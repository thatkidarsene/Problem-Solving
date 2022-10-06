import java.util.*;
public class Solution {
int N; int D; int C; int M; String S;
public Solution(int N, int D, int C, int M, String S){
	this.N = N; this.D= D; this.C = C; this.M = M; this.S = S;
}
public String toString(){
	return "N : "+N+" D : "+D+" C : "+C+" M : "+M+" S : "+S;
}

public static String solve(Solution s){
	int dog = s.D;
	int cat = s.C;
	if(s.S.lastIndexOf("D")==-1){return "YES";}
	for(int i=0;i<=s.S.lastIndexOf("D");i++){
		if( ((dog==0)&&(s.S.charAt(i)=='D')) || ((cat==0)&&(s.S.charAt(i)=='C'))){return "NO"; }
		if(s.S.charAt(i)=='D'){dog--;cat+=s.M;}else{cat--;}
	}
	if(dog>=0 ){return "YES";}else{return "NO"; }
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N = s.nextInt(); int D = s.nextInt(); int C = s.nextInt(); int M = s.nextInt();
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String S = s.nextLine();
			tab[i] = new Solution(N,D,C,M,S);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}