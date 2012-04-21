/**
 * 
 */
package org.open_jasmin.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.open_jasmin.operators.Op;
import org.open_jasmin.types.VectoR;

/**
 * @author elecage@gmail.com
 *
 */
public class VectoROperationTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		VectoR v1, v2, v3;
		double d1 = 7.0;
		double d2 = -4.0;
		double d3;
		
		double[] va1 = {2.0, 7.0, 3.0};
		double[] va2 = {-4.0, 3.0, -1.0};
		
		v1 = new VectoR(va1);
		v2 = new VectoR(va2);
		
		/**
		 * [JASMIN-TC-VECTOR-001] VectoR + VectoR
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [-2.0   10.0   2.0]
		 */
		v3 = Op.plus(v1, v2);
		
		assertTrue(-2.0 == v3.getElement(0));
		assertTrue(10.0 == v3.getElement(1));
		assertTrue(2.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-001] " + v1 + " + " + v2 + " = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-002] VectoR + double[]
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : va2 - double[]: {-4.0,   3.0,  -1.0}
		 * expected out : v3 - VectoR: [-2.0   10.0   2.0]
		 */
		v3 = Op.plus(v1, va2);
		
		assertTrue(-2.0 == v3.getElement(0));
		assertTrue(10.0 == v3.getElement(1));
		assertTrue(2.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-002] " + v1 + " + {" + va2[0] + ",\t" + va2[1] + ",\t" + va2[2] + "} = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-003] double[] + VectoR
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [-2.0   10.0   2.0]
		 */
		v3 = Op.plus(va1, v2);
		
		assertTrue(-2.0 == v3.getElement(0));
		assertTrue(10.0 == v3.getElement(1));
		assertTrue(2.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-003] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} + " + v2 + " = " + v3);

		/**
		 * [JASMIN-TC-VECTOR-004] double[] + double[]
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : va2 - double[]: {-4.0,   3.0,  -1.0}
		 * expected out : v3 - VectoR: [-2.0   10.0   2.0]
		 */
		v3 = Op.plus(va1, va2);
		
		assertTrue(-2.0 == v3.getElement(0));
		assertTrue(10.0 == v3.getElement(1));
		assertTrue(2.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-004] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} + {" + va2[0] + ",\t" + va2[1] + ",\t" + va2[2] + "} = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-005] VectoR - VectoR
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [6.0   4.0   4.0]
		 */
		v3 = Op.minus(v1, v2);
		
		assertTrue(6.0 == v3.getElement(0));
		assertTrue(4.0 == v3.getElement(1));
		assertTrue(4.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-005] {" + v1 + " - " + v2 + " = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-006] VectoR - double[]
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : va2 - VectoR: {-4.0,   3.0,  -1.0}
		 * expected out : v3 - VectoR: [6.0   4.0   4.0]
		 */
		v3 = Op.minus(v1, va2);
		
		assertTrue(6.0 == v3.getElement(0));
		assertTrue(4.0 == v3.getElement(1));
		assertTrue(4.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-006] " + v1 + " - {" + va2[0] + ",\t" + va2[1] + ",\t" + va2[2] + "} = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-007] double[] - VectoR
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [6.0   4.0   4.0]
		 */
		v3 = Op.minus(va1, v2);
		
		assertTrue(6.0 == v3.getElement(0));
		assertTrue(4.0 == v3.getElement(1));
		assertTrue(4.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-007] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} - " + v2 + " = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-008] double[] - double[]
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : va2 - double[]: {-4.0,   3.0,  -1.0}
		 * expected out : v3 - VectoR: [6.0   4.0   4.0]
		 */
		v3 = Op.minus(va1, va2);
		
		assertTrue(6.0 == v3.getElement(0));
		assertTrue(4.0 == v3.getElement(1));
		assertTrue(4.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-008] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} - {" + va2[0] + ",\t" + va2[1] + ",\t" + va2[2] + "} = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-009] Dot product between VectoR and VectoR
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : d3 - double: 10.0
		 */
		d3 = Op.dot(v1, v2);
		
		assertTrue(10.0 == d3);
		
		System.out.println("[JASMIN-TC-VECTOR-009] " + v1 + " ¡¤ " + v2 + " = " + d3);
		
		/**
		 * [JASMIN-TC-VECTOR-010] Dot product between VectoR and double[]
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : va2 - double[]: {-4.0,   3.0,  -1.0}
		 * expected out : d3 - double: 10.0
		 */
		d3 = Op.dot(v1, va2);
		
		assertTrue(10.0 == d3);
		
		System.out.println("[JASMIN-TC-VECTOR-010] " + v1 + " ¡¤ {" + va2[0] + ",\t" + va2[1] + ",\t" + va2[2] + "} = " + d3);
		
		/**
		 * [JASMIN-TC-VECTOR-011] Dot product between double[] and VectoR
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : d3 - double: 10.0
		 */
		d3 = Op.dot(va1, v2);
		
		assertTrue(10.0 == d3);
		
		System.out.println("[JASMIN-TC-VECTOR-011] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} ¡¤ " + v2 + " = " + d3);
		
		/**
		 * [JASMIN-TC-VECTOR-012] Dot product between double[] and double[]
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : v2 - double[]: {-4.0,   3.0,  -1.0}
		 * expected out : d3 - double: 10.0
		 */
		d3 = Op.dot(va1, va2);
		
		assertTrue(10.0 == d3);
		
		System.out.println("[JASMIN-TC-VECTOR-012] {" + va1[0] + "\t" + va1[1] + "\t" + va1[2] + "} ¡¤ {" + va2[0] + "\t" + va2[1] + "\t" + va2[2] + "} = " + d3);
		
		/**
		 * [JASMIN-TC-VECTOR-013] Cross product between VectoR and VectoR
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [-16.0 -10.0 34.0]
		 */
		v3 = Op.cross(v1, v2);
		
		assertTrue(-16.0 == v3.getElement(0));
		assertTrue(-10.0 == v3.getElement(1));
		assertTrue(34.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-013] " + v1 + " ¡¿ " + v2 + " = " + v3 );
		
		/**
		 * [JASMIN-TC-VECTOR-013] Cross product between VectoR and double[]
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : va2 - double[]: {-4.0,   3.0,  -1.0}
		 * expected out : v3 - VectoR: [-16.0 -10.0 34.0]
		 */
		v3 = Op.cross(v1, va2);
		
		assertTrue(-16.0 == v3.getElement(0));
		assertTrue(-10.0 == v3.getElement(1));
		assertTrue(34.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-014] " + v1 + " ¡¿ {" + va2[0] + ",\t" + va2[1] + ",\t" + va2[2] + "} = " + v3 );
		
		/**
		 * [JASMIN-TC-VECTOR-015] Cross product between double[] and VectoR
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [-16.0 -10.0 34.0]
		 */
		v3 = Op.cross(va1, v2);
		
		assertTrue(-16.0 == v3.getElement(0));
		assertTrue(-10.0 == v3.getElement(1));
		assertTrue(34.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-015] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} ¡¿ " + v2 + " = " + v3 );
		
		/**
		 * [JASMIN-TC-VECTOR-016] Cross product between double[] and double[]
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : va2 - double[]: {-4.0,   3.0,  -1.0}
		 * expected out : v3 - VectoR: [-16.0 -10.0 34.0]
		 */
		v3 = Op.cross(va1, va2);
		
		assertTrue(-16.0 == v3.getElement(0));
		assertTrue(-10.0 == v3.getElement(1));
		assertTrue(34.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-016] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} ¡¿ {" + va2[0] + ",\t" + va2[1] + ",\t" + va2[2] + "} = " + v3 );
		
		/**
		 * [JASMIN-TC-VECTOR-017] elements multiplication between VectoR and VectoR
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [-80 -10.0 -3.0]
		 */
		v3 = Op.times(v1, v2);
		
		assertTrue(-8.0 == v3.getElement(0));
		assertTrue(21.0 == v3.getElement(1));
		assertTrue(-3.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-017] " + v1 + " * " + v2 + " = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-018] elements multiplication between VectoR and double[]
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : va2 - double[]: {-4.0,   3.0,  -1.0}
		 * expected out : v3 - VectoR: [-80 -10.0 -3.0]
		 */
		v3 = Op.times(v1, va2);
		
		assertTrue(-8.0 == v3.getElement(0));
		assertTrue(21.0 == v3.getElement(1));
		assertTrue(-3.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-018] " + v1 + " * {" + va2[0] + ",\t" + va2[1] + ",\t" + va2[2] + "} = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-019] elements multiplication between double[] and VectoR
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [-80 -10.0 -3.0]
		 */
		v3 = Op.times(va1, v2);
		
		assertTrue(-8.0 == v3.getElement(0));
		assertTrue(21.0 == v3.getElement(1));
		assertTrue(-3.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-019] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} * " + v2 + " = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-020] elements multiplication between double[] and double[]
		 * input1 : va1 - double[]: { 2.0,   7.0,   3.0}
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [-80 -10.0 -3.0]
		 */
		v3 = Op.times(va1, va2);
		
		assertTrue(-8.0 == v3.getElement(0));
		assertTrue(21.0 == v3.getElement(1));
		assertTrue(-3.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-020] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} * {" + va2[0] + ",\t" + va2[1] +",\t" + va2[2] + "} = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-021] Multiplication between VectoR and double
		 * input1 : v1 - VectoR: [ 2.0   7.0   3.0]
		 * input2 : d1 - double : 7
		 * expected out : v3 - VectoR: [14.0 49.0 21.0]
		 */
		v3 = Op.times(v1, d1);
		
		assertTrue(14.0 == v3.getElement(0));
		assertTrue(49.0 == v3.getElement(1));
		assertTrue(21.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-021] " + v1 + " * " + d1 + " = " + v3);
		 
		/**
		 * [JASMIN-TC-VECTOR-022] Multiplication between double[] and double
		 * input1 : va1 - double[]: { 2.0   7.0   3.0}
		 * input2 : d1 - double : 7
		 * expected out : v3 - VectoR: [14.0 49.0 21.0]
		 */
		v3 = Op.times(va1, d1);
		
		assertTrue(14.0 == v3.getElement(0));
		assertTrue(49.0 == v3.getElement(1));
		assertTrue(21.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-022] {" + va1[0] + ",\t" + va1[1] + ",\t" + va1[2] + "} * " + d1 + " = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-023] Multiplication between double and VectoR
		 * input1 : d2 - double: -4.0
		 * input2 : v2 - VectoR: [-4.0   3.0  -1.0]
		 * expected out : v3 - VectoR: [16.0 -12.0 4.0]
		 */
		v3 = Op.times(d2, v2);
		
		assertTrue(16.0 == v3.getElement(0));
		assertTrue(-12.0 == v3.getElement(1));
		assertTrue(4.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-023] " + d2 + " * " + v2 + " = " + v3);
		
		/**
		 * [JASMIN-TC-VECTOR-024] Multiplication between double and double[]
		 * input1 : d2 - double: -4.0
		 * input2 : v2 - double[]: {-4.0,   3.0,  -1.0}
		 * expected out : v3 - VectoR: [16.0 -12.0 4.0]
		 */
		v3 = Op.times(d2, va2);
		
		assertTrue(16.0 == v3.getElement(0));
		assertTrue(-12.0 == v3.getElement(1));
		assertTrue(4.0 == v3.getElement(2));
		
		System.out.println("[JASMIN-TC-VECTOR-024] " + d2 + " * {" + va2[0] + ",\t" + va2[1] + ",\t" + va2[2]  + "} = " + v3);
		
		
	}
}
