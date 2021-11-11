public class ArrayHelp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		
		/*
		 * the above statement is array declaration.
		 * it creates arr "reference"known as "arr"
		 * but it doesn't reference to any integer collection YET.
		 * hence we can't access array items like arr[0] or arr[1] ..
		 * neither can we access the length of the array using arr.length 
		 */
		
		arr = new int[5];
		
		/*
		 * this is an instantiation statement. it does the following things -
		 * the "new int[5]" part allocates a block of memory for 5 integers (20 bytes)
		 * the "arr = " part makes "arr" refer to that block of the memory.
		 * the first integer in that block is then accessed by arr[0]
		 * the second integer is accessed by arr[1]
		 * ...
		 * the first integer is accessed by arr[ arr.length - 1 ]
		 * (as arr.length - 1 is the index of the last item
		 */
		
		for(int i=0; i < arr.length; i++) // for each valid index
			System.out.print(arr[i]+" "); //each item separated by a space
		System.out.println(); //change the line 
		
		/*
		 * above three lines display the array
		 * (you CANNOT display the array directly like System.out.println(arr); )
		 */
		
		for(int i=0; i < arr.length; i++) // for each valid index
			arr[i] = 2*i + 1; //populates the array items in a pattern
		
		for(int i=0; i < arr.length; i++) // for each valid index
			System.out.print(arr[i]+" "); //each item separated by a space
		System.out.println(); //change the line 
		
		int lastItem = getLast(arr); 
		/*
		 * the above method call ( getLast(arr) ) passes "arr" to getLast as "a"
		 * this makes "a" refer to the same block of memory that "arr" refers to.
		 * this is called a shallow copy. any changes you make to items of "a"
		 * would be made to items of "arr"
		 */
		System.out.println("last item is: "+lastItem);
		
		changeLastItem(arr, lastItem + 5);
		
		for(int i=0; i < arr.length; i++) // for each valid index
			System.out.print(arr[i]+" "); //each item separated by a space
		System.out.println(); //change the line 
		
		lastItem = getLast(arr); //get the updated last item
		System.out.println("last item is: "+lastItem);
		
		//next we assign some test values to arr item
		//notice the lack of pattern preventing us form doing with in a loop
		arr[0] = -5;
		arr[1] = 3;
		arr[2] = 4;
		arr[3] = 0;
		arr[4] = -6;
		
		for(int i=0; i < arr.length; i++) // for each valid index
			System.out.print(arr[i]+" "); //each item separated by a space
		System.out.println(); //change the line 
		
		int nPos = countPositives(arr);
		
		System.out.println(nPos+" positive numbers in the array");
	}

	/**
	 * the following method assumes that the passed array is instantiated
	 * and contains at least one item. we'll see how to eliminate this 
	 * assumption later during the unit
	 * @param a
	 * @return the last item in the array
	 */
	public static int getLast(int[] a) {
		// TODO Auto-generated method stub
		return a [ a.length - 1 ];
	}


	/**
	 * the following method assumes that the passed array is instantiated
	 * and contains at least one item, and changes the last item to the 
	 * second parameter (updated)
	 * @param a
	 * @param updated
	 */
	public static void changeLastItem(int[] a, int updated) {
		// TODO Auto-generated method stub
		a[ a.length - 1 ] = updated;
	}
	
	/**
	 * the following method assumes that the passed array is instantiated
	 * and contains at least one item
	 * 
	 * @param arr
	 * @return number of positive values ( > 0) in the array
	 */
	public static int countPositives(int[] a) {
		// TODO Auto-generated method stub
		int count = 0; //a counter to keep track of how many positives are there
		for(int i=0; i < a.length; i++) //for each item in the array
			if(a[i] > 0)  //check if it's positive
				count++; //and if so, add 1 to the count
		return count; //return the number of positives stored in count
	}

}
