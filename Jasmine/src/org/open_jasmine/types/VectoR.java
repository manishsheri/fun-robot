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

import org.open_jasmine.operators.Op;


/**
 * @author elecage@gmail.com
 *
 */
public class VectoR implements Cloneable, java.io.Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 7179653000794622792L;
	/**
	 * @uml.property  name="size"
	 */
	protected int 		size;
	/**
	 * @uml.property  name="element"
	 */
	protected double[] 	element;
	
	public VectoR() {
		this.size = Op.DEFAULT_VECTOR_SIZE;
		this.element = new double[this.size];
		int i;
		
		for(i = 0 ; i < this.size ; i++)
			this.element[i] = 0.0;
	}
	
	public VectoR(double[] element) {
		this.size = element.length;
		this.element = element;
	}

	public VectoR(int size) {
		super();
		this.size = size;
		this.element = new double[size];
		int i;
		
		for(i = 0 ; i < this.size ; i++)
			this.element[i] = 0.0;
	}
		
	public VectoR(int size, double d) {
		int i;
		
		this.size = size;
		this.element = new double[size];
			
		for(i = 0 ; i < size ; i++) {
			element[i] = d;
		}
	}
		
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
				return super.clone();
	}
		
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		int i;
		if (obj instanceof VectoR) {
			VectoR v = (VectoR) obj;

			if(this.size == v.getSize()) {
				
				for(i = 0 ; i < this.size ; i++) {
					if(this.element[i] != v.getElement(i))
						return result;
				}
				result = true;
			}
		}

		return result;
	}
		
	/**
	 * @return
	 * @uml.property  name="element"
	 */
	public double[] getElement() {
		return element;
	}
		
	public double getElement(int index) {
		try {
			return element[index];
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}
	
	public double[] getElement(int is, int ie) {
		try {
			if(this.size < ie)
				throw new Exception();
			int resultSize = ie - is + 1;
			int i;
			double[] result = new double[resultSize];
			
			for(i = 0 ; i < resultSize ; i++)
				result[i] = this.getElement(i + is);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public double[] getElementCopy() {
		double[] result = new double[this.size];
		int i;
		
		for(i = 0 ; i < this.size ; i++)
			result[i] = this.element[i];
		return result;
	}
	/**
	 * @return
	 * @uml.property  name="size"
	 */
	public int getSize() {
		return this.size;
	}
	public VectoR getSubVector(int is, int ie) {

		VectoR result = new VectoR(ie-is+1);
		double[] d = this.getElement(is, ie);
			
		if(d != null) {
			result = new VectoR(d);
		}
		return result;
	}	
	

	public double norm() {
		return norm(2.0);
	}
	
	public double norm(Double r){
		try {
			if (r.doubleValue() == 0.0)
				throw new Exception();
			double result = 0;
			int i;
			
			if(r == Double.POSITIVE_INFINITY) {
				result = Math.abs(this.element[0]);
				for(i = 1 ; i < this.size ; i++)
					result = result < Math.abs(this.element[i]) ? Math.abs(this.element[i]) : result;
			}
			else if(r == Double.NEGATIVE_INFINITY) {
				result = Math.abs(this.element[0]);
				for(i = 1 ; i < this.size ; i++)
					result = result > Math.abs(this.element[i]) ? Math.abs(this.element[i]) : result;
			}
			else if(r.intValue() == 1) {
				for(i = 0 ; i < this.size ; i++)
					result += Math.abs(this.element[i]);
			}
			else if(r.intValue() == 2) {
				for(i = 0 ; i < this.size ; i++)
					result += this.element[i] * this.element[i];
				result = Math.sqrt(result);
			}
			else {
				for(i = 0 ; i < this.size ; i++)
					result += Math.pow(this.element[i], r.doubleValue());
				result = Math.pow(result, 1.0/r.doubleValue());
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return Double.POSITIVE_INFINITY;
		}		
	}
	
	/**
	 * @param  d
	 * @uml.property  name="element"
	 */
	public void setElement(double[] element) {
		this.size = element.length;
		this.element = element;
	}
	
	public void setElement(int index, double d) {
			
		try {
			element[index] = d;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setElement(int index, double[] d) {
		try {
			int i;
			
			if((this.size - index) < d.length) {
				VectoR vtemp = new VectoR(index);
				for( i = 0 ; i < index ; i++)
					vtemp.setElement(i, this.getElement(i));
				this.element = new double[d.length];
				this.size = d.length;
			}			
			
			for(i = index ; i < this.size ; i++ )
				this.element[i] = d[i-index];
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setElement(int index, VectoR v) {
		setElement(index, v.getElement());
	}
	
	/**
	 * @param size
	 * @uml.property  name="size"
	 */
	public void setSize(int size) {
		this.size = size;
		this.element = new double[size];
	}

	@Override
	public String toString() {
		String str="[";
		int i;
		str += this.element[0];
		for(i = 1 ; i < this.size ; i++) {
			str += "\t";
			str += this.element[i];
		}
		str += "]";
		return str;
	}
}
