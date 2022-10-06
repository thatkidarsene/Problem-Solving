import java.util.*;
class GenSubsets{

	public static void printAllSubsets(ArrayList list){
		for(int i=0;i<Math.pow(2,list.size());i++){
			System.out.print("i : "+i);
			ArrayList subset = new ArrayList();
			for(int j=0;j<list.size();j++){
				//System.out.println("Checking if element number "+j+" is present ");
				if((i&1<<j)==(1<<j)){
					//System.out.println("yes it is present! adding it...");
					subset.add(list.get(j));
				}
			}
			System.out.println("\t"+subset);
		}
	}
	public static void main(String[] args) {
		ArrayList<String> set = new ArrayList<String>();
		set.add("Circle");set.add("Triangle");set.add("Curve");set.add("Trapezium");set.add("Star");
		printAllSubsets(set);
	}
}