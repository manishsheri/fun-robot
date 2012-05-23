/**
 * 
 */
package org.openjasmine.sensors;

import org.openjasmine.types.VectoR;

/**
 * @author elecage@gmail.com
 *
 */
public class Gyro {
	VectoR angle;

	
	double dt;
	/**
	 * 
	 */
	public Gyro() {
		// TODO Auto-generated constructor stub
		this.angle 		= new VectoR(3);
		int i;
		for(i = 0 ; i < this.angle.getSize() ; i++) {
			this.angle.setElement(i, 0.0);

		}
		this.dt			= 1.0;
	}
	public Gyro(double dt) {
		this.angle 		= new VectoR(3);

		int i;
		for(i = 0 ; i < this.angle.getSize() ; i++) {
			this.angle.setElement(i, 0.0);

		}
		this.dt			= dt;
	}
	
	public Gyro(double phi, double theta, double psi) {
		this.angle 		= new VectoR(3);
		
		this.angle.setElement(0, phi);
		this.angle.setElement(1, theta);
		this.angle.setElement(2, psi);

		this.dt			= 1.0;
	}
	
	public Gyro(double phi, double theta, double psi, double dt) {
		this.angle 		= new VectoR(3);

		this.angle.setElement(0, phi);
		this.angle.setElement(1, theta);
		this.angle.setElement(2, psi);

		this.dt			= dt;
	}
	
	public VectoR getAngle() {
		return angle;
	}
	public void setAngle(VectoR angle) {
		this.angle = angle;
	}
	public double getDt() {
		return dt;
	}
	public void setDt(double dt) {
		this.dt = dt;
	}
	
	public double getPhi() {
		return (Double)angle.getElement(0);
	}
	
	public double getTheta() {
		return (Double)angle.getElement(1);
	}
	
	public double getPsi() {
		return (Double)angle.getElement(2);
	}
	
	public void setPhi(double phi) {
		angle.setElement(0, phi);
	}
	
	public void setTheta(double theta) {
		angle.setElement(1, theta);
	}
	
	public void setPsi(double psi) {
		angle.setElement(2, psi);
	}
	public void Euler(double p, double q, double r) {
		double sinPhi = Math.sin((Double)angle.getElement(0));
		double cosPhi = Math.cos((Double)angle.getElement(0));
		double cosTheta = Math.cos((Double)angle.getElement(1));
		double tanTheta = Math.tan((Double)angle.getElement(1));
		double prevPhi = (Double)angle.getElement(0);
		double prevTheta = (Double)angle.getElement(1);
		double prevPsi = (Double)angle.getElement(2);
		
		double phi = prevPhi + dt * (p + q * sinPhi * tanTheta + r * cosPhi * tanTheta);
		double theta = prevTheta + dt * (q * cosPhi - r * sinPhi);
		double psi = prevPsi + dt * (q * sinPhi / cosTheta + r * cosPhi / cosTheta);
		
		angle.setElement(0, phi);
		angle.setElement(1, theta);
		angle.setElement(2, psi);
		
	}

}
