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
package org.open_jasmine.types;

public class Polar {
	protected double r;
	protected double theta;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof Polar) {
			Polar s = (Polar) obj;

			if ((s.getR() == this.r) && (s.getTheta() == this.theta))
				result = true;
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.r + "¡Ð" + this.theta;
	}

	public Polar() {
		r = 0.0;
		theta = 0.0;
	}
	
	public Polar(double r, double theta) {
		this.r = r;
		this.theta = theta;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}
	
	public void set(double r, double theta) {
		this.r = r;
		this.theta = theta;
	}
	
	public Complex toComplex() {
		Complex result = new Complex();
		result.set(this.r * Math.cos(this.theta), this.r * Math.sin(this.theta));
		return result;
	}
	
	public void fromComplex(Complex c) {
		double re = c.getRe();
		double im = c.getIm();
		this.r = Math.sqrt(re * re + im * im);
		if(re > 0 && im >= 0) {
			theta = Math.atan2(im, re);
		}
		else if(re > 0 && im < 0) {
			theta = Math.atan2(im, re) + 2 * Math.PI;
		}
		else if(re < 0) {
			theta = Math.atan2(im, re) + Math.PI;
		}
		else if(re == 0 && im > 0) {
			theta = Math.PI / 2.0;
		}
		else if(re == 0 && im < 0) {
			theta = 3.0 * Math.PI / 2.0;
		}
		else ;
		while(theta > Math.PI)
			theta -= Math.PI;
		while(theta < 0)
			theta += Math.PI;
	}
}
