public class Program1 {
	public static void main(String[] args) {
		int a = 147;
		int result = 0;
		System.out.println("number: "+a);
		while(a != 0) { //as long as there are digits left in the number
			result = result + 1; //counted another digit
			a = a / 10; //remove last digit from a
		}
		System.out.println("number of digits: "+result);
	}
}