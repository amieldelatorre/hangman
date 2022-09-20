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
        while (game.getNumberOfIncorrectGuesses() < Hangman.DEFAULT_MISTAKES_ALLOWED && !guessedCorrectly) {
            System.out.println("Player 2, please guess a letter or a word: ");
            guessWord = scanner.nextLine();
            guessedCorrectly = game.guess(guessWord);
        }
    }
}