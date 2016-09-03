package interview;

import interview.api.Type;
import interview.api.dto.Triangle;
import interview.api.types.TriangleType;
import interview.service.impl.TriangleClassifier;

import java.util.Scanner;

/**
 * This is the entry point of our application. It can be tested as a standalone
 * module or its behavior can be verified by its accompanying unit tests.
 * 
 * @author niko.strongioglou
 *
 */
public class TriangleClassifierApplication {

	public static void main(String[] args) {

		TriangleClassifier triangleClassifier = new TriangleClassifier();

		Scanner s = new Scanner(System.in);

		System.out.println("Welcome to the triangle classifier!");
		System.out
				.println("Give the sides of the triangle as input for classification. \n"
						+ "Answer with 'yes' or 'no' when prompted with continue.");

		String next = "yes";

		while (next.equalsIgnoreCase("yes")) {

			System.out.print("Side A : ");
			int sideA = s.nextInt();
			s.nextLine();

			System.out.print("Side B : ");
			int sideB = s.nextInt();
			s.nextLine();

			System.out.print("Side C : ");
			int sideC = s.nextInt();
			s.nextLine();

			Triangle triangle = new Triangle(sideA, sideB, sideC);

			System.out.println("Trying to classify " + triangle.toString());

			try {

				TriangleType type = triangleClassifier.classify(triangle);

				System.out.println("Input triangle is a " + type);

			} catch (IllegalArgumentException e) {

				System.out.println("Unclassifiable triangle. "
						+ "Please try again with a different input."
						+ e.getMessage());

			} catch (Exception e) {

				s.close();
				throw new RuntimeException("An unrecoverable exception occured");
			}

			System.out.print("continue?  ");
			next = s.nextLine();

		}

		System.out.println("Terminating triangle classification application");
		s.close();

	}

}
