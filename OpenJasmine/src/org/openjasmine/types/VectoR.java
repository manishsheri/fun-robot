package org.openjasmine.types;


public class VectoR implements Operation {

	@Override
	public Object plus(Object obj) {
		try {
			if(this.size != ((VectoR)obj).getSize())
				throw new Exception();
	
			int i;
			VectoR result = new VectoR(((VectoR)obj).getSize());
			
			Complex temp;
			if(this.element instanceof Complex[]) {
				for(i = 0 ; i < this.size ; i++)
				{
					temp = (Complex)((VectoR)obj).getElement(i);
					result.setElement(i, ((Complex[])this.element)[i].plus(temp));
				}
			}
			else if(this.element instanceof Double[]){
				Object o =  ((VectoR)obj).getElement();
				if( o instanceof Complex[]) {
					for(i = 0 ; i < this.size ; i++) {
						temp = (Complex)((VectoR)obj).getElement(i);
						result.setElement(i, temp.plus(this.element[i]));
					}
				}
				else if(this.element instanceof Double[]) {
					for(i = 0 ; i < this.size ; i++)
						result.setElement(i, (Double)this.element[i] + (Double)((VectoR)obj).getElement(i));
				}
			}

			return (Object)result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object minus(Object obj) {
		try {
			if(this.size != ((VectoR)obj).getSize())
				throw new Exception();
	
			int i;
			VectoR result = new VectoR(((VectoR)obj).getSize());
			
			Complex temp;
			if(this.element instanceof Complex[]) {
				for(i = 0 ; i < this.size ; i++)
				{
					temp = (Complex)((VectoR)obj).getElement(i);
					result.setElement(i, ((Complex[])this.element)[i].minus(temp));
				}
			}
			else if(this.element instanceof Double[]){
				Object o =  ((VectoR)obj).getElement();
				if( o instanceof Complex[]) {
					for(i = 0 ; i < this.size ; i++) {
						temp = ((Complex)((VectoR)obj).getElement(i)).diff();
						result.setElement(i, temp.plus(this.element[i]));
					}
				}
				else if(this.element instanceof Double[]) {
					for(i = 0 ; i < this.size ; i++)
						result.setElement(i, (Double)this.element[i] - (Double)((VectoR)obj).getElement(i));
				}
			}

			return (Object)result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object times(Object obj) {
		try {
			if(this.size != ((VectoR)obj).getSize())
				throw new Exception();
	
			int i;
			VectoR result = new VectoR(((VectoR)obj).getSize());
			
			Complex temp;
			if(this.element instanceof Complex[]) {
				for(i = 0 ; i < this.size ; i++)
				{
					temp = (Complex)((VectoR)obj).getElement(i);
					result.setElement(i, ((Complex[])this.element)[i].times(temp));
				}
			}
			else if(this.element instanceof Double[]){
				Object o =  ((VectoR)obj).getElement();
				if( o instanceof Complex[]) {
					for(i = 0 ; i < this.size ; i++) {
						temp = (Complex)((VectoR)obj).getElement(i);
						result.setElement(i, temp.times(this.element[i]));
					}
				}
				else if(this.element instanceof Double[]) {
					for(i = 0 ; i < this.size ; i++)
						result.setElement(i, (Double)this.element[i] * (Double)((VectoR)obj).getElement(i));
				}
			}

			return (Object)result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object div(Object obj) {
		try {
			if(this.size != ((VectoR)obj).getSize())
				throw new Exception();
	
			int i;
			VectoR result = new VectoR(((VectoR)obj).getSize());
			
			Complex temp;
			if(this.element instanceof Complex[]) {
				for(i = 0 ; i < this.size ; i++)
				{
					temp = ((Complex)((VectoR)obj).getElement(i)).inv();
					result.setElement(i, ((Complex[])this.element)[i].times(temp));
				}
			}
			else if(this.element instanceof Double[]){
				Object o =  ((VectoR)obj).getElement();
				if( o instanceof Complex[]) {
					for(i = 0 ; i < this.size ; i++) {
						temp = ((Complex)((VectoR)obj).getElement(i)).inv();
						result.setElement(i, temp.times(this.element[i]));
					}
				}
				else if(this.element instanceof Double[]) {
					for(i = 0 ; i < this.size ; i++)
						result.setElement(i, (Double)this.element[i] / (Double)((VectoR)obj).getElement(i));
				}
			}

			return (Object)result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object abs() {
		Object result = new Double[this.size];;
		int size = this.element.length;;
		/**
		 * element가 복소수
		 */
		if(this.element instanceof Complex[]) {
			for(int i = 0 ; i < size ; i++) {
				((Double[])result)[i] = (Double)(((Complex[])element)[i].abs());
			}
			
		}
		/**
		 * element가 실수
		 */
		else if(this.element instanceof Double[]) {
			for(int i = 0 ; i < size ; i++) {
				((Double[])result)[i] = (Double)(Math.abs(((Double[])element)[i]));
			}
		}
		/**
		 * element가 벡터
		 */
		/*
		else if(this.element instanceof VectoR[]) {
			
		}
		*/
		return result;
	}

	public VectoR(int size) {
		super();
		this.size = size;
		element = new Object[size];
	}

	public VectoR(Object[] element) {
		super();
		this.element = element;
		this.size = this.element.length;
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

	/**
	 * @uml.property  name="size"
	 */
	protected int size;

	/**
	 * Getter of the property <tt>size</tt>
	 * @return  Returns the size.
	 * @uml.property  name="size"
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Setter of the property <tt>size</tt>
	 * @param size  The size to set.
	 * @uml.property  name="size"
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/** 
	 * @uml.property name="element" multiplicity="(0 -1)" dimension="1"
	 */
	protected Object[] element;

	/** 
	 * Getter of the property <tt>element</tt>
	 * @return  Returns the element.
	 * @uml.property  name="element"
	 */
	public Object[] getElement() {
		return element;
	}

	public Object getElement(int index) {
		return element[index];
	}
	/** 
	 * Setter of the property <tt>element</tt>
	 * @param element  The element to set.
	 * @uml.property  name="element"
	 */
	public void setElement(Object[] element) {
		this.element = element;
	}
	
	public void setElement(int index, Object element) {
		this.element[index] = element;
	}

		
	/**
	 */
	public Object dot(VectoR v){
		Object result = null;;
		int i;
		
		try {
			if(this.size != v.getSize())
				throw new Exception();
			Object[] obj = v.getElement();
			
			if(this.element instanceof Complex[]) {
				result = new Complex(0.0, 0.0);
				Complex temp;
				for(i = 0 ; i < this.size ; i++) {
					temp = (Complex) ((Complex)this.element[i]).times((Complex)obj[i]);
					result = ((Complex)result).plus(temp);
				}
				
			}
			else if(this.element instanceof Double[]) {
				if(obj instanceof Complex[]) {
					result = new Complex(0.0, 0.0);
					Complex temp;
					for(i = 0 ; i < this.size ; i++) {
						temp = (Complex) ((Complex)obj[i]).times((Double)this.element[i]);
						result = ((Complex)result).plus(temp);
					}
				}
				else if(obj instanceof Double[]) {
					result = new Double(0.0);
					double temp;
					for(i = 0 ; i < this.size ; i++) {
						temp = ((Double)this.element[i]).doubleValue() * ((Double)obj[i]).doubleValue();
						result = ((Double)result).doubleValue() + temp; 
					}
				}
			}
			
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
