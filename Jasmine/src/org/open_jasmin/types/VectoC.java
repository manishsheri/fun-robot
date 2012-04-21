package org.open_jasmin.types;

import org.open_jasmin.operators.Op;


public class VectoC implements Cloneable, java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1086431830686010196L;
	/**
	 * @uml.property  name="size"
	 */
	protected int size;
	/**
	 * @uml.property  name="element"
	 */
	protected Complex[] element;
	
	public VectoC() {
		this.size = Op.DEFAULT_VECTOR_SIZE;
		this.element = new Complex[this.size];
		int i;
		
		for(i = 0 ; i < this.size ; i++)
			this.element[i] = new Complex(0.0, 0.0);
	}

	public VectoC(Complex[] element) {
		this.size = element.length;
		this.element = element;
	}

	public VectoC(int size) {
		super();
		this.size = size;
	}

	public VectoC(int size, Complex c) {
		this.size = size;
		int i;
		
		for(i = 0 ; i < size ; i++) 
			this.element[i].set(c.getRe(), c.getIm());
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	/**
	 * Getter of the property <tt>element</tt>
	 * @return   Returns the element.
	 * @uml.property  name="element"
	 */
	public Complex[] getElement() {
		return element;
	}



	/**
	 * Getter of the property <tt>element</tt>
	 * @return  Returns the element of index.
	 */
	public Complex getElement(int index) {
		try {
			return element[index];
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Getter of the property <tt>element</tt>
	 * @return  Returns the element.
	 */
	public Complex[] getElement(int is, int ie) {
		try {
			if(this.size < ie)
				throw new Exception();
			int resultSize = ie - is + 1;
			int i;
			Complex[] result = new Complex[resultSize];
			
			for(i = 0 ; i < resultSize ; i++)
				result[i] = this.getElement(i + is);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Complex[] getElementCopy() {
		Complex[] result = new Complex[this.size];
		int i;
		
		for(i = 0 ; i < this.size ; i++) {
			result[i].setRe(this.element[i].getRe());
			result[i].setIm(this.element[i].getIm());
		}
		return result;
	}
	
	/**
	 * Getter of the property <tt>size</tt>
	 * @return   Returns the size.
	 * @uml.property  name="size"
	 */
	public int getSize() {
		return size;
	}

	public VectoC getSubVector(int is, int ie) {

		VectoC result = new VectoC(ie-is+1);
		Complex[] d = this.getElement(is, ie);
			
		if(d != null) {
			result = new VectoC(d);
		}
		return result;
	}
	
	public double norm(Double r){
		try {
			if (r.doubleValue() == 0.0)
				throw new Exception();
			double result = 0;
			int i;
			
			if(r == Double.POSITIVE_INFINITY) {
				result = this.element[0].abs();
				for(i = 1 ; i < this.size ; i++)
					result = result < this.element[i].abs() ? this.element[i].abs() : result;
			}
			else if(r == Double.NEGATIVE_INFINITY) {
				result = this.element[0].abs();
				for(i = 1 ; i < this.size ; i++)
					result = result > this.element[i].abs() ? this.element[i].abs() : result;
			}
			else if(r.intValue() == 1) {
				for(i = 0 ; i < this.size ; i++)
					result += this.element[i].abs();
			}
			else if(r.intValue() == 2) {
				for(i = 0 ; i < this.size ; i++)
					result = result + Op.times(this.element[i], this.element[i]).abs();
				result = Math.sqrt(result);
			}
			else {
				// TODDO : 복소벡터의 노름
	/*			for(i = 0 ; i < this.size ; i++)
					result += Math.pow(this.element[i], r.doubleValue());
				result = Math.pow(result, 1.0/r.doubleValue());
				*/
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return Double.POSITIVE_INFINITY;
		}		
	}
	
	public double norm() {
		return norm(2.0);
	}
	/**
	 * Setter of the property <tt>element</tt>
	 * @param element   The element to set.
	 * @uml.property  name="element"
	 */
	public void setElement(Complex[] element) {
		this.size = element.length;
		this.element = element;
	}	
	
	public void setElement(int index, Complex c) {
		
		try {
			element[index] = c;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setElement(int index, Complex[] c) {
		try {
			int i;
			
			if((this.size - index) < c.length) {
				VectoC vtemp = new VectoC(index);
				for( i = 0 ; i < index ; i++)
					vtemp.setElement(i, this.getElement(i));
				this.element = new Complex[c.length];
				this.size = c.length;
			}			
			
			for(i = index ; i < this.size ; i++ )
				this.element[i] = c[i-index];
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setElement(int index, VectoC v) {
		setElement(index, v.getElement());
	}
	
	/**
	 * Setter of the property <tt>size</tt>
	 * @param size   The size to set.
	 * @uml.property  name="size"
	 */
	public void setSize(int size) {
		this.size = size;
		this.element = new Complex[size];
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
