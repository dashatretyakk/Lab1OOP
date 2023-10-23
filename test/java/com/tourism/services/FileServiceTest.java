package com.tourism.services;

import com.tourism.enums.Food;
import com.tourism.enums.Transport;
import com.tourism.models.*;
import com.tourism.models.tours.ExcursionTour;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileServiceTest {

    private final FileService fileService = new FileService("test_tours.dat");

    @AfterEach
    public void tearDown() throws Exception {
        // Видаляємо тестовий файл після кожного тесту
        String TEST_FILE_PATH = "test_tours.dat";
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
    }

    @Test
    public void testSaveAndLoadTours() {
        // Створення тестового туру
        Tour testTour = new ExcursionTour("Тест", Transport.BUS, Food.BREAKFAST, 5, "Тестовий опис", 3, 1000);
        List<Tour> tours = List.of(testTour);

        // Збереження турів у файл
        fileService.saveTours(tours);

        // Завантаження турів з файлу
        List<Tour> loadedTours = fileService.loadTours();

        // Порівняння завантажених турів з тестовими
        assertEquals(tours.size(), loadedTours.size(), "Кількість турів повинна бути однаковою");

        Tour loadedTour = loadedTours.get(0);

        assertEquals(testTour.getTitle(), loadedTour.getTitle(), "Назва повинна співпадати");
        assertEquals(testTour.getTripType(), loadedTour.getTripType(), "Тип подорожі повинен співпадати");
        assertEquals(testTour.getTransport(), loadedTour.getTransport(), "Транспорт повинен співпадати");
        assertEquals(testTour.getFood(), loadedTour.getFood(), "Тип харчування повинен співпадати");
        assertEquals(testTour.getDays(), loadedTour.getDays(), "Кількість днів повинна співпадати");
        assertEquals(testTour.getDescription(), loadedTour.getDescription(), "Опис повинен співпадати");
        assertEquals(testTour.getPrice(), loadedTour.getPrice(), 0.01, "Ціна повинна співпадати");
    }

    @Test
    public void testLoadToursFromNonExistingFile() {
        // Перевірка завантаження турів з неіснуючого файлу
        List<Tour> loadedTours = fileService.loadTours();
        assertTrue(loadedTours.isEmpty(), "Список повинен бути порожнім, якщо файл не існує");
    }
}
