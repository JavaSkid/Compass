package com.javaskid.compass.impl.utils;

import com.javaskid.compass.impl.Compass;

import java.lang.reflect.Field;
import java.util.Vector;

public class ClassLoaderUtils {
/*    public static void patchClassLoader() {

        new Sandbox(() -> {
            Field f = Compass.class.getClassLoader().getClass().getDeclaredField("classes");
            f.setAccessible(true);
        });
    }*/

/*    public static Vector<Class<?>> getLoadedClasses() {
        new Sandbox(() -> Compass.class.getClassLoader().getClass().getDeclaredField("classes").get(Compass.class.getClassLoader()));
        return null;
    }*/
}
