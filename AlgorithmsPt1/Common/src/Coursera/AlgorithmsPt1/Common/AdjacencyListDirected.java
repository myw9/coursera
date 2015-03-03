package Coursera.AlgorithmsPt1.Common;

import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyListDirected
{
	public HashMap<Integer,Vertex> vertices;
	public ArrayList<Edge> edges;
	
	public AdjacencyListDirected()
	{
		vertices = new HashMap<Integer,Vertex>();
		edges = new ArrayList<Edge>();	
	}
	
	public AdjacencyListDirected(AdjacencyListDirected adjacencyList)
	{
		this();
		for (Edge edge : adjacencyList.edges)
		{
			AddEdge(edge.srcVertex.id, edge.destVertex.id);
		}
	}
	
	public void AddEdge(int srcVertexId, int destVertexId)
	{
		AddEdge(srcVertexId, destVertexId, 1);
	}
	
	public void AddEdge(int srcVertexId, int destVertexId, int weight)
	{
		Vertex srcVertex = FindCreateVertex(srcVertexId);
		Vertex destVertex = FindCreateVertex(destVertexId);
		Edge edge = new Edge(srcVertex, destVertex);
		edge.SetWeight(weight);
		edges.add(edge);
		srcVertex.edges.add(edge);
	}
	
	public Vertex FindCreateVertex(int id)
	{
		Vertex searchResult = vertices.get(id);
		if (searchResult == null)
		{
			searchResult = new Vertex(id);
			vertices.put(id, searchResult);
		}
		return searchResult;
	}
	
	public void ReverseGraph()
	{
		for (Edge edge : edges)
		{
			// Fix edges references in source and destination vertices
			edge.destVertex.edges.add(edge);
			edge.srcVertex.edges.remove(edge);
			
			// Swap source and destination references in edge
			Vertex tempVertex = edge.srcVertex;
			edge.srcVertex = edge.destVertex;
			edge.destVertex = tempVertex;
		}
	}
}
