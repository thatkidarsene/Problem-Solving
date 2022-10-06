import java.util.*;

class Graph{
	int V;
	int adj[];
	int[] fun;
	boolean[] visited;
	Graph(int v){
        V = v;
        adj = new int[v];
        fun = new int[v];
        visited = new boolean[v];
    }
    void addEdge(int v, int w){
        adj[v] = w; 
    }


void printGraph(){
    	for(int i=1;i<V;i++){
    			System.out.print(i+"->"+adj[i]); 
    			System.out.println("");
    		}
    		
    	}
    int branch(int v, int[] count, int dest){
    		int res=0;
    		int n=v;
    		while (adj[n]!=dest && !visited[adj[n]]){
    			n = adj[n];
    			if(count[n]>1){res=n;}
    		}
    		if(res==0){res=n;}
    		return res;
    }

    int score(int v1, int v2){
    	if(v1==v2){return fun[v1];}
    	int n=v1;
    	int best=fun[v1];
    		while (adj[n]!=v2){
    			n = adj[n];
    			if(fun[n]>best){best=fun[n];}
    		}
    	return best;
    }

    boolean visited(){
    	boolean res = true;
    	 for (int i=1;i<V;i++){
            res = res && visited[i];
    }
    return res;
    }

    long traverse(int v){
    	int n = v;
    	long best = fun[v];
    		while (n!=0 && !visited[n]){
    			visited[n] = true; 
    			n =adj[n];
    			if(fun[n]>best && !visited[n]){best=fun[n];}
    		}
    	return best;
    }


}


public class Solution {
int []F; 
int []P;
int N;

public Solution(int N){
	this.N = N; 
	F = new int[N];
	P = new int[N];
}

public static void printArray(boolean[] tab){
	for(int i=1;i<tab.length;i++){
		System.out.print(tab[i]+" ");
	}
	System.out.println("");
}
public static void printArray(int[] tab){
	for(int i=1;i<tab.length;i++){
		System.out.print(tab[i]+" ");
	}
	System.out.println("");
}

public static int max_height(Graph g, ArrayList<Integer> list, int[] branch){
	int max=0;
	for(int i:list){
		int curr=i;
		int count=0;
		while(curr!=branch[i]){
			curr = g.adj[curr];
			count++;
		}
		
		if(count>max){max=count;}
	}
	return max;
}

public static long solve(Solution s){
	Graph g = new Graph(s.N+1);
	int count[] = new int[s.N+1];
	ArrayList<Integer> initiators = new ArrayList<Integer>();
	for(int i=0;i<s.F.length;i++){
		g.fun[i+1] = s.F[i]; 
	}
	for(int i=0;i<s.P.length;i++){
		if(s.P[i]!=0){
			g.addEdge(i+1,s.P[i]);
			count[s.P[i]]++;
		}
	}
	
	for(int i=1;i<g.V;i++){
		boolean init = true;
		for(int j=0;j<s.P.length;j++){
			if(s.P[j]==i){init = false;}
		}
		if(init){initiators.add(i);}
	}
	

	long score=0;
	int scores[] = new int[g.V];
	int branch[] = new int[g.V];
	while(!g.visited()){

	int min_score_initiator=0;
	int min_score = Integer.MAX_VALUE;
		for(int i:initiators){

			if(!g.visited[i]){
				
				
				int b = g.branch(i,count,0);
				branch[i] = b;
				
				int _score = g.score(i,b);
				scores[i] = _score;
				
				if(_score<min_score){min_score=_score;min_score_initiator=i;}

			}	
	}
	
	ArrayList<Integer> tielist = new ArrayList<Integer>();
	for(int i=0;i<scores.length;i++){
		if(scores[i]==min_score){tielist.add(i);}
	}
	
	int loops=0;
	int maxloops = max_height(g,tielist,branch);
	
	while(tielist.size()>1){

		loops++;
		
		for(int i:tielist){
			if(!g.visited[i]){
				
				
				int b = g.branch(i,count,branch[i]);
				branch[i] = b;
				
				int _score = g.score(i,b);
				scores[i] = _score;
				
				if(_score<min_score){min_score=_score;min_score_initiator=i;}
		
			}	
		
	}
	
	
	
	
	if(loops>=maxloops){break;}
	tielist.clear();
	for(int i=0;i<scores.length;i++){
		if(scores[i]==min_score){tielist.add(i);}
	}
	
	}


	
	
	
	scores[min_score_initiator] = -1;
	score += g.traverse(min_score_initiator);
	
	}				
	return score;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N = s.nextInt(); 
			tab[i] = new Solution(N);
			for(int j=0;j<N;j++){tab[i].F[j] = s.nextInt();}
			for(int j=0;j<N;j++){tab[i].P[j] = s.nextInt();}
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		s.close();
		
	}
}

