package securenotes.mainscreen;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
