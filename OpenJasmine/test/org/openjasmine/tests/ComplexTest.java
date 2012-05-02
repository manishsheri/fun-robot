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

	@Test
	/**
	 *  [OJ-COMPLEX-TC-001] Complex + Complex
	 */
	public void ojComplexTest001() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex) c1.plus(c2);
		System.out.println("[OJ-COMPLEX-TC-001] Complex + Complex");
		System.out.println(c1 + " + " +c2 + " = " + c3);
		
		assertTrue(-1.0 == c3.getRe());
		assertTrue(8.0 == c3.getIm());		
	}
	
	/**
	 *  [OJ-COMPLEX-TC-002] Complex + double
	 */
	@Test	
	public void ojComplexTest002() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex) c1.plus(3.0);
		System.out.println("[OJ-COMPLEX-TC-002] Complex + double");
		System.out.println(c1 + " + 3.0 = " + c3);
		
		assertTrue(4.0 == c3.getRe());
		assertTrue(3.0 == c3.getIm());
	}
	
	/**
	 *  [OJ-COMPLEX-TC-003] Complex - Complex
	 */	
	@Test	
	public void ojComplexTest003() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex) c1.minus(c2);
		System.out.println("[OJ-COMPLEX-TC-003] Complex - Complex");
		System.out.println(c1 + " - " +c2 + " = " + c3);
		
		assertTrue(3.0 == c3.getRe());
		assertTrue(-2.0 == c3.getIm());
	}
	
	/**
	 *  [OJ-COMPLEX-TC-004] Complex - double
	 */	
	@Test	
	public void ojComplexTest004() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex) c1.minus(3.0);
		System.out.println("[OJ-COMPLEX-TC-004] Complex - double");
		System.out.println(c1 + " - 3.0 = " + c3);
		
		assertTrue(-2.0 == c3.getRe());
		assertTrue(3.0 == c3.getIm());
	}
	
	/**
	 *  [OJ-COMPLEX-TC-005] Complex * Complex
	 */	
	@Test	
	public void ojComplexTest005() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex)c1.times(c2);
		System.out.println("[¥ö¥óOJ-COMPLEX-TC-005] Complex * Complex");
		System.out.println(c1 + " ¡¿ " +c2 + " = " + c3);
		
		assertTrue(-17.0 == c3.getRe());
		assertTrue(-1.0 == c3.getIm());
	}
	
	/**
	 *  [OJ-COMPLEX-TC-006] Complex * double
	 */
	@Test
	public void ojComplexTest006() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex)c1.times(3.0);
		System.out.println("[OJ-COMPLEX-TC-006] Complex * double");
		System.out.println(c1 + " * 3.0 = " + c3);
		
		assertTrue(3.0 == c3.getRe());
		assertTrue(9.0 == c3.getIm());		
	}
	
	/**
	 *  [OJ-COMPLEX-TC-007] Complex / Complex
	 */
	@Test
	public void ojComplexTest007() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex)c1.div(c2);
		System.out.println("[OJ-COMPLEX-TC-007] Complex / Complex");
		System.out.println(c1 + " ¡À " + c2 + " = " + c3);
		
		assertTrue(Math.abs(0.4483 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(-0.3793 - c3.getIm()) < 0.0001);
	}
	
	/**
	 *  [OJ-COMPLEX-TC-008] Complex / double
	 */
	@Test
	public void ojComplexTest008() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex)c1.div(3.0);
		System.out.println("[OJ-COMPLEX-TC-008] Complex / double");
		System.out.println(c1 + " ¡À 3.0 = " + c3 );		
		
		assertTrue(Math.abs(0.3333 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(1.0 - c3.getIm()) < 0.0001);
	}
	
	/**
	 *  [OJ-COMPLEX-TC-009] absolute number
	 */
	@Test
	public void ojComplexTest009() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		d = (Double)c1.abs();
		System.out.println("[OJ-COMPLEX-TC-009] absolute number");
		System.out.println("Absolute value of " + c1 + " = " + d);		
		
		assertTrue(Math.abs(3.1623 - d) < 0.0001);
	}
	
	/**
	 *  [OJ-COMPLEX-TC-010] invert number : 1/Complex
	 */
	@Test
	public void ojComplexTest010() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex)c1.inv();
		System.out.println("[OJ-COMPLEX-TC-010] invert number : 1/Complex");
		System.out.println("inverse value of " + c1 + " = " + c3);		
		
		assertTrue(Math.abs(0.1 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(-0.3 - c3.getIm()) < 0.0001);
	}
	
	/**
	 *  [OJ-COMPLEX-TC-011] different number : -Complex
	 */
	@Test
	public void ojComplexTest011() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		
		c3 = (Complex)c1.diff();
		System.out.println("[OJ-COMPLEX-TC-011] different number : -Complex");
		System.out.println("different value of " + c1 + " = " + c3);		
		
		assertTrue(Math.abs(-1.0 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(-3.0 - c3.getIm()) < 0.0001);
	}
	
	/**
	 *  [OJ-COMPLEX-TC-011] equal test
	 */
	@Test
	public void ojComplexTest012() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);

		c3 = new Complex(c1.getRe(), c1.getIm());
		
		if(c1 == c3)
			System.out.println("c1 == c3");
		else
			System.out.println("c1 != c3");
		
		assertTrue(Math.abs(c1.getRe() - c3.getRe())< 0.0001);
		assertTrue(Math.abs(c1.getIm() - c3.getIm())< 0.0001);
	}
	
	/**
	 *  [OJ-COMPLEX-TC-013] clone test
	 */
	@Test
	public void ojComplexTest013() {
		c1 = new Complex(1.0, 3.0);
		c2 = new Complex(-2.0, 5.0);
		c3 = new Complex(0.0, 0.0);
		
		/** 
		 *  case : clone - memory not shared 
		 */
		try {
			c3 = (Complex) c1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println("clone     : C1 = " + c1 + "\t" + "C3 = " + c3);
		assertTrue(Math.abs(1.0 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(3.0 - c3.getIm()) < 0.0001);
		
		
		c1.set(2.0, 4.0);
		System.out.println("change c1 : C1 = " + c1 + "\t" + "C3 = " + c3);
		assertTrue(Math.abs(1.0 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(3.0 - c3.getIm()) < 0.0001);
		
		/** 
		 *  case : assignment - memory shared 
		 */
		c3 = c1;
		System.out.println("assign    : C1 = " + c1 + "\t" + "C3 = " + c3);
		c1.set(1.0, 3.0);
		System.out.println("change c1 : C1 = " + c1 + "\t" + "C3 = " + c3);
		assertTrue(Math.abs(1.0 - c3.getRe()) < 0.0001);
		assertTrue(Math.abs(3.0 - c3.getIm()) < 0.0001);
	}
}
