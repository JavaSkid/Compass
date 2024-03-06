package com.javaskid.compass.impl.hooks.impl.hooks;

import com.javaskid.compass.impl.hooks.CompassMethodHook;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class StoreButtonHook extends CompassMethodHook {

    public StoreButtonHook() {
        super("https://store.lunarclient.com", "store");
    }

    @Override
    public void patch(MethodNode methodNode) {

        for (AbstractInsnNode node : methodNode.instructions) {
            if (node instanceof LdcInsnNode) {
                if (((LdcInsnNode) node).cst.equals("store")) {
                    AbstractInsnNode current = node;
                    while (current.getOpcode() != Opcodes.INVOKEINTERFACE) current = current.getNext();
                    System.out.println(current.getOpcode());
                    methodNode.instructions.remove(current);
                    break;
                }
            }
        }
    }
}
