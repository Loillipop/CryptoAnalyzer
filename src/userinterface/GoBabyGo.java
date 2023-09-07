package userinterface;
import stages.BrutForce;
import stages.Decoder;
import stages.StaticAnalyzer;
import stages.Encoder;
import java.io.IOException;
import java.nio.file.Path;
import java.util.InputMismatchException;
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
               Encoder.getEncrypt(),
               Decoder.getDecrypt(),
               BrutForce.getNameAction(),
               StaticAnalyzer.getNameAction());
    }
    public static void printChoiseUser(int i) {
        switch (i) {
            case 1 -> System.out.printf("Вы выбрали пункт 1 - %s\nпожалуйста введите путь к файлу:\n",
                    Encoder.getEncrypt());
            case 2 -> System.out.printf("Вы выбрали пункт 2 - %s\nпожалуйста введите путь к файлу:\n",
                    Decoder.getDecrypt());
            case 3 -> System.out.printf("Вы выбрали пункт 3 - %s\nпожалуйста введите путь к файлам для подбора:\n",
                    BrutForce.getNameAction());
            case 4 -> System.out.printf("Вы выбрали пункт 4 - %s\nпожалуйста введите путь к файлу для анализа:\n",
                    StaticAnalyzer.getNameAction());
            case 5 -> System.out.println("Вы выбрали пункт 5 - Выход из программы.");
        }
    }
    public static int inputCheckKeyStages () throws InputMismatchException {
           Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение ключа от 1 до 255:");
           while (scanner.hasNextInt()) {
               int temp = scanner.nextInt();
               if (temp > 0 && temp <= 255 ) {  // Проверяем значение ключа к выбранному диапазону
                   System.out.println("Введеное значение ключа: " + temp);
                   return temp;
               } else System.out.println("Введно число, отличное от указанного диапазона. Введите значение ключа от 1 до 255:");
           }
           int random = (int) (Math.random()* 255); // Если введено строкове значеиние. то генерим рандомный ключ
           System.out.println("Введено не цифровое значение ключа. Ключ будет сгенерирован автоматически: " + random);
           return random;
    }
    public static Path pathToFile () throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        return  Path.of(scanner.nextLine());
    }
    public static void inputAndOutputData () throws InputMismatchException, IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    printChoiseUser(1); // Выводим информационный текст (Enum?)
                    Path input1 = pathToFile(); // Вводим путь к файлу для шифрования
                    int key = inputCheckKeyStages(); // инициализаруем ключ для шифрования
                    Encoder.letsEnDecryptThisFile(input1,key); // передаем ключ и путь в метод  шифрования класса Encrypt
                }
                case 2 -> {
                    printChoiseUser(2);
                    Path input2 = pathToFile();
                    int key = inputCheckKeyStages();
                    Decoder.letsDecryptThisFile(input2, key);
                }
                case 3 -> {
                    printChoiseUser(3);
                    Path input3 = pathToFile();
                    int key = inputCheckKeyStages();
                    BrutForce.letsBrutThisFile(input3,key);
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