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
		VectoR v1, v2, v3, v4;
		double d;
		double[] v1Array = {3.0 , 2.0, 5.0};
		
		v1 = new VectoR(v1Array);
		v2 = new VectoR(3, 2.0);
		
		d = v1.getElement(0);
		assertTrue(d == 3.0);
		d = v1.getElement(1);
		assertTrue(d == 2.0);
		d = v1.getElement(2);
		assertTrue(d == 5.0);
		d = v1.getElement(3);
		assertTrue(d == 0.0);
		
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
		
		double[] v2Array = {4.0, 3.0, 8.0};
	
	}

}
