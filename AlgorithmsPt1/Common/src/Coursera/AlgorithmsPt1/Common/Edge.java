package Coursera.AlgorithmsPt1.Common;

public class Edge
{
	public Vertex srcVertex;
	public Vertex destVertex;
	public int weight;
	
	public Edge(Vertex srcVertex, Vertex destVertex)
	{
		this.srcVertex = srcVertex;
		this.destVertex = destVertex;
		this.weight = 1;
	}
	
	public void SetWeight(int weight)
	{
		this.weight = weight;
	}
}
