package org.openjasmine.geometry;

import org.openjasmine.types.VectoR;

public class Point {
	protected VectoR axis;
	protected int dimension;
	public Point(VectoR axis) {
		super();
		this.axis = axis;
		dimension = axis.getSize();
	}
	
	public Point(double x, double y) {
		this.axis = new VectoR(2);
		dimension = 2;
		this.axis.setElement(0, x);
		this.axis.setElement(1, y);
	}
	
	public Point(int size) {
		this.axis = new VectoR(size);
		this.dimension = size;
		int i;
		for(i = 0 ; i < dimension ; i++) {
			this.axis.setElement(i, 0.0);
		}
	}
	public Point(Double[] array) {
		this.axis = new VectoR(array);
		this.dimension = this.axis.getSize();
	}
	public double distance(Point p) {
		double dist = 0.0;
		VectoR pmp = (VectoR)this.axis.minus(p.axis);
		
		dist = pmp.norm();
		
		return dist;
	}
}
