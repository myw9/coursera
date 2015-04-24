package Coursera.AlgorithmsPt2.Week4;

import Coursera.AlgorithmsPt2.Week1.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Parser {
	public static Graph parseGraph(String filePath) throws Exception
	{		
		// Open graph file
		File file = new File(filePath);
		if (file.exists() && !file.isDirectory())
		{
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			// Parse header
			String header = bufferedReader.readLine();
			String[] headerSplit = header.split("\\s+");
			int numVertices = Integer.parseInt(headerSplit[0]);
			int numEdges = Integer.parseInt(headerSplit[1]);
			
			// Parse edges and vertices
			Graph graph = new Graph();
			String line;
			while((line = bufferedReader.readLine()) != null)
			{
				String[] lineSplit = line.split("\\s+");
				int tailNodeId = Integer.parseInt(lineSplit[0]);
				int headNodeId = Integer.parseInt(lineSplit[1]);
				int edgeLength = Integer.parseInt(lineSplit[2]);
				
				// Create nodes and edges and add to graph
				Node tailNode = graph.addNode(tailNodeId);
				Node headNode = graph.addNode(headNodeId);
				graph.addEdge(tailNodeId, headNodeId, edgeLength);
			}
			
			return graph;
		}
		else
		{
			return null;			
		}
	}
}
