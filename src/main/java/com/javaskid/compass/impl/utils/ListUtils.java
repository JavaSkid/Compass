package com.javaskid.compass.impl.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    public static boolean listContainsKeyWord(String substring, List<String> list) {
        boolean returnBool = true;
        for (String s : list)
            if (!substring.equals(s)) {
                returnBool = false;
                break;
            }
        return returnBool;
    }

    public static boolean listContainsKeyWord(String substring, String... list) {
        if (list == null) return false;
        for (String s : list) {
            if (substring.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
