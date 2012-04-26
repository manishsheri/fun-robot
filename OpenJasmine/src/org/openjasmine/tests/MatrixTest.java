/**
 * 
 */
package org.openjasmine.tests;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openjasmine.types.Complex;
import org.openjasmine.types.Matrix;

/**
 * @author Hyeon-min.Shim(elecage@gmail.com)
 *
 */
public class MatrixTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Double[][] d1 = {{1.0, 2.0, 3.0, 4.0}, {3.0, 4.0, 5.0, 6.0},{6.0, 3.0, 7.0, 3.0}};
		Double[][] d2 = {{3.0, 7.0, -2.0, 1.0}, {-1.0, 4.0, -5.0, -4.0},{3.0, -9.0, 0.0, 4.0}};
		
		Complex[][] c1 = {{Complex.getComplex(2.0, 3.4), Complex.getComplex(-2.4, 3.2), Complex.getComplex(5.4, -1.7), Complex.getComplex(-3.4, -3.5)},
						  {Complex.getComplex(-2.0, 1.4), Complex.getComplex(-4.4, -5.2), Complex.getComplex(9.0, 4.0), Complex.getComplex(0.4, 0.5)},
						  {Complex.getComplex(22.0, 53.1), Complex.getComplex(36.5, 13.2), Complex.getComplex(5.4, 1.7), Complex.getComplex(-3.4, 2.2)}};
		Complex[][] c2 = {{Complex.getComplex(-12.0, 5.4), Complex.getComplex(19.4, 7.2), Complex.getComplex(8.4, -3.7), Complex.getComplex(-3.6, -3.1)},
				  {Complex.getComplex(-5.0, 8.4), Complex.getComplex(3.4, 3.2), Complex.getComplex(-7.0, -5.0), Complex.getComplex(2.4, 3.5)},
				  {Complex.getComplex(22.4, 13.5), Complex.getComplex(3.3, 6.7), Complex.getComplex(54.3, 3.7), Complex.getComplex(-6.4, 3.2)}};

		Matrix md1 = new Matrix(d1);
		Matrix md2 = new Matrix(d2);
		Matrix md3;
		
		Matrix mc1 = new Matrix(c1);
		Matrix mc2 = new Matrix(c2);
		Matrix mc3;
		
		md3 = (Matrix)md1.plus(md2);
		
		System.out.println("md1 = \n" + md1);
		System.out.println("md2 = \n" + md2);
		System.out.println("md1 + md2 = \n" + md3);
		
		mc3 = (Matrix)mc1.plus(mc2);
		
		System.out.println("mc1 = \n" + mc1);
		System.out.println("mc2 = \n" + mc2);
		System.out.println("mc1 + mc2 = \n" + mc3);
		
		mc3 = (Matrix)md1.plus(mc1);
		System.out.println("md1 + mc1 = \n" + mc3);
		
		md3 = (Matrix)mc1.plus(md1);
		System.out.println("mc1 + md1 = \n" + mc3);
		
		md3 = (Matrix)md1.minus(md2);
		
		System.out.println("md1 = \n" + md1);
		System.out.println("md2 = \n" + md2);
		System.out.println("md1 - md2 = \n" + md3);
		
		mc3 = (Matrix)mc1.minus(mc2);
		
		System.out.println("mc1 = \n" + mc1);
		System.out.println("mc2 = \n" + mc2);
		System.out.println("mc1 - mc2 = \n" + mc3);
		
		mc3 = (Matrix)md1.minus(mc1);
		System.out.println("md1 - mc1 = \n" + mc3);
		
		md3 = (Matrix)mc1.minus(md1);
		System.out.println("mc1 - md1 = \n" + md3);
	}

}
