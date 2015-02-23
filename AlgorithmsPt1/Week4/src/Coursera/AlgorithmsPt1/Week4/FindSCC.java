package Coursera.AlgorithmsPt1.Week4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

import Coursera.AlgorithmsPt1.Common.*;

public class FindSCC
{
	public static ArrayList<SCC> FindSCCs(AdjacencyListDirected adjacencyList)
	{
		// Step 1: Reverse DFS graph
		AdjacencyListDirected adjacencyListReversed = new AdjacencyListDirected(adjacencyList);
		adjacencyListReversed.ReverseGraph();
		
		// Step 2: Run DFS on reversed graph and track finishing order
		HashMap<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
		Stack<Integer> processStack = new Stack<Integer>();
		for (Vertex vertex : adjacencyListReversed.vertices.values())
		{
			// check if vertex has been visited already
			if (visitedMap.get(vertex.id) == null)
			{
				DFSReverse(adjacencyListReversed, vertex, visitedMap, processStack);
			}
		}
		
		// Step 3: Run DFS on forward graph to compute SCCs
		visitedMap = new HashMap<Integer, Boolean>();
		ArrayList<SCC> sccList = new ArrayList<SCC>();
		HashMap<Integer, Integer> sccSizes = new HashMap<Integer, Integer>();
		int vertexToProcess;
		while (!processStack.isEmpty())
		{
			vertexToProcess = processStack.pop();
			if (visitedMap.get(vertexToProcess) == null)
			{
				Vertex vertex = adjacencyList.vertices.get(vertexToProcess);
				int sccSize = DFSForward(adjacencyList, vertex, visitedMap);
				sccSizes.put(vertexToProcess, sccSize);
				sccList.add(new SCC(vertex, sccSize));
			}
		}
		
		return sccList;
	}
	
	// Recursive DFS on reversed graph to determine vertex processing order
	private static void DFSReverse(AdjacencyListDirected adjacencyList, Vertex startVertex, HashMap<Integer, Boolean> visitedMap, Stack<Integer> processStack)
	{
		// Set visited to true
		visitedMap.put(startVertex.id, true);

		// Recursive calls to connected vertices
		for (Edge edge : startVertex.edges)
		{
			if (visitedMap.get(edge.destVertex.id) == null)
			{
				DFSReverse(adjacencyList, edge.destVertex, visitedMap, processStack);
			}
		}

		// Add vertex to processing stack (based on finishing order)
		processStack.push(startVertex.id);
	}
	
	// Forwards DFS on ordered processing stack to count SCC size
	private static int DFSForward(AdjacencyListDirected adjacencyList, Vertex startVertex, HashMap<Integer, Boolean> visitedMap)
	{
		// Set visited to true
		visitedMap.put(startVertex.id, true);
		
		// Recursive calls to connected vertices
		int sccSizeCount = 0;
		for (Edge edge : startVertex.edges)
		{
			if (visitedMap.get(edge.destVertex.id) == null)
			{
				sccSizeCount += DFSForward(adjacencyList, edge.destVertex, visitedMap);
			}
		}
		
		// Increment SCC size count
		return sccSizeCount + 1;
	}
	
	public static ArrayList<Integer> FindLargestSCCs(ArrayList<SCC> sccList, int order)
	{
		// Sort SCC based on size
		Collections.sort(sccList);
		
		// Find the top "order" SCC sizes
		ArrayList<Integer> largestSCCSizes = new ArrayList<Integer>();
		int sccIndex = sccList.size()-1;
		while (order > 0)
		{
			if (sccIndex >= 0)
			{
				largestSCCSizes.add(sccList.get(sccIndex).size);
				sccIndex--;
			}
			else
			{
				largestSCCSizes.add(0);
			}
			order--;
		}
		
		return largestSCCSizes;
	}
}
