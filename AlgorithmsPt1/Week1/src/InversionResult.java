import java.util.ArrayList;

public class InversionResult
{
	public ArrayList<Integer> sortedValues;
	public long numberInversions;
	
	public InversionResult(ArrayList<Integer> sortedValues, long numberInversions)
	{
		this.sortedValues = sortedValues;
		this.numberInversions = numberInversions;
	}
	
}
