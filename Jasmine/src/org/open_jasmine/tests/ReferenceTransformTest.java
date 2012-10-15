package org.open_jasmine.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.open_jasmine.operators.Op;
import org.open_jasmine.operators.RefTran;
import org.open_jasmine.types.VectoR;

public class ReferenceTransformTest {

	@Test
	public void testRotZ() {
		double[] va = {0.0, 2.0, 0.0};
		VectoR v = new VectoR(va);
		VectoR vres = RefTran.rotZ(v, Op.deg2rad(30.0));
		assertTrue(Math.abs(vres.getElement(0) - -1.000) < 0.0005);
		assertTrue(Math.abs(vres.getElement(1) - 1.732) < 0.0005);
		assertTrue(Math.abs(vres.getElement(2) - 0.000) < 0.0005);
		
		System.out.println("rotation z(30deg) of vector " + v + " = " + vres);
	}

}
