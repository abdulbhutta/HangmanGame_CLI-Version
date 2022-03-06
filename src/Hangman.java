import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.FileNotFoundException;

public class Hangman {
	
	//Get the word to guess from an array
	public static String getWord() {
		String words[] = {"abdul", "usman", "hello", "world", "blue", "green", "red"};
		String word;
		int randomNumber = 0;
		
		Random generator = new Random();
		randomNumber = generator.nextInt(words.length);
		word = words[randomNumber];
		
		return word;
	}

	//checks if the word contains the user guessed value
	static boolean playerGuess(String guess, String word, List<Character> playerGuesses) {
		boolean correct = false;
		
		playerGuesses.add(guess.charAt(0));
		correct = word.contains(guess);
		
		return correct;
	}

	//Check if the word characters have been guessed
	static boolean wordState(String word, List<Character> playerGuesses) {
		int correctGuesses = 0;
		
		//Go through each character and compare it to the actual word. If correct character, display it.
		for (int i=0; i<word.length(); i++) {
			if(playerGuesses.contains(word.charAt(i))) {
				System.out.print(word.charAt(i));
				correctGuesses++; 
			}
			else 
				System.out.print("-");
		} 
		System.out.println();

		//double check to make sure the word length matches the length of the guessed word
		return (word.length() == correctGuesses);
	}
		
	//Print out the hangman figure
	static int printMan(int wrongGuesses) {
		int gameOver = 0;
		
		System.out.println("==================");
		System.out.println("         |");
		
		if (wrongGuesses >= 1)
			System.out.println("         O");
		
		if (wrongGuesses >= 2)
			System.out.print("        \\ ");
		
		if(wrongGuesses >= 3)
			System.out.println("/");
		
		if (wrongGuesses >= 4)
			System.out.println("         |");
			
		if (wrongGuesses >= 5)
			System.out.print("        / ");
		
		if (wrongGuesses >= 6) {
			System.out.println("\\");
			gameOver = 1;
		}
		System.out.println();
		
		return gameOver;
	}
	
	public static boolean guessWord (String guessedWord, String word) {
		if(guessedWord.equals((word))) {
			return true;
		}
		
		return false;
	}
	
	//Main function
	public static void main(String[] args) throws FileNotFoundException {
		List<Character> playerGuesses = new ArrayList<Character>();	
		Scanner input = new Scanner(System.in); 
		String word;
		String userInput;
		String guessedWord;
		int wrongGuesses =0;
		int winner = 0;
		int gameOver = 0;
		boolean playerGuess;
		
		word = getWord();
		//System.out.println(word);
		System.out.println("Hangman\n");
		System.out.println("Welcome!");
		
		while(true) {
			System.out.println();
			gameOver = printMan(wrongGuesses);
			
			//The user lost
			if (gameOver == 1) {
				System.out.println("You have lost");
				break;
			}
			
			//If the user guessed all the correct characters
			if (wordState(word, playerGuesses) ) {
				System.out.println("Congratulation you won!!");
				break;
			}
			
			System.out.print("\nPlease enter a letter: ");
			String playerCharacterGuess = input.nextLine();
			System.out.println();			
			
			playerGuess = playerGuess(playerCharacterGuess, word, playerGuesses);
			
			//If player guessed wrong, increment the counter
			if (!playerGuess)
				wrongGuesses++;
			
			gameOver = printMan(wrongGuesses);
			wordState(word, playerGuesses);
			
			System.out.print("\nWould you like to guess the word? ");
			userInput = input.nextLine();
			
			//Make sure the user enters yes or no while checking if the word was correct
			while (true) {
				if (userInput.equals("yes") || userInput.equals("Yes")) {
					System.out.print("\nGuess the word: ");
					guessedWord = input.nextLine();
					if(guessWord(guessedWord, word) == true) {
						System.out.println("Congrats you won!");
						winner = 1;
						break;
					}
					
					//Wrong guess
					else {
						System.out.println("Wrong Guess! Please try again!");
						break;
					}
				
				//Break out of the loop if user enters no	
				}
				else if (userInput.equals("no") || userInput.equals("No")) {
					break;
				}
				//Error check to check whether the user entered yes or no
				else {
					System.out.print("Please enter only yes or no: ");
					userInput = input.nextLine();
					System.out.println();
				}
			}
			
			//If the user won, exit the game
			if (winner == 1)
				System.exit(0);
			
		}	
		//close input scanner
		input.close();
	}
}
 