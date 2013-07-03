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
	 * Constructs a vector with the given length. The given length has to be equal to or greather than zero.
	 * @param length - length of the new vector.
	 * @throws NegativeArraySizeException
	 */
	public Vector (int length) throws NegativeArraySizeException {
		try {
			len = length;
			vec = new double [length];
		}
		catch (NegativeArraySizeException e) {
			System.out.println("EXCEPTION: invalid length parameter. length has to greather than -1.");
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
	 * Returns the length (number of elements) of the calling vector.
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
	public void copyValues(Vector vecA, Vector vecB) {
		int vals;
		if (vecA.getLength() <= vecB.getLength())
			vals = vecA.getLength();
		else
			vals = vecB.getLength();
		for (int i = 0; i < vals; i++) {
			vecA.setAt(i, vecB.getAt(i));
		}
	}
	
	/**
	 * Adds the given vector to the calling vector. The length of these vectors has to be equal.
	 * @param vec - the vector to add to the calling vector.
	 * @return - the result of the addition as a new Vector-Object.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public Vector add(Vector vec) throws ArrayIndexOutOfBoundsException {
		Vector result = new Vector(this.getLength());
		if (this.getLength() == vec.getLength())	
		{
			for (int i = 0; i < vec.getLength(); i++) {
				result.setAt(i, this.getAt(i) + vec.getAt(i));
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("EXCEPTION: Can't add those vectors because their length isn't equal!");
		}
		return result;
	}
	
	/**
	 * Subtracts the given vector from the calling vector. The length of these vectors has to be equal.
	 * @param vec - the vector to subtract from the calling vector.
	 * @return - the result of the subtraction as a new Vector-Object.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public Vector sub(Vector vec) throws ArrayIndexOutOfBoundsException {
		Vector result = new Vector(this.getLength());
		if (this.getLength() == vec.getLength())	
		{
			for (int i = 0; i < vec.getLength(); i++) {
				result.setAt(i, this.getAt(i) - vec.getAt(i));
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("EXCEPTION: Can't substract those vectors because their length isn't equal!");
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.getLength(); i++) {
			result += this.getAt(i) + "\n";
		}
		return result;
	}
	
	/**
	 * Sets all values of the calling vector to the given value.
	 * @param value - the value to set all values to.
	 */
	public void fill(double value) {
		for (int i = 0; i < this.getLength(); i++) {
			this.setAt(i, value);
		}
	}
	
	/**
	 * Gets the euclidean norm of the calling vector.
	 * @return - the result of the euclidean norm.
	 */
	public double getEuclideanNorm() {
		double sum = 0;
		for (int i = 0; i < this.getLength(); i++) {
			sum += Math.pow(this.getAt(i), 2);
		}
		return Math.sqrt(sum);
	}
	
	/**
	 * Multiplies the calling vector with the given scalar.
	 * @param scalar - the scalar the calling vector will be multiplied with.
	 * @return - the result vector.
	 */
	public Vector multWithScalar(double scalar) {
		Vector result = new Vector(this.getLength());
		for (int i = 0; i < this.getLength(); i++) {
			result.setAt(i, this.getAt(i) * scalar);
		}
		return result;
	}
	
	/**
	 * Gets the dot product of the calling vector and the given vector. The length of these vectors has to be equal.
	 * @param vec - the second vector for the dot product.
	 * @return - the result as a double value.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public double getdotProduct(Vector vec) throws ArrayIndexOutOfBoundsException {
		double result;
		if (this.getLength() == vec.getLength()) {
			result = 0.0;
			for (int i = 0; i < this.getLength(); i++) {
				result += this.getAt(i) * vec.getAt(i);
			}
		}
		else {
			throw new ArrayIndexOutOfBoundsException("EXCEPTION: The length of the given vector has to be equal to the length of the calling vector!");
		}
		return result;
	}
	
	/**
	 * Gets the cross product of the calling vector and the given vector. The length of this vectors has to be 3.
	 * @param vec - the second vector.
	 * @return . the result as a new Vector-Object.
	 * @throws ArithmeticException
	 */
	public Vector getCrossProduct(Vector vec) throws ArithmeticException {
		Vector result = new Vector(3);
		if ((this.getLength() == vec.getLength()) && (this.getLength() == 3)) {
			result.setAt(0, (this.getAt(1) * vec.getAt(2)) - (this.getAt(2) * vec.getAt(1)));
			result.setAt(1, (this.getAt(2) * vec.getAt(0)) - (this.getAt(0) * vec.getAt(2)));
			result.setAt(2, (this.getAt(0) * vec.getAt(1)) - (this.getAt(1) * vec.getAt(0)));
		}
		else {
			throw new ArithmeticException("EXCEPTION: The length of the given vector and the calling vector has to be 3!");
		}
		return result;
	}
	
	/**
	 * Proofs if the two given vectors are orthogonal of each other.
	 * @param vec1 - first vector.
	 * @param vec2 - second vector.
	 * @return - true, if the vectors are orthogonal to each other. Otherwise false.
	 */
	public boolean areOrthogonal(Vector vec1, Vector vec2) {
		if (vec1.getdotProduct(vec2) == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Proofs if the calling vector is a unit vector.
	 * @return -true, if the calling vector is a unit vector. Otherwise false.
	 */
	public boolean isUnitVector() {
		if (this.getEuclideanNorm() == 0)
			return true;
		else
			return false;
	}
}