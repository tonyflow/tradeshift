package interview.api.dto;

import java.math.BigInteger;

/**
 * Using primitives for triangle sides since none of them can be nullable.
 * 
 * @author niko.strongioglou
 *
 */
public class Triangle implements Shape {

	private BigInteger sideA;
	private BigInteger sideB;
	private BigInteger sideC;

	public Triangle() {

	}

	public Triangle(BigInteger sideA, BigInteger sideB, BigInteger sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	public Triangle(String sideA, String sideB, String sideC) {
		this.sideA = new BigInteger(sideA);
		this.sideB = new BigInteger(sideB);
		this.sideC = new BigInteger(sideC);
	}

	public BigInteger getSideA() {
		return sideA;
	}

	public void setSideA(BigInteger sideA) {
		this.sideA = sideA;
	}

	public BigInteger getSideB() {
		return sideB;
	}

	public void setSideB(BigInteger sideB) {
		this.sideB = sideB;
	}

	public BigInteger getSideC() {
		return sideC;
	}

	public void setSideC(BigInteger sideC) {
		this.sideC = sideC;
	}

	public void addAllSides(BigInteger[] sides) {

		if (sides.length > 3) {
			throw new IllegalArgumentException("Triangle has only three sides");
		}

		this.setSideA(sides[0]);
		this.setSideB(sides[1]);
		this.setSideC(sides[2]);
	}

	@Override
	public String toString() {
		return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC="
				+ sideC + "]";
	}

}
