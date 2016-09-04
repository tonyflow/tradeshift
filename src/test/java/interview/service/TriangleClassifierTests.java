package interview.service;

import static org.junit.Assert.*;
import junit.framework.Assert;
import interview.api.Type;
import interview.api.dto.Triangle;
import interview.api.types.TriangleType;
import interview.service.impl.TriangleClassifier;

import org.junit.Before;
import org.junit.Test;

public class TriangleClassifierTests {

	private TriangleClassifier triangleClassifier = new TriangleClassifier();

	@Before
	public void setup() {

	}

	/**
	 * Verify correct classification of an equilateral triangle.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEquilateral() throws Exception {

		Triangle triangle = new Triangle(1, 1, 1);

		Type type = triangleClassifier.classify(triangle);

		Assert.assertEquals(TriangleType.EQUILATERAL, type);

	}

	/**
	 * Verify correct classification of an isosceles triangle.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIsosceles() throws Exception {

		Triangle triangle = new Triangle(2, 2, 1);

		Type type = triangleClassifier.classify(triangle);

		Assert.assertEquals(TriangleType.ISOSCELES, type);

	}

	/**
	 * Verify correct classification of an scalene triangle.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testScalene() throws Exception {

		// Triangle triangle = new Triangle(54, 145, 119);

		Triangle triangle = new Triangle(2, 5, 4);
		Type type = triangleClassifier.classify(triangle);

		Assert.assertEquals(TriangleType.SCALENE, type);

	}

	/**
	 * Triangle with a zero area and colinear vertices. A degenerate triangle.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDegenerate() throws Exception {

		Triangle triangle = new Triangle(2, 1, 3);

		try {
			triangleClassifier.classify(triangle);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Degenerate triangle", e.getMessage());
		}

	}

	/**
	 * Expecting an IllegalArgumentException to be produced as a result of a
	 * zero length side as data input. This case can be deduced to a case of a
	 * non existent triangle for we cannot apply the inequality principle for a
	 * triangle (0,2,1).
	 * 
	 * @throws Exception
	 */
	@Test
	public void testZeroSide() throws Exception {

		Triangle triangle = new Triangle(0, 2, 1);

		try {
			triangleClassifier.classify(triangle);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(
					"Triangle formation principle is not satisfied",
					e.getMessage());
		}

	}

	/**
	 * Classifier can handle negative length by deducing their absolute values.
	 * Classification will proceed normally after absolute value is retrieved.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNegativeSide() throws Exception {

		Triangle triangle = new Triangle(-1, -1, -1);

		TriangleType type = triangleClassifier.classify(triangle);

		Assert.assertEquals(TriangleType.EQUILATERAL, type);

	}

	/**
	 * Specify sides in a way which does not form a triangle.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNonExistent() throws Exception {

		Triangle triangle = new Triangle(1, 1, 4);

		try {
			triangleClassifier.classify(triangle);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(
					"Triangle formation principle is not satisfied",
					e.getMessage());
		}

	}

}
