/*
 * Author: Carlos Espinoza-Castro
 * Date: October 15th 2025
 * Purpose: To play a game of Rock-Paper-Scissors against the computer.
 */
import java.util.Scanner;

public class Roshambo {

	public static Scanner input = new Scanner(System.in);
	public static final String[] RPS = { "Quit", "Rock", "Paper", "Scissors" };
	
	public static void main(String[] args) {
		// Local variables
		int rounds = getRounds();
		int option;
		int computerOption;
		double playerScore = 0;
		double computerScore = 0;
		double winner;
		
		System.out.println("\n--- LET'S PLAY ROSHAMBO! ---\n");
		
		for (int i = 0; i < rounds; i++) {
			System.out.println("Round " + (i+1) + " of " + rounds);
			option = getPlayerOption();
			if (option == 0) {
				System.out.println("You quit the game.");
				break;
			}
			computerOption = getComputerOption();
			System.out.println("Computer chose: " + RPS[computerOption]);
			
			winner = determineWinner(option, computerOption);
			if (winner == 1) {
				System.out.println("You win the round!");
			} else if (winner == 0) {
				System.out.println("Computer wins the round!");
			} else {
				System.out.println("It's a tie!");
			}
			if (winner == 1) {
				playerScore++;
			} else if (winner == 0) {
				computerScore++;
			} else {
				playerScore += 0.5;
				computerScore += 0.5;
			}
			System.out.println();
		}
		System.out.println("\nFINAL SCORE:");
		System.out.println("Player: " + playerScore);
		System.out.println("Computer: " + computerScore);
		
		if (playerScore > computerScore) {
			System.out.println("You win the game!");
		} else if (computerScore > playerScore) {
			System.out.println("Computer wins the game!");
		} else {
			System.out.println("It's a tie overall!");
		}

	}
	
	//**** METHODS ****//
	
	// Prompts the user for the number of rounds and validates the input
	public static int getRounds() {
		int rounds;
		
		while (true) {
			System.out.print("Enter number of rounds (1-10): ");
			
			if (input.hasNextInt()) {
				rounds = input.nextInt();
				
				if (rounds >= 1 && rounds <= 10) {
					return rounds;
				} else {
					System.err.println("Error! Please enter a number from 1 to 10.");
				}
			} else {
				System.err.println("Error! Please enter a whole number.");
				input.next(); // clear invalid input
			}
		
		}
	}
	
	// Prompts the user to choose rock, paper, scissors, or quit
	public static int getPlayerOption() {
	    int option;

	    while (true) {
	        System.out.print("0 - Quit \n1 - Rock \n2 - Paper \n3 - Scissors \nChoose your fighter: ");

	        if (input.hasNextInt()) {
	            option = input.nextInt();

	            if (option >= 0 && option <= 3) {
	                return option;
	            } else {
	                System.err.println("Error! Please choose a number from 0 to 3.");
	            }
	        } else {
	            System.err.println("Error! Please enter a whole number.");
	            input.next(); // clears invalid input
	        }
	    }
	}
	
	// Randomly selects rock, paper, or scissors for the computer
	public static int getComputerOption() {
		return (int)(Math.random() * 3 + 1);
	}
	
	// Returns 1 if the player wins, 0 if the computer wins, and 0.5 for a tie
	public static double determineWinner(int playerOption, int computerOption) {
		double pScore;
		if (playerOption == computerOption) {
			pScore = 0.5;
		} else if (playerOption == 1 && computerOption == 2) {
			pScore = 0;
		} else if (playerOption == 2 && computerOption == 3) {
			pScore = 0;
		} else if (playerOption == 3 && computerOption == 1) {
			pScore = 0;
		} else  {
			pScore = 1;
		}
		
		return pScore;
	}
}
