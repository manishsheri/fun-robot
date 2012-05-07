/**
 * 
 */
package org.openjasmine.filter;

import org.openjasmine.types.Matrix;
import org.openjasmine.types.VectoR;

/**
 * @author Hyeon-min.Shim(elecage@gmail.com)
 *
 */
public class Kalman {
	protected Matrix A;		/** n by n matrix */
	protected Matrix H;		/** m by n matrix */
	protected Matrix Q;
	protected Matrix R;

	protected Matrix P;
	
	protected VectoR xHat;	/** estimate vector. n by 1 vector */
	protected VectoR xBar;	/** predict vector. n by 1 vector */
	protected VectoR w;		/** process noise. n by 1 vector */
	protected VectoR v;		/** measurement noise. m by 1 vector */
	
	/**
	 * n : state vector size
	 * m : measurement vector size
	 */
	int n, m;
	
	public Kalman(Matrix A, Matrix H, Matrix Q, Matrix R, Matrix P, VectoR xHat) {
		this.A = A;
		this.H = H;
		this.Q = Q;
		this.R = R;
		
		this.P = P;
		this.n = H.getCol();
		this.m = H.getRow();
		
		this.xHat = xHat;
		this.xBar = new VectoR(n);
	}
	
	public VectoR kf(VectoR z) {
		xBar = (VectoR)A.times(xHat);
		Matrix pTemp1 = (Matrix)A.times(P);
		Matrix pTemp2 = (Matrix)pTemp1.times(A.transpose());
		Matrix Pp = (Matrix)pTemp2.plus(Q);
		Matrix temp =(Matrix)((Matrix)((Matrix)H.times(Pp)).times(H.transpose())).plus(R);
		temp = temp.inv();
		Matrix mTemp1 = (Matrix)Pp.times(H.transpose());
		Matrix K =(Matrix) mTemp1.times(temp);
		
		VectoR vTemp1 =(VectoR)H.times(xBar);
		VectoR vTemp2 = (VectoR)z.minus(vTemp1);
		VectoR vTemp3 = (VectoR)K.times(vTemp2);
		xHat =(VectoR)xBar.plus(vTemp3);
		
		Matrix temp1 = (Matrix)((Matrix)K.times(H));
		Matrix temp2 = (Matrix)temp1.times(Pp);
		P = (Matrix)Pp.minus(temp2);
		
		return xHat;
	}
}
