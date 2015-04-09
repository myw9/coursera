package Coursera.AlgorithmsPt2.Week2;

import java.util.HashMap;

public class Q2 {

	public static void main(String[] args) throws Exception {
		long startTime;
		long endTime;	
		
		System.out.print("Parsing File...");
		startTime = System.currentTimeMillis();
		HammingData hammingData = Parser.parseHammingGraph("Q2 Inputs\\clustering_big.txt");
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.print("Computing Maximum k-Clusters...");
		startTime = System.currentTimeMillis();
		int kClusters = Hamming.computeMaxClusters(hammingData.hammingMap, hammingData.bitsPerNode);
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.println("K-clusters: " + kClusters);
	}

}
