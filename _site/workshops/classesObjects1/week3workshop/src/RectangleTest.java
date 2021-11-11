import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

	@Test
	void testSetWidth() {
		Rectangle r = new Rectangle();
		r.setWidth(6.4);
		assertEquals(6.4, r.getWidth(), 0.001);
		r.setWidth(-1.4);
		assertEquals(1.4, r.getWidth(), 0.001); 
		//1.4 should be assigned for -1.4
	}

	@Test
	void testSetHeight() {
		Rectangle r = new Rectangle();
		r.setHeight(6.2);
		assertEquals(6.2, r.getHeight(), 0.001);
		r.setHeight(-1.2);
		assertEquals(1.2, r.getHeight(), 0.001); 
		//1.2 should be assigned for -1.2
	}

	@Test
	void testRectangleDoubleDouble() {
		Rectangle r = new Rectangle(1.5, 2.8);
		assertEquals(1.5, r.getWidth(), 0.001); 
		assertEquals(2.8, r.getHeight(), 0.001);
		
		r = new Rectangle(-0.5, -5.8);
		assertEquals(0.5, r.getWidth(), 0.001); 
		assertEquals(5.8, r.getHeight(), 0.001);
	}

	@Test
	void testArea() {
		Rectangle r = new Rectangle(1.5, 2.8);
		assertEquals(4.2, r.area(), 0.001);
	}

	@Test 
	void testCompareTo() {
		Rectangle r = new Rectangle(1.5, 2.8);
		Rectangle s = new Rectangle(1.6, 2.5);
		Rectangle t = new Rectangle(1.5, 2.8);
		assertEquals(1, r.compareTo(s));
		assertEquals(-1, s.compareTo(r));
		assertEquals(0, r.compareTo(t));
	}
}
