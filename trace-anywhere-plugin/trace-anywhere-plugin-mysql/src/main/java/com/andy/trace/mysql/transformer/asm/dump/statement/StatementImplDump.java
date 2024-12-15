package com.andy.trace.mysql.transformer.asm.dump.statement;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.RecordComponentVisitor;

public class StatementImplDump implements Opcodes {

    public static byte[] dump() throws Exception {

        ClassWriter classWriter = new ClassWriter(0);
        FieldVisitor fieldVisitor;
        RecordComponentVisitor recordComponentVisitor;
        MethodVisitor methodVisitor;
        AnnotationVisitor annotationVisitor0;

        classWriter.visit(V11, ACC_PUBLIC | ACC_SUPER, "com/mysql/cj/jdbc/StatementImpl", null, "java/lang/Object", new String[]{"com/mysql/cj/jdbc/JdbcStatement"});

        classWriter.visitSource("StatementImpl.java", null);

        classWriter.visitNestMember("com/mysql/cj/jdbc/StatementImpl$1");

        classWriter.visitInnerClass("com/mysql/cj/protocol/Resultset$Type", "com/mysql/cj/protocol/Resultset", "Type", ACC_PUBLIC | ACC_FINAL | ACC_STATIC | ACC_ENUM);

        classWriter.visitInnerClass("com/mysql/cj/jdbc/StatementImpl$1", null, null, 0);

        classWriter.visitInnerClass("com/mysql/cj/Query$CancelStatus", "com/mysql/cj/Query", "CancelStatus", ACC_PUBLIC | ACC_FINAL | ACC_STATIC | ACC_ENUM);

        classWriter.visitInnerClass("java/lang/invoke/MethodHandles$Lookup", "java/lang/invoke/MethodHandles", "Lookup", ACC_PUBLIC | ACC_FINAL | ACC_STATIC);

        StatementImplDumpPart1.dump(classWriter);
        StatementImplDumpPart2.dump(classWriter);
        StatementImplDumpPart3.dump(classWriter);
        StatementImplDumpPart4.dump(classWriter);
        StatementImplDumpPart5.dump(classWriter);
        StatementImplDumpPart6.dump(classWriter);
        StatementImplDumpPart7.dump(classWriter);
        StatementImplDumpPart8.dump(classWriter);
        StatementImplDumpPart9.dump(classWriter);
        StatementImplDumpPart10.dump(classWriter);

        classWriter.visitEnd();

        return classWriter.toByteArray();
    }




}
