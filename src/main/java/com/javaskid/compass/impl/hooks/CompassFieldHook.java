package com.javaskid.compass.impl.hooks;

import com.javaskid.compass.impl.utils.ASMUtils;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Objects;

public abstract class CompassFieldHook extends CompassMethodHook {

    private final String[] targets;
    public CompassFieldHook(String... targets) {
        super(targets);
        this.targets = targets;
    }

    public abstract void patch(AbstractInsnNode node);
    @Override
    public void patch(MethodNode methodNode) {
        AbstractInsnNode node = ASMUtils.findField(methodNode, getTargets());
        if (node != null) patch(node);
    }
}
