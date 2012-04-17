/**
 * 
 */
package org.robot_jasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.robot_jasmine.types.*;
/**
 * @author elecage@gmail.com
 *
 */
public class ComplexTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Complex c1 = new Complex(1.0, 2.0);
		Complex c2 = new Complex(1.0, 3.0);
		double a;
		String str = c1.toString();
		
		boolean eq = c1.equals(c2);
		assertTrue(eq == false);
		
		Complex c3 = new Complex();
		
		c3 = c1.plus(c2);
		assertTrue(c3.getRe() == 2.0);
		assertTrue(c3.getIm() == 5.0);
		
		c3 = c1.minus(c2);
		assertTrue(c3.getRe() == 0.0);
		assertTrue(c3.getIm() == -1.0);
		
		c3 = c1.mul(c2);
		assertTrue(c3.getRe() == -5.0);
		assertTrue(c3.getIm() == 5.0);
		
		c3 = c1.mul(3.0);
		assertTrue(c3.getRe() == 3.0);
		assertTrue(c3.getIm() == 6.0);
		
		c3 = c1.conj();
		assertTrue(c3.getRe() == 1.0);
		assertTrue(c3.getIm() == -2.0);
		
		c3 = c1.div(c2);
		assertTrue(c3.getRe() == 0.7);
		assertTrue(c3.getIm() == -0.1);
		
		a = c1.abs();
		assertTrue(a - 2.2361 < 0.00001);
	}

}
