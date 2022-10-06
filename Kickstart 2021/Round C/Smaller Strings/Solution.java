import java.util.*;
import java.math.BigInteger;
public class Solution {
int N; int K;
String S;

public Solution(int N, int K,String S){
	this.N = N; this.K= K; this.S = S; 
}
public String toString(){
	return "N : "+N+" K : "+K+" S : "+S;
}

public static int solve(Solution s){
	if(s.N==1){return (int)(s.S.charAt(0)-'a');}
	long mod  = 1000000007;
	String largest = s.S.substring(0,(int)Math.ceil(s.N/2.0));
	long count = 0;
	for(int i=0;i<largest.length()-1;i++){
		count  += (int)(largest.charAt(i)-'a');
		count%=mod;
		count = (count*s.K)%mod;
	}
		long last = (int)(largest.charAt(largest.length()-1)-'a');
		count += last;
		StringBuilder stb =  new StringBuilder();
		stb.append(largest);
		stb.append(new StringBuilder(s.S.substring(0,s.S.length()/2)).reverse());
		String last_palindrome = stb.toString();
			if(last_palindrome.compareTo(s.S)<0){count++;}
	return (int)(count%mod);
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N = s.nextInt(); int K = s.nextInt();
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String S = s.nextLine();
			tab[i] = new Solution(N,K,S);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}