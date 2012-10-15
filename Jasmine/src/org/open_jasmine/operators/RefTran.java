/**
 * 
 */
package org.open_jasmine.operators;

import org.open_jasmine.types.Matrix;
import org.open_jasmine.types.VectoR;

/**
 * @author Hyeon-min Shim
 *
 */
public class RefTran {
	public static VectoR rotX(VectoR point, double rad) {
		VectoR ret;
		Matrix m;
		double cosr, sinr;
		cosr = Math.cos(rad);
		sinr = Math.sin(rad);
		double[][] marray = {{1.0, 0.0, 0.0},{0.0, cosr, -sinr},{0.0, sinr, cosr}};
		ret = new VectoR(3);
		m = new Matrix(marray);;
		ret = Op.times(m, point);

		return ret;
	}
	public static VectoR rotY(VectoR point, double rad) {
		VectoR ret;
		Matrix m;
		double cosr, sinr;
		cosr = Math.cos(rad);
		sinr = Math.sin(rad);
		double[][] marray = {{cosr, 0.0, sinr},{0.0, 1.0, 0.0},{-sinr, 0.0, cosr}};
		ret = new VectoR(3);
		m = new Matrix(marray);;
		ret = Op.times(m, point);

		return ret;
	}
	public static VectoR rotZ(VectoR point, double rad) {
		VectoR ret;
		Matrix m;
		double cosr, sinr;
		cosr = Math.cos(rad);
		sinr = Math.sin(rad);
		double[][] marray = {{cosr, -sinr, 0.0},{sinr, cosr, 0.0},{0.0, 0.0, 1.0}};
		ret = new VectoR(3);
		m = new Matrix(marray);;
		ret = Op.times(m, point);

		return ret;
	}
	public static VectoR tranX(VectoR point, double t) {
		VectoR ret = new VectoR(3);
		ret.setElement(0, point.getElement(0) + t);
		ret.setElement(1, point.getElement(1));
		ret.setElement(2, point.getElement(2));
		return ret;
	}
	public static VectoR tranY(VectoR point, double t) {
		VectoR ret = new VectoR(3);
		ret.setElement(0, point.getElement(0));
		ret.setElement(1, point.getElement(1) + t);
		ret.setElement(2, point.getElement(2));
		return ret;
	}
	public static VectoR tranZ(VectoR point, double t) {
		VectoR ret = new VectoR(3);
		ret.setElement(0, point.getElement(0));
		ret.setElement(1, point.getElement(1));
		ret.setElement(2, point.getElement(2) + t);
		return ret;
	}


}
