package com.javaskid.compass.impl.hooks;

import com.javaskid.compass.impl.Compass;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class CompassClassTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        ClassReader cr = new ClassReader(classfileBuffer);
        ClassNode node = new ClassNode();
        cr.accept(node, ClassReader.EXPAND_FRAMES);


        for (CompassHook hook : Compass.getInstance().getHookManager().getHooks()) {
            if (hook.targetClass != null) {
                hook.patch(node);
            }
        }

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        node.accept(cw);
        return cw.toByteArray();
    }
}
