import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		long startTime;
		long stopTime;
		long numberInversions;
		
		// Parse input file
		ArrayList<Integer> inputValues = CountInversions.ParseInputFile("Inputs\\IntegerArray.txt");
				
		// Count inversions (Brute)
		long runningTimeBrute;
		System.out.print("Counting Inversions (Brute)...");
		startTime = System.currentTimeMillis();
		
		numberInversions = CountInversions.CountInversionsBrute(inputValues);
		
		stopTime = System.currentTimeMillis();
		runningTimeBrute = (stopTime-startTime);
		System.out.println(runningTimeBrute + "ms");		
		System.out.println("Inversions (Brute): " + numberInversions);
		
		// Count inversions (Divide and Conquer)
		long runningTimeDivideConquer;
		System.out.print("Counting Inversions (Divide and Conquer)...");
		startTime = System.currentTimeMillis();
		
		InversionResult inversionResult = CountInversions.CountInversionsDivideConquer(inputValues);
		numberInversions = inversionResult.numberInversions;
		
		stopTime = System.currentTimeMillis();
		runningTimeDivideConquer = (stopTime-startTime);
		System.out.println(runningTimeDivideConquer + "ms");		
		System.out.println("Inversions (Divide and Conquer): " + numberInversions);
		
		// Algorithm Comparison
		System.out.println("Running Time Ratio (DaC-to-Brute): " + ((double) runningTimeDivideConquer / (double) runningTimeBrute));
	}

}
