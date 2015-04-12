package Coursera.AlgorithmsPt2.Week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
	public static KnapsackProblem parseKnapsackFile(String filePath) throws Exception
	{
		// Open file for reading
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// Read header
		String header = bufferedReader.readLine();
		String[] headerSplit = header.split("\\s");
		int knapsackSize = Integer.parseInt(headerSplit[0]);
		int numberOfItems = Integer.parseInt(headerSplit[1]);
		
		// Create knapsack problem
		KnapsackProblem knapsackProblem = new KnapsackProblem(knapsackSize, new ArrayList<KnapsackItem>(), numberOfItems);
		
		// Read item data
		String line;
		while ((line = bufferedReader.readLine()) != null)
		{
			String[] lineSplit = line.split("\\s");
			int value = Integer.parseInt(lineSplit[0]);
			int weight = Integer.parseInt(lineSplit[1]);
			knapsackProblem.addItem(new KnapsackItem(value, weight));
		}		
		
		return knapsackProblem;
	}
}
