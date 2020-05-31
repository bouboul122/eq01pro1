package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;


public class ArrowV1 extends ShapeEMR{

	ArrowV1(double xCoordinate, double yCoordinate, String mainColor, String borderColor) {
		super(xCoordinate, yCoordinate, mainColor, borderColor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Shape createShape() {
		// TODO Auto-generated method stub
		
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
	
	
	
	
	
    /*private static final double defaultArrowHeadSize = 5.0;
    
    public ArrowV1(double startX, double startY, double endX, double endY, double arrowHeadSize){
        super();
        strokeProperty().bind(fillProperty());
        setFill(Color.BLACK);
        
        //Line
        getElements().add(new MoveTo(startX, startY));
        getElements().add(new LineTo(endX, endY));
        
        //ArrowHead
        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        //point1
        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        //point2
        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        
        getElements().add(new LineTo(x1, y1));
        getElements().add(new LineTo(x2, y2));
        getElements().add(new LineTo(endX, endY));
    }
    
    public ArrowV1(double startX, double startY, double endX, double endY){
        this(startX, startY, endX, endY, defaultArrowHeadSize);
    }

	@Override
	public Shape createShape() {
		
		return null;
	}*/
}
