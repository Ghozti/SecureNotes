package securenotes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    Stage stage;

    /**
     * sets the first scene (log in scene)
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        DetailsCreator detailsCreator = new DetailsCreator();
        detailsCreator.createFiles();
        stage = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("scenes/logIn.fxml"));
        primaryStage.setTitle("Secure Notes Login");
        primaryStage.setScene(new Scene(root, 755, 450));//w x h
        primaryStage.show();
    }

    /**
     * This method can be used to switch between scenes with the fxml parameter
     */

    public void changeScene(String fxml,String name, double w, double h) throws IOException {
        Stage stg = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.setTitle(name);
        stg.setMaxHeight(h);
        stg.setMaxWidth(w);
        stg.setResizable(false);
        stg.setScene(new Scene(root,w,h));
        stg.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
