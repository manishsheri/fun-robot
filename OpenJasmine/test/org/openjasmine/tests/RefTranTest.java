/**
 * 
 */
package org.openjasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.geometry.RefTran;
import org.openjasmine.types.VectoR;

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
	public void test() {
		Double[] vArray = {3.0, 2.0, 0.0};
		
		VectoR v = new VectoR(vArray);
		VectoR v2 = RefTran.rotZ(RefTran.d2r(45.0), v);
		
		System.out.println(v + "rot 45 = " + v2);
		
		assertTrue(Math.abs(0.7071 - (Double)v2.getElement(0)) < 0.0001);
		assertTrue(Math.abs(3.5355 - (Double)v2.getElement(1)) < 0.0001);
		assertTrue(Math.abs(0.0 - (Double)v2.getElement(2)) < 0.0001);
		
	}

}
