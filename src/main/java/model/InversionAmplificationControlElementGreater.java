package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;

public class InversionAmplificationControlElementGreater extends ShapeEMR {

	public InversionAmplificationControlElementGreater(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);

	}

	@Override
	public Shape createShape() {
		InversionConversionControlElement element = new InversionConversionControlElement(this.xCoordinate, 
				this.yCoordinate, this.mainColor,this.borderColor);
		
		
		
		Polyline line = new Polyline();
		line.setStrokeWidth(0.25);
	
		line.getPoints().addAll(new Double[] {element.getxCoordinate(), element.getyCoordinate(), 
				element.getxCoordinate() + element.getWidth()/1.05, element.getyCoordinate()+ element.getWidth()/2,
				element.getxCoordinate() - element.getWidth()/2.95, element.getyCoordinate()+ element.getWidth()
				});
		
		Shape shape = Shape.subtract(element.createShape(), line);
		
		shape.setFill(Color.web(this.mainColor));
		shape.setStroke(Color.web(this.borderColor));
		return shape;
	}

}
