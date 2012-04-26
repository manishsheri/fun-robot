
package org.openjasmine.types;


/**
 * @author Hyeon-min.Shim(elecage@gmail.com)
 */
public class Complex implements Operation {

	
	/**
	 * add this complex and the other number
	 * @param obj number to add. 
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
	 * subtract a number from this complex  
	 * @param obj number to add(complex or real(double)). 
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
	 * Constructor
	 * @param re The re to set
	 * @param im The im to set
	 */
	public Complex(Double re, Double im){
		this.re = re.doubleValue();
		this.im = im.doubleValue();
	}


	/**
	 * @uml.property  name="re"
	 */
	protected double re;


	/**
	 * Getter of the property <tt>re</tt>
	 * @return  Returns the re.
	 * @uml.property  name="re"
	 */
	public double getRe() {
		return re;
	}

	/**
	 * Setter of the property <tt>re</tt>
	 * - <tt>re</tt> : real part of the complex number<br><br>
	 * @param re  The re to set.
	 * @uml.property  name="re"
	 */
	public void setRe(Double re) {
		this.re = re.doubleValue();
	}


	/**
	 * @uml.property  name="im"
	 */
	protected double im;


	/**
	 * Getter of the property <tt>im</tt><br>
	 * - <tt>im</tt> : imaginary part of the complex number<br><br>
	 * <tt>im</tt> 가져오기<br>
	 *  - <tt>im</tt> : 복소수의 허수부<br>
	 * @return  Returns the im.
	 * @uml.property  name="im"
	 */
	public double getIm() {
		return im;
	}

	/**
	 * Setter of the property <tt>im</tt><br>
	 * - <tt>im</tt> : imaginary part of the complex number<br><br>
	 * 속성 <tt>im</tt> 설정<br>
	 * - <tt>im</tt> : 복소수의 허수부<br>
	 * @param im  The im to set.
	 * @uml.property  name="im"
	 */
	public void setIm(Double im) {
		this.im = im.doubleValue();
	}

		
	/**
	 * Setter of the property <tt>re</tt> and <tt>im</tt><br>
	 * - <tt>re</tt> : real part of the complex number<br>
	 * - <tt>im</tt> : imaginary part of the complex number<br><br>
	 * 속성 <tt>re</tt>와 <tt>im</tt> 설정<br>
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
	 * 복소수의 절대값을 계산한다.<br>
	 * @return absolute number<br>
	 * 절대값  
	 */
	public Object abs() {
		return Math.sqrt((this.re * this.re) + (this.im * this.im));
	}


			
	/**
	 * calculate conjugate complex number<br><br>
	 * 켤레복소수를 계산한다.<br>
	 * @return conjugate complex number<br>
	 * 켤레복소수
	 */
	public Complex conj(){
		Complex result = new Complex(this.re, -this.im);
		
		return result; 
	}

		
		/**
		 */
		public static Complex getComplex(Double re, Double im){
			Complex result = new Complex(re, im);
			return result;
		}

			
	/**
	 */
	public Complex diff(){
		return Complex.getComplex(-this.re, -this.im);
	}

				
	/**
	 */
	public Object inv(){
		double df = this.re * this.re + this.im * this.im;
		Complex result = this.conj();
		result = (Complex)result.div(df);
		return result;
	}
		
}
