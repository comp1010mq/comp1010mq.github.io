package comp125;

import static org.junit.Assert.*;

import org.junit.Test;

public class SphereTest {

	@Test
	/**
	 * the expected values for radius = 1, 1.5 are taken from google
	 */
	public void testVolume() {
		assertEquals(0, new Sphere(0).volume(), 0.01);
		assertEquals(4.19, new Sphere(1).volume(), 0.01);
		assertEquals(14.14, new Sphere(1.5).volume(), 0.01);
	}

	@Test
	/**
	 * implement this test to test for correctness of the surfaceArea() method from class Sphere
	 */
	public void testSurfaceArea() {
		fail("Not yet implemented");
	}

}
