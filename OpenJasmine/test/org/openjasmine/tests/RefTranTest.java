/**
 * 
 */
package org.openjasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.geometry.RefTran;
import org.openjasmine.types.VectoR;

import Operation.GeoOp;

/**
 * @author khj
 *
 */
public class RefTranTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void ojRefTranTest001() {
		Double[] vArray = {0.0, 2.0, 0.0, 0.0};
		
		VectoR v = new VectoR(vArray);
		VectoR v2 = RefTran.rotZ(GeoOp.d2r(30.0), v);
		
		System.out.println(v + "rot 45 = " + v2);
		
		assertTrue(Math.abs(-1.0- (Double)v2.getElement(0)) < 0.001);
		assertTrue(Math.abs(1.732 - (Double)v2.getElement(1)) < 0.001);
		assertTrue(Math.abs(0.000 - (Double)v2.getElement(2)) < 0.001);
		
	}
	
	@Test
	public void ojRefTranTest002() {
		Double[] vArray = { 3.0, 7.0, 0.0, 0.0};
		VectoR v = new VectoR(vArray);
		VectoR v2 = RefTran.rotTran(GeoOp.d2r(0.0), GeoOp.d2r(0.0), GeoOp.d2r(30.0), 
									10.0, 5.0, 0.0, v);
		
		System.out.println(v2);
	}

}
