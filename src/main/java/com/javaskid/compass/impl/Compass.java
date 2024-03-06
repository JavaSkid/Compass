package com.javaskid.compass.impl;

import com.javaskid.compass.impl.hooks.HookManager;
import net.weavemc.loader.api.ModInitializer;

public class Compass implements ModInitializer {

    private HookManager hookManager;
    private static Compass instance;
    @Override
    public void preInit() {
        instance = this;

        this.hookManager = new HookManager();
    }

    public static Compass getInstance() {
        return instance;
    }

    public HookManager getHookManager() {
        return hookManager;
    }
}
