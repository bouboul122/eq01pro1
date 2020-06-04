package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;

/*
 * Cette classe fait partie du modele de conception Factory avec la classe ShapeEMR et ShapeEMRFactory ainsi que toutes
 * autres formes concretes.
 * 
 * Elle fait aussi partie du modele dans le modele de conception MVC
 */

public class PowerAmplificationGreaterElement extends ShapeEMR{

	public PowerAmplificationGreaterElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
	}

	@Override
	public Shape createShape() {
		ConversionPowerMonoElement element = new ConversionPowerMonoElement(xCoordinate, yCoordinate, mainColor, borderColor);
		Polyline line = new Polyline();
		
		line.getPoints().addAll(new Double[] {this.xCoordinate + element.getWidth(), this.yCoordinate,
				this.xCoordinate, this.yCoordinate + (element.getWidth()/2),
				this.xCoordinate + element.getWidth(), this.yCoordinate + element.getWidth()});
		line.setStrokeWidth(0.25);
		
		Shape shape = Shape.subtract(element.createShape(), line);
		shape.setFill(Color.web(this.mainColor));
		shape.setStroke(Color.web(this.borderColor));
		return shape;
	}

}
