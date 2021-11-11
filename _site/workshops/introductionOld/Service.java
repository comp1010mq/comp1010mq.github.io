public class Service {
	/**
	@param n - assume it's positive
	@return sum of the first n positive integers (1+2+...+n)
	*/
	public static int sum(int n) {
		return n*(n+1)/2;
	}

	public static double average(int a, int b) {
		return (a+b)/2; //buggy
	}
}