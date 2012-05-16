package org.openjasmine.logics;

import org.openjasmine.types.*;

public class NavGraphNode extends GraphNode {

	protected VectoR pos;
	public NavGraphNode() {
		// TODO Auto-generated constructor stub
		super();
		pos = new VectoR(2);
	}

	public NavGraphNode(int index) {
		super(index);
		// TODO Auto-generated constructor stub
		pos = new VectoR(2);
	}
	public NavGraphNode(int index, int pos) {
		
	}

}
