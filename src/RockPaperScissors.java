import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class RockPaperScissors {

    // Game messages
    public static final String
        WELCOME_MESSAGE = "Welcome to rock paper scissors!",
        CHOICE_MESSAGE = "Please choose your weapon for this round! \n 1 - Rock, 2 - Paper, 3 - Scissors",
        GAME_START_MESSAGE = "Please select the number of rounds you would like to play",
        GAME_END_MESSAGE = "Thank you for playing, if you want to play again, type 1.",
        ROUND_WIN_MESSAGE = "You won this round!",
        ROUND_TIE_MESSAGE = "You tied this round!",
        ROUND_LOSS_MESSAGE = "The computer won this round!",
        GAME_WIN_MESSAGE = "The player won this game!",
        GAME_TIE_MESSAGE = "The game ended in a tie!",
        GAME_LOSS_MESSAGE = "The computer won this game!";

    public static final int
        MAX_ROUNDS = 10,
        MIN_ROUNDS = 1;

    public static final ArrayList<String> CHOICE_LIST = new ArrayList<>(Arrays.asList("Rock", "Paper", "Scissors"));

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);

        Scanner s = new Scanner(System.in);
        startGame(s);
    }


    public static void startGame(Scanner s){
        // Set round variables
        int roundCount = 0;

        // Get the number of rounds the user wants to play
        int numRounds = promptInt(GAME_START_MESSAGE, s);

        if(numRounds < MIN_ROUNDS || numRounds > MAX_ROUNDS){
            throw new IllegalArgumentException("Choose an appropriate number of rounds next time. I will now stop running");
        }

        // declare tracker variables for round outcomes
        int playerWinCount = 0,
            tieCount = 0,
            computerWinCount = 0;

        while(roundCount < numRounds){
            int playerChoice = promptInt(CHOICE_MESSAGE, s);

            if(playerChoice < 1 || playerChoice > 3){
                System.out.printf("Please write an integer between 1-3");
                continue;
            }
            Random random = new Random();
            int computerChoice = random.nextInt(1,3+1);

            // Determine the outcome based on the two choices
            int winner = determineWinner(playerChoice, computerChoice);

            // Add one point to the score of the round-outcome
            if(winner == 1){
                playerWinCount += 1;
                System.out.println(ROUND_WIN_MESSAGE);
                System.out.println("You played: " + CHOICE_LIST.get(playerChoice - 1));
                System.out.println("Computer played: " + CHOICE_LIST.get(computerChoice - 1));
            }
            else if(winner == 0){
                tieCount += 1;
                System.out.println(ROUND_TIE_MESSAGE);
                System.out.println("You played: " + CHOICE_LIST.get(playerChoice - 1));
                System.out.println("Computer played: " + CHOICE_LIST.get(computerChoice - 1));
            }
            else if(winner == -1) {
                computerWinCount += 1;
                System.out.println(ROUND_LOSS_MESSAGE);
                System.out.println("You played: " + CHOICE_LIST.get(playerChoice - 1));
                System.out.println("Computer played: " + CHOICE_LIST.get(computerChoice - 1));
            }
            else{
                throw new RuntimeException("Round ended with no winner");
            }
            // Increment the round counter
            roundCount++;
            System.out.println();
        }
        // Find the win outcome and select the appropriate outcome message
        String gameOutcome = playerWinCount > computerWinCount ?  GAME_WIN_MESSAGE : GAME_LOSS_MESSAGE;
        if(playerWinCount == computerWinCount) gameOutcome = GAME_TIE_MESSAGE;

        // Call on the method to print the outcome to the user
        printOutCome(gameOutcome, playerWinCount, tieCount, computerWinCount);

        // Restart if player wants to play again
        int playAgain = promptInt(GAME_END_MESSAGE, s);
        if (playAgain == 1){
            startGame(s);
        }
    }


    /**
     * @param playerChoice rock = 1, paper = 2, scissors = 3
     * @return - integer to determine who won: player = 1, tie = 0, computer = -1
     */
    public static int determineWinner(int playerChoice, int computerChoice){
        // Check if there is a tie
        if(computerChoice == playerChoice) return 0;

        // Check if computer chose the weaker option
        // if true - player win, otherwise the computer has won
        switch(playerChoice){
            case 1:
                return computerChoice == 3 ? 1 : -1;

            case 2:
                return computerChoice == 1 ? 1 : -1;

            case 3:
                return computerChoice == 2 ? 1 : -1;

            default:
                throw new IllegalArgumentException("Choice was not one of the existing options");
        }
    }

    /**
     * Generates a number between 1-3 and returns it
     * @return number between 1-3
     */
    public static int generateComputerGuess(){
        Random random = new Random();
        return random.nextInt(1,3+1);
    }

    /**
     * Prompts the user to write an integer
     * @param promptMessage - Message that appears to the user
     * @param scanner - Scanner to read input
     * @return - -1000
     */
    public static Integer promptInt(String promptMessage, Scanner scanner){
        Integer userInput = null;
        try{
            System.out.println(promptMessage);
            userInput = scanner.nextInt();
        }catch(Exception e){
            System.out.println("Please write a valid integer");
        }
        return userInput;
    }

    public static void printOutCome(String outcome, int playerWins, int tieCount, int computerWins)
    {
        System.out.println(outcome);
        System.out.println("Player won:" + playerWins + " times" + "\n" +
                          "Computer won: " + computerWins + " times" + "\n" +
                          "There were: " + tieCount + " ties");
    }
}
