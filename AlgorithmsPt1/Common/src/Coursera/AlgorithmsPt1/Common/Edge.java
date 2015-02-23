package Coursera.AlgorithmsPt1.Common;

import java.util.ArrayList;

public class Edge
{
	public Vertex srcVertex;
	public Vertex destVertex;
	
	public Edge(Vertex srcVertex, Vertex destVertex)
	{
		this.srcVertex = srcVertex;
		this.destVertex = destVertex;
	}
}
