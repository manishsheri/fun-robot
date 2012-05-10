package org.openjasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.geometry.Point;

public class GeometryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Double[] d1 = {-1.0, -1.0, 3.0, 6.0};
		Double[] d2 = {1.0, 1.0, -3.0, 2.0};
		Point p1 = new Point(d1);
		Point p2 = new Point(d2);
		
		double dist = p1.distance(p2);
		
		System.out.print("distance = " + dist);
		assertTrue(Math.abs(7.7460 - dist) < 0.0001);
	}

}
