package com.javaskid.compass.impl.lunar.bogus;

import com.google.gson.JsonObject;

public abstract class FakeMod {

    private String name;
    private boolean enabledByDefault;
    public void setName(String str) {
        this.name = name;
    }

    public FakeMod(boolean enabledByDefault) {
        this.enabledByDefault = enabledByDefault;
    }

    public abstract void render();
    protected abstract FakeFeatureDetails getFeatureDetails();
}
