package com.javaskid.compass.impl.hooks.impl.hooks;

import com.javaskid.compass.impl.hooks.CompassMethodHook;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

public class PacketModSettingsHook extends CompassMethodHook {

    public PacketModSettingsHook() {
        super("[Mod Setting]");
    }


    @Override
    public void patch(MethodNode methodNode) {
        methodNode.instructions.clear();
        methodNode.instructions.add(new InsnNode(Opcodes.RETURN));
    }

}
