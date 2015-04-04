package Coursera.AlgorithmsPt2.Week1;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	ArrayList<Node> nodes;
	ArrayList<Edge> edges;
	HashMap<Integer, Node> nodeMap;
		
	public Graph()
	{
		this(new ArrayList<Node>(), new ArrayList<Edge>());
	}
	
	public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges)
	{
		this.nodes = nodes;
		this.edges = edges;
		nodeMap = new HashMap<Integer, Node>();
		for (Node n : nodes)
		{
			nodeMap.put(n.id, n);
		}
	}
	
	public Node addNode(int nodeId)
	{
		Node node;
		if (!nodeMap.containsKey(nodeId))
		{
			node = new Node(nodeId);
			nodes.add(node);
			nodeMap.put(node.id, node);
		}		
		else
		{
			node = nodeMap.get(nodeId);
		}
		return node;
	}
	
	public boolean removeNode(Node node)
	{
		boolean result = nodes.remove(node);
		if (result)
		{
			nodeMap.remove(node.id); 
		}
		return result;
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
