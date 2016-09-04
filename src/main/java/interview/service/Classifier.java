package interview.service;

import java.util.Scanner;

import interview.api.Type;
import interview.api.dto.Shape;

public interface Classifier<S extends Shape,T extends Type> {
	
	S getShape(Scanner s);
	
	T classify(S s);

}
