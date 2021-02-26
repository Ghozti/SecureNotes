package securenotes.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import securenotes.mainscreen.NotePad;

import java.io.IOException;

public class LogIn {

    @FXML
    private Button button;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label logerror;

    public void logIn(javafx.event.ActionEvent actionEvent) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        securenotes.Main main = new securenotes.Main();
        if (username.getText().equals("ghost") && password.getText().equals("123")) {
            main.changeScene("scenes/mainScreen.fxml");
            logerror.setText("");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            logerror.setText("Please Enter Your Data");
        } else {
            logerror.setText("          Invalid User");
        }
    }
}
