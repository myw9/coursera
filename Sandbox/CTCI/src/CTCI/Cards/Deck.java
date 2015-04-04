package CTCI.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	// Variables
	ArrayList<Card> cardsInDeck;
	ArrayList<Card> cardsDealt;
	
	// Constructor
	public Deck()
	{
		cardsInDeck = createDeck();	
		cardsDealt = new ArrayList<Card>();
	}
	
	// Create standard 52-card deck
	protected ArrayList<Card> createDeck()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		// Iterate over all suit and rank combinations
		for (Suit suit : Suit.values())
		{
			for (Rank rank : Rank.values())
			{
				cards.add(new Card(suit, rank));
			}
		}
		
		return cards;
	}
	
	// Get deck size
	public int getSize()
	{
		return cardsInDeck.size();
	}
	
	// Randomly shuffle deck of cards
	public void shuffle()
	{
		long seed = System.nanoTime();
		Collections.shuffle(cardsInDeck, new Random(seed));
	}
	
	// Peak at top card
	public Card peek()
	{
		if (cardsInDeck.size() > 0)
		{
			return cardsInDeck.get(0);
		}
		else
		{
			return null;
		}
	}
	
	// Deal top card
	public Card dealTop() throws Exception
	{
		Card card;
		
		if (cardsInDeck.size() > 0)
		{
			card = cardsInDeck.remove(0);
			cardsDealt.add(card);
		}
		else
		{
			throw new Exception("Out of cards");
		}
		
		return card;
	}
	
	// Insert card at bottom of the deck
	public void insertBottom(Card card)
	{
		if (card != null && cardsDealt.contains(card))
		{
			cardsInDeck.add(card);
			cardsDealt.remove(card);
		}
	}
	
	// Insert multiple cards at bottom of the deck
	public void insertBottom(ArrayList<Card> cards)
	{
		for (Card card : cards)
		{
			if (cards != null && cardsDealt.contains(card))
			{
				cardsInDeck.add(card);
				cardsDealt.remove(card);
			}
		}
	}
}
