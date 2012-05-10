package org.openjasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.geometry.GeoOp;
import org.openjasmine.geometry.RefTran;
import org.openjasmine.types.Complex;
import org.openjasmine.types.VectoR;

public class VectorTest {
	VectoR v1, v2, v3, v4, v5;
	VectoR vv1, vv2, vv3, vv4;
	VectoR vvv1, vvv2;
	double df;
	Double dr;
	Complex cf;
	Complex cr;
	Complex cc1;
	
	@Before
	public void setUp() throws Exception {
		Double[] d1 = {3.0, -2.0, 5.0, -7.0};
		Double[] d2 = {-2.0, -6.0, 7.0, 4.0};
		Double[] d3 = {0.2, -3.2, 4.3};		// for cross product
		Double[] d4 = {3.7, 1.9, -2.3};		// for cross product
		Double[] d5 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};	// for get sub-vector;
		Double[] re1 = {2.0, 3.0, -2.0, -6.0};	// for set complex vector
		Double[] im1 = {7.0, -5.0, 4.0, -8.0};  // for set complex vector
		
		df = 3.4;
		cf = new Complex(2.0, 3.2);
		
		/** 
		 * three methods of set complex array
		 */
		Complex[] c1 = new Complex[4];					
		
		Complex[] c2 = {Complex.setComplex(3.0, 2.0), 
						Complex.setComplex(5.0, -2.0),
						Complex.setComplex(-6.0, 4.0),
						Complex.setComplex(-2.0, -8.0)};
		
		Complex[] c3 = {Complex.setComplex(1.4, 2.7),
						Complex.setComplex(-2.3, 3.9),
						Complex.setComplex(0.8, -1.2)};

		Complex[] c4 = {Complex.setComplex(3.5, -3.4),
						Complex.setComplex(1.8, 5.9),
						Complex.setComplex(9.2, -3.3)};
		
		Complex[] c5 = {Complex.setComplex(2.0, 3.4),
						Complex.setComplex(3.5, 9.3),
						Complex.setComplex(-2.3, 3.4),
						Complex.setComplex(-0.3, 0.3),
						Complex.setComplex(-2.4, 4.4),
						Complex.setComplex(3.4, 3.2)};
		
		cc1 = new Complex(2.3, 3.2);
		for(int i = 0 ; i < 4 ; i++) {
			c1[i] = new Complex(re1[i], im1[i]);
		}
		
		v1 = new VectoR(d1);
		v2 = new VectoR(d2);
		v3 = new VectoR(c1);
		v4 = new VectoR(c2);
		
		vv1 = new VectoR(d3);
		vv2 = new VectoR(d4);
		vv3 = new VectoR(c3);
		vv4 = new VectoR(c4);
		
		vvv1 = new VectoR(d5);
		vvv2 = new VectoR(c5);
		
		System.out.print("v1  \t\t= " + v1 + "\n");
		System.out.print("v2  \t\t= " + v2 + "\n");
		System.out.print("v3  \t\t= " + v3 + "\n");
		System.out.print("v4  \t\t= " + v4 + "\n");
		System.out.print("vv1 \t\t= " + vv1 + "\n");
		System.out.print("vv2 \t\t= " + vv2 + "\n");
		System.out.print("vv3 \t\t= " + vv3 + "\n");
		System.out.print("vv4 \t\t= " + vv4 + "\n");
		System.out.print("vvv1 \t\t= " + vvv1 + "\n");
		System.out.print("vvv2 \t\t= " + vvv2 + "\n");
	}
	
	/**
	 * [OJ-VEC-TC-001] vector<double> + vector<double>
	 */
	@Test
	public void ojVecTest001() {
		v5 = (VectoR) v1.plus(v2);
		System.out.println("[OJ-VEC-TC-001] vector<dobule> + vector<double>");
		System.out.println("v1 + v2 \t= " + v5);
		
		assertTrue(Math.abs(1.0 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-8.0 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(12.0 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-3.0 - ((Double)v5.getElement(3)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-002] vector<dobule> + vector<Complex>
	 */
	@Test 
	public void ojVecTest002() {
		v5 = (VectoR) v1.plus(v3);
		
		System.out.println("[OJ-VEC-TC-002] vector<dobule> + vector<Complex>");
		System.out.println("v1 + v3 \t= " + v5);
		
		assertTrue(Math.abs(5.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(7.0 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(1.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(3.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(4.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-13.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-8.0 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-003] vector<Complex> + vector<double>
	 */
	@Test
	public void ojVecTest003() {
		v5 = (VectoR) v3.plus(v1);
		
		System.out.println("[OJ-VEC-TC-003] vector<Complex> + vector<double>");
		System.out.println("v3 + v1 \t= " + v5);
		
		assertTrue(Math.abs(5.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(7.0 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(1.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(3.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(4.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-13.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-8.0 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-004] vector<Complex> + vector<Complex>
	 */
	@Test
	public void ojVecTest004() {
		v5 = (VectoR) v3.plus(v4);
		
		System.out.println("[OJ-VEC-TC-004] vector<Complex> + vector<Complex>");
		System.out.println("v3 + v4 \t= " + v5);
		
		assertTrue(Math.abs(5.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(9.0 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(8.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-7.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-8.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(8.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-8.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-16.0 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-005] vector<double> - vector<double>
	 */
	@Test
	public void ojVecTest005() {
		v5 = (VectoR) v1.minus(v2);
		
		System.out.println("[OJ-VEC-TC-005] vector<double> - vector<double>");
		System.out.println("v1 - v2 \t= " + v5);
		
		assertTrue(Math.abs(5.0 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(4.0 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-2.0 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-11.0 - ((Double)v5.getElement(3)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-006] vector<double> - vector<Complex>
	 */
	@Test
	public void ojVecTest006() {
		v5 = (VectoR) v1.minus(v3);
		
		System.out.println("[OJ-VEC-TC-006] vector<double> - vector<Complex>");
		System.out.println("v1 - v3 \t= " + v5);
		
		assertTrue(Math.abs(1.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-7.0 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-5.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(5.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(7.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-4.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-1.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(8.0 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-007] vector<Complex> - vector<double>
	 */
	@Test
	public void ojVecTest007() {
		v5 = (VectoR) v3.minus(v1);
		System.out.println("[OJ-VEC-TC-007] vector<Complex> - vector<double>");
		System.out.println("v3 - v1 \t= " + v5);
		
		assertTrue(Math.abs(-1.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs( 7.0 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs( 5.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-5.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-7.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs( 4.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs( 1.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-8.0 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-008] vector<Complex> - vector<Complex>
	 */
	@Test
	public void ojVecTest008() {
		v5 = (VectoR) v3.minus(v4);
		System.out.println("[OJ-VEC-TC-008] vector<Complex> - vector<Complex>");
		System.out.println("v3 - v4 \t= " + v5);
		
		assertTrue(Math.abs(-1.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(5.0 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-2.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-3.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(4.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-4.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.0 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-009] vector<double>.* vector<double>
	 */
	@Test
	public void ojVecTest009() {
		v5 = (VectoR) v1.times(v2);
		System.out.println("[OJ-VEC-TC-009] vector<double>.* vector<double>");
		System.out.println("v1 * v2 \t= " + v5);
		
		assertTrue(Math.abs(-6.0 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(12.0 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(35.0 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-28.0 - ((Double)v5.getElement(3)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-010] vector<double>.* vector<Complex>
	 */
	@Test
	public void ojVecTest010() {
		v5 = (VectoR) v1.times(v3);
		System.out.println("[OJ-VEC-TC-010] vector<double>.* vector<Complex>");
		System.out.println("v1 * v3 \t= " + v5);
		
		assertTrue(Math.abs(6.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(21.0 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-6.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(10.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-10.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(20.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(42.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(56.0 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-011] vector<Complex>.* vector<double>
	 */
	@Test
	public void ojVecTest011() {
		v5 = (VectoR) v3.times(v1);
		System.out.println("[OJ-VEC-TC-011] vector<Complex>.* vector<double>");
		System.out.println("v3 * v1 \t= " + v5);
		
		assertTrue(Math.abs(6.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(21.0 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-6.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(10.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-10.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(20.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(42.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(56.0 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-012] vector<Complex>.* vector<Complex>
	 */
	@Test
	public void ojVecTest012() {
		v5 = (VectoR) v3.times(v4);
		System.out.println("[OJ-VEC-TC-012] vector<Complex>.* vector<Complex>");
		System.out.println("v3 * v4 \t= " + v5);
		
		assertTrue(Math.abs(-8.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(25.0 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(5.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-31.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-4.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-32.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-52.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(64.0 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-013] vector<double> * double
	 */
	@Test
	public void ojVecTest013() {
		v5 = (VectoR) v1.times(df);
		System.out.println("[OJ-VEC-TC-013] vector<double> * double");
		System.out.println(v1 + " * " + df + " = " + v5);
		
		assertTrue(Math.abs(10.2 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-6.8 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(17.0 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-23.8 - ((Double)v5.getElement(3)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-014] vector<double> * Complex
	 */
	@Test
	public void ojVecTest014() {
		v5 = (VectoR) v1.times(cf);
		System.out.println("[OJ-VEC-TC-014] vector<double> * Complex");
		System.out.println(v1 + " * " + cf + " = " + v5);
		
		assertTrue(Math.abs(6.0 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(9.6 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-4.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-6.4 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(10.0 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(16.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-14.0 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-22.4 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-015] vector<Complex> * double
	 */
	@Test
	public void ojVecTest015() {
		v5 = (VectoR) v3.times(df);
		System.out.println("[OJ-VEC-TC-015] vector<Complex> * double");
		System.out.println(v3 + " * " + df + " = " + v5);
		
		assertTrue(Math.abs(6.8 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(23.8 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(10.2 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-17.0 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-6.8 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(13.6 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-20.4 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-27.2 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-016] vector<Complex> * Complex
	 */
	@Test
	public void ojVecTest016() {
		v5 = (VectoR) v3.times(cf);
		System.out.println("[OJ-VEC-TC-016] vector<Complex> * Complex");
		System.out.println(v3 + " * " + cf + " = " + v5);
		
		assertTrue(Math.abs(-18.4 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(20.4 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(22.0 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.4 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-16.8 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.6 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(13.6 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-35.2 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-017] vector<double>./ vector<double>
	 */
	@Test
	public void ojVecTest017() {
		v5 = (VectoR) v1.div(v2);
		System.out.println("[OJ-VEC-TC-017] vector<double>./ vector<double>");
		System.out.println("v1 / v2 \t= " + v5);
		
		assertTrue(Math.abs(-1.5 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.33333 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(0.7143 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-1.7500 - ((Double)v5.getElement(3)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-018] vector<double>./ vector<Complex>
	 */
	@Test
	public void ojVecTest018() {
		v5 = (VectoR) v1.div(v3);
		System.out.println("[OJ-VEC-TC-018] vector<double>./ vector<Complex>");
		System.out.println("v1 / v3 \t= " + v5);
		
		assertTrue(Math.abs(0.1132 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.3962 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-0.1765 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.2941 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-0.5000 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.0000 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(0.4200 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.5600 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-019] vector<Complex>./ vector<double>
	 */
	@Test
	public void ojVecTest019() {
		v5 = (VectoR) v3.div(v1);
		System.out.println("[OJ-VEC-TC-019] vector<Complex>./ vector<double>");
		System.out.println("v3 / v1 \t= " + v5);
		
		assertTrue(Math.abs(0.6667 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.3333 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-1.5000 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.5000 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-0.4000 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.8000 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(0.8571 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.1429 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-020] vector<Complex>./ vector<Complex>
	 */
	@Test
	public void ojVecTest020() {
		v5 = (VectoR) v3.div(v4);
		System.out.println("[OJ-VEC-TC-020] vector<Complex>./ vector<Complex>");
		System.out.println("v3 / v4 \t= " + v5);
		
		assertTrue(Math.abs(1.5385 - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.3077 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(0.8621 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.6552 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(0.5385 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.3077 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(1.1176 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.4706 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-021] vector<double>./double
	 */
	@Test
	public void ojVecTest021() {
		v5 = (VectoR) v1.div(df);
		System.out.println("[OJ-VEC-TC-021] vector<double>./double");
		System.out.println("v1 / df \t= " + v5);
		
		assertTrue(Math.abs(0.8824 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-0.5882 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(1.4706 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs( -2.0588 - ((Double)v5.getElement(3)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-022] vector<double>./ Complex
	 */
	@Test
	public void ojVecTest022() {
		v5 = (VectoR) v1.div(cf);
		System.out.println("[OJ-VEC-TC-022] vector<double>./ Complex");
		System.out.println("v1 / cf \t= " + v5);
		
		assertTrue(Math.abs(0.4213  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-0.6742 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-0.2809 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.4494 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(0.7022 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.1236 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-0.9831 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.5730 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-023] vector<Complex>./ double
	 */
	@Test
	public void ojVecTest023() {
		v5 = (VectoR) v3.div(df);
		System.out.println("[OJ-VEC-TC-023] vector<Complex>./ double");
		System.out.println("v3 / df \t= " + v5);
		
		assertTrue(Math.abs(0.5882  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.0588 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(0.8824 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.4706 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-0.5882 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.1765 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-1.7647 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-2.3529 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-024] vector<Complex>./ Complex
	 */
	@Test
	public void ojVecTest024() {
		v5 = (VectoR) v3.div(cf);
		System.out.println("[OJ-VEC-TC-024] vector<Complex>./ Complex");
		System.out.println("v3 / cf \t= " + v5);
		
		assertTrue(Math.abs(1.8539  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.5337 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-0.7022 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(- 1.3764 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(0.6180 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(1.0112 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-2.6404 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.2247 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-025] dot(vector<Double>, vector<Double>
	 */
	@Test
	public void ojVecTest025() {
		dr = (Double)v1.dot(v2);
		System.out.println("[OJ-VEC-TC-025] dot(vector<Double>, vector<Double>");
		System.out.println("dot(v1, v2) = " + dr);
		
		assertTrue(Math.abs(13.0 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-026] dot(vector<Double>, vector<Complex>
	 */
	@Test
	public void ojVecTest026() {
		cr = (Complex)v1.dot(v3);
		System.out.println("[OJ-VEC-TC-026] dot(vector<Double>, vector<Complex>");
		System.out.println("dot(v3, v1) = " + cr);
		
		assertTrue(Math.abs(32.0 - cr.getRe()) < 0.0001);
		assertTrue(Math.abs(107.0 - cr.getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-027] dot(vector<Complex>, vector<Double>
	 */
	@Test
	public void ojVecTest027() {
		cr = (Complex)v3.dot(v1);
		System.out.println("[OJ-VEC-TC-027] dot(vector<Complex>, vector<Double>");
		System.out.println("dot(v1, v3) = " + cr);
		assertTrue(Math.abs(32.0 - cr.getRe()) < 0.0001);
		assertTrue(Math.abs(-107.0 - cr.getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-028] dot(vector<Complex>, vector<Complex>
	 */
	@Test
	public void ojVecTest028() {
		cr = (Complex)v3.dot(v4);
		System.out.println("[OJ-VEC-TC-028] dot(vector<Complex>, vector<Complex> - 1");
		System.out.println("dot(v3, v4) = " + cr);
		
		assertTrue(Math.abs(149.0 - cr.getRe()) < 0.0001);
		assertTrue(Math.abs(50.0 - cr.getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-029] dot(vector<Complex>, vector<Complex> - 2
	 */
	@Test
	public void ojVecTest029() {
		cr = (Complex)v4.dot(v3);
		System.out.println("[OJ-VEC-TC-029] dot(vector<Complex>, vector<Complex> - 2");
		System.out.println("dot(v4, v3) = " + cr);
		
		assertTrue(Math.abs(149.0 - cr.getRe()) < 0.0001);
		assertTrue(Math.abs(-50.0 - cr.getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-030] norm(vector<Double>, 0)
	 */
	@Test
	public void ojVecTest030() {
		dr = (Double)v1.norm(0.0);
		System.out.println("[OJ-VEC-TC-030] norm(vector<Double>, 0)");
		System.out.println("norm(v1, 0) = " + dr);
		
		assertTrue(Double.isInfinite(dr));
	}
	
	/**
	 * [OJ-VEC-TC-031] norm(vector<Double>, 1)
	 */
	@Test
	public void ojVecTest031() {
		dr = (Double)v1.norm(1.0);
		System.out.println("[OJ-VEC-TC-031] norm(vector<Double>, 1)");
		System.out.println("norm(v1, 1) = " + dr);
		
		assertTrue(Math.abs(17.0 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-032] norm(vector<Double>, 2)
	 */
	@Test
	public void ojVecTest032() {
		dr = (Double)v1.norm(2.0);
		System.out.println("[OJ-VEC-TC-032] norm(vector<Double>, 2)");
		System.out.println("norm(v1, 2) = " + dr);
		
		assertTrue(Math.abs(9.3274 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-033] norm(vector<Double>, 364)
	 */
	@Test
	public void ojVecTest033() {
		dr = (Double)v1.norm(364.0); // maximum power value
		System.out.println("[OJ-VEC-TC-033] norm(vector<Double>, 364)");
		System.out.println("norm(v1, 364) = " + dr);
		
		assertTrue(Math.abs(7.0 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-034] norm(vector<Double>, 364) - wrong result
	 */
	@Test
	public void ojVecTest034() {
		dr = (Double)v1.norm(365.0);	// wrong result
		System.out.println("[OJ-VEC-TC-034] norm(vector<Double>, 364) - wrong result");
		System.out.println("norm(v1, 365) = " + dr);
	}
	
	/**
	 * [OJ-VEC-TC-035] norm(vector<Double>, -INF)
	 */
	@Test
	public void ojVecTest035() {
		dr = (Double)v1.norm(Double.NEGATIVE_INFINITY);
		System.out.println("[OJ-VEC-TC-035] norm(vector<Double>, -INF)");
		System.out.println("norm(v1, -inf) = " + dr);
		
		assertTrue(Math.abs(2.0 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-036] norm(vector<Double>, INF)
	 */
	@Test
	public void ojVecTest036() {
		dr = (Double)v1.norm(Double.POSITIVE_INFINITY);
		System.out.println("[OJ-VEC-TC-036] norm(vector<Double>, INF)");
		System.out.println("norm(v1, inf) = " + dr);
		
		assertTrue(Math.abs(7.0 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-037] norm(vector<Complex>, 0)
	 */
	@Test
	public void ojVecTest037() {
		dr = (Double)v3.norm(0.0);
		System.out.println("[OJ-VEC-TC-037] norm(vector<Complex>, 0)");
		System.out.println("norm(v3, 0) = " + dr);
		
		assertTrue(Double.isInfinite(dr));
	}
	
	/**
	 * [OJ-VEC-TC-038] norm(vector<Complex>, 1)
	 */
	@Test
	public void ojVecTest038() {
		dr = (Double)v3.norm(1.0);
		System.out.println("[OJ-VEC-TC-038] norm(vector<Complex>, 1)");
		System.out.println("norm(v3, 1) = " + dr);
		
		assertTrue(Math.abs(27.5832 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-039] norm(vector<Complex>, 2)
	 */
	@Test
	public void ojVecTest039() {
		dr = (Double)v3.norm(2.0);
		System.out.println("[OJ-VEC-TC-039] norm(vector<Complex>, 2)");
		System.out.println("norm(v3, 2) = " + dr);
		
		assertTrue(Math.abs(14.3875 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-040] norm(vector<Complex>, 308)
	 */
	@Test
	public void ojVecTest040() {
		dr = (Double)v3.norm(308.0); // maximum power value
		System.out.println("[OJ-VEC-TC-040] norm(vector<Complex>, 308)");
		System.out.println("norm(v3, 308) = " + dr);
		
		assertTrue(Math.abs(10.0 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-041] norm(vector<Complex>, 308) - wrong result
	 */
	@Test
	public void ojVecTest041() {
		dr = (Double)v3.norm(309.0);	// wrong result
		System.out.println("[OJ-VEC-TC-041] norm(vector<Complex>, 308) - wrong result");
		System.out.println("norm(v3, 309) = " + dr);
	}
	
	/**
	 * [OJ-VEC-TC-042] norm(vector<Complex>,  -inf)
	 */
	@Test
	public void ojVecTest042() {
		dr = (Double)v3.norm(Double.NEGATIVE_INFINITY);
		System.out.println("[OJ-VEC-TC-042] norm(vector<Complex>,  -inf)");
		System.out.println("norm(v3, -inf) = " + dr);
		
		assertTrue(Math.abs(4.4721 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-043] norm(vector<Complex>,  inf)
	 */
	@Test
	public void ojVecTest043() {
		dr = (Double)v3.norm(Double.POSITIVE_INFINITY);
		System.out.println("[OJ-VEC-TC-043] norm(vector<Complex>,  inf)");
		System.out.println("norm(v3, inf) = " + dr);
		
		assertTrue(Math.abs(10.0 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-044] norm(vector<double>)
	 */
	@Test
	public void ojVecTest044() {
		dr = v2.norm();
		System.out.println("[OJ-VEC-TC-044] norm(vector<double>)");
		System.out.println("norm(v2) = " + dr);
		
		assertTrue(Math.abs(10.2470 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-045] norm(vector<Complex>)
	 */
	@Test
	public void ojVecTest045() {
		dr = v4.norm();
		System.out.println("[OJ-VEC-TC-045] norm(vector<Complex>)");
		System.out.println("norm(v4) = " + dr);
		
		assertTrue(Math.abs( 12.7279 - dr) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-046] cross(vector<double>, vector<double>) - 1
	 */
	@Test
	public void ojVecTest046() {
		v5 = vv1.cross(vv2);
		System.out.println("[OJ-VEC-TC-046] cross(vector<double>, vector<double>) - 1");
		System.out.println("cross(vv1, vv2) = " + v5);
		
		assertTrue(Math.abs(-0.81 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(16.37 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(12.2200 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-047] cross(vector<double>, vector<double>) - 2
	 */
	@Test
	public void ojVecTest047() {
		v5 = vv2.cross(vv1);
		System.out.println("[OJ-VEC-TC-047] cross(vector<double>, vector<double>) - 2");
		System.out.println("cross(v1, v2) = " + v5);
		
		assertTrue(Math.abs(0.81 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-16.37 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-12.2200 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-048] cross(vector<Complex>, vector<double>) 
	 */
	@Test
	public void ojVecTest048() {
		v5 = vv3.cross(vv1);
		System.out.println("[OJ-VEC-TC-048] cross(vector<Complex>, vector<double>)");
		System.out.println("cross(vv3, vv1) " + v5);
		
		assertTrue(Math.abs(-7.3300  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(12.9300 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs( -5.8600 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-11.8500 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-4.0200 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-9.4200 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-049] cross(vector<Double>, vector<Complex>) 
	 */
	@Test
	public void ojVecTest049() {
		v5 = vv1.cross(vv3);
		System.out.println("[OJ-VEC-TC-049] cross(vector<Double>, vector<Complex>)");
		System.out.println("cross(vv1, vv3) " + v5);
		
		assertTrue(Math.abs(7.3300  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(-12.9300 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(5.8600 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(11.8500 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(4.0200 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(9.4200 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-050] cross(vector<Complex>, vector<Complex>) 
	 */
	@Test
	public void ojVecTest050() {
		v5 = vv3.cross(vv4);
		System.out.println("[OJ-VEC-TC-050] cross(vector<Complex>, vector<Complex>)");
		System.out.println("cross(v3, v4) = " + v5);
		
		assertTrue(Math.abs(-16.8100  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(40.9100 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-23.0700 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-27.1400 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-18.6200 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(-8.3500 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-051] get SubVector<double>
	 */
	@Test
	public void ojVecTest051() {
		v5 = vvv1.getSubVector(2, 4);
		System.out.println("[OJ-VEC-TC-051] get SubVector<double>");
		System.out.println("sub vector of vvv1 from 2 to 4 " + v2);
		
		assertTrue(Math.abs(3.0 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(4.0 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(5.0 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-052] get SubVector<Complex>
	 */
	@Test
	public void ojVecTest052() {
		v5 = vvv2.getSubVector(2, 4);
		System.out.println("[OJ-VEC-TC-052] get SubVector<Complex>");
		System.out.println("sub vector of v1 from 2 to 4 " + v2);
		
		assertTrue(Math.abs(-2.3  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(3.4 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-0.3 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(0.3 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-2.4 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(4.4 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-053] Vector<double> * double
	 */
	@Test
	public void ojVecTest053() {
		v5 = (VectoR)v1.times(2.3);
		System.out.println("[OJ-VEC-TC-053] Vector<double> * double");
		System.out.println("v1 * 2.3 = " + v5);
		
		assertTrue(Math.abs(6.9 - ((Double)v5.getElement(0)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-4.6 - ((Double)v5.getElement(1)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(11.5 - ((Double)v5.getElement(2)).doubleValue()) < 0.0001);
		assertTrue(Math.abs(-16.1 - ((Double)v5.getElement(3)).doubleValue()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-054] Vector<Complex> * double
	 */
	@Test
	public void ojVecTest054() {
		v5 = (VectoR)v3.times(2.3);
		System.out.println("[OJ-VEC-TC-054] Vector<Complex> * double");
		System.out.println("v3 * 2.3 = " + v5);
		
		assertTrue(Math.abs(4.6  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(16.1 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(6.9 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-11.5 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-4.6 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(9.2 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-13.8 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-18.4 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-055] Vector<double> * Complex
	 */
	@Test
	public void ojVecTest055() {
		v5 = (VectoR)v1.times(cc1);
		System.out.println("[OJ-VEC-TC-055] Vector<double> * Complex");
		System.out.println("v1 * (2.3 + 3.2i) = " + v5);
		
		assertTrue(Math.abs(6.9  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(9.6 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-4.6 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-6.4 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(11.5 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(16.0 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-16.1 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-22.4 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-056] Vector<Complex> * Complex
	 */
	@Test
	public void ojVecTest056() {
		v5 = (VectoR)v3.times(Complex.setComplex(2.3, 3.2));
		System.out.println("[OJ-VEC-TC-056] Vector<Complex> * Complex");
		System.out.println(v2 + " * (2.3 + 3.2i) = " + v4);
		
		assertTrue(Math.abs(-17.8000  - ((Complex)v5.getElement(0)).getRe()) < 0.0001);
		assertTrue(Math.abs(22.5 - ((Complex)v5.getElement(0)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(22.9000 - ((Complex)v5.getElement(1)).getRe()) < 0.0001);
		assertTrue(Math.abs(-1.9 - ((Complex)v5.getElement(1)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(-17.4000 - ((Complex)v5.getElement(2)).getRe()) < 0.0001);
		assertTrue(Math.abs(2.8 - ((Complex)v5.getElement(2)).getIm()) < 0.0001);
		
		assertTrue(Math.abs(11.8000 - ((Complex)v5.getElement(3)).getRe()) < 0.0001);
		assertTrue(Math.abs(-37.6 - ((Complex)v5.getElement(3)).getIm()) < 0.0001);
	}
	
	/**
	 * [OJ-VEC-TC-057] Vector<Complex> * Complex
	 */
	@Test
	public void ojVecTest057() {
		// FIXME
		try {
			v5 = (VectoR)v1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[OJ-VEC-TC-057] Vector<Complex> * Complex");
		System.out.println("Clone : ");
		System.out.println("v1 = " + v1);
		System.out.println("v5 = " + v5);
		assertTrue(v5.getSize() == v1.getSize());
		assertTrue(v5.getElement(0) == v1.getElement(0));
		assertTrue(v5.getElement(1) == v1.getElement(1));
		assertTrue(v5.getElement(2) == v1.getElement(2));
		assertTrue(v5.getElement(3) == v1.getElement(3));
		
		v1.setElement(0, 2.0);
		v1.setElement(0, 3.0);
		v1.setElement(0, 4.0);
		v1.setElement(0, 5.0);
		
		System.out.println("v1 = " + v1);
		System.out.println("v5 = " + v5); // 아직 문제 있음
	}
	
	/**
	 * [OJ-VEC-TC-058] proj(Vector<double>)
	 */
	@Test
	public void ojVecTest058() {
		Double[] vaArray = {2.0, -1.0, 3.0};
		Double[] vbArray = {4.0, -1.0, 2.0};
		VectoR vp = new VectoR(vaArray);
		VectoR vq = new VectoR(vbArray);
		
		VectoR res = vq.proj(vp);
		System.out.println("[OJ-VEC-TC-058] proj(Vector<double>)");
		
		System.out.println(res);

	}
	
	/**
	 * [OJ-VEC-TC-059] perp(Vector<double>)
	 */
	@Test
	public void ojVecTest059() {
		Double[] vaArray =  {2.0, -1.0, 3.0};
		Double[] vbArray = {4.0, -1.0, 2.0};
		VectoR vp = new VectoR(vaArray);
		VectoR vq = new VectoR(vbArray);
		
		VectoR res = vq.perp(vp);
		System.out.println("[OJ-VEC-TC-059] perp(Vector<double>)");
		System.out.println(res);

	}
	
	/**
	 * [OJ-VEC-TC-060] getIncludeAngle(Vector<double>)
	 */
	@Test
	public void ojVecTest060() {
		Double[] uArray = {2.0, -1.0, 1.0};
		Double[] vArray = {1.0, 1.0, 2.0};
		VectoR u = new VectoR(uArray);
		VectoR v = new VectoR(vArray);
		
		double angle = u.getIncludeAngle(v);
		double vnorm = v.norm();
		double unorm = u.norm();
		double rootsix = Math.sqrt(6.0);
		System.out.println("[OJ-VEC-TC-060] getIncludeAngle(Vector<double>)");
		System.out.println("norm(u) = " + unorm);
		System.out.println("norm(v) = " + vnorm);
		System.out.println("root six = " + rootsix);
		System.out.println("u dot.v = " + (Double)u.dot(v));
		System.out.println("angle = " + angle + " rad");
		System.out.println("angle = " + GeoOp.r2d(angle) + " degree");
	}
	
}
