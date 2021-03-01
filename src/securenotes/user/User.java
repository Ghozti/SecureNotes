package securenotes.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import securenotes.Main;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


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
            infoError.setText("Incorrect Credentials");
        }
    }

    private void changeName(String newName) throws IOException {
        Files.write(Paths.get("").resolve("out/artifacts/SecureNotes_jar/details/name.txt"), newName.getBytes(), StandardOpenOption.CREATE);
    }

    private void changePass(String newPass) throws IOException {
        Files.write(Paths.get("").resolve("out/artifacts/SecureNotes_jar/details/name.txt"), newPass.getBytes(), StandardOpenOption.CREATE);
    }

    public String getName() throws IOException{
        System.out.println(readResource("/name.txt"));
        return readResource("/name.txt");
    }

    public String getPass() throws IOException{
        return readResource("/password.txt");
    }

    private String readResource(String name) throws IOException {
        try(var stream = getClass().getResourceAsStream(name)) {
            System.out.println(getClass().getResourceAsStream(name));
            return new String((stream).readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    //TODO maybe make this program create a folder to store the new name.txt and password.txt to be able to read and write
}
