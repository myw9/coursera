
public class Main {

	public static void main(String[] args) throws Exception {
		long startTime;
		long stopTime;
				
		System.out.print("Counting Inversions (Brute)...");
		startTime = System.currentTimeMillis();
		
		int numberInversions = CountInversions.CountInversionsBrute("Inputs\\INPUT1000.txt");
		
		stopTime = System.currentTimeMillis();
		System.out.println((stopTime-startTime) + "ms");		
		System.out.println("Inversions: " + numberInversions);
	}

}
