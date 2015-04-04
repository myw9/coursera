package Coursera.AlgorithmsPt2.Week1;

import java.io.IOException;
import java.util.ArrayList;

public class Q3 {

	public static void main(String[] args) throws IOException {
		long startTime;
		long endTime;	
		
		System.out.print("Parsing File...");
		startTime = System.currentTimeMillis();
		Graph graph = Parser.parseGraphFile("Graph Inputs\\edges.txt");
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.print("Computing Minimum Spanning Tree (MST)...");
		startTime = System.currentTimeMillis();
		ArrayList<Edge> mst = MinimumSpanningTree.computeMST(graph);
		long mstCost = MinimumSpanningTree.computeCost(mst);
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.println("MST Cost: " + mstCost);
	}

}
