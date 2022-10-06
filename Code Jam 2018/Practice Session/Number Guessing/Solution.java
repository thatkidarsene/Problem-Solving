import java.util.*;
public class Solution {
int A; 
int B;
int N;

public Solution(int A, int B, int N){
	this.A = A; this.B= B; this.N=N;
}


public static void solve(Solution s){
	Scanner sc = new Scanner(System.in);
	
	
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int A = s.nextInt(); int B = s.nextInt(); int N = s.nextInt();
			tab[i] = new Solution(A,B,N);
			int guess = (A+B)/2;
	int left = A+1;
	int right = B;
	String response;
	for(int j=0;j<N;j++){
		System.out.println(guess);
		s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		response = s.nextLine();
		if(response.equals("CORRECT")){
			break;
		}else if(response.equals("TOO_SMALL")){
				left = guess+1;
				guess = (left+right)/2;
		}else{
				right = guess-1;
				guess = (left+right)/2;
		}
	}

		}
		// for(int i=0;i<tab.length;i++){
		// 	solve(tab[i]);
		// }
		
	}
}