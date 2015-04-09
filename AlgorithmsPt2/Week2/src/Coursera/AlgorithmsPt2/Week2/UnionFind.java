package Coursera.AlgorithmsPt2.Week2;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFind<T>
{
	private HashMap<T,UnionFindNode<T>> nodeMap;
	private HashMap<T,ArrayList<UnionFindNode<T>>> setMap;
	private int objectCount;
	private int setCount;
	
	public UnionFind(ArrayList<T> objects)
	{
		nodeMap = new HashMap<T,UnionFindNode<T>>();
		setMap = new HashMap<T,ArrayList<UnionFindNode<T>>>();
		
		// Initialize nodes and sets
		for (T obj : objects)
		{
			UnionFindNode<T> objNode = new UnionFindNode<T>(obj);					// Wrap object in UF node
			nodeMap.put(obj, objNode);												// Add object to node hash map
			ArrayList<UnionFindNode<T>> set = new ArrayList<UnionFindNode<T>>();	// Create a new set for each node
			set.add(objNode);
			setMap.put(obj, set);													// Add set to sets hash map			
		}
		objectCount = objects.size();
		setCount = objectCount;
	}
	
	public T Find(T obj)
	{
		if (obj == null)
		{
			return null;
		}
		
		if (!nodeMap.containsKey(obj))
		{
			return null;
		}
		
		UnionFindNode<T> node = nodeMap.get(obj);
		return node.getLeader().getObj();
	}
	
	public void Union(T obj1, T obj2)
	{
		if (obj1 == null || obj2 == null || obj1 == obj2 || !setMap.containsKey(obj1) || !setMap.containsKey(obj2) || 
			nodeMap.get(obj1).getLeader() == nodeMap.get(obj2).getLeader())
		{
			return;
		}
		
		ArrayList<UnionFindNode<T>> set1 = setMap.get(obj1);
		ArrayList<UnionFindNode<T>> set2 = setMap.get(obj2);
		
		// Merge smaller set into larger set
		ArrayList<UnionFindNode<T>> smallSet = (set1.size() < set2.size()) ? set1 : set2;
		ArrayList<UnionFindNode<T>> bigSet = (set1.size() < set2.size()) ? set2 : set1;
		UnionFindNode<T> smallNode = (set1.size() < set2.size()) ? nodeMap.get(obj1) : nodeMap.get(obj2);
		UnionFindNode<T> bigNode = (set1.size() < set2.size()) ? nodeMap.get(obj2) : nodeMap.get(obj1);
		
		// Merge array lists
		bigSet.addAll(smallSet);
		
		// Update pointers
		for (UnionFindNode<T> node : smallSet)
		{
			node.setLeader(bigNode.getLeader());	// Update leader pointers
			setMap.put(node.getObj(), bigSet);		// Update set references
		}		
		setCount--;
	}

	public int getSetCount() {
		return setCount;
	}
}
