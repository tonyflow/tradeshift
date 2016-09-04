package interview.service.impl;

import interview.api.dto.Triangle;
import interview.api.types.TriangleType;
import interview.service.Classifier;

public class TriangleClassifier implements Classifier<Triangle, TriangleType> {

	public TriangleType classify(Triangle t) {

		int a = (t.getSideA().add(t.getSideB())).compareTo(t.getSideC());
		int b = (t.getSideB().add(t.getSideC())).compareTo(t.getSideA());
		int c = (t.getSideC().add(t.getSideA())).compareTo(t.getSideB());

		if (isDegenerate(a, b, c)) {
			throw new IllegalArgumentException("Degenerate triangle");
		}

		if (!exists(a, b, c)) {
			throw new IllegalArgumentException(
					"Triangle formation principle is not satisfied");
		}

		if (equilateral(t)) {
			return TriangleType.EQUILATERAL;
		} else if (isosceles(t)) {
			return TriangleType.ISOSCELES;
		} else if (scalene(t)) {
			return TriangleType.SCALENE;
		} else {
			throw new RuntimeException("Unrecovarable exception triangle");
		}

	}

	private boolean isosceles(Triangle t) {

		return (t.getSideA().compareTo(t.getSideB()) == 0)
				|| (t.getSideB().compareTo(t.getSideC()) == 0)
				|| (t.getSideA().compareTo(t.getSideC()) == 0);

	}

	private boolean equilateral(Triangle t) {

		return (t.getSideA().compareTo(t.getSideB()) == 0)
				&& (t.getSideB().compareTo(t.getSideC()) == 0)
				&& (t.getSideA().compareTo(t.getSideC()) == 0);

	}

	private boolean scalene(Triangle t) {

		if (t.getSideA().compareTo(t.getSideB()) > 0
				|| t.getSideA().compareTo(t.getSideB()) < 0) {
			if (t.getSideB().compareTo(t.getSideC()) > 0
					|| t.getSideB().compareTo(t.getSideC()) < 0) {
				if (t.getSideA().compareTo(t.getSideC()) > 0
						|| t.getSideA().compareTo(t.getSideC()) > 0) {
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * Check for co linearity of triangle's vertices.
	 * 
	 * @param t
	 * @return
	 */
	private boolean isDegenerate(int a, int b, int c) {

		return a == 0 || b == 0 || c == 0;
		//
		// return (t.getSideA() + t.getSideB() == t.getSideC())
		// || (t.getSideB() + t.getSideC() == t.getSideA())
		// || (t.getSideC() + t.getSideA() == t.getSideB());

	}

	/**
	 * The function below implements programmatically the triangle inequality.
	 * This mathematical principle states that for any triangle, the sum of the
	 * lengths of any two sides must be greater than or equal to the length f
	 * the remaining side. The formula is :
	 * 
	 * a < b + c && b < a + c && c < a + b OR the semiperimeter can be used :
	 * 
	 * max(a,b,c)<s,s=(a+b+c)/2
	 * 
	 * @param t
	 * @return
	 */
	private boolean exists(int a, int b, int c) {

		return a == 1 && b == 1 && c == 1;
		//
		// return (t.getSideA() + t.getSideB() >= t.getSideC())
		// && (t.getSideB() + t.getSideC() >= t.getSideA())
		// && (t.getSideC() + t.getSideA() >= t.getSideB());
	}

}
