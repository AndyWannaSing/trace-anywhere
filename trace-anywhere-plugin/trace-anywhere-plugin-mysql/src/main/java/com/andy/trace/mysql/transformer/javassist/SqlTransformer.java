package com.andy.trace.mysql.transformer.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.Set;

public class SqlTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if ("com/mysql/cj/jdbc/ClientPreparedStatement".equals(className)) {
            try {
                ClassPool cp = ClassPool.getDefault();
                cp.importPackage("java.util");
                cp.importPackage("com.andy.trace");
                CtClass cc = cp.get("com.mysql.cj.jdbc.ClientPreparedStatement");
                CtMethod method = cc.getDeclaredMethod("executeInternal");

                method.insertBefore("System.out.println(\"Executing with parameters: \" + Arrays.toString($args));" +
                        "System.out.println(this.toString());"+
                        "com.andy.trace.TraceManager.beforeExecSQL(this.toString());"
                );
                method.insertAfter("System.out.println(\"Executed successfully, result: \" + $_);" +
                        "com.andy.trace.TraceManager.afterExecSQLReturn(this.toString());", true);
                method.addCatch("{ System.out.println(\"Exception occurred: \" + $e);" +
                        " com.andy.trace.TraceManager.afterExecSQLException(this.toString());" +
                        "throw $e; }", ClassPool.getDefault().get("java.lang.Exception"));

                return cc.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if ("com/mysql/cj/jdbc/StatementImpl".equals(className)) {
            try {
                ClassPool cp = ClassPool.getDefault();
                cp.importPackage("java.util");
                cp.importPackage("com.andy.trace");
                CtClass cc = cp.get("com.mysql.cj.jdbc.StatementImpl");

                // 添加请求参数和返回结果的打印
                addLoggingMethod(cp, cc, "executeInternal");
                addLoggingMethod(cp, cc, "executeUpdateInternal");
                addLoggingMethod(cp, cc, "executeQuery");

                return cc.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return classfileBuffer;
    }

    private static void addLoggingMethod(ClassPool cp, CtClass cc, String methodName) throws Exception {
        CtMethod method = cc.getDeclaredMethod(methodName);

        // 在方法执行前打印请求参数
        method.insertBefore("System.out.println(\"" + methodName + " called with parameters: \" + java.util.Arrays.toString($args));");

        // 在方法成功执行后打印返回结果
        method.insertAfter("System.out.println(\"" + methodName + " executed successfully, result: \" + $_);", true);

        // 在方法执行异常时打印异常信息
        method.addCatch("{ System.out.println(\"" + methodName + " exception occurred: \" + $e); throw $e; }", ClassPool.getDefault().get("java.lang.Exception"));
    }


}
