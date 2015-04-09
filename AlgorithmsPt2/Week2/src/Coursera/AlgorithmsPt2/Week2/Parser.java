package Coursera.AlgorithmsPt2.Week2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import Coursera.AlgorithmsPt2.Week1.*;

public class Parser {
	// Parse cluster graph file
	public static Graph parseClusterGraph(String filepath) throws Exception
	{
		// Open stream reader for input file
		FileReader fileReader = new FileReader(filepath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// Parse header
		String header;
		header = bufferedReader.readLine();
		int numNodes = Integer.parseInt(header);
		
		// Parse graph data
		Graph graph = new Graph();
		String line;
		while((line = bufferedReader.readLine()) != null)
		{
			String[] lineSplit = line.split("\\s+");
			if (lineSplit.length == 3)
			{
				int startNodeId = Integer.parseInt(lineSplit[0]);
				int endNodeId = Integer.parseInt(lineSplit[1]);
				int cost = Integer.parseInt(lineSplit[2]);
				graph.addEdge(startNodeId, endNodeId, cost);
			}
			else
			{
				throw new Exception("Invalid edge datum");
			}
		}
		
		return graph;
	}
	
	// Parse hamming graph input file into a hashmap of hamming codes with counts
	public static HammingData parseHammingGraph(String filePath) throws Exception
	{
		// Create buffered reader for input file
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// Parse header
		String header = bufferedReader.readLine();
		String[] headerSplit = header.split("\\s+");
		int numNodes = Integer.parseInt(headerSplit[0]);
		int bitsPerNode = Integer.parseInt(headerSplit[1]);
		
		// Parse hamming data and store into hash map
		HashMap<Integer, Integer> hammingMap = new HashMap<Integer, Integer>();
		String line;
		while ((line = bufferedReader.readLine()) != null)
		{
			if (line != "")
			{
				String binaryString = line.replaceAll("\\s", "");
				int hammingCode = Integer.parseInt(binaryString, 2);
				if (hammingMap.containsKey(hammingCode))
				{
					int count = hammingMap.get(hammingCode);
					hammingMap.put(hammingCode, count+1);
				}
				else
				{
					hammingMap.put(hammingCode, 1);
				}
			}
		}
		
		return new HammingData(hammingMap, bitsPerNode);
	}
	
	
}
