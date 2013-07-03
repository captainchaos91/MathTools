package matrix;

import vector.Vector;

public class Matrix extends Vector {

	private int rows;
	private int cols;
	private Vector [] vecs;
	
	public Matrix () {
		
	}
	
	public Matrix (int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.vecs = new Vector [cols];
	}
	
	public Matrix (Matrix mat) {
		this.rows = mat.getRows();
		this.cols = mat.getCols();
		this.vecs = new Vector [mat.getCols()];
		for (int i = 0; i < mat.getCols(); i++) {
			this.setVecAt(i, mat.getVecAt(i));
		}
	}

	
	public Vector[] getVecs() {
		return vecs;
	}
	
	public Vector getVecAt(int pos) {
		return vecs[pos];
	}

	public void setVecAt(int pos, Vector vect) {
		this.vecs[pos] = vect;
	}
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
}
