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

    /*******************************************************************************************************************
     * @author ghozti
     * The User class is an utility and changeInfo controller class
     *     @FXML
     *     TextField oPass; <-- this is the old password text field
     *
     *     @FXML
     *     TextField nPass; <-- this is the new password text field
     *
     *     @FXML
     *     TextField oName; <-- this is the old name text field
     *
     *     @FXML
     *     TextField nName; <-- this is the new name text field
     *
     *     @FXML
     *     Button savebtn; <-- this is the button displayed in the screen
     *
     *     @FXML
     *     Label infoError; <-- this label will be called if the user entered invalid credits
     *     @FXML
     *     Label goodInfo; <-- this label will be called if the change was successful
     *
     *     the save method will be called once the user presses the button displayed in the screen it will check to see
           if the credentials match if so it will set the new name and password to what the user chose.

     *      changeName will be simply get the name.txt in the created folder (see details creator)
            and override the text to the new text (same for changePass)

     *      getName and getPass will each get the text from name.txt and password.txt
     ******************************************************************************************************************/

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