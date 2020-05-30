package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class ConversionPowerMultiElement extends ShapeEMR{
	
	double radius;

	public ConversionPowerMultiElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
		
		this.radius = 10.5;
	}

	@Override
	public Shape createShape() {
		Circle element = new Circle();
		element.setCenterX(this.xCoordinate);
		element.setCenterY(this.yCoordinate);
		element.setRadius(this.radius);
		element.setFill(Color.web(this.mainColor));
		element.setStroke(Color.web(this.borderColor));
		return element;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
}
