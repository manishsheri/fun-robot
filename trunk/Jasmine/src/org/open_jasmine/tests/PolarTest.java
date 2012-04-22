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

package org.open_jasmine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.open_jasmine.types.Complex;
import org.open_jasmine.types.Polar;

public class PolarTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Polar p = new Polar(5.0, 0.9272952180016122);
		Complex c = new Complex();
		/**
		 * [JASMIN-TC-POLAR-001] Convert Polar to Complex
		 * input  : p - Polar: 5.0¡Ð0.9272952180016122
		 * expected output : c - Complex: 3.0 + 4.0i
		 */
		c = p.toComplex();
		System.out.println("[JASMIN-TC-POLAR-001] " + p + " -> " + c);
		
		/**
		 * [JASMIN-TC-POLAR-002] Convert Complx to Polar
		 * input  : c - Complex: 3.0 + 4.0i
		 * expected output : p - Polar: 5.0¡Ð0.9272952180016122
		 */
		c = new Complex(3.0, 4.0);
		p.fromComplex(c);
		System.out.println("[JASMIN-TC-POLAR-002] " + c + " -> " + p);
		
	}

}
