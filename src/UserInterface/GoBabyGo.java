package UserInterface;
import Analyzer.BrutForce;
import Analyzer.StaticAnalyzer;
import DecryptEncrypt.Decryptor;
import DecryptEncrypt.Encryptor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GoBabyGo {
    public static void main(String[] args) {
        try {
            printTextInterface();
            inputAndOutputData();
            }catch (InputMismatchException | IOException e) {
                   System.out.println("Возникла непредвиденная ошибка: Несовпадение типов введенных значений" );
                   e.printStackTrace();
            }
    }

    public static void printTextInterface() {
        System.out.printf("Выберите требуемое действие:\n1 - %s\n2 - %s\n3 - %s\n4 - %s\n5 - Выход\n",
               Encryptor.getNameAction(),
               Decryptor.getNameAction(),
               BrutForce.getNameAction(),
               StaticAnalyzer.getNameAction());
    }
    public static void printChoiseUser(int i) {
        switch (i) {
            case 1 -> System.out.printf("Вы выбрали пункт 1 - %s\nпожалуйста введите путь к файлу:\n",
                    Encryptor.getNameAction());
            case 2 -> System.out.printf("Вы выбрали пункт 2 - %s\nпожалуйста введите путь к файлу:\n",
                    Decryptor.getNameAction());
            case 3 -> System.out.printf("Вы выбрали пункт 3 - %s\n",
                    BrutForce.getNameAction());
            case 4 -> System.out.printf("Вы выбрали пункт 4 - %s\nпожалуйста введите путь к файлу для анализа:\n",
                    StaticAnalyzer.getNameAction());
            case 5 -> System.out.println("Вы выбрали пункт 5 - Выход из программы.");
        }
    }
    public static int countBruteForceKey () throws InputMismatchException {
           Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение ключа от 0 до 10 включительно:");
           while (scanner.hasNextInt()) {
               int temp = scanner.nextInt();
               if (temp >= 0 && temp <= 10) {  // Проверяем значение ключа к выбранному диапазону
                   System.out.println("Введеное значение ключа: " + temp);
                   return temp;
               } else System.out.println("Введно число, отличное от указанного диапазона. Введите значение ключа от 0 до 10 включительно:");
           }
           int random = (int) (Math.random()* 10); // Если введено строкове значеиние. то генерим рандомный ключ
           System.out.println("Введено не цифровое значение ключа. Ключ будет сгенерирован автоматически: " + random);
           return random;
    }
    public static Path pathToFile () throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of(scanner.nextLine());
        return  path;
    }
    public static void inputAndOutputData () throws InputMismatchException, IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    printChoiseUser(1); // Выводим информационный текст (Enum?)
                    Path input1 = pathToFile(); // Вводим путь к файлу для шифрования
                    int key = countBruteForceKey(); // инициализаруем ключ для шифрования
                    Encryptor.letsEncryptThisFile(input1,key); // передаем ключ и путь в метод  шифрования класса Encrypt
                }
                case 2 -> {
                    printChoiseUser(2);
                    Path input2 = pathToFile();
                    int key = countBruteForceKey();
                    Decryptor.letsDecryptThisFile(input2, key);
                }
                case 3 -> {
                    printChoiseUser(3);
                    int key = countBruteForceKey();
                    BrutForce.letsBrutThisFile(key);
                }
                case 4 -> {
                    printChoiseUser(4);
                    Path input4 = pathToFile();
                    StaticAnalyzer.letsMakeStaticAnalyze(input4);
                }
                case 5 -> printChoiseUser(5);
            }
               break;
        }
    }

}