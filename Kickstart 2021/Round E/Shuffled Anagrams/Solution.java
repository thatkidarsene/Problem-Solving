import java.util.*;
import java.util.stream.*;
public class Solution {
String S;
public Solution(String S){
	this.S =S ;
}
public String toString(){
	return S;
}
public static void printArray(int[] arr){
		String s="[";
		for(int i=0;i<arr.length;i++){s+= (i==arr.length-1)?arr[i]:arr[i]+",";}
		System.out.println(s+"]");
	}
public static String solve(Solution s) {
	int[] count = new int[26];
	for (int i = 0; i < s.S.length(); i++) {
		count[(int) s.S.charAt(i) - 'a']++;
	}
    Arrays.sort(count);
	if(count[count.length-1]>s.S.length()/2){return "IMPOSSIBLE";}
	char[] ch_arr = s.S.toCharArray();
	Arrays.sort(ch_arr);
	String sorted_s = new String(ch_arr);
	String s1 = sorted_s.substring(0,sorted_s.length()/2);
	String s2 = sorted_s.substring(sorted_s.length()/2,sorted_s.length());
	String match_s = s2+s1;
	StringBuffer sol =  new StringBuffer(s.S);
	boolean[] visited = new boolean[s.S.length()];
	for(int i=0;i<s.S.length();i++) {
		for (int j = 0; j < sorted_s.length(); j++) {
			if (!visited[j] && s.S.charAt(i) == sorted_s.charAt(j)) {
				sol.setCharAt(i, match_s.charAt(j));
				visited[j] = true;
				break;
			}
		}
	}
    return  sol.toString();
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String  S = s.nextLine();
			tab[i] = new Solution(S);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		s.close();
	}
}