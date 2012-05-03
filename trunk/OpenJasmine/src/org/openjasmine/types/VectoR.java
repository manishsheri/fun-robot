package org.openjasmine.types;

import org.openjasmine.exception.VectorSizeMismatchException;

/**
 * Vector class
 * @filename VectoR.java
 * @author Hyeon-min.Shim(elecage@gmail.com)
 */

public class VectoR implements Operation, Cloneable {

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof VectoR) {
			if(((VectoR)obj).getSize() == this.size) {
				int i;
				for(i = 0 ; i < this.size ; i++) {
					if(this.element[i] != ((VectoR)obj).getElement(i))
						return false;
				}
				return true;
			}
			return false;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/** 
	 * elements of the VectoR class
	 */
	protected Object[] element;

	/**
	 * sizeof VectoR
	 */
	protected int size;

	/**
	 * Constructor with setting size
	 * @param size
	 */
	public VectoR(int size) {
		super();
		this.size = size;
		element = new Object[size];
	}

	/**
	 * Constructor with setting element
	 * @param element
	 */
	public VectoR(Object[] element) {
		super();
		this.element = element;
		this.size = this.element.length;
	}

	@Override
	/**
	 * Calculate absolute value
	 */
	public Object abs() {
		Object result = new Double[this.size];;
		int size = this.element.length;;
		/**
		 * when element is Complex
		 */
		if(this.element instanceof Complex[]) {
			for(int i = 0 ; i < size ; i++) {
				((Double[])result)[i] = (Double)(((Complex[])element)[i].abs());
			}
			
		}
		/**
		 * when element is Double
		 */
		else if(this.element instanceof Double[]) {
			for(int i = 0 ; i < size ; i++) {
				((Double[])result)[i] = (Double)(Math.abs(((Double[])element)[i]));
			}
		}
		/**
		 * when element is VectoR
		 */
		/*
		else if(this.element instanceof VectoR[]) {
			
		}
		*/
		return result;
	}

	/**
	 * Calculate cross product
	 * @param operand
	 * @return corss product result
	 */
	public VectoR cross(VectoR rhs) {
		Complex mtemp1 = new Complex(0., 0.);
		Complex mtemp2 = new Complex(0., 0.);
		try {
			if(this.size != 3 || rhs.getSize() != 3)
				throw new VectorSizeMismatchException();
			VectoR result = new VectoR(3);
			
			if(this.element instanceof Complex[]) {
				
				mtemp1 = (Complex) ((Complex)this.element[1]).times(rhs.getElement(2));
				mtemp2 = (Complex) ((Complex)this.element[2]).times(rhs.getElement(1));
				result.setElement(0, mtemp1.minus(mtemp2));
				
				mtemp1 = (Complex) ((Complex)this.element[2]).times(rhs.getElement(0));
				mtemp2 = (Complex) ((Complex)this.element[0]).times(rhs.getElement(2));
				result.setElement(1, mtemp1.minus(mtemp2));
				
				mtemp1 = (Complex) ((Complex)this.element[0]).times(rhs.getElement(1));
				mtemp2 = (Complex) ((Complex)this.element[1]).times(rhs.getElement(0));
				result.setElement(2, mtemp1.minus(mtemp2));
				
			}
			else if(this.element instanceof Double[]) {
				Object[] o = rhs.getElement();
				double dtemp1, dtemp2;
				if(o instanceof Double[]) {			
				
					dtemp1 = ((Double)this.element[1]).doubleValue() * ((Double)rhs.getElement(2)).doubleValue();
					dtemp2 = ((Double)this.element[2]).doubleValue() * ((Double)rhs.getElement(1)).doubleValue();
					result.setElement(0, dtemp1 - dtemp2);
					
					dtemp1 = ((Double)this.element[2]).doubleValue() * ((Double)rhs.getElement(0)).doubleValue();
					dtemp2 = ((Double)this.element[0]).doubleValue() * ((Double)rhs.getElement(2)).doubleValue();
					result.setElement(1, dtemp1 - dtemp2);
					
					dtemp1 = ((Double)this.element[0]).doubleValue() * ((Double)rhs.getElement(1)).doubleValue();
					dtemp2 = ((Double)this.element[1]).doubleValue() * ((Double)rhs.getElement(0)).doubleValue();
					result.setElement(2, dtemp1 - dtemp2);
				}
				else if(o instanceof Complex[]) {
					mtemp1 = (Complex) ((Complex)o[2]).times(this.element[1]);
					mtemp2 = (Complex) ((Complex)o[1]).times(this.element[2]);
					result.setElement(0, mtemp1.minus(mtemp2));
					
					mtemp1 = (Complex) ((Complex)o[0]).times(this.element[2]);
					mtemp2 = (Complex) ((Complex)o[2]).times(this.element[0]);
					result.setElement(1, mtemp1.minus(mtemp2));
					
					mtemp1 = (Complex) ((Complex)o[1]).times(this.element[0]);
					mtemp2 = (Complex) ((Complex)o[0]).times(this.element[1]);
					result.setElement(2, mtemp1.minus(mtemp2));
				}
			}
			return result;
		} catch (VectorSizeMismatchException e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object div(Object obj) {
		int i;
		VectoR result = new VectoR(this.size);
		if(obj instanceof VectoR) {
			try {
				if(this.size != ((VectoR)obj).getSize())
					throw new VectorSizeMismatchException();
				
				Object temp;
				Object[] o =  ((VectoR)obj).getElement();
				if(this.element instanceof Complex[]) {
					if(o instanceof Complex[]) {
						for(i = 0 ; i < this.size ; i++) {
							temp = ((Complex)((VectoR)obj).getElement(i)).inv();
							result.setElement(i, ((Complex[])this.element)[i].times(temp));
						}
					}
					else if(o instanceof Double[]) {
						for(i = 0 ; i < this.size ; i++) {
							double retemp, imtemp;
							retemp = ((Double)((Complex)this.element[i]).getRe()).doubleValue() /((Double)o[i]).doubleValue();
							imtemp = ((Double)((Complex)this.element[i]).getIm()).doubleValue() /((Double)o[i]).doubleValue();
							result.setElement(i, Complex.setComplex(retemp, imtemp));							
						}
					}
				}
				else if(this.element instanceof Double[]){
					
					if( o instanceof Complex[]) {
						for(i = 0 ; i < this.size ; i++) {
							temp = ((Complex)((VectoR)obj).getElement(i)).inv();
							result.setElement(i, ((Complex)temp).times(this.element[i]));
						}
					}
					else if(this.element instanceof Double[]) {
						for(i = 0 ; i < this.size ; i++)
							result.setElement(i, (Double)this.element[i] / (Double)((VectoR)obj).getElement(i));
					}
				}
	
				return (Object)result;
			} catch (VectorSizeMismatchException e) {
	
				e.printStackTrace();
				return null;
			}
		}
		else if (obj instanceof Complex) {
			Complex c;
			for(i = 0 ; i < this.size ; i++) {
				c = (Complex)((Complex)((Complex)obj).div(this.element[i])).inv();
				result.setElement(i, c);
			}
			
			return result;
		}
		else if(obj instanceof Double) {
			if(this.element instanceof Complex[]) {
				Complex c;
				for(i = 0 ; i < this.size ; i++) {
					c = (Complex)((Complex)this.element[i]).div(obj);
					result.setElement(i, c);
				}
			}
			else if(this.element instanceof Double[]) {
				for(i = 0 ; i < this.size ; i++) {
					result.setElement(i, ((Double)this.element[i]).doubleValue() / ((Double)obj).doubleValue());
				}
			}
			return result;			
		}
		
		return null;
	}

	/**
	 * Calculate dot product
	 * @param v operand
	 * @return dot product result(scalar)
	 */
	public Object dot(VectoR v){
		Object result = null;;
		int i;
		
		try {
			if(this.size != v.getSize())
				throw new VectorSizeMismatchException();
			Object[] obj = v.getElement();
			Object temp;
			if(this.element instanceof Complex[]) {
				result = new Complex(0.0, 0.0);
				
				if(obj instanceof Complex[]) {
					for(i = 0 ; i < this.size ; i++) {
						temp = (((Complex[])this.element)[i]).times(((Complex[])obj)[i].conj());
						result = ((Complex)result).plus(temp);
					}
				}
				else if(obj instanceof Double[]) {
					for(i = 0 ; i < this.size ; i++) {
						temp = (((Complex[])this.element)[i]).times(((Double[])obj)[i]);
						result = ((Complex)result).plus(temp);
					}
				}
				result = ((Complex)result).conj();
				
			}
			else if(this.element instanceof Double[]) {
				if(obj instanceof Complex[]) {
					result = new Complex(0.0, 0.0);
					for(i = 0 ; i < this.size ; i++) {
						temp = (((Complex) ((Complex)obj[i])).conj()).times(((Double[])this.element)[i]);
						result = ((Complex)result).plus(temp);
					}
					result = ((Complex)result).conj();
				}
				else if(obj instanceof Double[]) {
					result = new Double(0.0);
	
					for(i = 0 ; i < this.size ; i++) {
						temp = ((Double)this.element[i]).doubleValue() * ((Double)obj[i]).doubleValue();
						result = ((Double)result).doubleValue() + ((Double)temp).doubleValue(); 
					}
				}
			}
			
			return result;
		} catch (VectorSizeMismatchException e) {
			e.printStackTrace();
			return null;
		}
	}

	/** 
	 * Getter of the property <tt>element</tt>
	 * @return  Returns the element.
	 */
	public Object[] getElement() {
		return element;
	}

	public Object getElement(int index) {
		return element[index];
	}

	/**
	 * Getter of the property <tt>size</tt>
	 * @return  Returns the size.
	 */
	public int getSize() {
		return size;
	}

	@Override
	public Object minus(Object obj) {
		try {
			if(this.size != ((VectoR)obj).getSize())
				throw new Exception();
	
			int i;
			VectoR result = new VectoR(((VectoR)obj).getSize());
			
			Object temp;
			if(this.element instanceof Complex[]) {
				for(i = 0 ; i < this.size ; i++)
				{
					temp = ((VectoR)obj).getElement(i);
					result.setElement(i, ((Complex[])this.element)[i].minus(temp));
				}
			}
			else if(this.element instanceof Double[]){
				Object o =  ((VectoR)obj).getElement();
				if( o instanceof Complex[]) {
					for(i = 0 ; i < this.size ; i++) {
						temp = ((Complex)((VectoR)obj).getElement(i)).diff();
						result.setElement(i, ((Complex)temp).plus(this.element[i]));
					}
				}
				else if(this.element instanceof Double[]) {
					for(i = 0 ; i < this.size ; i++)
						result.setElement(i, (Double)this.element[i] - (Double)((VectoR)obj).getElement(i));
				}
			}

			return (Object)result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * calculate norm
	 * @return norm result
	 */
	public double norm() {
		return norm(2.0);
	}

	/**
	 * calculate norm with setting power
	 * @param n power
	 * @return norm result
	 */
	public double norm(Double n) {
		double result = 0;
		double temp;
		int i = 0;
		if(this.element instanceof Double[]){		
			
			if(n == Double.POSITIVE_INFINITY) {
				result = Math.abs((Double)this.element[0]);
				for(i = 1 ; i < this.size ; i++) {
					temp = Math.abs((Double)this.element[i]);
					result = result > temp ? result : temp;
				}
			}
			else if(n == Double.NEGATIVE_INFINITY) {
				result = (Double)this.element[0];
				for(i = 1 ; i < this.size ; i++) {
					temp = Math.abs((Double)this.element[i]);
					result = result < temp ? result : temp;
				}
			}
			else if(n.doubleValue() == 1.0) {
				for(i = 0 ; i < this.size ; i++) {
					result = result + Math.abs(((Double)this.element[i]).doubleValue());
				}
			}
			else if(n.doubleValue() == 2.0) {
				for(i = 0 ; i < this.size ; i++) {
					temp = Math.abs(((Double)this.element[i]).doubleValue());
					result = result + temp * temp;
				}
				result = Math.sqrt(result);
			}
			
			else {
				for(i = 0 ; i < this.size ; i++) {
					temp = Math.abs(((Double)this.element[i]).doubleValue());
					result = result + Math.pow(temp, n.doubleValue());
				}
				temp = 1/n.doubleValue();
				result = Math.pow(result, temp);
			}
			
		}
		else if(this.element instanceof Complex[]) {
		
			if(n == Double.POSITIVE_INFINITY) {
				result =(Double) ((Complex)this.element[0]).abs();
				for(i = 1 ; i < this.size ; i++) {
					temp = (Double) ((Complex)this.element[i]).abs();
					result = result > temp ? result : temp;
				}
			}
			else if(n == Double.NEGATIVE_INFINITY) {
				result =(Double) ((Complex)this.element[0]).abs();
				for(i = 1 ; i < this.size ; i++) {
					temp = (Double) ((Complex)this.element[i]).abs();
					result = result < temp ? result : temp;
				}
			}
			else if(n.doubleValue() == 1.0) {
				for(i = 0 ; i < this.size ; i++) {
					temp = (Double) ((Complex)this.element[i]).abs();
					result += temp;
				}
			}
			else if(n.doubleValue() == 2.0) {
				for(i = 0 ; i < this.size ; i++) {
					temp = (Double) ((Complex)this.element[i]).abs();
					result += temp*temp;
				}
				result = Math.sqrt(result);
			}
			
			else {
				result = 0.0;
				for(i = 0 ; i < this.size ; i++) {
					temp = (Double) ((Complex)this.element[i]).abs();
					temp = Math.pow(temp, n.doubleValue());
					result += temp;
				}
				temp = 1.0 / n.doubleValue();
				result = Math.pow(result, temp);
			}
		}
		
		return result;
	}
	@Override
	public Object plus(Object obj) {
		try {
			if(this.size != ((VectoR)obj).getSize())
				throw new VectorSizeMismatchException();
	
			int i;
			VectoR result = new VectoR(((VectoR)obj).getSize());
			
			Object temp;
			if(this.element instanceof Complex[]) {
				for(i = 0 ; i < this.size ; i++)
				{
					temp = ((VectoR)obj).getElement(i);
					result.setElement(i, ((Complex[])this.element)[i].plus(temp));
				}
			}
			else if(this.element instanceof Double[]){
				Object o =  ((VectoR)obj).getElement();
				if( o instanceof Complex[]) {
					for(i = 0 ; i < this.size ; i++) {
						//temp = (Complex)((VectoR)obj).getElement(i);
						temp = (Complex)((VectoR)obj).getElement(i);
						result.setElement(i, ((Complex)temp).plus(this.element[i]));
					}
				}
				else if(this.element instanceof Double[]) {
					for(i = 0 ; i < this.size ; i++)
						result.setElement(i, (Double)this.element[i] + (Double)((VectoR)obj).getElement(i));
				}
			}

			return (Object)result;
		} catch (VectorSizeMismatchException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * set element 
	 * @param index
	 * @param element
	 */
	public void setElement(int index, Object element) {
		this.element[index] = element;
	}

	/** 
	 * Setter of the property <tt>element</tt>
	 * @param element  The element to set.
	 */
	public void setElement(Object[] element) {
		this.element = element;
	}
	/**
	 * Setter of the property <tt>size</tt>
	 * @param size  The size to set.
	 */
	public void setSize(int size) {
		this.size = size;
		this.element = new Object[size];
	}
		
	@Override
	public Object times(Object obj) {
		VectoR result = null;
		int i;
		Object temp;
		if(obj instanceof VectoR) {
			try {
				if(this.size != ((VectoR)obj).getSize())
					throw new Exception();
		
				result = new VectoR(((VectoR)obj).getSize());
				
				
				if(this.element instanceof Complex[]) {
					for(i = 0 ; i < this.size ; i++)
					{
						temp = ((VectoR)obj).getElement(i);
						result.setElement(i, ((Complex[])this.element)[i].times(temp));
					}
				}
				else if(this.element instanceof Double[]){
					Object o =  ((VectoR)obj).getElement();
					if( o instanceof Complex[]) {
						for(i = 0 ; i < this.size ; i++) {
							temp = ((VectoR)obj).getElement(i);
							result.setElement(i, ((Complex)temp).times(this.element[i]));
						}
					}
					else if(this.element instanceof Double[]) {
						for(i = 0 ; i < this.size ; i++)
							result.setElement(i, (Double)this.element[i] * (Double)((VectoR)obj).getElement(i));
					}
				}
	
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		else if(obj instanceof Double) {
			result = new VectoR(this.size);
			if(this.element instanceof Double[]) {
				for(i = 0 ; i < this.size ; i++) {
					result.setElement(i, ((Double)obj).doubleValue() * ((Double)this.element[i]).doubleValue());
				}
			}
			else if(this.element instanceof Complex[]) {
		
				for(i = 0 ; i < this.size ; i++) {
					temp = ((Complex)this.element[i]).times((Double)obj);
					result.setElement(i, temp);
				}	
			}
		}
		else if(obj instanceof Complex) {
			result = new VectoR(this.size);
			for(i = 0 ; i < this.size ; i++) {
				temp = ((Complex)obj).times(this.element[i]);
				result.setElement(i, temp);
			}
			
		}
		return (Object)result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "[";
		str += this.element[0];
				
		for(int i = 1 ; i < size ; i++){
			str = str + "\t" + this.element[i];
		}
		str += "]";
		return str;
	}
	
	public VectoR getSubVector(int start, int end) {
		int nSize = end - start + 1;
		try {
			if(nSize > this.size || end > this.size)
				throw new Exception();
			
			VectoR result = new VectoR(nSize);
			int i;
			
			for(i = 0 ; i < nSize ; i++)
				result.setElement(i, this.element[i+start]);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
