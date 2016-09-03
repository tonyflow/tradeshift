package interview;

import interview.api.Type;
import interview.api.dto.Triangle;
import interview.service.impl.TriangleClassifier;

import java.util.Scanner;

/**
 * This is the entry point of our application. It can be tested as a standalone module or can
 * @author niko.strongioglou
 *
 */
public class TriangleClassifierApplication {

	public static void main(String[] args) {

		TriangleClassifier triangleClassifier = new TriangleClassifier();

		Scanner s = new Scanner(System.in);

		System.out.println("Welcome to the triangle classifier!");
		System.out
				.println("Give the sides as input or type exit on next to terminate the classifier");

		
		String next="";
		
		while (!next.equalsIgnoreCase("exit")) {
			
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

				Type type = triangleClassifier.classify(triangle);

				System.out.println("Input triangle is a " + type);

			} catch (Exception e) {
				System.out
						.println("Unclassifiable triangle. Please try again with a different input");
			} finally {
				s.close();
			}
			
			
			System.out.print("next?  ");
//			next = s.nextLine();
			
		}
		
		
		

	}

}
