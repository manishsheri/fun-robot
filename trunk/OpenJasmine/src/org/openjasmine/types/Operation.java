package org.openjasmine.types;


/** 
 * @filename Operation.java
 * @author Hyeon-min.shim(elecage@gmail.com)
 */
public interface Operation {

		
		/**
		 * add two object
		 * @param obj 이 수와 더할 숫자
		 * @return this + obj
		 */
		public abstract Object plus(Object obj);

			
		/**
		 */
		public abstract Object minus(Object obj);
			
		/**
		 */
		public abstract Object times(Object obj);
		
		/**
		 */
		public abstract Object div(Object obj);


			
			/**
			 */
		public abstract Object abs();
			
}
