import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, please enter a word to guess for player 2: ");
        String wordToGuess = scanner.nextLine();
        if (wordToGuess.isEmpty() || wordToGuess.isBlank()) {
            System.out.println("Input was empty, terminating program!");
            System.exit(0);
        }
        else
            System.out.println(wordToGuess);

        Hangman game = new Hangman(wordToGuess);
    }
}