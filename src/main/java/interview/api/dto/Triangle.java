package interview.api.dto;

/**
 * Using primitives for triangle sides since none of them can be nullable.
 * 
 * @author niko.strongioglou
 *
 */
public class Triangle implements Shape {

	private int sideA;
	private int sideB;
	private int sideC;

	public Triangle() {

	}

	public Triangle(int sideA, int sideB, int sideC) {
		super();
		this.sideA = Math.abs(sideA);
		this.sideB = Math.abs(sideB);
		this.sideC = Math.abs(sideC);
	}

	public int getSideA() {
		return sideA;
	}

	public void setSideA(int sideA) {
		this.sideA = sideA;
	}

	public int getSideB() {
		return sideB;
	}

	public void setSideB(int sideB) {
		this.sideB = sideB;
	}

	public int getSideC() {
		return sideC;
	}

	public void setSideC(int sideC) {
		this.sideC = sideC;
	}

	public void addAllSides(int[] sides) {

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
