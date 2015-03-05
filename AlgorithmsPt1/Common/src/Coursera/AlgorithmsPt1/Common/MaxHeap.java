package Coursera.AlgorithmsPt1.Common;

public class MaxHeap<T extends Comparable<T>>
{
	private T[] heapArray;
	private int count;
	
	public MaxHeap(int capacity)
	{
		heapArray = newArray(capacity);
		count = 0;
	}
	
	public T PeakMax()
	{
		return heapArray[0];
	}
	
	public void Insert(T t)
	{
		// Insert at bottom of heap
		heapArray[count] = t;
		
		// Bubble up
		int childIndex = count+1;							// 1-indexed
		int parentIndex = (int) Math.floor(childIndex/2.0);
		while (childIndex > 1)
		{
			if (heapArray[childIndex-1].compareTo(heapArray[parentIndex-1]) > 0)
			{
				// Swap
				T temp = heapArray[childIndex-1];
				heapArray[childIndex-1] = heapArray[parentIndex-1];
				heapArray[parentIndex-1] = temp;
				
				// Update child and parent indices
				childIndex = parentIndex;
				parentIndex = (int) Math.floor(childIndex/2.0);	
			}
			else
			{
				break;
			}
		}
		
		// Increment heap size
		count++;
	}
	
	public T ExtractMax()
	{
		if (count == 1)
		{
			T minValue = heapArray[0];
			heapArray[0] = null;
			count = 0;
			return minValue;
		}
		else if (count > 1)
		{
			// Min is at the root node
			T minValue = heapArray[0];
			
			// Swap with last element
			heapArray[0] = heapArray[count-1];
			heapArray[count-1] = null;
					
			// Bubble down
			int parentIndex = 1;
			int childIndex1 = 2*parentIndex;
			int childIndex2 = 2*parentIndex+1;
			while (heapArray[parentIndex-1] != null)
			{
				boolean child1Exists = (heapArray[childIndex1-1] != null);
				boolean child2Exists = (heapArray[childIndex2-1] != null);
				
				if ((child1Exists && heapArray[parentIndex-1].compareTo(heapArray[childIndex1-1]) < 0 && !child2Exists) ||
					(child1Exists && heapArray[parentIndex-1].compareTo(heapArray[childIndex1-1]) < 0 && child2Exists && heapArray[childIndex1-1].compareTo(heapArray[childIndex2-1]) > 0))
				{
					// Swap with child 1
					T temp = heapArray[parentIndex-1];
					heapArray[parentIndex-1] = heapArray[childIndex1-1];
					heapArray[childIndex1-1] = temp;
					
					// Update indices
					parentIndex = childIndex1;
					childIndex1 = 2*parentIndex;
					childIndex2 = 2*parentIndex+1;
				}
				else if ((child2Exists && heapArray[parentIndex-1].compareTo(heapArray[childIndex2-1]) < 0 && !child1Exists) ||
						 (child2Exists && heapArray[parentIndex-1].compareTo(heapArray[childIndex2-1]) < 0 && child1Exists && heapArray[childIndex2-1].compareTo(heapArray[childIndex1-1]) > 0))
				{
					// Swap with child 2
					T temp = heapArray[parentIndex-1];
					heapArray[parentIndex-1] = heapArray[childIndex2-1];
					heapArray[childIndex2-1] = temp;
					
					// Update indices
					parentIndex = childIndex2;
					childIndex1 = 2*parentIndex;
					childIndex2 = 2*parentIndex+1;
				}
				else
				{
					break;
				}
			}
			count--;			
			return minValue;
		}
		else
		{
			return null;
		}
	}
	
	private int Find(T t)
	{
		if (count > 0)
		{
			int searchIndex = Find(t, 1);
			return searchIndex;
		}
		else
		{
			return -1;
		}
	}
	
	private int Find(T t, int startIndex)
	{
		int childIndex1 = 2*startIndex;
		int childIndex2 = 2*startIndex+1;
		boolean child1Exists = (heapArray[childIndex1-1] != null);
		boolean child2Exists = (heapArray[childIndex2-1] != null);
		if (t.equals(heapArray[startIndex-1]))
		{
			return startIndex;
		}
		int child1Search;
		if (child1Exists && t.compareTo(heapArray[childIndex1-1]) <= 0)
		{
			child1Search = Find(t, childIndex1);
			if (child1Search != -1)
			{
				return child1Search;
			}			
		}
		int child2Search;
		if (child2Exists && t.compareTo(heapArray[childIndex2-1]) <= 0)
		{
			child2Search = Find(t, childIndex2);
			if (child2Search != -1)
			{
				return child2Search;
			}
		}
		return -1;
	}
	
	public T Delete(T t)
	{
		int searchIndex = Find(t);
		if (searchIndex != -1)
		{
			if (searchIndex == 1)
			{
				return ExtractMax();
			}
			else if (searchIndex == count)
			{
				T searchValue = heapArray[count-1];
				heapArray[count-1] = null;
				count--;		
				return searchValue;
			}
			else
			{				
				// Swap search value and last value
				T searchValue = heapArray[searchIndex-1];
				heapArray[searchIndex-1] = heapArray[count-1];
				heapArray[count-1] = null;
				
				int parentIndex = (int) Math.floor(searchIndex/2.0);
				if (heapArray[searchIndex-1].compareTo(heapArray[parentIndex-1]) < 0)
				{
					// Bubble down
					parentIndex = searchIndex;
					int childIndex1 = 2*parentIndex;
					int childIndex2 = 2*parentIndex+1;
					while (heapArray[parentIndex-1] != null)
					{
						boolean child1Exists = (heapArray[childIndex1-1] != null);
						boolean child2Exists = (heapArray[childIndex2-1] != null);
						
						if ((child1Exists && heapArray[parentIndex-1].compareTo(heapArray[childIndex1-1]) < 0 && !child2Exists) ||
							(child1Exists && heapArray[parentIndex-1].compareTo(heapArray[childIndex1-1]) < 0 && child2Exists && heapArray[childIndex1-1].compareTo(heapArray[childIndex2-1]) > 0))
						{
							// Swap with child 1
							T temp = heapArray[parentIndex-1];
							heapArray[parentIndex-1] = heapArray[childIndex1-1];
							heapArray[childIndex1-1] = temp;
							
							// Update indices
							parentIndex = childIndex1;
							childIndex1 = 2*parentIndex;
							childIndex2 = 2*parentIndex+1;
						}
						else if ((child2Exists && heapArray[parentIndex-1].compareTo(heapArray[childIndex2-1]) < 0 && !child1Exists) ||
								 (child2Exists && heapArray[parentIndex-1].compareTo(heapArray[childIndex2-1]) < 0 && child1Exists && heapArray[childIndex2-1].compareTo(heapArray[childIndex1-1]) > 0))
						{
							// Swap with child 2
							T temp = heapArray[parentIndex-1];
							heapArray[parentIndex-1] = heapArray[childIndex2-1];
							heapArray[childIndex2-1] = temp;
							
							// Update indices
							parentIndex = childIndex2;
							childIndex1 = 2*parentIndex;
							childIndex2 = 2*parentIndex+1;
						}
						else
						{
							break;
						}
					}
				}
				else
				{
					// Bubble up
					int childIndex = searchIndex;							// 1-indexed
					parentIndex = (int) Math.floor(childIndex/2.0);
					while (childIndex > 1)
					{
						if (heapArray[childIndex-1].compareTo(heapArray[parentIndex-1]) > 0)
						{
							// Swap
							T temp = heapArray[childIndex-1];
							heapArray[childIndex-1] = heapArray[parentIndex-1];
							heapArray[parentIndex-1] = temp;
							
							// Update child and parent indices
							childIndex = parentIndex;
							parentIndex = (int) Math.floor(childIndex/2.0);	
						}
						else
						{
							break;
						}
					}
				}
				count--;
				return searchValue;
			}
		}
		else
		{
			return null;
		}
	}
	
	public int Size()
	{
		return count;
	}
	
	@SuppressWarnings("unchecked")
	private T[] newArray(int size)
	{
	    return (T[]) new Comparable[size];
	}
}
