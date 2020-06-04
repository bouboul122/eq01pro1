package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import model.ArrowV1;
import model.ControlStrategyElement;
import model.ConversionPowerMonoElement;
import model.ConversionPowerMultiElement;
import model.CouplingPowerMonoElement;
import model.CouplingPowerMultiElement;
import model.PowerAmplificationGreaterElement;
import model.PowerAmplificationLowerElement;
import model.InversionAccumulationControlElement;
import model.InversionAmplificationControlElementGreater;
import model.InversionAmplificationControlElementLower;
import model.InversionConversionControlElement;
import model.InversionCouplingControlElement;
import model.Source;

/*
 * Cette classe contient la vue dans le modele MVC
 */
public class EMRDrawer extends Application {
	
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/eq01pro1.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

