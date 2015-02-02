package Coursera.AlgorithmsPt1.Week2;

import java.util.ArrayList;

import Coursera.AlgorithmsPt1.Common.Common;

public class Main
{

	public static void main(String[] args) throws Exception
	{
		ArrayList<Integer> inputValues;
		ComparisonResult comparisonResult;
		long startTimeMs;
		long stopTimeMs;
		
		// Execute QuickSort with "Fixed First" Pivot Method
		System.out.print("Counting Comparisons (Fixed First Pivot)...");
		startTimeMs = System.currentTimeMillis();
		
		inputValues = Common.ParseInputFile("Inputs\\QuickSort.txt");	// Parse input file
		comparisonResult = CountComparisons.QuickSort(inputValues, 0, inputValues.size()-1, PivotSelection.FixedFirst);	// Execute QuickSort w/ comparison counting
		
		stopTimeMs = System.currentTimeMillis();
		System.out.println(String.format("%d ms", stopTimeMs - startTimeMs));
		System.out.println("Number of Comparisons: " + comparisonResult.numberComparisons);
		
		// Execute QuickSort with "Fixed Last" Pivot Method
		System.out.print("Counting Comparisons (Fixed Last Pivot)...");
		startTimeMs = System.currentTimeMillis();
		
		inputValues = Common.ParseInputFile("Inputs\\QuickSort.txt");	// Parse input file
		comparisonResult = CountComparisons.QuickSort(inputValues, 0, inputValues.size()-1, PivotSelection.FixedLast);	// Execute QuickSort w/ comparison counting
		
		stopTimeMs = System.currentTimeMillis();
		System.out.println(String.format("%d ms", stopTimeMs - startTimeMs));
		System.out.println("Number of Comparisons: " + comparisonResult.numberComparisons);
		
		// Execute QuickSort with "Fixed First" Pivot Method
		System.out.print("Counting Comparisons (Median-Of-Three Pivot)...");
		startTimeMs = System.currentTimeMillis();
		
		inputValues = Common.ParseInputFile("Inputs\\QuickSort.txt");	// Parse input file
		comparisonResult = CountComparisons.QuickSort(inputValues, 0, inputValues.size()-1, PivotSelection.MedianOfThree);	// Execute QuickSort w/ comparison counting
		
		stopTimeMs = System.currentTimeMillis();
		System.out.println(String.format("%d ms", stopTimeMs - startTimeMs));
		System.out.println("Number of Comparisons: " + comparisonResult.numberComparisons);
	}

}
