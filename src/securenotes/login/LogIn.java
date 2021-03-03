package securenotes.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import securenotes.user.User;
import java.io.IOException;
import java.net.URISyntaxException;

public class LogIn {

    /**************************************************************************************************************************************************************************************************
     * @author ghozti
     * This class will be the logIn.fxml controller. It contains the id for the button, username text field, passswor passwordField and logerror label
     * the login function will be called when the Button is pressed.
     * checklogin will create a Main.java object in order to change scenes
     * then it will create an user object in order to access the name and password.
     * it will check if the user's inputted name and password (gathered from the username text field and password passwordfield) are equal to the name and password in user.getName and user.getPassword
     * if the name and password correspond it will change the screen to the main screen (mainScreen.dxml)
     * if they do not correspond then it will simply put the "invalid user" message
     **************************************************************************************************************************************************************************************************/

    /***********************
     *logIn.fxml controller
     ***********************/

    @FXML
    private Button button;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label logerror;

    public void logIn(javafx.event.ActionEvent actionEvent) throws IOException, URISyntaxException {
        checkLogin();
    }

    private void checkLogin() throws IOException{
        securenotes.Main main = new securenotes.Main();
        User user = new User();
        if (username.getText().equals(user.getName()) && password.getText().equals(user.getPass())) {
            main.changeScene("scenes/mainScreen.fxml","Secure Notes", 970,660);
            logerror.setText("");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            logerror.setText("Please Enter Your Data");
        } else {
            logerror.setText("          Invalid User");
        }
    }
}
