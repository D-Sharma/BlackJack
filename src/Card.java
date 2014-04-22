/*
 * Implements a card
 */
public class Card {
	
	/*
	 * This holds the value of the card.
	 * Jack, queen, and king, all have a rank of 10.
	 * Ace can have a value of 1 or 11.
	 */
	private int rank;
	private Suit suit;
	private String face;
	
	public Card(int rank, Suit suit, String face)
	{
		this.rank = rank;
		this.suit = suit;		
		this.face = face;
	}
	
	public Card()
	{
		
	}
	
	public int getRank()
	{
		return rank;
	}
	
	/**
	 * This method overrides toString method, it returns the card details as string 
	 * @return
	 */
	@Override
	public String toString()
	{
		String str = "";
		try
		{
			str = this.suit.name() + " " + this.face + " " + this.rank;
			return str;
		}
		catch(Exception ex)
		{
			System.out.println("An execption occured");
			System.out.println(ex.getMessage());
		}
		finally
		{
			str = "";
		}
		return str;
	}

}
