package interview.performance;

import static org.junit.Assert.*;
import interview.api.dto.Triangle;
import interview.api.types.TriangleType;
import interview.service.impl.TriangleClassifier;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import junit.framework.Assert;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

//TODO : Describe the way the tests were designed
/**
 * This is a test suite aimed to stretch the limits of the classifier
 * application in terms of heavy work load.
 * 
 * @author niko.strongioglou
 *
 */
public class PerformanceTests {

	private static final int BOUND = 100_001;
	TriangleClassifier triangleClassifier = new TriangleClassifier();

	@Before
	public void setup() {

	}

	/**
	 * Ran just to create the file for the stretch test. Creating a file
	 * containing the side sizes of 100,000 triangles whose types we have
	 * configured in advance.
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void testCreateTestFile() throws Exception {

		Path path = Paths.get("src/test/resources/triangles.txt");
		List<String> triangles = new ArrayList<String>();

		for (int i = 1; i < BOUND; i++) {

			// create equilaterals
			if (i < 20_000) {
				triangles.add(String.valueOf(i) + "," + String.valueOf(i) + ","
						+ String.valueOf(i));
			} else if (i >= 20_000 && i < 60_000) {
				// create isosceles
				triangles.add(String.valueOf(i) + "," + String.valueOf(i) + ","
						+ String.valueOf(i - 10));
			} else if (i >= 60_000 && i < 80_000) {
				// create scalene
				triangles.add(String.valueOf(i) + "," + String.valueOf(i + 3)
						+ "," + String.valueOf(i + 2));
			} else if (i >= 80_000 && i < 90_000) {
				// create degenerate
				triangles.add(String.valueOf(i) + "," + String.valueOf(1) + ","
						+ String.valueOf(i - 1));
			} else {
				// impossible triangles
				triangles.add(String.valueOf(0) + "," + String.valueOf(i) + ","
						+ String.valueOf(i - 1));
			}

		}

		Files.write(path, triangles, Charset.forName("UTF-8"));
	}

	/**
	 * Test opens the file created by the test above and verifies that there are
	 * "x" number of each. You may remove I/O to optimize execution speed.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStretch() throws Exception {

		ClassLoader loader = this.getClass().getClassLoader();
		InputStream resource = loader.getResourceAsStream("triangles.txt");
		String s = IOUtils.toString(resource, "UTF-8");
		StringTokenizer lineTokenizer = new StringTokenizer(s, "\n");

		int equilaterals = 0;
		int isosceles = 0;
		int scalenes = 0;
		int unclassifiable = 0;

		while (lineTokenizer.hasMoreTokens()) {

			StringTokenizer sidesTokenizer = new StringTokenizer(
					lineTokenizer.nextToken(), ",");

			int[] sides = new int[3];

			for (int i = 0; i < 3 && sidesTokenizer.hasMoreElements(); i++) {
				sides[i] = Integer.valueOf(sidesTokenizer.nextToken())
						.intValue();
			}

			Triangle t = new Triangle();
			t.addAllSides(sides);

			try {
				TriangleType type = triangleClassifier.classify(t);

				switch (type) {
				case EQUILATERAL:
					equilaterals++;
					break;
				case ISOSCELES:
					isosceles++;
					break;
				case SCALENE:
					scalenes++;
					break;
				}
			} catch (Exception e) {
				unclassifiable++;
			}

		}

		Assert.assertEquals(19999, equilaterals);
		Assert.assertEquals(40000, isosceles);
		Assert.assertEquals(20000, scalenes);
		Assert.assertEquals(20001, unclassifiable);

	}
}
