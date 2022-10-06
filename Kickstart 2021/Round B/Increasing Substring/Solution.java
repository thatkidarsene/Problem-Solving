import java.util.*;
public class Solution {
int N;
String S;
public Solution(int N, String S ){
	this.N =N ; this.S= S;
}
public String toString(){
	return "";
}

public static String solve(Solution s){
	if(s.N==1){return "1";}
	char[] arr = s.S.toCharArray();
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(count);
	for(int i=1;i<s.N;i++){
	if(arr[i]>arr[i-1] ){
			count++; 
		}
		else{count=1; 
	}
	list.add(count);
	} 
	String t = list.toString();
	t=t.replace("[","");
	t=t.replace("]","");
	t=t.replace(", "," ");
	return t;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int  N= s.nextInt();
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String S = s.nextLine();
			tab[i] = new Solution(N,S);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}