
package com.uniquindio.edu.co.application;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.Utilities;

import com.uniquindio.edu.co.application.controllers.DashboardController;
import com.uniquindio.edu.co.application.controllers.LoginController;
import com.uniquindio.edu.co.application.controllers.ReservationController;
import com.uniquindio.edu.co.application.controllers.ReservationsDetailsController;
import com.uniquindio.edu.co.application.models.Parking;
import com.uniquindio.edu.co.application.models.Space;
import com.uniquindio.edu.co.application.models.SpaceRecord;
import com.uniquindio.edu.co.application.models.User;
import com.uniquindio.edu.co.application.models.Utils;
import com.uniquindio.edu.co.application.models.enums.UserRole;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class App extends Application {
    private User sesionUser;
    private Stage primaryStage;
    private Stage secondaryStage;
	private Parking parking;
    @Override
    public void start(Stage stage) throws Exception {
		this.parking = new Parking("Parqueadero Quindio",1500.0,2000.0,1500.0, new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
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
	}
	//show
	public void showReservation(Label lblColor, VBox card, int i, int j) {
		this.secondaryStage = new Stage();
		try {

			ArrayList<String> userClientsNamesAndIdentification = parking.getUserClientNamesAndIdentification();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/ReservationView.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();
			ReservationController controller = loader.getController();
			controller.setMain(this, userClientsNamesAndIdentification,lblColor,card,i,j);
			Scene scene = new Scene(rootLayout);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public ArrayList<String> getVehiclesLicensePlateAndModelByUserId(String userId) throws Exception {
		return parking.getVehiclesLicensePlateAndModelByUserId(userId);
	}

	public void handleSpaceClicked(Label lblColor, VBox card, int i, int j) {
		if(parking.isFreeSpace(i,j)){
			showReservation(lblColor, card, i, j);
		}else{
			showReservationDetails(lblColor, card, i, j);
		}
	}

	private void showReservationDetails(Label lblColor, VBox card, int i, int j) {
		Space space;
		try {
			space = parking.getSpaceUsingPosition(i, j);
			User user = parking.getPropietaryByLicensePlate(space.getVehicle().getLicensePlate());
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/ReservationDetailsView.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();
			ReservationsDetailsController controller = loader.getController();
			controller.setMain(this,space,user,lblColor,card);
			Scene scene = new Scene(rootLayout);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean reserveSpace(String userIdentification, String vehicleLicensePlate, LocalDateTime selectedDateTime,
			int i, int j) throws Exception {
		return parking.reserveSpace(userIdentification,vehicleLicensePlate,selectedDateTime,i,j);
	}

	public void closeSecundaryView() {
		this.secondaryStage.close();
	}

    public Double getReservationAmmount(LocalDateTime endDate, int positionI, int positionJ) throws Exception {
		return parking.getReservationAmmount(endDate,positionI,positionJ);
    }

	public Double endReservation(LocalDateTime now, int positionI, int positionJ) throws Exception {
		return parking.endReservation(now,positionI,positionJ);
	}

	public List<SpaceRecord> getRecordList() {
		return parking.getRecordList();
	}

	public Double getCarFee() {
		return parking.getCarFee();
	}

	public Double getHybridMotorcycleFee() {
		return parking.getHybridMotorcicleFee();
	}

	public Double getClassicMotorcycleFee() {
		return parking.getClassicMotorcicleFee();
	}

    public void updateCarFee(double newFee) {
		parking.setCarFee(newFee);
    }

	public void updateClassicMotorcycleFee(double newFee) {
		parking.setClassicMotorcicleFee(newFee);
	}

    public void updateHybridMotorcycle(double newFee) {
		parking.setHybridMotorcicleFee(newFee);
    }

	public List<SpaceRecord> getAllRecords() {
		//return parking.getRecordList();
		List<SpaceRecord> list  = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			SpaceRecord spaceRecord = new SpaceRecord(LocalDateTime.now(), LocalDateTime.now(), "model "+i,
			 ""+(i*100), "119337091"+i, i, (i*2*2), i+(i*34));
			 list.add(spaceRecord);
		}

		return list;
	}
}
