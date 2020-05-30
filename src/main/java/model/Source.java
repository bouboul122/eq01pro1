package model;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class Source extends ShapeEMR{

	Source(double xCoordinate, double yCoordinate) {
		super(xCoordinate, yCoordinate);
	}

	@Override
	public Shape createShape() {
		
		Ellipse ellipse = new Ellipse();
		ellipse.setCenterX(this.xCoordinate);
		ellipse.setCenterX(this.yCoordinate);
		ellipse.setRadiusX(10);
		ellipse.setRadiusY(5);
		return ellipse;
	}

}
