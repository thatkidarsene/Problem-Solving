class MaxSubArray{
	public static int v1(int[] arr){
		int best=arr[0];
		for(int i=0;i<arr.length;i++){
			for(int j=i;j<arr.length;j++){
				int sum=0;
				for(int k=i;k<=j;k++){sum+=arr[k];}
	best = (sum<best)?best:sum;
		}
		}
		return best;
	}
	public static int v2(int[] arr){
		int best=arr[0];
		for(int i=0;i<arr.length;i++){
			int sum = 0;
			for(int j=i;j<arr.length;j++){
				sum+=arr[j];
				best = (sum<best)?best:sum;
			}
		}
		return best;
	}
	public static int v3(int[] arr){
		int best=arr[0];
		int sum=0;
		for(int k=0;k<arr.length;k++){
			sum = (sum+arr[k]<arr[k])?arr[k]:sum+arr[k];
			best = (sum<best)?best:sum;
		}
		return best;
	}

	public static void main(String[] args) {
		int[] arr = {-1,2,4,-3,5,2,-5,2};
		int[] arr2 = new int [2000];
		for(int i=0;i<2000;i++){
			arr2[i] = (int)(Math.random()*50)*(int)Math.pow(-1,(int)(Math.random()*2));
		}
			System.out.println("");
		System.out.println("Using first approach, maximum subarray sum is : "+v1(arr2));
		System.out.println("Using second approach, maximum subarray sum is : "+v2(arr2));
		System.out.println("Using third approach, maximum subarray sum is : "+v3(arr2));
	}
}