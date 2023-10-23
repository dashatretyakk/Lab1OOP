package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.enums.TripType;
import com.tourism.enums.Transport;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShoppingTourTest {
    private ShoppingTour tour;

    @Before
    public void setUp() {
        // Підготовка тестових даних перед кожним тестом
        tour = new ShoppingTour("Тестова путівка", Transport.BUS, Food.NONE, 3, "Тестовий опис", "Торговий центр", 500.0);
    }

    @Test
    public void testConstructor() {
        // Перевірка конструктора
        assertEquals("Тестова путівка", tour.getTitle());
        assertEquals(TripType.SHOPPING, tour.getTripType());
        assertEquals(Transport.BUS, tour.getTransport());
        assertEquals(Food.NONE, tour.getFood());
        assertEquals(3, tour.getDays());
        assertEquals("Тестовий опис", tour.getDescription());
        assertEquals(500.0, tour.getPrice(), 0.01);
        assertEquals("Торговий центр", tour.getShoppingCenter());
    }

    @Test
    public void testGettersAndSetters() {
        // Перевірка геттерів і сеттерів
        tour.setTitle("Нова назва");
        tour.setTripType(TripType.CRUISE);
        tour.setTransport(Transport.SHIP);
        tour.setFood(Food.FULL_BOARD);
        tour.setDays(7);
        tour.setDescription("Новий опис");
        tour.setPrice(1000.0);
        tour.setShoppingCenter("Новий торговий центр");

        assertEquals("Нова назва", tour.getTitle());
        assertEquals(TripType.CRUISE, tour.getTripType());
        assertEquals(Transport.SHIP, tour.getTransport());
        assertEquals(Food.FULL_BOARD, tour.getFood());
        assertEquals(7, tour.getDays());
        assertEquals("Новий опис", tour.getDescription());
        assertEquals(1000.0, tour.getPrice(), 0.01);
        assertEquals("Новий торговий центр", tour.getShoppingCenter());
    }

    @Test
    public void testGetFullTourInfo() {
        // Перевірка методу отримання повної інформації про тур
        String fullInfo = tour.getFullTourInfo();
        String expectedInfo = "Тип Подорожі: Шопінг\n" +
                "Назва: Тестова путівка\n" +
                "Транспорт: Автобус\n" +
                "Харчування: Без харчування\n" +
                "Тривалість: 3 дні\n" +
                "Опис: Тестовий опис\n" +
                "Ціна: 500.0\n" +
                "Торгівельний центр: Торговий центр\n";
        assertEquals(expectedInfo, fullInfo);
    }
}
