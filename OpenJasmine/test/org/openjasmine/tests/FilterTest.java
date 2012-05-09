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

	double velp, posp;
	double dt;
	@Before
	public void setUp() throws Exception {
		posp = 0.0;
		velp = 80.0;
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
		
		dt = 0.2;
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
	
	@Test
	public void ojFilterTest004() {
		dt = 0.1;
		Double[][] aArray = {{1.0, dt}, {0.0, 1.0}};
		Double[][] hArray = {{1.0, 0.0}};
		Double[][] qArray = {{1.0, 0.0},{0.0, 3.0}};
		Double[][] rArray = {{10.0}};
		Double[]   xArray = {0.0, 20.0};
		VectoR z = new VectoR(1);
		
		Matrix A = new Matrix(aArray);
		Matrix H = new Matrix(hArray);
		Matrix Q = new Matrix(qArray);
		Matrix R = new Matrix(rArray);
		Matrix P = Matrix.eye(2);
		VectoR x = new VectoR(xArray);
		
		VectoR res;
		
		P = (Matrix)P.times(5.0);
		
		Kalman kf = new Kalman(A, H, Q, R, P, x);
		System.out.println("====================");
		for(int i = 0 ; i < 100 ; i++) {
			z.setElement(0, getPose());
			
			res = kf.kf(z);
			System.out.println(z + "\t" + res +";");
		}
	}
	
	
	public double getPose() {
		double z;
		double w, v;
		
		w = 50.0*Math.random();
		v = 50.0*Math.random();
		
		z = posp + velp*dt + v;
		posp = z - v;
		velp = 80+w;
		
		return z;
	}
	
	@Test
	public void ojFilterTest005() {
		dt = 0.1;
		Double[][] aArray = {{1.0, dt}, {0.0, 1.0}};
		Double[][] hArray = {{0.0, 1.0}};
		Double[][] qArray = {{1.0, 0.0},{0.0, 3.0}};
		Double[][] rArray = {{10.0}};
		Double[]   xArray = {0.0, 20.0};
		VectoR z = new VectoR(1);
		
		Matrix A = new Matrix(aArray);
		Matrix H = new Matrix(hArray);
		Matrix Q = new Matrix(qArray);
		Matrix R = new Matrix(rArray);
		Matrix P = Matrix.eye(2);
		VectoR x = new VectoR(xArray);
		
		VectoR res;
		
		P = (Matrix)P.times(5.0);
		
		Kalman kf = new Kalman(A, H, Q, R, P, x);
		System.out.println("====================");
		for(int i = 0 ; i < 100 ; i++) {
			z.setElement(0, getVel());
			
			res = kf.kf(z);
			System.out.println(z + "\t" + res +";");
		}
	}
	
	public double getVel() {
		double z;
		double v;
		v = 0.0 + 10.0 * Math.random();
		
		posp = posp + velp * dt;
		velp = 80 + v;
		
		z = velp;
		
		return z;
	}
}
