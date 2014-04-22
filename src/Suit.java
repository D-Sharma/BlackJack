/*
 * @author Dimple Sharma 04/16/2014
 * Implements enumeration for the type of suits in a deck of cards
 */
public enum Suit {
	
	DIAMOND (1),
	HEART(2),
	CLUB (3),
	SPADE (4);
	
	private int value;
	
	private Suit(int val)
	{
		this.value = val;		
	}
	
	private int getValue()
	{
		return value;			
	}
}
