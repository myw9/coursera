package Coursera.AlgorithmsPt2.Week2;

import java.util.ArrayList;
import java.util.HashMap;

public class Hamming
{
	public static int computeMaxClusters(HashMap<Integer,Integer> hammingMap, int bitsPerCode)
	{		
		// Generate list of hamming codes to compare the input data with
		// (hamming distance = 1 or 2)
		ArrayList<Integer> xorCodes = new ArrayList<Integer>();
		for (int bitPosition = 0; bitPosition < bitsPerCode; bitPosition++)
		{
			int dist1Code = 1 << bitPosition;
			xorCodes.add(dist1Code); // add dist=1 codes
			for (int bitPosition2 = bitPosition+1; bitPosition2 < bitsPerCode; bitPosition2++)
			{
				int dist2Code = (1 << bitPosition) | (1 << bitPosition2);
				xorCodes.add(dist2Code); // add dist=2 codes
			}			
		}
		
		// Iterate over each hamming code in hashmap
		ArrayList<Integer> hammingCodes = new ArrayList<>(hammingMap.keySet());
		UnionFind<Integer> clusterData = new UnionFind<Integer>(hammingCodes);
		for (Integer hammingCode : hammingCodes)
		{
			// XOR hamming code with all 1 and 2 hamming distance values to compute corresponding integer value
			// Because if A ^ B = C => A ^ C = B
			boolean canBeIndependentCluster = true;
			for (int distCode : xorCodes)
			{
				int lookupCode = hammingCode ^ distCode;
				if (hammingMap.containsKey(lookupCode))
				{
					clusterData.Union(hammingCode, lookupCode);
				}
			}
		}
		
		return clusterData.getSetCount();
	}
}
