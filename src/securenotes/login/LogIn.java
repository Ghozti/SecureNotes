package securenotes.login;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LogIn {

    public LogIn(){
    }

    @FXML
    private Button button;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label logerror;

    public void userLogIn() throws IOException {
        securenotes.Main main = new Main();
        if (username.getText().equals("ghost") && password.getText().equals("123")){
            main.changeScene();
        }else if (username.getText().isEmpty() && password.getText().isEmpty()){
            logerror.setText("Please Enter Your Data");
        }else {
            logerror.setText("Invalid User");
        }
    }
}
