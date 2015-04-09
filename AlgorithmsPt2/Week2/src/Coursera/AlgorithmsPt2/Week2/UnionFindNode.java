package Coursera.AlgorithmsPt2.Week2;

public class UnionFindNode<T>
{
	private UnionFindNode<T> leader;
	private T obj;
	
	public UnionFindNode(T obj)
	{
		this.obj = obj;
		leader = this;
	}

	public UnionFindNode<T> getLeader() {
		return leader;
	}

	public void setLeader(UnionFindNode<T> leader) {
		this.leader = leader;
	}

	public T getObj() {
		return obj;
	}	
}
