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
      String resultOfCheck;
      int countOfErrors = 0;

      System.out.println("Нужно найти все неизвестные буквы в слове.");
      System.out.println("Можно ввести одну букву или все слово целиком.");
      System.out.println("У вас будет 5 попыток :)");
      System.out.println("исунок статуса!!!");//
      System.out.print("Вот ваше слово: ");

      while (true) {
          checkerService.printWordWithHiddenLetters();
            System.out.println("Жду от вас букву");
            resultOfCheck = checkerService.check(scanner.nextLine());

            if (resultOfCheck.equals("неверная буква")){ countOfErrors++;}
            if (countOfErrors == 5) {resultOfCheck = "проиграл";}

            switch (resultOfCheck) {
                case "выйграл":
                    System.out.println("Поздравляю, вы выйграли игру, искомое слово: " + checkerService.printSearchWord()+".");
                    System.out.println("исунок победы Фанфары!!!");//
                    return;
                case "верная буква":
                    System.out.println("Поздравляю, вы выбрали правильную букву, пролоджайте в том же духе!!!");
                    break;

                case "неверная буква":
                    System.out.println("К сожалению ошибка! Вы все еще имеете " + (5 - countOfErrors) + " попытки");
                    System.out.println("исунок Мена!!!");//
                    break;
                case "проиграл":
                    System.out.println("К сожалению вы проиграли. Искомое слово " + checkerService.printSearchWord());
                    System.out.println("исунок Мена Финальный!!!");//
                    return;

                case "невалидная буква"
                        :System.out.println("Вы ввели неверную букву, введите кириллицу");
                    break;

                case "неуникальная буква"
                        :System.out.println("Вы уже вводили эту букву, введите новую букву");
                    break;
            }



        }
    }
}