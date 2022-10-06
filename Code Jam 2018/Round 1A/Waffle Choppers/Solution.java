//FROM 2018 ROUND 1A
import java.util.*;
public class Solution {
int N;
int []D;
String S;
String [];
char;
char [];
public Solution(int , int [], char , char [], String[] ){
	this. = ; this.= ; this. = ; this. = ; this. = ; this. = ;
}
public String toString(){
	return " : "++"  : "++"  : "++"  : "++"  : "+;
}

public static  solve(Solution s){
	
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int  = s.nextInt(); int  = s.nextInt(); int  = s.nextInt(); int  = s.nextInt();
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String  = s.nextLine();
			tab[i] = new Solution(,,,,);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}