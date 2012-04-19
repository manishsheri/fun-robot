/**
 * 
 */
package org.open_jasmin.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.open_jasmin.operators.Op;
import org.open_jasmin.types.Complex;
import org.open_jasmin.types.VectoR;

/**
 * @author elecage@gmail.com
 *
 */
public class OperationTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Complex c1, c2, c3;
		double d1 = 7.0;
		double d2 = -4.0;
		double d3;
		
		c1 = new Complex(3.0, 4.0);
		c2 = new Complex(2.0, 4.0);
		c3 = Op.plus(c1, c2);
		
		assertTrue(5.0 == c3.getRe());
		assertTrue(8.0 == c3.getIm());
		
		c3 = Op.plus(c1, d1);
		
		assertTrue(10.0 == c3.getRe());
		assertTrue(4.0 == c3.getIm());
		
		c3 = Op.plus(d2, c2);
		
		assertTrue(-2.0 == c3.getRe());
		assertTrue(4.0 == c3.getIm());
		
		c3 = Op.minus(c1, c2);
		
		assertTrue(1.0 == c3.getRe());
		assertTrue(0.0 == c3.getIm());
		
		c3 = Op.minus(c1, d1);
		assertTrue(-4.0 == c3.getRe());
		assertTrue(4.0 == c3.getIm());
		
		c3 = Op.minus(d2, c2);
		assertTrue(-6.0 == c3.getRe());
		assertTrue(-4.0 == c3.getIm());
		
		c3 = Op.times(c1, c2);
		assertTrue(-10. == c3.getRe());
		assertTrue(20. == c3.getIm());
		
		c3 = Op.times(c1,  d1);
		assertTrue(21.0 == c3.getRe());
		assertTrue(28.0 == c3.getIm());
		
		c3 = Op.times(d2, c2);
		assertTrue(-8.0 == c3.getRe());
		assertTrue(-16.0 == c3.getIm());
		
		c3 = Op.divide(c1, c2);
		assertTrue(1.1 == c3.getRe());
		assertTrue(-0.2 == c3.getIm());
		
		c3 = Op.divide(c1, d1);
		assertTrue(Math.abs(0.4286 - c3.getRe()) < Op.TOL);
		assertTrue(Math.abs(0.5714 - c3.getIm()) < Op.TOL);
		
		c3 = Op.divide(d2, c2);
		assertTrue(-0.4 == c3.getRe());
		assertTrue(0.8 == c3.getIm());
		
		VectoR v1, v2, v3;
		double[] va1 = {2.0, 7.0, 3.0};
		double[] va2 = {-4.0, 3.0, -1.0};
		
		v1 = new VectoR(va1);
		v2 = new VectoR(va2);
		
		v3 = Op.plus(v1, v2);
		assertTrue(-2.0 == v3.getElement(0));
		assertTrue(10.0 == v3.getElement(1));
		assertTrue(2.0 == v3.getElement(2));
		
		v3 = Op.minus(v1, v2);
		assertTrue(6.0 == v3.getElement(0));
		assertTrue(4.0 == v3.getElement(1));
		assertTrue(4.0 == v3.getElement(2));
		
		d3 = Op.dot(v1, v2);
		assertTrue(10.0 == d3);
		
		v3 = Op.cross(v1, v2);
		assertTrue(-16.0 == v3.getElement(0));
		assertTrue(-10.0 == v3.getElement(1));
		assertTrue(34.0 == v3.getElement(2));
		
		v3 = Op.times(v1, d1);
		assertTrue(14.0 == v3.getElement(0));
		assertTrue(49.0 == v3.getElement(1));
		assertTrue(21.0 == v3.getElement(2));
		
		v3 = Op.times(d2, v2);
		assertTrue(16.0 == v3.getElement(0));
		assertTrue(-12.0 == v3.getElement(1));
		assertTrue(4.0 == v3.getElement(2));
		
		v3 = Op.times(v1, v2);
		assertTrue(-8.0 == v3.getElement(0));
		assertTrue(21.0 == v3.getElement(1));
		assertTrue(-3.0 == v3.getElement(2));
	}

}
