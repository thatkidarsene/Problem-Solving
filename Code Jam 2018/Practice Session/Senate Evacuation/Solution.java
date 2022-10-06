import java.util.*;
public class Solution {
int N; 
int []D;
String S;
public Solution(int N){
	this.N = N; this.D= new int[N] ;
}

public static String solve(Solution s){
	
	return "";
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N = s.nextInt();
			tab[i] = new Solution(N);
			for(int j=0;j<N;j++){
				tab[i].D[j] = s.nextInt();
			}
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}