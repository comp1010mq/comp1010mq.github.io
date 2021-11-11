import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AllInOneTest {

	@Test
	void testIsSquare() {
		assertTrue(AllInOne.isSquare(49));
		assertFalse(AllInOne.isSquare(-49));
		assertTrue(AllInOne.isSquare(0));
		assertTrue(AllInOne.isSquare(121));
		assertFalse(AllInOne.isSquare(80));
	}

	@Test
	void testAllSquares() {
		int[] nullArray = null;
		assertFalse(AllInOne.allSquares(nullArray)); 

		int[] a = {1, 4, 25, 100, 64};
		assertTrue(AllInOne.allSquares(a));
		
		int[] b = {1, 4, 253, 100, 64};
		assertFalse(AllInOne.allSquares(b));

		int[] c = {1, 4, -25, 100, 64};
		assertFalse(AllInOne.allSquares(c));

		int[] d = {};
		assertTrue(AllInOne.allSquares(d));
	}

	@Test
	void testCountPositiveEvens() {
		int[] nullArray = null;
		assertEquals(0, AllInOne.countPositiveEvens(nullArray)); 
		
		int[] a = {1, 4, 25, 100, 64};
		assertEquals(3, AllInOne.countPositiveEvens(a)); 
			
		int[] b = {1, -4, 25, -100};
		assertEquals(0, AllInOne.countPositiveEvens(b)); 

		int[] c = {6, 1, 14, 25, 100, 0, 0, 64};
		assertEquals(4, AllInOne.countPositiveEvens(c)); 
	}

}
