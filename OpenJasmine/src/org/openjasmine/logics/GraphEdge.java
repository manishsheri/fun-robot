package org.openjasmine.logics;

public class GraphEdge {

	protected int 		from;
	protected int 		to;
	
	protected double 	cost;
	public GraphEdge() {
		this.cost = 1.0;
		this.from = -1;
		this.to   = -1;
	}

	public GraphEdge(int from, int to, double cost) {
		this.cost = cost;
		this.from = from;
		this.to 	= to;
	}
	
	public GraphEdge(int from, int to) {
		this.cost = 1.0;
		this.from = from;
		this.to 	= to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
