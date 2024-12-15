package com.andy.trace.mysql.transformer.asm.dump.preparedstatement;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.RecordComponentVisitor;

public class ClientPreparedStatementDump implements Opcodes {

    public static byte[] dump() throws Exception {

        ClassWriter classWriter = new ClassWriter(0);
        FieldVisitor fieldVisitor;
        RecordComponentVisitor recordComponentVisitor;
        MethodVisitor methodVisitor;
        AnnotationVisitor annotationVisitor0;

        classWriter.visit(V11, ACC_PUBLIC | ACC_SUPER, "com/mysql/cj/jdbc/ClientPreparedStatement", null, "com/mysql/cj/jdbc/StatementImpl", new String[]{"com/mysql/cj/jdbc/JdbcPreparedStatement"});

        classWriter.visitSource("ClientPreparedStatement.java", null);

        classWriter.visitInnerClass("java/lang/invoke/MethodHandles$Lookup", "java/lang/invoke/MethodHandles", "Lookup", ACC_PUBLIC | ACC_FINAL | ACC_STATIC);

        ClientPreparedStatementDumpPart1.dump(classWriter);
        ClientPreparedStatementDumpPart2.dump(classWriter);
        ClientPreparedStatementDumpPart3.dump(classWriter);
        ClientPreparedStatementDumpPart4.dump(classWriter);
        ClientPreparedStatementDumpPart5.dump(classWriter);
        ClientPreparedStatementDumpPart6.dump(classWriter);
        ClientPreparedStatementDumpPart7.dump(classWriter);
        ClientPreparedStatementDumpPart8.dump(classWriter);
        classWriter.visitEnd();

        return classWriter.toByteArray();
    }




}
