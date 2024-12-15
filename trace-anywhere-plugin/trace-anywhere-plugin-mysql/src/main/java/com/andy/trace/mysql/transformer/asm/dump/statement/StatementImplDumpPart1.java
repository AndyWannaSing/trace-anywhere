package com.andy.trace.mysql.transformer.asm.dump.statement;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_VOLATILE;
import static org.objectweb.asm.Opcodes.ACONST_NULL;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.ATHROW;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.ICONST_M1;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.IFNULL;
import static org.objectweb.asm.Opcodes.IF_ICMPEQ;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.ISTORE;
import static org.objectweb.asm.Opcodes.MONITORENTER;
import static org.objectweb.asm.Opcodes.MONITOREXIT;
import static org.objectweb.asm.Opcodes.POP;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.SIPUSH;
import static org.objectweb.asm.TypeReference.NEW;

public class StatementImplDumpPart1 {
    public static void dump(ClassWriter classWriter) {
        FieldVisitor fieldVisitor;
        MethodVisitor methodVisitor;
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED | ACC_FINAL | ACC_STATIC, "PING_MARKER", "Ljava/lang/String;", null, "/* ping */");
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "USES_VARIABLES_FALSE", "B", null, new Integer(0));
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "USES_VARIABLES_TRUE", "B", null, new Integer(1));
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "USES_VARIABLES_UNKNOWN", "B", null, new Integer(-1));
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "commandBuilder", "Lcom/mysql/cj/protocol/a/NativeMessageBuilder;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "charEncoding", "Ljava/lang/String;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED | ACC_VOLATILE, "connection", "Lcom/mysql/cj/jdbc/JdbcConnection;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "doEscapeProcessing", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "isClosed", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "lastInsertId", "J", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "maxFieldSize", "I", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PUBLIC, "maxRows", "I", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "openResults", "Ljava/util/Set;", "Ljava/util/Set<Lcom/mysql/cj/jdbc/result/ResultSetInternalMethods;>;", null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "pedantic", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "profileSQL", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "results", "Lcom/mysql/cj/jdbc/result/ResultSetInternalMethods;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "generatedKeysResults", "Lcom/mysql/cj/jdbc/result/ResultSetInternalMethods;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "resultSetConcurrency", "I", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "updateCount", "J", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "useUsageAdvisor", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "warningChain", "Ljava/sql/SQLWarning;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "holdResultsOpenOverClose", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "batchedGeneratedKeys", "Ljava/util/ArrayList;", "Ljava/util/ArrayList<Lcom/mysql/cj/result/Row;>;", null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "retrieveGeneratedKeys", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "continueBatchOnError", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "pingTarget", "Lcom/mysql/cj/PingTarget;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "exceptionInterceptor", "Lcom/mysql/cj/exceptions/ExceptionInterceptor;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "lastQueryIsOnDupKeyUpdate", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PRIVATE, "isImplicitlyClosingResults", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "dontTrackOpenResources", "Lcom/mysql/cj/conf/RuntimeProperty;", "Lcom/mysql/cj/conf/RuntimeProperty<Ljava/lang/Boolean;>;", null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "dumpQueriesOnException", "Lcom/mysql/cj/conf/RuntimeProperty;", "Lcom/mysql/cj/conf/RuntimeProperty<Ljava/lang/Boolean;>;", null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "logSlowQueries", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "rewriteBatchedStatements", "Lcom/mysql/cj/conf/RuntimeProperty;", "Lcom/mysql/cj/conf/RuntimeProperty<Ljava/lang/Boolean;>;", null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "maxAllowedPacket", "Lcom/mysql/cj/conf/RuntimeProperty;", "Lcom/mysql/cj/conf/RuntimeProperty<Ljava/lang/Integer;>;", null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "dontCheckOnDuplicateKeyUpdateInSQL", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "resultSetFactory", "Lcom/mysql/cj/jdbc/result/ResultSetFactory;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "query", "Lcom/mysql/cj/Query;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PROTECTED, "session", "Lcom/mysql/cj/NativeSession;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PRIVATE, "originalResultSetType", "Lcom/mysql/cj/protocol/Resultset$Type;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PRIVATE, "originalFetchSize", "I", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PRIVATE, "isPoolable", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PRIVATE, "closeOnCompletion", "Z", null, null);
            fieldVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "(Lcom/mysql/cj/jdbc/JdbcConnection;Ljava/lang/String;)V", null, new String[]{"java/sql/SQLException"});
            methodVisitor.visitCode();
            Label label0 = new Label();
            Label label1 = new Label();
            Label label2 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label2, "com/mysql/cj/exceptions/CJException");
            Label label3 = new Label();
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(209, label3);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLineNumber(112, label4);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "commandBuilder", "Lcom/mysql/cj/protocol/a/NativeMessageBuilder;");
            Label label5 = new Label();
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(115, label5);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "charEncoding", "Ljava/lang/String;");
            Label label6 = new Label();
            methodVisitor.visitLabel(label6);
            methodVisitor.visitLineNumber(118, label6);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "connection", "Lcom/mysql/cj/jdbc/JdbcConnection;");
            Label label7 = new Label();
            methodVisitor.visitLabel(label7);
            methodVisitor.visitLineNumber(121, label7);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_1);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "doEscapeProcessing", "Z");
            Label label8 = new Label();
            methodVisitor.visitLabel(label8);
            methodVisitor.visitLineNumber(124, label8);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "isClosed", "Z");
            Label label9 = new Label();
            methodVisitor.visitLabel(label9);
            methodVisitor.visitLineNumber(127, label9);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitLdcInsn(new Long(-1L));
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "lastInsertId", "J");
            Label label10 = new Label();
            methodVisitor.visitLabel(label10);
            methodVisitor.visitLineNumber(130, label10);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "maxAllowedPacket", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKESTATIC, "com/mysql/cj/conf/PropertyDefinitions", "getPropertyDefinition", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/PropertyDefinition;", false);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/PropertyDefinition", "getDefaultValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "maxFieldSize", "I");
            Label label11 = new Label();
            methodVisitor.visitLabel(label11);
            methodVisitor.visitLineNumber(136, label11);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_M1);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "maxRows", "I");
            Label label12 = new Label();
            methodVisitor.visitLabel(label12);
            methodVisitor.visitLineNumber(139, label12);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitTypeInsn(NEW, "java/util/HashSet");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/util/HashSet", "<init>", "()V", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "openResults", "Ljava/util/Set;");
            Label label13 = new Label();
            methodVisitor.visitLabel(label13);
            methodVisitor.visitLineNumber(142, label13);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "pedantic", "Z");
            Label label14 = new Label();
            methodVisitor.visitLabel(label14);
            methodVisitor.visitLineNumber(145, label14);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "profileSQL", "Z");
            Label label15 = new Label();
            methodVisitor.visitLabel(label15);
            methodVisitor.visitLineNumber(148, label15);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "results", "Lcom/mysql/cj/jdbc/result/ResultSetInternalMethods;");
            Label label16 = new Label();
            methodVisitor.visitLabel(label16);
            methodVisitor.visitLineNumber(150, label16);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "generatedKeysResults", "Lcom/mysql/cj/jdbc/result/ResultSetInternalMethods;");
            Label label17 = new Label();
            methodVisitor.visitLabel(label17);
            methodVisitor.visitLineNumber(153, label17);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "resultSetConcurrency", "I");
            Label label18 = new Label();
            methodVisitor.visitLabel(label18);
            methodVisitor.visitLineNumber(156, label18);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitLdcInsn(new Long(-1L));
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "updateCount", "J");
            Label label19 = new Label();
            methodVisitor.visitLabel(label19);
            methodVisitor.visitLineNumber(159, label19);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "useUsageAdvisor", "Z");
            Label label20 = new Label();
            methodVisitor.visitLabel(label20);
            methodVisitor.visitLineNumber(162, label20);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "warningChain", "Ljava/sql/SQLWarning;");
            Label label21 = new Label();
            methodVisitor.visitLabel(label21);
            methodVisitor.visitLineNumber(168, label21);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "holdResultsOpenOverClose", "Z");
            Label label22 = new Label();
            methodVisitor.visitLabel(label22);
            methodVisitor.visitLineNumber(170, label22);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "batchedGeneratedKeys", "Ljava/util/ArrayList;");
            Label label23 = new Label();
            methodVisitor.visitLabel(label23);
            methodVisitor.visitLineNumber(172, label23);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "retrieveGeneratedKeys", "Z");
            Label label24 = new Label();
            methodVisitor.visitLabel(label24);
            methodVisitor.visitLineNumber(174, label24);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "continueBatchOnError", "Z");
            Label label25 = new Label();
            methodVisitor.visitLabel(label25);
            methodVisitor.visitLineNumber(176, label25);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "pingTarget", "Lcom/mysql/cj/PingTarget;");
            Label label26 = new Label();
            methodVisitor.visitLabel(label26);
            methodVisitor.visitLineNumber(181, label26);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "lastQueryIsOnDupKeyUpdate", "Z");
            Label label27 = new Label();
            methodVisitor.visitLabel(label27);
            methodVisitor.visitLineNumber(184, label27);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "isImplicitlyClosingResults", "Z");
            Label label28 = new Label();
            methodVisitor.visitLabel(label28);
            methodVisitor.visitLineNumber(188, label28);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "logSlowQueries", "Z");
            Label label29 = new Label();
            methodVisitor.visitLabel(label29);
            methodVisitor.visitLineNumber(196, label29);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "session", "Lcom/mysql/cj/NativeSession;");
            Label label30 = new Label();
            methodVisitor.visitLabel(label30);
            methodVisitor.visitLineNumber(598, label30);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/protocol/Resultset$Type", "FORWARD_ONLY", "Lcom/mysql/cj/protocol/Resultset$Type;");
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "originalResultSetType", "Lcom/mysql/cj/protocol/Resultset$Type;");
            Label label31 = new Label();
            methodVisitor.visitLabel(label31);
            methodVisitor.visitLineNumber(599, label31);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "originalFetchSize", "I");
            Label label32 = new Label();
            methodVisitor.visitLabel(label32);
            methodVisitor.visitLineNumber(2031, label32);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "isPoolable", "Z");
            Label label33 = new Label();
            methodVisitor.visitLabel(label33);
            methodVisitor.visitLineNumber(2089, label33);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "closeOnCompletion", "Z");
            Label label34 = new Label();
            methodVisitor.visitLabel(label34);
            methodVisitor.visitLineNumber(210, label34);
            methodVisitor.visitVarInsn(ALOAD, 1);
            Label label35 = new Label();
            methodVisitor.visitJumpInsn(IFNULL, label35);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcConnection", "isClosed", "()Z", true);
            Label label36 = new Label();
            methodVisitor.visitJumpInsn(IFEQ, label36);
            methodVisitor.visitLabel(label35);
            methodVisitor.visitLineNumber(211, label35);
            methodVisitor.visitFrame(Opcodes.F_FULL, 3, new Object[]{"com/mysql/cj/jdbc/StatementImpl", "com/mysql/cj/jdbc/JdbcConnection", "java/lang/String"}, 0, new Object[]{});
            methodVisitor.visitLdcInsn("Statement.0");
            methodVisitor.visitMethodInsn(INVOKESTATIC, "com/mysql/cj/Messages", "getString", "(Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitLdcInsn("08003");
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "com/mysql/cj/jdbc/exceptions/SQLError", "createSQLException", "(Ljava/lang/String;Ljava/lang/String;Lcom/mysql/cj/exceptions/ExceptionInterceptor;)Ljava/sql/SQLException;", false);
            methodVisitor.visitInsn(ATHROW);
            methodVisitor.visitLabel(label36);
            methodVisitor.visitLineNumber(214, label36);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "connection", "Lcom/mysql/cj/jdbc/JdbcConnection;");
            Label label37 = new Label();
            methodVisitor.visitLabel(label37);
            methodVisitor.visitLineNumber(215, label37);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcConnection", "getSession", "()Lcom/mysql/cj/Session;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "com/mysql/cj/NativeSession");
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "session", "Lcom/mysql/cj/NativeSession;");
            Label label38 = new Label();
            methodVisitor.visitLabel(label38);
            methodVisitor.visitLineNumber(216, label38);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcConnection", "getExceptionInterceptor", "()Lcom/mysql/cj/exceptions/ExceptionInterceptor;", true);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "exceptionInterceptor", "Lcom/mysql/cj/exceptions/ExceptionInterceptor;");
            Label label39 = new Label();
            methodVisitor.visitLabel(label39);
            methodVisitor.visitLineNumber(218, label39);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitTypeInsn(NEW, "com/mysql/cj/protocol/a/NativeMessageBuilder");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "session", "Lcom/mysql/cj/NativeSession;");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "getServerSession", "()Lcom/mysql/cj/protocol/ServerSession;", false);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/protocol/ServerSession", "supportsQueryAttributes", "()Z", true);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/mysql/cj/protocol/a/NativeMessageBuilder", "<init>", "(Z)V", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "commandBuilder", "Lcom/mysql/cj/protocol/a/NativeMessageBuilder;");
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(221, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/jdbc/StatementImpl", "initQuery", "()V", false);
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(224, label1);
            Label label40 = new Label();
            methodVisitor.visitJumpInsn(GOTO, label40);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(222, label2);
            methodVisitor.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"com/mysql/cj/exceptions/CJException"});
            methodVisitor.visitVarInsn(ASTORE, 3);
            Label label41 = new Label();
            methodVisitor.visitLabel(label41);
            methodVisitor.visitLineNumber(223, label41);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/jdbc/StatementImpl", "getExceptionInterceptor", "()Lcom/mysql/cj/exceptions/ExceptionInterceptor;", false);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "com/mysql/cj/jdbc/exceptions/SQLExceptionsMapping", "translateException", "(Ljava/lang/Throwable;Lcom/mysql/cj/exceptions/ExceptionInterceptor;)Ljava/sql/SQLException;", false);
            methodVisitor.visitInsn(ATHROW);
            methodVisitor.visitLabel(label40);
            methodVisitor.visitLineNumber(226, label40);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "query", "Lcom/mysql/cj/Query;");
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/Query", "setCurrentDatabase", "(Ljava/lang/String;)V", true);
            Label label42 = new Label();
            methodVisitor.visitLabel(label42);
            methodVisitor.visitLineNumber(228, label42);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcConnection", "getPropertySet", "()Lcom/mysql/cj/jdbc/JdbcPropertySet;", true);
            methodVisitor.visitVarInsn(ASTORE, 3);
            Label label43 = new Label();
            methodVisitor.visitLabel(label43);
            methodVisitor.visitLineNumber(230, label43);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "dontTrackOpenResources", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "dontTrackOpenResources", "Lcom/mysql/cj/conf/RuntimeProperty;");
            Label label44 = new Label();
            methodVisitor.visitLabel(label44);
            methodVisitor.visitLineNumber(231, label44);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "dumpQueriesOnException", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "dumpQueriesOnException", "Lcom/mysql/cj/conf/RuntimeProperty;");
            Label label45 = new Label();
            methodVisitor.visitLabel(label45);
            methodVisitor.visitLineNumber(232, label45);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "continueBatchOnError", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "continueBatchOnError", "Z");
            Label label46 = new Label();
            methodVisitor.visitLabel(label46);
            methodVisitor.visitLineNumber(233, label46);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "pedantic", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "pedantic", "Z");
            Label label47 = new Label();
            methodVisitor.visitLabel(label47);
            methodVisitor.visitLineNumber(234, label47);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "rewriteBatchedStatements", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "rewriteBatchedStatements", "Lcom/mysql/cj/conf/RuntimeProperty;");
            Label label48 = new Label();
            methodVisitor.visitLabel(label48);
            methodVisitor.visitLineNumber(235, label48);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "characterEncoding", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getStringProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/String");
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "charEncoding", "Ljava/lang/String;");
            Label label49 = new Label();
            methodVisitor.visitLabel(label49);
            methodVisitor.visitLineNumber(236, label49);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "profileSQL", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "profileSQL", "Z");
            Label label50 = new Label();
            methodVisitor.visitLabel(label50);
            methodVisitor.visitLineNumber(237, label50);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "useUsageAdvisor", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "useUsageAdvisor", "Z");
            Label label51 = new Label();
            methodVisitor.visitLabel(label51);
            methodVisitor.visitLineNumber(238, label51);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "logSlowQueries", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "logSlowQueries", "Z");
            Label label52 = new Label();
            methodVisitor.visitLabel(label52);
            methodVisitor.visitLineNumber(239, label52);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "maxAllowedPacket", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getIntegerProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "maxAllowedPacket", "Lcom/mysql/cj/conf/RuntimeProperty;");
            Label label53 = new Label();
            methodVisitor.visitLabel(label53);
            methodVisitor.visitLineNumber(240, label53);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "dontCheckOnDuplicateKeyUpdateInSQL", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "dontCheckOnDuplicateKeyUpdateInSQL", "Z");
            Label label54 = new Label();
            methodVisitor.visitLabel(label54);
            methodVisitor.visitLineNumber(241, label54);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "enableEscapeProcessing", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "doEscapeProcessing", "Z");
            Label label55 = new Label();
            methodVisitor.visitLabel(label55);
            methodVisitor.visitLineNumber(243, label55);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "maxAllowedPacket", "Lcom/mysql/cj/conf/RuntimeProperty;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "maxFieldSize", "I");
            Label label56 = new Label();
            methodVisitor.visitLabel(label56);
            methodVisitor.visitLineNumber(245, label56);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "dontTrackOpenResources", "Lcom/mysql/cj/conf/RuntimeProperty;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            Label label57 = new Label();
            methodVisitor.visitJumpInsn(IFNE, label57);
            Label label58 = new Label();
            methodVisitor.visitLabel(label58);
            methodVisitor.visitLineNumber(246, label58);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcConnection", "registerStatement", "(Lcom/mysql/cj/jdbc/JdbcStatement;)V", true);
            methodVisitor.visitLabel(label57);
            methodVisitor.visitLineNumber(249, label57);
            methodVisitor.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"com/mysql/cj/jdbc/JdbcPropertySet"}, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "defaultFetchSize", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getIntegerProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
            methodVisitor.visitVarInsn(ISTORE, 4);
            Label label59 = new Label();
            methodVisitor.visitLabel(label59);
            methodVisitor.visitLineNumber(250, label59);
            methodVisitor.visitVarInsn(ILOAD, 4);
            Label label60 = new Label();
            methodVisitor.visitJumpInsn(IFEQ, label60);
            Label label61 = new Label();
            methodVisitor.visitLabel(label61);
            methodVisitor.visitLineNumber(251, label61);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ILOAD, 4);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/jdbc/StatementImpl", "setFetchSize", "(I)V", false);
            methodVisitor.visitLabel(label60);
            methodVisitor.visitLineNumber(254, label60);
            methodVisitor.visitFrame(Opcodes.F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "maxRows", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getIntegerProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
            methodVisitor.visitVarInsn(ISTORE, 5);
            Label label62 = new Label();
            methodVisitor.visitLabel(label62);
            methodVisitor.visitLineNumber(256, label62);
            methodVisitor.visitVarInsn(ILOAD, 5);
            methodVisitor.visitInsn(ICONST_M1);
            Label label63 = new Label();
            methodVisitor.visitJumpInsn(IF_ICMPEQ, label63);
            Label label64 = new Label();
            methodVisitor.visitLabel(label64);
            methodVisitor.visitLineNumber(257, label64);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ILOAD, 5);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/jdbc/StatementImpl", "setMaxRows", "(I)V", false);
            methodVisitor.visitLabel(label63);
            methodVisitor.visitLineNumber(260, label63);
            methodVisitor.visitFrame(Opcodes.F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/conf/PropertyKey", "holdResultsOpenOverStatementClose", "Lcom/mysql/cj/conf/PropertyKey;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcPropertySet", "getBooleanProperty", "(Lcom/mysql/cj/conf/PropertyKey;)Lcom/mysql/cj/conf/RuntimeProperty;", true);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/conf/RuntimeProperty", "getValue", "()Ljava/lang/Object;", true);
            methodVisitor.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "holdResultsOpenOverClose", "Z");
            Label label65 = new Label();
            methodVisitor.visitLabel(label65);
            methodVisitor.visitLineNumber(262, label65);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitTypeInsn(NEW, "com/mysql/cj/jdbc/result/ResultSetFactory");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "connection", "Lcom/mysql/cj/jdbc/JdbcConnection;");
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/mysql/cj/jdbc/result/ResultSetFactory", "<init>", "(Lcom/mysql/cj/jdbc/JdbcConnection;Lcom/mysql/cj/jdbc/StatementImpl;)V", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "resultSetFactory", "Lcom/mysql/cj/jdbc/result/ResultSetFactory;");
            Label label66 = new Label();
            methodVisitor.visitLabel(label66);
            methodVisitor.visitLineNumber(263, label66);
            methodVisitor.visitInsn(RETURN);
            Label label67 = new Label();
            methodVisitor.visitLabel(label67);
            methodVisitor.visitLocalVariable("e", "Lcom/mysql/cj/exceptions/CJException;", null, label41, label40, 3);
            methodVisitor.visitLocalVariable("this", "Lcom/mysql/cj/jdbc/StatementImpl;", null, label3, label67, 0);
            methodVisitor.visitLocalVariable("c", "Lcom/mysql/cj/jdbc/JdbcConnection;", null, label3, label67, 1);
            methodVisitor.visitLocalVariable("db", "Ljava/lang/String;", null, label3, label67, 2);
            methodVisitor.visitLocalVariable("pset", "Lcom/mysql/cj/jdbc/JdbcPropertySet;", null, label43, label67, 3);
            methodVisitor.visitLocalVariable("defaultFetchSize", "I", null, label59, label67, 4);
            methodVisitor.visitLocalVariable("maxRowsConn", "I", null, label62, label67, 5);
            methodVisitor.visitMaxs(5, 6);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PROTECTED, "initQuery", "()V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(266, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitTypeInsn(NEW, "com/mysql/cj/SimpleQuery");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "session", "Lcom/mysql/cj/NativeSession;");
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/mysql/cj/SimpleQuery", "<init>", "(Lcom/mysql/cj/NativeSession;)V", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "com/mysql/cj/jdbc/StatementImpl", "query", "Lcom/mysql/cj/Query;");
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(267, label1);
            methodVisitor.visitInsn(RETURN);
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLocalVariable("this", "Lcom/mysql/cj/jdbc/StatementImpl;", null, label0, label2, 0);
            methodVisitor.visitMaxs(4, 1);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "addBatch", "(Ljava/lang/String;)V", null, new String[]{"java/sql/SQLException"});
            methodVisitor.visitCode();
            Label label0 = new Label();
            Label label1 = new Label();
            Label label2 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label2, null);
            Label label3 = new Label();
            methodVisitor.visitTryCatchBlock(label2, label3, label2, null);
            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLineNumber(271, label4);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/jdbc/StatementImpl", "checkClosed", "()Lcom/mysql/cj/jdbc/JdbcConnection;", false);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/jdbc/JdbcConnection", "getConnectionMutex", "()Ljava/lang/Object;", true);
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitVarInsn(ASTORE, 2);
            methodVisitor.visitInsn(MONITORENTER);
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(272, label0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            Label label5 = new Label();
            methodVisitor.visitJumpInsn(IFNULL, label5);
            Label label6 = new Label();
            methodVisitor.visitLabel(label6);
            methodVisitor.visitLineNumber(273, label6);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "query", "Lcom/mysql/cj/Query;");
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/Query", "addBatch", "(Ljava/lang/Object;)V", true);
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(275, label5);
            methodVisitor.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"java/lang/Object"}, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitInsn(MONITOREXIT);
            methodVisitor.visitLabel(label1);
            Label label7 = new Label();
            methodVisitor.visitJumpInsn(GOTO, label7);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/Throwable"});
            methodVisitor.visitVarInsn(ASTORE, 3);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitInsn(MONITOREXIT);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitInsn(ATHROW);
            methodVisitor.visitLabel(label7);
            methodVisitor.visitLineNumber(276, label7);
            methodVisitor.visitFrame(Opcodes.F_CHOP, 1, null, 0, null);
            methodVisitor.visitInsn(RETURN);
            Label label8 = new Label();
            methodVisitor.visitLabel(label8);
            methodVisitor.visitLocalVariable("this", "Lcom/mysql/cj/jdbc/StatementImpl;", null, label4, label8, 0);
            methodVisitor.visitLocalVariable("sql", "Ljava/lang/String;", null, label4, label8, 1);
            methodVisitor.visitMaxs(2, 4);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "addBatch", "(Ljava/lang/Object;)V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(280, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "query", "Lcom/mysql/cj/Query;");
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/Query", "addBatch", "(Ljava/lang/Object;)V", true);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(281, label1);
            methodVisitor.visitInsn(RETURN);
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLocalVariable("this", "Lcom/mysql/cj/jdbc/StatementImpl;", null, label0, label2, 0);
            methodVisitor.visitLocalVariable("batch", "Ljava/lang/Object;", null, label0, label2, 1);
            methodVisitor.visitMaxs(2, 2);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "getBatchedArgs", "()Ljava/util/List;", "()Ljava/util/List<Ljava/lang/Object;>;", null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(285, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "query", "Lcom/mysql/cj/Query;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/Query", "getBatchedArgs", "()Ljava/util/List;", true);
            methodVisitor.visitInsn(ARETURN);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLocalVariable("this", "Lcom/mysql/cj/jdbc/StatementImpl;", null, label0, label1, 0);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "cancel", "()V", null, new String[]{"java/sql/SQLException"});
            methodVisitor.visitCode();
            Label label0 = new Label();
            Label label1 = new Label();
            Label label2 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/io/IOException");
            Label label3 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label3, null);
            Label label4 = new Label();
            methodVisitor.visitTryCatchBlock(label2, label4, label3, null);
            Label label5 = new Label();
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(290, label5);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "query", "Lcom/mysql/cj/Query;");
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/Query", "getStatementExecuting", "()Ljava/util/concurrent/atomic/AtomicBoolean;", true);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/util/concurrent/atomic/AtomicBoolean", "get", "()Z", false);
            Label label6 = new Label();
            methodVisitor.visitJumpInsn(IFNE, label6);
            Label label7 = new Label();
            methodVisitor.visitLabel(label7);
            methodVisitor.visitLineNumber(291, label7);
            methodVisitor.visitInsn(RETURN);
            methodVisitor.visitLabel(label6);
            methodVisitor.visitLineNumber(294, label6);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "isClosed", "Z");
            Label label8 = new Label();
            methodVisitor.visitJumpInsn(IFNE, label8);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "connection", "Lcom/mysql/cj/jdbc/JdbcConnection;");
            methodVisitor.visitJumpInsn(IFNULL, label8);
            Label label9 = new Label();
            methodVisitor.visitLabel(label9);
            methodVisitor.visitLineNumber(295, label9);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitVarInsn(ASTORE, 1);
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(298, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "session", "Lcom/mysql/cj/NativeSession;");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "getHostInfo", "()Lcom/mysql/cj/conf/HostInfo;", false);
            methodVisitor.visitVarInsn(ASTORE, 2);
            Label label10 = new Label();
            methodVisitor.visitLabel(label10);
            methodVisitor.visitLineNumber(299, label10);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/conf/HostInfo", "getDatabase", "()Ljava/lang/String;", false);
            methodVisitor.visitVarInsn(ASTORE, 3);
            Label label11 = new Label();
            methodVisitor.visitLabel(label11);
            methodVisitor.visitLineNumber(300, label11);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/conf/HostInfo", "getUser", "()Ljava/lang/String;", false);
            methodVisitor.visitVarInsn(ASTORE, 4);
            Label label12 = new Label();
            methodVisitor.visitLabel(label12);
            methodVisitor.visitLineNumber(301, label12);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/conf/HostInfo", "getPassword", "()Ljava/lang/String;", false);
            methodVisitor.visitVarInsn(ASTORE, 5);
            Label label13 = new Label();
            methodVisitor.visitLabel(label13);
            methodVisitor.visitLineNumber(302, label13);
            methodVisitor.visitTypeInsn(NEW, "com/mysql/cj/NativeSession");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "session", "Lcom/mysql/cj/NativeSession;");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "getHostInfo", "()Lcom/mysql/cj/conf/HostInfo;", false);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "session", "Lcom/mysql/cj/NativeSession;");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "getPropertySet", "()Lcom/mysql/cj/conf/PropertySet;", false);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/mysql/cj/NativeSession", "<init>", "(Lcom/mysql/cj/conf/HostInfo;Lcom/mysql/cj/conf/PropertySet;)V", false);
            methodVisitor.visitVarInsn(ASTORE, 1);
            Label label14 = new Label();
            methodVisitor.visitLabel(label14);
            methodVisitor.visitLineNumber(303, label14);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitVarInsn(ALOAD, 4);
            methodVisitor.visitVarInsn(ALOAD, 5);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitIntInsn(SIPUSH, 30000);
            methodVisitor.visitTypeInsn(NEW, "com/mysql/cj/jdbc/StatementImpl$1");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/mysql/cj/jdbc/StatementImpl$1", "<init>", "(Lcom/mysql/cj/jdbc/StatementImpl;)V", false);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "connect", "(Lcom/mysql/cj/conf/HostInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/mysql/cj/TransactionEventHandler;)V", false);
            Label label15 = new Label();
            methodVisitor.visitLabel(label15);
            methodVisitor.visitLineNumber(314, label15);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "getProtocol", "()Lcom/mysql/cj/protocol/a/NativeProtocol;", false);
            methodVisitor.visitTypeInsn(NEW, "com/mysql/cj/protocol/a/NativeMessageBuilder");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "getServerSession", "()Lcom/mysql/cj/protocol/ServerSession;", false);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/mysql/cj/protocol/ServerSession", "supportsQueryAttributes", "()Z", true);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/mysql/cj/protocol/a/NativeMessageBuilder", "<init>", "(Z)V", false);
            methodVisitor.visitVarInsn(ALOAD, 1);
            Label label16 = new Label();
            methodVisitor.visitLabel(label16);
            methodVisitor.visitLineNumber(315, label16);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "getSharedSendPacket", "()Lcom/mysql/cj/protocol/a/NativePacketPayload;", false);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "session", "Lcom/mysql/cj/NativeSession;");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "getThreadId", "()J", false);
            methodVisitor.visitInvokeDynamicInsn("makeConcatWithConstants", "(J)Ljava/lang/String;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), new Object[]{"KILL QUERY \u0001"});
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/protocol/a/NativeMessageBuilder", "buildComQuery", "(Lcom/mysql/cj/protocol/a/NativePacketPayload;Ljava/lang/String;)Lcom/mysql/cj/protocol/a/NativePacketPayload;", false);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitInsn(ICONST_0);
            Label label17 = new Label();
            methodVisitor.visitLabel(label17);
            methodVisitor.visitLineNumber(314, label17);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/protocol/a/NativeProtocol", "sendCommand", "(Lcom/mysql/cj/protocol/Message;ZI)Lcom/mysql/cj/protocol/a/NativePacketPayload;", false);
            methodVisitor.visitInsn(POP);
            Label label18 = new Label();
            methodVisitor.visitLabel(label18);
            methodVisitor.visitLineNumber(316, label18);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/mysql/cj/Query$CancelStatus", "CANCELED_BY_USER", "Lcom/mysql/cj/Query$CancelStatus;");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/jdbc/StatementImpl", "setCancelStatus", "(Lcom/mysql/cj/Query$CancelStatus;)V", false);
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(320, label1);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitJumpInsn(IFNULL, label8);
            Label label19 = new Label();
            methodVisitor.visitLabel(label19);
            methodVisitor.visitLineNumber(321, label19);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "forceClose", "()V", false);
            methodVisitor.visitJumpInsn(GOTO, label8);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(317, label2);
            methodVisitor.visitFrame(Opcodes.F_FULL, 2, new Object[]{"com/mysql/cj/jdbc/StatementImpl", "com/mysql/cj/NativeSession"}, 1, new Object[]{"java/io/IOException"});
            methodVisitor.visitVarInsn(ASTORE, 2);
            Label label20 = new Label();
            methodVisitor.visitLabel(label20);
            methodVisitor.visitLineNumber(318, label20);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "com/mysql/cj/jdbc/StatementImpl", "exceptionInterceptor", "Lcom/mysql/cj/exceptions/ExceptionInterceptor;");
            methodVisitor.visitMethodInsn(INVOKESTATIC, "com/mysql/cj/jdbc/exceptions/SQLExceptionsMapping", "translateException", "(Ljava/lang/Throwable;Lcom/mysql/cj/exceptions/ExceptionInterceptor;)Ljava/sql/SQLException;", false);
            methodVisitor.visitInsn(ATHROW);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(320, label3);
            methodVisitor.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/Throwable"});
            methodVisitor.visitVarInsn(ASTORE, 6);
            methodVisitor.visitLabel(label4);
            methodVisitor.visitVarInsn(ALOAD, 1);
            Label label21 = new Label();
            methodVisitor.visitJumpInsn(IFNULL, label21);
            Label label22 = new Label();
            methodVisitor.visitLabel(label22);
            methodVisitor.visitLineNumber(321, label22);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/mysql/cj/NativeSession", "forceClose", "()V", false);
            methodVisitor.visitLabel(label21);
            methodVisitor.visitLineNumber(323, label21);
            methodVisitor.visitFrame(Opcodes.F_FULL, 7, new Object[]{"com/mysql/cj/jdbc/StatementImpl", "com/mysql/cj/NativeSession", Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, "java/lang/Throwable"}, 0, new Object[]{});
            methodVisitor.visitVarInsn(ALOAD, 6);
            methodVisitor.visitInsn(ATHROW);
            methodVisitor.visitLabel(label8);
            methodVisitor.visitLineNumber(326, label8);
            methodVisitor.visitFrame(Opcodes.F_FULL, 1, new Object[]{"com/mysql/cj/jdbc/StatementImpl"}, 0, new Object[]{});
            methodVisitor.visitInsn(RETURN);
            Label label23 = new Label();
            methodVisitor.visitLabel(label23);
            methodVisitor.visitLocalVariable("hostInfo", "Lcom/mysql/cj/conf/HostInfo;", null, label10, label1, 2);
            methodVisitor.visitLocalVariable("database", "Ljava/lang/String;", null, label11, label1, 3);
            methodVisitor.visitLocalVariable("user", "Ljava/lang/String;", null, label12, label1, 4);
            methodVisitor.visitLocalVariable("password", "Ljava/lang/String;", null, label13, label1, 5);
            methodVisitor.visitLocalVariable("e", "Ljava/io/IOException;", null, label20, label3, 2);
            methodVisitor.visitLocalVariable("newSession", "Lcom/mysql/cj/NativeSession;", null, label0, label8, 1);
            methodVisitor.visitLocalVariable("this", "Lcom/mysql/cj/jdbc/StatementImpl;", null, label5, label23, 0);
            methodVisitor.visitMaxs(9, 7);
            methodVisitor.visitEnd();
        }
    }
}
