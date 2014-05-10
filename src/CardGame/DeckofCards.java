package CardGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class DeckofCards implements DeckofCardsInterface {

	private Card[] cards = new Card[52];
	private int dealt = 0;
	
	public DeckofCards() {
		int m = 0;
		for (int i = 1; i <= 13; i++) {
			for (int j = 1; j <= 4; j++) {
				cards[m++] = new Card(i, j);
			}
		}
		dealt = 0;
	}
	
	/**
	 * Use random number to shuffle cards.
	 */
	@Override 
	public void shuffle() {
		Stack<Integer> cardSet = new Stack<Integer>();
		for (int i = 1; i <= cards.length; i++) {
			cardSet.add(i);
		}
		dealt = 0;
		Random r = new Random();
		for (int i = 1; i <= cards.length; i++) {
			int rand = r.nextInt(53 - i);
			int num = cardSet.get(rand);
			int rank = num % 13 + 1;
			int suit = num % 4 + 1;
			cards[i-1].setCard(rank, suit);
			cardSet.remove(rand);
		}
	}

	public boolean isComplete() {
		int[] set = new int[52];
	
		for (int i = 0; i < cards.length; i++) {
			set[i] = (cards[i].getRank() * 4 + cards[i].getSuit() - 4);
		}
		
		Arrays.sort(set);
		for (int i = 0; i < 52; i++) {
			if (set[i] != i + 1)
				return false;
		}
		return true;
	}
	
	
	/**
	 * Override the toString function. When print out, one card per line.
	 * @return String content to the whole deck of cards.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Card c : cards) {
			sb.append(c);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * @return number of undealt cards
	 */
	@Override
	public int cardsLeft() {
		return 52 - dealt;
	}
	
	/**
	 * if all cards dealt. shuffle cards, returns next card
	 * @return next card
	 */
	@Override
	public Card dealCard() {
		if (dealt == cards.length) {
			shuffle();
		}
		return cards[dealt++];
	}
	
	
	public static void main(String[] args) {
		DeckofCards dc = new DeckofCards();
		dc.shuffle();
		System.out.println(dc);
	}
}
