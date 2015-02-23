package Coursera.AlgorithmsPt1.Week4;

import Coursera.AlgorithmsPt1.Common.Vertex;

public class SCC implements Comparable<SCC>
{
	public Vertex leadVertex;
	public int size;
	
	public SCC(Vertex leadVertex, int size)
	{
		this.leadVertex = leadVertex;
		this.size = size;
	}

	@Override
	public int compareTo(SCC arg0)
	{
		if (this.size > arg0.size)
		{
			return 1;
		}
		else if (this.size < arg0.size)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}
