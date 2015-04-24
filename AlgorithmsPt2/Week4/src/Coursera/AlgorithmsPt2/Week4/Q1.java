package Coursera.AlgorithmsPt2.Week4;

import Coursera.AlgorithmsPt2.Week1.Graph;

public class Q1 {

	public static void main(String[] args) throws Exception {
		long startTime;
		long endTime;	
		
		System.out.print("Parsing Files...");
		startTime = System.currentTimeMillis();
		Graph graph1 = Parser.parseGraph("Q1 Inputs\\g1.txt");
		Graph graph2 = Parser.parseGraph("Q1 Inputs\\g2.txt");
		Graph graph3 = Parser.parseGraph("Q1 Inputs\\g3.txt");
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.print("Computing Shortest Shortest Paths...");
		startTime = System.currentTimeMillis();
		Integer solution1 = FloydWarshall.computeAllPairsShortestPath(graph1);
		Integer solution2 = FloydWarshall.computeAllPairsShortestPath(graph2);
		Integer solution3 = FloydWarshall.computeAllPairsShortestPath(graph3);
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		if (solution1 != null || solution2 != null || solution3 != null)
		{
			solution1 = (solution1 == null) ? Integer.MAX_VALUE : solution1;
			solution2 = (solution2 == null) ? Integer.MAX_VALUE : solution2;
			solution3 = (solution3 == null) ? Integer.MAX_VALUE : solution3;
			int bestSolution = Math.min(Math.min(solution1, solution2), solution3);
			
			System.out.println("Shortest Shortest Path Length: " + bestSolution);
		}
		else
		{
			System.out.println("Shortest Shortest Path Length: " + "NULL");
		}
	}

}
