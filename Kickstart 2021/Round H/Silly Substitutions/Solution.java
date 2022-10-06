import java.util.*;
public class Solution {
int N; 
String S;

public Solution(int N,String S){
	this. N=N ; this.S= S;
}
public String toString(){
	return "";
}
public static String transform(String res){
	res = res.replace("01","2");
		res = res.replace("12","3");
		res = res.replace("23","4");
		res = res.replace("34","5");
		res = res.replace("45","6");
		res = res.replace("56","7");
		res = res.replace("67","8");
		res = res.replace("78","9");
		res = res.replace("89","0");
		res = res.replace("90","1");
		return res;
}
public static String solve(Solution s){
	String res = s.S;
	boolean b = true;
	while(b){
		res = transform(res);
		String check = transform(res);
		if(res.equals(check)){b=false;}
	}
	return res;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int  N = s.nextInt(); 
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String S = s.nextLine();
			tab[i] = new Solution(N,S);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}