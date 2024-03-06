package com.javaskid.compass.impl.utils;

public class Sandbox {

    public static String run(FakeThrowable runnable){
        try {
            runnable.run();
        } catch (Exception e) {
            return e.getMessage();
        }
        return null;
    }


    @FunctionalInterface
    public interface FakeThrowable {
        void run() throws Exception;
    }
}
