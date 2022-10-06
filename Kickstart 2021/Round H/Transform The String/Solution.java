import java.util.*;
public class Solution {
String S;
String F;
public Solution(String S,String F ){
	this.S =S ; this.F= F; }
public String toString(){
	return "";
}

public static int pscore(char c1, char c2){
	char b1 = (c1<c2)?c1:c2;
	char b2 = (c1<c2)?c2:c1;
	//System.out.println("b1 : "+b1+" b2 : "+b2);
	//System.out.println("b1-b2 : "+(b1-b2));
	return ((int)(b2-b1)<13)?(int)(b2-b1):(int)((int)('z'-b2)+(int)(b1-'a')+1);
}
public static int solve(Solution s){
	int res=0;
	for(int i=0;i<s.S.length();i++){
		int min =Integer.MAX_VALUE;
		for(int j=0;j<s.F.length();j++){
			char c1 = s.S.charAt(i);
			char c2 = s.F.charAt(j);
			int tmp= pscore(s.S.charAt(i),s.F.charAt(j));
			//System.out.println("pscore "+c1+" "+c2+" = "+tmp);
			min = (min<tmp)?min:tmp;
			//System.out.println("min:"+min);
		}
		res+=min;
		//System.out.println("res:"+res);
	}
	return res;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String S  = s.nextLine();
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String F  = s.nextLine();
			tab[i] = new Solution(S,F);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}