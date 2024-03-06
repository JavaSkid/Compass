package com.javaskid.compass.impl.hooks.impl.hooks;

import com.javaskid.compass.impl.hooks.CompassMethodHook;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class DevModeHook extends CompassMethodHook {
    public DevModeHook() {
        super("Couldn't find lunarBuildData.txt??");
    }

    @Override
    public void patch(MethodNode methodNode) {
        for (AbstractInsnNode insnNode : methodNode.instructions) {
            if (insnNode instanceof MethodInsnNode) {
                MethodInsnNode insn = (MethodInsnNode) insnNode;
                if (insn.name.equals("parseBoolean")) {
                    methodNode.instructions.set(insn.getPrevious(), new InsnNode(Opcodes.ICONST_1));
                    methodNode.instructions.remove(insnNode);
                }
            }
        }
    }

}
