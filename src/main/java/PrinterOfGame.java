package main.java;

import java.util.Random;

public class PrinterOfGame {
    private final String topLine = "+----------+";
    private final String clearLine = "|";
    private final String lineWithRope = "|          |";
    private final String lineWithHead = "|          O";
    private final String lineWithHands = "|         / \\";
    private final String lineWithBody = "|         /|\\";
    private final String lineWithLegs = "|         / \\";
    private final String bottomLine = "-------------";

    public void printHangman(int countOfErrors) {
        switch (countOfErrors) {
            case 0:
                printWithoutErrors();
                return;
            case 1:
                printFirstError();
                return;
            case 2:
                printSecondError();
                return;
            case 3:
                printThirdError();
                return;
            case 4:
                printFourthError();
                return;
            case 5:
                printFifthError();
                return;
        }
    }

    private void printFifthError() {
        System.out.println(topLine);
        System.out.println(lineWithRope);
        System.out.println(lineWithHead);
        System.out.println(lineWithBody);
        System.out.println(lineWithLegs);
        System.out.println(clearLine);
        System.out.println(bottomLine);
        System.out.println(bottomLine);
    }

    private void printFourthError() {
        System.out.println(topLine);
        System.out.println(lineWithRope);
        System.out.println(lineWithHead);
        System.out.println(lineWithBody);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(bottomLine);
        System.out.println(bottomLine);

    }

    private void printThirdError() {
        System.out.println(topLine);
        System.out.println(lineWithRope);
        System.out.println(lineWithHead);
        System.out.println(lineWithHands);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(bottomLine);
        System.out.println(bottomLine);

    }

    private void printSecondError() {
        System.out.println(topLine);
        System.out.println(lineWithRope);
        System.out.println(lineWithHead);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(bottomLine);
        System.out.println(bottomLine);

    }

    private void printFirstError() {
        System.out.println(topLine);
        System.out.println(lineWithRope);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(bottomLine);
        System.out.println(bottomLine);

    }

    private void printWithoutErrors() {
        System.out.println(topLine);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(clearLine);
        System.out.println(bottomLine);
        System.out.println(bottomLine);

    }

    public void printVictory() {
        String[] emoji = {"\uD83E\uDD87", "\uD83D\uDCA3", "\uD83D\uDCAA", "\uD83E\uDD19", "\uD83E\uDD47", "\uD83D\uDE09",
                "\uD83D\uDC4C", "\uD83E\uDD18", "\uD83D\uDC4D", "\uD83C\uDF1B", "\uD83C\uDF1E", "\uD83D\uDC33", "\uD83E\uDDE8", "\uD83D\uDC7B"};
        Random random = new Random();
        int maxIntOfRandom = emoji.length;
        int index;

        for (int row = 0; row < 5; row++) {
            for (int element = 0; element < 25; element++) {
                index = random.nextInt(maxIntOfRandom);
                System.out.print(emoji[index] + " ");
            }
            System.out.println();
        }

    }

}

