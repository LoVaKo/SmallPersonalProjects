import java.util.ArrayList;
import java.util.Scanner;
public class Hangman {
    ArrayList<Character> secretWord;
    ArrayList<Character> secretWordBlank;
    int numAttempts;
    int round;
    ArrayList<Character> wrongGuesses;

    public Hangman(ArrayList<Character> secretWord) {
        this.secretWord = secretWord;
        this.secretWordBlank = new ArrayList<>();

        for (int i = 0; i < secretWord.size(); i++) {
            secretWordBlank.add('_');
        }
        this.numAttempts = 7;
        this.round = 1;
        this.wrongGuesses = new ArrayList<>();
    }

    // Getters
    public int getNumAttempts() {
        return numAttempts;
    }
    public int getRound() {
        return round;
    }
    public ArrayList<Character> getSecretWord() {
        return secretWord;
    }
    public ArrayList<Character> getSecretWordBlank() {
        return secretWordBlank;
    }
    public ArrayList<Character> getWrongGuesses() {
        return wrongGuesses;
    }

    // Game mechanics
    public static Hangman newGame(String secretWord) {
        ArrayList<Character> secretWordConverted = new ArrayList<>();
        for (char c : secretWord.toCharArray()) {
            secretWordConverted.add(c);
        }
        return new Hangman(secretWordConverted);
    }
    public void makeGuess(char guess) {
        boolean found = false;
        for(int i = 0; i < secretWord.size(); i++) {
            if (secretWord.get(i) == guess) {
                secretWordBlank.set(i, guess);
                found = true;
            }
        }
        if (!found) {
            System.out.println("You guessed wrong. Minus 1 attempt.");
            wrongGuesses.add(guess);
            numAttempts --;
        } else {
            System.out.println("You guessed right! The Secret Word is updated.");
        }
        round ++;
    }
    public void getGameStatus(){
        printHangman(getNumAttempts());
        System.out.println();
        System.out.println("============= Game status =============");
        System.out.println("Secret word     :   " + stringBuilder(secretWordBlank));
        System.out.println("Round           :   " + getRound());
        System.out.println("Attempts left   :   " + getNumAttempts());
        System.out.println("Wrong guesses   :   " + stringBuilder(wrongGuesses));
        System.out.println("=======================================");
    }
    public void printHangman(int numAttempts) {
        if (numAttempts == 7) {
            System.out.println("  +---+\n      |\n      |\n      |\n      |\n      |\n=========");
        } else if (numAttempts == 6) {
            System.out.println("  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========");
        } else if (numAttempts == 5) {
            System.out.println("  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========");
        } else if (numAttempts == 4) {
            System.out.println("  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========");
        } else if (numAttempts == 3) {
            System.out.println("  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========");
        } else if (numAttempts == 2) {
            System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========");
        } else if (numAttempts == 1) {
            System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========");
        } else if (numAttempts == 0){
            System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========");
        }
    }


    // Support methods
    public static boolean isValidWord(String secretWord) {
        // Secret Word must be between 3 and 12 characters long.
        int length = secretWord.toCharArray().length;
        if (length < 3 || length > 12) return false;

        // Secret word must contain lower case only
        for(char ch : secretWord.toCharArray()) {
            if(!Character.isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }

    public String stringBuilder(ArrayList<Character> characterArrayList) {
        StringBuilder sb = new StringBuilder(characterArrayList.size());
        for (Character ch : characterArrayList) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        boolean letsPlay = true;
        Scanner scanner = new Scanner(System.in);

        while (letsPlay) {
            // Setting up the new game
            System.out.println("""
                    Welcome to Hangman!
                    Let's start a new game.
                    Player 1, please enter the secret word.""");

            String secretWord = scanner.nextLine();
            while (!isValidWord(secretWord)) {
                System.out.println("The secret word must contain only lowercase letters and have a length between 3 and 12 characters. Please enter again.");
                secretWord = scanner.nextLine();
            } // Checking if the secretWord is valid.

            Hangman game = newGame(secretWord);

            for (int i = 0; i < 30; i++) {
                System.out.println();
            } // Clearing screen

            while (true) {
                // Provide Game Status
                game.getGameStatus();
                System.out.println();

                // make a guess
                System.out.println("Player 2, make a guess");
                String userInput = scanner.nextLine();
                char guess = userInput.charAt(0);
                game.makeGuess(guess);

                // conclude game
                if (game.secretWord.equals(game.secretWordBlank)) {
                    System.out.println(game.secretWord);
                    System.out.println("\nCongratulations! You won the game.");
                    break;
                }
                if (game.getNumAttempts() == 0) {
                    System.out.println("\nYou ran out of attempts. Game lost.");
                    game.printHangman(game.getNumAttempts());
                    break;
                }
            }

            // Play again?
            System.out.println("\nWould you like to play again? [y/n]");
            String userInput2 = scanner.nextLine();
            if (userInput2.equalsIgnoreCase("n")) letsPlay = false;
        }
    }
}