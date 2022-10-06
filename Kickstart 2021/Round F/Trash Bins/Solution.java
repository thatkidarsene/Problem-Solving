import java.util.*;
public class Solution {
int N;
String S;
public Solution(int N,String S){
	this.N= N; this.S= S;
}
public String toString(){
	return "";
}
public static void printArray(int[] arr){
		String s="[";
		for(int i=0;i<arr.length;i++){s+= (i==arr.length-1)?arr[i]:arr[i]+",";}
			System.out.println(s+"]");
	}
public static int min(int a,int b){
	return (a<b)?a:b;
}


public static long solve(Solution s){
	int[] store = new int[s.N];
	int first=0,last=0;
	for(int i=0;i<s.N;i++) {if(s.S.charAt(i)=='1'){first=i;break;}}
	for(int i=0;i<s.N;i++) {if(s.S.charAt(i)=='1'){last=i;}}
	for(int i=0;i<=first;i++){store[i]=first-i;}
	int next=first;
	int prev=next;
	int k=prev;
	while(next<last){
		while(s.S.charAt(k+1)!='1'){k++;}
		next=k+1;
		for(int i=prev+1;i<=next;i++){store[i]=min(i-prev,next-i);}
		prev=next;
		k=prev;
	}
	for(int i=last;i<s.N;i++){store[i]=i-last;}

	System.out.println("Store : ");
	printArray(store);
	long sum=0;
	for(int i=0;i<s.N;i++){sum+=store[i];}
	return sum;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N= s.nextInt();
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String S = s.nextLine();
			tab[i] = new Solution(N,S);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}