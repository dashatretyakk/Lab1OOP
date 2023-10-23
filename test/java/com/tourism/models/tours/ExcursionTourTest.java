package com.tourism.models.tours;

import com.tourism.enums.Food;
import com.tourism.enums.TripType;
import com.tourism.enums.Transport;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExcursionTourTest {
    private ExcursionTour tour;

    @Before
    public void setUp() {
        // Підготовка тестових даних перед кожним тестом
        tour = new ExcursionTour("Тестова путівка", Transport.BUS, Food.BREAKFAST, 5, "Тестовий опис", 3, 800.0);
    }

    @Test
    public void testConstructor() {
        // Перевірка конструктора
        assertEquals("Тестова путівка", tour.getTitle());
        assertEquals(TripType.EXCURSION, tour.getTripType());
        assertEquals(Transport.BUS, tour.getTransport());
        assertEquals(Food.BREAKFAST, tour.getFood());
        assertEquals(5, tour.getDays());
        assertEquals("Тестовий опис", tour.getDescription());
        assertEquals(800.0, tour.getPrice(), 0.01);
        assertEquals(3, tour.getNumberOfSites());
    }

    @Test
    public void testGettersAndSetters() {
        // Перевірка геттерів і сеттерів
        tour.setTitle("Нова назва");
        tour.setTripType(TripType.RECREATION);
        tour.setTransport(Transport.PLANE);
        tour.setFood(Food.HALF_BOARD);
        tour.setDays(7);
        tour.setDescription("Новий опис");
        tour.setPrice(1000.0);
        tour.setNumberOfSites(4);

        assertEquals("Нова назва", tour.getTitle());
        assertEquals(TripType.RECREATION, tour.getTripType());
        assertEquals(Transport.PLANE, tour.getTransport());
        assertEquals(Food.HALF_BOARD, tour.getFood());
        assertEquals(7, tour.getDays());
        assertEquals("Новий опис", tour.getDescription());
        assertEquals(1000.0, tour.getPrice(), 0.01);
        assertEquals(4, tour.getNumberOfSites());
    }

    @Test
    public void testGetFullTourInfo() {
        // Перевірка методу отримання повної інформації про тур
        String fullInfo = tour.getFullTourInfo();
        String expectedInfo = "Тип Подорожі: Екскурсія\n" +
                "Назва: Тестова путівка\n" +
                "Транспорт: Автобус\n" +
                "Харчування: Сніданок\n" +
                "Тривалість: 5 днів\n" +
                "Опис: Тестовий опис\n" +
                "Ціна: 800.0\n" +
                "Кількість місць для відвідування: 3\n";
        assertEquals(expectedInfo, fullInfo);
    }
}
