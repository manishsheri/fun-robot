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

package org.robot_jasmine.types;


/**
 * @author elecage@gmail.com
 *
 */
public class VectoR implements Cloneable, java.io.Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 7179653000794622792L;
	protected int 		size;
	protected double[] 	element;
	
	public VectoR(int size) {
		super();
		this.size = size;
		this.element = new double[size];
	}

	public VectoR(double[] element) {
		super();
		this.size = element.length;
		this.element = element;
	}
		
	public VectoR(int size, double d) {
		int i;
		
		this.size = size;
		this.element = new double[size];
			
		for(i = 0 ; i < size ; i++) {
			element[i] = d;
		}
	}
		
	public int getSize() {
		return this.size;
	}
		
	public double[] getElement() {
		return element;
	}
		
	public double getElement(int index) {
		try {
			return element[index];
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
	}
		
	public void setElement(int index, double d) {
			
		try {
			element[index] = d;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void setElement(int index, double[] d) {
		try {
			int i;
			
			if((this.size - index) < d.length) {
				VectoR vtemp = new VectoR(index);
				for( i = 0 ; i < index ; i++)
			}
			
			
			for(i = index ; i < this.size ; i++ )
				this.element[i] = d[i-index];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setElement(int index, VectoR v) {
		setElement(index, v.getElement());
	}
	
	public void setElement(double[] d) {
		int i;
		
		if(this.size < d.length) {
			this.size = d.length;
			this.element = new double[d.length];
		}
		for(i = 0 ; i < d.length ; i++)
			this.element[i] = d[i];	
	}
	public VectoR plus(VectoR v) {
		int i;
		
		try {
			if(this.size != v.getSize())
				 throw new Exception();
			VectoR result = new VectoR(this.size);
			
			for(i = 0 ; i < this.size ; i++)
				result.setElement(i, this.element[i] + v.getElement(i));
			
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
}
