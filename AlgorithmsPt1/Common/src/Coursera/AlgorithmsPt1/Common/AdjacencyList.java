package Coursera.AlgorithmsPt1.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AdjacencyList
{
	public ArrayList<Edge> edges;
	public Map<Integer, Vertex> vertices;
	
	// Default constructor
	public AdjacencyList()
	{
		vertices = new HashMap<Integer, Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	// Copy constructor
	public AdjacencyList(AdjacencyList adjacencyList)
	{
		this();
		for (Edge edge : adjacencyList.edges)
		{
			AddEdge(edge.vertex1.id, edge.vertex2.id);
		}
	}
	
	public void AddEdge(int vertexId1, int vertexId2)
	{
		Vertex vertex1 = FindCreateVertex(vertexId1);
		Vertex vertex2 = FindCreateVertex(vertexId2);
		Edge edge = new Edge(vertex1, vertex2);
		edges.add(edge);
		vertex1.edges.add(edge);
		vertex2.edges.add(edge);
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
	
	public Edge GetEdge(int index)
	{
		return edges.get(index);
	}
	
	public int EdgeCount()
	{
		return edges.size();
	}
	
	public int VertexCount()
	{
		return vertices.size();
	}
	
	public void MergeVertices(Vertex source, Vertex destination) throws Exception
	{
		// Replace all endpoints in source edges with destination vertex
		ArrayList<Edge> edgesToRemove = new ArrayList<Edge>();
		for (Edge edge : source.edges)
		{
			// Check for self-loops			
			if ((edge.vertex1.id == source.id && edge.vertex2.id == destination.id) ||
				(edge.vertex1.id == destination.id && edge.vertex2.id == source.id))
			{
				edgesToRemove.add(edge);
			}
			else if (edge.vertex1.id == source.id)
			{
				edge.vertex1 = destination;
				destination.edges.add(edge);
			}
			else if (edge.vertex2.id == source.id)
			{
				edge.vertex2 = destination;
				destination.edges.add(edge);
			}
		}		
		vertices.remove(source.id);
		
		// Remove self-loop edges
		for (Edge edge : edgesToRemove)
		{
			edges.remove(edge);
		}
	}
}
