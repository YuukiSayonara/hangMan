package main.java;

import java.util.Scanner;

public class Game {
    private final Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isChoising = true;
        System.out.println("Вы хотите сыграть в игру?");

        while (isChoising) {
            System.out.println("Введите д - если да, н - если нет");

            switch (scanner.nextLine().toLowerCase()) {
                case "д":
                    playSwitcher();
                    System.out.println("Вы хотите сыграть еще раз?");
                    break;
                case "н":
                    isChoising = false;
                    scanner.close();
                    System.out.println("Всего доброго!!!");
                    break;
                default:
                    System.out.println("Вы ввели неверную букву");
            }
        }
    }

    private void playSwitcher() {
        CheckerService checkerService = new CheckerService();
//      System.out.println(checkerService.printSearchWord());
        ResultOfCheck resultOfCheck;
        int countOfErrors = 0;
        PrinterOfGame printerOfGame = new PrinterOfGame();

        System.out.println("Нужно найти все неизвестные буквы в слове.");
        System.out.println("Можно ввести одну букву или все слово целиком.");
        System.out.println("У вас будет 5 попыток :)");
        printerOfGame.printHangman(countOfErrors);
        System.out.print("Вот ваше слово: ");

        while (true) {
            checkerService.printWordWithHiddenLetters();
            System.out.println("Жду от вас букву");
            resultOfCheck = checkerService.check(scanner.nextLine());

            if (resultOfCheck.equals(ResultOfCheck.NOT_RIGHT_LETTER)) {
                countOfErrors++;
            }
            if (countOfErrors == 5) {
                resultOfCheck = ResultOfCheck.LOSS;
            }

            switch (resultOfCheck) {
                case VICTORY:
                    System.out.println("Поздравляю, вы выйграли игру, искомое слово: " + checkerService.printSearchWord() + ".");
                    printerOfGame.printVictory();
                    return;
                case RIGHT_LETTER:
                    System.out.println("Поздравляю, вы выбрали правильную букву, пролоджайте в том же духе!!!");
                    printerOfGame.printHangman(countOfErrors);
                    break;

                case NOT_RIGHT_LETTER:
                    System.out.println("К сожалению ошибка! Вы все еще имеете " + (5 - countOfErrors) + " попытки");
                    printerOfGame.printHangman(countOfErrors);
                    break;
                case LOSS:
                    System.out.println("К сожалению вы проиграли. Искомое слово " + checkerService.printSearchWord());
                    printerOfGame.printHangman(countOfErrors);
                    return;

                case NOT_VALID_LETTER:
                    System.out.println("Вы ввели неверную букву, введите кириллицу");
                    printerOfGame.printHangman(countOfErrors);
                    break;

                case NOT_UNIQUE_LETTER:
                    System.out.println("Вы уже вводили эту букву, введите новую букву");
                    printerOfGame.printHangman(countOfErrors);
                    break;
            }


        }
    }
}