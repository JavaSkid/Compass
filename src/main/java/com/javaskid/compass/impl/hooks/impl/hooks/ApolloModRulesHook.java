package com.javaskid.compass.impl.hooks.impl.hooks;

import com.javaskid.compass.impl.hooks.CompassHook;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

public class ApolloModRulesHook extends CompassHook {
    public ApolloModRulesHook() {
        super("mod_setting", "Mod Setting");
    }

    @Override
    public void patch(ClassNode node) {
        for (MethodNode methodNode : node.methods) {
            if (methodNode.desc.equals("()V")) {
                methodNode.instructions.clear();
                methodNode.instructions.add(new InsnNode(Opcodes.RETURN));
                methodNode.tryCatchBlocks.clear();
            }
        }
    }
}
