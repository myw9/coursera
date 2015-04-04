package CTCI.Blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import CTCI.Cards.Suit;

public class Main {

	private static final int MIN_PLAYERS = 1;
	private static final int MAX_PLAYERS = 4;
	private static BlackJackGame game = null;
	
	public static void main(String[] args) throws Exception {		
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		boolean continueLoop;
		
		// Print welcome message
		System.out.println("=== Java BLACKJACK ===");
				
		// Ask for player names
		continueLoop = true;
		while (continueLoop)
		{
			String playerMessage = String.format("Enter player names (%d-%d player, comma delimited): ", MIN_PLAYERS, MAX_PLAYERS);
			System.out.print(playerMessage);
			String playerNames = bufferedReader.readLine();
			String[] playerNamesSplit = playerNames.split("\\s*,\\s*");
			if (playerNames.equals("")|| playerNamesSplit.length < MIN_PLAYERS || playerNamesSplit.length > MAX_PLAYERS)
			{
				System.out.println("Invalid Number of Players");
				continue;
			}
			else
			{
				game = new BlackJackGame(new ArrayList<String>(Arrays.asList(playerNamesSplit)));
				for (BlackJackPlayer player : game.getPlayers())
				{
					System.out.println("Added Player: " + player.getName());
				}				
				continueLoop = false;
			}
		}
		
		// Shuffle and Deal cards
		System.out.println("");
		System.out.println("=== DEAL CARDS ===");
		game.shuffleDeck();
		game.dealCards();
		printGameState();		
		
		// Iterate through player's turns
		boolean continueTurn;
		for (BlackJackPlayer player : game.getPlayers())
		{
			System.out.println("");
			String message = String.format("=== %s's TURN ===", player.getName());
			System.out.println(message);
			System.out.println(player.toString());
			continueTurn = true;
			while (continueTurn)
			{
				System.out.print("Hit (H), Stand (S): ");
				String action = bufferedReader.readLine();
				// Do action
				if (action.equals("H"))
				{
					game.Hit(player, player.getHands().get(0));
					System.out.println(player.toString());
				}
				else if (action.equals("S"))
				{
					continueTurn = false;
				}
				else
				{
					continue;
				}
				
				if (player.getIsBust())
				{
					System.out.println(String.format("%s BUSTED!", player.getName()));
					continueTurn = false;
				}
			}
		}
		
		// Dealer's Turn
		BlackJackPlayer dealer = game.getDealer();
		System.out.println("");
		String message = String.format("=== %s's TURN ===", game.getDealer().getName());
		System.out.println(message);
		System.out.println(dealer.toString());
		continueTurn = true;
		while (continueTurn)
		{
			continueTurn = game.performDealerAction();
			System.out.println(dealer.toString());			
		}
		if (dealer.getIsBust())
		{
			System.out.println(String.format("%s BUSTED!", dealer.getName()));
		}
		
		// Results
		System.out.println("");
		System.out.println("=== RESULTS ===");
		for (BlackJackPlayer player : game.getPlayers())
		{
			String winner = (player.bestHandValue() > dealer.bestHandValue()) ? player.getName() : dealer.getName();
			String loser = (player.bestHandValue() > dealer.bestHandValue()) ? dealer.getName() : player.getName();
			if (player.bestHandValue() == dealer.bestHandValue())
			{
				System.out.println(String.format("%s TIES %s", player.getName(), dealer.getName()));
			}
			else
			{
				System.out.println(String.format("%s WINS OVER %s", winner, loser));
			}
		}
	}
	
	public static void printGameState()
	{
		for (BlackJackPlayer player : game.getPlayers())
		{
			System.out.println(player.toString());
		}
		System.out.println(game.getDealer().toString());
	}
}
