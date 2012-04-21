/*
 * Copyright (c) <2012> <Hyeon-min.shim(elecage@gmail.com)>
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package org.open_jasmin.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.open_jasmin.operators.Op;
import org.open_jasmin.types.Complex;
import org.open_jasmin.types.Polar;


/**
 * @author elecage@gmail.com
 *
 */
public class ComplexOperationTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Complex c1, c2, c3, c4;
		double d1 = 7.0;
		double d2 = -4.0;
		double d3, d4;
		
		c1 = new Complex(3.0, 4.0);
		c2 = new Complex(2.0, 4.0);
		
		/**
		 * [JASMIN-TC-COMPLEX-001] Complex + Complex
		 * input 1 : c1 - Complex: 3.0 + 4.0i
		 * input 2 : c2 - Complex: 2.0 + 4.0i
		 * expected output : c3 - Complex: 5.0 + 8.0i
		 */
		c3 = Op.plus(c1, c2);
		
		assertTrue(5.0 == c3.getRe());
		assertTrue(8.0 == c3.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-001] " + c1 + " + " + c2 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-002] Complex + double
		 * input 1 : c1 - Complex: 3.0 + 4.0i
		 * input 2 : d1 - double: 7.0
		 * expected output : c3 - Complex: 10.0 + 4.0i
		 */
		c3 = Op.plus(c1, d1);
		
		assertTrue(10.0 == c3.getRe());
		assertTrue(4.0 == c3.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-002] " + c1 + " + " + d1 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-003] double + Complex
		 * input 1 : d2 - double: -4.0
		 * input 2 : c2 - Complex: -2.0+4.0i
		 * expected output : c3 - Complex: 10.0 + 4.0i
		 */
		c3 = Op.plus(d2, c2);
		
		assertTrue(-2.0 == c3.getRe());
		assertTrue(4.0 == c3.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-003] " + d2 + " + " + c2 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-004] double + double
		 * input 1 : d1 - double: 7.0
		 * input 2 : d2 - double: -4.0
		 * expected output : d3 = double: -3.0
		 */
		d3 = Op.plus(d1, d2);
		
		assertTrue(3.0 == d3);
		
		System.out.println("[JASMIN-TC-COMPLEX-004] " +  d1 + " + " + d2 + " = " + d3);
		
		/**
		 * [JASMIN-TC-COMPLEX-005] Complex - Complex
		 * input 1 : c1 - Complex: 3.0 + 4.0i
		 * input 2 : c2 - Complex: 2.0 + 4.0i
		 * expected output : c3 - Complex: 1.0 + 0.0i
		 */
		c3 = Op.minus(c1, c2);
		
		assertTrue(1.0 == c3.getRe());
		assertTrue(0.0 == c3.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-005] " +  c1 + " - " + c2 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-006] Complex - double
		 * input 1 : c1 - Complex: 3.0 + 4.0i
		 * input 2 : d1 = 7.0
		 * expected output : c3 - Complex: -4.0 + 0.0i
		 */
		c3 = Op.minus(c1, d1);
		
		assertTrue(-4.0 == c3.getRe());
		assertTrue(4.0 == c3.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-006] " +  c1 + " - " + d1 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-007] double - Complex
		 * input 1 : d2 - double: -4.0
		 * input 2 : c2 - Complex: 2.0+4.0i
		 * expected output : c3 - Complex: -6.0 - 4.0i
		 */
		c3 = Op.minus(d2, c2);
		
		assertTrue(-6.0 == c3.getRe());
		assertTrue(-4.0 == c3.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-007] " +  d2 + " - " + c2 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-008] double - double
		 * input 1 : d1 - double: 7.0
		 * input 2 : d2 - double: -4.0
		 * expected output : d3 - double: 11.0
		 */
		d3 = Op.minus(d1, d2);
		
		assertTrue(11.0 == d3);
		
		System.out.println("[JASMIN-TC-COMPLEX-008] " +  d1 + " - " + d2 + " = " + d3);
		
		/**
		 * [JASMIN-TC-COMPLEX-009] Complex * Complex
		 * input 1 : c1 - Complex: 3.0 + 4.0i
		 * input 2 : c2 - Complex: 2.0+4.0i
		 * expected output : c3 - Complex: -8.0 -16i
		 */
		c3 = Op.times(c1, c2);
		
		assertTrue(-10. == c3.getRe());
		assertTrue(20. == c3.getIm());
		
		System.out.println( "[JASMIN-TC-COMPLEX-009] "+ c1 + " * " + c2 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-010] Complex * double
		 * input 1 : c1 - Complex: 3.0 + 4.0i
		 * input 2 : d1 - double: 7.0
		 * expected output : c3 - Complex: -21.0 +28i
		 */
		c3 = Op.times(c1,  d1);
		
		assertTrue(21.0 == c3.getRe());
		assertTrue(28.0 == c3.getIm());
		
		System.out.println( "[JASMIN-TC-COMPLEX-010] "+ c1 + " * " + d1 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-011] double * Complex
		 * input 1 : d2 - double: -4.0
		 * input 2 : c2 - Complex: 2.0+4.0i
		 * expected output : c3 - Complex: -8.0 -16i
		 */
		c3 = Op.times(d2, c2);
		
		assertTrue(-8.0 == c3.getRe());
		assertTrue(-16.0 == c3.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-011] "+ d2 + " * " + c2 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-012] double * double
		 * input 1 : d1 - double: 7.0
		 * input 2 : d2 - double: -4.0
		 * expected output : d3 - double: -28
		 */
		d3 = Op.times(d1, d2);
		
		assertTrue(-28.0 == d3);
		
		System.out.println("[JASMIN-TC-COMPLEX-012] "+ d1 + " * " + d2 + " = " + d3);
		
		/**
		 * [JASMIN-TC-COMPLEX-013] Complex / Complex
		 * input 1 : c1 - Complex: 3.0 + 4.0i
		 * input 2 : c2 - Complex: 2.0+4.0i
		 * expected output : c3 - Complex: 1.1 - 0.2i
		 */
		c3 = Op.divide(c1, c2);
		
		assertTrue(1.1 == c3.getRe());
		assertTrue(-0.2 == c3.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-013] "+ c1 + " / " + c2 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-014] Complex / double
		 * input 1 : c1 - Complex: 3.0 + 4.0i
		 * input 2 : d1 - double: 7.0
		 * expected output : c3 - Complex: 0.4286 - 0.5714i
		 */
		c3 = Op.divide(c1, d1);
		
		assertTrue(Math.abs(0.4286 - c3.getRe()) < Op.TOL);
		assertTrue(Math.abs(0.5714 - c3.getIm()) < Op.TOL);
		
		System.out.println("[JASMIN-TC-COMPLEX-014] "+ c1 + " / " + d1 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-015] double / Complex
		 * input 1 : d2 - double: -4.0
		 * input 2 : c2 - Complex: 2.0+4.0i
		 * expected output : c3 - Complex: -0.4 - 0.8i
		 */
		c3 = Op.divide(d2, c2);
		
		assertTrue(-0.4 == c3.getRe());
		assertTrue(0.8 == c3.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-015] "+ d2 + " / " + c2 + " = " + c3);
		
		/**
		 * [JASMIN-TC-COMPLEX-016] double / double
		 * input 1 : d1 - double: 7.0
		 * input 2 : d2 - double: -4.0
		 * expected output : d3 - double: -1.75
		 */
		d3 = Op.divide(d1, d2);
		
		assertTrue(Math.abs(d3 + 1.75) < Op.TOL);
		
		System.out.println("[JASMIN-TC-COMPLEX-016] "+ d1 + " / " + d2 + " = " + d3);
		
		/**
		 * [JASMIN-TC-COMPLEX-017] absolute number of double
		 * input a : d1 - double: 7.0
		 * expected output : d3 - double: 7.0
		 * input b : d2 - double: -4.0
		 * expected output : d4 - double: 4.0
		 */
		d3 = Op.abs(d1);
		d4 = Op.abs(d2);
		
		assertTrue(7.0 == d3);
		assertTrue(4.0 == d4);
		
		System.out.println("[JASMIN-TC-COMPLEX-017a] absolute number of " + d1 + " is " + d3);		
		System.out.println("[JASMIN-TC-COMPLEX-017b] absolute number of " + d2 + " is " + d4);
		
		/**
		 * [JASMIN-TC-COMPLEX-018] absolute number of Complex
		 * input a : c1 - Complex: 3.0 + 4.0i
		 * expected output : d3 - double: 5.0
		 * input b : c2 - Complex: 2.0+4.0i
		 * expected output : d4 - double: 4.47213
		 */
		d3 = Op.abs(c1);
		d4 = Op.abs(c2);
		
		assertTrue(5.0 == d3);
		assertTrue(Math.abs(4.47213 - d4) < Op.TOL);
		
		System.out.println("[JASMIN-TC-COMPLEX-018a] absolute number of " + c1 + " is " + d3);
		System.out.println("[JASMIN-TC-COMPLEX-018b] absolute number of " + c2 + " is " + d4);
		
		/**
		 * [JASMIN-TC-COMPLEX-019] Conjugate number of Complex
		 * input a : c1 - Complex: 3.0 + 4.0i
		 * expected output : c3 - Complex: 3.0 - 4.0i
		 * input b : c2 - Complex: 2.0 + 4.0i
		 * expected output : c4 - Complex: 2.0 - 4.0i;
		 */
		c3 = Op.conj(c1);
		c4 = Op.conj(c2);
		
		assertTrue(3.0 == c3.getRe());
		assertTrue(-4.0 == c3.getIm());
		assertTrue(2.0 == c4.getRe());
		assertTrue(-4.0 == c4.getIm());
		
		System.out.println("[JASMIN-TC-COMPLEX-019a] Conjugate number of " + c1 + " is " + c3);
		System.out.println("[JASMIN-TC-COMPLEX-019b] Conjugate number of " + c2 + " is " + c4);
		
		/**
		 * [JASMIN-TC-COMPLEX-020] Convert Complex to Polar
		 * input a : c1 - Complex: 3.0 + 4.0i
		 * expected output : p - Polar: 5.0¡Ð0.9272952180016122
		 */
		Polar p = new Polar();
		
		p = c1.toPolar();
		
		System.out.println("[JASMIN-TC-COMPLEX-020] " + c1 + " -> " + p);
		
		/**
		 * [JASMIN-TC-COMPLEX-020] Convert Complex to Polar
		 * input a : p - 5.0¡Ð0.9272952180016122
		 * expected output : c3 - Complex: 3.0 + 4.0i
		 */
		
		c3.fromPolar(p);
		System.out.println("[JASMIN-TC-COMPLEX-021] " + p + " -> " + c3);
	}
}
