/*
 * Copyright (c) <2012> <Hyeon-min.shim(elecage@gmail.com)>
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package org.open_jasmine.types;

public class Matrix {
	/**
	 * @uml.property  name="row"
	 */
	int row;
	/**
	 * @uml.property  name="col"
	 */
	int col;
	/**
	 * @uml.property  name="element"
	 */
	double [][] element;
	public Matrix() {
		row = 3;
		col = 3;
		element = new double[row][col];
	}
	public Matrix(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		element = new double[row][col];
	}
	public Matrix(double[][] element) {
		super();
		row = element.length;
		col = element[0].length;
		this.element = element.clone();
	}
	
	public Matrix(Matrix m) {
		row = m.getRow();
		col = m.getCol();
		element = m.getElementCopy();
	}
	/**
	 * @return
	 * @uml.property  name="row"
	 */
	public int getRow() {
		return row;
	}
	/**
	 * @param row
	 * @uml.property  name="row"
	 */
	public void setRow(int row) {
		this.row = row;
		try {
			if(this.row == 0 || this.col == 0)
				throw new Exception();
			
			this.element = new double[this.row][this.col];
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * @return
	 * @uml.property  name="col"
	 */
	public int getCol() {
		return col;
	}
	/**
	 * @param col
	 * @uml.property  name="col"
	 */
	public void setCol(int col) {
		this.col = col;
		try {
			if(this.row == 0 || this.col == 0)
				throw new Exception();
			
			this.element = new double[this.row][this.col];
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setSize(int row, int col) {
		this.row = row;
		this.col = col;
		
		try {
			if(this.row == 0 || this.col == 0)
				throw new Exception();
			
			this.element = new double[this.row][this.col];
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return
	 * @uml.property  name="element"
	 */
	public double[][] getElement() {
		return element;
	}
	
	public double getElement(int row, int col) {
		return element[row][col];
	}
	
	public double[][] getElementCopy() {
		return element.clone();
	}
	
	/**
	 * @param element
	 * @uml.property  name="element"
	 */
	public void setElement(double[][] element) {
		this.element = element;
	}
	
	public void setElement(int row, int col, double element) {
		this.element[row][col] = element;
	}
	
	public Matrix transpose() {
		Matrix result = new Matrix(col, row);
		int i, j;
		
		for(i = 0 ; i < col ; i++) {
			for(j = 0 ; j < row ; j++) {
				result.setElement(i, j, this.element[j][i]);
			}
		}
		
		return result;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		int i, j;
		String str ="";
		for(i = 0 ; i < row ; i++) {
			str += ("[" + this.element[i][0]);
			
			for(j = 1 ; j < col ; j++) {
				str += ("\t" + this.element[i][j]);
			}
			str += "]\n";
		}
		return str;
	}
	
	public void setEye() {
		try {
			if(this.col != this.row)
				throw new Exception();
			
			int i, j;
			for(i = 0 ; i < row ; i++) {
				for(j = 0 ; j < col ; j++) {
					if(i == j)
						this.element[i][j] = 1.0;
					else
						this.element[i][j] = 0.0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double trace() {
		double result = 0;
		int i;
		
		for(i = 0 ; i < row ; i++) {
			result += this.element[i][i];
		}
		
		return result;
	}
}
