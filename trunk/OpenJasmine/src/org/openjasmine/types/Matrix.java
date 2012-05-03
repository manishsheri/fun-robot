package org.openjasmine.types;

import org.openjasmine.exception.ComplexSizeMismatchException;

/**
 * Matrix class
 * @filename Matrix.java
 * @author Hyeon-min.Shim(elecage@gmail.com)
 */
public class Matrix implements Operation {

	/**
	 * Default Constructor
	 */
	public Matrix() {
		super();
		row = 3;	/// default row size = 3;
		col = 3;	/// default col size = 3;
		elements = new Object[row][col];
	}

	/**
	 * Constructor with size setting.<br>
	 * 크기를 설정하는 생성자.
	 * @param row row size of the Matrix class.
	 * @param col column size of the Matrix class.
	 */
	public Matrix(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		elements = new Object[row][col];
	}

	/**
	 * Constructor with size setting and initial value - all elements has same value.<br>
	 * 크기와 초기값을 설정하는 생성자. 모든 엘리먼트 값이 같도록 설정. 
	 * @param row row size of the Matrix class.
	 * @param col column size of the Matrix class.
	 * @param value initial value of each elements.
	 */
	public Matrix(int row, int col, Object value) {
		super();
		this.row = row;
		this.col = col;
		elements = new Object[row][col];
		
		int i, j;
		
		for(i = 0 ; i < row ; i++) {
			for(j = 0 ; j < col ; j++) {
				elements[i][j] = value;
			}
		}
	}
	
	/**
	 * Constructor with elements setting.
	 * @param elements element setting
	 */
	public Matrix(Object[][] elements) {
		super();
		this.elements = elements;
		this.row = elements.length;
		this.col = elements[0].length;
	}
	
	public Matrix(Matrix m) {
		this.row = m.getRow();
		this.col = m.getCol();
		this.elements = m.getElement();
	}

	/* (non-Javadoc)
	 * @see org.openjasmine.types.Operation#plus(java.lang.Object)
	 */
	@Override
	public Object plus(Object obj) {
		if(obj instanceof Matrix) {
			try {
				if(this.row != ((Matrix)obj).getRow() || this.col != ((Matrix)obj).getCol())
					throw new ComplexSizeMismatchException();
				
				Matrix result = new Matrix(this.row, this.col);
				Object[][] objElm = ((Matrix) obj).getElement();
				int i, j;
				if(elements instanceof Double[][]) {
					if(objElm instanceof Double[][]) {
						double value;
						
						for(i = 0 ; i < this.row ; i++) {
							for(j = 0 ; j < this.col ; j++) {
								value = ((Double)this.elements[i][j]).doubleValue() + ((Double)objElm[i][j]).doubleValue();
								result.setElement(i, j, value);
							}
						}
					}
					else if(objElm instanceof Complex[][]) {
						Complex value;
						
						for(i = 0 ; i < this.row ; i++) {
							for(j = 0 ; j < this.col ; j++) {
								value = (Complex) ((Complex)objElm[i][j]).plus(this.elements[i][j]);
								result.setElement(i, j, value);
							}
						}
					}
				}
				else if(elements instanceof Complex[][]) {
					Complex value;
					
					for(i = 0 ; i < this.row ; i++) {
						for(j = 0 ; j < this.col ; j++) {
							value = (Complex) ((Complex)this.elements[i][j]).plus(objElm[i][j]);
							result.setElement(i, j, value);
						}
					}
				}
				
				return result;
				
			} catch (ComplexSizeMismatchException e) {
				e.printStackTrace();
				return null;
			}
		}
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		int i, j;
		if(obj instanceof Matrix) {
			if(((Matrix)obj).getCol() == this.col && ((Matrix)obj).getRow() == this.row) {
				for(i = 0 ; i < this.row ; i++) {
					for(j = 0 ; j < this.col ; j++) {
						if(this.elements[i][j] != ((Matrix)obj).getElement(i, j))
							return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "";
		int i, j;
		for(i = 0 ; i < row ; i++){
			str += ("[" + this.elements[i][0]);
			for(j = 1 ; j < col ; j++)
			{
				str += ("\t" + elements[i][j]);
			}
			str += "]\n";
		}
		
		return str;
	}

	/* (non-Javadoc)
	 * @see org.openjasmine.types.Operation#minus(java.lang.Object)
	 */
	@Override
	public Object minus(Object obj) {
		if(obj instanceof Matrix) {
			try {
				if(this.row != ((Matrix)obj).getRow() || this.col != ((Matrix)obj).getCol())
					throw new ComplexSizeMismatchException();
				
				Matrix result = new Matrix(this.row, this.col);
				Object[][] objElm = ((Matrix) obj).getElement();
				int i, j;
				if(elements instanceof Double[][]) {
					if(objElm instanceof Double[][]) {
						double value;
						
						for(i = 0 ; i < this.row ; i++) {
							for(j = 0 ; j < this.col ; j++) {
								value = ((Double)this.elements[i][j]).doubleValue() - ((Double)objElm[i][j]).doubleValue();
								result.setElement(i, j, value);
							}
						}
					}
					else if(objElm instanceof Complex[][]) {
						Complex value;
						
						for(i = 0 ; i < this.row ; i++) {
							for(j = 0 ; j < this.col ; j++) {
								value = (Complex) ((Complex)objElm[i][j]).minus(this.elements[i][j]);
								result.setElement(i, j, value.diff());
							}
						}
					}
				}
				else if(elements instanceof Complex[][]) {
					Object value;
					
					for(i = 0 ; i < this.row ; i++) {
						for(j = 0 ; j < this.col ; j++) {
							value = ((Complex)this.elements[i][j]).minus(objElm[i][j]);
							result.setElement(i, j, value);
						}
					}
				}
				
				return result;
				
			} catch (ComplexSizeMismatchException e) {
				e.printStackTrace();
				return null;
			}
		}
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see org.openjasmine.types.Operation#times(java.lang.Object)
	 */
	@Override
	public Object times(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openjasmine.types.Operation#div(java.lang.Object)
	 */
	@Override
	public Object div(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openjasmine.types.Operation#abs()
	 */
	@Override
	public Object abs() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * row size of the Matrix class
	 */
	private int row;

	/**
	 * Getter of the property <tt>row</tt>
	 * @return  Returns the row.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Setter of the property <tt>row</tt>
	 * @param row  The row to set.
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * column size of the Matirx class
	 */
	private int col;

	/**
	 * Getter of the property <tt>col</tt>
	 * @return  Returns the col.
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Setter of the property <tt>col</tt>
	 * @param col  The col to set.
	 */
	public void setCol(int col) {
		this.col = col;
		this.elements = new Object[this.row][this.col];
	}

	/**
	 * elements of the Matrix class
	 */
	private Object[][] elements;

	/**
	 * Getter of the property <tt>element</tt>
	 * @return  Returns the elements.
	 */
	public Object[][] getElement() {
		return this.elements;
	}
	
	public Object getElement(int row, int col) {
		return this.elements[row][col];
	}

	/**
	 * Setter of the property <tt>element</tt>
	 * @param element  The elements to set.
	 */
	public void setElement(Object[][] element) {
		elements = element;
	}
	
	/**
	 * set element of the Matrix
	 * @param row row position of the element
	 * @param col column position of the element
	 * @param element value of the element
	 */
	public void setElement(int row, int col, Object element) {
		this.elements[row][col] = element;
	}

	public Matrix transpose()	{
		Matrix result = new Matrix(this.col, this.row);
		int i, j;
		
		for(i = 0 ; i < this.row ; i++) {
			for(j = 0 ; j < this.col ; j++) {
				result.setElement(j, i, this.elements[i][j]);
			}
		}
		return result;
	}
	
	static public Matrix eye(int size) {
		Matrix result = new Matrix(size, size) ;
		int i, j;
		
		for(i = 0 ; i < size ; i++) {
			for(j = 0 ; j < size ; j++) {
				if(i == j) {
					result.setElement(i, j, 1.0);
				}
				else {
					result.setElement(i, j, 0.0);
				}	
			}
		}
			
		return result;
	}
	
	public Object trace() {
		Object result = null;
		int i;
		try {
			if(this.row != this.col)
				throw new ComplexSizeMismatchException();
			if(this.elements instanceof Double[][]) {
				double rd = 0;
				
				for(i = 0 ; i < this.row ; i++)
					rd += ((Double)this.elements[i][i]).doubleValue();
				result = rd;
			}
			else if(this.elements instanceof Complex[][]) {
				Complex rc = new Complex(0.0, 0.0);
				
				for(i = 0 ; i < this.row ; i++)
					rc = (Complex) rc.plus(this.elements[i][i]);
				result = rc;
			}
			new Matrix(this.row, this.col);
		} catch (ComplexSizeMismatchException e) {
			e.printStackTrace();
		}
		return result;
	}
}
