package org.openjasmine.op;

public class GeoOp {
	public static double d2r(double degree) {
		double r = degree * Math.PI / 180.0;
		return r;
	}
	
	public static double r2d(double radian) {
		double d = radian * 180.0 / Math.PI;
		
		return d;
	}
}
