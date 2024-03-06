package com.javaskid.compass.impl.hooks.impl.hooks;

import com.javaskid.compass.impl.hooks.CompassHook;
import net.weavemc.loader.api.Hook;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.ClassNode;

public class PacketStaffModStateHook extends CompassHook {

    public PacketStaffModStateHook() {
        super("com/lunarclient/bukkitapi/nethandler/client/LCPacketStaffModState");
    }

    @Override
    public void patch(ClassNode node) {

    }
}
