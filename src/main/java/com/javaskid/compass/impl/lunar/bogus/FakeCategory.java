package com.javaskid.compass.impl.lunar.bogus;


public enum FakeCategory {
    ALL("all"),
    NEW("new"),
    HUD("hud"),
    SERVER("server"),
    MECHANIC("mechanic"),
    NONE("none");

    String name;

    FakeCategory(String all) {

    }


    public String toString() {
        return this.name;
    }

    public String getLanguagePath() {
        return "gui.components";
    }

    public String getName() {
        return this.name;
    }
}