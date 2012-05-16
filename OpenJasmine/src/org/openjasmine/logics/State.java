/**
 * 
 */
package org.openjasmine.logics;

/**
 * @author khj
 *
 */
public interface State {
	public void enter(Object obj);
	public void execute(Object obj);
	public void exit(Object obj);
}
