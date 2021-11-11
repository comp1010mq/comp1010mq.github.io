
public class AllInOne {

	/**
	 * 
	 * @param n
	 * @return true if n is a perfect square, false otherwise.
	 * return true if array is empty.
	 */
	public static boolean isSquare(int n) {
		int root = (int)Math.sqrt(n);
		if(root * root == n)
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @param data
	 * @return true if every item of the array is a square, false otherwise.
	 * return true if array is empty.
	 * return false if array is null
	 */
	public static boolean allSquares(int[] data) {
		if(data == null)
			return false;
		for(int i=0; i < data.length; i++) {
			if(!isSquare(data[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param data
	 * @return number of positive even numbers in the array.
	 * for example, if data = {18, 2, -40, 13, -19, 4}, return 3
	 * as 18, 2 and 4 are the three numbers that are both even AND positive
	 * IMPORTANT: return 0 if array is null
	 */
	public static int countPositiveEvens(int[] data) {
		return 0; //to be completed
	}

}
