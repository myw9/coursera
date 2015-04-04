package CTCI.Cards;

public class Card {
	// Variables
	private	final Suit suit;
	private final Rank rank;
	
	// Constructor
	public Card(Suit suit, Rank rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	// Accessor for suit variable
	public Suit getSuit()
	{
		return suit;
	}
	
	// Accessor for rank variable
	public Rank getRank()
	{
		return rank;
	}
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.rank.toString());
		stringBuilder.append("Of");
		stringBuilder.append(this.suit.toString());
		return stringBuilder.toString();
	}
}
