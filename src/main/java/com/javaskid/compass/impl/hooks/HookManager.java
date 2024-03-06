package com.javaskid.compass.impl.hooks;

import com.javaskid.compass.impl.hooks.impl.hooks.*;

import java.util.ArrayList;
import java.util.List;

public class HookManager {
    private List<CompassHook> hooks;

    public HookManager() {
        hooks = new ArrayList<>();
        register(new DevModeHook());
        register(new PacketModSettingsHook());
        register(new PollingRateWarningHook());
        register(new ModSettingsHook());
        //register(new StoreButtonHook());
        //register(new UIHook());
        //register(new ApolloModRulesHook());
        //register(new PacketStaffModStateHook());
    }
    public void register(CompassHook hook) {
        this.hooks.add(hook);
    }

    public void unregister(CompassHook hook) {
        hooks.remove(hook);
    }

    public List<CompassHook> getHooks() {
        return hooks;
    }

    public CompassHook getHook(Class clazz) {
        return hooks.stream().filter(compassHook -> compassHook.getClass().equals(clazz)).findFirst().orElseThrow();
    }

}
