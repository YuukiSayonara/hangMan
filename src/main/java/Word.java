package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Word {
    private final ArrayList<String> list;
    private final int maxInt;
    private String word;

    public Word() {
        list = new ListOfWords().getListOfWords();
        maxInt = list.size();
        setWord();
    }

    public String getWord() {
        return word;
    }

    private void setWord(){
        Random random = new Random();
        word = list.get(random.nextInt(maxInt));
    }


}
