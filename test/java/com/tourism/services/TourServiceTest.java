package com.tourism.services;

import com.tourism.enums.Food;
import com.tourism.enums.Transport;
import com.tourism.models.Tour;
import com.tourism.models.tours.RecreationTour;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TourServiceTest {
    private TourService tourService;

    @Before
    public void setUp() {
        tourService = new TourService();
    }

    @Test
    public void testAddTour() {
        // Створення путівки для тесту
        Tour tourToAdd = new RecreationTour("Літо в Греції", Transport.PLANE, Food.HALF_BOARD, 7, "Відпочинок на березі моря", "Готель 4*", 12000);

        // Додавання путівки
        tourService.addTour(tourToAdd);

        // Перевірка, чи путівка була додана до списку путівок
        int lastTour = tourService.getAllTours().size() - 1;
        assertEquals(tourToAdd, tourService.getAllTours().get(lastTour));
    }

    @Test
    public void testDeleteTour() {
        // Створення путівки для тесту
        Tour tourToDelete = new RecreationTour("Відпочинковий тур", Transport.PLANE, Food.HALF_BOARD, 5, "Відпочинок на морському узбережжі", "Готель", 2000.0);
        // Додавання путівки
        tourService.addTour(tourToDelete);

        int size = tourService.getAllTours().size();
        // Видалення путівки
        tourService.deleteTour(tourToDelete);

        // Перевірка, чи путівка була видалена зі списку путівок
        List<Tour> tours = tourService.getAllTours();
        assertEquals(size - 1, tours.size());
    }
}
