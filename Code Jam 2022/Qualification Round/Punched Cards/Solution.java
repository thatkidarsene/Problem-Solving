import java.util.*;
public class Solution {
int R;
int C;
public Solution(int R, int C){
	this.R = R; this.C= C;
}


public static void solve(Solution s){
	for(int i=0;i<2*s.R+1;i++){
		for(int j=0;j<2*s.C+1;j++){
			if(i%2==0){
				if(j%2==0){
					if(i==0 && j==0){System.out.print(".");}else{
					System.out.print("+");}
				}else{
					if(i==0 && j==1){System.out.print(".");}else{
					System.out.print("-");}
				}
			}else{
				if(j%2==0){
					if(i==1 && j==0){System.out.print(".");}else{
					System.out.print("|");}
				}else{
					System.out.print(".");
				}
			}
		}
		System.out.println("");
	}
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int R = s.nextInt(); int C = s.nextInt();
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			tab[i] = new Solution(R,C);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+":");
			solve(tab[i]);
		}
		
	}
}