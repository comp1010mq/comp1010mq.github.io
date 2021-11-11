public class RectangleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(-5, 8);
				
		System.out.println(rect.area());
		
		Rectangle other = new Rectangle(1.4);
		System.out.println(other.area());
		
		Rectangle third = new Rectangle();
		System.out.println(third.area());
		
		System.out.println(rect);
		System.out.println(other);
		System.out.println(third);
	}

}
