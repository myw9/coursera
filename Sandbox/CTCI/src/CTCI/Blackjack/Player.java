package CTCI.Blackjack;

import java.util.ArrayList;

import CTCI.Cards.*;

public class Player {
	// Variables
	private String name;
	private ArrayList<Hand> hands;
	
	// Constructor
	public Player(String name)
	{
		this(name, new ArrayList<Hand>());
	}
	
	// Constructor
	public Player(String name, ArrayList<Hand> hands)
	{
		this.name = name;
		this.hands = hands;
	}
	
	// Accessor for player name
	public String getName()
	{
		return this.name;
	}
	
	// Accessor for player's hands
	public ArrayList<Hand> getHands()
	{
		return this.hands;
	}
	
	// Add hand
	public void addHand(Hand hand)
	{
		if (hand != null)
		{
			hands.add(hand);
		}
	}
	
	// Discard hands
	public ArrayList<Card> discardHands()
	{
		ArrayList<Card> discardedCards = new ArrayList<Card>();
		for (Hand hand : hands)
		{
			discardedCards.addAll(hand.getCards());
		}
		hands = new ArrayList<Hand>();
		return discardedCards;
	}
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.name + ": ");
		for (Hand hand : this.hands)
		{
			stringBuilder.append(hand.toString());
		}
		return stringBuilder.toString();
	}
}
