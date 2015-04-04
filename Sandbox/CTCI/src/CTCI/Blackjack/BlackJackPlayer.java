package CTCI.Blackjack;

import java.util.ArrayList;
import java.util.Collections;

import CTCI.Cards.*;

public class BlackJackPlayer extends Player {

	// Constructor
	public BlackJackPlayer(String name)
	{
		super(name);	
	}
	
	// Constructor
	public BlackJackPlayer(String name, ArrayList<Hand> hands)
	{
		super(name, hands);	
	}
	
	// Returns whether the player is bust or not
	public boolean getIsBust()
	{
		boolean isBust = true;
		for (Hand hand : this.getHands())
		{
			isBust &= BlackJackGame.isBust(hand);
		}		
		return isBust;
	}
	
	// Calculate the player's best hand value
	public int bestHandValue()
	{
		if (this.getIsBust())
		{
			return -1;
		}
		
		Hand bestHand = null;
		int bestValue = -1;
		for (Hand hand : this.getHands())
		{
			int handValue = -1;
			ArrayList<Integer> handValues = BlackJackGame.computeHandValue(hand);
			Collections.sort(handValues);
			for (int index=handValues.size()-1; index >= 0; index--)
			{
				if(handValues.get(index) <= 21)
				{
					handValue = handValues.get(index);
					break;
				}
			}
			if (handValue > bestValue)
			{
				bestHand = hand;
				bestValue = handValue;
			}
		}
		return bestValue;
	}
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(super.toString());
		stringBuilder.append(" ");
		for (Hand hand : this.getHands())
		{
			ArrayList<Integer> handValues = BlackJackGame.computeHandValue(hand);
			stringBuilder.append("(");
			for (Integer i : handValues)
			{
				stringBuilder.append(String.format("%d,", i));				
			}
			if (handValues.size() > 0)
			{
				stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
			}
			stringBuilder.append(")");
		}
		return stringBuilder.toString();
	}
}
