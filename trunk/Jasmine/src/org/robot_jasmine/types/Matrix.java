package org.robot_jasmine.types;

public class Matrix {
	int row, col;
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
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public double[][] getElement() {
		return element;
	}
	
	public double getElement(int row, int col) {
		return element[row][col];
	}
	
	public double[][] getElementCopy() {
		return element.clone();
	}
	
	public void setElement(double[][] element) {
		this.element = element;
	}
	
	public void setElement(int row, int col, double element) {

	}
	

}
