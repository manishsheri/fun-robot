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
	
	public VectoC(int size) {
		super();
		this.size = size;
	}

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}



	/**
	 * Getter of the property <tt>size</tt>
	 * @return  Returns the size.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Setter of the property <tt>size</tt>
	 * @param size  The size to set.
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Getter of the property <tt>element</tt>
	 * @return  Returns the element.
	 */
	public Complex[] getElement() {
		return element;
	}

	/**
	 * Setter of the property <tt>element</tt>
	 * @param element  The element to set.
	 */
	public void setElement(Complex[] element) {
		this.element = element;
	}
}
