package interview.service.impl;

import interview.api.dto.Triangle;
import interview.api.types.TriangleType;
import interview.service.Classifier;

public class TriangleClassifier implements Classifier<Triangle, TriangleType> {

	public TriangleType classify(Triangle t) {

		if (!exists(t)) {
			throw new IllegalArgumentException("Zero edged triangle");
		}

		if (isDegenerate(t)) {
			throw new IllegalArgumentException("Degenerate triangle");
		}

		if (t.getSideA() == t.getSideB() && t.getSideB() == t.getSideC()
				&& t.getSideA() == t.getSideC()) {
			return TriangleType.EQUILATERAL;
		} else if (t.getSideA() == t.getSideB() || t.getSideB() == t.getSideC()
				|| t.getSideA() == t.getSideC()) {
			return TriangleType.ISOSCELES;
		} else if (t.getSideA() != t.getSideB() && t.getSideB() != t.getSideC()
				&& t.getSideA() != t.getSideC()) {
			return TriangleType.SCALENE;
		} else {
			throw new RuntimeException("Inclassifiable triangle");
		}

	}

	/**
	 * Check for co linearity of triangle's vertices.
	 * 
	 * @param t
	 * @return
	 */
	private boolean isDegenerate(Triangle t) {

		return (t.getSideA() + t.getSideB() == t.getSideC())
				|| (t.getSideB() + t.getSideC() == t.getSideA())
				|| (t.getSideC() + t.getSideA() == t.getSideB());

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
	private boolean exists(Triangle t) {

		return (t.getSideA() + t.getSideB() > t.getSideC())
				&& (t.getSideB() + t.getSideC() > t.getSideA())
				&& (t.getSideC() + t.getSideA() > t.getSideB());
	}

	/**
	 * Same as above but using semiperimeter to assert triangle's existence.
	 * exists2() can substitute exist().
	 * 
	 * @param t
	 * @return
	 */
	private boolean exists2(Triangle t) {

		int max = Math.max(Math.max(t.getSideA(), t.getSideB()), t.getSideC());

		int s = (t.getSideA() + t.getSideB() + t.getSideC());
		return max < s;
	}
}
