package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.enums.TripType;
import com.tourism.enums.Transport;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CruiseTourTest {
    private CruiseTour tour;

    @Before
    public void setUp() {
        // Підготовка тестових даних перед кожним тестом
        tour = new CruiseTour("Тестова путівка", Food.FULL_BOARD, 10, "Тестовий опис", "Круїзний корабель", 2000.0);
    }

    @Test
    public void testConstructor() {
        // Перевірка конструктора
        assertEquals("Тестова путівка", tour.getTitle());
        assertEquals(TripType.CRUISE, tour.getTripType());
        assertEquals(Transport.SHIP, tour.getTransport());
        assertEquals(Food.FULL_BOARD, tour.getFood());
        assertEquals(10, tour.getDays());
        assertEquals("Тестовий опис", tour.getDescription());
        assertEquals(2000.0, tour.getPrice(), 0.01);
    }

    @Test
    public void testGettersAndSetters() {
        // Перевірка геттерів і сеттерів
        tour.setTitle("Нова назва");
        tour.setTripType(TripType.RECREATION);
        tour.setTransport(Transport.PLANE);
        tour.setFood(Food.BREAKFAST);
        tour.setDays(5);
        tour.setDescription("Новий опис");
        tour.setPrice(1500.0);
        tour.setShipName("Нова назва корабля");

        assertEquals("Нова назва", tour.getTitle());
        assertEquals(TripType.RECREATION, tour.getTripType());
        assertEquals(Transport.PLANE, tour.getTransport());
        assertEquals(Food.BREAKFAST, tour.getFood());
        assertEquals(5, tour.getDays());
        assertEquals("Новий опис", tour.getDescription());
        assertEquals(1500.0, tour.getPrice(), 0.01);
        assertEquals("Нова назва корабля", ((CruiseTour) tour).getShipName());
    }

    @Test
    public void testGetFullTourInfo() {
        // Перевірка методу отримання повної інформації про тур
        String fullInfo = tour.getFullTourInfo();
        String expectedInfo = "Тип Подорожі: Круїз\n" +
                "Назва: Тестова путівка\n" +
                "Транспорт: Корабель\n" +
                "Харчування: Повний пансіон\n" +
                "Тривалість: 10 днів\n" +
                "Опис: Тестовий опис\n" +
                "Ціна: 2000.0\n" +
                "Назва корабля: Круїзний корабель\n";
        assertEquals(expectedInfo, fullInfo);
    }
}
