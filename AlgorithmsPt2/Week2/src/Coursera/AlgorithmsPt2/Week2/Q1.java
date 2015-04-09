package Coursera.AlgorithmsPt2.Week2;

import java.util.ArrayList;

import Coursera.AlgorithmsPt2.Week1.Graph;

public class Q1 {

	public static void main(String[] args) throws Exception {
		long startTime;
		long endTime;	
		
		System.out.print("Parsing File...");
		startTime = System.currentTimeMillis();
		Graph graph = Parser.parseClusterGraph("Q1 Inputs\\clustering1.txt");
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.print("Computing Minimum Spacing for K-clustering...");
		startTime = System.currentTimeMillis();
		int minSpacing = Clustering.computeMaxSpacing(graph, 4);
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");	
		
		System.out.println("Minimum Spacing: " + minSpacing);
	}

}
