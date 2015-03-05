package Coursera.AlgorithmsPt1.Common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
	
	// Parse input file and outputs an integer array
	public static ArrayList<Long> ParseInputFileLarge(String filePath) throws Exception
	{
		// Create file reader
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Read file into array
		ArrayList<Long> inputValues = new ArrayList<Long>(100000);
		String currentLine = bufferedReader.readLine();
		while (currentLine != null)
		{
			inputValues.add(Long.parseLong(currentLine));
			currentLine = bufferedReader.readLine();
		}

		// Close file reader
		bufferedReader.close();

		return inputValues;
	}

	public static AdjacencyListUndirected ParseAdjacencyFileUndirected(String filePath) throws Exception
	{
		// Create file reader
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Create adjacency list from file
		AdjacencyListUndirected adjacencyList = new AdjacencyListUndirected();
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
	
	public static AdjacencyListDirected ParseAdjacencyFileDirected(String filePath) throws Exception
	{
		// Create file reader
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Create adjacency list from file
		AdjacencyListDirected adjacencyList = new AdjacencyListDirected();
		String currentLine = bufferedReader.readLine();
		while (currentLine != null)
		{
			// Split data by white spaces
			String[] splitLine = currentLine.split("[ \t]");
			
			if (splitLine.length > 1)
			{
				// Parse source vertex
				int srcVertex = Integer.parseInt(splitLine[0]);
				
				// Create edges
				for (int index = 1; index < splitLine.length; index++)
				{
					adjacencyList.AddEdge(srcVertex, Integer.parseInt(splitLine[index]));
				}
			}
			
			// Read next line
			currentLine = bufferedReader.readLine();
		}
		
		// Close file reader
		bufferedReader.close();
		
		return adjacencyList;
	}
	
	public static AdjacencyListDirected ParseAdjacencyFileWeighted(String filePath) throws Exception
	{
		// Create file reader
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Create adjacency list from file
		AdjacencyListDirected adjacencyList = new AdjacencyListDirected();
		String currentLine = bufferedReader.readLine();
		while (currentLine != null)
		{
			// Split data by white spaces
			String[] splitLine = currentLine.split("[ \t]");
			
			if (splitLine.length > 1)
			{
				// Parse source vertex
				int srcVertex = Integer.parseInt(splitLine[0]);
				
				// Create edges
				for (int index = 1; index < splitLine.length; index++)
				{
					String[] splitEdge = splitLine[index].split(",");
					adjacencyList.AddEdge(srcVertex, Integer.parseInt(splitEdge[0]), Integer.parseInt(splitEdge[1]));
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
