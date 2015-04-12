package Coursera.AlgorithmsPt2.Week3;

public class Q2 {

	public static void main(String[] args) throws Exception {
		long startTime;
		long endTime;	
		
		System.out.print("Parsing File...");
		startTime = System.currentTimeMillis();
		KnapsackProblem problem = Parser.parseKnapsackFile("Q2 Inputs\\knapsack_big.txt");
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");
		
		System.out.print("Computing Maximum Knapsack Value (Recursive)...");
		startTime = System.currentTimeMillis();
		int solution = KnapsackDP.computeMaxKnapsackValueRecursive(problem);
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + " ms");	
		
		System.out.println("Maximum Value: " + solution);

	}

}
