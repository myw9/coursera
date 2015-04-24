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
	
	public void addEdge(int startNodeId, int endNodeId, int cost)
	{
		Node startNode = addNode(startNodeId);
		Node endNode = addNode(endNodeId);
		Edge newEdge = new Edge(startNode, endNode, cost);
		newEdge.startNode = startNode;
		newEdge.endNode = endNode;
		startNode.addEdge(newEdge);
		endNode.addEdge(newEdge);
		this.addEdge(newEdge);
	}
	
	public boolean removeEdge(Edge edge)
	{
		return edges.remove(edge);
	}
	
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
	
	public ArrayList<Node> getNodes()
	{
		return nodes;
	}
	
	public Node getNode(int nodeId)
	{
		if (this.nodeMap.containsKey(nodeId))
		{
			return nodeMap.get(nodeId);
		}
		else
		{
			return null;
		}
	}
	
	public ArrayList<Edge> mergeNodes(Node node1, Node node2)
	{
		// Check for null inputs
		if (node1 == null || node2 == null || node1 == node2)
		{
			return null;
		}
		
		// Merge node 2 into node 1
		Node bigNode;
		Node smallNode;
		if (node1.edges.size() > node2.edges.size())
		{
			bigNode = node1;
			smallNode = node2;			
		}
		// Merge node 1 into node 2
		else
		{
			bigNode = node2;
			smallNode = node1;
		}
		
		// Perform merger
		ArrayList<Edge> selfEdges = new ArrayList<Edge>();
		for (Edge edge : smallNode.edges)
		{
			if ((edge.startNode == bigNode && edge.endNode == smallNode) ||
				(edge.startNode == smallNode && edge.endNode == bigNode))
			{
				selfEdges.add(edge);
			}
			else if (edge.startNode == smallNode)
			{
				edge.startNode = bigNode;
				bigNode.addEdge(edge);
			}
			else if (edge.endNode == smallNode)
			{
				edge.endNode = bigNode;
				bigNode.addEdge(edge);
			}			
		}
		
		// Remove circular edges
		for (Edge edge : selfEdges)
		{
			edge.startNode.removeEdge(edge);
			edge.endNode.removeEdge(edge);
			this.removeEdge(edge);
		}
		
		// Remove small node
		this.removeNode(smallNode);
		
		return selfEdges;
	}
}
