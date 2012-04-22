package org.open_jasmine.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.open_jasmine.types.Matrix;

public class MatrixOperationTest {

	@Test
	public void test() {
		Matrix m1;
		
		double[][] ma1 = {{1.0, 2.0, 3.0, 4.0},{-4.0, -3.0, -2.0, -1.0},{5.0, -5.0, 4.0, -4.0}};
		
		m1 = new Matrix(ma1);
		
		m1.toString();
		
	}

}
