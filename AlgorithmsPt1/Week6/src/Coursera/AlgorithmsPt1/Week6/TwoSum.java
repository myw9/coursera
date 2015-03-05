package Coursera.AlgorithmsPt1.Week6;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum
{
	public static int CalculateTwoSum(ArrayList<Long> inputValues, int lowerbound, int upperbound)
	{
		int numTargetValues = 0;
		
		// Add all input values to hash map
		HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
		for (int index = 0; index < inputValues.size(); index++)
		{
			long i = inputValues.get(index);
			Integer iHashed = hashMap.get(i);
			if (iHashed != null)
			{
				hashMap.put(i, iHashed+1);	
			}
			else
			{
				hashMap.put(i, 1);
			}
		}
		
		// Create array for two sum values
		int[] twoSumValues = new int[upperbound-lowerbound+1];
		
		// Iterate over all input values to check for distinct 2-sum's
		for (int index = 0; index < inputValues.size(); index++)
		{
			long i = inputValues.get(index);
			for (int sum = lowerbound; sum <= upperbound; sum++)
			{
				long searchValue = sum - i;
				if (hashMap.containsKey(searchValue))
				{
					// Check for distinct values
					if (searchValue != i || hashMap.get(searchValue) > 1)
					{
						twoSumValues[sum-lowerbound] = 1;
					}
				}
			}
		}
		
		// Count number of sums in array
		for (int index = 0; index < twoSumValues.length; index++)
		{
			numTargetValues += twoSumValues[index];
		}
		
		return numTargetValues;
	}
}
