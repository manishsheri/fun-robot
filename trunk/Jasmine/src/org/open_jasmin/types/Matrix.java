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
package org.open_jasmin.types;

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

	}
	

}
