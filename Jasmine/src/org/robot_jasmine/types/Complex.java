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
package org.robot_jasmine.types;

import java.math.*;

public class Complex extends Object implements Cloneable {
	protected double re;
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

	public Complex div(Complex m) {
		// Complex result = new Complex();
		double mRe = m.getRe();
		double mIm = m.getIm();
		double denom = mRe * mRe + mIm * mIm;

		Complex result = this.mul(m.conj());
		result.set(result.getRe() / denom, result.getIm() / denom);

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

	public double getIm() {
		return im;
	}

	public double getRe() {
		return re;
	}

	public Complex minus(Complex m) {
		Complex result = new Complex(this.re - m.getRe(), this.im - m.getIm());

		return result;
	}

	public Complex mul(Complex m) {
		Complex result = new Complex(this.re * m.getRe() - this.im * m.getIm(),
				this.re * m.getIm() + this.im * m.getRe());

		return result;
	}

	public Complex mul(double d) {
		Complex result = new Complex(d * this.re, d * this.im);

		return result;
	}

	public Complex plus(Complex m) {
		Complex result = new Complex(this.re + m.getRe(), this.im + m.getIm());

		return result;
	}

	public void set(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public void setIm(double im) {
		this.im = im;
	}

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
		return this.re + " + " + this.im + "i";
	}
}
