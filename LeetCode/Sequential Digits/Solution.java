import java.util.*;
class Solution {
    public static List<Integer> sequentialDigits(int low, int high) {
        if(low==high){return new ArrayList<Integer>();}
        List l = new ArrayList<Integer>();
        int i = low;
        if(isSN(i)){l.add(i);}
        while(i<high){
            System.out.println("i : "+i);
            int next = nextSN(i);
            System.out.println("next sn after "+i+" is "+next);
            if(next==-1){return l;}
            l.add(next);
            i=next;
        }
        if((int)l.get(l.size()-1)>high){l.remove(l.get(l.size()-1));}
return l;

    }
    public static boolean isSN(int n){
        String s = Integer.toString(n);
        if(s.length()==1){return false;}
        boolean b = true;
        for(int i=1;i<s.length();i++){
            b = b &&(s.charAt(i)==s.charAt(i-1)+1);
        }
        return b;
    }
    public static int nextSN(int n){
        if(n>=123456789){return -1;}
        String s = Integer.toString(n);
        System.out.println(" s : "+s);
        if(isSN(n)){
            System.out.println("true");
            int d; char begin;
            if(s.charAt(0)<'9'-s.length()+1){
                System.out.println("if");
                d = s.length();begin=(char)(s.charAt(0)+1);}
            else{
                System.out.println("else");
                d = s.length()+1;begin='1';}
            return createSN(d,begin);
        }
         if(s.charAt(0)>'9'-s.length()+1){System.out.println("limit");return createSN(s.length()+1,'1');}
        int i=0;
        System.out.println("s : "+s+" char i : "+s.charAt(i)+" char i+1 : "+s.charAt(i+1));
        while(s.charAt(i)==(char)(s.charAt(i+1)-1)){System.out.println("i before increment : "+i);i++;}
        System.out.println("out of while i="+i);
        if(s.charAt(i)>=(char)s.charAt(i+1)+1){System.out.println("if");return createSN(s.length(),s.charAt(0));}else{ System.out.println("else");
            return createSN(s.length(),(char)(s.charAt(0)+1));
        }
  
    }
    public static int createSN(int length,char start){
        String s = "";
        if(length>9){return -1;}
        if((int)(start-'0')>(int)(9-length+1)){return createSN(length+1,'1');}
        for(int i=0;i<length;i++){s+=(char)(start+i);}
            return new Integer(s);
    }
    public static void main(String[] args) {
        List l = sequentialDigits(0,100);
        System.out.println(l);
    }
}