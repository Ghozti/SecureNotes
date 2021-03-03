package securenotes.mainscreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import securenotes.Main;
import securenotes.decryptor.Decryptor;
import securenotes.encryptor.Encryptor;
import java.io.*;



public class NotePad {

    /***********************************************************************************************************************************
     * @author ghozti
     * This class is the main atraction for the app and the mainScreen.fxml controller
     * it creates a method called getTextToString which will be used to get the note area's user inputted text.
     * the encrypt, decrypt, saveFile,openFile and openDetailMenu methods are all called when an user interacts with something in the UI
     * encrypt will create an encryptor object and call it's encrypt method along with adding the note area string as it's argument
     * decrypt will do the same except it calls the decryptor
     * Savefile and open file will be called when the user chooses "save" or "open" respectively. This method will open file explorer to
       either save the current note area into a new or existing file.
     * openDetailMenu will create a main object and change the scene to "changeInfo.fxml"
     **********************************************************************************************************************************/

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
        Window stage = options.getScene().getWindow();
        fileChooser.setTitle("save");
        fileChooser.setInitialFileName("myNote");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file","*.txt"));
        try {
            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            FileWriter writer = new FileWriter(file);
            writer.write(noteArea.getText());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        Window stage = options.getScene().getWindow();
        fileChooser.setTitle("open");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file","*.txt"));
        try {
            File file = fileChooser.showOpenDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                String line = reader.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = reader.readLine();
                }
                noteArea.setText(sb.toString());
            } finally {
                reader.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openDetailMenu(ActionEvent actionEvent) throws IOException {
        Main main = new Main();
        main.changeScene("scenes/changeInfo.fxml","secure notes credentials changer", 585,430);
    }
}
