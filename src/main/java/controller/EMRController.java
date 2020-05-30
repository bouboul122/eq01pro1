package controller;

import javafx.fxml.FXML;
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

}
