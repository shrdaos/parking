
package com.uniquindio.edu.co.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new Pane(), 800, 600));
        stage.setTitle("HOla mundo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
