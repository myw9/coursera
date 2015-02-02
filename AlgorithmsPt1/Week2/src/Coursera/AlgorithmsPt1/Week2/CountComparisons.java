package Coursera.AlgorithmsPt1.Week2;

import java.util.ArrayList;

public class CountComparisons
{
	public static ComparisonResult QuickSort(ArrayList<Integer> inputValues, int startIndex, int stopIndex, PivotSelection pivotSelection)
	{
		long numberComparisons = 0;
		
		// Base case
		if (startIndex == stopIndex || startIndex > stopIndex)
		{
			return new ComparisonResult(numberComparisons);
		}

		// Choose pivot index
		int pivotIndex = startIndex;
		switch (pivotSelection)
		{
			case FixedFirst:
				pivotIndex = startIndex;
				break;

			case FixedLast:
				pivotIndex = stopIndex;
				break;

			case MedianOfThree:
				int middleIndex = startIndex + (int) (stopIndex - startIndex)
						/ 2;
				if (inputValues.get(startIndex) >= inputValues.get(stopIndex)
						&& inputValues.get(startIndex) <= inputValues
								.get(middleIndex))
				{
					pivotIndex = startIndex;
					break;
				}
				if (inputValues.get(startIndex) <= inputValues.get(stopIndex)
						&& inputValues.get(startIndex) >= inputValues
								.get(middleIndex))
				{
					pivotIndex = startIndex;
					break;
				}
				if (inputValues.get(middleIndex) >= inputValues.get(startIndex)
						&& inputValues.get(middleIndex) <= inputValues
								.get(stopIndex))
				{
					pivotIndex = middleIndex;
					break;
				}
				if (inputValues.get(middleIndex) <= inputValues.get(startIndex)
						&& inputValues.get(middleIndex) >= inputValues
								.get(stopIndex))
				{
					pivotIndex = middleIndex;
					break;
				}
				if (inputValues.get(stopIndex) >= inputValues.get(startIndex)
						&& inputValues.get(stopIndex) <= inputValues
								.get(middleIndex))
				{
					pivotIndex = stopIndex;
					break;
				}
				if (inputValues.get(stopIndex) <= inputValues.get(startIndex)
						&& inputValues.get(stopIndex) >= inputValues
								.get(middleIndex))
				{
					pivotIndex = stopIndex;
					break;
				}
		}

		// Swap pivot to start index
		int pivotValue = inputValues.get(pivotIndex);
		inputValues.set(pivotIndex, inputValues.get(startIndex));
		inputValues.set(startIndex, pivotValue);

		// Partition values
		int partitionIndex = startIndex + 1; // next element to partition
		int boundaryIndex = startIndex + 1; // boundary between partitions (1st element after boundary)
		while (partitionIndex <= stopIndex)
		{
			// Swap values and update boundary if new value is < pivot value
			if (inputValues.get(partitionIndex) <= pivotValue)
			{
				int tempValue = inputValues.get(partitionIndex);
				inputValues.set(partitionIndex, inputValues.get(boundaryIndex));
				inputValues.set(boundaryIndex, tempValue);
				boundaryIndex++;
			} else
			{
				// Do nothing
			}

			// Update partition pointer
			partitionIndex++;
		}
		
		// Swap pivot into sorted position
		int tempValue = inputValues.get(boundaryIndex-1);
		inputValues.set(boundaryIndex-1, inputValues.get(startIndex));
		inputValues.set(startIndex, tempValue);

		// Recursive calls to sub-arrays
		numberComparisons += (stopIndex - startIndex);	// add n-1 comparisons executed in the partition step
		ComparisonResult leftResults = QuickSort(inputValues, startIndex, boundaryIndex-2, pivotSelection);
		numberComparisons += leftResults.numberComparisons;
		ComparisonResult rightResults = QuickSort(inputValues, boundaryIndex, stopIndex, pivotSelection);
		numberComparisons += rightResults.numberComparisons;
		
		return new ComparisonResult(numberComparisons);
	}
}
