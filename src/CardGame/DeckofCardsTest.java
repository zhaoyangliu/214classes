package CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class DeckofCardsTest {
	StringBuffer outFile = new StringBuffer();
	int SHUFFLE_TIME = 10;
	int DEAL_TIME = 110;
	DeckofCards dc = new DeckofCards();
	boolean shufflePass = true;
	boolean dealPass = true;
	boolean cardsLeftPass = true;
	boolean dealShuffle = true;
	
	/**
	 * Test whether shuffle method gives a complete set of cards.
	 * Deal a given number of cards, this function checks following: 
	 * 1. Whether it automatically shuffles when empty.
	 * 2. When dealing 52 cards, make sure they can consist a whole set.
	 * 3. Check at any time cardsLeft() gives right number.
	 */
	public void testShuffle() {
		outFile.append("\n***********************************************************\n");
		outFile.append("* Test the completeness of a deck of cards *\n");
		outFile.append("***********************************************************\n");
		for (int i = 1; i <= SHUFFLE_TIME; i++) {
			dc.shuffle();
			if (dc.isComplete())
				outFile.append("Shuffle " + i + ": Successed\n");
			else {
				outFile.append("Shuffle " + i + ": Failed\n");
				shufflePass = false;
			}
		}
	}
	/*
	 * Deal a given number of cards, this function checks following: 
	 * 1. Whether it automatically shuffles when empty.
	 * 2. When dealing 52 cards, make sure they can consist a whole set.
	 * 3. Check at any time cardsLeft() gives right number.
	 */
	public void testDealCard() {
		int[] set = new int[52];
		int[] lastSet = new int[52];
		
		outFile.append("\n***********************************************************\n");
		outFile.append("* Test dealCard and cardsLeft method with " + DEAL_TIME + " times deal *\n");
		outFile.append("***********************************************************\n");
		
		for (int i = 1; i <= DEAL_TIME; i++) {
			Card tmp = dc.dealCard();
			set[(i - 1) % 52] = tmp.getRank() * 4 + tmp.getSuit() - 4; 
			int cardsLeft = dc.cardsLeft();
			if (cardsLeft != 51 - (i - 1) % 52)
				cardsLeftPass = false;
			if (i % 52 == 0) {
				if (i == 52) {
					lastSet = set;
				}
				else {
					if (Arrays.equals(lastSet, set)) {
						dealShuffle = false;
						outFile.append("Error: cards not shuffled when dealt empty\n");
						lastSet = set;
					}
				}

				Arrays.sort(set);
				for (int j = 1; j <= 52; j++) {
					if (set[j - 1] != j) 
						dealPass = false;
				}
				
				set = new int[52];
				if (dealPass == false) {
					outFile.append("Error: dealCard() not includes whole set at round " + i/52 + ". ");
				}
				else {
					outFile.append("dealCard() includes whole set at round " + i/52 + ".  ");
					dealPass = true;
				}
				if (cardsLeftPass == true) {
					outFile.append("cardsLeft() have right output at round " + i/52 + "\n");
				}
				else {
					outFile.append("Error: cardsLeft() don't have right output at round " + i/52 + " \n");
					cardsLeftPass = true;
				}
			}
		}
		
	}
	
	
	/**
	 * Initialize the testing and get input of shuffle time and deal time.
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void initTest() throws NumberFormatException, IOException {
		System.out.println("Input a number to test how many times of shuffles: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SHUFFLE_TIME = Integer.parseInt(br.readLine());
		System.out.println("Input a number to indicate how many cards will be dealt: ");
		DEAL_TIME = Integer.parseInt(br.readLine());
	}
	
	public static void main(String[] args) throws IOException {
		
		DeckofCardsTest dct = new DeckofCardsTest();
		
		dct.initTest();
		dct.testShuffle();
		dct.testDealCard();
		System.out.println(dct.outFile.toString());
	}
}
