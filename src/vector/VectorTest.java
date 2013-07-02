package vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector b = new Vector(4);
		b.setAt(0, 1);
		b.setAt(1, 5);
		b.setAt(2, 4);
		b.setAt(3, 19);
		Vector a = new Vector(4);
		a.setAt(0, 5);
		a.setAt(1, 4);
		a.setAt(2, 1);
		a.setAt(3, 0);
		Vector c = new Vector(a.sub(b));
		System.out.println(c.toString());

	}

}
