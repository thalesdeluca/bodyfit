import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login/login.fxml"));
        Font.loadFont(getClass().getResourceAsStream("./resources/fonts/Khand-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("./resources/fonts/Khand-Bold.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("./resources/fonts/Khand-Light.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("./resources/fonts/Raleway-Bold.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("./resources/fonts/Raleway-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("./resources/fonts/Raleway-Thin.ttf"), 14);
        primaryStage.setTitle("BodyFit");
        primaryStage.setScene(new Scene(root, 768, 450));
        primaryStage.setResizable(true);
        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(768);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
