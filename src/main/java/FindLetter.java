package main.java;

import java.util.HashSet;
import java.util.Set;

public class FindLetter {
    public String wordToFind;
    public Set<String> lettersToFind;
    public String wordWithHiddenLetters;

    public FindLetter() {
        preparingWords();
    }

    void preparingWords() {
        wordToFind = new Word().getWord();
        lettersToFind = new HashSet<>();
        wordWithHiddenLetters = "";

        for (int i = 0; i < wordToFind.length(); i++) {
            if (i % 2 != 0) {
                wordWithHiddenLetters += ("*");
                lettersToFind.add(Character.toString(wordToFind.charAt(i)));
            } else wordWithHiddenLetters += wordToFind.charAt(i);
        }

    }

    boolean checkWord(String word) {
        return word.equals(wordToFind);
    }

    boolean checkLetter(String letter){
        if(lettersToFind.contains(letter)){
            for (int i = 0; i < wordToFind.length(); i++) {
               if(Character.toString(wordToFind.charAt(i)).equals(letter)){
               }
            }
        }
        return false;
    }

    public void printWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.charAt(i) + " ");
        }
        System.out.println();
    }
}
