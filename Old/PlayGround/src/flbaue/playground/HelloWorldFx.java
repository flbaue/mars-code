package flbaue.playground;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 02.07.13
 * Time: 17:34
 */
public class HelloWorldFx extends Application {

    Label lable;
    Button button;

    @Override
    public void init(){
        lable = new Label("Hello World");
        button = new Button("Click Me!");
    }

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        root.getChildren().add(lable);
        root.getChildren().add(button);

        Scene scene = new Scene(root,200,200);

        stage.setTitle("Hello World App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);

    }
}
