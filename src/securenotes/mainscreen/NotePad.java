package securenotes.mainscreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;

public class NotePad {

    @FXML
    ScrollBar scrollbar;

    @FXML
    MenuButton options;

    @FXML
    TextArea noteArea;

    public String getTextToString(){
        return noteArea.getText();
    }

    public void saveFile(ActionEvent actionEvent) {
        System.out.println(getTextToString());
    }

    public void encrypt(ActionEvent actionEvent) {
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
}
