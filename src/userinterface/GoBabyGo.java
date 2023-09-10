package userinterface;

import stages.Decoder;
import stages.StaticAnalyzer;
import stages.Encoder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

import static stages.BrutForce.letsBrutThisFile;

public class GoBabyGo {
    public static void main(String[] args) {
        try {
            printTextInterface();
            inputAndOutputData();
        } catch (InputMismatchException | NullPointerException | IOException e) {
            System.out.println("Возникла непредвиденная ошибка" + e.getCause());
            e.printStackTrace();
        }
    }

    public static void printTextInterface() {
        System.out.println(Constant.MENU);
    }

    public static void inputAndOutputData() throws InputMismatchException, IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    printChoiseUser(Choise.ENCODER); // Выводим информационный текст
                    Path input1 = pathToFile(); // Вводим путь к файлу для шифрования
                    int key = inputCheckKeyStages(); // инициализаруем ключ для шифрования
                    Encoder.letsEncryptThisFile(input1, key); // передаем ключ и путь в метод  шифрования класса Encoder
                }
                case 2 -> {
                    printChoiseUser(Choise.DECODER);
                    Path input2 = pathToFile();
                    int key = inputCheckKeyStages();
                    Decoder.letsDecryptThisFile(input2, key);
                }
                case 3 -> {
                    printChoiseUser(Choise.BRUTFORCE);
                    Path input3 = pathToFile();
                    int key = inputCheckKeyStages();
                    letsBrutThisFile(input3, key);
                }
                case 4 -> {
                    printChoiseUser(Choise.STATICANALYZER);
                    Path input4 = pathToFile();
                    StaticAnalyzer.letsMakeStaticAnalyze(input4);
                }
                case 5 -> printChoiseUser(Choise.EXIT);
                default -> System.out.println("Некорректный выбор. Введите перечисленные значения");
            }
        }
    }

    public static void printChoiseUser(Choise choise) {
        switch (choise) {
            case ENCODER -> System.out.printf("Вы выбрали пункт 1 - %s\nпожалуйста введите путь к файлу:\n",
                    Choise.ENCODER.getChoise());
            case DECODER -> System.out.printf("Вы выбрали пункт 2 - %s\nпожалуйста введите путь к файлу:\n",
                    Choise.DECODER.getChoise());
            case BRUTFORCE ->
                    System.out.printf("Вы выбрали пункт 3 - %s\nпожалуйста введите путь к файлам для подбора:\n",
                            Choise.BRUTFORCE.getChoise());
            case STATICANALYZER ->
                    System.out.printf("Вы выбрали пункт 4 - %s\nпожалуйста введите путь к файлу для анализа:\n",
                            Choise.STATICANALYZER.getChoise());
            case EXIT -> System.out.println("Вы выбрали пункт 5 - Выход из программы.");
        }
    }

    public static Path pathToFile() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        return Path.of(scanner.nextLine());
    }

    public static int inputCheckKeyStages() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение ключа от 1 до 255:");
        while (scanner.hasNextInt()) {
            int temp = scanner.nextInt();
            if (temp > 0 && temp <= 255) {  // Проверяем значение ключа к выбранному диапазону
                System.out.println("Введеное значение ключа: " + temp);
                return temp;
            } else
                System.out.println("Введно число, отличное от указанного диапазона. Введите значение ключа от 1 до 255:");
        }
        int random = (int) (Math.random() * 255); // Если введено строкове значеиние. то генерим рандомный ключ
        System.out.println("Введено не цифровое значение ключа. Ключ будет сгенерирован автоматически: " + random);
        return random;
    }
}
