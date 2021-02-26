package securenotes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("scenes/logIn.fxml"));
        primaryStage.setTitle("Secure Notes Login");
        primaryStage.setScene(new Scene(root, 755, 450));//w x h
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Stage stg = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.setTitle("Secure Notes");
        stg.setMaxHeight(651);
        stg.setMaxWidth(964);
        stg.setResizable(true);
        stg.setScene(new Scene(root,964,651));
        stg.show();
        //stg.getScene().setRoot(root);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
