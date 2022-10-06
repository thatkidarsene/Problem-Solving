import java.util.*;
public class Solution {
int P;
int Q; 
Point[] D;

public Solution(int P, int Q){
	this.P = P; this.Q= Q;
	this.D = new Point[P];
}


public static String solve(Solution s){
	

	return "";
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int P = s.nextInt(); int Q = s.nextInt();
			tab[i] = new Solution(P,Q);
			for(int j=0;j<P;j++){
				int X = s.nextInt();
				int Y = s.nextInt();
				s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				char D = s.next().charAt(0);
				tab[i].D[j] = new Point(X,Y,D);
			}
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}



	public static final class Point{
	int X;
	int Y;
	char D;
	int count =0;
	public boolean iMT(Point P,int Q){
		if(D=='N' && Y<Q){return P.Y>Y;}else{
			if(D=='S' && Y>0){return P.Y<Y;}else{
				if(D=='E' && X<Q){return P.X>X;}else{
					if(D=='W' && X>0){return P.X<X;}
				}
			}
		}
		return false;
	}
	public  Point next(int Q){
		if(D=='N' && Y<Q){return new Point(X,Y+1,D);}else{
			if(D=='S' && Y>0){return new Point(X,Y-1,D);}else{
				if(D=='E' && X<Q){return new Point(X+1,Y,D);}else{
					if(D=='W' && X>0){return new Point(X-1,Y,D);}
				}
			}
		}
		return this;
	}
	public String toString(){
		return "("+X+","+Y+") moving "+D+" count : "+count;
	}
	public Point(int X,int Y,char D){
		this.X=X;
		this.Y=Y;
		this.D=D;
	}
}

}