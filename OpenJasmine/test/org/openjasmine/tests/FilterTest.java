package org.openjasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.filter.Average;
import org.openjasmine.filter.Kalman;
import org.openjasmine.filter.MovingAverage;
import org.openjasmine.types.Matrix;
import org.openjasmine.types.VectoR;

public class FilterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void ojFilterTest001() {
		Average average = new Average();
		
		int i;
		double avg = 0.0;
		for(i = 1 ; i < 100 ; i++) {
			avg = average.newAverage((double)i);
			System.out.println("Average of (1 ~" + i + ") = " + avg);
		}
	}
	@Test
	public void ojFilterTest002() {
		MovingAverage average = new MovingAverage(20);
		
		int i, k;
		double avg = 0.0;
		for(i = 1 ; i < 100 ; i++) {
			avg = average.newAverage((double)i);
			if(i < 20)
				k = 1;
			else
				k = i-20 + 1;
			System.out.println("Average of (" + k + " ~" + i + ") = " + avg);
		}
	}
	
	@Test
	public void ojFilterTest003() {
		double dt = 0.2;
		VectoR z = new VectoR(1);
		
		Matrix A = new Matrix(1, 1);
		A.setElement(0, 0, 1.0);
		
		Matrix H = new Matrix (1, 1);
		H.setElement(0, 0, 1.0);
		
		Matrix Q = new Matrix(1, 1);
		Q.setElement(0, 0, 0.0);
		
		Matrix R = new Matrix(1, 1);
		R.setElement(0, 0, 4.0);
		
		Matrix P = new Matrix(1, 1);
		P.setElement(0, 0, 6.0);
		
		VectoR x = new VectoR(1);
		x.setElement(0, 14.0);
		Kalman kf = new Kalman(A, H, Q, R, P, x);

		VectoR out;
		for(double t = 0.0 ; t < 10.0 ; t += dt) {
			z.setElement(0, 14.4 + 4 * Math.random());
			out = kf.kf(z);
			System.out.println(z + "  " + out + ';');
		}
	}
}
