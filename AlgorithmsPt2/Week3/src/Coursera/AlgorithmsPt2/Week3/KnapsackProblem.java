package Coursera.AlgorithmsPt2.Week3;

import java.util.ArrayList;

public class KnapsackProblem {
	private ArrayList<KnapsackItem> items;
	private int capacity;
	private int maxItemIndex;	// 1-indexed
	
	public KnapsackProblem(int capacity)
	{
		items = new ArrayList<KnapsackItem>();
		this.capacity = capacity;
	}
	
	public KnapsackProblem(int capacity, ArrayList<KnapsackItem> items, int maxItemIndex)
	{
		this.capacity = capacity;
		this.items = items;
		this.maxItemIndex = maxItemIndex;
	}

	public ArrayList<KnapsackItem> getItems() {
		return items;
	}
	
	public void addItem(KnapsackItem item)
	{
		items.add(item);
	}

	public void clearItems()
	{
		items.clear();
	}
	
	public int getCapacity() {
		return capacity;
	}

	public int getMaxItemIndex() {
		return maxItemIndex;
	}
}
