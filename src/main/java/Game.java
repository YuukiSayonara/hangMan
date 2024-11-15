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
                    play();
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

  private void play() {
        FindLetter findLetter = new FindLetter();
        int resultOfCheck;
        int countOfErrors = 0;
      System.out.println("Нужно найти все неизвестные буквы в слове.");
      System.out.println("Можно ввести одну букву или все слово целиком.");
      System.out.println("У вас будет 5 попыток :)");
      System.out.print("Вот ваше слово: ");

      while (true) {
            findLetter.printWordWithHiddenLetters();
            System.out.println("Жду от вас букву");
            resultOfCheck = findLetter.check(scanner.nextLine());

            if (resultOfCheck == 3){ countOfErrors++;}
            if (countOfErrors == 5) {resultOfCheck = 4;}

            switch (resultOfCheck) {
                case 1:
                    System.out.println("Поздравляю, вы выйграли игру, искомое слово: " + findLetter.getWordToFind()+".");
                    return;
                case 2:
                    System.out.println("Поздравляю, вы выбрали правильную букву, пролоджайте в том же духе!!!");
                    break;

                case 3:
                    System.out.println("К сожалению ошибка! ВЫ все еще имеете " + (5 - countOfErrors) + " попытки");
                    break;
                case 4:
                    System.out.println("К сожалению вы проиграли. Искомое слово " + findLetter.getWordToFind());
                    return;
            }


        }
    }
}