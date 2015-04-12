package Coursera.AlgorithmsPt2.Week3;

public class KnapsackItem {
	private int value;
	private int weight;
	
	public KnapsackItem(int value, int weight)
	{
		this.value = value;
		this.weight = weight;
	}
	
	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}
}
