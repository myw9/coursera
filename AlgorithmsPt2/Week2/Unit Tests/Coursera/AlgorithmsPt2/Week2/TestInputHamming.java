package Coursera.AlgorithmsPt2.Week2;

import java.util.HashMap;

public class TestInputHamming
{
	HashMap<Integer,Integer> hammingMap;
	int bitsPerCode;
	int maxClustersSolution;
	
	public TestInputHamming(HashMap<Integer,Integer> hammingMap, int bitsPerCode, int maxClustersSolution)
	{
		this.hammingMap = hammingMap;
		this.bitsPerCode = bitsPerCode;
		this.maxClustersSolution = maxClustersSolution;
	}
}
