package Coursera.AlgorithmsPt2.Week2;

import java.util.HashMap;

public class HammingData
{
	HashMap<Integer,Integer> hammingMap;
	int bitsPerNode;
	
	public HammingData(HashMap<Integer,Integer> hammingMap, int bitsPerNode)
	{
		this.hammingMap = hammingMap;
		this.bitsPerNode = bitsPerNode;
	}
}
