package Coursera.AlgorithmsPt2.Week1;

import java.util.ArrayList;

public class Node {
	int id;
	ArrayList<Edge> edges;
	
	public Node()
	{
		this(-1, null);
	}
	
	public Node(int id)
	{
		this(id, new ArrayList<Edge>());
	}
	
	public Node(int id, ArrayList<Edge> edges)
	{
		this.id = id;
		this.edges = edges;
	}
	
	public void addEdge(Edge edge)
	{
		edges.add(edge);
	}
	
	public boolean removeEdge(Edge edge)
	{
		return edges.remove(edge);
	}
}
