import java.util.*;
class BinarySearchV2{
	public static int BS(int[] tab, int x){
		int k=0;
		for(int step=tab.length/2;step>=1;step/=2){
			while((k+step)<tab.length && tab[k+step]<=x){k+=step;}
		}
		return tab[k]==x?k:-1;
	}
	public static void main(String[] args) {
		int[] arr = {-5,-3,-1,2,2,2,4,5};
		Test.printArray(arr);
		System.out.println("Searching element "+2+" found at position : "+BS(arr,2));
		System.out.println("Searching element "+-5+" found at position : "+BS(arr,-5));
		System.out.println("Searching element "+4+" found at position : "+BS(arr,4));
		System.out.println("Searching element "+14+" found at position : "+BS(arr,14));
	}
}