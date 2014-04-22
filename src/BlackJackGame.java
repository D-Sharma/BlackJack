import java.util.Scanner;

/**
 * This class implements a console game black jack.
 * @author Dimple
 *
 */
public class BlackJackGame {
	
	public static Hand player;
	public static Hand dealer;
	public static BlackJack blackJack;
	
	public static void main(String[] args) {
				
		player = new Hand(100, "Player");	//BlackJack hand for player who starts playing with 100 chips		
		dealer = new Hand(1000, "Dealer");    //Blackjack hand for dealer who starts playing with 1000 chips
		
		blackJack = new BlackJack(player, dealer);	//Creates instance of BlackJack game object
		
		System.out.println("Welcome to BlackJack!");
		
		//Begin to play BlackJack!
		beginBlackJack();
		
		//Exit the game
		System.out.println("Thank you for playing blackjack.");		
	}
	
	/**
	 * This method begins the black jack game.
	 * It initializes black jack game, player, and dealer.
	 */
	public static void beginBlackJack()
	{
		try
		{
			//Request user to enter bet value for current game
			int bet = getPlayerBet();
			if(bet < 1 || bet > 20 )
				return;
			
			//Blackjack game creates hands for player and dealer, and sets bet
			blackJack.NewGame(bet);
			
			System.out.println();
			blackJack.showCards(player);
			blackJack.showCards(dealer);
			
			boolean isPlayerPlaying = false;
			boolean isDealerPlaying = false;
			
			//Continue to play the game until both player and dealer have stopped drawing new cards.
			while(!isPlayerPlaying || !isDealerPlaying)
			{
				
				if(!isPlayerPlaying)
				{
					isPlayerPlaying = playerPlays();
					
					//If player the total hand value of player is greater than 21. The player is busted.
					//If player loses, deduct bet and end the game.
					if(blackJack.isBusted(player))
					{
						System.out.println("Player loses");
						isDealerPlaying = true;
						player.lostBet();
						return;
					}
					//Check if player got a blackjack
					else if(blackJack.isBlackJack(player))
					{
						System.out.println("A perfect 21! Player has a blackjack!");
					}
						
				}
				
				//Deal continues to play hit unless dealer's hand value is 17 or greater.
				if(!isDealerPlaying)
				{
					isDealerPlaying = dealerPlays();
				}		
				
			}	
			
			//Calculate the winner of the blackjack game.
			String result = blackJack.getWinner();
			System.out.println(result);
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}

	}
	
	/**
	 * This method returns whether a hand has Blackjack hand value of 21
	 * @return
	 */
	private static boolean isBlackJack(Hand hand)
	{
		boolean result = false;
		try
		{		
			if(blackJack.isBlackJack(hand))
			{
				result = true;
				System.out.println("You have a BlackJack");
			}
		}
		catch(Exception ex)
		{
			System.out.println("An Exception occured");
			System.out.println(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * This method implements dealers playing strategy.
	 * The dealer continues to play hit until dealer's total hand value is 17 or greater.
	 * @return
	 */
	private static boolean dealerPlays()
	{
		boolean result = false;
		try
		{
			result = blackJack.dealerPlays();			
			
		}
		catch(Exception ex)
		{
			System.out.println("An Exception occured");
			System.out.println(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * This method implements players playing strategy.
	 * The player continues to play hit until its total hand value is 21 or lesser.
	 * @return
	 */
	private static boolean playerPlays()
	{
		boolean result = false;
		try
		{
			
			System.out.println("Player, would you like to hit or stand?");
			System.out.println("Press 1 for hit or press 2 for stand");
			
			int input = new Scanner(System.in).nextInt();
		
			if(input == 1)			
			{
				blackJack.Hit();
				System.out.println("Player successfully  plays hit.");
				blackJack.showCards(player);
							
				if(blackJack.isBusted(player))
				{
					System.out.println("The player is busted. ");
					result = true;
				}				
				
				System.out.println("Player's hand value is " + player.getValue());
			}
			else
				result = true;
			
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());	
		}
		return result;
	}
	
	/**
	 * This methods get bet value from the user.
	 * @return
	 */
	private static int getPlayerBet()
	{
		int result = 0;
		try
		{			
			System.out.println("Enter bet between 1 to 20");		
			Scanner scanBet = new Scanner(System.in);
			result = scanBet.nextInt();				
			
		}
		catch(Exception ex)
		{
			System.out.println("An exception occured");
			System.out.println(ex.getMessage());
		}
		return result;
		
	}
	
}
