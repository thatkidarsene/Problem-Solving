import java.util.*;
public class Solution {
int N; 
int []D;
public Solution(int N){
	this.N = N; 
	this.D= new int[N]; 
}

public static int solve(Solution s){
	int left = 0;
	int right = s.D.length-1;
	int n = 0;
	int best = Integer.MIN_VALUE;
	int min;
	min = s.D[left]<s.D[right]?left:right;	
	//System.out.println("min:"+min);
	while(left<=right){
	//System.out.println("min:"+min+"best : "+best);

		if(min==left){
			if(s.D[left]>=best){
				best = s.D[left];
				n++;
			}
			//System.out.println("left1:"+left);
			left++;
			//System.out.println("left2:"+left);
			//System.out.println("its left, best:"+best);			
		}
		else{
			if(s.D[right]>=best){
				best = s.D[right];	
				n++;
				}
			right--;
			//System.out.println("its right, best:"+best);			
				}
		
		//System.out.println("left:"+left+"right:"+right);	
			if(left==right){
			if(s.D[left]>=best){n++;}
				break;
			}
		min = s.D[left]<s.D[right]?left:right;	
		//System.out.println("min:"+min);	
	}
	return n;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N = s.nextInt();
			tab[i] = new Solution(N);
			for(int j=0;j<N;j++){
				tab[i].D[j] = s.nextInt();
			}
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}