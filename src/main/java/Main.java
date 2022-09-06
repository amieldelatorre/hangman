import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word to guess: ");
        String wordToGuess = scanner.nextLine();
        if (wordToGuess.isEmpty() || wordToGuess.isBlank())
            System.out.println("Empty String");
        else
            System.out.println(wordToGuess);
    }
}