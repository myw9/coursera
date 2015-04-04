package Coursera.AlgorithmsPt2.Week1;

public class Edge {
	Node startNode;
	Node endNode;
	int cost;
	
	public Edge(Node startNode, Node endNode, int cost)
	{
		this.startNode = startNode;
		this.endNode = endNode;
		this.cost = cost;
	}
}
