/**
 * 
 */
package kr.ac.inha.biselab.jamalins.datastructure;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sim
 *
 */
public class ComplexTest {

	Complex c0;
	Complex c1;
	Complex c2;
	Complex c3;
	Complex c4;
	
	double tol;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c0 = new Complex();					// zero + jzero
		c1 = new Complex(1.0, 2.0);			// positive + jpositive
		c2 = new Complex(2.0, -3.0);		// positive + jnegative
		c3 = new Complex(-3.0, 4.0);		// negative + jpositive
		c4 = new Complex(-5.0, -6.0);		// negative + jnegative
		tol = 0.0001;
		
		/*
		System.out.println(c0.toString());
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());
		*/
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#Complex()}.
	 */
	@Test
	public void testComplex() {
		Complex c = new Complex();
		assertTrue(Math.abs(0.0 - c.getRe()) < tol);
		assertTrue(Math.abs(0.0 - c.getIm()) < tol);
		System.out.println("Test #1 Complex constructor 0.0 + j0.0");
		System.out.println("c = " + c.toString());
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#Complex(double, double)}.
	 */
	@Test
	public void testComplexDoubleDouble() {
		System.out.println("Test #2 Complex constructor assigned by double numbers.");
		
		Complex cc1 = new Complex(12.3, 13.0);
		assertTrue(Math.abs(12.3 - cc1.getRe()) < tol);
		assertTrue(Math.abs(13.0 - cc1.getIm()) < tol);
		System.out.println("cc1 = " + cc1.toString());
		
		Complex cc2 = new Complex(3.0, -2.7);
		assertTrue(Math.abs(3.0 - cc2.getRe()) < tol);
		assertTrue(Math.abs(-2.7 - cc2.getIm()) < tol);
		System.out.println("cc2 = " + cc2.toString());
		
		Complex cc3 = new Complex(-83.0, 2.5);
		assertTrue(Math.abs(-83.0 - cc3.getRe()) < tol);
		assertTrue(Math.abs(2.5 - cc3.getIm()) < tol);
		System.out.println("cc3 = " + cc3.toString());
		
		Complex cc4 = new Complex(-832.3, 92489.9284);
		assertTrue(Math.abs(-832.3 - cc4.getRe()) < tol);
		assertTrue(Math.abs(92489.9284 - cc4.getIm()) < tol);
		System.out.println("cc4 = " + cc4.toString());
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#Complex(kr.ac.inha.biselab.jamalins.datastructure.Complex)}.
	 */
	@Test
	public void testComplexComplex() {
		System.out.println("Test #3 Complex constructor assigned by complex number");
		
		Complex cc1 = new Complex(c1);
		assertTrue(Math.abs(1.0 - cc1.getRe()) < tol);
		assertTrue(Math.abs(2.0 - cc1.getIm()) < tol);
		System.out.println("cc1 = " + cc1.toString());
		
		Complex cc2 = new Complex(c2);
		assertTrue(Math.abs(2.0 - cc2.getRe()) < tol);
		assertTrue(Math.abs(-3.0 - cc2.getIm()) < tol);
		System.out.println("cc2 = " + cc2.toString());
		
		Complex cc3 = new Complex(c3);
		assertTrue(Math.abs(-3.0 - cc3.getRe()) < tol);
		assertTrue(Math.abs(4.0 - cc3.getIm()) < tol);
		System.out.println("cc3 = " + cc3.toString());
		
		Complex cc4 = new Complex(c4);
		assertTrue(Math.abs(-5.0 - cc4.getRe()) < tol);
		assertTrue(Math.abs(-6.0 - cc4.getIm()) < tol);
		System.out.println("cc4 = " + cc4.toString());
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#getRe()}.
	 */
	@Test
	public void testGetRe() {
		System.out.println("Test #4 Get Real number");
		double re = c0.getRe();
		assertTrue(re == 0.0);
		
		re = c1.getRe();
		assertTrue(Math.abs(1.0 - re) < tol);
		System.out.println("real part of c1 = " + re);
		re = c2.getRe();
		assertTrue(Math.abs(2.0 - re) < tol);
		System.out.println("real part of c2 = " + re);
		
		re = c3.getRe();
		assertTrue(Math.abs(-3.0 - re) < tol);
		System.out.println("real part of c3 = " + re);
		
		re = c4.getRe();
		assertTrue(Math.abs(-5.0 - re) < tol);
		System.out.println("real part of c4 = " + re);
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#setRe(double)}.
	 */
	@Test
	public void testSetRe() {
		System.out.println("Test #5 Set Real number");
		Complex c = new Complex();
		c.setRe(2.9);
		assertTrue(Math.abs(2.9 - c.getRe()) < tol);
		System.out.println("c = " + c.toString());
		c.setRe(-82.3);
		assertTrue(Math.abs(-82.3 - c.getRe()) < tol);
		System.out.println("c = " + c.toString());
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#getIm()}.
	 */
	@Test
	public void testGetIm() {
		System.out.println("Test #6 Get Imagenary number");
		double im = c0.getIm();
		assertTrue(im == 0.0);
		
		im = c1.getIm();
		assertTrue(Math.abs(2.0 - im) < tol);
		System.out.println("imaginary part of c1 = " + im);
		im = c2.getIm();
		assertTrue(Math.abs(-3.0 - im) < tol);
		System.out.println("imaginary part of c2 = " + im);
		
		im = c3.getIm();
		assertTrue(Math.abs(4.0 - im) < tol);
		System.out.println("imaginary part of c3 = " + im);
		
		im = c4.getIm();
		assertTrue(Math.abs(-6.0 - im) < tol);
		System.out.println("imaginary part of c4 = " + im);
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#setIm(double)}.
	 */
	@Test
	public void testSetIm() {
		System.out.println("Test #7 Set Imaginary number");
		Complex c = new Complex();
		c.setIm(2.9);
		assertTrue(Math.abs(2.9 - c.getIm()) < tol);
		System.out.println("c = " + c.toString());
		
		c.setIm(-82.3);
		assertTrue(Math.abs(-82.3 - c.getIm()) < tol);
		System.out.println("c = " + c.toString());
		
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#setReIm(double, double)}.
	 */
	@Test
	public void testSetReIm() {
		System.out.println("Test #8 Set Real and Imaginary number");
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#conj()}.
	 */
	@Test
	public void testConj() {
		System.out.println("Test #9 Conjugate");
		Complex c = c1.conj();
		assertTrue(Math.abs(c.getRe() - c1.getRe()) < tol);
		assertTrue(Math.abs(c.getIm() + c1.getIm()) < tol);
		System.out.println("conj("+c1.toString() +") = " + c);
		
		c = c2.conj();
		assertTrue(Math.abs(c.getRe() - c2.getRe()) < tol);
		assertTrue(Math.abs(c.getIm() + c2.getIm()) < tol);
		System.out.println("conj("+c2.toString() +") = " + c);
		
		c = c3.conj();
		assertTrue(Math.abs(c.getRe() - c3.getRe()) < tol);
		assertTrue(Math.abs(c.getIm() + c3.getIm()) < tol);
		System.out.println("conj("+c3.toString() +") = " + c);
		
		c = c4.conj();
		assertTrue(Math.abs(c.getRe() - c4.getRe()) < tol);
		assertTrue(Math.abs(c.getIm() + c4.getIm()) < tol);
		System.out.println("conj("+c4.toString() +") = " + c);
		
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#addTo(kr.ac.inha.biselab.jamalins.datastructure.Complex)}.
	 */
	@Test
	public void testAddTo() {
		System.out.println("Test #10 AddTo");
		Complex c = c1.addTo(c2);
		assertTrue(Math.abs(c.getRe() - 3.0) < tol);
		assertTrue(Math.abs(c.getIm() + 1.0) < tol);
		System.out.println(c1 + " + " + c2 + " = " + c);
		
		c = c2.addTo(c3);
		assertTrue(Math.abs(c.getRe() + 1.0) < tol);
		assertTrue(Math.abs(c.getIm() - 1.0) < tol);
		System.out.println(c2 + " + " + c3 + " = " + c);
		
		c = c3.addTo(c4);
		assertTrue(Math.abs(c.getRe() + 8.0) < tol);
		assertTrue(Math.abs(c.getIm() + 2.0) < tol);
		System.out.println(c3 + " + " + c4 + " = " + c);
		
		c = c4.addTo(c0);
		assertTrue(Math.abs(c.getRe() + 5.0) < tol);
		assertTrue(Math.abs(c.getIm() + 6.0) < tol);
		System.out.println(c4 + " + " + c0 + " = " + c);
		
		c = c4.addTo(c1);
		assertTrue(Math.abs(c.getRe() + 4.0) < tol);
		assertTrue(Math.abs(c.getIm() + 4.0) < tol);
		System.out.println(c4 + " + " + c1 + " = " + c);
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#add(kr.ac.inha.biselab.jamalins.datastructure.Complex, kr.ac.inha.biselab.jamalins.datastructure.Complex)}.
	 */
	@Test
	public void testAdd() {
		System.out.println("Test #11 Add");
		Complex c = new Complex();
		
		c.add(c1, c2);
		assertTrue(Math.abs(c.getRe() - 3.0) < tol);
		assertTrue(Math.abs(c.getIm() + 1.0) < tol);
		System.out.println(c1 + " + " + c2 + " = " + c);
		
		c.add(c2, c3);
		assertTrue(Math.abs(c.getRe() + 1.0) < tol);
		assertTrue(Math.abs(c.getIm() - 1.0) < tol);
		System.out.println(c2 + " + " + c3 + " = " + c);
		
		c.add(c3, c4);
		assertTrue(Math.abs(c.getRe() + 8.0) < tol);
		assertTrue(Math.abs(c.getIm() + 2.0) < tol);
		System.out.println(c3 + " + " + c4 + " = " + c);
		
		c.add(c4, c0);
		assertTrue(Math.abs(c.getRe() + 5.0) < tol);
		assertTrue(Math.abs(c.getIm() + 6.0) < tol);
		System.out.println(c4 + " + " + c0 + " = " + c);
		
		c.add(c4, c1);
		assertTrue(Math.abs(c.getRe() + 4.0) < tol);
		assertTrue(Math.abs(c.getIm() + 4.0) < tol);
		System.out.println(c4 + " + " + c1 + " = " + c);
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#subTo(kr.ac.inha.biselab.jamalins.datastructure.Complex)}.
	 */
	@Test
	public void testSubTo() {
		System.out.println("Test #12 SubTo");
		Complex c = c1.subTo(c2);

		assertTrue(Math.abs(c.getRe() + 1.0) < tol);
		assertTrue(Math.abs(c.getIm() - 5.0) < tol);
		System.out.println(c1 + " - " + c2 + " = " + c);
		
		c = c2.subTo(c3);
		assertTrue(Math.abs(c.getRe() - 5.0) < tol);
		assertTrue(Math.abs(c.getIm() + 7.0) < tol);
		System.out.println(c2 + " - " + c3 + " = " + c);
		
		c = c3.subTo(c4);
		assertTrue(Math.abs(c.getRe() - 2.0) < tol);
		assertTrue(Math.abs(c.getIm() - 10.0) < tol);
		System.out.println(c3 + " - " + c4 + " = " + c);
		
		c = c4.subTo(c0);
		assertTrue(Math.abs(c.getRe() + 5.0) < tol);
		assertTrue(Math.abs(c.getIm() + 6.0) < tol);
		System.out.println(c4 + " - " + c0 + " = " + c);
		
		c = c4.subTo(c1);
		assertTrue(Math.abs(c.getRe() + 6.0) < tol);
		assertTrue(Math.abs(c.getIm() + 8.0) < tol);
		System.out.println(c4 + " - " + c1 + " = " + c);
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#sub(kr.ac.inha.biselab.jamalins.datastructure.Complex, kr.ac.inha.biselab.jamalins.datastructure.Complex)}.
	 */
	@Test
	public void testSub() {
		System.out.println("Test #13 Sub");
		Complex c = new Complex();
		
		c.sub(c1, c2);
		assertTrue(Math.abs(c.getRe() + 1.0) < tol);
		assertTrue(Math.abs(c.getIm() - 5.0) < tol);
		System.out.println(c1 + " - " + c2 + " = " + c);
		
		c.sub(c2, c3);
		assertTrue(Math.abs(c.getRe() - 5.0) < tol);
		assertTrue(Math.abs(c.getIm() + 7.0) < tol);
		System.out.println(c2 + " - " + c3 + " = " + c);
		
		c.sub(c3,c4);
		assertTrue(Math.abs(c.getRe() - 2.0) < tol);
		assertTrue(Math.abs(c.getIm() - 10.0) < tol);
		System.out.println(c3 + " - " + c4 + " = " + c);
		
		c.sub(c4, c0);
		assertTrue(Math.abs(c.getRe() + 5.0) < tol);
		assertTrue(Math.abs(c.getIm() + 6.0) < tol);
		System.out.println(c4 + " - " + c0 + " = " + c);
		
		c.sub(c4, c1);
		assertTrue(Math.abs(c.getRe() + 6.0) < tol);
		assertTrue(Math.abs(c.getIm() + 8.0) < tol);
		System.out.println(c4 + " - " + c1 + " = " + c);
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#mulTo(kr.ac.inha.biselab.jamalins.datastructure.Complex)}.
	 */
	@Test
	public void testMulTo() {
		System.out.println("Test #14 MulTo");
		Complex c = c1.mulTo(c2);
		assertTrue(Math.abs(c.getRe() - 8.0) < tol);
		assertTrue(Math.abs(c.getIm() - 1.0) < tol);
		System.out.println(c1 + " * " + c2 + " = " + c);
		
		c = c2.mulTo(c3);
		assertTrue(Math.abs(c.getRe() - 6.0) < tol);
		assertTrue(Math.abs(c.getIm() - 17.0) < tol);
		System.out.println(c2 + " * " + c3 + " = " + c);
		
		c = c3.mulTo(c4);
		assertTrue(Math.abs(c.getRe() - 39.0) < tol);
		assertTrue(Math.abs(c.getIm() + 2.0) < tol);
		System.out.println(c3 + " * " + c4 + " = " + c);
		
		c = c4.mulTo(c0);
		assertTrue(Math.abs(c.getRe() - 0.0) < tol);
		assertTrue(Math.abs(c.getIm() - 0.0) < tol);
		System.out.println(c4 + " * " + c0 + " = " + c);
		
		c = c4.mulTo(c1);
		assertTrue(Math.abs(c.getRe() - 7.0) < tol);
		assertTrue(Math.abs(c.getIm() + 16.0) < tol);
		System.out.println(c4 + " * " + c1 + " = " + c);
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#mul(kr.ac.inha.biselab.jamalins.datastructure.Complex, kr.ac.inha.biselab.jamalins.datastructure.Complex)}.
	 */
	@Test
	public void testMul() {
		System.out.println("Test #15 Mul");
		Complex c = new Complex();
		c.mul(c1,c2);
		assertTrue(Math.abs(c.getRe() - 8.0) < tol);
		assertTrue(Math.abs(c.getIm() - 1.0) < tol);
		System.out.println(c1 + " * " + c2 + " = " + c);
		
		c.mul(c2,c3);
		assertTrue(Math.abs(c.getRe() - 6.0) < tol);
		assertTrue(Math.abs(c.getIm() - 17.0) < tol);
		System.out.println(c2 + " * " + c3 + " = " + c);
		
		c.mul(c3,c4);
		assertTrue(Math.abs(c.getRe() - 39.0) < tol);
		assertTrue(Math.abs(c.getIm() + 2.0) < tol);
		System.out.println(c3 + " * " + c4 + " = " + c);
		
		c.mul(c4,c0);
		assertTrue(Math.abs(c.getRe() - 0.0) < tol);
		assertTrue(Math.abs(c.getIm() - 0.0) < tol);
		System.out.println(c4 + " * " + c0 + " = " + c);
		
		c.mul(c4,c1);
		assertTrue(Math.abs(c.getRe() - 7.0) < tol);
		assertTrue(Math.abs(c.getIm() + 16.0) < tol);
		System.out.println(c4 + " * " + c1 + " = " + c);
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#divTo(kr.ac.inha.biselab.jamalins.datastructure.Complex)}.
	 */
	@Test
	public void testDivTo() {
		System.out.println("Test #16 DivTo");
		Complex c = c1.divTo(c2);
		System.out.println(c1 + " / " + c2 + " = " + c);
		assertTrue(Math.abs(c.getRe() + 0.3077) < tol);
		assertTrue(Math.abs(c.getIm() - 0.5385) < tol);
		System.out.println(c1 + " / " + c2 + " = " + c);
		
		c = c2.divTo(c3);
		assertTrue(Math.abs(c.getRe() + 0.7200) < tol);
		assertTrue(Math.abs(c.getIm() - 0.0400) < tol);
		System.out.println(c2 + " / " + c3 + " = " + c);
		
		c = c3.divTo(c4);
		assertTrue(Math.abs(c.getRe() + 0.1475) < tol);
		assertTrue(Math.abs(c.getIm() + 0.6230) < tol);
		System.out.println(c3 + " / " + c4 + " = " + c);
		/*
		c = c4.divTo(c0);
		assertTrue(c.getRe() == Double.NaN);
		assertTrue(c.getIm() == Double.NaN);
		System.out.println(c4 + " / " + c0 + " = " + c);
		
		*/
		
		c = c4.divTo(c1);
		assertTrue(Math.abs(c.getRe() + 3.400) < tol);
		assertTrue(Math.abs(c.getIm() -  0.8000) < tol);
		System.out.println(c4 + " / " + c1 + " = " + c);
	}

	/**
	 * Test method for {@link kr.ac.inha.biselab.jamalins.datastructure.Complex#div(kr.ac.inha.biselab.jamalins.datastructure.Complex, kr.ac.inha.biselab.jamalins.datastructure.Complex)}.
	 */
	@Test
	public void testDiv() {
		System.out.println("Test #17 Div");
		Complex c = new Complex();
		c.div(c1, c2);
		
		System.out.println(c1 + " / " + c2 + " = " + c);
		assertTrue(Math.abs(c.getRe() + 0.3077) < tol);
		assertTrue(Math.abs(c.getIm() - 0.5385) < tol);
		System.out.println(c1 + " / " + c2 + " = " + c);
		
		c.div(c2, c3);
		assertTrue(Math.abs(c.getRe() + 0.7200) < tol);
		assertTrue(Math.abs(c.getIm() - 0.0400) < tol);
		System.out.println(c2 + " / " + c3 + " = " + c);
		
		c.div(c3, c4);
		assertTrue(Math.abs(c.getRe() + 0.1475) < tol);
		assertTrue(Math.abs(c.getIm() + 0.6230) < tol);
		System.out.println(c3 + " / " + c4 + " = " + c);
		/*
		c = c4.divTo(c0);
		assertTrue(c.getRe() == Double.NaN);
		assertTrue(c.getIm() == Double.NaN);
		System.out.println(c4 + " / " + c0 + " = " + c);
		
		*/
		
		c.div(c4, c1);
		assertTrue(Math.abs(c.getRe() + 3.400) < tol);
		assertTrue(Math.abs(c.getIm() -  0.8000) < tol);
		System.out.println(c4 + " / " + c1 + " = " + c);
	}

}
