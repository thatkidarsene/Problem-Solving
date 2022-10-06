import java.util.*;
public class Solution {
int N; 
int K;
String S;
public Solution(int N, int K, String S){
	this.N = N; this.K=K ; this.S =S ;
}
public String toString(){
	return " ";
}

public static int solve(Solution s){
	int score = 0;
	for(int i=0;i<(s.N+1)/2;i++){
		if(s.S.charAt(i)!=s.S.charAt(s.N-1-i)){score++;}
	}
	return Math.abs(score-s.K);
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int  N= s.nextInt(); int K = s.nextInt();
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String S = s.nextLine();
			tab[i] = new Solution(N,K,S);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}