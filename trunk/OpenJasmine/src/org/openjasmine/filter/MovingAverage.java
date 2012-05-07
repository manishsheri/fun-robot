package org.openjasmine.filter;

public class MovingAverage extends Average {
	int size;
	double[] buffer;
	
	public MovingAverage() {
		super();
		size = 10;
		buffer = new double[size];
	}
	
	public MovingAverage(int size) {
		super();
		this.size = size;
		buffer = new double[size];
	}

	@Override
	public double newAverage(double data) {
		int i;
		int index = count % size;
		buffer[index] = data;
		count++;
		average = 0.0;
		if(count < size) {
			for(i = 0 ; i < count ; i++) {
				average += buffer[i];
			}
			average /= (double)count;
		}
		else {
			for(i = 0 ; i < size ; i++) {
				average += buffer[i];
			}
			average /= (double)size;
		}
		return average;
	}
}
