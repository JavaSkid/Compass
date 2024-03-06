package com.javaskid.compass.impl.hooks.impl;

import com.javaskid.compass.impl.Compass;
import com.javaskid.compass.impl.hooks.CompassHook;
import net.weavemc.loader.api.Hook;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.ClassNode;

public class CompassMainHook extends Hook {

    public CompassMainHook() {
        super();
    }

    @Override
    public void transform(@NotNull ClassNode node, @NotNull AssemblerConfig cfg) {
        for (CompassHook hook : Compass.getInstance().getHookManager().getHooks()) {
            if (hook.matches(node)) {
                hook.targetClass = node.name;
                System.out.println(hook.getClass().getName() + " is patching : " + node.name);
                hook.patch(node);
            }
        }
    }
}
