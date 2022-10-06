import java.util.*;
import java.util.stream.*;
public class Solution {
int N; 
String[] D;
public Solution(int N){
	this.N = N; 
	this.D=  new String[N];
}

 // //add to the end of the list
 //    stringList.add(random);

 //    //add to the beginning of the list
 //    stringList.add(0,  random);

public static boolean check(String s){
		boolean b= true;
	for(int i=0;i<s.length();i++){
		char c = s.charAt(i);
		int first = s.indexOf(c);
		int last=0;
	for(int j=0;j<s.length();j++){
		if(s.charAt(j) == c){
			last =j;
		}
	}
	//////System.out.println("c:"+c+" first:"+first+" last:"+last);
	for(int k=first;k<=last;k++){
		//////System.out.println("k="+k+"char is "+s.charAt(k));
		b = b&&(s.charAt(k)==c);
	}
	}
	return b;
}

public static String LTR(ArrayList<String> list){
	String s ="";
	for(String str:list){
		s+=str;
	}
	return s;
}

// public static boolean AA(boolean[] tab){
// 	boolean res = true;

// }

// public static String BFsolve(Solution s){
// 	List <String> list = Arrays.asList(s.D);
// 	List l2 = generatePerm(list);
// 	for(Object l:l2){
// 		//System.out.println(l);
// 	}
// return "";
// }


public static String solve(Solution s){
	ArrayList<String> tab = new ArrayList<String>();
	String[] duet = new String[s.D.length];
	int[] count = new int[26];
	for(int i=0;i<s.D.length;i++){
		int tmp = (int)(s.D[i].charAt(0)-'A');
		count[tmp]++;
		if(s.D[i].length()>1){
		int tmp2 = (int)(s.D[i].charAt(s.D[i].length()-1)-'A');
		count[tmp2]++;
		}

		//////System.out.println((i+1)+"st string tmp :"+tmp+" tmp2:"+tmp2);
	}
	int[] countS = IntStream.range(0, count.length)
                .boxed().sorted((i, j) -> count[i]<count[j]?1:-1 )
                .mapToInt(ele -> ele).toArray();
    for(int i=0;i<countS.length;i++){
    	////System.out.println(count[i]+" ");
    }
    ////System.out.println("");
    for(int i=0;i<countS.length;i++){
    	////System.out.println(countS[i]+" ");
    }
      //////System.out.println("");
    boolean[] added = new boolean[s.D.length];
    for(int i=0;i<countS.length;i++){
		if(count[countS[i]]==0){//////System.out.println("breaking");
		break;
	}
		for(int j=0;j<s.D.length;j++){
			int p = countS[i];
			char q = (char)('A'+p);
			//System.out.println("i: "+i+" j:"+j+" processing char + "+q);
			//System.out.println("added "+j+" : "+added[j]);
			//( s.D[j].indexOf(q)==0 || s.D[j].indexOf(q)==s.D[j].length()-1 )
			if(s.D[j].indexOf(q)!=-1&&!added[j]){
				if(tab.isEmpty()){//////System.out.println("empty");
				tab.add(s.D[j]);
			}else{
				// ArrayList<String> ts = tab;
				// //System.out.println("saving ts : "+LTR(ts));
				tab.add(s.D[j]);
				if(!check(LTR(tab))){
					//System.out.println("check wrong reverting");
					tab.remove(tab.size()-1);
					
					tab.add(0,s.D[j]);
					//System.out.println("after revert:"+LTR(tab));
				}

			}
				added[j] = true;
			}
			//System.out.println("current string : "+LTR(tab));
		}
		////System.out.println("check "+LTR(tab)+" : "+check(LTR(tab)));
		if(!check(LTR(tab))){
			return "IMPOSSIBLE";
		}
	}
	if(check(LTR(tab))){return LTR(tab);}else{
		return "IMPOSSIBLE";
	}
}







	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		Solution tab[] = new Solution[T];
		for(int i=0;i<T;i++){
			int N = s.nextInt(); 
			tab[i] = new Solution(N);
			for(int j=0;j<N;j++){
				s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				tab[i].D[j] = s.next();;
			}
		}
		for(int i=0;i<tab.length;i++){
			System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
		}
		
	}
}