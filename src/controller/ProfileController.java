
package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author lars
 */
public class ProfileController implements Initializable {
    
    @FXML
    private BorderPane bp;
    @FXML
    private Button button1;
    @FXML
    private Label leftLabel;
    @FXML
    private Label bottomLabel;
    @FXML
    private Label centerLabel;
    @FXML
    private Label rightLabel;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
       double width = screensize.getWidth() - ((screensize.getWidth() / 100) * 10);
       double height = screensize.getHeight() - ((screensize.getHeight() / 100) * 15); 
       
       // Set Width & Height Application
       bp.setPrefWidth(width);
       bp.setPrefHeight(height);
       
       
       // Set Size Labels
       leftLabel.setStyle("-fx-background-color: #333;");
       centerLabel.setStyle("-fx-background-color: #000;");
       rightLabel.setStyle("-fx-background-color: #333;");
       
       leftLabel.setLayoutX(0);
       centerLabel.setLayoutX(width / 2);
       rightLabel.setLayoutX((width / 4) + (width / 2));
       
       leftLabel.setPrefWidth(width / 4);
       centerLabel.setPrefWidth(width / 2);
       rightLabel.setPrefWidth(width/ 4);
       
      
       
       // Set Dynamic Width
       button1.setPrefWidth(width / 20);
    
       
       
    }   
    
}
