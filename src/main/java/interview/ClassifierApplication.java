package interview;

import interview.api.Type;
import interview.api.dto.Shape;
import interview.api.dto.Triangle;
import interview.api.types.TriangleType;
import interview.factory.ClassifierFactory;
import interview.service.Classifier;
import interview.service.impl.TriangleClassifier;

import java.util.Scanner;

/**
 * This is the entry point of our application. It can be tested as a standalone
 * module or its behavior can be verified by its accompanying unit tests.
 * 
 * @author niko.strongioglou
 *
 */
public class ClassifierApplication {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		ClassifierFactory classifierFactory = new ClassifierFactory();

		Scanner scanner = new Scanner(System.in);

		System.out
				.print("Welcome to the shape classifier! \n"
						+ "What kind of shape would you want to classify (triangle etc...)?");

		String shape = scanner.nextLine();

		Classifier classifier = classifierFactory.getClassifier(shape);

		String next = "yes";

		while (next.equalsIgnoreCase("yes")) {

			Shape s  = classifier.getShape(scanner);

			System.out.println("Trying to classify " + s.toString());

			try {

				Type type = classifier.classify(s);

				System.out.println("Input shape is a " + type);

			} catch (IllegalArgumentException e) {

				System.out.println("Unclassifiable shape. "
						+ "Please try again with a different input."
						+ e.getMessage());

			} catch (Exception e) {

				scanner.close();
				throw new RuntimeException("An unrecoverable exception occured");
			}

			System.out.print("continue? ('yes' or 'no')  ");
			next = scanner.nextLine();

		}

		System.out.println("Terminating shape classification application");
		scanner.close();

	}

}
