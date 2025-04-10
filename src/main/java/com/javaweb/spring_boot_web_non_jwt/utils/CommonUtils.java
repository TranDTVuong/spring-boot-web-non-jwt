package com.javaweb.spring_boot_web_non_jwt.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonUtils {
    public static String emptyOrDefault(String str) {
        return str == null ? "" : str;
    }
}
