package CardGame;

public class Card {
	int rank = 0;
	int suit = 0;
	
	/** Constructor function that accept two integers to initialize rank and suit.
	 * 
	 * @param r parameter that will be passed to rank
	 * @param s parameter that will be passed to suit
	 */
	public Card(int r, int s) {
		rank = r;
		suit = s;
	}
	
	/** change the content of the card.
	 * 
	 * @param r parameter that will be passed to rank
	 * @param s parameter that will be passed to suit
	 */
	public void setCard(int r, int s) {
		rank = r;
		suit = s;
	}
	
	/** get the suit of the card
	 * 
	 * @author Zhaoyang Liu
	 * @return return the suit of the card
	 */
	public int getSuit() {
		return suit;
	}
	
	/** get the rank of the card
	 * 
	 * @author Zhaoyang Liu
	 * @return return the rank of the card
	 */
	public int getRank() {
		return rank;
	}
	
	/** Override the toString function so that the class would be format printed
	 *  
	 * @author Zhaoyang Liu
	 * @return String that contains the card information
	 */
	public String toString() {
		String rankString = "";
		String suitString = "";
		StringBuffer returnString = new StringBuffer();
		
		switch(rank) {
		case 1:
			rankString = "Ace";
			break;
		case 11:
			rankString = "Jack";
			break;
		case 12:
			rankString = "Queen";
			break;
		case 13:
			rankString = "King";
			break;
		default:
			rankString = String.valueOf(rank);
			break;
		}
		
		String[] suitArray = {"Clubs", "Diamonds", "Hearts", "Spades"};
		suitString = suitArray[suit - 1];
		
		returnString.append(rankString);
		returnString.append(" of ");
		returnString.append(suitString);
		
		return returnString.toString();
	}

	public static void main(String[] args) {
		Card tmpCard = new Card(1, 4);
		System.out.println(tmpCard.getSuit());
		System.out.println(tmpCard);
	}
	
}

