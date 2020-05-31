package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import model.AccumulationPowerElement;
import model.ShapeEMRFactory;
import model.Source;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class EMRController {
	
	ShapeEMRFactory shapeFactory = new ShapeEMRFactory();
	ClipboardContent content = new ClipboardContent();
	Dragboard db;
	
	Shape powerSource = shapeFactory.getShape(ShapeEMRFactory.eshape.sourcePower, 0, 0, "#98FB98", "#008000").createShape();
	Shape accumulationPower = shapeFactory.getShape(ShapeEMRFactory.eshape.accumulationPower, 0, 0, "#FFD700", "#FF0000").createShape();
	Shape conversionMonoPower = shapeFactory.getShape(ShapeEMRFactory.eshape.conversionMonoPower, 0, 0, "#FFD700", "#FF0000").createShape();
	Shape conversionMultiPower = shapeFactory.getShape(ShapeEMRFactory.eshape.conversionMultiPower, 0, 0, "#FFD700", "#FF0000").createShape();
	Shape couplingMonoPower = shapeFactory.getShape(ShapeEMRFactory.eshape.couplingMonoPower, 0, 0, "#FFD700", "#FF0000").createShape();
	Shape couplingMultiPower = shapeFactory.getShape(ShapeEMRFactory.eshape.couplingMultiPower, 0, 0, "#FFD700", "#FF0000").createShape();
	Shape amplificationGreaterPower = shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationGreaterPower, 0, 0, "#FFD700", "#FF0000").createShape();
	Shape amplificationLowerPower = shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationLowerPower, 0, 0, "#FFD700", "#FF0000").createShape();
	
	@FXML
	Pane drawingBoard = new Pane();
	@FXML
	Label statusLabel = new Label();
	@FXML
	MenuItem menuClose = new MenuItem();
	@FXML
	MenuItem deleteMenu = new MenuItem();
	@FXML
	MenuItem aboutMenu = new MenuItem();
	@FXML
	Button deleteButton = new Button();
	@FXML 
	Button moveButton = new Button();
	@FXML 
	Button simulateButton = new Button();
	@FXML
	Button alignButton = new Button();
	@FXML
	VBox powerVbox = new VBox();
	@FXML
	VBox controlVbox = new VBox();
	@FXML
	VBox estimationVbox = new VBox();
	@FXML
	VBox arrowVbox = new VBox();
	
	public void initialize() {
		//Adding in the power VBox//
		 powerVbox.setSpacing(10);
	     powerVbox.setAlignment(Pos.TOP_CENTER);
	        
		powerVbox.getChildren().add(powerSource);
		powerVbox.getChildren().add(accumulationPower);
		powerVbox.getChildren().add(conversionMonoPower);
		powerVbox.getChildren().add(conversionMultiPower);
		powerVbox.getChildren().add(couplingMonoPower);
		powerVbox.getChildren().add(couplingMultiPower);
		powerVbox.getChildren().add(amplificationGreaterPower);
		powerVbox.getChildren().add(amplificationLowerPower);
		
		
		//Adding in the control VBox//
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.accumulationInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationGreaterInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationLowerInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.conversionControlInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.couplingControlInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationLowerPower, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.controlStrategy, 0, 0, "#0000FF", "#0000FF").createShape());
		
		//Adding in the power VBox//
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.sourceEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.accumulationEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.conversionMonoEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.conversionMultiEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.couplingMultiEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.couplingMonoEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationGreaterEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationLowerEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		
		powerSource.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {
		        /* drag was detected, start a drag-and-drop gesture*/
		        /* allow any transfer mode */
		        db = powerSource.startDragAndDrop(TransferMode.ANY);
		        
		        /* Put a string on a dragboard */
		        content.putString("PowerSource");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		accumulationPower.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {
		        /* drag was detected, start a drag-and-drop gesture*/
		        /* allow any transfer mode */
		        db = accumulationPower.startDragAndDrop(TransferMode.ANY);
		        
		        /* Put a string on a dragboard */
		        content.putString("accumulationPower");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		couplingMonoPower.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {
		        /* drag was detected, start a drag-and-drop gesture*/
		        /* allow any transfer mode */
		        db = couplingMonoPower.startDragAndDrop(TransferMode.ANY);
		        
		        /* Put a string on a dragboard */
		        content.putString("couplingMonoPower");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		drawingBoard.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        /* data is dragged over the target */
		        /* accept it only if it is not dragged from the same node 
		         * and if it has a string data */
		        if (event.getGestureSource() != drawingBoard &&
		                event.getDragboard().hasString()) {
		        	statusLabel.setText("Dragging");
		            /* allow for both copying and moving, whatever user chooses */
		            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		        }
		        
		        event.consume();
		    }
		});
		
		drawingBoard.setOnDragDropped(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        /* data dropped */
		        /* if there is a string data on dragboard, read it and use it */
		        Dragboard db = event.getDragboard();
		        boolean success = false;
		        if (db.hasString()) {
		        	System.out.println("Allo");
		        	System.out.println(content.getString());
		        	if (content.getString().equals("PowerSource")){
		        		Shape newPowerSource = shapeFactory.getShape(ShapeEMRFactory.eshape.sourcePower, event.getX(), 
		        				event.getY(), "#98FB98", "#008000").createShape(); 
		        		drawingBoard.getChildren().add(newPowerSource);
		        		statusLabel.setText("Dropped");
		        		success = true;
		        	} else if (content.getString().equals("accumulationPower")){
		        		Shape newAccPowerElement = shapeFactory.getShape(ShapeEMRFactory.eshape.accumulationPower, event.getX(), 
		        				event.getY(), "#FFD700", "#FF0000").createShape();
		        		drawingBoard.getChildren().add(newAccPowerElement);
		        		statusLabel.setText("Dropped");
		        		success = true;
		        	} else if (content.getString().equals("couplingMonoPower")){
		        		Shape newCoupMonoPower = shapeFactory.getShape(ShapeEMRFactory.eshape.couplingMonoPower, event.getX(), 
		        				event.getY(), "#FFD700", "#FF0000").createShape();
		        		drawingBoard.getChildren().add(newCoupMonoPower);
		        		statusLabel.setText("Dropped");
		        		success = true;
		        	} 
		        }
		        /* let the source know whether the string was successfully 
		         * transferred and used */
		        event.setDropCompleted(success);
		        
		        event.consume();
		     }
		});
		
        }
	

	
	@FXML
	public void menuCloseClicked()
	{
		statusLabel.setText("Close menu Selected!");
	}
	
	@FXML
	public void deleteMenuClicked()
	{
		statusLabel.setText("Delete menu Selected!");
	}
    
	@FXML
	public void aboutMenuClicked()
	{
		statusLabel.setText("About menu Selected!");
	}
	
	@FXML
	public void deleteButtonClicked() 
	{	
		statusLabel.setText("Delete button Slected!");
	}
	
	@FXML
	public void moveButtonClicked() 
	{	
		statusLabel.setText("Move button Slected!");
	}
	@FXML
	public void simulateButtonClicked() 
	{	
		statusLabel.setText("Simulate button Slected!");
	}
	@FXML 
	public void alignButtonClicked() 
	{	
		statusLabel.setText("Align button Slected!");
	}
	
}
