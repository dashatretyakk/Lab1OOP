package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.enums.TripType;
import com.tourism.enums.Transport;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TreatmentTourTest {
    private TreatmentTour tour;

    @Before
    public void setUp() {
        // Підготовка тестових даних перед кожним тестом
        tour = new TreatmentTour("Тестова путівка", Transport.TRAIN, Food.HALF_BOARD, 14, "Тестовий опис", "Спа-лікування", 1200.0);
    }

    @Test
    public void testConstructor() {
        // Перевірка конструктора
        assertEquals("Тестова путівка", tour.getTitle());
        assertEquals(TripType.TREATMENT, tour.getTripType());
        assertEquals(Transport.TRAIN, tour.getTransport());
        assertEquals(Food.HALF_BOARD, tour.getFood());
        assertEquals(14, tour.getDays());
        assertEquals("Тестовий опис", tour.getDescription());
        assertEquals(1200.0, tour.getPrice(), 0.01);
        assertEquals("Спа-лікування", tour.getTreatmentType());
    }

    @Test
    public void testGettersAndSetters() {
        // Перевірка геттерів і сеттерів
        tour.setTitle("Нова назва");
        tour.setTripType(TripType.RECREATION);
        tour.setTransport(Transport.PLANE);
        tour.setFood(Food.FULL_BOARD);
        tour.setDays(7);
        tour.setDescription("Новий опис");
        tour.setPrice(1000.0);
        tour.setTreatmentType("Масаж");

        assertEquals("Нова назва", tour.getTitle());
        assertEquals(TripType.RECREATION, tour.getTripType());
        assertEquals(Transport.PLANE, tour.getTransport());
        assertEquals(Food.FULL_BOARD, tour.getFood());
        assertEquals(7, tour.getDays());
        assertEquals("Новий опис", tour.getDescription());
        assertEquals(1000.0, tour.getPrice(), 0.01);
        assertEquals("Масаж", tour.getTreatmentType());
    }

    @Test
    public void testGetFullTourInfo() {
        // Перевірка методу отримання повної інформації про тур
        String fullInfo = tour.getFullTourInfo();
        String expectedInfo = "Тип Подорожі: Лікування\n" +
                "Назва: Тестова путівка\n" +
                "Транспорт: Поїзд\n" +
                "Харчування: Полупансіон\n" +
                "Тривалість: 14 днів\n" +
                "Опис: Тестовий опис\n" +
                "Ціна: 1200.0\n" +
                "Тип лікування: Спа-лікування\n";
        assertEquals(expectedInfo, fullInfo);
    }
}
