package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/*
 * Cette classe fait partie du modele de conception Factory avec la classe ShapeEMR et ShapeEMRFactory ainsi que toutes
 * autres formes concretes.
 * 
 * Elle fait aussi partie du modele dans le modele de conception MVC
 */
public class AccumulationPowerElement extends ShapeEMR{

	public AccumulationPowerElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
	}

	@Override
	public Shape createShape() {
		Rectangle element = new Rectangle();
		element.setX(this.xCoordinate);
		element.setY(this.yCoordinate);
		element.setWidth(19.75);
		element.setHeight(40);
		element.setFill(Color.web(this.mainColor));
		element.setStroke(Color.web(this.borderColor));
		
		Line diagonal = new Line();
		diagonal.setStrokeWidth(0.25);
		diagonal.setStartX(this.xCoordinate);
		diagonal.setStartY(this.yCoordinate);
		diagonal.setEndX(this.xCoordinate + element.getWidth());
		diagonal.setEndY(this.yCoordinate + element.getHeight());
		diagonal.setFill(Color.web(this.borderColor));
		
		Shape shape = Shape.subtract(element, diagonal);
		shape.setFill(Color.web(this.mainColor));
		shape.setStroke(Color.web(this.borderColor));
		
		return shape;
	}

}
