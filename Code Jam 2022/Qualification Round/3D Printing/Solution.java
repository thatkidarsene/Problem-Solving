import java.util.*;
public class Solution {
int M[][] = new int[3][4]; 

public static int maxIndex(int[] tab){
	int max = 0;
	for(int i=1;i<tab.length;i++)
		if(tab[i]>max)
			max = i;
	return max;
}
public static void printArray(int[] arr){
	for(int i=1;i<arr.length;i++){
		System.out.println(arr[i]+" ");
	}
}

public static int[] minTab(int[][] tab){
	int res[] = new int[tab[0].length];
	for(int i=0;i<res.length;i++){res[i] = Integer. MAX_VALUE;}
	//printArray(res);
	for(int col=0;col<tab[0].length;col++){
		for(int row=0;row<tab.length;row++){
			if(tab[row][col]<res[col]){res[col]=tab[row][col];}
		}
	}
	return res;
}

public static String solve(Solution s){
	int tab[] = minTab(s.M);
	if((tab[0]+tab[1]+tab[2]+tab[3])<1000000){return "IMPOSSIBLE";}else{
		int sum = tab[0]+tab[1]+tab[2]+tab[3];
		if(sum!=1000000){
			int extra = sum-1000000;
			int highest = maxIndex(tab);
			for(int i=0;i<tab.length;i++){
				tab[i] -= (int)((tab[i]*1.0/sum)*extra);
			}
			sum = tab[0]+tab[1]+tab[2]+tab[3];
			if(sum!=1000000){
				extra = sum-1000000;
				tab[highest] -= extra;
			}

		}
		return Integer.toString(tab[0])+" "+Integer.toString(tab[1])+" "+Integer.toString(tab[2])+" "+Integer.toString(tab[3]); 
	}
	
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			tab[i] = new Solution();
			for(int row=0;row<3;row++){
				for(int col=0;col<4;col++){
					tab[i].M[row][col] = s.nextInt();
				}
			}
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}