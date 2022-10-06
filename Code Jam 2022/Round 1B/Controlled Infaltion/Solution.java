import java.util.*;
public class Solution {
int N; 
int P;
long [][]D;
public Solution(int N, int P){
	this.N =N ; this.P =P ; 
	this.D = new long[N][P];
}

public static long getSum(long[] tab){
	long res=0;
	for(int i=0;i<tab.length-1;i++){
		res += tab[i+1]-tab[i];
	}
	return res;
}

public static long getAcross(long[][] tab, int index, int edge){
	long res=0;
	long min;
	if(edge==0){
		long d1 = Math.abs(tab[index][0] - tab[index+1][tab[index+1].length-1]);
	long d2 = Math.abs(tab[index][0] - tab[index+1][0]);
	min = d1<d2?d1:d2;
	edge = d1<d2?0:1;
	return min;
		
	}else{
			long d3 = Math.abs(tab[index][tab[index].length-1] - tab[index+1][tab[index+1].length-1]);
	long d4= Math.abs(tab[index][tab[index].length-1] - tab[index+1][0]);
	min = d3<d4?d3:d4;
	edge = d3<d4?0:1;
	return min;
	}
}
public static long solve(Solution s){
	// ArrayList<Integer>[] tab = (ArrayList<Integer>[]) new ArrayList[s.N];
	// for(int i=0;i<s.N;i++){
	// 	for(int j=0;j<s.P;j++){
	// 		tab[i].add(s.D[i][j]);
	// 	}
	// }
	Arrays.sort(s.D[0]);
	long res = 0;
	res += s.D[0][0]<s.D[0][s.D[0].length-1]?s.D[0][0]:s.D[0][s.D[0].length-1];
	//System.out.println("res:"+res);
	res += getSum(s.D[0]);
	//System.out.println("res:"+res);

	long d1 = Math.abs(s.D[0][0] - s.D[0+1][s.D[0+1].length-1]);
	long d2 = Math.abs(s.D[0][0] - s.D[0+1][0]);
	long d3 = Math.abs(s.D[0][s.D[0].length-1] - s.D[0+1][s.D[0+1].length-1]);
	long d4= Math.abs(s.D[0][s.D[0].length-1] - s.D[0+1][0]);
	//System.out.println("d1:"+d1);
	//System.out.println("d2:"+d2);
	//System.out.println("d3:"+d3);
	//System.out.println("d4:"+d4);
	long min;
	int edge;
	if(s.D[0][0]<s.D[0][s.D[0].length-1]){
		min = d3<d4?d3:d4;
		edge = 1;
	}else{
		min = d1<d2?d1:d2;
		edge = 0;
	}
	////System.out.println("min:"+min);
	//System.out.println("edge:"+edge);
	res+=min;
	//res += getAcross(s.D,0,edge);
	//System.out.println("res:"+res);
	for(int i=1;i<s.N;i++){

		// //System.out.println("i:"+i);
		Arrays.sort(s.D[i]);
		// //System.out.println("getsum : "+getSum(s.D[i]));
		res += getSum(s.D[i]);
		if(i<s.N-1){
			// //System.out.println("getAcross : "+getAcross(s.D,i));
			res += getAcross(s.D,i,edge);
		}
	}
	
	// for(int i=0;i<s.N;i++){
	// 	Arrays.sort(tab[i]);
	// }
	return res;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N = s.nextInt(); int P = s.nextInt();
			tab[i] = new Solution(N,P);
			for(int j=0;j<N;j++){
				for(int k=0;k<P;k++){
					tab[i].D[j][k] = s.nextInt();
				}
			}
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}