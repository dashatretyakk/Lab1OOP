package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.models.Tour;
import com.tourism.enums.Transport;
import com.tourism.enums.TripType;

// Підклас ShoppingTour, який розширює клас Tour і представляє путівки для шопінгу
public class ShoppingTour extends Tour {
    private String shoppingCenter; // Торговий центр

    // Конструктор класу ShoppingTour
    public ShoppingTour(String title, Transport transport, Food food, int days, String description, String shoppingCenter, double price) {
        // Виклик конструктора базового класу Tour
        super(title, TripType.SHOPPING, transport, food, days, description, price);
        this.shoppingCenter = shoppingCenter;
    }

    // Гетер для отримання назви торгового центру
    public String getShoppingCenter() {
        return shoppingCenter;
    }

    // Сетер для встановлення назви торгового центру
    public void setShoppingCenter(String shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    // Перевизначений метод для отримання повної інформації про путівку для шопінгу
    @Override
    public String getFullTourInfo() {
        // Виклик методу getFullTourInfo() базового класу та додавання інформації про торговий центр
        return super.getFullTourInfo() +
                "Торгівельний центр: " + shoppingCenter + "\n";
    }
}
