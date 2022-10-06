import java.util.*;
import java.util.stream.*;
class Test{
	public static void printArray(int[] arr){
		String s="[";
		for(int i=0;i<arr.length;i++){s+= (i==arr.length-1)?arr[i]:arr[i]+",";}
			System.out.println(s+"]");
	}
	public static void main(String[] args) {
		
		int[] arr = {1,1,2,-3,-4,3,4,3,0,1,4,0,5,8,9,5,6};
		int[] index = new int[arr.length];
		for(int i=0;i<arr.length;i++){index[i]=i;}
		printArray(arr);
		int[] sortedIndices = IntStream.range(0, arr.length)
                .boxed().sorted((i, j) -> arr[i] - arr[j])
                .mapToInt(ele -> ele).toArray();
		printArray(sortedIndices);
	}
}