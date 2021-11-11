import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class ServiceTest {
	@Test @Graded(description="sum(int)", marks=10)
	public void testSum() {
		assertEquals(55, Service.sum(10));
	}

	@Test @Graded(description="average(int, int)", marks=10)
	public void testAverage() {
		assertEquals(4.0, Service.average(3, 5), 0.01);
		assertEquals(2.5, Service.average(1, 4), 0.01);
	}
}