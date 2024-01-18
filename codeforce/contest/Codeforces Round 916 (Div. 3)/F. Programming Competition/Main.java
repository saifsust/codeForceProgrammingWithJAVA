import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
	private final  Scanner read = new Scanner(System.in);

	public static void main(String[] args){
		new Main().solve();
	}

	private void solve(){

		int T = read.nextInt();

		while(T-- > 0){
			int n = read.nextInt();
			List<Integer> graph[] = new ArrayList[n];

			for(int i = 1; i<n; i++){
				int u = read.nextInt();
				--u;
				if(graph[i] == null) graph[i] = new ArrayList<Integer>();
				if(graph[u] == null) graph[u] = new ArrayList<Integer>();
				graph[u].add(i);
			}

			int sz[] = new int[n];

			dfs(0, sz, graph);
			System.out.println(dfs(0, 0, sz, graph));

		}
	}

     private void dfs(int source, int sz[], List<Integer>graph[]){
	     sz[source] = 1;
	     for(int next : graph[source]){
		     dfs(next, sz, graph);
		     sz[source] += sz[next];
	     }
     }

    private int dfs(int source, int k , int[] sz, List<Integer>graph[]){
	    int T = 0;
	    int M = -1;

	    for(int next : graph[source]){
		    T += sz[next];
		    if(M == -1 || sz[M] < sz[next]) M = next;
	    }

	    if(T == 0) return 0;

	    if(sz[M] - k <= T - sz[M]) return (T - k) / 2;

	    int ans = T - sz[M];
	    return ans + dfs(M, Math.max(0, k + ans - 1), sz, graph);
    }	    

}
