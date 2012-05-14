/**
 * 
 */
package org.openjasmine.types;

/**
 * @author khj
 *
 */
public class Quaternion {
	protected double s;
	protected VectoR v;
	/**
	 * 
	 */
	public Quaternion() {
		s = 0.0;
		v = new VectoR(3);
		int i;
		for(i = 0 ; i < 3 ; i++) {
			v.setElement(i, 0.0);
		}
	}
	public Quaternion(double s, VectoR v) {
		this.s = s;
		this.v = v;
	}
	
	public Quaternion(double s, double x, double y, double z) {
		this.s = s;
		v = new VectoR(3);
		v.setElement(0, x);
		v.setElement(1, y);
		v.setElement(2, z);
	}
	
	public double magnitude() {
		double result = 0.0;
		
		result = s*s;
		result += (Double)v.getElement(0) * (Double)v.getElement(0);
		result += (Double)v.getElement(1) * (Double)v.getElement(1);
		result += (Double)v.getElement(2) * (Double)v.getElement(2);
		
		result = Math.sqrt(result);
		return result;
	}
	public double getS() {
		return s;
	}
	public void setS(double s) {
		this.s = s;
	}
	public VectoR getV() {
		return v;
	}
	public void setV(VectoR v) {
		this.v = v;
	}
	public Quaternion plus(double s) {
		double sr = this.s;
		double x = (Double) this.v.getElement(0);
		double y = (Double) this.v.getElement(1);
		double z = (Double) this.v.getElement(2);
		
		return new Quaternion(sr + s, x, y, z);
		
	}
	public Quaternion plus(Quaternion q) {
		Quaternion result = new Quaternion(0.0, 0.0, 0.0, 0.0);
		
		result.setS(this.s + q.getS());
		result.setV((VectoR)this.v.plus(q.getV()));
		return result;
	}
	
	/**
	 * 사원수에서 스칼라를 뺀다. 사원수의 스칼라부에서 argument를 뺀다.
	 * @param s 빼고자 하는 스칼라값
	 * @return 스칼라 s를 뺀 사원수
	 */
	public Quaternion minus(double s) {
		double sr = this.s;
		double x = (Double) this.v.getElement(0);
		double y = (Double) this.v.getElement(1);
		double z = (Double) this.v.getElement(2);
		
		return new Quaternion(sr - s, x, y, z);
		
	}
	
	/**
	 * 사원수에서 사원수를 뺀다.
	 * @param q 빼고자 하는 사원수
	 * @return
	 */
	public Quaternion minus(Quaternion q) {
		Quaternion result = new Quaternion(0.0, 0.0, 0.0, 0.0);
		
		result.setS(this.s - q.getS());
		result.setV((VectoR)this.v.minus(q.getV()));
		return result;
	}
	
	/**
	 * 사원수에 스칼라를 곱한다.
	 * @param s 사원수에 곱하고자 하는 스칼라
	 * @return 스칼라를 곱한 사원수
	 */
	public Quaternion times(double s) {
		double sr = this.s;
		double x = (Double) this.v.getElement(0);
		double y = (Double) this.v.getElement(1);
		double z = (Double) this.v.getElement(2);
		
		return new Quaternion(sr * s, x * s, y * s, z * s);
		
	}
	
	/**
	 * 사원수와 사원수를 곱한다.
	 * @param q 곱하고자 하는 사원수
	 * @return 두 사원수를 곱한 사원수
	 */
	public Quaternion times(Quaternion q) {
		double sr1 = this.s;
		double x1 = (Double) this.v.getElement(0);
		double y1 = (Double) this.v.getElement(1);
		double z1 = (Double) this.v.getElement(2);
		
		double sr2 = q.getS();
		VectoR v2 = q.getV();
		double x2 = (Double) v2.getElement(0);
		double y2 = (Double) v2.getElement(1);
		double z2 = (Double) v2.getElement(2);
		
		return new Quaternion((sr1 * sr2) - (x1 * x2) - (y1 * y2) - (z1 * z2),
							  (sr1 * x2) + (x1 * sr2) + (y1 * z2) - (z1 * y2), 
							  (sr1 * y2) - (x1 * z2) + (y1 * sr2) + (z1 * x2), 
							  (sr1 * z2) + (x1 * y2) - (y1 * x2) + (z1 * sr2));
	}
	
	/**
	 * 사원수에 벡터를 곱한다. 벡터는 스칼라부가 0.0인 사원수로 가정한다.
	 * @param v 곱하고자 하는 벡터값
	 * @return v를 곱한 사원수.
	 */
	
	public Quaternion times(VectoR v) {
		Quaternion qv = new Quaternion(0.0, v);
		return this.times(qv);
	}
	
	/**
	 * 사원수의 역수를 반환한다.
	 * @return 사원수 역수
	 */
	public Quaternion inv() {
		double mag = this.magnitude();
		Quaternion result = this.conj();
		return result.div(mag * mag);
	}
	
	/**
	 * 사원수를 스칼라로 나눈다.
	 * @param s 나누고자 하는 스칼라 값
	 * @return s로 나눈 사원수
	 */
	public Quaternion div(double s) {
		double sr = this.s;
		double x = (Double) this.v.getElement(0);
		double y = (Double) this.v.getElement(1);
		double z = (Double) this.v.getElement(2);
		
		try {
			return new Quaternion(sr / s, x / s, y / s, z / s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
		
	/**
	 * 사원수의 켤레사원수를 리턴한다.
	 * @return 켤레사원수
	 */
	public Quaternion conj() {
		double sr = this.s;
		double x = (Double) this.v.getElement(0);
		double y = (Double) this.v.getElement(1);
		double z = (Double) this.v.getElement(2);
		
		return new Quaternion(sr , -x, -y, -z);
	}
	
	/**
	 * 사원수의 벡터부분으로 나타낸 축을 중심으로 회전한 각의 크기를 알려준다.
	 * @return 
	 * @return 회전각
	 */
	public double getAngle() {
		return 2.0 * Math.acos(this.s);
	}
	
	public VectoR getAxis() {
		Double[] ar = {0.0, 0.0, 0.0};
		VectoR v = this.getV();
		VectoR zeroV = new VectoR(ar);
		double m = this.magnitude();
		
		if(m <= 0.0001) {
			return (VectoR)zeroV;
		}
		else {
			return (VectoR)v.div(m);
		}
	}
	
	public Quaternion rotate(Quaternion q) {
		Quaternion rq = this.times(q);
		return rq.times(this.conj());
	}
	
	public VectoR rotate(VectoR v) {
		Quaternion q = new Quaternion(0.0, v);
		Quaternion rq = this.times(q);
		return (rq.times(this.conj())).getV();
	}
	
	public void setFromEuler(double roll, double pitch, double yaw) {
		double cyaw	 	= Math.cos(0.5 * yaw);
		double cpitch 	= Math.cos(0.5 * pitch);
		double croll 	= Math.cos(0.5 * roll);
		double syaw		= Math.sin(0.5 * yaw);
		double spitch	= Math.sin(0.5 * pitch);
		double sroll	= Math.sin(0.5 * roll);
		
		double cyawcpitch	= cyaw * cpitch;
		double syawspitch 	= syaw * spitch;
		double cyawspitch 	= cyaw * spitch;
		double syawcpitch	= syaw * cpitch;
		
		this.s = cyawcpitch * croll + syawspitch * sroll;
		this.v.setElement(0, cyawcpitch * sroll - syawspitch * croll);
		this.v.setElement(1, cyawspitch * croll + syawcpitch * sroll);
		this.v.setElement(2, syawcpitch * croll - cyawspitch * sroll);
	}
	
	public VectoR getEuler() {
		double x = (Double)this.v.getElement(0);
		double y = (Double)this.v.getElement(1);
		double z = (Double)this.v.getElement(2);
		double q00 = this.s * this.s;
		double q11 = x * x;
		double q22 = y * y;
		double q33 = z * z;
		
		
		double r11 = q00 + q11 - q22 - q33;
		double r21 = 2.0 * (x * y + this.s * z);
		double r31 = 2.0 * (x * z - this.s * y);
		double r32 = 2.0 * (y * z + this.s * x);
		double r33 = q00 - q11 - q22 + q33;
		double r12, r13;
		double tmp = Math.abs(r31);
		
		VectoR result = new VectoR(3);
		if(tmp > 0.9999999) {
			r12 = 2.0 * (x * y - this.s * z);
			r13 = 2.0 * (x * z + this.s * y);
			
			result.setElement(0, 0.0);	/// 옆놀이
			result.setElement(1, -(Math.PI/2.0) * r31 / tmp);	/// 키놀이
			result.setElement(2, Math.atan2(-r12, -r31 * r13)); // 빗놀이
		}
		else {
			result.setElement(0, Math.atan2(r32, r33));
			result.setElement(1, Math.asin(-r31));
			result.setElement(2, Math.atan2(r21, r11));
		}
		return result;
	}
}
