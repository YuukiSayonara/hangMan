package main.java;

import java.util.HashSet;
import java.util.Set;

public class CheckerClass {
    private final String searchWord;
    private Set<String> hiddenLetters;
    private String[] wordWithHiddenLetters;
    private Set<String> rightLetters ;
    private Set<String> userEnteredLetters;

    public CheckerClass() {
        searchWord = new RandomWord().getRandomWord();
        setHiddenLetters();
        setRightLetters();
        userEnteredLetters = new HashSet<>();
    }

    public Set<String> getHiddenLetters() {
        return hiddenLetters;
    }

    public String[] getWordWithHiddenLetters() {
        return wordWithHiddenLetters;
    }

    public Set<String> getRightLetters() {
        return rightLetters;
    }

    public Set<String> getUserEnteredLetters() {
        return userEnteredLetters;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setUserEnteredLetters(String letter) {
            userEnteredLetters.add(letter);
    }

    private void setHiddenLetters() {
        hiddenLetters = new HashSet<>();
        wordWithHiddenLetters = new String[searchWord.length()];
        String letter;

        for (int i = 0; i < searchWord.length(); i++) {
            letter = Character.toString(searchWord.charAt(i));
            if (i % 2 != 0) {
                wordWithHiddenLetters[i] = "*";
                hiddenLetters.add(letter);
            } else wordWithHiddenLetters[i] = letter;
        }

    }
        private void setRightLetters(){
         rightLetters = new HashSet<>();
            for (int i =1072 ; i <1104 ; i++) {
                rightLetters.add(Character.toString(i));
            }
            rightLetters.add(Character.toString(1105)); //ё

        }


}
