package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ListOfWords{
    private ArrayList<String> listOfWords;

    public ListOfWords() {
        setListOfWords();
    }

    public ArrayList<String> getListOfWords() {
        return listOfWords;
    }

    private void setListOfWords(){
        listOfWords =new ArrayList<>();
        try(BufferedReader reader =new BufferedReader(new FileReader("src/main/resources/nouns.txt"))) {
            String word = reader.readLine();

            while (word != null) {
                word = word.strip().toLowerCase();
                if (checkWord(word)) {
                    listOfWords.add(word);
                }
                word = reader.readLine();
            }
        }
        catch(IOException io){
            System.out.println(io.getMessage());

        }

    }

    private boolean checkWord(String word){
        return !(word.isBlank() || word.length()<5 || word.contains("-") || word.contains(" "));
    }




}
