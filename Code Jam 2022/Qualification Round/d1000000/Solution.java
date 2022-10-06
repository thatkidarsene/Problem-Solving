import java.util.*;
public class Solution {
int N; 
int sides[];
public Solution(int N){
	this.N = N;
	sides = new int[N];
}


public static int solve(Solution s){
	Arrays.sort(s.sides);
	int count = 0;
	// for(int i=0;i<s.sides.length;i++){
	// 	System.out.print(s.sides[i]+" ");
	// }
	// 	System.out.print(" ");
	// int[] counts = new int[s.N];
	int dest = 1;
	for(int i=0;i<s.sides.length;i++){
		if((s.sides[i]-dest)>=0){
			dest++;
			count++;
		}
	}
	// System.out.print(" ");
	// for(int i=0;i<counts.length;i++){
	// 	System.out.print(counts[i]+" ");
	// }


	
	// int pointer = 0;
	// int number = counts[0];
	// for(int i=1;i<counts.length;i++){
	// 	if(number<=counts[i]){number--;}else{number = counts[i];}
	// 	counts[i] = number;
	// }
	// System.out.println("");
	// System.out.println("...");

	// for(int i=0;i<counts.length;i++){
	// 	System.out.print(counts[i]+" ");
	// }
	// System.out.println("");
	// System.out.println("...");
	// while(pointer<s.N && counts[pointer]>0){
	// 	count++;
	// 	pointer++;
	// }
	
	return count;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N = s.nextInt();
			tab[i] = new Solution(N);
			for(int j=0;j<N;j++){
				tab[i].sides[j] = s.nextInt();
			}
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}