// Princeton Universit
public class QuickFindUF
{
	private int[] id;
	public QuickFindUF (int N)
	{
		id = new int[N];
		for (int i=0;i<N;i++)
		{
			id[i]=i;
			// initialize the indx
		}
	}
	public boolean connected (int p, int q)
	{
		return id[p]==id[q];
	}
	public void union (int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		for (int i=0; i<id.length;i++)
		{
			if (id[i]==pid) id[i]=qid;
		}
	}

}
// cost: initialize:N ; union:N; find: 1
public class QuickUnionUF
{
	private int[] id;
	public QuickUnionUF (int N)
	{
		id = new int[N];
		for (int i=0;i<N;i++) id[i]=i;
	}
	private int root (int i)
	{
		while (i != id[i]) i = id[i];
		return i;
	}
	public boolean connected (int p, int q)
	{
		return root(p) == root(q);
	}
	public void union (int p; int q)
	{
		int proot = root(p);
		int qroot = qroot(q);
		id[proot] = qroot;
	}
}
// cost: initialize:N ; union:N; find: N
// defect: tree is too tall, find is too expensive

public class QuickUnionWeightUF
{
	private int[] id;
	private int[] sz;
	public QuickUnionWeightUF (int N)
	{
		id = new int[N];
		sz = new int[N];
		for (int i=0;i<N;i++) 
		{
			id[i]=i;
			sz[i]=1;
		}
	}
	private int root (int i)
	{
		while (i != id[i]) i = id[i];
		return i;
	}
	public boolean connected (int p, int q)
	{
		return root(p) == root(q);
	}
	public void union (int p; int q)
	{
		int proot = root(p);
		int qroot = root(q);
		if (sz[proot]<sz[qroot])
		{
			id[proot]=qroot;
			sz[qroot]+=sz[proot];
		}
		else{
			id[qroot]=proot;
			sz[proot]+=sz[qroot];
		}
	}
}
// cost: initialize:N ; union:logN; find: logN
// proposition: depth of any node x is at most logN
// defect: tree is too tall, find is too expensive
public class QuickUnionPathCompressionUF
{
	private int[] id;
	private int[] sz;
	public QuickUnionPathCompressionUFF (int N)
	{
		id = new int[N];
		sz = new int[N];
		for (int i=0;i<N;i++) 
		{
			id[i]=i;
			// sz[i]=1;
		}
	}
	private int root (int i)
	{
		while (i != id[i]) 
		{
			id[i] = id[id[i]];/////only on extra if code!
			i = id[i];
		}
		return i;
	}
	public boolean connected (int p, int q)
	{
		return root(p) == root(q);
	}
	public void union (int p; int q)
	{
		int proot = root(p);
		int qroot = root(q);
		if (sz[proot]<sz[qroot])
		{
			id[proot]=qroot;
			sz[qroot]+=sz[proot];
		}
		else{
			id[qroot]=proot;
			// sz[proot]+=sz[qroot];
		}
	}
}
// proposition: almost linear










