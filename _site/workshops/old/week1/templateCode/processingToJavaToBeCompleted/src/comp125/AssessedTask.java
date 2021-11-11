package comp125;


public class AssessedTask {
	//worth 50% of the weekly mark
	public static int sum(int[] a) {
		int total = 0;
		for(int i=0; i<a.length; i++)
			total+=a[i];
		return total;
	}
	
	//worth 35% of the weekly mark
	public static int sumEven(int[] a) {
		int total = 0;
		for(int i=0; i<a.length; i++)
			if(a[i]%2 == 0)
				total+=a[i];
		return total;
	}
	
	//HD level, worth 15% of the weekly mark
	public static int countUnique(int[] a) {
		return 0; //TO BE COMPLETED
	}
	
	public static void main(String[] args) {
		//DO NOT MODIFY ANY PART OF MAIN METHOD
		int[] arr = {3,1,4,1,5,9,2,6,5};
		System.out.println(sum(arr)); //should be 36
		System.out.println(sumEven(arr)); //should be 12
		System.out.println(countUnique(arr)); //should be 5
	}
}

/*
static methods can only be *directly* called by other static methods
*/
