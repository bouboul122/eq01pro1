package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;

public class PowerAmplificationLowerElement extends ShapeEMR{

	public PowerAmplificationLowerElement(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
	}

	@Override
	public Shape createShape() {
		ConversionPowerMonoElement element = new ConversionPowerMonoElement(xCoordinate, yCoordinate, mainColor, borderColor);
		Polyline line = new Polyline();
		
		line.getPoints().addAll(new Double[] {this.xCoordinate, this.yCoordinate,
				this.xCoordinate + element.getWidth(), this.yCoordinate + (element.getWidth()/2),
				this.xCoordinate, this.yCoordinate + element.getWidth()});
		line.setStrokeWidth(0.25);
		
		Shape shape = Shape.subtract(element.createShape(), line);
		shape.setFill(Color.web(this.mainColor));
		shape.setStroke(Color.web(this.borderColor));
		return shape;
	}

}
