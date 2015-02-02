package Coursera.AlgorithmsPt1.Week2;
import java.util.ArrayList;

// Unit test input parameters
public class TestInput {
	public ArrayList<Integer> inputValues;
	public long numberComparisonsFirst; 		// Using fixed first index pivot selection
	public long numberComparisonsLast;			// Using fixed last index pivot selection
	public long numberComparisonsMedianOfThree;	// Using median-of-three pivot selection method
	
	// Constructor
	public TestInput(ArrayList<Integer> inputValues, long numberComparisonsFirst, long numberComparisonsLast, long numberComparisonsMedianOfThree)
	{
		this.inputValues = inputValues;
		this.numberComparisonsFirst = numberComparisonsFirst;
		this.numberComparisonsLast = numberComparisonsLast;
		this.numberComparisonsMedianOfThree = numberComparisonsMedianOfThree;
	}
}
