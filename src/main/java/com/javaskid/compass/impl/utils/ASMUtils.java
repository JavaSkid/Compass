package com.javaskid.compass.impl.utils;

import org.objectweb.asm.tree.*;


public class ASMUtils {

    public static AbstractInsnNode findField(MethodNode node, String... target) {
        for (AbstractInsnNode insn : node.instructions) {
            if (insn instanceof LdcInsnNode) {

                LdcInsnNode fieldInsnNode = (LdcInsnNode) insn;
                if (fieldInsnNode.cst instanceof String) if (ListUtils.listContainsKeyWord((String) fieldInsnNode.cst, target)) return fieldInsnNode;

            } else if (insn instanceof InvokeDynamicInsnNode) {
                InvokeDynamicInsnNode methodInsnNode = (InvokeDynamicInsnNode) insn;

                for (Object o : methodInsnNode.bsmArgs) {
                    if (o instanceof String && ListUtils.listContainsKeyWord((String) o, target)) return methodInsnNode;
                }
            }
        }
        return null;
    }

    public static MethodNode findMethod(ClassNode node, String... targets) {
        for (MethodNode m : node.methods) {
            if (findField(m, targets) != null) return m;
        }
        return null;
    }

    public static FieldNode findClassField(ClassNode node, String... targets) {
        for (FieldNode fieldNode : node.fields) {
            if (ListUtils.listContainsKeyWord(fieldNode.desc, targets)) return fieldNode;
        }
        return null;
    }

    public static AnnotationNode findClassAnnotation(ClassNode node, String... targets) {
        if (node.visibleAnnotations != null) {
            for (AnnotationNode annotationNode : node.visibleAnnotations) {
                if (annotationNode.values == null) continue;
                for (Object o : annotationNode.values) {
                    if (o instanceof String) {
                        if (ListUtils.listContainsKeyWord((String) o, targets)) return annotationNode;
                    }
                }
            }
        }
        if (node.invisibleAnnotations != null) {
            for (AnnotationNode annotationNode : node.invisibleAnnotations) {
                if (annotationNode.values == null) continue;
                for (Object o : annotationNode.values) {
                    if (o instanceof String) {
                        if (ListUtils.listContainsKeyWord((String) o, targets)) return annotationNode;
                    }
                }
            }
        }

        return null;
    }

    public static boolean findClass(ClassNode node, String... target) {
        return findMethod(node, target) != null ||
                findClassField(node, target) != null ||
                findClassAnnotation(node, target) != null ||
                ListUtils.listContainsKeyWord(node.name, target);
    }


}
