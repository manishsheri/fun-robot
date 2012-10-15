package org.open_jasmine.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.open_jasmine.operators.Op;
import org.open_jasmine.types.Matrix;
import org.open_jasmine.types.VectoR;

public class OpTest {

	@Test
	public void testPlusComplexComplex() {
	}

	@Test
	public void testPlusComplexDouble() {
	}

	@Test
	public void testPlusDoubleComplex() {
	}

	@Test
	public void testPlusDoubleDouble() {
	}

	@Test
	public void testMinusComplexComplex() {
	}

	@Test
	public void testMinusComplexDouble() {
	}

	@Test
	public void testMinusDoubleComplex() {
	}

	@Test
	public void testMinusDoubleDouble() {
	}

	@Test
	public void testTimesComplexComplex() {
	}

	@Test
	public void testTimesComplexDouble() {
	}

	@Test
	public void testTimesDoubleComplex() {
	}

	@Test
	public void testDivideComplexComplex() {
	}

	@Test
	public void testDivideComplexDouble() {
	}

	@Test
	public void testDivideDoubleComplex() {
	}

	@Test
	public void testDivideDoubleDouble() {
	}

	@Test
	public void testPlusVectoRVectoR() {
	}

	@Test
	public void testPlusVectoRDoubleArray() {
	}

	@Test
	public void testPlusDoubleArrayVectoR() {
	}

	@Test
	public void testPlusDoubleArrayDoubleArray() {

	}

	@Test
	public void testMinusVectoRVectoR() {

	}

	@Test
	public void testMinusVectoRDoubleArray() {

	}

	@Test
	public void testMinusDoubleArrayVectoR() {

	}

	@Test
	public void testMinusDoubleArrayDoubleArray() {

	}

	@Test
	public void testDotVectoRVectoR() {
	}

	@Test
	public void testDotVectoRDoubleArray() {
	}

	@Test
	public void testDotDoubleArrayVectoR() {
	}

	@Test
	public void testDotDoubleArrayDoubleArray() {
	}

	@Test
	public void testCrossVectoRVectoR() {
	}

	@Test
	public void testCrossVectoRDoubleArray() {
	}

	@Test
	public void testCrossDoubleArrayVectoR() {
	}

	@Test
	public void testCrossDoubleArrayDoubleArray() {
	}

	@Test
	public void testTimesVectoRDouble() {
	}

	@Test
	public void testTimesDoubleVectoR() {
	}

	@Test
	public void testTimesVectoRVectoR() {
	}

	@Test
	public void testTimesVectoRDoubleArray() {
	}

	@Test
	public void testTimesDoubleArrayVectoR() {
	}

	@Test
	public void testTimesDoubleArrayDoubleArray() {
	}

	@Test
	public void testTimesDoubleDouble() {
	}

	@Test
	public void testAbsDouble() {
	}

	@Test
	public void testAbsComplex() {
	}

	@Test
	public void testConj() {
	}

	@Test
	public void testTimesDoubleArrayDouble() {
	}

	@Test
	public void testTimesDoubleDoubleArray() {
	}

	@Test
	public void testComplexToPolar() {
	}

	@Test
	public void testPolarToComplex() {
	}

	@Test
	public void testPlusMatrixMatrix() {
	}

	@Test
	public void testMinusMatrixMatrix() {
	}

	@Test
	public void testTimesMatrixVectoR() {
		double[][] d = {{0.866, -0.5, 0.0}, {0.5, 0.866, 0.0}, {0.0, 0.0, 1.0}};
		double[] varray = {0.0, 2.0, 0.0};
		Matrix m = new Matrix(d);
		VectoR v = new VectoR(varray);
		
		VectoR res = Op.times(m, v);
		
		System.out.println(m + " * " + v + " = " + res);
	}

	@Test
	public void testDeg2rad() {
	}

	@Test
	public void testRad2deg() {
	}

}
