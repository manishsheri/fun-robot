package org.openjasmine.types;

public class LU {
	private Matrix lower;
	private Matrix upper;
	private int size;
	/**
	 * @return the lower
	 */
	public Matrix getLower() {
		return lower;
	}
	/**
	 * @param lower the lower to set
	 */
	public void setLower(Matrix lower) {
		this.lower = lower;
	}
	/**
	 * @return the upper
	 */
	public Matrix getUpper() {
		return upper;
	}
	/**
	 * @param upper the upper to set
	 */
	public void setUpper(Matrix upper) {
		this.upper = upper;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	public LU() {
		this.size = 3;
		lower = new Matrix(this.size, this.size);
		upper = new Matrix(this.size, this.size);
	}
	public LU(int size) {
		super();
		this.size = size;
		lower = new Matrix(this.size, this.size);
		upper = new Matrix(this.size, this.size);
	}
	
	public void decomposition(Matrix mat) {
		int i, j, imax, k;
		final double tiny = 1.0e-20;
		
		
	}
}
