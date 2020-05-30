package model;

import javafx.scene.shape.Shape;

public class CouplingPowerMultiElement extends ShapeEMR{

	public CouplingPowerMultiElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
	}

	@Override
	public Shape createShape() {
		ConversionPowerMultiElement elementTop = new ConversionPowerMultiElement(this.xCoordinate, this.yCoordinate, 
				this.mainColor, this.borderColor);
		ConversionPowerMultiElement elementBottom = new ConversionPowerMultiElement(
				this.xCoordinate + (2*elementTop.getRadius()/3), this.yCoordinate + (2*elementTop.getRadius()/3), 
				this.mainColor, this.borderColor);
		return null;
	}

}
