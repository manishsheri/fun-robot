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
	}

}
