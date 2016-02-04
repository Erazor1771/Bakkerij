
package controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Profile;
import org.apache.commons.io.FileUtils;

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
    @FXML
    private Button uploadLogoBTN;
    @FXML
    private ImageView logoView;
    @FXML
    private Label logoPathLabel;

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
                         pf.makeProfile(naamInput.getText(),straatInput.getText(),Integer.parseInt(huisnummerInput.getText()),plaatsInput.getText(), logoPathLabel.getText());
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

    @FXML
    private void clickLogoButton(ActionEvent event) throws MalformedURLException, IOException, URISyntaxException {
        
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Select Image File");
        filechooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter(
                    "Image Files","*.bmp", "*.png", "*.jpg", "*.gif")
            ); // limit chooser options to image files
        
        File selectedFile = filechooser.showOpenDialog(logoPathLabel.getScene().getWindow());
        
        if(selectedFile != null) {
            String pathToFile = selectedFile.getPath();
            String filename = selectedFile.getName();
            System.out.println(filename);
            String imageFile = selectedFile.toURI().toURL().toString();
            logoPathLabel.setText(pathToFile);
            
            //pf.selectAndCopyLogo(pathToFile, "C:/Users/lars/"); // copy logo to project directory (source, destination)
            
            Image image = new Image(imageFile);
            logoView.setImage(image);
            
            File source = new File(pathToFile);
            File dest = new File(getRoot() + filename);
            
            try {
                FileUtils.copyFile(source, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        else
        {
            logoPathLabel.setText("Image file selection cancelled.");
        }
    }
    
      public String getRoot() throws IOException, URISyntaxException{
        URL u = getClass().getProtectionDomain().getCodeSource().getLocation();
        File f = new File(u.toURI());
        String rootPath = f.getParent();
        return rootPath;
      }

}
