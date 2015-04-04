package CTCI.Cards;

public enum Suit {
	Clubs(1),
	Hearts(2),
	Diamonds(3),
	Spades(4);
	
	// Integer value
	private final int value;
	
	// Constructor
	Suit(int value)
	{
		this.value = value;
	}
	
	// Accessor method for integer value
	public int getValue()
	{
		return value;
	}
}
