package com.javaskid.compass.impl;

public class NativeBridge {

    public native static void  initNative();
    public native static void retransformClasses(String className);
    public static void init() {
        String name;
        String os = System.getProperty("os.name");
        if (os.contains("win")) name="compass.dll";
        else if (os.contains("mac")) name = "compass.dylib";
        else name = "compass.so";
        System.loadLibrary(name);
    }
}
