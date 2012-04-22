/*
 * Copyright (c) <2012> <Hyeon-min.shim(elecage@gmail.com)>
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
/**
 * @author elecage@gmail.com
 *
 */
package org.open_jasmin.types;


public class Complex extends Object implements Cloneable {
	/**
	 * @uml.property  name="re"
	 */
	protected double re;
	/**
	 * @uml.property  name="im"
	 */
	protected double im;

	public Complex() {
		super();
		re = 0.0;
		im = 0.0;
	}

	public Complex(double re, double im) {
		super();
		this.re = re;
		this.im = im;
	}

	public double abs() {
		return Math.sqrt(re * re + im * im);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public Complex conj() {
		Complex result = new Complex(this.re, -this.im);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof Complex) {
			Complex s = (Complex) obj;

			if ((s.getRe() == this.re) && (s.getIm() == this.im))
				result = true;
		}

		return result;
	}

	/**
	 * @return
	 * @uml.property  name="im"
	 */
	public double getIm() {
		return im;
	}

	/**
	 * @return
	 * @uml.property  name="re"
	 */
	public double getRe() {
		return re;
	}

	public void set(double re, double im) {
		this.re = re;
		this.im = im;
	}

	/**
	 * @param im
	 * @uml.property  name="im"
	 */
	public void setIm(double im) {
		this.im = im;
	}

	/**
	 * @param re
	 * @uml.property  name="re"
	 */
	public void setRe(double re) {
		this.re = re;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(this.im >= 0)
			return "(" + this.re + "+" + this.im + "i)";
		else
			return "(" + this.re + "-" + Math.abs(this.im) + "i)";
	}
	
	public void fromPolar(Polar p) {
		double re = p.getR();
		double im = p.getTheta();
		this.re = re * Math.cos(im);
		this.im = re * Math.sin(im);
	}
	
	public Polar toPolar() {
		Polar p = new Polar();
		double theta = 0;
		p.setR(Math.sqrt(this.re * this.re + this.im * this.im));
		
		if(this.re > 0 && this.im >= 0) {
			theta = Math.atan2(this.im, this.re);
		}
		else if(this.re > 0 && this.im < 0) {
			theta = Math.atan2(this.im, this.re) + 2 * Math.PI;
		}
		else if(re < 0) {
			theta = Math.atan2(this.im, this.re) + Math.PI;
		}
		else if(re == 0 && im > 0) {
			theta = Math.PI / 2.0;
		}
		else if(re == 0 && im < 0) {
			theta = 3.0 * Math.PI / 2.0;
		}
		while(theta > Math.PI)
			theta -= Math.PI;
		while(theta < 0)
			theta += Math.PI;
		
		p.setTheta(theta);
		
		return p;
	}
}
