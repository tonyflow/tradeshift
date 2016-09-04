package interview.factory;

import interview.service.Classifier;
import interview.service.impl.TriangleClassifier;

/**
 * A factory producing a number of {@code Classifier}s based on the kind of shape we
 * want to classify. The if / else cases can be extended to any number of shapes
 * and types.
 * 
 * @author niko.strongioglou
 *
 */
public class ClassifierFactory {

	@SuppressWarnings("rawtypes")
	public Classifier getClassifier(String shape) {

		if (shape.equalsIgnoreCase("triangle")) {
			return new TriangleClassifier();
		} else {
			throw new IllegalArgumentException(
					"No valid classifier for input string " + shape);
		}
	}

}
