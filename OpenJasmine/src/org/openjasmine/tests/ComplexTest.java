package org.openjasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.types.Complex;

public class ComplexTest {
	Complex c1, c2, c3;
	double d;
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 
	 */
	@Test
	public void test() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		/**
		 *  [OJ-COMPLEX-TC-001] Complex + Complex
		 */
		c3 = (Complex) c1.plus(c2);
		System.out.println("[OJ-COMPLEX-TC-001] Complex + Complex");
		System.out.println(c1 + " + " +c2 + " = " + c3);
		
		assertTrue(-1.0 == c3.getRe());
		assertTrue(8.0 == c3.getIm());
				
		/**
		 *  [OJ-COMPLEX-TC-002] Complex + double
		 */
		
		c3 = (Complex) c1.plus(3.0);
		System.out.println("[OJ-COMPLEX-TC-002] Complex + double");
		System.out.println(c1 + " + 3.0 = " + c3);
		
		assertTrue(4.0 == c3.getRe());
		assertTrue(3.0 == c3.getIm());
		
		/**
		 *  [OJ-COMPLEX-TC-003] Complex - Complex
		 */		
		c3 = (Complex) c1.minus(c2);
		System.out.println("[OJ-COMPLEX-TC-003] Complex - Complex");
		System.out.println(c1 + " - " +c2 + " = " + c3);
		
		assertTrue(3.0 == c3.getRe());
		assertTrue(-2.0 == c3.getIm());
		
		/**
		 *  [OJ-COMPLEX-TC-004] Complex - double
		 */	
		c3 = (Complex) c1.minus(3.0);
		System.out.println("[OJ-COMPLEX-TC-004] Complex - double");
		System.out.println(c1 + " - 3.0 = " + c3);
		
		assertTrue(-2.0 == c3.getRe());
		assertTrue(3.0 == c3.getIm());
		
		/**
		 *  [OJ-COMPLEX-TC-005] Complex * Complex
		 */	
		c3 = (Complex)c1.times(c2);
		System.out.println("[¥ö¥óOJ-COMPLEX-TC-005] Complex * Complex");
		System.out.println(c1 + " ¡¿ " +c2 + " = " + c3);
		
		assertTrue(-17.0 == c3.getRe());
		assertTrue(-1.0 == c3.getIm());
				
		/**
		 *  [OJ-COMPLEX-TC-006] Complex * double
		 */
		c3 = (Complex)c1.times(3.0);
		System.out.println("[OJ-COMPLEX-TC-006] Complex * double");
		System.out.println(c1 + " * 3.0 = " + c3);
		
		assertTrue(3.0 == c3.getRe());
		assertTrue(9.0 == c3.getIm());		
		
		/**
		 *  [OJ-COMPLEX-TC-007] Complex / Complex
		 */
		c3 = (Complex)c1.div(c2);
		System.out.println("[OJ-COMPLEX-TC-007] Complex / Complex");
		System.out.println(c1 + " ¡À " + c2 + " = " + c3);
		
		assertTrue(Math.abs(0.4483 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(-0.3793 - c3.getIm()) < 0.0001);
				
		/**
		 *  [OJ-COMPLEX-TC-008] Complex / double
		 */
		
		c3 = (Complex)c1.div(3.0);
		System.out.println("[OJ-COMPLEX-TC-008] Complex / double");
		System.out.println(c1 + " ¡À 3.0 = " + c3 );		
		
		assertTrue(Math.abs(0.3333 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(1.0 - c3.getIm()) < 0.0001);
		
		/**
		 *  [OJ-COMPLEX-TC-009] absolute number
		 */
		d = (Double)c1.abs();
		System.out.println("[OJ-COMPLEX-TC-009] absolute number");
		System.out.println("Absolute value of " + c1 + " = " + d);		
		
		assertTrue(Math.abs(3.1623 - d) < 0.0001);
		
		/**
		 *  [OJ-COMPLEX-TC-010] invert number : 1/Complex
		 */
		c3 = (Complex)c1.inv();
		System.out.println("[OJ-COMPLEX-TC-010] invert number : 1/Complex");
		System.out.println("inverse value of " + c1 + " = " + c3);		
		
		assertTrue(Math.abs(0.1 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(-0.3 - c3.getIm()) < 0.0001);
		
		/**
		 *  [OJ-COMPLEX-TC-011] different number : -Complex
		 */
		c3 = (Complex)c1.diff();
		System.out.println("[OJ-COMPLEX-TC-011] different number : -Complex");
		System.out.println("different value of " + c1 + " = " + c3);		
		
		assertTrue(Math.abs(-1.0 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(-3.0 - c3.getIm()) < 0.0001);
	}

}
