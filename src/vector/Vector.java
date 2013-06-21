package vector;

/**
 * Vector representation as an array of numbers.
 * Supports various simple arithmetic operations.
 * 
 * @author Robert Illner
 * @version 1.0.0-0001
 *
 */
public class Vector {
	
	private int len;
	private double [] vec;
	
	
	/**
	 * Constructs a non-initialized vector.
	 */
	public Vector () {
		len = 0;
		vec = null;
	}
	
	/**
	 * Constructs a vector with the given length.
	 * @param length - length of the new vector.
	 */
	public Vector (int length) {
		try {
			len = length;
			vec = new double [length];
		}
		catch (NegativeArraySizeException e) {
			System.out.println("ERROR: invalid length parameter. length has to greather than -1.");
		}
		
	}
	
	/**
	 * Constructs a vector containing the values of the given vector.
	 * @param vector - a vector whose values will be copied.
	 */
	public Vector (Vector vector) {
		len = vector.getLength();
		vec = new double [len];
		copyValues(this, vector);
		
	}
	
	/**
	 * Returns the length of the calling vector.
	 */
	public int getLength() {
		return this.len;
	}
	
	/**
	 * Gets the value at position pos of this vector.
	 * @param pos - the index of the position of the value to find.
	 * @return the value at position pos.
	 */
	public double getAt(int pos) {
		return this.vec[pos];
	}
	
	/**
	 * Sets the value at position pos to the given value.
	 * @param pos - position of the value to set.
	 * @param value - the value to set.
	 */
	public void setAt(int pos, double value) {
		this.vec[pos] = value;
	}
	
	/**
	 * Copies the values of vector vecB into vector vecA.
	 * If vecA is as long as vecB, vecA will become a copy of vecB.
	 * If vecA is longer than vecB, the remaining values of vecA will remain unchanged.
	 * If vecB is longer than vecA, the remaining values of vecB will be ignored.
	 * @param vecA - the vector receiving the new values.
	 * @param vecB - the vector containing the values to copy.
	 */
	public static void copyValues(Vector vecA, Vector vecB) {
		int vals;
		if (vecA.getLength() <= vecB.getLength())
			vals = vecA.getLength();
		else
			vals = vecB.getLength();
		for (int i = 0; i < vals; i++) {
			vecA.setAt(i, vecB.getAt(i));
		}
	}
	
	public static void main(String[] args) {
		System.out.println();
	}

}
