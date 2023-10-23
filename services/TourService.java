package com.tourism.services;

import com.tourism.models.Tour;

import java.util.List;

// Сервіс для управління путівками
public class TourService {
    // Список доступних путівок
    private final List<Tour> tours;

    // Сервіс для роботи з файлами
    private final FileService fileService = new FileService();

    // Конструктор сервісу путівок
    public TourService() {
        // Завантаження путівок з файлу при створенні сервісу
        tours = fileService.loadTours();
    }

    // Метод для отримання всіх путівок
    public List<Tour> getAllTours() {
        return tours;
    }

    // Метод для додавання нової путівки
    public void addTour(Tour tour) {
        // Додавання путівки до списку та збереження змін у файлі
        tours.add(tour);
        fileService.saveTours(tours);
    }

    // Метод для видалення путівки
    public void deleteTour(Tour tour) {
        // Видалення путівки зі списку та збереження змін у файлі
        tours.remove(tour);
        fileService.saveTours(tours);
    }
}
