package com.tourism.services;

import com.tourism.models.Tour;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Сервіс для роботи з файлами
public class FileService {

    // Шлях до файлу для збереження та завантаження даних
    private final String FILE_PATH;

    // Конструктор без параметрів, ініціалізує шлях до файлу за замовчуванням
    public FileService() {
        FILE_PATH = "tours.dat";
    }

    // Конструктор з параметром для зазначення власного шляху до файлу
    public FileService(String filePass) {
        FILE_PATH = filePass;
    }

    // Метод для завантаження путівок з файлу
    public List<Tour> loadTours() {
        List<Tour> tours = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(FILE_PATH)))) {
            // Зчитування путівок з файлу та додавання їх до списку
            tours = (List<Tour>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Помилка завантаження даних: " + e.getMessage());
        }
        return tours;
    }

    // Метод для збереження путівок в файл
    public void saveTours(List<Tour> tours) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(FILE_PATH)))) {
            // Запис путівок в файл
            oos.writeObject(tours);
        } catch (Exception e) {
            System.out.println("Помилка збереження даних: " + e.getMessage());
        }
    }
}
