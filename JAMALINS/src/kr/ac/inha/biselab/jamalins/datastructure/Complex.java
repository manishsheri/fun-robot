/**
 * 
 */
package kr.ac.inha.biselab.jamalins.datastructure;

/**
 * @author Hyeon-min Shim
 *
 */
public class Complex {
	/**
	 * Complex number is described as (re) + j(im). re is real part of the complex number, and im is imagenary part.
	 */
	double re;
	double im;
	
	/**
	 * Constructor
	 */
	Complex() {
		this.re = 0.0;
		this.im = 0.0;
	}
	
	Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	Complex(Complex c) {
		this.re = c.re;
		this.im = c.im;
	}

	/**
	 * @return the re
	 */
	public double getRe() {
		return re;
	}

	/**
	 * @param re the re to set
	 */
	public void setRe(double re) {
		this.re = re;
	}

	/**
	 * @return the im
	 */
	public double getIm() {
		return im;
	}

	/**
	 * @param im the im to set
	 */
	public void setIm(double im) {
		this.im = im;
	}

	/**
	 * @param re the re to set;
	 * @param im the im to set;
	 */
	public void setReIm(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	/**
	 * conj()
	 * return conjugate number.
	 */
	public Complex conj() {
		Complex result = new Complex(this.re, -this.im);
		return result;
	}
	
	/**
	 * Add this number and a complex number and assign to the other complex number 
	 * Usage:
	 * cresult = c1.addTo(c2);
	 * cresult, c1, c2 are complex number;
	 * cresult = c1 + c2;
	 */
	public Complex addTo(Complex c) {
		Complex cresult = new Complex();
		cresult.setReIm(this.re + c.getRe(), this.im + c.getIm());
		return cresult;
	}
	
	/**
	 * Add two complex numbers and assign to this complex number 
	 * Usage:
	 * cresult.add(c1, c2);
	 * cresult, c1, c2 are complex number;
	 * cresult = c1 + c2;
	 */
	public void add(Complex c1, Complex c2) {
		this.re = c1.getRe() + c2.getRe();
		this.im = c1.getIm() + c2.getIm();
	}
	
	/**
	 * Subtract this number and a complex number and assign to the other complex number 
	 * Usage:
	 * cresult = c1.subTo(c2);
	 * cresult, c1, c2 are complex number;
	 * cresult = c1 - c2;
	 */
	public Complex subTo(Complex c) {
		Complex cresult = new Complex();
		cresult.setReIm(this.re - c.getRe(), this.im - c.getIm());
		return cresult;
	}
	
	/**
	 * Subtract two complex numbers and assign to this complex number 
	 * Usage:
	 * cresult.sub(c1, c2);
	 * cresult, c1, c2 are complex number;
	 * cresult = c1 - c2;
	 */
	public void sub(Complex c1, Complex c2) {
		this.re = c1.getRe() - c2.getRe();
		this.im = c1.getIm() - c2.getIm();
	}
	
	/**
	 * Multiply this number and a complex number and assign to the other complex number 
	 * Usage:
	 * cresult = c1.mulTo(c2);
	 * cresult, c1, c2 are complex number;
	 * cresult = c1 * c2;
	 */
	public Complex mulTo(Complex c) {
		Complex cresult = new Complex();
		cresult.setRe(this.re * c.getRe() - this.im * c.getIm());
		cresult.setIm(this.re * c.getIm() + this.im * c.getRe());
		return cresult;
	}
	
	/**
	 * Multiply two complex numbers and assign to this complex number 
	 * Usage:
	 * cresult.add(c1, c2);
	 * cresult, c1, c2 are complex number;
	 * cresult = c1 * c2;
	 */
	public void mul(Complex c1, Complex c2) {
		this.re = c1.getRe() * c2.getRe() - c1.getIm() * c2.getIm();
		this.im = c1.getRe() * c2.getIm() + c1.getIm() * c2.getRe();
	}
	
	/**
	 * Divide this number by a complex number and assign to the other complex number 
	 * Usage:
	 * cresult = c1.divTo(c2);
	 * cresult, c1, c2 are complex number;
	 * cresult = c1 / c2;
	 */
	public Complex divTo(Complex c) {
		Complex cresult = new Complex();
		Complex cconj = c.conj();
		Complex cden = new Complex();
		cden.mul(c, cconj);
		double re;
		double im;
		try {
			re = (this.re * cconj.getRe() - this.im * cconj.getIm()) / cden.getRe();
			im = (this.re * cconj.getIm() + this.im * cconj.getRe()) / cden.getRe();
			
			cresult.setRe(re);
			cresult.setIm(im);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cresult;
	}
	
	/**
	 * Divide first complex number by second complex number and assign to this complex number 
	 * Usage:
	 * cresult.div(c1, c2);
	 * cresult, c1, c2 are complex number;
	 * cresult = c1 / c2;
	 */
	public void div(Complex c1, Complex c2) {
		Complex cconj = c2.conj();
		Complex cden = new Complex();
		cden.mul(c2, cconj);
		
		try {
			this.re = (c1.getRe() * cconj.getRe() - c1.getIm() * cconj.getIm())/cden.getRe();
			this.im = (c1.getRe() * cconj.getIm() + c1.getIm() * cconj.getRe())/cden.getRe();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[(" + re + ") +  j(" + im + ")]";
	}
	
	
}
