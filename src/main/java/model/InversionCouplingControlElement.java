package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;

public class InversionCouplingControlElement extends ShapeEMR{

	public InversionCouplingControlElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Shape createShape() {
		
		InversionConversionControlElement elementTop = new InversionConversionControlElement(this.xCoordinate, this.yCoordinate, 
				this.mainColor, this.borderColor);
		InversionConversionControlElement elementBottom = new InversionConversionControlElement(this.xCoordinate + elementTop.getWidth()/3, 
				this.yCoordinate + 2*elementTop.getWidth()/3, 
				this.mainColor, this.borderColor);
		
		
		Polyline line = new Polyline();
		line.setStrokeWidth(0.25);
	
		line.getPoints().addAll(new Double[] {elementBottom.getxCoordinate(), elementBottom.getyCoordinate(), 
				elementBottom.getxCoordinate() - elementBottom.getWidth()/12, elementBottom.getyCoordinate() + elementBottom.getWidth()/3,
				elementBottom.getxCoordinate() + elementBottom.getWidth()/2.5, elementBottom.getyCoordinate() + elementBottom.getWidth()/3,
				elementBottom.getxCoordinate() + elementBottom.getWidth()/2, elementBottom.getyCoordinate(),
				elementBottom.getxCoordinate(), elementBottom.getyCoordinate()
		});
		
		Shape shape = Shape.union(elementTop.createShape(), elementBottom.createShape());
		shape = Shape.subtract(shape, line);
		shape.setFill(Color.web(this.mainColor));
		shape.setStroke(Color.web(this.borderColor));
		return shape;
	}

}
