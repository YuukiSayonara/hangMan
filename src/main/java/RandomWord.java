package main.java;

import java.util.ArrayList;
import java.util.Random;

public class RandomWord {
    private final ArrayList<String> list;
    private final int maxIntOfRandom;
    private String randomWord;

    public RandomWord() {
        list = new ListOfWords().getListOfWords();
        maxIntOfRandom = list.size();
        setRandomWord();
    }

    public String getRandomWord() {
        return randomWord;
    }

    private void setRandomWord(){
        Random random = new Random();
        randomWord = list.get(random.nextInt(maxIntOfRandom));
    }


}
