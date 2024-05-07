package com.uniquindio.edu.co.application.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ReservationController implements Initializable {
    private App app;
    private ObservableList<String> usersObservableList;
    private ObservableList<String> vehiclesObservableList;
    private Label lblColor;
    private VBox card;
    private int i;
    private int j;

    @FXML
    private DatePicker datePicker;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField hourTXT;

    @FXML
    private TextField minuteTXT;

    @FXML
    private RadioButton takeSystemTimeRbtn;

    @FXML
    private ComboBox<String> userComboBox;

    @FXML
    private ComboBox<String> vehicleComboBox;

    @FXML
    void reserveSpace(ActionEvent event) {
        try {
            checkInputs();
            LocalDateTime selectedDateTime; 
            String userIdentification;
            String vehicleLicensePlate;
            if(!takeSystemTimeRbtn.isSelected()){
                int hour = Integer.parseInt(hourTXT.getText());
                int minute = Integer.parseInt(minuteTXT.getText());
                // Crea un objeto LocalDateTime con la fecha del DatePicker y la hora y minutos deseados
                selectedDateTime = LocalDateTime.of( datePicker.getValue(), LocalTime.of(hour,minute)); 
            }
            else{
                selectedDateTime = LocalDateTime.now();
            }
            //obtiene la cedula del usuario
            userIdentification = (userComboBox.getSelectionModel().getSelectedItem()).split("-")[1];
            //obtiene la placa del vehiculo 
            vehicleLicensePlate = (vehicleComboBox.getSelectionModel().getSelectedItem()).split("-")[1];
            //se hace la reserva
            boolean isReserved = app.reserveSpace(userIdentification,vehicleLicensePlate,selectedDateTime,i,j);

            this.lblColor.setStyle("-fx-background-color: #ff0000");
            this.card.setStyle("-fx-border-color:  #ff0000");
           // Obtener la fecha seleccionada en el DatePicker

        } catch (Exception e) {
            Utils.showErrorMessage("Error al reservar", e.getMessage());
        }
    }

    private void checkInputs() throws Exception {
        //se valida que se haya seleccionado un usuario
        if (userComboBox.getSelectionModel().getSelectedItem() == null)
            throw new Exception("Se debe seleccionar a un cliente");
        //se valida que se haya seleccionado un vehiculo
        if (vehicleComboBox.getSelectionModel().getSelectedItem() == null)
            throw new Exception("Se debe seleccionar un vehiculo");
        //se valida si esta' seleccionado el radio boto'n de fecha automatica
        if(!takeSystemTimeRbtn.isSelected()){
            //se valida que se haya seleccionado una fecha
            if(datePicker.getValue() == null )
                throw new Exception("Se debe seleccionar una fecha");
            //se valida que la hora sea un entero
            if(!Utils.isInteger(hourTXT.getText()))
                throw new Exception("La hora debe ser un numero entero entre 0 - 23");
            if(!Utils.isInteger(minuteTXT.getText()))
                throw new Exception("El minuto debe ser un numero entero entre 0 - 59");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         // Obtener la lista de items del ComboBox
    
    // Agregar varios nombres a la lista
    
        assert hourTXT != null : "fx:id=\"hourTXT\" was not injected: check your FXML file 'ReservationView.fxml'.";
        assert minuteTXT != null : "fx:id=\"minuteTXT\" was not injected: check your FXML file 'ReservationView.fxml'.";
        assert takeSystemTimeRbtn != null : "fx:id=\"takeSystemTimeRbtn\" was not injected: check your FXML file 'ReservationView.fxml'.";
        assert userComboBox != null : "fx:id=\"userComboBox\" was not injected: check your FXML file 'ReservationView.fxml'.";
        assert vehicleComboBox != null : "fx:id=\"vehicleComboBox\" was not injected: check your FXML file 'ReservationView.fxml'.";
        this.usersObservableList = userComboBox.getItems();
        this.vehiclesObservableList = vehicleComboBox.getItems();
        // Configurar un listener para el evento de selección del ComboBox
        userComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateVehicleComboBox(newValue.split("-")[1]);
            //updateReservationState(oldValue,newValue);
        });
    }
    private void updateVehicleComboBox(String userId) {
        vehiclesObservableList.clear();
        ArrayList<String> vehicleList;
        try {
            vehicleList = app.getVehiclesLicensePlateAndModelByUserId(userId);
            this.vehiclesObservableList.addAll(vehicleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setMain(App app, ArrayList<String> userClientsNamesAndIdentification, Label lblColor, VBox card, int i, int j) {
        this.app = app;
        usersObservableList.addAll(userClientsNamesAndIdentification);
        this.lblColor = lblColor;
        this.card = card;
        this.i = i;
        this.j = j;
    }
    public void updateReservationState(String oldValue, String newValue){
        System.out.println(oldValue);
        System.out.println(newValue);
    }


}
