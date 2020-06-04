package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;

/*
 * Cette classe fait partie du modele de conception Factory avec la classe ShapeEMR et ShapeEMRFactory ainsi que toutes
 * autres formes concretes.
 * 
 * Elle fait aussi partie du modele dans le modele de conception MVC
 */

public class InversionAccumulationControlElement extends ShapeEMR{

	public InversionAccumulationControlElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
		
	}

	@Override
	public Shape createShape() {
		InversionConversionControlElement element = new InversionConversionControlElement(this.xCoordinate, this.yCoordinate, 
				this.mainColor, this.borderColor);
		
		Line line = new Line();
		line.setStartX(this.xCoordinate);
		line.setStartY(this.yCoordinate);
		line.setEndX(this.xCoordinate + 3*element.getWidth()/4);
		line.setEndY(this.yCoordinate + element.getWidth());
		line.setStrokeWidth(0.25);
		
		
		Shape shape = Shape.subtract(element.createShape(), line);
		
		shape.setFill(Color.web(this.mainColor));
		shape.setStroke(Color.web(this.borderColor));
		
		return shape;
	}
	

}
