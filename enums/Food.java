package com.tourism.enums;

public enum Food {
    NONE("Без харчування"),
    BREAKFAST("Сніданок"),
    HALF_BOARD("Полупансіон"),
    FULL_BOARD("Повний пансіон");

    private final String description;

    Food(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
