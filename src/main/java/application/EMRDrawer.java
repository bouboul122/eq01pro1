package application;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AccumulationPowerElement;
import model.ConversionPowerMonoElement;
import model.ConversionPowerMultiElement;
import model.CouplingPowerMonoElement;

import model.CouplingPowerMultiElement;

import model.InversionAccumulationControlElement;
import model.InversionAmplificationControlElementGreater;
import model.InversionAmplificationControlElementLower;
import model.InversionConversionControlElement;
import model.InversionCouplingControlElement;

import model.Source;

public class EMRDrawer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	
    	AnchorPane drawingBoard = new AnchorPane();
    	BorderPane borderpane = new BorderPane();
    	borderpane.setTop(addTop());
    	borderpane.setLeft(addShapeMenu());
    	borderpane.setBottom(new Label("Welcome to the drawing board"));
    	borderpane.setCenter(drawingBoard);
    	
    	CouplingPowerMultiElement element = new CouplingPowerMultiElement(300, 300, "#FFD700", "#FF0000");
    	drawingBoard.getChildren().add(element.createShape());
		
		Scene scene = new Scene(borderpane);
		stage.setScene(scene);
		stage.setTitle("EMR Drawer");
		stage.show();
    	
        
    }
    
    private Node addTop()
    {
    	VBox vbox = new VBox();
    	
    	final Menu fileMenu = new Menu("File");
    	final Menu editMenu = new Menu("Edit");
    	final Menu helpMenu = new Menu("Help");
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(fileMenu);
		menuBar.getMenus().add(editMenu);
		menuBar.getMenus().add(helpMenu);

		vbox.getChildren().add(menuBar);
		
		ToolBar toolBar = new ToolBar(new Button("New"), new Button("Open"), new Button("Save"), new Separator(),
				new Button("Clean"), new Button("Compile"), new Button("Run"), new Separator(),new Button("Profile"));

		vbox.getChildren().add(toolBar);
		return vbox;
    }
    
    private Node addShapeMenu() {

		TitledPane power = new TitledPane("Power", new VBox(new Source(300, 300, "#98FB98", "#008000").createShape(),
				new AccumulationPowerElement(300, 300, "#FFD700", "#FF0000").createShape(),
				new ConversionPowerMonoElement(300, 300, "#FFD700", "#FF0000").createShape(),
				new ConversionPowerMultiElement(300, 300, "#FFD700", "#FF0000").createShape(),
				new CouplingPowerMonoElement(300, 300, "#FFD700", "#FF0000").createShape()));
			
		TitledPane control = new TitledPane("Control", new VBox(new InversionConversionControlElement(300, 300, "#87CEEB","#0000FF").createShape(),
				new InversionAccumulationControlElement(300, 300, "#87CEEB","#0000FF").createShape(),
				new InversionCouplingControlElement(300, 300, "#87CEEB","#0000FF").createShape(),
				new InversionAmplificationControlElementGreater(300, 300, "#87CEEB","#0000FF").createShape(),
				new InversionAmplificationControlElementLower(300, 300, "#87CEEB","#0000FF").createShape()));
		
		TitledPane estimation = new TitledPane("Estimation", new VBox());
		Accordion accordion = new Accordion();
		accordion.getPanes().addAll(power, control, estimation);

		return accordion;
	}

    public static void main(String[] args) {
    	launch(args);
    }
}

