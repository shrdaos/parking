
package com.uniquindio.edu.co.application;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Utilities;

import com.uniquindio.edu.co.application.controllers.DashboardController;
import com.uniquindio.edu.co.application.controllers.LoginController;
import com.uniquindio.edu.co.application.models.Parking;
import com.uniquindio.edu.co.application.models.Space;
import com.uniquindio.edu.co.application.models.User;
import com.uniquindio.edu.co.application.models.Utils;
import com.uniquindio.edu.co.application.models.enums.UserRole;

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
	private Parking parking;
    @Override
    public void start(Stage stage) throws Exception {
		this.parking = new Parking("Parqueadero Quindio",1.0,1.0,1.0, new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
		parking.burnData();

        try {
			this.primaryStage = stage;
			this.primaryStage.setTitle(this.parking.getName() != null? this.parking.getName():"Parqueadero");
			//showLogin();
			showDashboard();
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


	public void loginUser(String email, String password) throws Exception {
		User user =  this.parking.getUserByCredentials(email, password);
		this.sesionUser = user;
		System.out.println(user.toString());

		if(user.getUserRole().equals(UserRole.ADMIN) ){
			showDashboard();
		}else{
			showClientView();
		}
	}


	private void showClientView() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'showClientView'");
	}


	private void showDashboard() {
		int totalSpaces = Utils.getNaturalIntegerJOption("Ingrese la cantidad total de espacios en el parqueadero");
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/DashboardView.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();
			DashboardController controller = loader.getController();
			controller.setMain(this,totalSpaces);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSpaces(List<Space> spaces) {
		parking.setSpaceList(spaces);
	}
}
