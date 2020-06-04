package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/*
 * Cette classe fait partie du modele de conception Factory avec la classe ShapeEMR et ShapeEMRFactory ainsi que toutes
 * autres formes concretes.
 * 
 * Elle fait aussi partie du modele dans le modele de conception MVC
 */

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
