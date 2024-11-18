package main.java;

public class CheckerService {
   private final CheckerClass checkerClass;

    public CheckerService() {
        checkerClass = new CheckerClass();
    }

    public ResultOfCheck check(String playerWord) {
        playerWord = playerWord.toLowerCase();
        
        if (isTargetWord(playerWord)) return ResultOfCheck.VICTORY;
        if(isNotValidLetters(playerWord)) return ResultOfCheck.NOT_VALID_LETTER;
        
        if(isNotUniquePlayerLetter(playerWord)) return ResultOfCheck.NOT_UNIQUE_LETTER;
        checkerClass.setUserEnteredLetters(playerWord);
        
        if (isTargetLetter(playerWord)) {
            if (checkerClass.getHiddenLetters().isEmpty()) {
                return ResultOfCheck.VICTORY;
            } else return ResultOfCheck.RIGHT_LETTER;
        } else return ResultOfCheck.NOT_RIGHT_LETTER;

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

    private boolean isNotValidLetters(String playerLetter) {
        return !checkerClass.getValidLetters().contains(playerLetter);
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
