package CTCI.Blackjack;

import java.util.ArrayList;
import CTCI.Cards.*;

public class Hand {
	// Variables
	private ArrayList<Card> cardsInHand;
	
	// Default constructor
	public Hand()
	{
		this(new ArrayList<Card>());
	}
	
	// Constructor
	public Hand(ArrayList<Card> cards)
	{
		cardsInHand = cards;
	}
	
	// Accessor for cards in hand
	public ArrayList<Card> getCards()
	{
		return cardsInHand;
	}
	
	// Add card to hand
	public void addCard(Card card)
	{
		if (card != null)
		{
			cardsInHand.add(card);
		}
	}
	
	// Remove card from hand
	public boolean removeCard(Card card)
	{
		if (cardsInHand.contains(card))
		{
			return cardsInHand.remove(card);
		}
		else
		{
			return false;
		}
	}
	
	// Remove all cards from hand
	public ArrayList<Card> removeAllCards()
	{
		ArrayList<Card> cards = cardsInHand;
		cardsInHand = new ArrayList<Card>();
		return cards;
	}
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (Card card : this.cardsInHand)
		{
			stringBuilder.append(card.toString());
			stringBuilder.append(",");
		}		
		if (this.cardsInHand.size() > 0)
		{
			stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
