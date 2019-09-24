// Complete a variety of calculations of matrix 

package matrix;

public class Matrix {

	private double[][] values;

	/**
	 * The Matrix is based on the supplied two-dimensional array of values.
	 * @param values
	 */
	public Matrix(double[][] in) {
		double[][] copy = new double[in.length][in[0].length]; 
		for (int i = 0 ; i < in.length ; ++i) {
			for (int j = 0 ; j < in[0].length ; ++j) {
				copy[i][j] = in[i][j];
			}
		}
		values = copy; 
	}

	public double getValue(int row, int col) {
		return this.values[row][col];  
	}

	public int getNumRows() {
		return values.length; 
	}

	public int getNumCols() {
		return values[0].length;
	}

	/**
	 * Arrays one and two are considered
	 * equal if and only if:
	 *   1) They have the same shape (number of rows and columns agree)
	 *   2) The contents of the two arrays are the same, element by element
	 * @param one
	 * @param two
	 * @return true iff the arrays have the same shape and contents
	 */
	private static boolean arraysAreEqual(double[][] one, double[][] two) {
		if (one.length != two.length) {
			return false;
		}
		else {
			for (int i = 0; i < one.length; ++i) {
				if (one[i].length != two[i].length) {
					return false;
				}
			}
			for (int i = 0 ; i < one.length ; ++i) {
				for (int j = 0 ; j < one[i].length ; ++j) {
					if (one[i][j] != two[i][j]) {
						return false;
					}}}}
		return true; 
	}
	/**
	 * This was generated initially by eclipse, but
	 *   eclipse does not know how to compare two-dimensional arrays.
	 *   We therefore call arraysAreEequal to do that job.
	 */
	public boolean equals(Object obj) {
		// If this and obj are the same object, they must be equal
		if (this == obj)
			return true;
		// If obj is null ("this" cannot be null), then they are not equal
		if (obj == null)
			return false;
		// If the two objects are not the same type, they are not equal
		if (getClass() != obj.getClass())
			return false;
		//
		// If we get here, we have two objects of the same type.
		// Calling your helper method to determine the arrays' equality.
		Matrix other = (Matrix) obj;
		return arraysAreEqual(this.values, other.values);
	}
	public Matrix plus(Matrix other) {

		double[][] ans = new double[this.getNumRows()][this.getNumCols()];
		if (this.getNumRows() == other.getNumRows() && this.getNumCols() == other.getNumCols()){
			for (int i = 0 ; i < this.getNumRows(); ++i) {
				for (int j = 0 ; j < this.getNumCols(); ++j) {
					ans[i][j] = this.values[i][j] + other.values[i][j];
				}}
			return new Matrix(ans); 
		}
		else {
			throw new IllegalArgumentException("Not Same Size");
		}
	}
	/**
	 * Returns a **new Matrix** that is the product of this and the other one.
	 * Does not change this Matrix at all.
	 * @param other
	 * @return
	 */
	public Matrix times(Matrix other) {
		double[][] ans = new double[this.getNumRows()][other.getNumCols()];
		if (this.values[0].length == other.values.length){
			for (int i = 0 ; i < this.values.length; ++i) {
				for (int j = 0 ; j < other.values[0].length; ++j) {
					for(int c = 0; c < this.values[0].length; c++)
						ans[i][j] += this.values[i][c] * other.values[c][j];
				}
			}
			return new Matrix(ans);
		}
		else {
			throw new IllegalArgumentException("Not Applicable");
		}
	}
	/**
	 * Returns a **new Matrix** that is the transpose of this one.
	 * Does not change this Matrix at all.
	 * @return
	 */
	public Matrix transpose() {
		double[][] ans = new double[this.getNumCols()][this.getNumRows()];
		for (int i = 0 ; i < this.getNumRows(); ++i) {
			for (int j = 0 ; j < this.getNumCols(); ++j) {
				ans[j][i] = this.values[i][j];
			}
		}		
		return  new Matrix(ans); 
	}
	/**
	 * Modifies this Matrix by scaling row i by the supplied factor.
	 * @param i the row to scale, where 0 is the top row
	 * @param factor the amount by which to scale each element of row i
	 */
	public void scaleRow(int i, double factor) {
		if (i < this.values.length) {
			for (int j = 0 ; j < this.values[i].length ; ++j) {
				this.values[i][j] = this.values[i][j]*factor;
			}
		}
		else {			
			throw new IllegalArgumentException("Wrong Length");
		}
	}

/**
 * Modifies this matrix by adding row i to row j.  Row 0 is the top row.
 * @param i
 * @param j
 */
public void addRows(int i, int j) {
	for (int r = 0 ; r < this.getNumRows() ; ++r) {
		for (int c = 0 ; c < this.getNumCols() ; ++c) {
			if (r == j) {
				this.values[r][c] = this.getValue(i, c)+this.getValue(r, c);
			}
		}
	}
}

/**
 * Modifies the Matrix by exchanging row i with row j
 * @param i
 * @param j
 */
public void exchangeRows(int i, int j){
	double[] store = new double[this.getNumCols()];
	for (int c = 0 ; c < this.getNumCols(); ++c) {
		store[c] = this.values[i][c];
		this.values[i][c] = this.values[j][c];
		this.values[j][c] = store[c];
	}
}

/**
 * This returns a String representation of
 * the Matrix.  The contents of each row is separated by a tab (\t)
 * so that columns (kind of) line up.  Each row is separated by a
 * newline (\n) so that the output looks like a matrix.  The output
 * of this method should <i>not</i> be used to compare matrices for
 * equality:  use the .equals(Object) method instead!
 */
public String toString() {
	String ans = "";
	for (int i=0; i < values.length; ++i) {
		ans = ans + "\n";
		// Loop below assumes all rows have the same number of columns
		for (int j=0; j < values[0].length; ++j) {
			ans = ans + values[i][j] + "\t";
		}
	}
	return ans;
}

}
