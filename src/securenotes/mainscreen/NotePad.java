package securenotes.mainscreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import securenotes.Main;
import securenotes.decryptor.Decryptor;
import securenotes.encryptor.Encryptor;

import java.io.*;
import java.util.Scanner;


public class NotePad {

    /***********************
     *mainScreen.fxml controller
     ***********************/

    @FXML
    MenuButton options;

    @FXML
    TextArea noteArea;

    private String getTextToString(){
        return noteArea.getText();
    }

    public void encrypt(ActionEvent actionEvent) {
        noteArea.setText(new Encryptor().encrypt(getTextToString()));
    }

    public void decryptText(ActionEvent actionEvent) {
        noteArea.setText(new Decryptor().decrypt(getTextToString()));
    }

    public void saveFile(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        try {
            FileWriter myWriter = new FileWriter(selectedFile);
            myWriter.write(noteArea.getText());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void openFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        try {
            if (selectedFile != null) {
                Scanner reader = new Scanner(selectedFile);
                while (reader.hasNextLine()) {
                    noteArea.setText(reader.nextLine());
                }
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void openDetailMenu(ActionEvent actionEvent) throws IOException {
        Main main = new Main();
        main.changeScene("scenes/changeInfo.fxml","secure notes", 585,430);
    }
}
