package com.tourism.ui;

import com.tourism.enums.TripType;
import com.tourism.models.Tour;
import com.tourism.services.TourService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class MainAppTest {
    @Mock
    private TourService tourService;
    MainApp mainApp = new MainApp();
    List<Tour> fakeTours = new ArrayList<>();

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Тест на відображення списку турів
    @Test
    public void testDisplayTours() {
        String input = "0\n"; // Вводимо 0 для виходу з меню
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner fakeScanner = new Scanner(inputStream);

        mainApp.tourService = tourService;
        mainApp.scanner = fakeScanner;

        when(tourService.getAllTours()).thenReturn(fakeTours);

        // Запускаємо метод, який ми тестуємо
        mainApp.displayTours(mainApp.scanner);

        // Перевіряємо, що вивід не містить помилок
        assertFalse(System.out.checkError());
    }

    // Тест на паузу
    @Test
    public void testPause() {
        // Створюємо екземпляр MainApp
        MainApp mainApp = new MainApp();

        // Створюємо фейковий ввід (InputStream) для введення Enter
        InputStream inputStream = new ByteArrayInputStream("\n".getBytes());
        System.setIn(inputStream);

        // Створюємо фейковий вивід (OutputStream) для захоплення виводу методу pause
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Запускаємо метод, який ми тестуємо
        mainApp.pause();

        // Перевіряємо, що вивід містить запит на Enter
        assertTrue(outContent.toString().contains("Натисніть Enter для продовження..."));
    }

    // Тест на валідацію перелічуваного типу
    @Test
    public void testValidateEnumInput() {
        // Тест для методу validateEnumInput
        String input = "Відпочинок"; // Допустиме значення
        Scanner fakeScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        TripType result = mainApp.validateEnumInput(TripType.class, "Введіть тип путівки: ", fakeScanner);

        assertEquals(TripType.RECREATION, result);
    }

    // Тест на валідацію текстового введення
    @Test
    public void testValidateTextInput() {
        // Тест для методу validateTextInput
        String input = "Париж"; // Допустиме значення
        Scanner fakeScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        String result = mainApp.validateTextInput("Введіть назву: ", fakeScanner);

        assertEquals("Париж", result);
    }

    // Тест на валідацію числового введення
    @Test
    public void testValidateNumberInput() {

        Scanner fakeScanner = new Scanner("42\n");

        int result = mainApp.validateNumberInput("Введіть число: ", 1, 100, fakeScanner);

        assertEquals(42, result);
    }

    // Тест на валідацію позитивного числа з плаваючою точкою
    @Test
    public void testValidatePositiveDoubleInput() {

        Scanner fakeScanner = new Scanner("99.99\n");

        double result = mainApp.validatePositiveDoubleInput("Введіть позитивне число: ", fakeScanner);

        assertEquals(99.99, result, 0.01); // Допустима похибка
    }
}
