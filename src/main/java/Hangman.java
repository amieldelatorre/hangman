import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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

    public int getMistakesAllowed() {
        return mistakesAllowed;
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

    public String getCurrentGuessWordState() {
        char[] stringToReturn = new char[wordToGuess.length()];
        Arrays.fill(stringToReturn, '_');
        for (String correctGuess : correctGuesses) {
            if (correctGuess.length() > 1 && wordToGuess.equals(correctGuess)) {
                return correctGuess;
            }
            else if (correctGuess.length() <= 1) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    char charInWordToGuess = wordToGuess.charAt(i);
                    if (String.valueOf(charInWordToGuess).equals(correctGuess))
                        stringToReturn[i] = charInWordToGuess;
                }
            }
        }
        return String.valueOf(stringToReturn);
    }

    public boolean isGameWon() {
        boolean result = false;
        List<String> charsGuessed = new ArrayList<String>();
        for (String correctGuess : correctGuesses) {
            if (correctGuess.length() > 1 && wordToGuess.equals(correctGuess)) {
                result = true;
                break;
            }
            else if (correctGuess.length() == 1)
                charsGuessed.add(correctGuess);
        }

        if (!result)
            return charsGuessed.size() == wordToGuess.length();
        return result;
    }

    public boolean guessNotInAGuessList(String guess) {
        return !correctGuesses.contains(guess) && !incorrectGuesses.contains(guess);
    }
}
