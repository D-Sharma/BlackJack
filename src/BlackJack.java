/*
 * This class implements BlackJack game with player and dealer.
 */
public class BlackJack 
{
	private Hand player;
	private Hand dealer;
	private Deck deck;
	
	/**
	 * This method is a constructor.
	 * It initializes an object of BlackJack class
	 * @param player
	 * @param dealer
	 */
	public BlackJack (Hand player, Hand dealer)
	{
		this.player = player;
		this.dealer = dealer;
		this.deck = new Deck();		
	}
	
	/**
	 * This method initializes cards in hand and bet for each player of the game.
	 * @param playerBet     //User inputs bet for blackjack game
	 * @return
	 */
	public boolean NewGame(int playerBet)
	{
		
		boolean result = false;
		try
		{		
			//The dealer bets the same at the player. 
			int dealerBet = playerBet;
			
			if(setNewGame())
			{
				player.setBet(playerBet);
				dealer.setBet(dealerBet);
				result = true;
			}
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured while initializing new game");
			System.out.println(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * This method creates new set of game.
	 * It draws 2 cards each for player and dealer respectively.
	 * @return
	 */
	private boolean setNewGame()
	{
		boolean result = false; 
		try
		{
			//Get two cards for player
			player.AddCard(deck.DrawCard());
			player.AddCard(deck.DrawCard());
			
			//Get two cards for dealer
			dealer.AddCard(deck.DrawCard());
			dealer.AddCard(deck.DrawCard());
			
			result = true;
		}
		catch(Exception ex)
		{
			System.out.println("An error occured while setting initializing new game");
			System.out.println(ex.getMessage());
		}
		
		return result;
		
	}
	
	/**
	 * This method implements hit action. 
	 * The action hit, draws a new card from the deck and adds it to the existing list of cards. 
	 */
	public void Hit()
	{
		try
		{
			player.AddCard(deck.DrawCard());
		}
		catch(Exception ex)
		{
			System.out.println("An error occured when playing hit.");
			System.out.println(ex.getMessage());
		}		
	}
		
	/**
	 * This method plays on behalf of the dealer.
	 * The dealer plays hit until its hand value is less than 17
	 * @return
	 */
	public boolean dealerPlays()
	{		
		boolean result = false;
		try
		{
			//Deal will hit if hand value is less than 17 
			if(dealer.getValue() < 17)
			{
				dealer.AddCard(deck.DrawCard());
				System.out.println("Dealer successfully plays hit.");
				showCards(dealer);
				result = false;
			}
			else
				result = true;
		}
		catch(Exception ex)
		{
			System.out.println("An error occured when dealer tries to play.");
			System.out.println(ex.getMessage());
		}	
		return result;
	}
	
	/**
	 * This method calculates the winner of the game.
	 * The goal for the player is to obtain cards of value 21 or higher than the dealer.
	 * @return
	 */
	public String getWinner()
	{
		String result = "";
		
		try
		{							
			if(player.getValue() < dealer.getValue() && dealer.getValue() <=21)
			{
				result = "Dealer wins";
				player.lostBet();
			}			
			else if(player.getValue() == dealer.getValue() && player.getValue() <= 21)
			{
				result = "Push, its a draw. Dealer wins";
			}
			else 
			{
				result = "Player wins.";
				player.winBet();
			}			
		}		
		catch(Exception ex)
		{
			System.out.println("An error occured calculating winner");
			System.out.println(ex.getMessage());
		}
		
		return result;
	}
	
	/**
	 * This method calculates sum of values of cards on hand. 
	 * If the sum is greater than 21 then the hand is busted
	 * @return Returns whether hand is busted
	 */
	public boolean isBusted(Hand hand)
	{
		boolean result = true;
		
		try
		{
			if(hand.getValue() > 21)			
				result = true;				
			else
				result = false;
		}		
		catch(Exception ex)
		{
			System.out.println("An error occured while setting initializing new game");
			System.out.println(ex.getMessage());
		}
		
		return result;
		
	}
	
	/**
	 * This method checks if the player has a black jack
	 * @return
	 */
	public boolean isBlackJack(Hand hand)
	{
		boolean result = false;
		
		try
		{
			if(hand.getValue() == 21)			
				result = true;				
			else
				result = false;
		}		
		catch(Exception ex)
		{
			System.out.println("An error occured while setting initializing new game");
			System.out.println(ex.getMessage());
		}
		
		return result;
		
	}
	
	/**
	 * This methods displays value of all cards as string
	 * @param hand
	 * @return
	 */
	public void showCards(Hand hand)
	{			
		try
		{
			System.out.println(hand.getName() + " cards:");
			
			for(Card card : hand.cards)
			{
				System.out.println(card.toString());			
			}
			System.out.println("Total hand value is " + hand.getValue());
			System.out.println();
		}
		catch(Exception ex)
		{
			System.out.println("An error occured while generating string value of cards");
			System.out.println(ex.getMessage());
		}	
				
	}

}
