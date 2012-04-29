/**
 * 
 */
package org.openjasmine.types;

/** 
 * @author Hyeon-min.Shim(elecage@gmail.com)
 */
public class Matrix implements Operation {

	public Matrix() {
		super();
		row = 3;	/// default row size = 3;
		col = 3;	/// default col size = 3;
		elements = new Object[row][col];
	}

	public Matrix(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		elements = new Object[row][col];
	}

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
	
	public Matrix(Object[][] elements) {
		super();
		this.elements = elements;
		this.row = elements.length;
		this.col = elements[0].length;
	}

	/* (non-Javadoc)
	 * @see org.openjasmine.types.Operation#plus(java.lang.Object)
	 */
	@Override
	public Object plus(Object obj) {
		if(obj instanceof Matrix) {
			try {
				if(this.row != ((Matrix)obj).getRow() || this.col != ((Matrix)obj).getCol())
					throw new Exception();
				
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
				
			} catch (Exception e) {
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
					throw new Exception();
				
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
				
			} catch (Exception e) {
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
	 * @uml.property  name="row"
	 */
	private int row;

	/**
	 * Getter of the property <tt>row</tt>
	 * @return  Returns the row.
	 * @uml.property  name="row"
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Setter of the property <tt>row</tt>
	 * @param row  The row to set.
	 * @uml.property  name="row"
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @uml.property  name="col"
	 */
	private int col;

	/**
	 * Getter of the property <tt>col</tt>
	 * @return  Returns the col.
	 * @uml.property  name="col"
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Setter of the property <tt>col</tt>
	 * @param col  The col to set.
	 * @uml.property  name="col"
	 */
	public void setCol(int col) {
		this.col = col;
		this.elements = new Object[this.row][this.col];
	}

	/**
	 * @uml.property  name="element" multiplicity="(0 -1)" dimension="2"
	 */
	private Object[][] elements;

	/**
	 * Getter of the property <tt>element</tt>
	 * @return  Returns the elements.
	 * @uml.property  name="element"
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
	 * @uml.property  name="element"
	 */
	public void setElement(Object[][] element) {
		elements = element;
	}
	
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
				throw new Exception();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
