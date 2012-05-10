/**
 * 
 */
package org.openjasmine.geometry;

import org.openjasmine.types.Matrix;
import org.openjasmine.types.VectoR;

/**
 * @author Hyeon-min.Shim(elecage@gmail.com)
 *
 */
public class RefTran {
	public static VectoR rotX(double rad, VectoR v) {
		Matrix rot = getRotXMatrix(rad);
		VectoR res = new VectoR(4);
		
		res = (VectoR)rot.times(v);
		return res;
	}
	public static VectoR rotY(double rad, VectoR v) {
		Matrix rot = getRotYMatrix(rad);
		VectoR res = new VectoR(4);
		
		res = (VectoR)rot.times(v);
		return res;
	}
	public static VectoR rotZ(double rad, VectoR v) {
		Matrix rot = getRotZMatrix(rad);
		VectoR res = new VectoR(4);
		
		
		res = (VectoR)rot.times(v);
		return res;
	}
	
	public static VectoR rot(double xrad, double yrad, double zrad, VectoR v) {
		VectoR temp1 = new VectoR(v.getSize());
		VectoR temp2 = new VectoR(v.getSize());
		VectoR res = new VectoR(v.getSize());
		
		temp1 = rotY(yrad, v);
		temp2 = rotX(xrad, temp1);
		res = rotZ(zrad, temp2);

		return res;
	}
	
	public static VectoR rotTran(double xrad, double yrad, double zrad, 
								double xtran, double ytran, double ztran, VectoR v) {
		VectoR res = new VectoR(4);
		Matrix rotTranMat = getRotTranMatrix(xrad, yrad, zrad, xtran, ytran, ztran);
		System.out.println("rotTranmat = \n" + rotTranMat);
		
		res = (VectoR)rotTranMat.times(v);
		return res;
	}
	public static Matrix getRotXMatrix(double rad) {
		Matrix rot = new Matrix(4, 4);
		double cosx = Math.cos(rad);
		double sinx = Math.sin(rad);
	
		rot.setElement(0, 0, 1.0);
		rot.setElement(0, 1, 0.0);
		rot.setElement(0, 2, 0.0);
		rot.setElement(0, 3, 0.0);
		rot.setElement(1, 0, 0.0);
		rot.setElement(1, 1, cosx);
		rot.setElement(1, 2, -sinx);
		rot.setElement(1, 3, 0.0);
		rot.setElement(2, 0, 0.0);
		rot.setElement(2, 1, sinx);
		rot.setElement(2, 2, cosx);
		rot.setElement(2, 3, 0.0);
		rot.setElement(3, 0, 0.0);
		rot.setElement(3, 1, 0.0);
		rot.setElement(3, 2, 0.0);
		rot.setElement(3, 3, 1.0);
		
		return rot;
	}
	
	public static Matrix getRotYMatrix(double rad) {
		Matrix rot = new Matrix(4, 4);

		double cosy = Math.cos(rad);
		double siny = Math.sin(rad);
		rot.setElement(0, 0, cosy);
		rot.setElement(0, 1, 0.0);
		rot.setElement(0, 2, siny);
		rot.setElement(0, 3, 0.0);
		rot.setElement(1, 0, 0.0);
		rot.setElement(1, 1, 1.0);
		rot.setElement(1, 2, 0.0);
		rot.setElement(0, 3, 0.0);
		rot.setElement(2, 0, -siny);
		rot.setElement(2, 1, 0.0);
		rot.setElement(2, 2, cosy);
		rot.setElement(2, 3, 0.0);
		rot.setElement(3, 0, 0.0);
		rot.setElement(3, 1, 0.0);
		rot.setElement(3, 2, 0.0);
		rot.setElement(3, 3, 1.0);
		return rot;
	}
	
	public static Matrix getRotZMatrix(double rad) {
		Matrix rot = new Matrix(4, 4);
		
		double cosz = Math.cos(rad);
		double sinz = Math.sin(rad);
		rot.setElement(0, 0, cosz);
		rot.setElement(0, 1, -sinz);
		rot.setElement(0, 2, 0.0);
		rot.setElement(0, 3, 0.0);
		rot.setElement(1, 0, sinz);
		rot.setElement(1, 1, cosz);
		rot.setElement(1, 2, 0.0);
		rot.setElement(1, 3, 0.0);
		rot.setElement(2, 0, 0.0);
		rot.setElement(2, 1, 0.0);
		rot.setElement(2, 2, 1.0);
		rot.setElement(2, 3, 0.0);
		rot.setElement(3, 0, 0.0);
		rot.setElement(3, 1, 0.0);
		rot.setElement(3, 2, 0.0);
		rot.setElement(3, 3, 1.0);
		return rot;
	}
	
	public static Matrix getRotTranMatrix(double xrad, double yrad, double zrad, 
			double xtran, double ytran, double ztran) {
		Matrix rotXMat = getRotXMatrix(xrad);
		Matrix rotYMat = getRotYMatrix(yrad);
		Matrix rotZMat = getRotZMatrix(zrad);
		
		Matrix temp = (Matrix) rotXMat.times(rotYMat);
		Matrix rotTranMat = (Matrix) temp.times(rotZMat);
		rotTranMat.setElement(0, 3, xtran);
		rotTranMat.setElement(1, 3, ytran);
		rotTranMat.setElement(2, 3, ztran);
		rotTranMat.setElement(3, 3, 1.0);
		
	
		return rotTranMat;
	}
}
