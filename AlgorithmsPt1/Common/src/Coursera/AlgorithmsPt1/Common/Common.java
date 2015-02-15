package Coursera.AlgorithmsPt1.Common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Common
{
	// Parse input file and outputs an integer array
	public static ArrayList<Integer> ParseInputFile(String filePath) throws Exception
	{
		// Create file reader
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Read file into array
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

	public static AdjacencyList ParseAdjacencyFile(String filePath) throws Exception
	{
		// Create file reader
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Create adjacency list from file
		AdjacencyList adjacencyList = new AdjacencyList();
		String currentLine = bufferedReader.readLine();
		while (currentLine != null)
		{
			// Split data by white spaces
			String[] splitLine = currentLine.split("[ \t]");
			
			if (splitLine.length > 1)
			{
				// Parse vertex
				int vertex = Integer.parseInt(splitLine[0]);
				
				// Create edges
				for (int index = 1; index < splitLine.length; index++)
				{
					adjacencyList.AddEdge(vertex, Integer.parseInt(splitLine[index]));
				}
			}
			
			// Read next line
			currentLine = bufferedReader.readLine();
		}
		
		// Close file reader
		bufferedReader.close();
		
		return adjacencyList;
	}
}
