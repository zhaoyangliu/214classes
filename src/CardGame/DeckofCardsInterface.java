package CardGame;

public interface DeckofCardsInterface {
	
	/**
	 * shuffles the deck of cards and resets deal to beginning of deck
	 */
	public void shuffle();
	
	/**
	 * returns number of undealt cards
	 * @return number of undealt cards
	 */
	public int cardsLeft();

	/**
	 * if all cards dealt. shuffle cards, returns next card.
	 * @return next card
	 */
	public Card dealCard();

	/**
	 * return a string representing the entire deck of cards
	 * @return a string representing the entire deck of cards
	 */
	public String toString();
}
