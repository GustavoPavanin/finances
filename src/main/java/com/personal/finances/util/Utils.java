package com.personal.finances.util;

import java.util.List;

public class Utils {
    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNullOrEmpty(List<Object> list) {
        return isNull(list) || list.isEmpty();
    }
}
