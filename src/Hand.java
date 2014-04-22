import java.util.ArrayList;
import java.util.List;

/*
 * @author Dimple Sharma
 * This class implements a hand of the blackjack game
 */
public class Hand 
{
	/*
	 * Contains the name of the player. 
	 */
	private String name;
	
	/*
	 * A player starts with two cards.
	 */
	public List<Card> cards;
	
	/*
	 * Contains number of chips the player has.
	 * A player can start playing with minimum 100 chips.
	 */
	private int chips;
	
	/*
	 * Contains value of the cards at hand
	 */
	private int value;
	
	/*
	 * Contains bet value of the current hand.
	 */
	private int bet;
		
	/*
	 * This is a constructor which initializes an object of the class hand.
	 */
	public Hand(int chip, String name)
	{
		try
		{
			cards = new ArrayList<Card>();		
			this.chips = chip;		
			this.name = name;
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * This method adds card to the hand
	 * @param card
	 * @return
	 */
	public boolean AddCard(Card card)
	{
		boolean result = false;

		try
		{		
			if(card != null)
			{
				cards.add(card);
				result = true;
			}
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}

		return result;
	}
	
	/*
	 * This method resets the hand
	 */
	public void Reset()
	{
		try
		{
			cards.clear();
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}
	}
	
	/*
	 * This method returns the total value of cards of the hand of the blackjack game.
	 */
	public int getValue()
	{
		int value = 0;
		try
		{
			for(Card card: cards)
			{
				value += card.getRank();			
			}
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}
		return value;
	}
	
	/**
	 * This method gets card on index from list of cards on hand
	 * @param index
	 * @return
	 */
	public String getCard(int index)
	{
		String result = "";
		try
		{
			result = cards.get(index).toString();
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * Displays cards as string value.
	 * @return
	 */
	public String ShowCards()
	{
		String show = "";
		
		try
		{
			
			for(Card card : this.cards)
			{
				show += card.toString() + System.getProperty("line.separator");			
			}
		
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured while setting bet");
			System.out.println(ex.getMessage());
		}
		
		return show;
		
	}
	
	/**
	 * this method initializes bet for the hand.
	 * @param bet
	 */
	public void setBet(int bet)
	{
		try
		{
			this.bet = bet;
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured while setting bet");
			System.out.println(ex.getMessage());
		}		
	}
	
	/**
	 * This method deducts bet from chips, when hand loses the black jack game.
	 */
	public void lostBet()
	{
		try
		{
			this.chips -= this.bet;
			System.out.println(this.name + " lost bet, total chips remaining " + this.chips);
			this.bet = 0; //reset bet
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured while setting bet");
			System.out.println(ex.getMessage());
		}	
	}
	
	/**
	 * This method adds bet to the chip, when hand wins the black jack game.
	 */
	public void winBet()
	{
		try
		{
			this.chips += this.bet;			
			System.out.println(this.name + " wins bet, total chips on hand " + this.chips);
			this.bet = 0; // reset bet
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured while setting bet");
			System.out.println(ex.getMessage());
		}	
	}
	
	/**
	 * This method returns chips remaining for the hand.
	 * @return
	 */
	public int getChipValue()
	{
		int result = 0;
		try
		{
			result = this.chips;
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured while setting bet");
			System.out.println(ex.getMessage());
		}
		
		return result;
	}
	
	/**
	 * This method returns the name of the hand.
	 * @return
	 */
	public String getName()
	{
		String result = "";
		try
		{
			result = this.name;
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured.");
			System.out.println(ex.getMessage());
		}
		return result;
	}

}
