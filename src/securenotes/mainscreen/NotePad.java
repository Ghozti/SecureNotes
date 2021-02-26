package securenotes.mainscreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;

public class NotePad {

    @FXML
    ScrollBar scrollbar;

    @FXML
    MenuButton options;

    @FXML
    TextArea noteArea;

    public String getTextToString(){
        String s = noteArea.getText();
        return s;
    }

    public void saveFile(ActionEvent actionEvent) {
        System.out.println(getTextToString());
    }

    public void encrypt(ActionEvent actionEvent) {
    }

    public void openFile(ActionEvent actionEvent) {
    }
}
