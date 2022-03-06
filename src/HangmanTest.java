import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class HangmanTest {

	@Test
	void checkWord() {
		assertNotNull(Hangman.getWord());
	}
	
	@Test
	void correctWordGuessTest() {
		String guessedWord = "test";
		String actualWord = "test";
		List<Character> playerGuess = new ArrayList<Character>();	
		
		for (int i =0; i<guessedWord.length(); i++) {
			playerGuess.add(guessedWord.charAt(i));
		}
		
		assertTrue(Hangman.wordState(actualWord, playerGuess));		
	}
	
	@Test
	void incorrectWordGuessTest() {
		String guessedWord = "test czse";
		String actualWord = "test case";
		List<Character> playerGuess = new ArrayList<Character>();
		
		for (int i =0; i<guessedWord.length(); i++) {
			playerGuess.add(guessedWord.charAt(i));
		}
		
		assertFalse(Hangman.wordState(actualWord, playerGuess));
	}	
	 
	 @Test
		void playerCharacterGuessTest() {
			String word = "test case";
			String guess = "t";
			List<Character> playerGuesses = new ArrayList<Character>();	
			
			assertTrue(Hangman.playerGuess(guess, word, playerGuesses));	
		}
	 
	 @Test
		void guessWordTest() {
			String guessedWord = "test";
			String actualWord = "test";
			
			assertTrue(Hangman.guessWord(guessedWord, actualWord));
		}
	 
	 @Test
	 	void guessWrongWordTest() {
			String guessedWord = "tpst";
			String actualWord = "test";
			
			assertFalse(Hangman.guessWord(guessedWord, actualWord));
		}
	 @Test
		void gameOverTest() {
			assertEquals(Hangman.printMan(6), 1);
		}

}
