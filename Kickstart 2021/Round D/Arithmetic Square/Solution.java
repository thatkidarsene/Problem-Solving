import java.util.*;
public class Solution {
int G00,G01,G02,G10,G12,G20,G21,G22; 

public Solution(int G00, int G01, int G02, int G10, int G12,int G20, int G21, int G22){
	this.G00 = G00; this.G01 = G01; this.G02 = G02;
	this.G10 = G10; this.G12 = G12;
	this.G20 = G20; this.G21 = G21; this.G22 = G22;
}
public String toString(){
	return "";
}

public static int solve(Solution s){
	int out =0;
	if(s.G00+s.G02==2*s.G01){out++;}
	if(s.G00+s.G20==2*s.G10){out++;}
	if(s.G02+s.G22==2*s.G12){out++;}
	if(s.G20+s.G22==2*s.G21){out++;}
	int n1 = s.G01+s.G21;
	int n2 = s.G10+s.G12;
	int n3 = s.G00+s.G22;
	int n4 = s.G02+s.G20;
	int size = 0;
	if(n1%2==0){size++;}if(n2%2==0){size++;}if(n3%2==0){size++;}if(n4%2==0){size++;}
	if(size==0){return out;}
	int[] arr = {n1,n2,n3,n4};
	Arrays.sort(arr);
	int best=1;
	int count=1;
	for(int i=0;i<arr.length-1;i++){
		if(arr[i]%2==0 && arr[i]==arr[i+1]){count++; best=(best<count)?count:best;}else{count=1;}
	}
	out+=best;
	return out;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int G00  = s.nextInt(); int G01 = s.nextInt(); int G02 = s.nextInt();  
			int G10 = s.nextInt(); int G12 = s.nextInt(); 
			int G20 = s.nextInt(); int G21 = s.nextInt(); int G22 = s.nextInt();
			tab[i] = new Solution(G00,G01,G02,G10,G12,G20,G21,G22);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}