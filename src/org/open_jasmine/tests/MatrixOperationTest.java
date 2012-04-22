package org.open_jasmine.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.open_jasmine.operators.Op;
import org.open_jasmine.types.Matrix;

public class MatrixOperationTest {

	@Test
	public void test() {
		Matrix m1, m2, m3, m4, m5;
		
		double[][] ma1 = {{1.0, 2.0, 3.0, 4.0},{-4.0, -3.0, -2.0, -1.0},{5.0, -5.0, 4.0, -4.0}};
		double[][] ma2 = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		m1 = new Matrix(ma1);
		m2 = m1.transpose();
		m4 = new Matrix(ma2);
		System.out.println("m1 = \n" + m1.toString());
		System.out.println("m2 = \n" + m2.toString());
		
		m3 = new Matrix(3, 3);
		System.out.println("m3 = \n" + m3);
		
		m3.setEye();
		
		System.out.println("Identify M3 = \n" + m3);
		
		System.out.println("Trace of m3 = " + m3.trace());
		System.out.println("m4 = \n" + m4);
		System.out.println("Trace of m4 =\n " + m4.trace());
		
		m5 = Op.plus(m3, m4);
		System.out.println("m3 + m4 = \n" + m5);
		
		m5 = Op.minus(m3, m4);
		
		System.out.println("m3 - m4 = \n" + m5);
		
		
		
	}

}
