package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class ControlStrategyElement extends ShapeEMR{

	private int height;
	private int width;
	public ControlStrategyElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
		// TODO Auto-generated constructor stub
		height = 21;
		width = height * 3;
	}

	@Override
	public Shape createShape() {
		
		Polygon element = new Polygon();
		element.getPoints().addAll(new Double[] {
				this.xCoordinate, this.yCoordinate,
				this.xCoordinate - this.width/4, this.yCoordinate +height,
				this.xCoordinate + 3*this.width/4, this.yCoordinate + height,
				this.xCoordinate + this.width, this.yCoordinate
			
		});
		
		element.setFill(Color.web(this.mainColor));
		element.setStroke(Color.web(this.borderColor));
		return element;
	}

}
