package vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector a = new Vector(4);
		a.setAt(0, 5);
		a.setAt(1, 4);
		a.setAt(2, 1);
		a.setAt(3, 0);
		System.out.println(a.getEuclideanNorm());

	}

}
