package Coursera.AlgorithmsPt1.Common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Common
{
	// Parse input file and outputs an integer array
	public static ArrayList<Integer> ParseInputFile(String filePath)
			throws Exception
	{
		// Create file reader
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Reader file into array
		ArrayList<Integer> inputValues = new ArrayList<Integer>(100000);
		String currentLine = bufferedReader.readLine();
		while (currentLine != null)
		{
			inputValues.add(Integer.parseInt(currentLine));
			currentLine = bufferedReader.readLine();
		}

		// Close file reader
		bufferedReader.close();
		
		return inputValues;
	}
}
