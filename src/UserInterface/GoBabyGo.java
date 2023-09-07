package UserInterface;
import Analyzer.BrutForce;
import Analyzer.StaticAnalyzer;
import DecryptEncrypt.Decryptor;
import DecryptEncrypt.Encryptor;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GoBabyGo {
    public static void main(String[] args) {
        try {
            printTextInterface();
            inputAndOutputData();
            }catch (InputMismatchException e) {
                   System.out.println("Возникла непредвиденная ошибка: Несовпадение типов введенных значений" );
                   e.printStackTrace();
            }
    }

    public static void printTextInterface() {
                System.out.printf("Выберите требуемое действие:\n1 - %s\n2 - %s\n3 - %s\n4 - %s\n5 - Выход\n",
                Decryptor.getNameAction(),
                Encryptor.getNameAction(),
                BrutForce.getNameAction(),
                StaticAnalyzer.getNameAction());
                }
    public static void printChoiseUser(int i) {
       switch (i) {
             case 1:
                  System.out.printf("Вы выбрали пункт 1 - %s\nпожалуйста введите путь к файлу:\n",
                  Decryptor.getNameAction());
                  break;
             case 2:
                  System.out.printf("Вы выбрали пункт 2 - %s\nпожалуйста введите путь к файлу:\n",
                  Encryptor.getNameAction());
                  break;
             case 3:
                  System.out.printf("Вы выбрали пункт 3 - %s\nУкажите значение ключа от 0 до 100:\n",
                  BrutForce.getNameAction());
                  break;
             case 4:
                  System.out.printf("Вы выбрали пункт 4 - %s\nпожалуйста введите путь к файлу для анализа:\n",
                  StaticAnalyzer.getNameAction());
                  break;
             case 5:
                  System.out.println("Вы выбрали пункт 5 - Выход из программы.");
                  break;
       }
    }
    public static int countBruteForceKey () throws InputMismatchException {
           Scanner scanner = new Scanner(System.in);
           int temp = scanner.nextInt();
           if (temp >= 0 && temp <= 100 ) {
               System.out.println("Введеное число для переборки ключа: " + temp);
               return temp;
           } else
               System.out.println("Введно неверное или отрицательное число");
               return 0;
    }
    public static String pathToFile () throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextLine();
    }
    public static void inputAndOutputData () throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
             switch (scanner.nextInt()) {
                   case 1:
                        printChoiseUser(1);
                        String input1 = pathToFile();
                        Decryptor.letsDecryptThisFile(input1);
                        break;
                   case 2:
                        printChoiseUser(2);
                        String input2 = pathToFile();
                        Encryptor.letsEncryptThisFile(input2);
                        break;
                   case 3:
                        printChoiseUser(3);
                        int key  = countBruteForceKey();
                        BrutForce.letsBrutThisFile(key);
                        break;
                   case 4:
                        printChoiseUser(4);
                        String input4 = pathToFile();
                        StaticAnalyzer.letsMakeStaticAnalyze(input4);
                        break;
                   case 5:
                        printChoiseUser(5);
                        break;
             }
               break;
        }
    }

}