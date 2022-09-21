import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();

        System.out.println("Player 1, please enter a word to guess for player 2: ");
        char[] charsToGuess;
        if (console == null)
            charsToGuess = scanner.nextLine().toCharArray();
        else
            charsToGuess = console.readPassword();
        String wordToGuess = String.valueOf(charsToGuess);
        if (wordToGuess.isEmpty() || wordToGuess.isBlank()) {
            System.out.println("Input was empty, terminating program!");
            System.exit(0);
        }
        else
            System.out.println(wordToGuess);

        Hangman game = new Hangman(wordToGuess);

        String guessWord;
        boolean guessedCorrectly = false;
        while (game.getNumberOfIncorrectGuesses() < game.getMistakesAllowed() && !game.isGameWon()) {
            System.out.println("Player 2, please guess a letter or a word: ");
            guessWord = scanner.nextLine();
            if (game.guessNotInAGuessList(guessWord))
                game.guess(guessWord);
            else
                System.out.println("This has already been guessed and will not be counted as an attempt, please try again!");

            System.out.println("Word progress: " + game.getCurrentGuessWordState());
        }
        System.out.println("Game won? " + game.isGameWon());
    }
}