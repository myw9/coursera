package Coursera.AlgorithmsPt1.Common;

import java.util.ArrayList;

public class Vertex
{
	public int id;
	public ArrayList<Edge> edges;
	
	public Vertex(int id)
	{
		this.id = id;
		edges = new ArrayList<Edge>();
	}
}
