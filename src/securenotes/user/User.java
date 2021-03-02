package securenotes.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import securenotes.Main;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class User {
    /***************************
     * changeInfo controller****
     **************************/

    @FXML
    TextField oPass;

    @FXML
    TextField nPass;

    @FXML
    TextField oName;

    @FXML
    TextField nName;

    @FXML
    Button savebtn;

    @FXML
    Label infoError;

    @FXML
    Label goodInfo;

    public void save(ActionEvent actionEvent) throws IOException, URISyntaxException {
        Main main = new Main();
        if (oName.getText().equals(getName()) && oPass.getText().equals(getPass())){
            changeName(nName.getText());
            changePass(nPass.getText());
            infoError.setText("");
            goodInfo.setText("success! you may close this now");
        }else {
            infoError.setText("Invalid Credentials");
        }
    }

    private void changeName(String newName) throws IOException {
        File directory = new File(System.getProperty("user.home") + "/SecureNotesDetails/name.txt").getAbsoluteFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(directory));
        writer.write(newName);
        writer.close();
    }


    private void changePass(String newPass) throws IOException {
        File directory = new File(System.getProperty("user.home") + "/SecureNotesDetails/password.txt").getAbsoluteFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(directory));
        writer.write(newPass);
        writer.close();
    }

    public String getName() throws IOException{
        File directory = new File(System.getProperty("user.home") + "/SecureNotesDetails/name.txt").getAbsoluteFile();
        String content;
        content = new String(Files.readAllBytes(Paths.get(String.valueOf(directory))));
        return content;
    }

    public String getPass() throws IOException{
        File directory = new File(System.getProperty("user.home") + "/SecureNotesDetails/password.txt").getAbsoluteFile();
        String content;
        content = new String(Files.readAllBytes(Paths.get(String.valueOf(directory))));
        return content;
    }
}
