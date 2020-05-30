package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ConversionPowerMonoElement extends ShapeEMR{
	
	double width;

	public ConversionPowerMonoElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
		this.width = 21;
	}

	@Override
	public Shape createShape() {
		Rectangle element = new Rectangle();
		element.setX(this.xCoordinate);
		element.setY(this.yCoordinate);
		element.setWidth(this.width);
		element.setHeight(this.width);
		element.setFill(Color.web(this.mainColor));
		element.setStroke(Color.web(this.borderColor));
		return element;
	}
	
	public double getWidth()
	{
		return this.width;
	}

}
