package org.openjasmine.tests;
/**
 * @filename MatrixTest.java
 * @author Hyeon-min.Shim(elecage@gmail.com)
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.types.Complex;
import org.openjasmine.types.Matrix;
import org.openjasmine.types.VectoR;

public class MatrixTest {

	double dr;
	Complex cr;
	Matrix md1;
	Matrix md2;
	Matrix md3;
	Matrix md4;
	Matrix md5;
	
	
	Matrix mc1;
	Matrix mc2;
	Matrix mc3;
	Matrix mc4;
	Matrix mc5;
	
	VectoR vd1;
	VectoR vc1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Double[][] d1 = {{1.0, 2.0, 3.0, 4.0},  {3.0, 4.0, 5.0, 6.0},    {6.0, 3.0, 7.0, 3.0}};
		Double[][] d2 = {{3.0, 7.0, -2.0, 1.0}, {-1.0, 4.0, -5.0, -4.0}, {3.0, -9.0, 0.0, 4.0}};
		Double[][] d3 = {{2.0, 3.0, 6.0, 9.4}, {9.0, 8.0, 2.0, 1.0}, {6.0,2.0,7.0 , 8.0}, {6.0, 2.0, 0.5, 4.0}};
		Complex[][] c1 = {{Complex.setComplex(2.0, 3.4),   Complex.setComplex(-2.4, 3.2),  Complex.setComplex(5.4, -1.7),  Complex.setComplex(-3.4, -3.5)},
						  {Complex.setComplex(-2.0, 1.4),  Complex.setComplex(-4.4, -5.2), Complex.setComplex(9.0, 4.0),   Complex.setComplex(0.4, 0.5)},
						  {Complex.setComplex(22.0, 53.1), Complex.setComplex(36.5, 13.2), Complex.setComplex(5.4, 1.7),   Complex.setComplex(-3.4, 2.2)}};
		Complex[][] c2 = {{Complex.setComplex(-12.0, 5.4), Complex.setComplex(19.4, 7.2),  Complex.setComplex(8.4, -3.7),  Complex.setComplex(-3.6, -3.1)},
				  		  {Complex.setComplex(-5.0, 8.4),  Complex.setComplex(3.4, 3.2),   Complex.setComplex(-7.0, -5.0), Complex.setComplex(2.4, 3.5)},
				  		  {Complex.setComplex(22.4, 13.5), Complex.setComplex(3.3, 6.7),   Complex.setComplex(54.3, 3.7),  Complex.setComplex(-6.4, 3.2)}};
		Complex[][] c3 = {{Complex.setComplex(4.0, 2.4), Complex.setComplex(4.7, 6.4), Complex.setComplex(2.7, -0.8), Complex.setComplex(3.4, -0.5)},
						  {Complex.setComplex(-1.0, -3.6), Complex.setComplex(1.3, -6.3), Complex.setComplex(3.4, 0.5), Complex.setComplex(2.4, 3.7)},
						  {Complex.setComplex(5.0, -7.4), Complex.setComplex(-2.7, 4.4), Complex.setComplex(7.6, -0.8), Complex.setComplex(1.9, 3.5)},
						  {Complex.setComplex(8.0, 2.1), Complex.setComplex(8.1, 1.4), Complex.setComplex(-4.7, 7.4), Complex.setComplex(-1.4, 4.5)}};
		
		cr = new Complex(0.0, 0.0);
		md1 = new Matrix(d1);
		md2 = new Matrix(d2);
		md3 = new Matrix(d3);

		
		
		mc1 = new Matrix(c1);
		mc2 = new Matrix(c2);
		mc3 = new Matrix(c3);

		Double[] vdarray = {2.0, 9.0, 5.0, 3.0};
		vd1 = new VectoR(vdarray);
		Complex[] vcarray = {new Complex(2.0, 3.0), new Complex(5.0, -2.0), 
							new Complex(-3.0, -1.5), new Complex(-4.0, 3.0)};
		vc1 = new VectoR(vcarray);
		System.out.print("md1 = \n" + md1 + "\n");
		System.out.print("md2 = \n" + md2+ "\n");
		System.out.print("md3 = \n" + md3+ "\n");
		System.out.print("mc1 = \n" + mc1+ "\n");
		System.out.print("mc2 = \n" + mc2+ "\n");
		System.out.print("mc3 = \n" + mc3+ "\n");
		
		System.out.println("vd1 = " + vd1);
		System.out.println("vc1 = " + vc1);
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
	 * [OJ-MAT-TC-011] conjugate transpose(Matrix<Complex>)
	 */
	@Test
	public void ojMatTest011() {
		mc5 = mc1.conjTranspose();
		
		System.out.println("[OJ-MAT-TC-011] conjugate transpose(Matrix<Complex>)");
		System.out.println("transpose(mdc)= \n" + mc5);
		/*
		 *	  2.0000 - 3.4000i  -2.0000 - 1.4000i  22.0000 -53.1000i
		 */
		assertTrue(Math.abs(2.0000 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.4000 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-2.0000 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.4000 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(22.0000 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-53.1000 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		/*
 		 *	  -2.4000 - 3.2000i  -4.4000 + 5.2000i  36.5000 -13.2000i
	     */
		assertTrue(Math.abs(-2.4000 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.2000 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(-4.4000 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(5.2000 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(36.5000 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-13.2000 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		/*
		 *	   5.4000 + 1.7000i   9.0000 - 4.0000i   5.4000 - 1.7000i
		 */
		assertTrue(Math.abs(5.4000 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.7000 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(9.0000 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-4.0000 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(5.4000 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.7000 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);

		/*
 		 *	  -3.4000 + 3.5000i   0.4000 - 0.5000i  -3.4000 - 2.2000i
	     */
		assertTrue(Math.abs(-3.4000 - ((Complex)mc5.getElement(3, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.5000 - ((Complex)mc5.getElement(3, 0)).getIm()) < 0.0001);

		assertTrue(Math.abs(0.4000 - ((Complex)mc5.getElement(3, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.5000 - ((Complex)mc5.getElement(3, 1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-3.4000 - ((Complex)mc5.getElement(3, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-2.2000 - ((Complex)mc5.getElement(3, 2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-012] Identity matrix
	 */
	@Test
	public void ojMatTest012() {
		md5 = Matrix.eye(10);
		System.out.println("[OJ-MAT-TC-012] Identity matrix");
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
	 * [OJ-MAT-TC-013] Matrix(double) trace
	 */
	@Test
	public void ojMatTest013() {
		dr = ((Double)md3.trace()).doubleValue();
		System.out.println("[OJ-MAT-TC-013] Matrix(double) trace");
		System.out.println("trace(md3)= " + dr);
		assertTrue(Math.abs(21.0 - dr) < 0.001);
	}
	/**
	 * [OJ-MAT-TC-014] Matrix(Complex) trace
	 */
	@Test
	public void ojMatTest014() {
		cr = (Complex)mc3.trace();
		
		System.out.println("[OJ-MAT-TC-014] Matrix(Complex) trace");
		System.out.println("trace(mc3)= " + cr);
		
		assertTrue(Math.abs(11.5 - cr.getRe()) < 0.001);
		assertTrue(Math.abs(-0.2 - cr.getIm()) < 0.001);
	}
	/**
	 * [OJ-MAT-TC-015] Matrix(double) * double
	 */
	@Test
	public void ojMatTest015() {
		md5 = (Matrix) md1.times(3.0);
		System.out.println("[OJ-MAT-TC-015] Matrix(double) * double");
		System.out.println("md1 * 3.0 = " + md5);
		/*
		 *  3     6     9    12
		 */
		assertTrue(Math.abs(3.0 - ((Double)md5.getElement(0, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(6.0 - ((Double)md5.getElement(0, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(9.0 - ((Double)md5.getElement(0, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(12.0 - ((Double)md5.getElement(0, 3)).doubleValue()) < 0.0001);
		/*
		 * 9    12    15    18
		 */
		   
		assertTrue(Math.abs(9.0 - ((Double)md5.getElement(1, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(12.0 - ((Double)md5.getElement(1, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(15.0 - ((Double)md5.getElement(1, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(18.0 - ((Double)md5.getElement(1, 3)).doubleValue()) < 0.0001);
		/*
		 * 18     9    21     9
		 */
		assertTrue(Math.abs(18.0 - ((Double)md5.getElement(2, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(9.0 - ((Double)md5.getElement(2, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(21.0 - ((Double)md5.getElement(2, 2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(9.0 - ((Double)md5.getElement(2, 3)).doubleValue()) < 0.0001);
		    
	}
	
	/**
	 * [OJ-MAT-TC-016] Matrix(Complex) * double
	 */
	@Test
	public void ojMatTest016() {
		mc5 = (Matrix) mc1.times(3.0);
		System.out.println("[OJ-MAT-TC-016] Matrix(Complex) * double");
		System.out.println("mc1 * 3.0 = " + mc5);
		/*
		 *  6.00 + 10.20i  -7.20 + 9.60i   16.20 - 05.10i  -10.20 - 10.50i
		 */
		assertTrue(Math.abs(6.0 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(10.20 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-7.2 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(9.6 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(16.2 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.1 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);
		assertTrue(Math.abs(-10.2 - ((Complex)mc5.getElement(0, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-10.5 - ((Complex)mc5.getElement(0, 3)).getIm()) < 0.0001);
		/*
		 *  -06.00 + 04.20i  -13.20 - 15.60i   27.00 + 12.00i   01.20 + 01.50i
		 */
		   
		assertTrue(Math.abs(-6.0 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(4.2 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-13.20 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-15.60 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(27.0 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(12.0 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);
		assertTrue(Math.abs(1.2 - ((Complex)mc5.getElement(1, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.50 - ((Complex)mc5.getElement(1, 3)).getIm()) < 0.0001);
		/*
		 * 66.00 + 159.30i   109.50 + 39.60i   16.20 + 5.10i  -10.20 + 6.60i
		 */
		assertTrue(Math.abs(66.0 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(159.30 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(109.50 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(39.60 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(16.20 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(5.10 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);
		assertTrue(Math.abs(-10.20 - ((Complex)mc5.getElement(2, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(6.6 - ((Complex)mc5.getElement(2, 3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-017] Matrix(double) * Complex
	 */
	@Test
	public void ojMatTest017() {
		mc5 = (Matrix) md1.times(new Complex(3.0, 2.5));
		System.out.println("[OJ-MAT-TC-017] Matrix(double) * Complex");
		System.out.println("md1 * (3.0+2.5i)= " + mc5);
		/*
		 * 3.0000 + 2.5000i   6.0000 + 5.0000i   9.0000 + 7.5000i  12.0000 +10.0000i
		 */
		assertTrue(Math.abs(3.0 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.50 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(6.0 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(5.0 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(9.0 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(7.5 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);
		assertTrue(Math.abs(12.0 - ((Complex)mc5.getElement(0, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(10.0 - ((Complex)mc5.getElement(0, 3)).getIm()) < 0.0001);
		/*
		 *  9.0000 + 7.5000i  12.0000 +10.0000i  15.0000 +12.5000i  18.0000 +15.0000i
		 */
		   
		assertTrue(Math.abs(9.0 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(7.5 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(12.0 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(10.0 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(15.0 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(12.5 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);
		assertTrue(Math.abs(18.0 - ((Complex)mc5.getElement(1, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(15.0 - ((Complex)mc5.getElement(1, 3)).getIm()) < 0.0001);
		/*
		 * 18.0000 +15.0000i   9.0000 + 7.5000i  21.0000 +17.5000i   9.0000 + 7.5000i
		 */
		assertTrue(Math.abs(18.0 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(15.0 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(9.0 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(7.50 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(21.0 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(17.50 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);
		assertTrue(Math.abs(9.00 - ((Complex)mc5.getElement(2, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(7.5 - ((Complex)mc5.getElement(2, 3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-018] Matrix(Complex) * Complex
	 */
	@Test
	public void ojMatTest018() {
		mc5 = (Matrix) mc1.times(new Complex(3.0, 2.5));
		System.out.println("[OJ-MAT-TC-018] Matrix(Complex) * Complex");
		System.out.println("mc1 * (3.0+2.5i)= " + mc5);
		/*
		 * -2.50 + 15.20i  -15.20 + 3.60i   20.45 + 8.40i  -01.45 - 19.00i
		 */
		assertTrue(Math.abs(-2.5 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(15.2 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-15.2 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.6 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(20.45 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(8.4 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);
		assertTrue(Math.abs(-1.45 - ((Complex)mc5.getElement(0, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-19.0 - ((Complex)mc5.getElement(0, 3)).getIm()) < 0.0001);
		/*
		 *  -09.50 - 00.80i  -00.20 - 26.60i   17.00 + 34.50i  -00.05 + 02.50i
		 */
		   
		assertTrue(Math.abs(-9.5 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.8 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-0.20 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-26.6 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(17.0 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(34.5 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);
		assertTrue(Math.abs(-0.05 - ((Complex)mc5.getElement(1, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.5 - ((Complex)mc5.getElement(1, 3)).getIm()) < 0.0001);
		/*
		 *  -66.75 + 214.30i   76.50 + 130.85i   11.95 + 18.60i  -15.70 - 01.90i
		 */
		assertTrue(Math.abs(-66.75 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(214.30 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(76.50- ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(130.85 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(11.95 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(18.60 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);
		assertTrue(Math.abs(-15.70 - ((Complex)mc5.getElement(2, 3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.9 - ((Complex)mc5.getElement(2, 3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-019] Matrix(double) * Vector(double)
	 */
	@Test
	public void ojMatTest019() {
		VectoR v5 = (VectoR) md1.times(vd1);
		
		System.out.println("[OJ-MAT-TC-019] Matrix(double) * VectoR(double)");
		System.out.println("md1 * vd1= " + v5);
		
		assertTrue(Math.abs(47.0 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(85.0 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(83.0 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-020] Matrix(double) * Vector(Complex)
	 */
	@Test
	public void ojMatTest020() {
		VectoR v5 = (VectoR) md1.times(vc1);
		
		System.out.println("[OJ-MAT-TC-020] Matrix(double) * VectoR(Complex)");
		System.out.println("md1 * vc1= " + v5);
		
		/**
		 * -13.0000 - 6.5000i
 		 * -13.0000 -11.5000i
  		 * -6.0000 -10.5000i
		 */
		assertTrue(Math.abs(-13.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(6.5 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-13.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(11.5 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		assertTrue(Math.abs(-6.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(10.5 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-021] Matrix(Complex) * Vector(double)
	 */
	@Test
	public void ojMatTest021() {
		VectoR v5 = (VectoR) mc1.times(vd1);
		
		System.out.println("[OJ-MAT-TC-021] Matrix(Complex) * VectoR(double)");
		System.out.println("mc1 * vd1= " + v5);
		
		/**
		 *  -0.80 + 16.60i
   		 * 2.60 - 22.50i
   		 * 389.30 + 240.10i
		 */
		assertTrue(Math.abs(-0.8 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(16.6 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		assertTrue(Math.abs(2.6 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-22.5 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		assertTrue(Math.abs(389.3 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(240.10 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-022] Matrix(Complex) * Vector(Complex)
	 */
	@Test
	public void ojMatTest022() {
		VectoR v5 = (VectoR) mc1.times(vc1);
		
		System.out.println("[OJ-MAT-TC-022] Matrix(Complex) * VectoR(Complex)");
		System.out.println("mc1 * vc1= " + v5);
		
		/**
		 * -6.45 + 34.40i
  		 * -64.70 - 46.70i
   		 * 86.95 + 133.00i
		 */
		assertTrue(Math.abs(-6.45 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(34.4 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-64.7 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-46.7 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		assertTrue(Math.abs(86.95 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(133.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-023] Matrix(double) * Matrix(Double)
	 */
	@Test
	public void ojMatTest023() {
		md5 = (Matrix) md1.times(md2.transpose());
		
		System.out.println("[OJ-MAT-TC-023] Matrix(double) * Matrix(double)");
		System.out.println("md1 * md2'= " + md5);
		
		/*
		 * 15   -24     1
    	 * 33   -36    -3
    	 * 28   -41     3
		 */

		assertTrue(Math.abs(15.0 - ((Double)md5.getElement(0, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-24.0 - ((Double)md5.getElement(0, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.0 - ((Double)md5.getElement(0, 2)).doubleValue()) < 0.0001);

		
		assertTrue(Math.abs(33.0 - ((Double)md5.getElement(1, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-36.0 - ((Double)md5.getElement(1, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-3.0 - ((Double)md5.getElement(1, 2)).doubleValue()) < 0.0001);

		
		assertTrue(Math.abs(28.0 - ((Double)md5.getElement(2, 0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-41.0 - ((Double)md5.getElement(2, 1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(3.0 - ((Double)md5.getElement(2, 2)).doubleValue()) < 0.0001);

	}
	
	/**
	 * [OJ-MAT-TC-024] Matrix(double) * Matrix(Complex)
	 */
	@Test
	public void ojMatTest024() {
		mc5 = (Matrix) md1.times(mc2.transpose());
		
		System.out.println("[OJ-MAT-TC-024] Matrix(double) * Matrix(Complex)");
		System.out.println("md1 * mc2'= " + mc5);
		
		/*
		 * 37.60 - 03.70i  -09.60 + 13.80i   166.30 + 50.80i
   		 * 62.00 + 07.90i  -22.00 + 34.00i   313.50 + 105.00i
   		 * 34.20 + 18.80i  -61.60 + 35.50i   505.20 + 136.60i
		 */

		assertTrue(Math.abs(37.60 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.7 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-9.6 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(13.8 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(166.3 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(50.8 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		
		assertTrue(Math.abs(62.0 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(7.9 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-22.0 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(34.0 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(313.5 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);		
		assertTrue(Math.abs(105.0 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		
		assertTrue(Math.abs(34.2 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(18.8 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-61.6 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(35.5 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(505.2 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);	
		assertTrue(Math.abs(136.6 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-025] Matrix(Complex) * Matrix(double)
	 */
	@Test
	public void ojMatTest025() {
		mc5 = (Matrix) mc1.times(md2.transpose());
		
		System.out.println("[OJ-MAT-TC-025] Matrix(Complex) * Matrix(double)");
		System.out.println("mc1 * md2'= " + mc5);
		
		/*
		 * -25.00 + 32.50i  -25.00 + 31.90i   14.00 - 32.60i
  		 * -54.40 -39.70i  -62.20 -44.20i   35.20 + 53.00i
   		 * 307.30 + 250.50i   110.60  -17.60i  -276.10 + 49.30i
		 */

		assertTrue(Math.abs(-25.00 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(32.50 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-25.00 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(31.90 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(14.00 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-32.60 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.0001);

		
		assertTrue(Math.abs(-54.40 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-39.70 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs(-62.20 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-44.20 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(35.20 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.0001);		
		assertTrue(Math.abs(53.00- ((Complex)mc5.getElement(1, 2)).getIm()) < 0.0001);

		
		assertTrue(Math.abs(307.30 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.0001);
		assertTrue(Math.abs(250.50 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.0001);
		assertTrue(Math.abs( 110.60 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-17.60 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.0001);
		assertTrue(Math.abs(-276.10 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.0001);	
		assertTrue(Math.abs(49.30 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-026] Matrix(Complex) * Matrix(Complex)
	 */
	@Test
	public void ojMatTest026() {
		mc5 = (Matrix) mc1.times(mc2.transpose());
		
		System.out.println("[OJ-MAT-TC-026] Matrix(Complex) * Matrix(Complex)");
		System.out.println("mc1 * mc2'= " + mc5);
		
		/*
		 * -71.5 + 3.7i  -99.2 - 32.4i   302.0 + 36.8i
   		 * 59.0 - 162.9i  -43.9 - 126.0i   426.4 + 206.3i
   		 * 133.0 - 2.6i  -519.3 + 35.5i   109.6 + 1861.9i
		 */

		assertTrue(Math.abs(-71.5 - ((Complex)mc5.getElement(0, 0)).getRe()) < 0.1);
		assertTrue(Math.abs(3.679 - ((Complex)mc5.getElement(0, 0)).getIm()) < 0.1);
		assertTrue(Math.abs(-99.2 - ((Complex)mc5.getElement(0, 1)).getRe()) < 0.1);
		assertTrue(Math.abs(-32.4 - ((Complex)mc5.getElement(0, 1)).getIm()) < 0.1);
		assertTrue(Math.abs(302.0 - ((Complex)mc5.getElement(0, 2)).getRe()) < 0.1);
		assertTrue(Math.abs(36.8 - ((Complex)mc5.getElement(0, 2)).getIm()) < 0.1);

		
		assertTrue(Math.abs(59.0 - ((Complex)mc5.getElement(1, 0)).getRe()) < 0.1);
		assertTrue(Math.abs(-162.9 - ((Complex)mc5.getElement(1, 0)).getIm()) < 0.1);
		assertTrue(Math.abs(-43.9 - ((Complex)mc5.getElement(1, 1)).getRe()) < 0.1);
		assertTrue(Math.abs(-126.0 - ((Complex)mc5.getElement(1, 1)).getIm()) < 0.1);
		assertTrue(Math.abs(426.4 - ((Complex)mc5.getElement(1, 2)).getRe()) < 0.1);		
		assertTrue(Math.abs(206.3 - ((Complex)mc5.getElement(1, 2)).getIm()) < 0.1);

		
		assertTrue(Math.abs(133.0 - ((Complex)mc5.getElement(2, 0)).getRe()) < 0.1);
		assertTrue(Math.abs(-2.6 - ((Complex)mc5.getElement(2, 0)).getIm()) < 0.1);
		assertTrue(Math.abs(-519.3 - ((Complex)mc5.getElement(2, 1)).getRe()) < 0.1);
		assertTrue(Math.abs(35.5 - ((Complex)mc5.getElement(2, 1)).getIm()) < 0.1);
		assertTrue(Math.abs( 109.6 - ((Complex)mc5.getElement(2, 2)).getRe()) < 0.1);	
		assertTrue(Math.abs(1861.9 - ((Complex)mc5.getElement(2, 2)).getIm()) < 0.1);
	}
	
	/**
	 * [OJ-MAT-TC-027] minor(Matrix(double), i, j)
	 */
	@Test
	public void ojMatTest027() {
		md3 = md1.minor(1, 2);
		System.out.println("[OJ-MAT-TC-027] minor(Matrix(double), i, j)");
		System.out.println("minor(" + md1 + ", 1, 2) = \n" + md3);
		
		assertTrue(md3.getElement(0, 0) == md1.getElement(0, 0));
		assertTrue(md3.getElement(0, 1) == md1.getElement(0, 1));
		assertTrue(md3.getElement(0, 2) == md1.getElement(0, 3));
		
		assertTrue(md3.getElement(1, 0) == md1.getElement(2, 0));
		assertTrue(md3.getElement(1, 1) == md1.getElement(2, 1));
		assertTrue(md3.getElement(1, 2) == md1.getElement(2, 3));
	}
	
	
	/**
	 * [OJ-MAT-TC-028] minor(Matrix(Complex), i, j)
	 */
	@Test
	public void ojMatTest028() {
		mc3 = mc1.minor(1, 2);
		System.out.println("[OJ-MAT-TC-028] minor(Matrix(Complex), i, j)");
		System.out.println("minor(" + mc1 + ", 1, 2) = \n" + mc3);
		
		assertTrue(mc3.getElement(0, 0) == mc1.getElement(0, 0));
		assertTrue(mc3.getElement(0, 1) == mc1.getElement(0, 1));
		assertTrue(mc3.getElement(0, 2) == mc1.getElement(0, 3));
		
		assertTrue(mc3.getElement(1, 0) == mc1.getElement(2, 0));
		assertTrue(mc3.getElement(1, 1) == mc1.getElement(2, 1));
		assertTrue(mc3.getElement(1, 2) == mc1.getElement(2, 3));
	}
	/**
	 * [OJ-MAT-TC-029] det(Matrix(Double))
	 */
	@Test
	public void ojMatTest029() {
		Double[][] da = {{1.0, 2.0}, {5.0, 3.0}};
		Matrix mda = new Matrix(da);
		
		Double res = (Double)mda.det();
		System.out.println("[OJ-MAT-TC-029] det(Matrix(Double))");
		System.out.println("det(" + mda + ") = " + res);
		
		assertTrue(Math.abs(-7.0 - res.doubleValue()) < 0.0001);
	}
	
	
	
	
	/**
	 * [OJ-MAT-TC-030] det(Matrix(Complex))
	 */
	@Test
	public void ojMatTest030() {
		Complex[][] ca = {{new Complex(2.0, 4.0), new Complex(3.0, -2.0)},
						  {new Complex(-3.0, 1.0), new Complex(-6.0, -5.0)}};
		Matrix mca = new Matrix(ca);
		
		Complex res = (Complex)mca.det();
		System.out.println("[OJ-MAT-TC-030] det(Matrix(Complex))");
		System.out.println("det(" + mca + ") = " + res);
		
		assertTrue(Math.abs(15.0 - res.getRe()) < 0.0001);
		assertTrue(Math.abs(-43.0 - res.getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-031] det(Matrix(Double))
	 */
	@Test
	public void ojMatTest031() {
		Double[][] da = {{1.0, 2.0, 3.0}, {5.0, 3.0, 2.0}, {5.0, 7.0, 6.0}};
		Matrix mda = new Matrix(da);
		
		Double res = (Double)mda.det();
		System.out.println("[OJ-MAT-TC-031] det(Matrix(Double))");
		System.out.println("det(" + mda + ") = " + res);
		
		assertTrue(Math.abs(24.0 - res.doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-032] det(Matrix(Double))
	 */
	@Test
	public void ojMatTest032() {
		Double[][] da = {{1.0, 2.0, 3.0, 5.0, 7.0}, 
				         {5.0, 3.0, 2.0, -3.0, -5.0}, 
				         {5.0, 7.0, 6.0, 9.0, 1.0},
				         {-3.0, 3.0, 5.0, 9.0, 3.0},
				         {6.0, 7.0, 3.0, 9.0, 8.0}};
		Matrix mda = new Matrix(da);
		
		Double res = (Double)mda.det();
		System.out.println("[OJ-MAT-TC-032] det(Matrix(Double))");
		System.out.println("det(" + mda + ") = " + res);
		
		assertTrue(Math.abs(-2890.0 - res.doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-033] det(Matrix(Complex))
	 */
	@Test
	public void ojMatTest033() {
		Complex[][] ca = {{new Complex(1.0, 2.0), new Complex(-2.0, 3.0), new Complex(-1.0, -5.0)},
						  {new Complex(-3.0, 5.0), new Complex(-3.0, 9.0), new Complex(4.0, 3.0)},
					 	  {new Complex(3.0, -2.0), new Complex(-3.0, -4.0), new Complex(-7.0, 4.0)}};
		
		Matrix mca = new Matrix(ca);
		
		Complex res = (Complex)mca.det();
		System.out.println("[OJ-MAT-TC-033] det(Matrix(Complex))");
		System.out.println("det(" + mca + ") = " + res);
		/**
		 * -2.9300e+002 -1.8900e+002i
		 */
		assertTrue(Math.abs(-293.0 - res.getRe()) < 0.0001);
		assertTrue(Math.abs(-189.0 - res.getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-034] cofactor(Matrix(Double))
	 */
	@Test
	public void ojMatTest034() {
		Double[][] da = {{3.0, 1.0, -4.0}, {2.0, 5.0, 6.0}, {1.0, 4.0, 8.0}};
		
		Matrix mda = new Matrix(da);
		
		Double res = (Double)mda.cofactor(0, 0);
		System.out.println("[OJ-MAT-TC-034] cofactor(Matrix(Complex))");
		System.out.println("cofactor(" + mda + ", 0, 0) = " + res);
		/**
		 * 16
		 */
		assertTrue(Math.abs( 16.0- res.doubleValue()) < 0.0001);
		
		res = (Double)mda.cofactor(2, 1);
		System.out.println("cofactor(" + mda + ", 2, 1) = " + res);
		assertTrue(Math.abs( -26.0- res.doubleValue()) < 0.0001);
	}
	/**
	 * [OJ-MAT-TC-035] adj(Matrix(Double))
	 */
	@Test
	public void ojMatTest035() {
		Double[][] da = {{3.0, 2.0, -1.0}, {1.0, 6.0, 3.0}, {2.0, -4.0, 0.0}};
		
		Matrix mda = new Matrix(da);
		
		Matrix res = mda.adj();
		System.out.println("[OJ-MAT-TC-035] adj(Matrix(Double))");
		System.out.println("adj(" + mda + ") = " + res);
		
		assertTrue(Math.abs( 12.0- ((Double)res.getElement(0,0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 4.0- ((Double)res.getElement(0,1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 12.0- ((Double)res.getElement(0,2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 6.0- ((Double)res.getElement(1,0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 2.0- ((Double)res.getElement(1,1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( -10.0- ((Double)res.getElement(1,2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( -16.0- ((Double)res.getElement(2,0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 16.0- ((Double)res.getElement(2,1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 16.0- ((Double)res.getElement(2,2)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-036] inv(Matrix(Double))
	 */
	@Test
	public void ojMatTest036() {
		Double[][] da = {{3.0, 2.0, -1.0}, {1.0, 6.0, 3.0}, {2.0, -4.0, 0.0}};
		
		Matrix mda = new Matrix(da);
		
		Matrix res = mda.inv();
		System.out.println("[OJ-MAT-TC-036] inv(Matrix(Double))");
		System.out.println("inv(" + mda + ") = " + res);
		
		/**
		 * 0.1875    0.0625    0.1875
    	 * 0.0937    0.0313   -0.1563
   		 * -0.2500    0.2500    0.2500
		 */
		
		assertTrue(Math.abs( 0.1875 - ((Double)res.getElement(0,0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 0.0625- ((Double)res.getElement(0,1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 0.1875 - ((Double)res.getElement(0,2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 0.0937 - ((Double)res.getElement(1,0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 0.0313 - ((Double)res.getElement(1,1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( -0.1563 - ((Double)res.getElement(1,2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( -0.2500 - ((Double)res.getElement(2,0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 0.2500- ((Double)res.getElement(2,1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( 0.2500 - ((Double)res.getElement(2,2)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-037] inv(Matrix(Complex))
	 */
	@Test
	public void ojMatTest037() {
		Complex[][] ca = {{new Complex(1.0, 2.0), new Complex(-2.0, 3.0), new Complex(-1.0, -5.0)},
				  {new Complex(-3.0, 5.0), new Complex(-3.0, 9.0), new Complex(4.0, 3.0)},
			 	  {new Complex(3.0, -2.0), new Complex(-3.0, -4.0), new Complex(-7.0, 4.0)}};
		
		Matrix mca = new Matrix(ca);
		
		Matrix res = mca.inv();
		System.out.println("[OJ-MAT-TC-037] inv(Matrix(Complex))");
		System.out.println("inv(" + mca + ") = " + res);
		
		/**
		 * 0.1139 + 0.0972i  -0.0288 - 0.1452i   0.1567 - 0.1011i
  		 * -0.1156 - 0.0893i   0.0002 - 0.0103i  -0.0707 + 0.0490i
   		 * 0.0078 + 0.1179i  -0.0237 - 0.0632i  -0.0053 - 0.0717i
		 */
		
		assertTrue(Math.abs( 0.1139 - ((Complex)res.getElement(0,0)).getRe()) < 0.0001);
		assertTrue(Math.abs( 0.0972 - ((Complex)res.getElement(0,0)).getIm()) < 0.0001);
		assertTrue(Math.abs( -0.0288- ((Complex)res.getElement(0,1)).getRe()) < 0.0001);
		assertTrue(Math.abs( -0.1452 - ((Complex)res.getElement(0,1)).getIm()) < 0.0001);
		assertTrue(Math.abs( 0.1567 - ((Complex)res.getElement(0,2)).getRe()) < 0.0001);
		assertTrue(Math.abs( -0.1011 - ((Complex)res.getElement(0,2)).getIm()) < 0.0001);
		assertTrue(Math.abs( -0.1156 - ((Complex)res.getElement(1,0)).getRe()) < 0.0001);
		assertTrue(Math.abs( -0.0893 - ((Complex)res.getElement(1,0)).getIm()) < 0.0001);
		assertTrue(Math.abs( 0.0002 - ((Complex)res.getElement(1,1)).getRe()) < 0.0001);
		assertTrue(Math.abs( -0.0103 - ((Complex)res.getElement(1,1)).getIm()) < 0.0001);
		assertTrue(Math.abs( -0.0707 - ((Complex)res.getElement(1,2)).getRe()) < 0.0001);
		assertTrue(Math.abs( 0.0490 - ((Complex)res.getElement(1,2)).getIm()) < 0.0001);
		assertTrue(Math.abs( 0.0078 - ((Complex)res.getElement(2,0)).getRe()) < 0.0001);
		assertTrue(Math.abs( 0.1179 - ((Complex)res.getElement(2,0)).getIm()) < 0.0001);
		assertTrue(Math.abs( -0.0237- ((Complex)res.getElement(2,1)).getRe()) < 0.0001);
		assertTrue(Math.abs( -0.0632 - ((Complex)res.getElement(2,1)).getIm()) < 0.0001);
		assertTrue(Math.abs( -0.0053 - ((Complex)res.getElement(2,2)).getRe()) < 0.0001);
		assertTrue(Math.abs( -0.0717 - ((Complex)res.getElement(2,2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-MAT-TC-038] Orthogonal Test (Matrix(double))
	 */
	@Test
	public void ojMatTest038() {
		Double[][] aArray = {{3.0/7.0, 2.0/7.0, 6.0/7.0},
						     {-6.0/7.0, 3.0/7.0, 2.0/7.0},
						     {2.0/7.0, 6.0/7.0, -3.0/7.0}};
		
		Matrix a = new Matrix(aArray);
		boolean b = a.isOrthogonal();
		
		assertTrue(b);
	}
	
}


