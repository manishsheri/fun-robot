/**
 * 
 */
package org.openjasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.types.Complex;
import org.openjasmine.types.Matrix;

/**
 * @author Hyeon-min.Shim(elecage@gmail.com)
 *
 */
public class MatrixTest {

	double dr;
	Complex cr;
	Matrix md1;
	Matrix md2;
	Matrix md3;
	Matrix md5;
	
	
	Matrix mc1;
	Matrix mc2;
	Matrix mc3;
	Matrix mc5;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Double[][] d1 = {{1.0, 2.0, 3.0, 4.0},  {3.0, 4.0, 5.0, 6.0},    {6.0, 3.0, 7.0, 3.0}};
		Double[][] d2 = {{3.0, 7.0, -2.0, 1.0}, {-1.0, 4.0, -5.0, -4.0}, {3.0, -9.0, 0.0, 4.0}};
		Double[][] d3 = {{2.0, 3.0, 6.0, 9.4}, {9.0, 8.0, 2.0, 1.0}, {6.0,2.0,7.0 , 8.0}, {6.0, 2.0, 0.5, 4.0}};
		Complex[][] c1 = {{Complex.getComplex(2.0, 3.4),   Complex.getComplex(-2.4, 3.2),  Complex.getComplex(5.4, -1.7),  Complex.getComplex(-3.4, -3.5)},
						  {Complex.getComplex(-2.0, 1.4),  Complex.getComplex(-4.4, -5.2), Complex.getComplex(9.0, 4.0),   Complex.getComplex(0.4, 0.5)},
						  {Complex.getComplex(22.0, 53.1), Complex.getComplex(36.5, 13.2), Complex.getComplex(5.4, 1.7),   Complex.getComplex(-3.4, 2.2)}};
		Complex[][] c2 = {{Complex.getComplex(-12.0, 5.4), Complex.getComplex(19.4, 7.2),  Complex.getComplex(8.4, -3.7),  Complex.getComplex(-3.6, -3.1)},
				  		  {Complex.getComplex(-5.0, 8.4),  Complex.getComplex(3.4, 3.2),   Complex.getComplex(-7.0, -5.0), Complex.getComplex(2.4, 3.5)},
				  		  {Complex.getComplex(22.4, 13.5), Complex.getComplex(3.3, 6.7),   Complex.getComplex(54.3, 3.7),  Complex.getComplex(-6.4, 3.2)}};
		Complex[][] c3 = {{Complex.getComplex(4.0, 2.4), Complex.getComplex(4.7, 6.4), Complex.getComplex(2.7, -0.8), Complex.getComplex(3.4, -0.5)},
						  {Complex.getComplex(-1.0, -3.6), Complex.getComplex(1.3, -6.3), Complex.getComplex(3.4, 0.5), Complex.getComplex(2.4, 3.7)},
						  {Complex.getComplex(5.0, -7.4), Complex.getComplex(-2.7, 4.4), Complex.getComplex(7.6, -0.8), Complex.getComplex(1.9, 3.5)},
						  {Complex.getComplex(8.0, 2.1), Complex.getComplex(8.1, 1.4), Complex.getComplex(-4.7, 7.4), Complex.getComplex(-1.4, 4.5)}};
		
		cr = new Complex(0.0, 0.0);
		md1 = new Matrix(d1);
		md2 = new Matrix(d2);
		md3 = new Matrix(d3);

		
		
		mc1 = new Matrix(c1);
		mc2 = new Matrix(c2);
		mc3 = new Matrix(c3);

		System.out.println("md1 = \n" + md1);
		System.out.println("md2 = \n" + md2);
		System.out.println("md3 = \n" + md3);
		System.out.println("mc1 = \n" + mc1);
		System.out.println("mc2 = \n" + mc2);
		System.out.println("mc3 = \n" + mc3);
	}
	/**
	 * [OJ-MAT-TC-001] Matrix<double> + Matrix<double>
	 */
	@Test
	public void ojMatTest001() {
		md5 = (Matrix)md1.plus(md2);
		System.out.println("[OJ-MAT-TC-001] Matrix<dobule> + Matrix<double>");
		System.out.println("md1 + md2 = \n" + md5);
		/*
		 *    4     9     1     5
     	 * 	  2     8     0     2
     	 *    9    -6     7     7
		 */
		assertTrue(Math.abs(4.0 - ((Double)md5.getElement(0, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(9.0 - ((Double)md5.getElement(0, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(0, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(5.0 - ((Double)md5.getElement(0, 3)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(2.0 - ((Double)md5.getElement(1, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(8.0 - ((Double)md5.getElement(1, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(2.0 - ((Double)md5.getElement(1, 3)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(9.0 - ((Double)md5.getElement(2, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-6.0 - ((Double)md5.getElement(2, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(7.0 - ((Double)md5.getElement(2, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(7.0 - ((Double)md5.getElement(2, 3)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-002] Matrix<Complex> + Matrix<Complex>
	 */
	@Test
	public void ojMatTest002() {
		mc5 = (Matrix)mc1.plus(mc2);
		
		System.out.println("[OJ-MAT-TC-002] Matrix<Complex> + Matrix<Complex>");
		System.out.println("mc1 + mc2 = \n" + mc5);
		/*
		 *  -10.0000 + 8.8000i  17.0000 +10.4000i  13.8000 - 5.4000i  -7.0000 - 6.6000i
  		 */
		assertTrue(Math.abs(-10.0 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(8.8 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(17.0 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(10.4 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(13.8 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.4 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(-7.0 - ((Complex)mc5.getElement(0, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-6.6 - ((Complex)mc5.getElement(0, 3)).getIm()) < 0.0001);
		/*
		 *	-7.0000 + 9.8000i   -1.0000 - 2.0000i   2.0000 - 1.0000i   2.8000 + 4.0000i
		 */
		assertTrue(Math.abs(-7.0000 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(9.8000 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-1.0000 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-2.0000 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(2.0000 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.0000- ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(2.8000 - ((Complex)mc5.getElement(1, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(4.0000 - ((Complex)mc5.getElement(1, 3)).getIm()) < 0.0001);
		/*
 		 *	44.4000 +66.6000i   39.8000 +19.9000i  59.7000 + 5.4000i  -9.8000 + 5.4000i
	     */
		assertTrue(Math.abs(44.4000 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(66.6000 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(39.8000 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(19.9000 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(59.7000 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(5.4000- ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(-9.8000 - ((Complex)mc5.getElement(2, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(5.4000 - ((Complex)mc5.getElement(2, 3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-003] Matrix<double> + Matrix<Complex>
	 */
	@Test
	public void ojMatTest003() {
		mc5 = (Matrix)md1.plus(mc2);
		System.out.println("[OJ-MAT-TC-003] Matrix<Complex> + Matrix<Complex>");
		System.out.println("md1 + mc2 = \n" + mc5);
		
		/*
		 *   -11.0000 + 5.4000i  21.4000 + 7.2000i  11.4000 - 3.7000i   0.4000 - 3.1000i
  		 */
		assertTrue(Math.abs(-11.0000 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(5.400 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(21.4000 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(7.2000 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(11.4000 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.7000 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(0.4000 - ((Complex)mc5.getElement(0, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.1000 - ((Complex)mc5.getElement(0, 3)).getIm()) < 0.0001);
		/*
		 *	-2.0000 + 8.4000i   7.4000 + 3.2000i  -2.0000 - 5.0000i   8.4000 + 3.5000i
		 */
		assertTrue(Math.abs(-2.0000 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(8.4000 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(7.4000 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.2000 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-2.0000 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.0000- ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(8.4000 - ((Complex)mc5.getElement(1, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.5000 - ((Complex)mc5.getElement(1, 3)).getIm()) < 0.0001);
		/*
 		 *	28.4000 +13.5000i   6.3000 + 6.7000i  61.3000 + 3.7000i  -3.4000 + 3.2000i
	     */
		assertTrue(Math.abs(28.4000 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(13.5000 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(6.3000 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(6.7000 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(61.3000 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.7000 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(-3.4000 - ((Complex)mc5.getElement(2, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.2000 - ((Complex)mc5.getElement(2, 3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-004] Matrix<Complex> + Matrix<Double>
	 */		
	@Test
	public void ojMatTest004() {
		mc5 = (Matrix)mc1.plus(md2);
		System.out.println("[OJ-MAT-TC-004] Matrix<Complex> + Matrix<Double>");
		System.out.println("mc1 + md2 = \n" + mc5);

		/*
		 *    5.0000 + 3.4000i   4.6000 + 3.2000i   3.4000 - 1.7000i  -2.4000 - 3.5000i
  		 */
		assertTrue(Math.abs(5.0000 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.4000 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(4.6000 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.2000 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(3.4000 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.7000 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(-2.4000 - ((Complex)mc5.getElement(0, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.5000 - ((Complex)mc5.getElement(0, 3)).getIm()) < 0.0001);
		/*
		 *	 -3.0000 + 1.4000i  -0.4000 - 5.2000i   4.0000 + 4.0000i  -3.6000 + 0.5000i
		 */
		assertTrue(Math.abs(-3.0000 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.4000 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-0.4000 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.2000 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(4.0000 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(4.0000- ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(-3.6000 - ((Complex)mc5.getElement(1, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.5000 - ((Complex)mc5.getElement(1, 3)).getIm()) < 0.0001);
		/*
 		 *	 25.0000 +53.1000i  27.5000 +13.2000i   5.4000 + 1.7000i   0.6000 + 2.2000i
	     */
		assertTrue(Math.abs(25.0000 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(53.1000 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(27.5000 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(13.2000 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(5.4000 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.7000 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(0.6000 - ((Complex)mc5.getElement(2, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.2000 - ((Complex)mc5.getElement(2, 3)).getIm()) < 0.0001);
	}
	/**
	 * [OJ-MAT-TC-005] Matrix<double> - Matrix<double>
	 */
	@Test
	public void ojMatTest005() {
		md5 = (Matrix)md1.minus(md2);

		System.out.println("[OJ-MAT-TC-005] Matrix<double> - Matrix<double>");
		System.out.println("md1 - md2 = \n" + md5);
		/*
		 *  -2    -5     5     3
		 */
		assertTrue(Math.abs(-2.0 - ((Double)md5.getElement(0, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-5.0 - ((Double)md5.getElement(0, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(5.0 - ((Double)md5.getElement(0, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(3.0 - ((Double)md5.getElement(0, 3)).doubleValue()) < 0.0001);
		
		/*
		 *  4     0    10    10
		 */
		assertTrue(Math.abs(4.0 - ((Double)md5.getElement(1, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(10.0 - ((Double)md5.getElement(1, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(10.0 - ((Double)md5.getElement(1, 3)).doubleValue()) < 0.0001);
		
		/*
		 *  3    12     7    -1
		 */
		assertTrue(Math.abs(3.0 - ((Double)md5.getElement(2, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(12.0 - ((Double)md5.getElement(2, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(7.0 - ((Double)md5.getElement(2, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-1.0 - ((Double)md5.getElement(2, 3)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-006] Matrix<Complex> - Matrix<Complex>
	 */
	@Test
	public void ojMatTest006() {
		mc5 = (Matrix)mc1.minus(mc2);
		System.out.println("[OJ-MAT-TC-006] Matrix<Complex> - Matrix<Complex>");
		System.out.println("mc1 - mc2 = \n" + mc5);
		
		/*
		 *   14.0000 - 2.0000i -21.8000 - 4.0000i  -3.0000 + 2.0000i   0.2000 - 0.4000i
  		 */
		assertTrue(Math.abs(14.0000 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-2.0000 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-21.8000 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-4.0000 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-3.0000 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.0000 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(0.2000 - ((Complex)mc5.getElement(0, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.4000 - ((Complex)mc5.getElement(0, 3)).getIm()) < 0.0001);
		/*
		 *	 3.0000 - 7.0000i  -7.8000 - 8.4000i  16.0000 + 9.0000i  -2.0000 - 3.0000i
		 */
		assertTrue(Math.abs(3.0000 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-7.0000 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-7.8000 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-8.4000 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(16.0000 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(9.0000 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(-2.0000  - ((Complex)mc5.getElement(1, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.0000 - ((Complex)mc5.getElement(1, 3)).getIm()) < 0.0001);
		/*
 		 *	 -0.4000 +39.6000i  33.2000 + 6.5000i -48.9000 - 2.0000i   3.0000 - 1.0000i
	     */
		assertTrue(Math.abs(-0.4000 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(39.6000 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(33.2000 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(6.5000 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-48.9000 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-2.0000 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(3.0000 - ((Complex)mc5.getElement(2, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.0000 - ((Complex)mc5.getElement(2, 3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-007] Matrix<double> - Matrix<Complex>
	 */
	@Test
	public void ojMatTest007() {
		mc5 = (Matrix)md1.minus(mc2);
		System.out.println("[OJ-MAT-TC-007] Matrix<double> - Matrix<Complex>");
		System.out.println("md1 - mc2 = \n" + mc5);
		
		/*
		 *    13.0000 - 5.4000i -17.4000 - 7.2000i  -5.4000 + 3.7000i   7.6000 + 3.1000i
  		 */
		assertTrue(Math.abs(13.0000 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.4000 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-17.4000 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-7.2000 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-5.4000 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.7000 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(7.6000 - ((Complex)mc5.getElement(0, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.1000 - ((Complex)mc5.getElement(0, 3)).getIm()) < 0.0001);
		/*
		 *	 8.0000 - 8.4000i   0.6000 - 3.2000i  12.0000 + 5.0000i   3.6000 - 3.5000i
		 */
		assertTrue(Math.abs(8.0000 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-8.4000 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(0.6000 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.2000 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(12.0000 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(5.0000 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(3.6000  - ((Complex)mc5.getElement(1, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.5000 - ((Complex)mc5.getElement(1, 3)).getIm()) < 0.0001);
		/*
 		 *	 -16.4000 -13.5000i  -0.3000 - 6.7000i -47.3000 - 3.7000i   9.4000 - 3.2000i
	     */
		assertTrue(Math.abs(-16.4000 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-13.5000 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-0.3000 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-6.7000 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-47.3000 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.7000 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(9.4000 - ((Complex)mc5.getElement(2, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.2000 - ((Complex)mc5.getElement(2, 3)).getIm()) < 0.0001);	
	}
	
	/**
	 * [OJ-MAT-TC-008] Matrix<Complex> - Matrix<double>
	 */
	@Test
	public void ojMatTest008() {
		mc5 = (Matrix)mc1.minus(md2);
		System.out.println("[OJ-MAT-TC-008] Matrix<Complex> - Matrix<double>");
		System.out.println("mc1 - md2 = \n" + md5);
		
		/*
		 *    -1.0000 + 3.4000i  -9.4000 + 3.2000i   7.4000 - 1.7000i  -4.4000 - 3.5000i
  		 */
		assertTrue(Math.abs(-1.0000 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.4000 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-9.4000 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.2000 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(7.4000 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.7000 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(-4.4000 - ((Complex)mc5.getElement(0, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.5000 - ((Complex)mc5.getElement(0, 3)).getIm()) < 0.0001);
		/*
		 *	  -1.0000 + 1.4000i  -8.4000 - 5.2000i  14.0000 + 4.0000i   4.4000 + 0.5000i
		 */
		assertTrue(Math.abs(-1.0000 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.4000 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-8.4000 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.2000 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(14.0000 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(4.0000 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(4.4000  - ((Complex)mc5.getElement(1, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.5000 - ((Complex)mc5.getElement(1, 3)).getIm()) < 0.0001);
		/*
 		 *	 19.0000 +53.1000i  45.5000 +13.2000i   5.4000 + 1.7000i  -7.4000 + 2.2000i
	     */
		assertTrue(Math.abs(19.0000 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(53.1000 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(45.5000 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(13.2000 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(5.4000 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.7000 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);

		assertTrue(Math.abs(-7.4000 - ((Complex)mc5.getElement(2, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.2000 - ((Complex)mc5.getElement(2, 3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-009] transpose(Matrix<double>)
	 */
	@Test
	public void ojMatTest009() {
		md5 = md1.transpose();
		
		System.out.println("[OJ-MAT-TC-009] transpose(Matrix<double>)");
		System.out.println("transpose(md1)= \n" + md5);
		/*
		 *  1     3     6
		 */
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(0, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(3.0 - ((Double)md5.getElement(0, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(6.0 - ((Double)md5.getElement(0, 2)).doubleValue()) < 0.0001);
		
		/*
		 *  2     4     3
		 */
		assertTrue(Math.abs(2.0 - ((Double)md5.getElement(1, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(4.0 - ((Double)md5.getElement(1, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(3.0 - ((Double)md5.getElement(1, 2)).doubleValue()) < 0.0001);

		/*
		 *  3     5     7
		 */
		assertTrue(Math.abs(3.0 - ((Double)md5.getElement(2, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(5.0 - ((Double)md5.getElement(2, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(7.0 - ((Double)md5.getElement(2, 2)).doubleValue()) < 0.0001);

		/*
		 *  4     6     3
		 */
		assertTrue(Math.abs(4.0 - ((Double)md5.getElement(3, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(6.0 - ((Double)md5.getElement(3, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(3.0 - ((Double)md5.getElement(3, 2)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-010] transpose(Matrix<Complex>)
	 */
	@Test
	public void ojMatTest010() {
mc5 = mc1.transpose();
		
		System.out.println("[OJ-MAT-TC-010] transpose(Matrix<Complex>)");
		System.out.println("transpose(mdc)= \n" + mc5);
		/*
		 *	  2.0000 + 3.4000i  -2.0000 + 1.4000i  22.0000 +53.1000i
		 */
		assertTrue(Math.abs(2.0000 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.4000 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-2.0000 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.4000 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(22.0000 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(53.1000 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		/*
 		 *	  -2.4000 + 3.2000i  -4.4000 - 5.2000i  36.5000 +13.2000i
	     */
		assertTrue(Math.abs(-2.4000 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.2000 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-4.4000 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.2000 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(36.5000 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(13.2000 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		/*
		 *	   5.4000 - 1.7000i   9.0000 + 4.0000i   5.4000 + 1.7000i
		 */
		assertTrue(Math.abs(5.4000 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.7000 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(9.0000 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(4.0000 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(5.4000 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.7000 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);

		/*
 		 *	  -3.4000 - 3.5000i   0.4000 + 0.5000i  -3.4000 + 2.2000i
	     */
		assertTrue(Math.abs(-3.4000 - ((Complex)mc5.getElement(3, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.5000 - ((Complex)mc5.getElement(3, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(0.4000 - ((Complex)mc5.getElement(3, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.5000 - ((Complex)mc5.getElement(3, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-3.4000 - ((Complex)mc5.getElement(3, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.2000 - ((Complex)mc5.getElement(3, 2)).getIm()) < 0.0001);
	}
	/**
	 * [OJ-MAT-TC-010] Identity matrix
	 */
	@Test
	public void ojMatTest011() {
		md5 = Matrix.eye(10);
		System.out.println("[OJ-MAT-TC-011] Identity matrix");
		System.out.println("transpose(md1)= \n" + md5);
		
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(0, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(2, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(3, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(4, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(5, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(6, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(7, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(8, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(9, 0)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(0, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(1, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(2, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(3, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(4, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(5, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(6, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(7, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(8, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(9, 1)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(0, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(2, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(3, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(4, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(5, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(6, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(7, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(8, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(9, 2)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(0, 3)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 3)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(2, 3)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(3, 3)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(4, 3)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(5, 3)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(6, 3)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(7, 3)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(8, 3)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(9, 3)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(0, 4)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 4)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(2, 4)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(3, 4)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(4, 4)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(5, 4)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(6, 4)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(7, 4)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(8, 4)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(9, 4)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(0, 5)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 5)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(2, 5)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(3, 5)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(4, 5)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(5, 5)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(6, 5)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(7, 5)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(8, 5)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(9, 5)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(0, 6)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 6)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(2, 6)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(3, 6)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(4, 6)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(5, 6)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(6, 6)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(7, 6)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(8, 6)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(9, 6)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(0, 7)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 7)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(2, 7)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(3, 7)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(4, 7)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(5, 7)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(6, 7)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(7, 7)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(8, 7)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(9, 7)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(0, 8)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 8)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(2, 8)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(3, 8)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(4, 8)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(5, 8)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(6, 8)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(7, 8)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(8, 8)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(9, 8)).doubleValue()) < 0.0001);
		
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(0, 9)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(1, 9)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(2, 9)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(3, 9)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(4, 9)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(5, 9)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(6, 9)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(7, 9)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Double)md5.getElement(8, 9)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(9, 9)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-012] Matrix(double) trace
	 */
	@Test
	public void ojMatTest012() {
		dr = ((Double)md3.trace()).doubleValue();
		System.out.println("[OJ-MAT-TC-012] Matrix(double) trace");
		System.out.println("trace(md3)= " + dr);
		assertTrue(Math.abs(21.0 - dr) < 0.001);
	}
	/**
	 * [OJ-MAT-TC-013] Matrix(Complex) trace
	 */
	@Test
	public void ojMatTest013() {
cr = (Complex)mc3.trace();
		
		System.out.println("[OJ-MAT-TC-013] Matrix(Complex) trace");
		System.out.println("trace(mc3)= " + cr);
		
		assertTrue(Math.abs(11.5 - cr.getRe()) < 0.001);
		assertTrue(Math.abs(-0.2 - cr.getIm()) < 0.001);
	}
}
