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
	public static void main(String[] args) throws FileNotFoundException {
	        
		Scanner input = new Scanner(System.in); 
		
		String words[] = {"Abdul", "Usman", "Hello", "World", "blue", "green", "red"};
		String word;
		Random generator = new Random();
		
		int wrongGuesses =0;
		int randomNumber = generator.nextInt(words.length);
		
		word = words[randomNumber];
		//System.out.println(word);
		System.out.println(word);
		
		List<Character> playerGuesses = new ArrayList<Character>();		
		wordState(word, playerGuesses);
		
		while(true) {
			hangedMan(wrongGuesses);
			
			if (wrongGuesses >= 6) {
				System.out.println("You have lost");
				break;
			}
			
			if (!playerGuess(input, word, playerGuesses))
						wrongGuesses++;
			
			if ( wordState(word, playerGuesses) ) {
				System.out.println("Congratulation you won!!");
				break;
			}
			
			
			/*System.out.println("Would you like to guess the word? ");
			if(input.nextLine().equals((word))) {
				break;
			}
			else 
				System.out.println("Wrong word, please try again.");*/
		}		
	}

	private static void hangedMan(int wrongGuesses) {
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
		
		if (wrongGuesses >= 6)
			System.out.println("\\");
		
		System.out.println();
	}

	private static boolean playerGuess(Scanner input, String word, List<Character> playerGuesses) {
		System.out.println();
		System.out.print("Please enter a letter: ");
		String playerCharacterGuess = input.nextLine();
		System.out.println();
		playerGuesses.add(playerCharacterGuess.charAt(0));
		
		return word.contains(playerCharacterGuess);
		
		//wordState(word, playerGuesses);
	}

	private static boolean wordState(String word, List<Character> playerGuesses) {
		int correctGuesses = 0;
		
		for (int i=0; i<word.length(); i++) {
			if(playerGuesses.contains(word.charAt(i))) {
				System.out.print(word.charAt(i));
				correctGuesses++;
			}
			else 
				System.out.print("-");
		} 
		System.out.println();
		return (word.length() == correctGuesses);
	}

}
 