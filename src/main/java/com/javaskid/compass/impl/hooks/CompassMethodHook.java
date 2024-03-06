package com.javaskid.compass.impl.hooks;

import com.javaskid.compass.impl.utils.ASMUtils;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public abstract class CompassMethodHook extends CompassHook {

    private String[] targets;
    public CompassMethodHook(String... targets) {
        super(targets);
        this.targets = targets;
    }

    public abstract void patch(MethodNode methodNode);

    @Override
    public void patch(ClassNode node) {
        MethodNode methodNode = ASMUtils.findMethod(node, getTargets());
        if (methodNode != null) patch(methodNode);
    }
}
