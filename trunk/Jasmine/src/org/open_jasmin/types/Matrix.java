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
