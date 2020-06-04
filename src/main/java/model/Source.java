package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/*
 * Cette classe fait partie du modele de conception Factory avec la classe ShapeEMR et ShapeEMRFactory ainsi que toutes
 * autres formes concretes.
 * 
 * Elle fait aussi partie du modele dans le modele de conception MVC
 */

public class Source extends ShapeEMR{

	public Source(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
	}

	@Override
	public Shape createShape() {
		
		Ellipse ellipse = new Ellipse();
		ellipse.setCenterX(this.xCoordinate);
		ellipse.setCenterY(this.yCoordinate);
		ellipse.setRadiusX(30);
		ellipse.setRadiusY(15);
		ellipse.setFill(Color.web(this.mainColor));
		ellipse.setStroke(Color.web(this.borderColor));
		return ellipse;
	}

}
