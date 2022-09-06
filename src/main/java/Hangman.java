public class Hangman {
    String wordToGuess;
    int mistakesAllowed;

    public static final int defaultMistakesAllowed = 5;

    public Hangman(String wordToGuess) {
        this(wordToGuess, defaultMistakesAllowed);
    }

    public Hangman(String wordToGuess, int mistakesAllowed) {
        this.wordToGuess = wordToGuess;
        this.mistakesAllowed = mistakesAllowed;
    }
}
