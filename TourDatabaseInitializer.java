package com.tourism.utils;

import com.tourism.enums.Food;
import com.tourism.enums.Transport;
import com.tourism.models.tours.*;

import com.tourism.models.Tour;
import com.tourism.services.FileService;

import java.util.ArrayList;
import java.util.List;

// Клас для ініціалізації бази даних путівок
public class TourDatabaseInitializer {

    public static void main(String[] args) {
        List<Tour> tours = createTours(); // Створення списку путівок
        saveTours(tours); // Збереження путівок у файл
        displayTours(tours); // Відображення інформації про путівки
    }

    // Метод для створення путівок
    private static List<Tour> createTours() {
        List<Tour> tours = new ArrayList<>();

        // Додавання різних типів путівок до списку
        tours.add(new RecreationTour("Літо в Греції", Transport.PLANE, Food.HALF_BOARD, 7, "Відпочинок на березі моря", "Готель 4*", 12000));
        tours.add(new ExcursionTour("Подорож до Парижу", Transport.TRAIN, Food.BREAKFAST, 5, "Відвідання головних пам'яток міста", 10, 24300));
        tours.add(new ShoppingTour("Шопінг в Мілані", Transport.PLANE, Food.NONE, 3, "Вільний час для шопінгу", "Модний торговий центр", 9800));
        tours.add(new TreatmentTour("Лікування в Карпатах", Transport.BUS, Food.FULL_BOARD, 10, "Спа-процедури та гірський клімат", "Спа-санаторій", 50000));
        tours.add(new CruiseTour("Круїз по Середземному морю", Food.FULL_BOARD, 14, "Відпочинок на кораблі", "Лайнер 'Сереніті'", 130000));
        tours.add(new RecreationTour("Гірськолижний відпочинок в Альпах", Transport.PLANE, Food.HALF_BOARD, 7, "Зимові види спорту і гірські краєвиди", "Гірський курортний шале", 17200));
        tours.add(new ExcursionTour("Історичний тур по Риму", Transport.PLANE, Food.FULL_BOARD, 6, "Дослідження давніх римських пам'яток", 8, 9800));
        tours.add(new ShoppingTour("Розкішний шопінг в Дубаї", Transport.PLANE, Food.HALF_BOARD, 5, "Шопінг в розкішних бутиках", "Торговий центр 'Люкс'", 500));
        tours.add(new TreatmentTour("Відпочинок в Сан-Франциско", Transport.PLANE, Food.BREAKFAST, 4, "Спа-процедури та океанський бриз", "Спа-готель біля пляжу",48000));
        tours.add(new ExcursionTour("Екскурсія до Києва", Transport.TRAIN, Food.BREAKFAST, 2, "Огляд головних архітектурних пам'яток", 6, 3100));

        return tours;
    }

    // Метод для збереження путівок в файлі
    private static void saveTours(List<Tour> tours) {
        FileService fileService = new FileService();
        fileService.saveTours(tours); // Виклик методу збереження путівок у файл
    }

    // Метод для відображення інформації про путівки
    private static void displayTours(List<Tour> tours) {
        for (int i = 0; i < tours.size(); i++) {
            System.out.println("Тур №" + (i + 1) + ":");
            System.out.println(tours.get(i).getFullTourInfo()); // Виведення повної інформації про путівку
        }
    }
}
