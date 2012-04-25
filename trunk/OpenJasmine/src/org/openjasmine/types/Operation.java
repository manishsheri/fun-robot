/**
 * 
 */
package org.openjasmine.types;


/** 
 * @author Hyeon-min.shim(elecage@gmail.com)
 */
public interface Operation {

		
		/**
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
