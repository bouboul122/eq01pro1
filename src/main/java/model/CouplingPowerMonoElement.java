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

public class CouplingPowerMonoElement extends ShapeEMR{

	public CouplingPowerMonoElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);

	}

	@Override
	public Shape createShape() {
		ConversionPowerMonoElement elementTop = new ConversionPowerMonoElement(this.xCoordinate, this.yCoordinate, 
				this.mainColor, this.borderColor);
		ConversionPowerMonoElement elementBottom = new ConversionPowerMonoElement(
				this.xCoordinate + (2*elementTop.getWidth()/3), this.yCoordinate + (2*elementTop.getWidth()/3), 
				this.mainColor, this.borderColor);
		
		Polyline line = new Polyline();
		line.setStrokeWidth(0.25);
	
		line.getPoints().addAll(new Double[] {elementBottom.getxCoordinate(), elementBottom.getyCoordinate(), 
				(elementBottom.getxCoordinate() + elementBottom.getWidth()/3), (elementBottom.getyCoordinate()),
				(elementBottom.getxCoordinate() + elementBottom.getWidth()/3), (elementBottom.getyCoordinate() + elementBottom.getWidth()/3),
				elementBottom.getxCoordinate(), (elementBottom.getyCoordinate() + elementBottom.getWidth()/3),
				elementBottom.getxCoordinate(), elementBottom.getyCoordinate()});
		
		Shape shape = Shape.union(elementTop.createShape(), elementBottom.createShape());
		shape = Shape.subtract(shape, line);
		shape.setFill(Color.web(this.mainColor));
		shape.setStroke(Color.web(this.borderColor));
		
		return shape;
	}

}
