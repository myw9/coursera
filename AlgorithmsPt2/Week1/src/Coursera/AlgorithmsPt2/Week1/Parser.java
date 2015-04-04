package Coursera.AlgorithmsPt2.Week1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {	
	// Parse job file
	public static ArrayList<Job> parseJobFile(String filePath) throws IOException
	{
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// Read header
		String header = bufferedReader.readLine();
		if (header == null)
		{
			return null;
		}
		int numJobs = Integer.parseInt(header);
		
		// Read job data
		ArrayList<Job> jobList = new ArrayList<Job>();
		String line;
		while ((line = bufferedReader.readLine()) != null && !line.equals(""))
		{
			String[] splitLine = line.split("\\s+");
			int weight = Integer.parseInt(splitLine[0]);
			int length = Integer.parseInt(splitLine[1]);
			jobList.add(new Job(weight, length));
		}
		
		return jobList;
	}

	// Parse graph file
	public static Graph parseGraphFile(String filePath) throws IOException
	{
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// Read header
		String header = bufferedReader.readLine();
		if (header == null)
		{
			return null;
		}
		String[] splitHeader = header.split("[ ]"); 
		int numNodes = Integer.parseInt(splitHeader[0]);
		int numEdges = Integer.parseInt(splitHeader[1]);
		
		// Read graph data
		Graph graph = new Graph();
		String line;
		while ((line = bufferedReader.readLine()) != null && !line.equals(""))
		{
			String[] splitLine = line.split("\\s+");
			int startNodeId = Integer.parseInt(splitLine[0]);
			int endNodeId = Integer.parseInt(splitLine[1]);
			int edgeCost = Integer.parseInt(splitLine[2]);
			Node startNode = graph.addNode(startNodeId);
			Node endNode = graph.addNode(endNodeId);
			Edge edge = new Edge(startNode, endNode, edgeCost);
			startNode.addEdge(edge);
			endNode.addEdge(edge);
			graph.addEdge(edge);			
		}
		
		return graph;
	}
}
