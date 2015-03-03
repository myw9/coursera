package Coursera.AlgorithmsPt1.Week5;

import Coursera.AlgorithmsPt1.Common.Vertex;

public class VertexDijkstra implements Comparable<VertexDijkstra>
{
	public long greedyScore;
	public Vertex vertex;
	
	public VertexDijkstra(Vertex vertex, long greedyScore)
	{
		this.vertex = vertex;
		this.greedyScore = greedyScore;
	}

	@Override
	public int compareTo(VertexDijkstra o)
	{
		if (greedyScore < o.greedyScore)
		{
			return -1;
		}
		else if (greedyScore > o.greedyScore)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj)
	{
		return (vertex.id == ((VertexDijkstra)obj).vertex.id);
	}
}
