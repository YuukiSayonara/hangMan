package main.java;

import java.util.HashSet;
import java.util.Set;

public class FindLetter {
    private String wordToFind;
    private Set<String> lettersToFind;
    private String[] arrayWithHiddenLetters;

    public FindLetter() {
        preparingWord();
    }

    public String getWordToFind() {
        return wordToFind;
    }

    private void preparingWord() {
        wordToFind = new Word().getWord();
        lettersToFind = new HashSet<>();
        arrayWithHiddenLetters = new String[wordToFind.length()];
        String letter;

        for (int i = 0; i < wordToFind.length(); i++) {
            letter = Character.toString(wordToFind.charAt(i));
            if (i % 2 != 0) {
                arrayWithHiddenLetters[i] = "*";
                lettersToFind.add(letter);
            } else arrayWithHiddenLetters[i] = letter;
        }

    }

    public int check(String playerWord) {
        playerWord = playerWord.toLowerCase();
        if (checkWord(playerWord)) return 1;

        if (checkLetter(playerWord)) {
            if (lettersToFind.isEmpty()) {
                return 1;
            } else return 2;
        } else return 3;

    }

    private boolean checkWord(String playerWord) {
        return playerWord.toLowerCase().equals(wordToFind);
    }

    private boolean checkLetter(String playerLetter) {
        String letterOfWord;

        if (lettersToFind.contains(playerLetter)) {
            for (int i = 0; i < wordToFind.length(); i++) {
                letterOfWord = Character.toString(wordToFind.charAt(i));

                if (letterOfWord.equals(playerLetter)) {
                    arrayWithHiddenLetters[i] = letterOfWord;
                }
            }
            lettersToFind.remove(playerLetter);
            return true;
        }
        return false;
    }

    public void printWordWithHiddenLetters() {
        for (String letter : arrayWithHiddenLetters) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }
}
