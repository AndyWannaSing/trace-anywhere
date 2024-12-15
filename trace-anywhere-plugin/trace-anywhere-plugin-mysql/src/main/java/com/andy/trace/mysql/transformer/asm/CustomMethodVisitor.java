package com.andy.trace.mysql.transformer.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class CustomMethodVisitor extends MethodVisitor {
    private int access;
    private String name;
    private String descriptor;
    private String signature;
    private String[] exceptions;
    private  boolean isStatic;

    public CustomMethodVisitor(MethodVisitor mv,
                               int access,
                               String name,
                               String descriptor,
                               String signature,
                               String[] exceptions,
                               boolean isStatic){
        super(Opcodes.ASM9, mv);
        this.access = access;
        this.name = name;
        this.descriptor = descriptor;
        this.signature = signature;
        this.exceptions = exceptions;
        this.isStatic = isStatic;
    }

    @Override
    public void visitCode() {
        super.visitCode();
        // 在方法开始处插入代码
        if (!isStatic) {
            mv.visitVarInsn(Opcodes.ALOAD, 0); // 加载 "this"
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(Ljava/lang/Object;)V", false);
        }
        // 打印实例对象（对于非静态方法）
        if (!isStatic) {
            mv.visitVarInsn(Opcodes.ALOAD, 0); // 加载 "this"
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(Ljava/lang/Object;)V", false);
        }

        // 打印参数
        Type[] argumentTypes = Type.getArgumentTypes(descriptor);
        int localIndex = isStatic ? 0 : 1; // 静态方法从0开始，实例方法从1开始
        for (Type argType : argumentTypes) {
            mv.visitVarInsn(argType.getOpcode(Opcodes.ILOAD), localIndex);
            printValue(argType);
            localIndex += argType.getSize();
        }
    }

    @Override
    public void visitInsn(int opcode) {
        if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW) {
            if (opcode != Opcodes.RETURN) {
                // 复制返回值到栈顶
                if (opcode == Opcodes.IRETURN || opcode == Opcodes.FRETURN) {
                    mv.visitInsn(Opcodes.DUP);
                } else if (opcode == Opcodes.LRETURN || opcode == Opcodes.DRETURN) {
                    mv.visitInsn(Opcodes.DUP2);
                } else if (opcode == Opcodes.ARETURN) {
                    mv.visitInsn(Opcodes.DUP);
                }
                // 打印返回值
                Type returnType = Type.getReturnType(descriptor);
                printValue(returnType);
            }
        }
        super.visitInsn(opcode);
    }

    private void printValue(Type type) {
        String descriptor = type.getDescriptor();
        if (type.getSort() == Type.OBJECT || type.getSort() == Type.ARRAY) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(Ljava/lang/Object;)V", false);
        } else if (type.getSort() == Type.INT) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(I)V", false);
        } else if (type.getSort() == Type.FLOAT) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(F)V", false);
        } else if (type.getSort() == Type.LONG) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(J)V", false);
        } else if (type.getSort() == Type.DOUBLE) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(D)V", false);
        } else if (type.getSort() == Type.BOOLEAN) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(Z)V", false);
        } else if (type.getSort() == Type.CHAR) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(C)V", false);
        } else if (type.getSort() == Type.BYTE) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(B)V", false);
        } else if (type.getSort() == Type.SHORT) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "out", "(S)V", false);
        }
    }
}
