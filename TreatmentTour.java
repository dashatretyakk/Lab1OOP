package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.models.Tour;
import com.tourism.enums.Transport;
import com.tourism.enums.TripType;

// Підклас TreatmentTour, який розширює клас Tour і представляє путівки для лікування
public class TreatmentTour extends Tour {
    private String treatmentType; // Тип лікування

    // Конструктор класу TreatmentTour
    public TreatmentTour(String title, Transport transport, Food food, int days, String description, String treatmentType, double price) {
        // Виклик конструктора базового класу Tour
        super(title, TripType.TREATMENT, transport, food, days, description, price);
        this.treatmentType = treatmentType;
    }

    // Гетер для отримання типу лікування
    public String getTreatmentType() {
        return treatmentType;
    }

    // Сетер для встановлення типу лікування
    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    // Перевизначений метод для отримання повної інформації про путівку для лікування
    @Override
    public String getFullTourInfo() {
        // Виклик методу getFullTourInfo() базового класу та додавання інформації про тип лікування
        return super.getFullTourInfo() +
                "Тип лікування: " + treatmentType + "\n";
    }
}
