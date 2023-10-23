package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.models.Tour;
import com.tourism.enums.Transport;
import com.tourism.enums.TripType;

// Підклас RecreationTour, який розширює клас Tour і представляє путівки для відпочинку
public class RecreationTour extends Tour {
    private String accommodationType;  // Тип помешкання

    // Конструктор класу RecreationTour
    public RecreationTour(String title, Transport transport, Food food, int days, String description, String accommodationType, double price) {
        // Виклик конструктора базового класу Tour
        super(title, TripType.RECREATION, transport, food, days, description, price);
        this.accommodationType = accommodationType;
    }

    // Гетер для отримання типу помешкання
    public String getAccommodationType() {
        return accommodationType;
    }

    // Сетер для встановлення типу помешкання
    public void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType;
    }

    // Перевизначений метод для отримання повної інформації про путівку для відпочинку
    @Override
    public String getFullTourInfo() {
        // Виклик методу getFullTourInfo() базового класу та додавання інформації про тип помешкання
        return super.getFullTourInfo() +
                "Тип помешкання: " + accommodationType + "\n";
    }
}
