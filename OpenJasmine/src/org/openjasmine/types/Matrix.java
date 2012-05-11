package org.openjasmine.types;

import org.openjasmine.exception.ComplexSizeMismatchException;
import org.openjasmine.exception.MatrixSizeMismatchException;
import org.openjasmine.exception.TypeMismatchException;


/**
 * Matrix class
 * @filename Matrix.java
 * @author Hyeon-min.Shim(elecage@gmail.com)
 */
public class Matrix implements Operation {

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

	/**
	 * column size of the Matirx class
	 */
	private int col;

	/**
	 * elements of the Matrix class
	 */
	private Object[][] elements;
	
	/**
	 * row size of the Matrix class
	 */
	private int row;
	
	/**
	 * Default Constructor
	 */
	public Matrix() {
		super();
		int i, j;
		row = 3;	/// default row size = 3;
		col = 3;	/// default col size = 3;
		elements = new Object[row][col];
		
		for(i = 0 ; i < row ; i++) {
			for(j = 0 ; j < col ; j++) {
				elements[i][j] = 0.0;
			}
		}
	}

	/**
	 * Constructor with size setting.<br>
	 * 크기를 설정하는 생성자.
	 * @param row row size of the Matrix class.
	 * @param col column size of the Matrix class.
	 */
	public Matrix(int row, int col) {
		super();
		
		int i, j;
		this.row = row;
		this.col = col;
		elements = new Object[row][col];
		
		for(i = 0 ; i < row ; i++) {
			for(j = 0 ; j < col ; j++) {
				elements[i][j] = 0.0;
			}
		}
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

	public Matrix(Matrix m) {
		this.row = m.getRow();
		this.col = m.getCol();
		this.elements = m.getElement();
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

	/* (non-Javadoc)
	 * @see org.openjasmine.types.Operation#abs()
	 */
	@Override
	public Object abs() {
		// TODO Auto-generated method stub
		return null;
	}

	public Matrix adj() {
		
		int i, j;
		Matrix result = new Matrix(this.row, this.col);
		if(this.row == 1) {
			return this;
		}
		for(i = 0 ; i < this.row ; i++) {
			for(j = 0 ; j < this.col ; j++) {
				result.setElement(i, j, this.cofactor(i, j));
			}
		}
		return result.transpose();
	}

	public Object cofactor(int row, int col) {
		try {
			if( this.row != this.col) {
				throw new MatrixSizeMismatchException();
			}
		} catch (MatrixSizeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		int i = 0, j = 0;
		Object result = null;
		if(this.row == 2) {
			if(row == 0 && col == 0) {
				i = 1;
				j = 1;
			}
			else if(row == 0 && col == 1) {
				i = 1;
				j = 0;
			}
			else if(row == 1 && col == 0) {
				i = 0;
				j = 1;
			}
			else if(row == 1 && col == 1) {
				i = 0;
				j = 0;
			}
			return this.elements[i][j];
		}
		else {
			if(elements[0][0] instanceof Double) {
				result = new Double(0.0);
				double rf = 0;
				if((row + col) % 2 == 0) {
					rf = 1.0;
				}
				else {
					rf = -1.0;
				}
				result = rf * ((Double)(this.minor(row, col)).det());
				
			}
			else if(elements[0][0] instanceof Complex) {
				result = new Complex(0.0, 0.0);
				Complex rf = new Complex(0.0, 0.0);
				if((row + col) % 2 == 0) {
					rf.set(1.0, 0.0);
				}
				else {
					rf.set(-1.0, 0.0);
				}
				result = rf.times((this.minor(row, col)).det());
			}
			return result;
		}
		
	}

	public Matrix conjTranspose()	{
		Matrix result = new Matrix(this.col, this.row);
		int i, j;
		
		try {
			if(!(this.elements[0][0] instanceof Complex)) {
				throw new TypeMismatchException();
			}
			for(i = 0 ; i < this.row ; i++) {
				for(j = 0 ; j < this.col ; j++) {
					result.setElement(j, i, ((Complex)this.elements[i][j]).conj());
				}
			}
		} catch (TypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Object det() {
		try {
			if(this.col != this.row) {
				throw new MatrixSizeMismatchException();
			}
		} catch (MatrixSizeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		int i;
		double dCoeff = 1.0;
		Complex cCoeff = new Complex(1.0, 0.0);
		Double dResult;
		Complex cResult;
		Matrix minorMat;
		Complex cTemp;
		if(this.elements[0][0] instanceof Double) {
			if(this.col == 1) {
				dResult = (Double)this.elements[0][0];
				return dResult;
			}
			if(this.col == 2) {
				return ((Double)this.elements[0][0]).doubleValue() * ((Double)this.elements[1][1]).doubleValue()
						- ((Double)this.elements[0][1]).doubleValue() * ((Double)this.elements[1][0]).doubleValue();
			}
			/**
			 * 행렬사이즈가 2보다 클 때
			 */
			else {
				dResult = 0.0;
				for (i = 0 ; i < this.row ; i++) {
					minorMat = this.minor(i, 0);
					if((i % 2) == 0) {
						dCoeff = 1.0;
					}
					else {
						dCoeff = -1.0;
					}
					dResult = dResult + (dCoeff * (Double)this.elements[i][0]) * ((Double)minorMat.det()).doubleValue();						
				}
				return dResult;
			}
		}
		else if(this.elements[0][0] instanceof Complex) {
			if(this.col == 1) {
				cResult = new Complex(((Complex)this.elements[0][0]).getRe(), ((Complex)this.elements[0][0]).getIm());
			}
			if(this.col == 2) {
				return ((Complex)(((Complex)this.elements[0][0]).times(this.elements[1][1]))).minus(
						((Complex)this.elements[0][1]).times(this.elements[1][0]));
			}
			/**
			 * 행렬사이즈가 2보다 클 때
			 */
			else {
				cResult = new Complex(0.0, 0.0);
				for(i = 0 ; i < this.row ; i++) {
					minorMat = this.minor(i, 0);
					if((i % 2) == 0) {
						cCoeff.set(1.0, 0.0);
					} 
					else {
						cCoeff.set(-1.0, 0.0);
					}
					cTemp = (Complex)((Complex)cCoeff.times(this.elements[i][0])).times(minorMat.det());
					cResult = (Complex) ((Complex) cResult.plus(cTemp));
				}
				return cResult;
			}
		}
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

	/**
	 * Getter of the property <tt>col</tt>
	 * @return  Returns the col.
	 */
	public int getCol() {
		return col;
	}

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
	 * Getter of the property <tt>row</tt>
	 * @return  Returns the row.
	 */
	public int getRow() {
		return row;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	public Matrix inv()	{
		Object dt = this.det();
		Matrix result;
		
		if(dt instanceof Complex) {
			if(((Complex)dt).getRe() == 0.0 && ((Complex)dt).getIm() == 0.0) {
				return null;
			}
			dt = ((Complex) dt).inv();
			
		}
		else if(dt instanceof Double) {
			if(((Double)dt).doubleValue() == 0.0) {
				return null;
			}
			dt = 1.0 / ((Double)dt).doubleValue();
		}
		if(this.col == 1) {
			result = new Matrix(1, 1);
			result.setElement(0, 0, dt);
		}
		else {
			result = (Matrix)(this.adj());
			result = (Matrix) result.times(dt);
		}
		return result;
	}

	/**
	 * 소행렬 구하기
	 * @param row
	 * @param col
	 * @return minor matrix
	 */
	public Matrix minor(int mRow, int mCol) {
		int rf = 0, cf = 0;
		int i, j;
		Matrix result = new Matrix(this.row - 1, this.col - 1) ;
		
		for(i = 0 ; i < this.row -1 ; i++) {
			if(i >= mRow) {
				rf = 1;
			}
			else {
				rf = 0;
			}
			for(j = 0 ; j < this.col -1  ; j++)  {
				
				if(j >= mCol) {
					cf = 1;
				}
				else {
					cf = 0;
				}
				result.setElement(i, j, this.elements[i+rf][j + cf]);
			}
		}
		
		return result;
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
				if(elements[0][0] instanceof Double) {
					if(objElm[0][0] instanceof Double) {
						double value;
						
						for(i = 0 ; i < this.row ; i++) {
							for(j = 0 ; j < this.col ; j++) {
								value = ((Double)this.elements[i][j]).doubleValue() - ((Double)objElm[i][j]).doubleValue();
								result.setElement(i, j, value);
							}
						}
					}
					else if(objElm[0][0] instanceof Complex) {
						Complex value;
						
						for(i = 0 ; i < this.row ; i++) {
							for(j = 0 ; j < this.col ; j++) {
								value = (Complex) ((Complex)objElm[i][j]).minus(this.elements[i][j]);
								result.setElement(i, j, value.diff());
							}
						}
					}
				}
				else if(elements[0][0] instanceof Complex) {
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
				if(elements[0][0] instanceof Double) {
					if(objElm[0][0] instanceof Double) {
						double value;
						
						for(i = 0 ; i < this.row ; i++) {
							for(j = 0 ; j < this.col ; j++) {
								value = ((Double)this.elements[i][j]).doubleValue() + ((Double)objElm[i][j]).doubleValue();
								result.setElement(i, j, value);
							}
						}
					}
					else if(objElm[0][0] instanceof Complex) {
						Complex value;
						
						for(i = 0 ; i < this.row ; i++) {
							for(j = 0 ; j < this.col ; j++) {
								value = (Complex) ((Complex)objElm[i][j]).plus(this.elements[i][j]);
								result.setElement(i, j, value);
							}
						}
					}
				}
				else if(elements[0][0] instanceof Complex) {
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
	
	/**
	 * Setter of the property <tt>col</tt>
	 * @param col  The col to set.
	 */
	public void setCol(int col) {
		this.col = col;
		this.elements = new Object[this.row][this.col];
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
	
	/**
	 * Setter of the property <tt>element</tt>
	 * @param element  The elements to set.
	 */
	public void setElement(Object[][] element) {
		elements = element;
	}
	/**
	 * Setter of the property <tt>row</tt>
	 * @param row  The row to set.
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/* (non-Javadoc)
	 * @see org.openjasmine.types.Operation#times(java.lang.Object)
	 */
	@Override
	public Object times(Object obj) {
		Object result = null;
		int i, j;
		if(obj instanceof Double) {
			result = new Matrix(this.row, this.col);
			if(this.elements[0][0] instanceof Double) {
				for(i = 0 ; i < this.row ; i++) {
					for(j = 0 ; j < this.col ; j++) {
						((Matrix)result).setElement(i, j, 
								((Double)this.elements[i][j]).doubleValue() 
							  * ((Double)obj).doubleValue());
					}
				}
				
			}
			else if(this.elements[0][0] instanceof Complex) {
				for(i = 0 ; i < this.row ; i++) {
					for(j = 0 ; j < this.col ; j++) {
						((Matrix)result).setElement(i, j, 
								((Complex)this.elements[i][j]).times(obj));
					}
				}
			}
		}
		else if(obj instanceof Complex) {
			result = new Matrix(this.row, this.col);
			for(i = 0 ; i < this.row ; i++) {
				for(j = 0 ; j < this.col ; j++) {
					((Matrix)result).setElement(i, j, ((Complex)obj).times(this.elements[i][j]));
				}
			}
		}
		else if(obj instanceof VectoR) {
			try {
				if(((VectoR)obj).getSize() != this.col) {
					throw new MatrixSizeMismatchException();
				}
			} catch (MatrixSizeMismatchException e) {
				e.printStackTrace();
			}
						
			if(this.elements[0][0] instanceof Double) {
				result = new VectoR(this.row);
				Object[] temp = ((VectoR)obj).getElement();
							
				if(temp[0] instanceof Double) {
					double dTemp;
					for(i = 0 ; i < this.row ; i++) {
						dTemp = 0.0;
						for(j = 0 ; j < this.col ; j++) {
							dTemp += (((Double)this.elements[i][j]).doubleValue() * ((Double)temp[j]).doubleValue());
						}
						((VectoR)result).setElement(i, (Double)dTemp);
					}
				}
				else if(temp[0] instanceof Complex) {
					Complex[] cTemp = new Complex[3];
					for(i = 0 ; i < this.row ; i++) {
						cTemp[i] = new Complex(0.0, 0.0);
						
						for(j = 0 ; j < this.col ; j++) {
							cTemp[i] = (Complex) cTemp[i].plus(((Complex)temp[j]).times(this.elements[i][j]));
						}
						
					}
					((VectoR)result).setElement(cTemp);
				}
			}
			else if(this.elements[0][0] instanceof Complex) {
				result = new VectoR(this.row);
				Object[] temp = ((VectoR)obj).getElement();
				
				Complex[] cTemp = new Complex[3];
				for(i = 0 ; i < this.row ; i++) {
					cTemp[i] = new Complex(0.0, 0.0);
					for(j = 0 ; j < this.col ; j++) {
						cTemp[i] = (Complex) cTemp[i].plus(((Complex)this.elements[i][j]).times(temp[j]));
					}
				}
				((VectoR)result).setElement(cTemp);
			}
			
		}
		else if(obj instanceof Matrix) {
			try {
				if(this.col != ((Matrix)obj).getRow()) {
					throw new MatrixSizeMismatchException();
				}
			} catch (MatrixSizeMismatchException e) {
				e.printStackTrace();
			}
			result = new Matrix(this.row, ((Matrix)obj).getCol());
			int k;
			Object[][] temp = ((Matrix)obj).getElement();
			if(this.elements[0][0] instanceof Double) {
				double dTemp;
				if(temp[0][0] instanceof Double) {
					for(i = 0 ; i < this.row ; i++) {
						for(j = 0 ; j < ((Matrix)obj).getCol() ; j++) {
							dTemp = 0;
							for(k = 0 ; k < this.col ; k++) {
								dTemp += ((Double)this.elements[i][k]).doubleValue() * ((Double)temp[k][j]).doubleValue();
							}
							((Matrix)result).setElement(i, j, dTemp);
						}
					}
				}
				else if(temp[0][0] instanceof Complex) {
					Complex[][] cTemp = new Complex[this.row][((Matrix)obj).getCol()];
					for(i = 0 ; i < this.row ; i++) {
						for(j = 0 ; j <  ((Matrix)obj).getCol() ; j++) {
							cTemp[i][j] = new Complex(0.0, 0.0);
							for(k = 0 ; k < this.col ; k++) {
								cTemp[i][j] = (Complex) cTemp[i][j].plus(((Complex)temp[k][j]).times(this.elements[i][k]));
							}
						}
					}
					((Matrix)result).setElement(cTemp);
				}
			}
			else if(this.elements[0][0] instanceof Complex) {
				Complex[][] cTemp = new Complex[this.row][((Matrix)obj).getCol()];
				for(i = 0 ; i < this.row ; i++) {
					for(j = 0 ; j <  ((Matrix)obj).getCol() ; j++) {
						cTemp[i][j] = new Complex(0.0, 0.0);
						for(k = 0 ; k < this.col ; k++) {
							cTemp[i][j] = (Complex) cTemp[i][j].plus(((Complex)this.elements[i][k]).times(temp[k][j]));
						}
					}
				}
				((Matrix)result).setElement(cTemp);
			}
		}
		return result;
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
	public Object trace() {
		Object result = null;
		int i;
		try {
			if(this.row != this.col)
				throw new ComplexSizeMismatchException();
			if(this.elements[0][0] instanceof Double) {
				double rd = 0;
				
				for(i = 0 ; i < this.row ; i++)
					rd += ((Double)this.elements[i][i]).doubleValue();
				result = rd;
			}
			else if(this.elements[0][0] instanceof Complex) {
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
	
	public boolean isOrthogonal() {
		boolean result = true;
		Matrix m1 = this.transpose();
		Matrix m2 = this.inv();
		int i, j;
		double tol = 0.0001;
		
		try {
			for(i = 0 ; i < this.row ; i++) {
				for(j = 0 ; j < this.col ; j++) {
					if(Math.abs((Double)m1.getElement(i, j) - (Double)m2.getElement(i, j)) > tol) {
						result = false;
						return result;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
}
