package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;

/*
 * Cette classe fait partie du modele de conception Factory avec la classe ShapeEMR et ShapeEMRFactory ainsi que toutes
 * autres formes concretes.
 * 
 * Elle fait aussi partie du modele dans le modele de conception MVC
 */

public class ArrowV1 extends ShapeEMR{

	ArrowV1(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);

	}

	@Override
	public Shape createShape() {

		
		Polyline line = new Polyline();
		
		line.getPoints().addAll(new Double[]{
			    xCoordinate, yCoordinate,
			    xCoordinate + 30.0, yCoordinate + 0.0,
			    xCoordinate + 27.0, yCoordinate + 5.0,
			    xCoordinate + 27.0, yCoordinate - 5.0,
			    xCoordinate + 30.0, yCoordinate + 0.0,});
		line.setFill(Color.web(mainColor));
		line.setStroke(Color.web(borderColor));
		
		return line;
		
	}
	
}
