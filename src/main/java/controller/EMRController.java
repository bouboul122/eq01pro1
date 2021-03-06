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

/*
 * Cette classe fait partie du controlleur dans le modele de conception MVC
 */

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
	Shape arrow = shapeFactory.getShape(ShapeEMRFactory.eshape.arrowV1, 0, 0, "#060606", "#060606").createShape();
	
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
		controlVbox.setSpacing(10);
	    controlVbox.setAlignment(Pos.TOP_CENTER);
	     
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.accumulationInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationGreaterInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationLowerInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.conversionControlInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.couplingControlInversion, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationLowerPower, 0, 0, "#87CEEB", "#0000FF").createShape());
		controlVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.controlStrategy, 0, 0, "#0000FF", "#0000FF").createShape());
		
		//Adding in the estimation VBox//
		estimationVbox.setSpacing(10);
	    estimationVbox.setAlignment(Pos.TOP_CENTER);
	    
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.sourceEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.accumulationEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.conversionMonoEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.conversionMultiEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.couplingMultiEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.couplingMonoEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationGreaterEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		estimationVbox.getChildren().add(shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationLowerEstimation, 0, 0, "#EE82EE", "#0000FF").createShape());
		
		arrowVbox.getChildren().add(arrow);
		
		powerSource.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {

		        db = powerSource.startDragAndDrop(TransferMode.ANY);
		        

		        content.putString("PowerSource");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		accumulationPower.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {

		        db = accumulationPower.startDragAndDrop(TransferMode.ANY);

		        content.putString("accumulationPower");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		conversionMonoPower.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {

		        db = conversionMonoPower.startDragAndDrop(TransferMode.ANY);
		        

		        content.putString("conversionMonoPower");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		conversionMultiPower.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {
		        db = conversionMultiPower.startDragAndDrop(TransferMode.ANY);
		        

		        content.putString("conversionMultiPower");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		couplingMonoPower.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {
		        db = couplingMonoPower.startDragAndDrop(TransferMode.ANY);
		        
		        content.putString("couplingMonoPower");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		amplificationGreaterPower.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {

		        db = amplificationGreaterPower.startDragAndDrop(TransferMode.ANY);
		        

		        content.putString("amplificationGreaterPower");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		amplificationLowerPower.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {

		        db = amplificationLowerPower.startDragAndDrop(TransferMode.ANY);
		        

		        content.putString("amplificationLowerPower");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		couplingMultiPower.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {

		        db = couplingMultiPower.startDragAndDrop(TransferMode.ANY);
		        

		        content.putString("couplingMultiPower");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		arrow.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {

		        db = powerSource.startDragAndDrop(TransferMode.ANY);
		        

		        content.putString("Arrow");
		        statusLabel.setText(content.getString());
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
		
		drawingBoard.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {

		        if (event.getGestureSource() != drawingBoard &&
		                event.getDragboard().hasString()) {
		        	statusLabel.setText("Dragging");

		            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		        }
		        
		        event.consume();
		    }
		});
		
		drawingBoard.setOnDragDropped(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        Dragboard db = event.getDragboard();
		        boolean success = false;
		        if (db.hasString()) {
		        	System.out.println("Allo");
		        	System.out.println(content.getString());
		        	if (content.getString().equals("PowerSource")){
		        		Shape newPowerSource = shapeFactory.getShape(ShapeEMRFactory.eshape.sourcePower, event.getX(), 
		        				event.getY(), "#98FB98", "#008000").createShape();
		        		Label source = new Label("Source");
		        		source.setLayoutX(event.getX()- 15);
		        		source.setLayoutY(event.getY() - 10);
		        		drawingBoard.getChildren().addAll(newPowerSource, source);
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
		        	} else if (content.getString().equals("Arrow")){
		        		Shape newArrow = shapeFactory.getShape(ShapeEMRFactory.eshape.arrowV1, event.getX(), 
		        				event.getY(), "#060606", "#060606").createShape();
		        		drawingBoard.getChildren().add(newArrow);
		        		statusLabel.setText("Dropped");
		        		success = true;
		        	} else if (content.getString().equals("conversionMonoPower")){
		        		Shape newArrow = shapeFactory.getShape(ShapeEMRFactory.eshape.conversionMonoPower, event.getX(), 
		        				event.getY(), "#FFD700", "#FF0000").createShape();
		        		drawingBoard.getChildren().add(newArrow);
		        		statusLabel.setText("Dropped");
		        		success = true;
		        	} else if (content.getString().equals("conversionMultiPower")){
		        		Shape newArrow = shapeFactory.getShape(ShapeEMRFactory.eshape.conversionMultiPower, event.getX(), 
		        				event.getY(), "#FFD700", "#FF0000").createShape();
		        		drawingBoard.getChildren().add(newArrow);
		        		statusLabel.setText("Dropped");
		        		success = true;
		        	} else if (content.getString().equals("amplificationGreaterPower")){
		        		Shape newArrow = shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationGreaterPower, event.getX(), 
		        				event.getY(), "#FFD700", "#FF0000").createShape();
		        		drawingBoard.getChildren().add(newArrow);
		        		statusLabel.setText("Dropped");
		        		success = true;
		        	} else if (content.getString().equals("amplificationLowerPower")){
		        		Shape newArrow = shapeFactory.getShape(ShapeEMRFactory.eshape.amplificationLowerPower, event.getX(), 
		        				event.getY(), "#FFD700", "#FF0000").createShape();
		        		drawingBoard.getChildren().add(newArrow);
		        		statusLabel.setText("Dropped");
		        		success = true;
		        	} else if (content.getString().equals("couplingMultiPower")){
		        		Shape newArrow = shapeFactory.getShape(ShapeEMRFactory.eshape.couplingMultiPower, event.getX(), 
		        				event.getY(), "#FFD700", "#FF0000").createShape();
		        		drawingBoard.getChildren().add(newArrow);
		        		statusLabel.setText("Dropped");
		        		success = true;
		        	}
		        }
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
