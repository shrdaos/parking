package com.uniquindio.edu.co.application.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.uniquindio.edu.co.application.App;
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

}
