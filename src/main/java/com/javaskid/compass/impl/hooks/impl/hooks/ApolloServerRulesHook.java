package com.javaskid.compass.impl.hooks.impl.hooks;

import com.javaskid.compass.impl.hooks.CompassHook;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class ApolloServerRulesHook extends CompassHook {

    public ApolloServerRulesHook() {
        super("server_rule", "Server Rule");
    }

    @Override
    public void patch(ClassNode node) {
        for (MethodNode methodNode : node.methods) {
            if (methodNode.desc.equals("()V")) {
                methodNode.instructions.clear();
            }
        }
    }
}
