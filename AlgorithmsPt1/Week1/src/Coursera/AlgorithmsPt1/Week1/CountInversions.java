package Coursera.AlgorithmsPt1.Week1;

import java.io.*;
import java.util.ArrayList;

public class CountInversions
{

	// Count inversions using brute force n^2 approach
	public static long CountInversionsBrute(ArrayList<Integer> inputData)
			throws Exception
	{
		// Iterate over each pair of values to check for inversion
		long numberInversions = 0;
		for (int index1 = 0; index1 < inputData.size(); index1++)
		{
			for (int index2 = index1 + 1; index2 < inputData.size(); index2++)
			{
				if (inputData.get(index1) > inputData.get(index2))
				{
					numberInversions++;
				}
			}
		}

		return numberInversions;
	}

	// Count inversions using Divide and Conquer n*log(n) approach
	public static InversionResult CountInversionsDivideConquer(
			ArrayList<Integer> inputData)
	{
		// Check for base case (1 value)
		if (inputData.size() == 1)
		{
			return new InversionResult(inputData, 0);
		}

		// Split array in half: O(n)
		int splitSize = inputData.size() / 2;
		ArrayList<Integer> leftValues = new ArrayList<Integer>(splitSize);
		ArrayList<Integer> rightValues = new ArrayList<Integer>(splitSize);
		for (int index = 0; index < inputData.size(); index++)
		{
			// Add values to left half
			if (index < splitSize)
			{
				leftValues.add(inputData.get(index));
			}
			// Add values to right half
			else
			{
				rightValues.add(inputData.get(index));
			}
		}

		// Recursive calls
		InversionResult inversionResultLeft = CountInversionsDivideConquer(leftValues);
		InversionResult inversionResultRight = CountInversionsDivideConquer(rightValues);

		// Merge/Sort + count split inversions
		InversionResult inversionResultSplit = CountSplitInversionsDivideConquer(
				inversionResultLeft.sortedValues,
				inversionResultRight.sortedValues);

		// Calculate total number of inversions
		long numberTotalInversions = inversionResultLeft.numberInversions
				+ inversionResultRight.numberInversions
				+ inversionResultSplit.numberInversions;
		return new InversionResult(inversionResultSplit.sortedValues,
				numberTotalInversions);
	}

	// Merge sorted sub-arrays and count inversions
	private static InversionResult CountSplitInversionsDivideConquer(
			ArrayList<Integer> sortedValuesLeft,
			ArrayList<Integer> sortedValuesRight)
	{
		// Combine sorted values from left and right sides and count inversions
		ArrayList<Integer> sortedValuesCombined = new ArrayList<Integer>(
				sortedValuesLeft.size() + sortedValuesRight.size());
		long numberSplitInversions = 0;

		int indexLeft = 0;
		int indexRight = 0;
		while (indexLeft < sortedValuesLeft.size()
				|| indexRight < sortedValuesRight.size())
		{
			// Compare both array listss
			if (indexLeft < sortedValuesLeft.size()
					&& indexRight < sortedValuesRight.size())
			{
				// Inversions exist
				if (sortedValuesLeft.get(indexLeft) > sortedValuesRight
						.get(indexRight))
				{
					numberSplitInversions += sortedValuesLeft.size()
							- indexLeft;
					sortedValuesCombined.add(sortedValuesRight.get(indexRight));
					indexRight++;
				}
				// No inversion
				else
				{
					sortedValuesCombined.add(sortedValuesLeft.get(indexLeft));
					indexLeft++;
				}
			}
			// Copy remaining left values
			else if (indexLeft < sortedValuesLeft.size())
			{
				sortedValuesCombined.add(sortedValuesLeft.get(indexLeft));
				indexLeft++;
			}
			// Copy remaining right values
			else if (indexRight < sortedValuesRight.size())
			{
				sortedValuesCombined.add(sortedValuesRight.get(indexRight));
				indexRight++;
			}
		}

		return new InversionResult(sortedValuesCombined, numberSplitInversions);
	}
}
