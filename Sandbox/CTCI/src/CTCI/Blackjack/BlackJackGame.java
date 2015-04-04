package CTCI.Blackjack;

import java.util.ArrayList;
import java.util.Collections;

import CTCI.Cards.*;

public class BlackJackGame {
	// Variables
	private Deck deck;
	private ArrayList<BlackJackPlayer> players;
	private BlackJackPlayer dealer;
	private ArrayList<Card> discardPile;
	
	// Constructor
	public BlackJackGame(ArrayList<String> playerNames) throws Exception
	{
		if (playerNames == null || playerNames.size() == 0)
		{
			throw new Exception("Not Enough Players");
		}
		
		// Create deck
		deck = new Deck();
		discardPile = new ArrayList<Card>();
		
		// Add players to game
		players = new ArrayList<BlackJackPlayer>();
		for (String playerName : playerNames)
		{
			players.add(new BlackJackPlayer(playerName));
		}
		
		// Add dealer to game
		dealer = new BlackJackPlayer("Dealer");
	}
	
	// Accessor to get player list
	public ArrayList<BlackJackPlayer> getPlayers()
	{
		return players;
	}
	
	// Accessor to get player list
	public BlackJackPlayer getDealer()
	{
		return dealer;
	}
	
	// Reset game
	public void resetGame() throws Exception
	{
		// Return all cards to the deck
		deck.insertBottom(discardPile);
		discardPile = new ArrayList<Card>();
		for (Player player : players)
		{
			ArrayList<Card> cards = player.discardHands();
			deck.insertBottom(cards);
		}
		ArrayList<Card> cards = dealer.discardHands();
		deck.insertBottom(cards);
		
		// Check whether all cards were returned
		if (deck.getSize() != 52)
		{
			throw new Exception("Invalid number of cards in deck");
		}
	}
	
	// Shuffle deck
	public void shuffleDeck()
	{
		deck.shuffle();
	}
	
	// Deal cards to all players
	public void dealCards() throws Exception
	{
		// Add 2 cards to each player's hand
		for (Player player : players)
		{			
			ArrayList<Card> newCards = new ArrayList<Card>();
			newCards.add(deck.dealTop());
			newCards.add(deck.dealTop());
			Hand hand = new Hand(newCards);
			player.addHand(hand);
		}
		
		// Add 2 cards to dealer's hand
		ArrayList<Card> newCards = new ArrayList<Card>();
		newCards.add(deck.dealTop());
		newCards.add(deck.dealTop());
		Hand hand = new Hand(newCards);
		dealer.addHand(hand);
	}
	
	// Compute whether a hand is bust
	public static boolean isBust(Hand hand)
	{
		if (hand == null || hand.getCards().size() == 0)
		{
			return false;
		}
		
		ArrayList<Card> cards = hand.getCards();
		int sum = 0;
		for (Card card : cards)
		{
			ArrayList<Integer> cardValues = computeCardValue(card);
			Collections.sort(cardValues);
			sum += cardValues.get(0);
		}
		return (sum > 21);
	}
	
	// Compute whether hand is blackjack
	public static boolean isBlackjack(Hand hand)
	{
		if (hand == null || hand.getCards().size() != 2)
		{
			return false;
		}
		
		ArrayList<Card> cards = hand.getCards();
		Rank rank1 = cards.get(0).getRank();
		Rank rank2 = cards.get(1).getRank();
		if ((rank1 == Rank.Ace && (rank2 == Rank.Ten || rank2 == Rank.Jack || rank2 == Rank.Queen || rank2 == Rank.King)) ||
			(rank2 == Rank.Ace && (rank1 == Rank.Ten || rank1 == Rank.Jack || rank1 == Rank.Queen || rank1 == Rank.King)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Compute card value
	public static ArrayList<Integer> computeCardValue(Card card)
	{
		if (card == null)
		{
			return null;
		}
				
		ArrayList<Integer> cardValues = new ArrayList<Integer>();
		switch(card.getRank())
		{
			case Ace:
				cardValues.add(1);
				cardValues.add(11);
				break;
			case Two:
			case Three:
			case Four:
			case Five:
			case Six:
			case Seven:
			case Eight:
			case Nine:
			case Ten:
				cardValues.add(card.getRank().getValue());
				break;
			case Jack:
			case Queen:
			case King:
				cardValues.add(10);
				break;
		}
		return cardValues;
	}
	
	// Compute hand value(s)
	public static ArrayList<Integer> computeHandValue(Hand hand)
	{
		if (hand == null)
		{
			return null;
		}
		
		ArrayList<Card> cards = hand.getCards();
		ArrayList<Integer> handValues = new ArrayList<Integer>();
		handValues.add(0);
		for (Card card : cards)
		{
			ArrayList<Integer> cardValues = computeCardValue(card);
			
			// Duplicate hand values for each additional card value
			ArrayList<Integer> newHandValues = new ArrayList<Integer>();
			for (int rep = 0; rep < cardValues.size(); rep++)
			{
				for (Integer i : handValues)
				{
					newHandValues.add(new Integer(i + cardValues.get(rep)));
				}
			}
			handValues = newHandValues;
		}
		return handValues;		
	}

	// Hit
	public void Hit(BlackJackPlayer player, Hand hand) throws Exception
	{
		Card card = deck.dealTop();
		hand.addCard(card);
	}
	
	// Performs a dealer action and returns whether dealer needs to continue playing
	public boolean performDealerAction() throws Exception
	{
		int bestPlayerValue = -1;
		for (BlackJackPlayer player : this.players)
		{
			int handValue = player.bestHandValue();
			if (handValue > bestPlayerValue)
			{
				bestPlayerValue = handValue;
			}
		}
		
		// Dealer is done playing if their hand is as good as the best player hand
		if (dealer.bestHandValue() >= bestPlayerValue)
		{
			return false;
		}
		// Dealer must hit if < 17 points
		else if(dealer.bestHandValue() < 17)
		{
			Hit(dealer, dealer.getHands().get(0));
			if (dealer.getIsBust() || dealer.bestHandValue() >= 17)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		return false;
	}
}
