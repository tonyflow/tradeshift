package interview.service;

import interview.api.Type;
import interview.api.dto.Shape;

/**
 * Basic interface for any {@code Classifier}. Like the
 * {@code TriangleClassifier}.
 * 
 * @author niko.strongioglou
 *
 * @param <S>
 * @param <T>
 */
public interface Classifier<S extends Shape, T extends Type> {

	T classify(S s);

}
