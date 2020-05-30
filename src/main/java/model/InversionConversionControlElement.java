package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import javafx.scene.shape.Shape;



public class InversionConversionControlElement extends ShapeEMR{
	
	private double width;
	
	public InversionConversionControlElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
	
		this.width = 21;
	
	}

	@Override
	public Shape createShape() {
		
		Polygon element = new Polygon();
		element.getPoints().addAll(new Double[] {
				this.xCoordinate, this.yCoordinate,
				this.xCoordinate - this.width/4, this.yCoordinate +width,
				this.xCoordinate + 3*this.width/4, this.yCoordinate + width,
				this.xCoordinate + this.width, this.yCoordinate
			
		});
		
		element.setFill(Color.web(this.mainColor));
		element.setStroke(Color.web(this.borderColor));
		
		return element;
	}
	public double getWidth() {
		return width;
	}
}
