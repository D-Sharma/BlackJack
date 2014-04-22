import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @author Dimple Sharma
 * Implements a deck of playing cards
 */
public class Deck {
	
	/*
	 * Global variables declaration
	 * Contains total number of cards in a deck.
	 */
	final static int SIZE = 52;
	
	/*
	 * 
	 */
	List<Card> cards;
	
	/*
	 * Number of cards remaining in the deck
	 */
	private int count;
	
	
	public Deck()
	{
		initializeDeck();
	}
	
	/*
	 * This method initializes the deck with cards. 
	 */
	private void initializeDeck()
	{
		try
		{
			cards = new ArrayList<Card>();
			for(Suit suit : Suit.values())
			{
				cards.add(new Card(11, suit, "Ace"));			
				cards.add(new Card(2, suit, "Two"));
				cards.add(new Card(3, suit, "Three"));
				cards.add(new Card(4, suit, "Four"));
				cards.add(new Card(5, suit, "Five"));
				cards.add(new Card(6, suit, "Six"));
				cards.add(new Card(7, suit, "Seven"));
				cards.add(new Card(8, suit, "Eight"));
				cards.add(new Card(9, suit, "Nine"));
				cards.add(new Card(10, suit, "Ten"));
				cards.add(new Card(10, suit, "Jack"));
				cards.add(new Card(10, suit, "Queen"));
				cards.add(new Card(10, suit, "King"));
				
			}
			
			count = Deck.SIZE;
			shuffle();	//Randomly shuffle all cards in the deck
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}

	}
	
	/*
	 * This methods randomly shuffles the cards in deck
	 * 
	 */
	private void shuffle()
	{
		int deckSize = cards.size();
		int swap = 0;
		Card card = new Card();
		
		//Generate random index number and swap values
		Random randomGenerator = new Random();
	    for (int i = 0; i < deckSize; i++)
	    {
	    	swap = randomGenerator.nextInt(deckSize);
	    	card = cards.get(i);
	    	cards.set(i, cards.get(swap));
	    	cards.set(swap, card);
	    	
	    }
	}
	
	/*
	 * This method gets the top card from the deck.
	 */
	public Card DrawCard()
	{
		Card card = new Card();
		try
		{
			//Draw a card from the deck
			card = cards.remove(0); 
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}		
		return card;
	}
	
	/*
	 * This method returns the number of cards left in the deck.
	 */
	public int Size()
	{
		int result = 0;
		try
		{
			count = cards.size();
			result = count;
		}		
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}
		
		return result;
	}

}
