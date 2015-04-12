package Coursera.AlgorithmsPt2.Week3;

import java.util.ArrayList;
import java.util.HashMap;

public class KnapsackDP {
	public static int computeMaxKnapsackValueIterative(KnapsackProblem problem)
	{
		int numberOfItems = problem.getItems().size();
		int capacity = problem.getCapacity();
		int[][] subproblemSolutions = new int[numberOfItems+1][capacity+1];
		
		// Initialize subproblem solutions
		for (int capacityIndex=0; capacityIndex <= capacity; capacityIndex++)
		{
			subproblemSolutions[0][capacityIndex] = 0;
		}
		
		// Execute dynamic problem
		for (int itemIndex=1; itemIndex <= numberOfItems; itemIndex++)
		{
			for (int currentCapacity=0; currentCapacity <= capacity; currentCapacity++)
			{
				KnapsackItem currentItem = problem.getItems().get(itemIndex-1);
				int valueCase1 = subproblemSolutions[itemIndex-1][currentCapacity];
				int valueCase2 = (currentItem.getWeight() > currentCapacity) ? -1 : (subproblemSolutions[itemIndex-1][currentCapacity-currentItem.getWeight()] + currentItem.getValue());
				subproblemSolutions[itemIndex][currentCapacity] = (valueCase1 >= valueCase2) ? valueCase1 : valueCase2;				
			}
		}
		
		return subproblemSolutions[numberOfItems][capacity];
	}
	
	public static int computeMaxKnapsackValueRecursive(KnapsackProblem problem)
	{
		// Initialize array list of hashmap of sub solutions where the array list index represents the item range and the hash table hashes uses the capacity as the key
		ArrayList<HashMap<Integer,Integer>> subSolutions = new ArrayList<HashMap<Integer,Integer>>();
		int numberOfItems = problem.getItems().size();
		for (int index=0; index<=problem.getItems().size(); index++)
		{
			subSolutions.add(new HashMap<Integer,Integer>());
		}
		
		// Set all 0-item values to 0
		for (int capacitySize=0; capacitySize <= problem.getCapacity(); capacitySize++)
		{
			subSolutions.get(0).put(capacitySize, 0);
		}
		
		return computeMaxKnapsackValueRecursive(problem, subSolutions);
	}
	
	private static int computeMaxKnapsackValueRecursive(KnapsackProblem problem, ArrayList<HashMap<Integer,Integer>> subSolutions)
	{
		// Base case
		if (problem.getMaxItemIndex() == 0)
		{
			return 0;
		}
		
		// Memoization
		if (subSolutions.get(problem.getMaxItemIndex()).containsKey(problem.getCapacity()))
		{
			return subSolutions.get(problem.getMaxItemIndex()).get(problem.getCapacity());
		}
		
		// Get last items to evaluate
		KnapsackItem currentItem = problem.getItems().get(problem.getMaxItemIndex()-1);
		
		// Compute case 1 value
		KnapsackProblem problem1 = new KnapsackProblem(problem.getCapacity(), problem.getItems(), problem.getMaxItemIndex()-1);
		int valueCase1 = computeMaxKnapsackValueRecursive(problem1, subSolutions);
		
		// Compute case 2 value
		KnapsackProblem problem2 = new KnapsackProblem(problem.getCapacity()-currentItem.getWeight(), problem.getItems(), problem.getMaxItemIndex()-1);
		int valueCase2 = (problem2.getCapacity() < 0) ? -1 : computeMaxKnapsackValueRecursive(problem2, subSolutions) + currentItem.getValue();
		
		// Store best value
		int bestValue = Math.max(valueCase1, valueCase2);
		subSolutions.get(problem.getMaxItemIndex()).put(problem.getCapacity(), bestValue);
		
		return bestValue;
	}
}
