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
		
		c3 = (Complex) c1.plus(c2);
		
		assertTrue(-1.0 == c3.getRe());
		assertTrue(8.0 == c3.getIm());
		
		System.out.println(c1 + " + " +c2 + " = " + c3);
		
		c3 = (Complex) c1.plus(3.0);
		
		assertTrue(4.0 == c3.getRe());
		assertTrue(3.0 == c3.getIm());
		
		System.out.println(c1 + " + 3.0 = " + c3);
		
		c3 = (Complex) c1.minus(c2);
		
		assertTrue(3.0 == c3.getRe());
		assertTrue(-2.0 == c3.getIm());
		
		System.out.println(c1 + " - " +c2 + " = " + c3);
		
		c3 = (Complex) c1.minus(3.0);
		assertTrue(-2.0 == c3.getRe());
		assertTrue(3.0 == c3.getIm());
		
		System.out.println(c1 + " - 3.0 = " + c3);
		
		c3 = (Complex)c1.times(c2);
		assertTrue(-17.0 == c3.getRe());
		assertTrue(-1.0 == c3.getIm());
		
		System.out.println(c1 + " ¡¿ " +c2 + " = " + c3);
		
		c3 = (Complex)c1.times(3.0);
		
		assertTrue(3.0 == c3.getRe());
		assertTrue(9.0 == c3.getIm());
		
		System.out.println(c1 + " * 3.0 = " + c3);
		
		
		c3 = (Complex)c1.div(c2);
		System.out.println(c1 + " ¡À " + c2 + " = " + c3);
		assertTrue(Math.abs(0.4483 - c3.getRe()) < 0.0005);
		assertTrue(Math.abs(-0.3793 - c3.getIm()) < 0.0005);
		
		c3 = (Complex)c1.div(3.0);
		System.out.println(c1 + " ¡À 3.0 = " + c3 );
		assertTrue(Math.abs(0.3333 - c3.getRe()) < 0.0005);
		assertTrue(Math.abs(1.0 - c3.getIm()) < 0.0005);
		
		d = (Double)c1.abs();
		
		System.out.println("Absolute value of " + c1 + " = " + d);
		assertTrue(Math.abs(3.1623 - d) < 0.0001);
		
		c3 = c1.inv();
		System.out.println("inverse value of " + c1 + " = " + c3);
	}

}
