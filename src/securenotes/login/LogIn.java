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
