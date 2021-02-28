package securenotes.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import securenotes.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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

    public void save(ActionEvent actionEvent) {
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

    private void changeName(String newName){
        try {
            Path path = Paths.get("name.txt");
            FileWriter writer = new FileWriter(String.valueOf(path.toAbsolutePath()));
            writer.write(newName);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changePass(String newPass){
        try {
            Path path = Paths.get("password.txt");
            FileWriter writer = new FileWriter(String.valueOf(path.toAbsolutePath()));
            writer.write(newPass);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName(){
        try {
            Path path = Paths.get("name.txt");
            File nameFile = new File(String.valueOf(path.toRealPath()));
            Scanner reader = new Scanner(nameFile);
            String name = "";
            while (reader.hasNextLine()) {
                name = reader.nextLine();
            }
            reader.close();
            return name;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getPass(){
        try {
            Path path = Paths.get("password.txt");
            File passFile = new File(String.valueOf(path.toRealPath()));
            Scanner reader = new Scanner(passFile);
            String password = "";
            while (reader.hasNextLine()) {
                password = reader.nextLine();
            }
            reader.close();
            return password;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
