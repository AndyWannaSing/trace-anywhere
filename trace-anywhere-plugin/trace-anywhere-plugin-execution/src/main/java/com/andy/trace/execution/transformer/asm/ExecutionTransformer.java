package com.andy.trace.execution.transformer.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExecutionTransformer  implements ClassFileTransformer {

    private static Set<String> classNames = new HashSet<>();

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if(classNames.contains(className)){
            return classfileBuffer;
        }
        if(className.equals("org/springframework/beans/factory/support/DefaultListableBeanFactory")){
            Arrays.stream(Thread.currentThread().getStackTrace()).forEach(e -> System.out.println("   " +e));
        }
        if(className.equals("org/springframework/boot/SpringApplication$Startup")
                || className.equals("org/springframework/boot/context/properties/source/IterableConfigurationPropertySource")
                || className.equals("org/springframework/beans/factory/support/DefaultListableBeanFactory")
                || className.equals("org/springframework/beans/AbstractNestablePropertyAccessor")
                || className.equals("org/springframework/boot/web/embedded/tomcat/TomcatEmbeddedWebappClassLoader")
                || className.equals("org/springframework/http/HttpHeaders")
                || className.equals("org/springframework/boot/logging/logback/ColorConverter")
                || className.startsWith("org/springframework/core/env/PropertiesPropertySource")
                || className.startsWith("org/springframework/boot/context/properties/source/ConfigurationPropertySource")
                || className.startsWith("org/springframework/boot/context/properties/source/ConfigurationPropertyName")
                || className.equals("org/springframework/util/ConcurrentReferenceHashMap")
                || className.equals("org/springframework/core/env/PropertySource")
                || className.equals("org/springframework/boot/origin/PropertySourceOrigin")
        ) {
            return classfileBuffer;
        }

        classNames.add(className);
        if((!className.startsWith("com.andy.trace")
                && !className.startsWith("org/springframework"))
                || className.equals("com/andy/trace/agent/ExecutionReporter")
                || className.endsWith("Exception")
                || className.endsWith("ResolvableType")
                || className.startsWith("com/intellij")){
            return classfileBuffer;
        }


        return enhanceClass(className, classfileBuffer);

        /*ClassReader classReader = new ClassReader(classfileBuffer);
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        ClassVisitor classVisitor = new ClassVisitorAdapter(Opcodes.ASM9, classWriter);
        classReader.accept(classVisitor, 0);
        return classWriter.toByteArray();*/
    }

    private static byte[] enhanceClass(String className, byte[] originalClassBytes) {
        // 使用字节码增强库进行字节码修改，将方法调用前后插入上报信息的逻辑
        // 这里使用 ASM 库作为示例，你也可以选择其他字节码增强库
        // 这里只对一个方法进行监控，你可以根据需要修改
        ClassReader classReader = new ClassReader(originalClassBytes);
        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
        classReader.accept(new ClassVisitor(Opcodes.ASM9, classWriter) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature,
                                             String[] exceptions) {
                MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MethodVisitor(Opcodes.ASM9, methodVisitor) {
                    @Override
                    public void visitCode() {
                        // 方法调用前插入上报信息的逻辑
                        visitLdcInsn(className);
                        visitLdcInsn(name);
                        visitMethodInsn(Opcodes.INVOKESTATIC, "com/andy/trace/agent/ExecutionReporter", "start",
                                "(Ljava/lang/String;Ljava/lang/String;)V", false);
                        super.visitCode();
                    }

                    @Override
                    public void visitInsn(int opcode) {
                        if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN || opcode == Opcodes.ATHROW) {
                            // 方法调用结束后插入上报信息的逻辑
                            visitLdcInsn(className);
                            visitLdcInsn(name);
                            visitMethodInsn(Opcodes.INVOKESTATIC, "com/andy/trace/agent/ExecutionReporter", "end",
                                    "(Ljava/lang/String;Ljava/lang/String;)V", false);
                        }
                        super.visitInsn(opcode);
                    }
                };
            }
        }, ClassReader.EXPAND_FRAMES);
        return classWriter.toByteArray();
    }

    /*if(name.equals("<init>")
            || name.equals("toString")
            || name.equals("get")
            || name.equals("setValue")
            || name.equals("isOverride")
            || name.equals("isEmpty")
            || name.equals("doWithAggregate")
            || name.equals("notNull")
            || name.equals("forAnnotationType")
            || name.equals("matches")
            || name.equals("doWithAnnotations")
            || name.equals("convertName")
            || name.equals("getMapping")
            || name.equals("isUsingSources")
            || name.equals("getUnderlyingSource")
            || name.equals("convertLegacyNameElement")
            || name.equals("getNext")
            || name.equals("getState")
            || name.equals("getAttribute")
            || name.equals("getMergedBeanDefinition")
            || name.equals("from")
            || name.equals("getBaseTypeMethods")
            || name.equals("finish")
            || name.equals("getOrder")
            || name.equals("getResolvableType")
            || name.equals("hasOption")
            || name.equals("createReference")
            || name.equals("nullSafeHashCode")
            || name.equals("scan")
            || name.equals("processMethodHierarchy")
            || name.equals("getPropertySource")
            || name.equals("nullSafeEquals")
            || name.equals("checkPropertyName")
            || name.equals("resolvePropertyName")
            || name.equals("getProperty")
            || name.equals("map")
            || name.equals("getElement")
            || name.equals("getSize")
            || name.equals("getType")
            || name.equals("next")
            || name.equals("getKey")
            || name.equals("getValue")
            || name.equals("fetchNext")
            || name.equals("hasNext")
            || name.equals("isIndexed")
            || name.equals("isAbstract")
            || name.equals("getGenerics")
            || name.equals("isFactoryBean")
            || name.equals("getDecoratedDefinition")
            || name.equals("getBeanPostProcessorCache")
            || name.equals("isAssignableFrom")
            || name.equals("getMapped")
            || name.equals("getName")
            || name.equals("getReference")
            || name.equals("getHash")
            || name.equals("isIgnored")
            || name.equals("getSource")
            || name.equals("hashCode")
            || name.equals("now")
            || name.equals("getSegmentForHash")
            || name.equals("pollForPurge")
            || name.equals("getMappings")
            || name.equals("updateMappings")
            || name.equals("isFrom")
            || name.equals("toStringArray")
            || name.equals("isAlpha")
            || name.equals("charAt")
            || name.equals("isAlphaNumeric")
            || name.equals("hasExpired")
            || name.equals("unwrap")
            || name.equals("getRawType")
            || name.equals("isAssignable")
            || name.equals("canonicalName")
            || name.equals("getSingleton")
            || name.equals("getObjectForBeanInstance")
            || name.equals("supportsEvent")
            || name.equals("restructureIfNecessary")
            || name.equals("getFactoryBeanName")
            || name.equals("containsSingleton")
            || name.equals("transformedBeanName")
            || name.equals("isFactoryDereference")
            || name.equals("isLazyInit")
            || name.equals("isAlias")
            || name.equals("isTypeMatch")
            || name.equals("isSynthetic")
            || name.equals("getTargetType")
            || name.equals("determineTargetType")
            || name.equals("getParentBeanFactory")
            || name.equals("hasBeanClass")
            || name.equals("setBeanName")
            || name.equals("getBeanMethods")
            || name.equals("hasBeanCreationStarted")
            || name.equals("hasText")
            || name.equals("fromMap")
            || name.equals("isPresent")
            || name.equals("getInstance")
            || name.equals("missing")
            || name.equals("size")
            || name.equals("getAnnotationType")
            || name.equals("isMappingForType")
            || name.equals("spliterator")
            || name.equals("getIndex")
            || name.equals("findInChain")
            || name.equals("iterator")
            || name.equals("isIn")
            || name.equals("getTypeForMapOptions")
            || name.equals("adaptValueForMapOptions")
            || name.equals("isFiltered")
            || name.equals("resolvePrimitiveIfNecessary")
            || name.equals("getAnnotationAttributes")
            || name.equals("getDistance")
            || name.equals("getAttributes")
            || name.equals("extractFromMap")
            || name.equals("getAliasMapping")
            || name.equals("getMetaTypes")
            || name.equals("hasPlainJavaAnnotationsOnly")
            || name.equals("isWithoutHierarchy")
            || name.equals("createMergedAnnotationIfPossible")
            || name.equals("test")
            || name.equals("adapt")
            || name.equals("registerBeanDefinitionForImportedConfigurationClass")
            || name.equals("hasInstantiationAwareBeanPostProcessors")
            || name.equals("getMergedLocalBeanDefinition")
            || name.equals("isSingletonCurrentlyInCreation")
            || name.equals("buildEnabled")){
        return methodVisitor;
    }*/

    static class ClassVisitorAdapter extends ClassVisitor {

        private String className;

        public ClassVisitorAdapter(int api, ClassVisitor classVisitor) {
            super(api, classVisitor);
        }

        /**
         * Visits the header of the class.
         *
         * @param version    the class version. The minor version is stored in the 16 most significant bits,
         *                   and the major version in the 16 least significant bits.
         * @param access     the class's access flags (see {@link Opcodes}). This parameter also indicates if
         *                   the class is deprecated {@link Opcodes#ACC_DEPRECATED} or a record {@link
         *                   Opcodes#ACC_RECORD}.
         * @param name       the internal name of the class (see {@link Type#getInternalName()}).
         * @param signature  the signature of this class. May be {@literal null} if the class is not a
         *                   generic one, and does not extend or implement generic classes or interfaces.
         * @param superName  the internal of name of the super class (see {@link Type#getInternalName()}).
         *                   For interfaces, the super class is {@link Object}. May be {@literal null}, but only for the
         *                   {@link Object} class.
         * @param interfaces the internal names of the class's interfaces (see {@link
         *                   Type#getInternalName()}). May be {@literal null}.
         */
        @Override
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            Execution.report("Entering class: " + name);
            this.className = name;
            super.visit(version, access, name, signature, superName, interfaces);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            if(name.equals("<init>")){
                return cv.visitMethod(access, name, descriptor, signature, exceptions);
            }
            MethodVisitor methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions);
            return new MethodInfoVisitor(api, methodVisitor, name, descriptor);
        }

        /**
         * Visits the end of the class. This method, which is the last one to be called, is used to inform
         * the visitor that all the fields and methods of the class have been visited.
         */
        @Override
        public void visitEnd() {
            Execution.report("Exit class:" + this.className);
            super.visitEnd();
        }
    }

    static class MethodInfoVisitor extends MethodVisitor {
        private final String methodName;
        private final String methodDesc;
        private int level;

        public MethodInfoVisitor(int api, MethodVisitor methodVisitor, String methodName, String methodDesc) {
            super(api, methodVisitor);
            this.methodName = methodName;
            this.methodDesc = methodDesc;
            this.level = 0;
        }

        @Override
        public void visitCode() {
            super.visitCode();
            // 记录方法进入
            Execution.report("Entering method: " + methodName + " at level " + level);
        }

        @Override
        public void visitInsn(int opcode) {
            // 当执行到方法调用时，增加层级
            if (opcode == Opcodes.INVOKEVIRTUAL || opcode == Opcodes.INVOKESTATIC ||
                    opcode == Opcodes.INVOKEINTERFACE || opcode == Opcodes.INVOKESPECIAL) {
                level++;
            }
            super.visitInsn(opcode);
        }

        @Override
        public void visitMaxs(int maxStack, int maxLocals) {
            super.visitMaxs(maxStack, maxLocals);
            // 在方法退出时输出
            Execution.report("Exiting method: " + methodName + " at level " + level);
            // 减少层级
            level--;
        }
    }


    static class Execution {
        public static void report(String message) {
            // 实现上报逻辑，这里只是简单打印，您可以扩展为网络请求或其他方式
            System.out.println(message);
        }

        public static void start(String className, String methodName) {
            // 监控方法开始
            System.out.println("Method started: Class: " + className + ", Method: " + methodName);
        }

        public static void end(String className, String methodName) {
            // 监控方法结束
            System.out.println("Method ended: Class: " + className + ", Method: " + methodName);
        }
    }

}
