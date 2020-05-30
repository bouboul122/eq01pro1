package model;

import javafx.scene.shape.Shape;

public abstract class ShapeEMR {
	
	double xCoordinate;
	double yCoordinate;
	
	ShapeEMR (double xCoordinate, double yCoordinate)
	{
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	
	
	public double getxCoordinate() {
		return xCoordinate;
	}



	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}



	public double getyCoordinate() {
		return yCoordinate;
	}



	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public abstract Shape createShape();

}
