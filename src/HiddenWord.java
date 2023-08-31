import java.util.ArrayList;

public class HiddenWord {
    //instance variables
    private String hiddenWord;
    //constructors
    public HiddenWord(String hiddenWord){
        this.hiddenWord = hiddenWord.toUpperCase();
    }
    //methods
    public String getHint(String guessWord){
        //Throwing Exception Errors

        //doesnt contain all caps
        for (int i = 0; i < guessWord.length(); i++){
            //if 2COOL4SCHOOL doesn't = 2cool4SCHOOL
            if (!guessWord.toUpperCase().equals(guessWord)){
                throw new IllegalArgumentException("Your guess ( " + guessWord + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
            }
        }

        //longer or shorter than length
        if (guessWord.length() != this.hiddenWord.length()){
            throw new IllegalArgumentException("Your guess ( " + guessWord + " ) has " + guessWord.length() + " characters. The hidden word has " + this.hiddenWord.length() + " characters. Your guess must be a word with " + this.hiddenWord.length() + " characters!");
        }

        //the default hint is just *****, if-statements determine whether it changes to '+' or correct letter
        String hint = "";
        ArrayList<Character> allLetters = new ArrayList<>(guessWord.length());
        for (int i = 0; i < guessWord.length(); i++){
            hint += "*";
            //allLetters contain all letters of hiddenWord
            allLetters.add(this.hiddenWord.charAt(i));
        }

        //if char correct in that index, replace asterisks with correct letter
        for (int i = 0; i < guessWord.length(); i++){
            //check if character is the same
            if (guessWord.charAt(i) == this.hiddenWord.charAt(i)){
                hint = hint.substring(0,i) + guessWord.charAt(i) + hint.substring(i+1,guessWord.length());
            }
            //check if character appears somewhere in hiddenWord
            else if (allLetters.contains(guessWord.charAt(i))){
                hint = hint.substring(0,i) + "+" + hint.substring(i+1,guessWord.length());
            }
        }

        return hint;
    }

    public String getHiddenWord(){
        return this.hiddenWord;
    }
}
