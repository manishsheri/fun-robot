/**
 * 
 */
package org.openjasmine.filter;

/**
 * @author Hyeon-min.Shim(elecage@gmail.com)
 *
 */
public class Average {
	private double prevAverage;
	protected double average;
	protected int count;
	/**
	 * 
	 */
	public Average() {
		// TODO Auto-generated constructor stub
		prevAverage = 0;
		average = 0;
		count = 0;
	}
	
	public double newAverage(double data) {
		count++;
		double alpha = (((double)count) - 1.0) / ((double)count);
		average = alpha * prevAverage + (1.0 - alpha) * data;
		prevAverage = average;
		return average;
	}

}
