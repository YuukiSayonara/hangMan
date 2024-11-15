package main.java;

public class CheckerService {
   private final CheckerClass checkerClass;

    public CheckerService() {
        checkerClass = new CheckerClass();
    }

    public String check(String playerWord) {
        playerWord = playerWord.toLowerCase();
        
        if (isTargetWord(playerWord)) return "выйграл";
        if(isNotRightLetters(playerWord)) return "невалидная буква";
        
        if(isNotUniquePlayerLetter(playerWord)) return "неуникальная буква";
        checkerClass.setUserEnteredLetters(playerWord);
        
        if (isTargetLetter(playerWord)) {
            if (checkerClass.getHiddenLetters().isEmpty()) {
                return "выйграл";
            } else return "верная буква";
        } else return "неверная буква";

    }

    private boolean isTargetWord(String playerWord) {
        return playerWord.toLowerCase().equals(checkerClass.getSearchWord());
    }

    private boolean isTargetLetter(String playerLetter) {
        if (checkerClass.getHiddenLetters().contains(playerLetter)) {
            toOpenLetter(playerLetter);
            checkerClass.getHiddenLetters().remove(playerLetter);
            return true;
        }
        return false;
    }

    private boolean isNotRightLetters(String playerLetter) {
        return !checkerClass.getRightLetters().contains(playerLetter);
    }

    private boolean isNotUniquePlayerLetter(String playerLetter) {
        return checkerClass.getUserEnteredLetters().contains(playerLetter);
    }

    private void toOpenLetter(String playerLetter){
        String letterOfSearchWordByIndex;
        
        for (int i = 0; i < checkerClass.getSearchWord().length(); i++) {
            letterOfSearchWordByIndex = Character.toString(checkerClass.getSearchWord().charAt(i));

            if (letterOfSearchWordByIndex.equals(playerLetter)) {
                checkerClass.getWordWithHiddenLetters()[i] = letterOfSearchWordByIndex;
            }
        }
    }

    public void printWordWithHiddenLetters() {
        for (String letter : checkerClass.getWordWithHiddenLetters()) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    public String printSearchWord(){
        return checkerClass.getSearchWord();
    }
}
