package interview.service;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Random;

import junit.framework.Assert;
import interview.api.Type;
import interview.api.dto.Triangle;
import interview.api.types.TriangleType;
import interview.service.impl.TriangleClassifier;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author niko.strongioglou
 *
 */
public class TriangleClassifierTests {

	private static final int ITERATIONS = 20;
	private TriangleClassifier triangleClassifier = new TriangleClassifier();

	@Before
	public void setup() {

	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void testBigInteger() throws Exception {

		Random r = new Random();

		for (int i = 0; i < ITERATIONS; i++) {
			try {

				System.out.println("New iteration");
				System.out.println("===================");
				BigInteger a = new BigInteger(234, r);
				System.out.println(a);
				System.out.println("===================");

				BigInteger b = new BigInteger(234, r);
				System.out.println(b);
				System.out.println("===================");

				BigInteger c = new BigInteger(234, r);
				System.out.println(c);
				System.out.println("===================");
				Triangle t = new Triangle(a, b, c);

				TriangleType type = triangleClassifier.classify(t);

				System.out.println(type);

			} catch (Exception e) {
				// Ignore exception
			}
		}

	}

	@Test
	public void testEquilateral() throws Exception {

		Triangle triangle = new Triangle(
				"11833632370446395214854056631093199051331476434357803453848900937883441",
				"11833632370446395214854056631093199051331476434357803453848900937883441",
				"11833632370446395214854056631093199051331476434357803453848900937883441");

		TriangleType type = triangleClassifier.classify(triangle);

		Assert.assertEquals(TriangleType.EQUILATERAL, type);
	}

	@Test
	public void testIsosceles() throws Exception {

		Triangle triangle = new Triangle(
				"11833632370446395214854056631093199051331476434357803453848900937883441",
				"11833632370446395214854056631093199051331476434357803453848900937883441",
				"10729950880438966206203973695927670591571770587487290293856422073363014");

		TriangleType type = triangleClassifier.classify(triangle);

		Assert.assertEquals(TriangleType.ISOSCELES, type);
	}

	@Test
	public void testScalene() throws Exception {

		Triangle triangle = new Triangle(
				"25175743036762384120037629208231877773111425443545756721812028389745738",
				"27555861801640861913529457930336028809396543542143973589631217547672018",
				"14608309176289070880681653718755881458519200159216768508139676928568665");

		TriangleType type = triangleClassifier.classify(triangle);

		Assert.assertEquals(TriangleType.SCALENE, type);
	}

}
