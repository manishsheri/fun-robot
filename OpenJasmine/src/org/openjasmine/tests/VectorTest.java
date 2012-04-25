package org.openjasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.types.Complex;
import org.openjasmine.types.VectoR;

public class VectorTest {
	VectoR v1, v2, v3, v4, v5;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Double[] d1 = {3.0, -2.0, 5.0, -7.0};
		Double[] d2 = {-2.0, -6.0, 7.0, 4.0};
		Double[] re1 = {2.0, 3.0, -2.0, -6.0};
		Double[] im1 = {7.0, -5.0, 4.0, -8.0};
		Double dr;
		Complex cr;
		Complex[] c1 = new Complex[4];
		for(int i = 0 ; i < 4 ; i++) {
			c1[i] = new Complex(re1[i], im1[i]);
		}
		Complex[] c2 = {Complex.getComplex(3.0, 2.0), 
						Complex.getComplex(5.0, -2.0),
						Complex.getComplex(-6.0, 4.0),
						Complex.getComplex(-2.0, -8.0)};
		
		v1 = new VectoR(d1);
		v2 = new VectoR(d2);
		v3 = new VectoR(c1);
		v4 = new VectoR(c2);
		 
		System.out.println("v1  \t\t= " + v1);
		System.out.println("v2  \t\t= " + v2);
		System.out.println("v3  \t\t= " + v3);
		System.out.println("v4  \t\t= " + v4);
		
		v5 = (VectoR) v1.plus(v2);
		System.out.println("v1 + v2 \t= " + v5);
		v5 = (VectoR) v1.plus(v3);
		System.out.println("v1 + v3 \t= " + v5);
		v5 = (VectoR) v3.plus(v4);
		System.out.println("v3 + v4 \t= " + v5);
		
		v5 = (VectoR) v1.minus(v2);
		System.out.println("v1 - v2 \t= " + v5);
		v5 = (VectoR) v1.minus(v3);
		System.out.println("v1 - v3 \t= " + v5);
		v5 = (VectoR) v3.minus(v4);
		System.out.println("v3 - v4 \t= " + v5);
		
		v5 = (VectoR) v1.times(v2);
		System.out.println("v1 * v2 \t= " + v5);
		v5 = (VectoR) v1.times(v3);
		System.out.println("v1 * v3 \t= " + v5);
		v5 = (VectoR) v3.times(v4);
		System.out.println("v3 * v4 \t= " + v5);
		
		v5 = (VectoR) v1.div(v2);
		System.out.println("v1 / v2 \t= " + v5);
		v5 = (VectoR) v1.div(v3);
		System.out.println("v1 / v3 \t= " + v5);
		v5 = (VectoR) v3.div(v4);
		System.out.println("v3 / v4 \t= " + v5);
		
		dr = (Double)v1.dot(v2);
		System.out.println("dot(v1, v2) = " + dr);
		
		cr = (Complex)v1.dot(v3);
		System.out.println("dot(v1, v3) = " + cr);
		
		cr = (Complex)v3.dot(v4); // 문제 있다.
		System.out.println("dot(v3, v4) = " + cr);
		
		cr = (Complex)v4.dot(v3);
		System.out.println("dot(v4, v3) = " + cr);
		
		cr = (Complex)v3.dot(v1);
		System.out.println("dot(v3, v1) = " + cr);
		
		cr = (Complex)v4.dot(v1);
		System.out.println("dot(v4, v1) = " + cr);
		
		dr = (Double)v1.norm(0.0);
		System.out.println("norm(v1, 0) = " + dr);
		
		dr = (Double)v1.norm(1.0);
		System.out.println("norm(v1, 1) = " + dr);
		dr = (Double)v1.norm(2.0);
		System.out.println("norm(v1, 2) = " + dr);
		dr = (Double)v1.norm(364.0); // maximum power value
		System.out.println("norm(v1, 364) = " + dr);
		dr = (Double)v1.norm(365.0);	// wrong result
		System.out.println("norm(v1, 365) = " + dr);
		dr = (Double)v1.norm(Double.NEGATIVE_INFINITY);
		System.out.println("norm(v1, -inf) = " + dr);
		dr = (Double)v1.norm(Double.POSITIVE_INFINITY);
		System.out.println("norm(v1, inf) = " + dr);
		
		dr = (Double)v3.norm(1.0);
		System.out.println("norm(v3, 1) = " + dr);
		dr = (Double)v3.norm(2.0);
		System.out.println("norm(v3, 2) = " + dr);
		dr = (Double)v3.norm(308.0); // maximum power value
		System.out.println("norm(v3, 308) = " + dr);
		dr = (Double)v3.norm(309.0);	// wrong result
		System.out.println("norm(v3, 309) = " + dr);
		dr = (Double)v3.norm(Double.NEGATIVE_INFINITY);
		System.out.println("norm(v3, -inf) = " + dr);
		dr = (Double)v3.norm(Double.POSITIVE_INFINITY);
		System.out.println("norm(v3, inf) = " + dr);
		
		dr = v2.norm();
		System.out.println("norm(v2) = " + dr);
		dr = v4.norm();
		System.out.println("norm(v4) = " + dr);
		
		Double[] d3 = {0.2, -3.2, 4.3};
		Double[] d4 = {3.7, 1.9, -2.3};
		v1 = new VectoR(d3);
		v2 = new VectoR(d4);
		v3 = v1.cross(v2);
		System.out.println("cross(v1, v2) = " + v3);
		
		Complex[] c3 = {Complex.getComplex(1.4, 2.7),
						Complex.getComplex(-2.3, 3.9),
						Complex.getComplex(0.8, -1.2)};
		
		Complex[] c4 = {Complex.getComplex(3.5, -3.4),
						Complex.getComplex(1.8, 5.9),
						Complex.getComplex(9.2, -3.3)};
		
		v1 = new VectoR(c3);
		v2 = new VectoR(c4);
		
		v3 = v1.cross(v2);
		
		System.out.println("cross(v1, v2) = " + v3);
		
		Double[] d5 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
		
		v1 = new VectoR(d5);
		v2 = v1.getSubVector(2, 4);
		
		System.out.println("sub vector of v1 from 2 to 4 " + v2);
		
		Complex[] c5 = {Complex.getComplex(2.0, 3.4),
						Complex.getComplex(3.5, 9.3),
						Complex.getComplex(-2.3, 3.4),
						Complex.getComplex(-0.3, 0.3),
						Complex.getComplex(-2.4, 4.4),
						Complex.getComplex(3.4, 3.2)};
		
		v1 = new VectoR(c5);
		v2 = v1.getSubVector(2, 4);
		System.out.println("sub vector of v1 from 2 to 4 " + v2);
		
		v1 = new VectoR(d1);
		v2 = new VectoR(c1);
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);
		v3 = (VectoR)v1.times(2.3);
		System.out.println(v1 + " * 2.3 = " + v3);
		v4 = (VectoR)v2.times(2.3);
		System.out.println(v2 + " * 2.3 = " + v4);
		Complex cc1 = new Complex(2.3, 3.2);
		v3 = (VectoR)v1.times(cc1);
		System.out.println(v1 + " * (2.3 + 3.2i) = " + v3);
		v4 = (VectoR)v2.times(Complex.getComplex(2.3, 3.2));
		System.out.println(v2 + " * (2.3 + 3.2i) = " + v4);
		
		
	}

}
