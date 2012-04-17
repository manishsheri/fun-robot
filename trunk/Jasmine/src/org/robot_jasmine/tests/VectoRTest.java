package org.robot_jasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.robot_jasmine.types.VectoR;

public class VectoRTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		VectoR v1, v2, v3, v4, v6;
		double d;
		double[] v1Array = {3.0 , 2.0, 5.0};
		
		v1 = new VectoR(v1Array);
	//	v2 = new VectoR(3, 2.0);
		
		d = v1.getElement(0);
		assertTrue(d == 3.0);
		d = v1.getElement(1);
		assertTrue(d == 2.0);
		d = v1.getElement(2);
		assertTrue(d == 5.0);
		/*d = v1.getElement(3);  // exception occurred.
		assertTrue(d == 0.0); */
		
		v3 = new VectoR(5, 0);
		v3.setElement(2, v1Array);
		assertTrue(0 == v3.getElement(0));
		assertTrue(0 == v3.getElement(1));
		assertTrue(3.0 == v3.getElement(2));
		assertTrue(2.0 == v3.getElement(3));
		assertTrue(5.0 == v3.getElement(4));
		v4 = new VectoR(5, 0);
		v4.setElement(2, v1);
		assertTrue(0 == v4.getElement(0));
		assertTrue(0 == v4.getElement(1));
		assertTrue(3.0 == v4.getElement(2));
		assertTrue(2.0 == v4.getElement(3));
		assertTrue(5.0 == v4.getElement(4));
		
		double[] v2Array = {4.0, 3.0, 8.0, 7.0, 3.0};
		
		v3 = new VectoR(3);
		v3.setElement(v2Array);
		assertTrue(4.0 == v3.getElement(0));
		assertTrue(3.0 == v3.getElement(1));
		assertTrue(8.0 == v3.getElement(2));
		assertTrue(7.0 == v3.getElement(3));
		assertTrue(3.0 == v3.getElement(4));
		
		VectoR v5 = v3.plus(v4);
		
		assertTrue(4.0 == v5.getElement(0));
		assertTrue(3.0 == v5.getElement(1));
		assertTrue(11.0 == v5.getElement(2));
		assertTrue(9.0 == v5.getElement(3));
		assertTrue(8.0 == v5.getElement(4));
		
		v5 = v4.plus(v2Array);
		assertTrue(4.0 == v5.getElement(0));
		assertTrue(3.0 == v5.getElement(1));
		assertTrue(11.0 == v5.getElement(2));
		assertTrue(9.0 == v5.getElement(3));
		assertTrue(8.0 == v5.getElement(4));
		
		v5 = v3.minus(v4);
		assertTrue(4.0 == v5.getElement(0));
		assertTrue(3.0 == v5.getElement(1));
		assertTrue(5.0 == v5.getElement(2));
		assertTrue(5.0 == v5.getElement(3));
		assertTrue(-2.0 == v5.getElement(4));
		
		v5 = v4.minus(v2Array);
		assertTrue(-4.0 == v5.getElement(0));
		assertTrue(-3.0 == v5.getElement(1));
		assertTrue(-5.0 == v5.getElement(2));
		assertTrue(-5.0 == v5.getElement(3));
		assertTrue(2.0 == v5.getElement(4));
		
		double[] v3Array = v5.getElement(2, 4);
		
		assertTrue(3 == v3Array.length);
		assertTrue(-5.0 == v3Array[0]);
		assertTrue(-5.0 == v3Array[1]);
		assertTrue(2.0 == v3Array[2]);
		
		v6 = v5.getSubVector(2, 4);
		
		assertTrue(3 == v6.getSize());
		assertTrue(-5.0 == v6.getElement(0));
		assertTrue(-5.0 == v6.getElement(1));
		assertTrue(2.0 == v6.getElement(2));
		
		VectoR v7 = v6.mul(3.0);
		assertTrue(-15.0 == v7.getElement(0));
		assertTrue(-15.0 == v7.getElement(1));
		assertTrue(6.0 == v7.getElement(2));
		
		VectoR v8 = v7.div(3.0);
		assertTrue(-5.0 == v8.getElement(0));
		assertTrue(-5.0 == v8.getElement(1));
		assertTrue(2.0 == v8.getElement(2));
		
		v8.setElement(1, 7.0);
		assertTrue(14.0 == v8.norm(1.0));
		
		d = v8.norm(2.0);
		
		assertTrue(8.8318 - v8.norm(2.0) < 0.0001);

		d = v8.norm(10.0);
		assertTrue(7.0238 - d < 0.0001);
		assertTrue(2.0 == v8.norm(Double.NEGATIVE_INFINITY));
		assertTrue(7.0 == v8.norm(Double.POSITIVE_INFINITY));
		
		assertTrue(8.8318 - v8.norm() < 0.0001);
	
		double[] v4Array = {1.0, 2.0, 3.0};
		double[] v5Array = {2.0, 5.0, 7.0};
		v1 = new VectoR(v4Array);
		v2 = new VectoR(v5Array);
		assertTrue(33.0 == v1.dot(v2));
		v3 = new VectoR(v1.getSize());
		v3 = v1.mul(v2);
		assertTrue(2.0 == v3.getElement(0));
		assertTrue(10.0 == v3.getElement(1));
		assertTrue(21.0 == v3.getElement(2));
		
		v3 = v1.cross(v2);
		assertTrue(-1.0 == v3.getElement(0));
		assertTrue(-1.0 == v3.getElement(1));
		assertTrue(1.0 == v3.getElement(2));
		
		
		v3 = v4.cross(v2);

		
		assertTrue(!v1.equals(v2));
		
		v2 = new VectoR(v4Array);
		assertTrue(v1.equals(v2));
		
		System.out.println(v1.toString());
	}
}
