package org.openjasmine.types;

/**
 * @filename Complex.java
 * @author Hyeon-min.Shim(elecage@gmail.com)
 */

public class Complex implements Operation, Cloneable {

	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/**
	 * add this complex and the other number <br>
	 * 두 복소수를 더한다.
	 * @param obj number to add. < 더하고자 하는 수>
	 * @return this + obj
	 */
	@Override
	public Object plus(Object obj) {
		Object result =  new Complex();
		if(obj instanceof Complex) {
			((Complex)result).set(this.re + ((Complex)obj).getRe(), (this.im +((Complex)obj).getIm()));
		}
		else if(obj instanceof Double) {
			((Complex)result).set(this.re + ((Double)obj).doubleValue(), this.im);
		}
		return result;
	}
	
	/**
	 * subtract a number from this complex.<br> 
	 * 두 복소수를 뺀다.
	 * @param obj number to add(complex or real(double)) 빼고자 하는 숫자. 복소수 또는 double형이 올 수 있다. 
	 * @return this + obj
	 */
	@Override
	public Object minus(Object obj) {
		Object result =  new Complex();
		if(obj instanceof Complex) {
			((Complex)result).set(this.re - ((Complex)obj).getRe(), (this.im - ((Complex)obj).getIm()));
		}
		else if(obj instanceof Double) {
			((Complex)result).set(this.re - ((Double)obj).doubleValue(), this.im);
		}
		return result;
	}

	@Override
	/**
	 * multiply a number from this complex.<br>  
	 * 두 복소수를 곱한다.
	 * @param obj number to add(complex or real(double)) 곱하고자 하는 숫자. 복소수 또는 double형이 올 수 있다. 
	 * @return this + obj
	 */
	public Object times(Object obj) {
		Object result =  new Complex();
		double re2, im2;
		if(obj instanceof Complex) {
			re2 = this.re * ((Complex)obj).getRe() - this.im * ((Complex)obj).getIm();
			im2 = this.re * ((Complex)obj).getIm() + this.im * ((Complex)obj).getRe();
			
			((Complex)result).set(re2, im2);
		}
		else if(obj instanceof Double) {
			((Complex)result).set(this.re * ((Double)obj).doubleValue(), this.im * ((Double)obj).doubleValue());
		}
		return result;
	}

	@Override
	public Object div(Object obj) {
		Object result =  new Complex();
		double re2, im2, df;
		if(obj instanceof Complex) {
			Complex con = ((Complex)obj).conj();
			re2 = ((Complex)obj).getRe();
			im2 = ((Complex)obj).getIm();
			df =  (re2 * re2) + (im2 * im2);
			result = this.times(con);
			re2 = ((Complex)result).getRe() / df;
			im2 = ((Complex)result).getIm() / df;
						
			((Complex)result).set(re2, im2);
		}
		else if(obj instanceof Double) {
			((Complex)result).set(this.re / ((Double)obj).doubleValue(), this.im / ((Double)obj).doubleValue());
		}
		return result;
	}

		
		
	/**
	 * Constructor. 실수부와 허수부를 세팅하는 경우.
	 * @param re The re to set
	 * @param im The im to set
	 */
	public Complex(Double re, Double im){
		this.re = re.doubleValue();
		this.im = im.doubleValue();
	}


	/**
	 * Real part of the Complex class.<br>
	 * Complex 클래스의 실수부 
	 */
	protected double re;


	/**
	 * Getter of the property <tt>re</tt>
	 * @return  Returns the re.
	 */
	public double getRe() {
		return re;
	}

	/**
	 * Setter of the property <tt>re</tt>
	 * - <tt>re</tt> : real part of the complex number<br><br>
	 * @param re  The re to set.
	 */
	public void setRe(Double re) {
		this.re = re.doubleValue();
	}


	/**
	 * Imaginary part of the Complex class
	 * Complex class의 허수부
	 */
	protected double im;


	/**
	 * Getter of the property <tt>im</tt><br>
	 * - <tt>im</tt> : imaginary part of the complex number<br><br>
	 * 복소수의 허수부 <tt>im</tt> 가져오기<br>
	 *  - <tt>im</tt> : 복소수의 허수부<br>
	 * @return  Returns the im.
	 */
	public double getIm() {
		return im;
	}

	/**
	 * Setter of the property <tt>im</tt><br>
	 * - <tt>im</tt> : imaginary part of the complex number<br><br>
	 * 복소수의 허수부 <tt>im</tt> 설정<br>
	 * - <tt>im</tt> : 복소수의 허수부<br>
	 * @param im  The im to set.
	 */
	public void setIm(Double im) {
		this.im = im.doubleValue();
	}

		
	/**
	 * Setter of the property <tt>re</tt> and <tt>im</tt><br>
	 * - <tt>re</tt> : real part of the complex number<br>
	 * - <tt>im</tt> : imaginary part of the complex number<br><br>
	 * 복소수의 실수부<tt>re</tt>와 허수부  <tt>im</tt> 설정<br>
	 * - <tt>re</tt> : 복소수의 실수부<br>
	 * - <tt>im</tt> : 복소수의 허수부<br>
	 
	 * @param re  The re to set
	 * @param im  The im to set.
	 */
	public void set(Double re, Double im){
		this.re = re.doubleValue();
		this.im = im.doubleValue(); 
	}

			
	/**
	 * Default constructor;
	 */
	public Complex(){
		this.re = 0.0;
		this.im = 0.0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Complex) {
			if(((Complex)obj).getRe() ==  this.re && ((Complex)obj).getIm() == this.im)
				return true;
			else 
				return false;
		}
		return false;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(this.im < 0)
			return "(" + this.re + "-" + (-this.im) + "i)";
		else
			return "(" + this.re + "+" + this.im + "i)";
	}

	/**
	 * calculate absolute number of the complex number.<br>
	 * 복소수의 절대값 계산.<br>
	 * @return absolute number<br>
	 * 절대값
	 */
	public Object abs() {
		return Math.sqrt((this.re * this.re) + (this.im * this.im));
	}


			
	/**
	 * calculate conjugate complex number<br><br>
	 * 켤레복소수 계산.<br>
	 * @return conjugate complex number<br>
	 * 켤레복소수 클래스
	 */
	public Complex conj(){
		Complex result = new Complex(this.re, -this.im);
		
		return result; 
	}

		
	/**
	 * set Complex with real and imaginary parts.
	 * 별도의 Complex를 설정하지 않고 복소수를 설정
	 */
	public static Complex setComplex(Double re, Double im){
		Complex result = new Complex(re, im);
		return result;
	}

			
	/**
	 * minus number of the Complex class
	 * (this Complex class) * (-1)
	 */
	public Complex diff(){
		return Complex.setComplex(-this.re, -this.im);
	}

				
	/**
	 * 1/(this Complex class)
	 */
	public Object inv(){
		double df = this.re * this.re + this.im * this.im;
		Complex result = this.conj();
		result = (Complex)result.div(df);
		return result;
	}
		
}
