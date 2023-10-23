package com.tourism.enums;

public enum TripType {
    RECREATION("Відпочинок"),
    EXCURSION("Екскурсія"),
    TREATMENT("Лікування"),
    SHOPPING("Шопінг"),
    CRUISE("Круїз");

    private final String description;

    TripType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
