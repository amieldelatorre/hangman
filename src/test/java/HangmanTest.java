import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



class HangmanTest {

    @Test
    void getWordToGuess() {
        String wordToGuess = "game";
        Hangman game = new Hangman(wordToGuess);
        Assertions.assertEquals(wordToGuess, game.getWordToGuess());
    }

    @Test
    void getMistakesAllowed() {
        // Using the DEFAULT_MISTAKES_ALLOWED
        String wordToGuess = "game";
        Hangman game = new Hangman(wordToGuess);
        Assertions.assertEquals(5,game.getMistakesAllowed());

        // Using a custom number of mistakes allowed
        int numMistakesAllowed = 8;
        Hangman game2 = new Hangman(wordToGuess, numMistakesAllowed);
        Assertions.assertEquals(numMistakesAllowed, game2.getMistakesAllowed());
    }

    @Test
    void getNumberOfCorrectGuesses() {
        fail("Not Implemented.");
    }

    @Test
    void getNumberOfIncorrectGuesses() {
        fail("Not Implemented.");
    }

    @Test
    void getNumberOfGuesses() {
        fail("Not Implemented.");
    }

    @Test
    void guess() {
        fail("Not Implemented.");
    }

    @Test
    void guessWord() {
        fail("Not Implemented.");
    }

    @Test
    void guessLetter() {
        fail("Not Implemented.");
    }

    @Test
    void getCurrentGuessWordState() {
        fail("Not Implemented.");
    }

    @Test
    void isGameWon() {
        fail("Not Implemented.");
    }

    @Test
    void guessNotInAGuessList() {
        fail("Not Implemented.");
    }
}