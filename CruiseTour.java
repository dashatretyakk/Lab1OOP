package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.models.Tour;
import com.tourism.enums.Transport;
import com.tourism.enums.TripType;

// Підклас CruiseTour, який розширює клас Tour і представляє круїзні путівки
public class CruiseTour extends Tour {
    private String shipName;  // Назва корабля

    // Конструктор класу CruiseTour
    public CruiseTour(String title, Food food, int days, String description, String shipName, double price) {
        // Виклик конструктора базового класу Tour
        super(title, TripType.CRUISE, Transport.SHIP, food, days, description, price);
        this.shipName = shipName;
    }

    // Гетер для отримання назви корабля
    public String getShipName() {
        return shipName;
    }

    // Сетер для встановлення назви корабля
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    // Перевизначений метод для отримання повної інформації про круїзну путівку
    @Override
    public String getFullTourInfo() {
        // Виклик методу getFullTourInfo() базового класу та додавання інформації про назву корабля
        return super.getFullTourInfo() + "Назва корабля: " + shipName + "\n" ;
    }
}
