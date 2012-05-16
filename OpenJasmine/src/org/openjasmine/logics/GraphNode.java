package org.openjasmine.logics;

public class GraphNode {

	/**
	 * 모든 노드는 인덱스를 가지며 유효한 인덱스는 0보다 크거나 같다.
	 */
	protected int index;
	public static int INVALID_NODE_INDEX = -1;
	public GraphNode() {
		index = INVALID_NODE_INDEX;
	}
	
	public GraphNode(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
