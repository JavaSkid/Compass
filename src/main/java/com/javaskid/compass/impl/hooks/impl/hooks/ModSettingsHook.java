package com.javaskid.compass.impl.hooks.impl.hooks;

import com.javaskid.compass.impl.hooks.CompassFieldHook;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;

public class ModSettingsHook extends CompassFieldHook {

    public ModSettingsHook() {
        super("modSettings");
    }
    @Override
    public void patch(AbstractInsnNode node) {
        ((LdcInsnNode)node).cst = "Fucked by compass !";
    }
}
