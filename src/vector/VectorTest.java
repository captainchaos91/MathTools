package vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector a = new Vector(4);
		a.setAt(0, 5);
		a.setAt(1, 4);
		a.setAt(2, 1);
		a.setAt(3, 0);
		Vector b = new Vector(5);
		b.setAt(0, 2);
		b.setAt(1, -7);
		b.setAt(2, 3);
		b.setAt(3, 1);
		b.setAt(4, -1);
		System.out.println(a.getdotProduct(b));

	}

}
