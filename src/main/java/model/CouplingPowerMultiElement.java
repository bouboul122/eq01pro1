package model;

import javafx.scene.paint.Color;

/*
 * Cette classe fait partie du modele de conception Factory avec la classe ShapeEMR et ShapeEMRFactory ainsi que toutes
 * autres formes concretes.
 * 
 * Elle fait aussi partie du modele dans le modele de conception MVC
 */

import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;

public class CouplingPowerMultiElement extends ShapeEMR{

	public CouplingPowerMultiElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
	}

	@Override
	public Shape createShape() {
		ConversionPowerMultiElement elementTop = new ConversionPowerMultiElement(this.xCoordinate, this.yCoordinate, 
				this.mainColor, this.borderColor);
		ConversionPowerMultiElement elementBottom = new ConversionPowerMultiElement(
				this.xCoordinate, this.yCoordinate + (10*elementTop.getRadius()/6), 
				this.mainColor, this.borderColor);
		
		
		Shape shape = Shape.union(elementTop.createShape(), elementBottom.createShape());
		shape.setFill(Color.web(this.mainColor));
		shape.setStroke(Color.web(this.borderColor));
		return shape;
	}

}
