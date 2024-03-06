package com.javaskid.compass.impl.hooks.impl.hooks;

import com.javaskid.compass.impl.hooks.CompassMethodHook;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

public class PollingRateWarningHook extends CompassMethodHook {

    public PollingRateWarningHook() {
        super("Unable to start polling detection thread in headless client!", "polling_rate");
    }

    @Override
    public void patch(MethodNode methodNode) {
        methodNode.instructions.clear();
        methodNode.instructions.add(new InsnNode(Opcodes.RETURN));
    }
}
