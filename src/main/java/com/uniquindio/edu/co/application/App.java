
package com.uniquindio.edu.co.application;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;

import com.uniquindio.edu.co.application.controllers.LoginController;
import com.uniquindio.edu.co.application.models.User;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class App extends Application {
    private User sesionUser;
    private Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {

        try {
			this.primaryStage = stage;
			this.primaryStage.setTitle("Laberinto");
			showLogin();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    

    private void showLogin() {
        try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/LoginView.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();
			LoginController controller = loader.getController();
			controller.setMain(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        launch(args);
    }
}
