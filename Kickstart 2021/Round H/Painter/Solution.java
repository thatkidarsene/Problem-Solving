import java.util.*;
public class Solution {
int N; 
String P;

public Solution(int N,String P){
	this. N=N ; this.P= P;
}
public String toString(){
	return "";
}

public static int solve(Solution s){
	char[] red = new char[s.N]; Arrays.fill(red,'/');
	char[] blue = new char[s.N]; Arrays.fill(blue,'/');
	char[] yellow = new char[s.N]; Arrays.fill(yellow,'/');
	for(int i=0;i<s.N;i++){
				switch(s.P.charAt(i)) {
		  case 'U':
		    break;
		  case 'R':
		    red[i]='R';
		    break;
		  case 'Y':
		    yellow[i]='Y';
		    break;
		  case 'B':
		    blue[i]='B';
		    break;
		  case 'O':
		    red[i]='R';
		    yellow[i]='Y';
		    break;
		  case 'P':
		    red[i]='R';
		    blue[i]='B';
		    break;
		  case 'G':
		    blue[i]='B';
		    yellow[i]='Y';
		    break;
		  case 'A':
		 	red[i]='R';
		    blue[i]='B';
		    yellow[i]='Y';
		    break;
		  default:
		    // code block
		}
	}
	int res=0;
//	System.out.println("red: "+new String(red));
//	System.out.println("blue: "+new String(blue));
//	System.out.println("yellow: "+ new String(yellow));
	for(int i=0;i<s.N-1;i++){
		int prev=res;
		if(red[i]!=red[i+1] && red[i]!='/'){res++;}
		prev=res;
		if(yellow[i]!=yellow[i+1] && yellow[i]!='/'){res++;}
		prev=res;
		if(blue[i]!=blue[i+1] && blue[i]!='/'){res++;}
	}
			if(red[s.N-1]!='/'){
				//System.out.println("red, "+" adding one...");
			res++;}
			if(yellow[s.N-1]!='/'){
				//System.out.println("yellow, "+" adding one...");
			res++;}
			if(blue[s.N-1]!='/'){
				//System.out.println("blue, "+" adding one...");
			res++;}

	return res;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int  N = s.nextInt(); 
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String P = s.nextLine();
			tab[i] = new Solution(N,P);
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}