package org.open_jasmine.operators;

import org.open_jasmine.types.*;

public class Op {
	public static double TOL = 0.0001;
	public static int DEFAULT_VECTOR_SIZE = 3;
	public static int DEFAULT_MATRIX_ROW_SIZE = 3;
	public static int DEFAULT_MATRIX_COL_SIZE = 3;
	/**
	 * plus
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static Complex plus(Complex c1, Complex c2) {
		Complex result = new Complex();
		
		result.setRe(c1.getRe() + c2.getRe());
		result.setIm(c1.getIm() + c2.getIm());
		
		return result;
	}
	
	public static Complex plus(Complex c, double d) {
		Complex result = new Complex();
		
		result.setRe(c.getRe() + d);
		result.setIm(c.getIm());
		
		return result;
	}
	
	public static Complex plus(double d, Complex c) {
		Complex result = new Complex();
		
		result.setRe(c.getRe() + d);
		result.setIm(c.getIm());
		
		return result;
	}
	
	public static double plus(double d1, double d2) {
		return d1 + d2;
	}
	
	/**
	 * minus
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static Complex minus(Complex c1, Complex c2) {
		Complex result = new Complex();
		
		result.setRe(c1.getRe() - c2.getRe());
		result.setIm(c1.getIm() - c2.getIm());
		
		return result;
	}
	
	public static Complex minus(Complex c, double d) {
		Complex result = new Complex();
		
		result.setRe(c.getRe() - d);
		result.setIm(c.getIm());
		
		return result;
	}
	
	public static Complex minus(double d, Complex c) {
		Complex result = new Complex();
		
		result.setRe(d - c.getRe());
		result.setIm(-c.getIm());
		
		return result;
	}
	
	public static double minus(double d1, double d2) {
		return d1 - d2;
	}
	
	public static Complex times(Complex c1, Complex c2) {
		Complex result = new Complex();
		
		result.setRe(c1.getRe() * c2.getRe() - c1.getIm() * c2.getIm());
		result.setIm(c1.getRe() * c2.getIm() + c1.getIm() * c2.getRe());
		
		return result;
	}
	
	public static Complex times(Complex c, double d) {
		Complex result = new Complex();
		
		result.setRe(c.getRe() * d);
		result.setIm(c.getIm() * d);
		
		return result;
	}
	
	public static Complex times(double d, Complex c) {
		Complex result = new Complex();
		
		result.setRe(c.getRe() * d);
		result.setIm(c.getIm() * d);
		
		return result;
	}
	
	public static Complex divide(Complex c1, Complex c2) {
		Complex result = times(c1, c2.conj());
		double div = c2.getRe() * c2.getRe() + c2.getIm() * c2.getIm();
		result.setRe(result.getRe() / div);
		result.setIm(result.getIm() / div);
		
		return result;
	}
	
	public static Complex divide(Complex c, double d) {
		Complex result = new Complex(c.getRe() / d, c.getIm() / d);
		
		return result;
	}
	
	public static Complex divide(double d, Complex c) {
		Complex result = times(d, c.conj());
		
		double div = c.getRe() * c.getRe() + c.getIm() * c.getIm();
		result.setRe(result.getRe() / div);
		result.setIm(result.getIm() / div);
		
		return result;
	}
	
	public static double divide(double d1, double d2) {
		return d1 / d2;
	}
	
	public static VectoR plus(VectoR v1, VectoR v2) {
		try {
			if(v1.getSize() != v2.getSize())
				throw new Exception();
			int i;
			VectoR result = new VectoR(v1.getSize());
			
			for(i = 0 ; i < v1.getSize() ; i++) {
				result.setElement(i, v1.getElement(i) + v2.getElement(i));
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR plus(VectoR v, double[] d) {
		try {
			if(v.getSize() != d.length)
				throw new Exception();
			int i;
			VectoR result = new VectoR(v.getSize());
			
			for(i = 0 ; i < v.getSize() ; i++) {
				result.setElement(i, v.getElement(i) + d[i]);
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR plus(double[] d, VectoR v) {
		try {
			if(v.getSize() != d.length)
				throw new Exception();
			int i;
			VectoR result = new VectoR(v.getSize());
			
			for(i = 0 ; i < v.getSize() ; i++) {
				result.setElement(i, v.getElement(i) + d[i]);
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR plus(double[] d1, double[] d2) {
		try {
			if(d1.length != d2.length)
				throw new Exception();
			VectoR result = new VectoR(d1.length);
			int i;
			
			for(i = 0 ; i < result.getSize() ; i++) 
				result.setElement(i, d1[i] + d2[i]);
			
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR minus(VectoR v1, VectoR v2) {
		try {
			if(v1.getSize() != v2.getSize())
				throw new Exception();
			int i;
			VectoR result = new VectoR(v1.getSize());
			
			for(i = 0 ; i < v1.getSize() ; i++) {
				result.setElement(i, v1.getElement(i) - v2.getElement(i));
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR minus(VectoR v, double[] d) {
		try {
			if(v.getSize() != d.length)
				throw new Exception();
			int i;
			VectoR result = new VectoR(v.getSize());
			
			for(i = 0 ; i < v.getSize() ; i++) {
				result.setElement(i, v.getElement(i) - d[i]);
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR minus(double[] d, VectoR v) {
		try {
			if(v.getSize() != d.length)
				throw new Exception();
			int i;
			VectoR result = new VectoR(v.getSize());
			
			for(i = 0 ; i < v.getSize() ; i++) {
				result.setElement(i, d[i] - v.getElement(i));
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR minus(double[] d1, double[] d2) {
		try {
			if(d1.length != d2.length)
				throw new Exception();
			VectoR result = new VectoR(d1.length);
			int i;
			
			for(i = 0 ; i < result.getSize() ; i++) 
				result.setElement(i, d1[i] - d2[i]);
			
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static double dot(VectoR v1, VectoR v2) {
		try {
			if(v1.getSize() != v2.getSize())
				throw new Exception();
			int i;
			double result = 0;
			
			for(i = 0 ; i < v1.getSize() ; i++) {
				result += v1.getElement(i) * v2.getElement(i);
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}
	
	public static double dot(VectoR v, double[] d) {
		try {
			if(v.getSize() != d.length)
				throw new Exception();
			int i;
			double result = 0;
			
			for(i = 0 ; i < v.getSize() ; i++) {
				result += v.getElement(i) *d[i];
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}
	
	public static double dot(double[] d, VectoR v) {
		try {
			if(v.getSize() != d.length)
				throw new Exception();
			int i;
			double result = 0;
			
			for(i = 0 ; i < v.getSize() ; i++) {
				result += v.getElement(i) *d[i];
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}
	
	public static double dot(double[] d1, double[] d2) {
		try {
			if(d1.length != d2.length)
				throw new Exception();
			int i;
			double result = 0;
			
			for(i = 0 ; i < d1.length ; i++) {
				result += d1[i] *d2[i];
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}
	
	public static VectoR cross(VectoR v1, VectoR v2) {
		try {
			if(v1.getSize() != 3 ||  v2.getSize() != 3)
				throw new Exception();
			VectoR result = new VectoR(3);
			result.setElement(0, v1.getElement(1) * v2.getElement(2) - v1.getElement(2) * v2.getElement(1));
			result.setElement(1, v1.getElement(2) * v2.getElement(0) - v1.getElement(0) * v2.getElement(2));
			result.setElement(2, v1.getElement(0) * v2.getElement(1) - v1.getElement(1) * v2.getElement(0));
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR cross(VectoR v, double[] d) {
		try {
			if(v.getSize() != 3 ||  d.length != 3)
				throw new Exception();
			VectoR result = new VectoR(3);
			result.setElement(0, v.getElement(1) * d[2] - v.getElement(2) * d[1]);
			result.setElement(1, v.getElement(2) * d[0] - v.getElement(0) * d[2]);
			result.setElement(2, v.getElement(0) * d[1] - v.getElement(1) * d[0]);
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR cross(double[] d, VectoR v) {
		try {
			if(v.getSize() != 3 ||  d.length != 3)
				throw new Exception();
			VectoR result = new VectoR(3);
			result.setElement(0, -v.getElement(1) * d[2] + v.getElement(2) * d[1]);
			result.setElement(1, -v.getElement(2) * d[0] + v.getElement(0) * d[2]);
			result.setElement(2, -v.getElement(0) * d[1] + v.getElement(1) * d[0]);
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR cross(double[] d1, double[] d2) {
		try {
			if(d1.length != 3 ||  d2.length != 3)
				throw new Exception();
			VectoR result = new VectoR(3);
			result.setElement(0, d1[1] * d2[2] - d1[2] * d2[1]);
			result.setElement(1, d1[2] * d2[0] - d1[0] * d2[2]);
			result.setElement(2, d1[0] * d2[1] - d1[1] * d2[0]);
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VectoR times(VectoR v, double d) {
		int i;
		VectoR result = new VectoR(v.getSize());
		for(i = 0 ; i < v.getSize() ; i++)
			result.setElement(i, v.getElement(i) * d);
		
		return result;
	}
	
	public static VectoR times(double d, VectoR v) {
		int i;
		VectoR result = new VectoR(v.getSize());
		for(i = 0 ; i < v.getSize() ; i++)
			result.setElement(i, v.getElement(i) * d);
		
		return result;
	}
	
	public static VectoR times(VectoR v1, VectoR v2) {
		try {
			if(v1.getSize() != v2.getSize())
				throw new Exception();
			VectoR result = new VectoR(v1.getSize());
			int i;
			
			for(i = 0 ; i < v1.getSize() ; i++)
				result.setElement(i, v1.getElement(i) * v2.getElement(i));
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	public static VectoR times(VectoR v, double[] d) {
		try {
			if(v.getSize() != d.length)
				throw new Exception();
			VectoR result = new VectoR(v.getSize());
			int i;
			
			for(i = 0 ; i < v.getSize() ; i++)
				result.setElement(i, v.getElement(i) *d[i]);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	public static VectoR times(double[] d, VectoR v) {
		try {
			if(v.getSize() != d.length)
				throw new Exception();
			VectoR result = new VectoR(v.getSize());
			int i;
			
			for(i = 0 ; i < v.getSize() ; i++)
				result.setElement(i, v.getElement(i) *d[i]);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	public static VectoR times(double[] d1, double[] d2) {
		try {
			if(d2.length != d1.length)
				throw new Exception();
			VectoR result = new VectoR(d1.length);
			int i;
			
			for(i = 0 ; i < result.getSize() ; i++)
				result.setElement(i, d1[i] *d2[i]);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}

		
		/**
		 */
		public static double times(double d1, double d2){
		return d1 * d2;
		}

			
		/**
		 */
		public static double abs(double d) {
			return Math.abs(d); 
		}

				
		/**
		 */
		public static double abs(Complex c){
			return c.abs(); 
		}

					
					/**
					 */
		public static Complex conj(Complex c) {
			return c.conj(); 
		}

						
			/**
			 */
		public static VectoR times(double[] va, double d){
			int i;
			VectoR result = new VectoR(va.length);
			
			for(i = 0 ; i < va.length ; i++)
				result.setElement(i, va[i] * d);
			
			return result;
		 }

		public static VectoR times(double d, double[] va) {
			int i;
			VectoR result = new VectoR(va.length);
			
			for(i = 0 ; i < va.length ; i++)
				result.setElement(i, va[i] * d);
			
			return result;
		}

						
			/**
			 */
		public static Polar complexToPolar(Complex c){
			Polar result = new Polar();
			
			result.fromComplex(c);
			
			return result; 
		}
					
		public static Complex polarToComplex(Polar p) {
			Complex result = p.toComplex();
			
			return result;
		}
		
		public static Matrix plus(Matrix m1, Matrix m2) {
			try {
				if((m1.getRow() != m2.getRow()) ||( m1.getCol() != m2.getCol()))
					throw new Exception();
				int i, j, row, col;
				Matrix result = new Matrix(m1.getRow(), m1.getCol());
				
				row = m1.getRow();
				col = m1.getCol();
				for(i = 0 ; i < row ; i++) {
					for(j = 0 ; j < col ; j++) {
						result.setElement(i, j, m1.getElement(i, j) + m2.getElement(i, j));
					}
				}
				
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public static Matrix minus(Matrix m1, Matrix m2) {
			try {
				if((m1.getRow() != m2.getRow()) ||( m1.getCol() != m2.getCol()))
					throw new Exception();
				int i, j, row, col;
				Matrix result = new Matrix(m1.getRow(), m1.getCol());
				
				row = m1.getRow();
				col = m1.getCol();
				for(i = 0 ; i < row ; i++) {
					for(j = 0 ; j < col ; j++) {
						result.setElement(i, j, m1.getElement(i, j) - m2.getElement(i, j));
					}
				}
				
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public static VectoR times(Matrix m, VectoR v) {
			int i, j, rowsize, colsize;
			VectoR ret = new VectoR(v.getSize());
			rowsize = m.getRow();
			colsize = m.getCol();
			double temp;
			for(i = 0 ; i < rowsize ; i++) {
				temp = 0.0;
				for(j = 0 ; j < colsize ; j++) {
					temp += m.getElement(i, j) * v.getElement(j);
				}
				ret.setElement(i, temp);
			}
			return ret;
		}
		public static double deg2rad(double deg) {
			double ret;
			ret = deg * Math.PI / 180.0;
			return ret;
			
		}
		
		public static double rad2deg(double rad) {
			double ret;
			ret = rad * 180.0 / Math.PI;
			return ret;
		}
}
