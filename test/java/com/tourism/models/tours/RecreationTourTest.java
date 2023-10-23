package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.enums.Transport;
import com.tourism.enums.TripType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RecreationTourTest {
    private RecreationTour tour;

    @Before
    public void setUp() {
        // Підготовка тестових даних перед кожним тестом
        tour = new RecreationTour("Тестова путівка", Transport.PLANE, Food.HALF_BOARD, 7, "Тестовий опис", "Готель", 1000.0);
    }

    @Test
    public void testConstructor() {
        // Перевірка конструктора
        assertEquals("Тестова путівка", tour.getTitle());
        assertEquals(TripType.RECREATION, tour.getTripType());
        assertEquals(Transport.PLANE, tour.getTransport());
        assertEquals(Food.HALF_BOARD, tour.getFood());
        assertEquals(7, tour.getDays());
        assertEquals("Тестовий опис", tour.getDescription());
        assertEquals("Готель", tour.getAccommodationType());
        assertEquals(1000.0, tour.getPrice(), 0.01);
    }

    @Test
    public void testGettersAndSetters() {
        // Перевірка геттерів і сеттерів
        tour.setTitle("Нова назва");
        tour.setTripType(TripType.EXCURSION);
        tour.setTransport(Transport.TRAIN);
        tour.setFood(Food.BREAKFAST);
        tour.setDays(5);
        tour.setDescription("Новий опис");
        tour.setPrice(1500.0);
        tour.setAccommodationType("Хостел");

        assertEquals("Нова назва", tour.getTitle());
        assertEquals(TripType.EXCURSION, tour.getTripType());
        assertEquals(Transport.TRAIN, tour.getTransport());
        assertEquals(Food.BREAKFAST, tour.getFood());
        assertEquals(5, tour.getDays());
        assertEquals("Новий опис", tour.getDescription());
        assertEquals(1500.0, tour.getPrice(), 0.01);
        assertEquals("Хостел", tour.getAccommodationType());
    }

    @Test
    public void testGetShortTourInfo() {
        // Перевірка методу отримання короткої інформації про тур
        String shortInfo = tour.getShortTourInfo();
        assertEquals("Тестова путівка. Тестовий опис. Тривалість: 7 днів. Ціна: 1000.00 грошенят", shortInfo);
    }

    @Test
    public void testGetFullTourInfo() {
        // Перевірка методу отримання повної інформації про тур
        String fullInfo = tour.getFullTourInfo();
        String expectedInfo = "Тип Подорожі: Відпочинок\n" +
                "Назва: Тестова путівка\n" +
                "Транспорт: Літак\n" +
                "Харчування: Полупансіон\n" +
                "Тривалість: 7 днів\n" +
                "Опис: Тестовий опис\n" +
                "Ціна: 1000.0\n" +
                "Тип помешкання: Готель\n";
        assertEquals(expectedInfo, fullInfo);
    }
}
