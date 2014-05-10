package CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InBetweenGame {
	
	public DeckofCards dc;
	
	public InBetweenGame() {
		dc = new DeckofCards();
		dc.shuffle();
	}
	
	public void startGame() throws NumberFormatException, IOException {
		int choice = -1;
		
		System.out.println("****************************************");
		System.out.println("Game Rule:\nYou and your opposite will get a random card");
		System.out.println("bet whether next card will be in or out of [your card (inclusive), oppostie's card(inclusive)]");
		System.out.println("****************************************");
		Card myCard = dc.dealCard();
		System.out.println("Your card is \"" + myCard + "\"");
		System.out.println("Guess next cards will be \n1. BETWEEN your card rank and opposite's card rank \n2. OUT of your card rank and opposite's rank \n3. QUIT");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		choice = Integer.parseInt(br.readLine());
		
		while (choice != 1 && choice != 2 && choice != 3) {
			System.out.println("Please type in right number 1-3");
			choice = Integer.parseInt(br.readLine());
		}
		
		while (choice != 3) {
			Card opponentCard = dc.dealCard();
			Card nextCard = dc.dealCard();
			
			int min = Math.min(myCard.getRank(), opponentCard.getRank());
			int max = Math.max(myCard.getRank(), opponentCard.getRank());
			
			System.out.println("Your opponent's card is \"" + opponentCard + "\"");
			System.out.println("Next card is \"" + nextCard + "\"");
			
			if ( (choice == 1 && ( nextCard.getRank() >= min && nextCard.getRank() <= max) ) 
				|| (choice == 2 && !(nextCard.getRank() >= min && nextCard.getRank() <= max)) ){
				
				System.out.println("You Win!\n");
				
			}
			else {
				System.out.println("You Lose!\n");
			}
			
			myCard = dc.dealCard();
			System.out.println("Your card is \"" + myCard + "\"");
			System.out.println("Guess next cards will be \n1. BETWEEN your card rank and opposite's card rank \n2. OUT of your card rank and opposite's rank \n3. QUIT");
			choice = Integer.parseInt(br.readLine());
			
			while (choice != 1 && choice != 2 && choice != 3) {
				System.out.println("Please type in right number 1-3");
				choice = Integer.parseInt(br.readLine());
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		InBetweenGame ib = new InBetweenGame();
		ib.startGame();
	}
	
}
