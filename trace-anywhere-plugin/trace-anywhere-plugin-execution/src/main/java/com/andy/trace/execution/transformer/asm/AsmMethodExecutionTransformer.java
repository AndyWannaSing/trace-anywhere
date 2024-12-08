package com.andy.trace.execution.transformer.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;

public class AsmMethodExecutionTransformer implements ClassFileTransformer {

    private Set<String> targetPackageNames = new HashSet<>();

    public AsmMethodExecutionTransformer() {

    }

    public AsmMethodExecutionTransformer(Set<String> targetPackageNames) {
        this.targetPackageNames = targetPackageNames;
    }

    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {

        if (className.contains("com/andy/trace/TraceManager")) {
            return classfileBuffer;
        }

        boolean matchTargetClass = targetPackageNames.stream().anyMatch(className::startsWith);
        if (!matchTargetClass) {
            return classfileBuffer;
        }
        System.out.println("AsmMethodExecutionTransformer：" + className);
        try {
            return enhanceTargetClass(loader, className, classBeingRedefined, protectionDomain, classfileBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] enhanceTargetClass(ClassLoader loader,
                                      String className,
                                      Class<?> classBeingRedefined,
                                      ProtectionDomain protectionDomain,
                                      byte[] classfileBuffer) throws IllegalClassFormatException, IOException {
        ClassReader classReader = new ClassReader(classfileBuffer);
        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
        classReader.accept(new ClassVisitor(Opcodes.ASM9, classWriter) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature,
                                             String[] exceptions) {
                MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
                if (!targetMethod(name)) {
                    return methodVisitor;
                }
                return new MethodVisitor(Opcodes.ASM9, methodVisitor) {
                    @Override
                    public void visitCode() {
                        // 方法调用前插入上报信息的逻辑
                        visitLdcInsn(className);
                        visitLdcInsn(name);
                        visitMethodInsn(Opcodes.INVOKESTATIC,
                                "com/andy/trace/TraceManager",
                                "reportMethodVisited",
                                "(Ljava/lang/String;Ljava/lang/String;)V",
                                false);
                        super.visitCode();
                    }

                    @Override
                    public void visitInsn(int opcode) {
                        if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) {
                            // 方法调用结束后插入上报信息的逻辑
                            visitLdcInsn(className);
                            visitLdcInsn(name);
                            visitMethodInsn(Opcodes.INVOKESTATIC,
                                    "com/andy/trace/TraceManager",
                                    "reportMethodReturn",
                                    "(Ljava/lang/String;Ljava/lang/String;)V",
                                    false);
                        } else if (opcode == Opcodes.ATHROW) {
                            // 方法调用结束后插入上报信息的逻辑
                            visitLdcInsn(className);
                            visitLdcInsn(name);
                            visitMethodInsn(Opcodes.INVOKESTATIC,
                                    "com/andy/trace/TraceManager",
                                    "reportMethodThrow",
                                    "(Ljava/lang/String;Ljava/lang/String;)V",
                                    false);
                        }
                        super.visitInsn(opcode);
                    }
                };
            }

            private boolean targetMethod(String name) {
                if ("<init>".equals(name)) {
                    return false;
                }
                return true;
            }
        }, ClassReader.EXPAND_FRAMES);
        return classWriter.toByteArray();
    }
}
