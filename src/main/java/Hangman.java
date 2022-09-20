import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hangman {
    private String wordToGuess;
    private int mistakesAllowed;
    private List<String> correctGuesses = new ArrayList<String>();
    private List<String> incorrectGuesses = new ArrayList<String>();

    public static final int DEFAULT_MISTAKES_ALLOWED = 5;

    public Hangman(String wordToGuess) {
        this(wordToGuess, DEFAULT_MISTAKES_ALLOWED);
    }

    public Hangman(String wordToGuess, int mistakesAllowed) {
        this.wordToGuess = wordToGuess;
        this.mistakesAllowed = mistakesAllowed;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public int getNumberOfCorrectGuesses() {
        return correctGuesses.size();
    }

    public int getNumberOfIncorrectGuesses() {
        return incorrectGuesses.size();
    }

    public int getNumberOfGuesses() {
        return getNumberOfCorrectGuesses() + getNumberOfIncorrectGuesses();
    }

    public boolean guess(String guessAttempt) {
        boolean guessResult;
        if (guessAttempt.length() > 1)
            guessResult = guessWord(guessAttempt);
        else
            guessResult = guessLetter(guessAttempt);

        if (guessResult)
            correctGuesses.add(guessAttempt);
        else
            incorrectGuesses.add(guessAttempt);

        return guessResult;
    }

    public boolean guessWord(String guessWord) {
        return wordToGuess.equals(guessWord);
    }

    public boolean guessLetter(String guessChar) {
        int indexOfLetter = wordToGuess.indexOf(guessChar);
        // indexOf returns -1 if string or character is not found
        return indexOfLetter != -1;
    }
}
