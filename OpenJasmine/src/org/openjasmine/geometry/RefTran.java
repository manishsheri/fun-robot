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
	public static VectoR rotx(double rad, VectoR v) {
		Matrix rot = new Matrix(3, 3);
		VectoR res = new VectoR(3);
		double cosx = Math.cos(rad);
		double sinx = Math.sin(rad);
	
		rot.setElement(0, 0, 1.0);
		rot.setElement(0, 1, 0.0);
		rot.setElement(0, 2, 0.0);
		rot.setElement(1, 0, 0.0);
		rot.setElement(1, 1, cosx);
		rot.setElement(1, 2, -sinx);
		rot.setElement(2, 0, 0.0);
		rot.setElement(2, 1, sinx);
		rot.setElement(2, 2, cosx);
		
		res = (VectoR)rot.times(v);
		return res;
	}
	public static VectoR rotY(double rad, VectoR v) {
		Matrix rot = new Matrix(3, 3);
		VectoR res = new VectoR(3);
		double cosy = Math.cos(rad);
		double siny = Math.sin(rad);
		rot.setElement(0, 0, cosy);
		rot.setElement(0, 1, 0.0);
		rot.setElement(0, 2, siny);
		rot.setElement(1, 0, 0.0);
		rot.setElement(1, 1, 1.0);
		rot.setElement(1, 2, 0.0);
		rot.setElement(2, 0, -siny);
		rot.setElement(2, 1, 0.0);
		rot.setElement(2, 2, cosy);
		
		res = (VectoR)rot.times(v);
		return res;
	}
	public static VectoR rotZ(double rad, VectoR v) {
		Matrix rot = new Matrix(3, 3);
		VectoR res = new VectoR(3);
		double cosz = Math.cos(rad);
		double sinz = Math.sin(rad);
		rot.setElement(0, 0, cosz);
		rot.setElement(0, 1, -sinz);
		rot.setElement(0, 2, 0.0);
		rot.setElement(1, 0, sinz);
		rot.setElement(1, 1, cosz);
		rot.setElement(1, 2, 0.0);
		rot.setElement(2, 0, 0.0);
		rot.setElement(2, 1, 0.0);
		rot.setElement(2, 2, 1.0);
		
		res = (VectoR)rot.times(v);
		return res;
	}
}
