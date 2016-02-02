
package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Profile;

/**
 * FXML Controller class
 *
 * @author lars
 */
public class ProfileController implements Initializable {
    @FXML
    private Button makeProfileBTN;
    @FXML
    private TextField naamInput;
    @FXML
    private TextField straatInput;
    @FXML
    private TextField huisnummerInput;
    @FXML
    private TextField plaatsInput;
    
    Profile pf;
    @FXML
    private Label naamError;
    @FXML
    private Label straatError;
    @FXML
    private Label plaatsError;
    @FXML
    private Label huisnummerError;

    public ProfileController() throws SQLException {
        this.pf = new Profile();
    }

    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickProfileButton(ActionEvent event) throws SQLException {
        
        naamError.setText(null);
        straatError.setText(null);
        huisnummerError.setText(null);
        plaatsError.setText(null);
        
        if (!naamInput.getText().isEmpty()) {
            if (!straatInput.getText().isEmpty()) {
                if (!huisnummerInput.getText().isEmpty()){
                    if (!plaatsInput.getText().isEmpty()) {
                         pf.makeProfile(naamInput.getText(),straatInput.getText(),Integer.parseInt(huisnummerInput.getText()),plaatsInput.getText());
                    } else {
                        plaatsError.setText("Plaats is nog leeg");
                    }
                } else {
                    huisnummerError.setText("Huisnummer is nog leeg");
                }
            } else {
                straatError.setText("Straat is nog leeg");
            }
        } else {
            naamError.setText("Naam is nog leeg");
        }        
    }
    
}
