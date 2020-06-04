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

public class InversionAmplificationControlElementLower extends ShapeEMR{

	public InversionAmplificationControlElementLower(double xCoordinate, double yCoordinate, String mainColor,
			String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
		
	}

	@Override
	public Shape createShape() {
		InversionConversionControlElement element = new InversionConversionControlElement(this.xCoordinate, 
				this.yCoordinate, this.mainColor,this.borderColor);
		
		
		Polyline line = new Polyline();
		line.setStrokeWidth(0.25);
	
		line.getPoints().addAll(new Double[] {element.getxCoordinate()+element.getWidth(), element.getyCoordinate(), 
				element.getxCoordinate() - element.getWidth()/4, element.getyCoordinate()+ element.getWidth()/2,
				element.getxCoordinate() + element.getWidth()/1.5, element.getyCoordinate()+ element.getWidth()
				});
		
		Shape shape = Shape.subtract(element.createShape(), line);
		
		shape.setFill(Color.web(this.mainColor));
		shape.setStroke(Color.web(this.borderColor));
		return shape;
	}

}
