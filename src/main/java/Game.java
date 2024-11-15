package main.java;

import java.util.Scanner;

public class Game {
    
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean isChoising = true;
        System.out.println("Вы хотите сыграть в игру?");

        while (isChoising) {
            System.out.println("Введите д - если да, н - если нет");

            switch (scanner.nextLine().toLowerCase()) {
                case "д":
                    isChoising = false;
                    System.out.println("start");
                    break;
                case "н":
                    isChoising = false;
                    System.out.println("Всего доброго!!!");
                    break;
                default:
                    System.out.println("Вы ввели неверную букву");
            }
        }
    }
}