package Coursera.AlgorithmsPt2.Week3;

public class Q1 {

	public static void main(String[] args) throws Exception {
		long startTime;
		long endTime;	
		
		System.out.print("Parsing File...");
		startTime = System.currentTimeMillis();
		KnapsackProblem problem = Parser.parseKnapsackFile("Q1 Inputs\\knapsack1.txt");
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.print("Computing Maximum Knapsack Value (Iterative)...");
		startTime = System.currentTimeMillis();
		int solution = KnapsackDP.computeMaxKnapsackValueIterative(problem);
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");	
		
		System.out.println("Maximum Value: " + solution);

	}

}
