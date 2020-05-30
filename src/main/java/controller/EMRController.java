package controller;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class EMRController {
	
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
	
	public void initialize() {
		
		
		
		
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
