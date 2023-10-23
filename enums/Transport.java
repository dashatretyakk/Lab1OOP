package com.tourism.enums;

public enum Transport {
    BUS("Автобус"),
    TRAIN("Поїзд"),
    PLANE("Літак"),
    SHIP("Корабель");

    private final String description;

    Transport(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
