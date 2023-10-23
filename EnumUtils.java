package com.tourism.utils;

import java.util.Arrays;

public class EnumUtils {
    //Метод знаходить константу перерахування за її описом.
    public static <T extends Enum<T>> T findByDescription(Class<T> enumClass, String description) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(enumItem -> enumItem.toString().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }
}