package com.tourism.ui;

import com.tourism.enums.Food;
import com.tourism.enums.Transport;
import com.tourism.enums.TripType;
import com.tourism.models.Tour;
import com.tourism.models.tours.CruiseTour;
import com.tourism.models.tours.ExcursionTour;
import com.tourism.models.tours.RecreationTour;
import com.tourism.models.tours.TreatmentTour;
import com.tourism.services.TourService;
import com.tourism.utils.EnumUtils;
import com.tourism.utils.comparators.DurationComparatorAsc;
import com.tourism.utils.comparators.DurationComparatorDesc;
import com.tourism.utils.comparators.PriceComparatorAsc;
import com.tourism.utils.comparators.PriceComparatorDesc;

import java.util.List;
import java.util.Scanner;

// Головний клас додатку
public class MainApp {
    // Сервіс для управління подорожами
    public static TourService tourService = new TourService();

    // Об'єкт для зчитування вводу користувача
    public static Scanner scanner = new Scanner(System.in);

    // Роздільник для відображення розділової лінії
    private static final String delimiter = "--------------------";

    // Головний метод додатку
    public static void main(String[] args) {

        boolean isRunning = true;

        while (isRunning) {
            try {
                displayMenu();

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        displayTours(scanner);
                        break;
                    case 2:
                        addNewTour();
                        break;
                    case 3:
                        deleteTour(scanner);
                        break;
                    case 0:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Невірний вибір, спробуйте ще раз.");
                }
            } catch (Exception e) {
                System.out.println("Сталася помилка");
                scanner.nextLine();
            }
        }
    }

    // Метод для відображення головного меню
    private static void displayMenu() {
        System.out.println(delimiter);
        System.out.println("1. Перегляд путівок");
        System.out.println("2. Додати путівку");
        System.out.println("3. Видалити путівку");
        System.out.println("0. Вийти");
        System.out.print("Ваш вибір: ");
    }

    // Метод для відображення списку доступних путівок
    public static void displayTours(Scanner scanner) {
        while (true) {
            System.out.println(delimiter);
            List<Tour> availableTours = tourService.getAllTours();
            if (availableTours.isEmpty()) {
                System.out.println("Список путівок порожній.");
                return;
            }

            System.out.println("Доступні путівки:");
            for (int i = 0; i < availableTours.size(); i++) {
                System.out.println((i + 1) + ". " + availableTours.get(i).getShortTourInfo());
            }
            pause();

            System.out.println(delimiter);
            System.out.println("Доступні дії:");
            System.out.println("1. Перегляд повної інформації про путівку.");
            System.out.println("2. Сортування списку за ціною (зростання).");
            System.out.println("3. Сортування списку за ціною (зменшення).");
            System.out.println("4. Сортування списку за тривалістю (зростання).");
            System.out.println("5. Сортування списку за тривалістю (зменшення).");
            System.out.println("0. Повернення до головного меню.");

            System.out.print("Ваш вибір: ");
            String input = scanner.nextLine();

            switch (input.trim()) {
                case "1":
                    viewTourDetails(availableTours, scanner);
                    pause();
                    break;
                case "2":
                    availableTours.sort(new PriceComparatorAsc());
                    displaySortedTours(availableTours);
                    pause();
                    break;
                case "3":
                    availableTours.sort(new PriceComparatorDesc());
                    displaySortedTours(availableTours);
                    pause();
                    break;
                case "4":
                    availableTours.sort(new DurationComparatorAsc());
                    displaySortedTours(availableTours);
                    pause();
                    break;
                case "5":
                    availableTours.sort(new DurationComparatorDesc());
                    displaySortedTours(availableTours);
                    pause();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
                    break;
            }
        }
    }

    // Метод для відображення інформації про обрану путівку
    private static void displayTourInfo(Tour tour) {
        System.out.println(delimiter);
        System.out.println("Повна інформація про путівку:");
        System.out.println("Назва: " + tour.getTitle());
        System.out.println("Тип: " + tour.getTripType());
        System.out.println("Транспорт: " + tour.getTransport());
        System.out.println("Харчування: " + tour.getFood());
        System.out.println("Тривалість: " + tour.getDays() + " днів");
        System.out.println("Опис: " + tour.getDescription());

        if (tour instanceof RecreationTour) {
            RecreationTour recreationTour = (RecreationTour) tour;
            System.out.println("Тип помешкання: " + recreationTour.getAccommodationType());
        } else if (tour instanceof ExcursionTour) {
            ExcursionTour excursionTour = (ExcursionTour) tour;
            System.out.println("Кількість місць для відвідування: " + excursionTour.getNumberOfSites());
        } else if (tour instanceof TreatmentTour) {
            TreatmentTour treatmentTour = (TreatmentTour) tour;
            System.out.println("Тип лікування: " + treatmentTour.getTreatmentType());
        } else if (tour instanceof CruiseTour) {
            CruiseTour cruiseTour = (CruiseTour) tour;
            System.out.println("Назва корабля: " + cruiseTour.getShipName());
        }
    }

    // Метод для перегляду повної інформації про обрану путівку
    private static void viewTourDetails(List<Tour> availableTours, Scanner scanner) {
        System.out.print("Введіть номер путівки для перегляду повної інформації або 'q' для повернення: ");
        String input = scanner.nextLine();
        if (!input.equalsIgnoreCase("q")) {
            try {
                int tourNumber = Integer.parseInt(input);
                if (tourNumber >= 1 && tourNumber <= availableTours.size()) {
                    Tour selectedTour = availableTours.get(tourNumber - 1);
                    displayTourInfo(selectedTour);
                } else {
                    System.out.println("Помилка: невірний номер путівки! Доступні номери: 1 - " + availableTours.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("Помилка: невірний формат вводу.");
            }
        }
    }

    // Метод для відображення відсортованих путівок
    private static void displaySortedTours(List<Tour> sortedTours) {
        for (int i = 0; i < sortedTours.size(); i++) {
            System.out.println((i + 1) + ". " + sortedTours.get(i).getShortTourInfo());
        }
        System.out.println(delimiter);
    }

    // Метод для додавання нової путівки
    private static void addNewTour() {
        System.out.println(delimiter);
        System.out.println("Введіть інформацію для нової путівки...");
        String title = validateTextInput("Назва путівки: ", scanner);
        TripType type = validateEnumInput(TripType.class, "Тип путівки (Відпочинок, Екскурсія, Лікування, Шопінг, Круїз): ", scanner);
        Transport transport;
        if (type != TripType.CRUISE) {
            transport = Transport.SHIP;
        } else {
            transport = validateEnumInput(Transport.class, "Транспорт (Автобус, Поїзд, Літак, Корабель): ", scanner);
        }
        Food food = validateEnumInput(Food.class, "Харчування (Без харчування, Сніданок, Полупансіон, Повний пансіон): ", scanner);
        int duration = validateNumberInput("Тривалість (число днів): ", 1, 365, scanner);
        String description = validateTextInput("Опис путівки: ", scanner);
        double price = validatePositiveDoubleInput("Ціна путівки: ", scanner);

        Tour newTour;
        switch (type) {
            case RECREATION:
                String accommodationType = validateTextInput("Тип помешкання (наприклад, Готель, Хостел і т.д.): ", scanner);
                newTour = new RecreationTour(title, transport, food, duration, description, accommodationType, price);
                break;
            case EXCURSION:
                int numberOfSites = validateNumberInput("Кількість місць для відвідування: ", 1, 100, scanner);
                newTour = new ExcursionTour(title, transport, food, duration, description, numberOfSites, price);
                break;
            case TREATMENT:
                String treatmentType = validateTextInput("Тип лікування (наприклад, Масаж, Грязеві ванни і т.д.): ", scanner);
                newTour = new TreatmentTour(title, transport, food, duration, description, treatmentType, price);
                break;
            case CRUISE:
                String shipName = validateTextInput("Назва корабля: ", scanner);
                newTour = new CruiseTour(title, food, duration, description, shipName, price);
                break;
            default:
                throw new IllegalArgumentException("Невідомий тип путівки: " + type);
        }

        tourService.addTour(newTour);
        System.out.println("Путівка успішно додана!");
    }

    // Метод для видалення путівки
    private static void deleteTour(Scanner scanner) {
        System.out.println(delimiter);
        System.out.println("Список усіх путівок:");
        List<Tour> allTours = tourService.getAllTours();
        for (int i = 0; i < allTours.size(); i++) {
            System.out.println((i + 1) + ". " + allTours.get(i).getTitle());
        }

        System.out.print("Введіть номер путівки для видалення: ");
        int tourNumber = scanner.nextInt();
        scanner.nextLine();  // Очищення вводу

        if (tourNumber < 1 || tourNumber > allTours.size()) {
            System.out.println("Помилка: невірний номер путівки!");
            return;
        }

        Tour selectedTour = allTours.get(tourNumber - 1);
        tourService.deleteTour(selectedTour);
        System.out.println("Путівка з номером " + tourNumber + " успішно видалена!");
    }

    // Метод для відображення повідомлення та очікування Enter від користувача
    public static void pause() {
        System.out.print("\n Натисніть Enter для продовження...");
        scanner.nextLine();
    }

    // Метод для перевірки та зчитування вибору із користувача для енума
    public static <T extends Enum<T>> T validateEnumInput(Class<T> enumClass, String prompt, Scanner scanner) {
        while (true) {
            String input = validateTextInput(prompt, scanner);
            T enumValue = EnumUtils.findByDescription(enumClass, input);
            if (enumValue != null) {
                return enumValue;
            } else {
                System.out.println("Невірне значення. Спробуйте ще раз.");
            }
        }
    }

    // Метод для перевірки та зчитування текстового вводу
    public static String validateTextInput(String prompt, Scanner scanner) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }


    // Метод для перевірки та зчитування числового вводу
    public static int validateNumberInput(String prompt, int min, int max, Scanner scanner) {
        int number;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Помилка: це не число. Спробуйте ще раз.");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number < min || number > max);
        scanner.nextLine();
        return number;
    }

    // Метод для перевірки та зчитування позитивного числового вводу з плаваючою точкою
    public static double validatePositiveDoubleInput(String prompt, Scanner scanner) {
        double number;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println("Помилка: це не число. Спробуйте ще раз.");
                scanner.next();
            }
            number = scanner.nextDouble();
            if (number <= 0) {
                System.out.println("Помилка: число повинно бути позитивним.");
            }
        } while (number <= 0);
        scanner.nextLine();
        return number;
    }

}
