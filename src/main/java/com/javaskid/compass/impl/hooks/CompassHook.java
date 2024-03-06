package com.javaskid.compass.impl.hooks;

import com.javaskid.compass.impl.utils.ASMUtils;
import org.objectweb.asm.tree.*;

public abstract class CompassHook {
    private final String[] targets;
    public String targetClass;
    public CompassHook(String... targets) {
        this.targets = targets;
    }

    public abstract void patch(ClassNode node);

    public boolean matches(ClassNode node) {
        return ASMUtils.findClass(node, this.targets);
    }

    public String[] getTargets() {
        return targets;
    }
}
