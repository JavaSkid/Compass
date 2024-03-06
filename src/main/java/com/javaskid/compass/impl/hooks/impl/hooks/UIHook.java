package com.javaskid.compass.impl.hooks.impl.hooks;

import com.javaskid.compass.impl.hooks.CompassHook;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

public class UIHook extends CompassHook {
    public UIHook() {
        super("mods.json", "version");
    }

    @Override
    public void patch(ClassNode node) {
        node.methods.stream().filter(m -> (m.access == Opcodes.ACC_PROTECTED) && (m.desc.equals("()Ljava/util/Set;"))).findFirst().orElseThrow();
    }
}
