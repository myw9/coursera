package Coursera.AlgorithmsPt1.Week6;

import java.util.ArrayList;

import Coursera.AlgorithmsPt1.Common.MaxHeap;
import Coursera.AlgorithmsPt1.Common.MinHeap;

public class MedianMaintenance
{
	public static long CalculateMedianMod(ArrayList<Long> inputData, int modValue)
	{
		long medianModValue = 0;
		long medianSum = 0;
		
		// Initialize heaps
		MaxHeap<Long> lowValues = new MaxHeap<Long>(20000);
		MinHeap<Long> highValues = new MinHeap<Long>(20000);
		
		// Process 1st value
		long firstValue = inputData.get(0);
		lowValues.Insert(firstValue);
		medianSum += firstValue;
		
		// Process 2nd value
		long secondValue = inputData.get(1);
		if (secondValue < lowValues.PeakMax())
		{
			highValues.Insert(lowValues.ExtractMax());
			lowValues.Insert(secondValue);
			medianSum += secondValue;
		}
		else
		{
			highValues.Insert(secondValue);
			medianSum += lowValues.PeakMax();
		}
		
		// Iterate over all remaining values in input data arraylist
		for (int index=2; index<inputData.size(); index++)
		{
			Long lowMax = lowValues.PeakMax();
			Long highMin = highValues.PeakMin();
			long nextInteger = inputData.get(index);
			
			// Check heap balancing
			if (lowValues.Size() == highValues.Size())
			{
				if (nextInteger >= highMin)
				{
					highValues.Insert(nextInteger);
					medianSum += highValues.PeakMin();
				}
				else
				{
					lowValues.Insert(nextInteger);
					medianSum += lowValues.PeakMax();
				}				
			}
			else if (lowValues.Size() < highValues.Size())
			{
				if (nextInteger <= highMin)
				{
					lowValues.Insert(nextInteger);
					medianSum += lowValues.PeakMax();
				}
				else
				{
					lowValues.Insert(highValues.ExtractMin());
					highValues.Insert(nextInteger);
					medianSum += lowValues.PeakMax();
				}
			}
			else
			{
				if (nextInteger >= lowMax)
				{
					highValues.Insert(nextInteger);
					medianSum += lowValues.PeakMax();
				}
				else
				{
					highValues.Insert(lowValues.ExtractMax());
					lowValues.Insert(nextInteger);
					medianSum += lowValues.PeakMax();
				}
			}
		}		
		
		// Calculate median mod value
		medianModValue = medianSum % modValue;
		
		return medianModValue;
	}
}
