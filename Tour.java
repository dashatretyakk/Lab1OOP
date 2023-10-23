package com.tourism.models;

import com.tourism.enums.Food;
import com.tourism.enums.Transport;
import com.tourism.enums.TripType;

import java.io.Serializable;

// Абстрактний клас, який представляє базовий клас для всіх типів путівок
public abstract class Tour implements Serializable {
    protected String title;          // Назва путівки
    protected TripType tripType;     // Тип подорожі
    protected Transport transport;   // Тип транспорту
    protected Food food;             // Тип харчування
    protected int days;              // Тривалість (кількість днів)
    protected String description;    // Опис путівки
    protected double price;          // Ціна

    // Конструктор класу Tour
    public Tour(String title, TripType tripType, Transport transport, Food food, int days, String description, double price) {
        this.title = title;
        this.tripType = tripType;
        this.transport = transport;
        this.food = food;
        this.days = days;
        this.description = description;
        this.price = price;
    }

    // Гетери для отримання значень полів
    public String getTitle() {
        return title;
    }

    public TripType getTripType() {
        return tripType;
    }

    public Transport getTransport() {
        return transport;
    }

    public Food getFood() {
        return food;
    }

    public int getDays() {
        return days;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    // Сетери для встановлення значень полів
    public void setTitle(String title) {
        this.title = title;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Метод для отримання короткої інформації про путівку
    public String getShortTourInfo() {
        return String.format("%s. %s. Тривалість: %s %s. Ціна: %.2f грошенят", title, description, days, generateDayString(days), price);
    }

    // Метод для отримання повної інформації про путівку
    public String getFullTourInfo() {
        return "Тип Подорожі: " + tripType + "\n" +
                "Назва: " + title + "\n" +
                "Транспорт: " + transport + "\n" +
                "Харчування: " + food + "\n" +
                "Тривалість: " + days + " " + generateDayString(days) + "\n" +
                "Опис: " + description + "\n" +
                "Ціна: " + price + "\n";
    }

    // Перевизначений метод toString() для відображення об'єкту у вигляді рядка
    @Override
    public String toString() {
        return "Tour{" +
                "title='" + title + '\'' +
                ", tripType=" + tripType +
                ", transport=" + transport +
                ", food=" + food +
                ", days=" + days +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }


    // Метод для отримання коректної форми "день"
    public static String generateDayString(int number) {
        if (number == 0 || (number >= 5 && number <= 20)) {
            return "днів";
        } else {
            int lastDigit = number % 10;
            if (lastDigit == 1) {
                return "день";
            } else if (lastDigit >= 2 && lastDigit <= 4) {
                return "дні";
            } else {
                return "днів";
            }
        }
    }
}