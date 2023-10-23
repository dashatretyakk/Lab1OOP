package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.models.Tour;
import com.tourism.enums.Transport;
import com.tourism.enums.TripType;

// Підклас ExcursionTour, який розширює клас Tour і представляє путівки для екскурсій
public class ExcursionTour extends Tour {
    private int numberOfSites;  // Кількість місць для відвідування

    // Конструктор класу ExcursionTour
    public ExcursionTour(String title, Transport transport, Food food, int days, String description, int numberOfSites, double price) {
        // Виклик конструктора базового класу Tour
        super(title, TripType.EXCURSION, transport, food, days, description, price);
        this.numberOfSites = numberOfSites;
    }

    // Гетер для отримання кількості місць для відвідування
    public int getNumberOfSites() {
        return numberOfSites;
    }

    // Сетер для встановлення кількості місць для відвідування
    public void setNumberOfSites(int numberOfSites) {
        this.numberOfSites = numberOfSites;
    }

    // Перевизначений метод для отримання повної інформації про путівку для екскурсій
    @Override
    public String getFullTourInfo() {
        // Виклик методу getFullTourInfo() базового класу та додавання інформації про кількість місць для відвідування
        return super.getFullTourInfo() +
                "Кількість місць для відвідування: " + numberOfSites + "\n";
    }
}
