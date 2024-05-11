package com.uniquindio.edu.co.application.controllers;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.uniquindio.edu.co.application.App;
import com.uniquindio.edu.co.application.models.Space;
import com.uniquindio.edu.co.application.models.User;
import com.uniquindio.edu.co.application.models.Utils;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ReservationsDetailsController implements Initializable {
    private App app;
    private Label lblColor;
    private VBox card;
    private Space space;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label emailLbl;

    @FXML
    private Label identificationLbl;

    @FXML
    private Label lisencePlateLbl;

    @FXML
    private Label modelLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label reservationDateLbl;

    @FXML
    private Label rolLbl;

    @FXML
    private Label totalVehiclesLbl;

    @FXML
    void endReservationAction(ActionEvent event) {
        System.out.println("terminando reservacion");
        try {
            System.out.println("haciendo llamado");
            
            Double amount = app.endReservation(LocalDateTime.now(),space.getPositionI(),space.getPositionJ()); 
            System.out.println(amount);
            lblColor.setStyle(  "-fx-background-color: #48E120");
            card.setStyle("-fx-border-color: #48E120");
            app.closeSecundaryView();
            
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showErrorMessage("Error", e.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert emailLbl != null : "fx:id=\"emailLbl\" was not injected: check your FXML file 'ReservationDetailsView.fxml'.";
        assert identificationLbl != null : "fx:id=\"identificationLbl\" was not injected: check your FXML file 'ReservationDetailsView.fxml'.";
        assert lisencePlateLbl != null : "fx:id=\"lisencePlateLbl\" was not injected: check your FXML file 'ReservationDetailsView.fxml'.";
        assert modelLbl != null : "fx:id=\"modelLbl\" was not injected: check your FXML file 'ReservationDetailsView.fxml'.";
        assert nameLbl != null : "fx:id=\"nameLbl\" was not injected: check your FXML file 'ReservationDetailsView.fxml'.";
        assert reservationDateLbl != null : "fx:id=\"reservationDateLbl\" was not injected: check your FXML file 'ReservationDetailsView.fxml'.";
        assert rolLbl != null : "fx:id=\"rolLbl\" was not injected: check your FXML file 'ReservationDetailsView.fxml'.";
        assert totalVehiclesLbl != null : "fx:id=\"totalVehiclesLbl\" was not injected: check your FXML file 'ReservationDetailsView.fxml'.";

    }

    public void setMain(App app, Space space,User user, Label lblColor, VBox card) {
        this.app = app;
        this.lblColor = lblColor;
        this.card = card;
        this.space = space;
        nameLbl.setText(user.getName());
        identificationLbl.setText(user.getIdentification());
        emailLbl.setText(user.getEmail());
        rolLbl.setText(user.getUserRole().name());
        totalVehiclesLbl.setText(" " +user.getTotalVehicles());
        reservationDateLbl.setText(space.getStartTime().toString());
        modelLbl.setText(space.getVehicle().getModel());
        lisencePlateLbl.setText(space.getVehicle().getLicensePlate());
    }

}
