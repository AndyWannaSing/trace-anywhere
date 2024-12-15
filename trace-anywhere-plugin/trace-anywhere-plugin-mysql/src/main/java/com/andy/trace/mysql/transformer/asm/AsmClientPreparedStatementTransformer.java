package com.andy.trace.mysql.transformer.asm;

import com.andy.trace.mysql.transformer.asm.dump.preparedstatement.ClientPreparedStatementDump;
import com.andy.trace.mysql.transformer.asm.dump.statement.StatementImplDump;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Set;

public class AsmClientPreparedStatementTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {

        if (!className.equals("com/mysql/cj/jdbc/ClientPreparedStatement")) {
            return classfileBuffer;
        }

        System.out.println("AsmClientPreparedStatementTransformer：" + className);
        try {
            return enhanceTargetClass(loader, className, classBeingRedefined, protectionDomain, classfileBuffer);
        } catch (Exception e) {
            System.err.println("Failed to dump ClientPreparedStatement：" + e.getMessage());
            return classfileBuffer;
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
                return new CustomMethodVisitor(methodVisitor, access, name, descriptor, signature, exceptions, false);
            }

            private boolean targetMethod(String name) {
                Set<String> set = Set.of("executeInternal");
                return set.contains(name);
            }
        }, ClassReader.EXPAND_FRAMES);
        return classWriter.toByteArray();
    }
}
