package interview.service;

import interview.api.Type;
import interview.api.dto.Shape;

public interface Classifier<S extends Shape,T extends Type> {
	
	T classify(S s);

}
