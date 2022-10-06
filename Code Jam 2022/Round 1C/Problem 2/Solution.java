import java.util.*;
public class Solution {
int N; 
int K;
int []D;
public Solution(int N, int K){
	this.N = N; this.K= K;
	this.D = new int [N];
}


public static String solve(Solution s){
	
	long A=0;
	long C=0;

	for(int i=0;i<s.D.length;i++){
		C+= s.D[i]*s.D[i];
	}
	for(int i=0;i<s.D.length;i++){
		A+= s.D[i];
	}
	if (A==0 && C==0){return "1";}
	double b = (C-A*A)/(2.0*A);
	if ((b == Math.floor(b)) && !Double.isInfinite(b)) {
    return Long.toString((long)b);
}else{

	return "IMPOSSIBLE";
}
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N = s.nextInt(); int K = s.nextInt();
			tab[i] = new Solution(N,K);
			for(int j=0;j<N;j++){
				tab[i].D[j] = s.nextInt();
			}
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}