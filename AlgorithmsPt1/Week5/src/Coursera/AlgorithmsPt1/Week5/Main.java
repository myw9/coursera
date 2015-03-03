package Coursera.AlgorithmsPt1.Week5;

import java.util.HashMap;

import Coursera.AlgorithmsPt1.Common.AdjacencyListDirected;
import Coursera.AlgorithmsPt1.Common.Common;

public class Main
{

	public static void main(String[] args) throws Exception
	{
		long startTime;
		long stopTime;
		
		System.out.print("Parsing Input File...");
		startTime = System.currentTimeMillis();
		AdjacencyListDirected adjacencyList = Common.ParseAdjacencyFileWeighted("Inputs\\dijkstraData.txt");
		stopTime = System.currentTimeMillis();
		System.out.println((stopTime-startTime) + " ms");
		
		System.out.print("Computing Shortest Paths...");
		startTime = System.currentTimeMillis();
		HashMap<Integer,VertexDijkstra> shortestMap = Dijkstra.ComputeShortestPath(adjacencyList, 1);
		stopTime = System.currentTimeMillis();
		System.out.println((stopTime-startTime) + " ms");
		
		//7,37,59,82,99,115,133,165,188,197
		String solution = "";
		solution += shortestMap.get(7).greedyScore + ",";
		solution += shortestMap.get(37).greedyScore + ",";
		solution += shortestMap.get(59).greedyScore + ",";
		solution += shortestMap.get(82).greedyScore + ",";
		solution += shortestMap.get(99).greedyScore + ",";
		solution += shortestMap.get(115).greedyScore + ",";
		solution += shortestMap.get(133).greedyScore + ",";
		solution += shortestMap.get(165).greedyScore + ",";
		solution += shortestMap.get(188).greedyScore + ",";
		solution += shortestMap.get(197).greedyScore;
		System.out.println("Solution: " + solution);
		
		//10,30,50,80,90,110,130,160,180,190
		//3205,2303,3152,982,2018,2317,1820,2403,3027,2596
		solution = "";
		solution += shortestMap.get(10).greedyScore + ",";
		solution += shortestMap.get(30).greedyScore + ",";
		solution += shortestMap.get(50).greedyScore + ",";
		solution += shortestMap.get(80).greedyScore + ",";
		solution += shortestMap.get(90).greedyScore + ",";
		solution += shortestMap.get(110).greedyScore + ",";
		solution += shortestMap.get(130).greedyScore + ",";
		solution += shortestMap.get(160).greedyScore + ",";
		solution += shortestMap.get(180).greedyScore + ",";
		solution += shortestMap.get(190).greedyScore;
		System.out.println("Solution: " + solution);
	}

}
