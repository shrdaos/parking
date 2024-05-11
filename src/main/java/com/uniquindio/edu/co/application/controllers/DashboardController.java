package com.uniquindio.edu.co.application.controllers;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ResourceBundle;

import com.uniquindio.edu.co.application.App;
import com.uniquindio.edu.co.application.models.Space;
import com.uniquindio.edu.co.application.models.SpaceRecord;
import com.uniquindio.edu.co.application.models.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardController implements Initializable {
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label carFeeLbl;

    @FXML
    private Label classicMotorcycleFeeLbl;

    @FXML
    private Label hybridMotorcycleFeeLbl;

    @FXML
    private TextField profileEmailTXT;

    @FXML
    private TextField profileIdentificationTXT;

    @FXML
    private Button refreshRecordsButton;

    @FXML
    private TextField profileNameTXT;

    @FXML
    private TextField profileRoleTXT;

    @FXML
    private DatePicker recordsFromDate;

    @FXML
    private DatePicker recordsToDate;

    @FXML
    private VBox spacesVBox;
    @FXML
    private VBox recordsVBox;
    @FXML
    void generateMoneyEarnedReport(ActionEvent event) {
        generateMoneyEarnedReportImplementation();

    }

    @FXML
    void generateRecordsReport(ActionEvent event) {
        generateRecordsReportImplementation();

    }

    @FXML
    void logoutAction(ActionEvent event) {

    }

    @FXML
    void updateCarFeeAction(ActionEvent event) {
        updateCarFee();
    }

    @FXML
    void refreshRecrodsAction(ActionEvent event) {
        refreshRecrods();
    }

    @FXML
    void updateClassicMotorcycleFeeAction(ActionEvent event) {
        updateClassicMotorcycleFee();
    }

    @FXML
    void updateHybridMotorcycleAction(ActionEvent event) {
        updateHybridMotorcycle();
    }

    @FXML
    void updateUserInfoAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert carFeeLbl != null : "fx:id=\"carFeeLbl\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert classicMotorcycleFeeLbl != null : "fx:id=\"classicMotorcycleFeeLbl\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert hybridMotorcycleFeeLbl != null : "fx:id=\"hybridMotorcycleFeeLbl\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert profileEmailTXT != null : "fx:id=\"profileEmailTXT\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert profileIdentificationTXT != null : "fx:id=\"profileIdentificationTXT\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert profileNameTXT != null : "fx:id=\"profileNameTXT\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert profileRoleTXT != null : "fx:id=\"profileRoleTXT\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert recordsFromDate != null : "fx:id=\"recordsFromDate\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert recordsToDate != null : "fx:id=\"recordsToDate\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert spacesVBox != null : "fx:id=\"spacesVBox\" was not injected: check your FXML file 'DashboardView.fxml'.";
        spacesVBox.setSpacing(10);


    }
    public void spaceClickedAction(MouseEvent event,int i,int j,Label lblColor, VBox card) {
        app.handleSpaceClicked(lblColor,card,i,j);
    }

    public void setMain(App app,int totalSpaces) {
        this.app = app;
        app.setSpaces(getSpaces(totalSpaces));
        updateFees(app.getCarFee(),app.getHybridMotorcycleFee(),app.getClassicMotorcycleFee());
    }
    private void updateFees(Double carFee, Double hybridMotorcycleFee, Double classicMotorcycleFee) {
        carFeeLbl.setText(""+carFee);
        hybridMotorcycleFeeLbl.setText(""+hybridMotorcycleFee);
        classicMotorcycleFeeLbl.setText(""+classicMotorcycleFee);
    }

    private List<Space> getSpaces(int totalSpaces) {
        List<Space> spaces = new ArrayList<>();
        int drawed = 0;
        int file = 0;
        while (drawed <totalSpaces){
            file ++;
            int column = 1;

            int totalPerFile;
            HBox hBox = new HBox();
            hBox.setSpacing(10);

            if(drawed+10<totalSpaces){
                totalPerFile = 10;
            }else{
                totalPerFile = totalSpaces - drawed;
            }

            for (int i = 0; i < totalPerFile ; i++) {
                VBox card = getSpaceCard(file, column);
                spaces.add(new Space(file, column, null, null));
                hBox.getChildren().add(card);
                drawed++;
                column ++;
            }
            spacesVBox.getChildren().add(hBox);
        }
        return spaces;

    }

    public VBox getSpaceCard(int file, int column ){
        //se crea la targeta que cambiará de color y representará el espacio gráficamente
        //usando vertical box y tres labels
        VBox card = new VBox();
        card.setStyle("-fx-border-color:  #48E120");
        card.setMinWidth(54);
        card.setMinHeight(62);


        // Agregando margen a la derecha e izquierda
        Insets margin = new Insets(0, 10, 0, 10); // Margen de 3 a la derecha e izquierda
        VBox.setMargin(card, margin);
        //se crea el label que contendra' el color caracteristico de la targeta
        Label lblColor = new Label();
        lblColor.setStyle("-fx-background-color: #48E120");
        lblColor.setMinWidth(55);
        lblColor.setMinHeight(18);

        card.getChildren().add(lblColor);
        //se crea el label que contendra' la posicion en i
        Label lblIPos = getSpaceLabel(file, "I");
        card.getChildren().add(lblIPos);
        //se crea el label que contendra' la posicion en j
        Label lblJPos = getSpaceLabel(column, "J");
        card.getChildren().add(lblJPos);
        int[] fileColumn = {file, column};
        card.setOnMouseClicked(event -> spaceClickedAction(event,fileColumn[0],fileColumn[1],lblColor,card));
        return card;

    }
    public Label getSpaceLabel(int pos , String tipe){
        Label lblPos = new Label();
        lblPos.setMinWidth(55);
        lblPos.setMinHeight(18);
        lblPos.setText(tipe+" : "+pos);
        lblPos.setAlignment(Pos.CENTER);
        return lblPos;
    }
   private void generateRecordsReportImplementation() {
        try {
            validateDates();
            LocalDateTime startTime = LocalDateTime.of( recordsFromDate.getValue(), LocalTime.of(0,0)); 
            LocalDateTime endTime = LocalDateTime.of( recordsToDate.getValue(), LocalTime.of(23,59)); 
            List<SpaceRecord> recordsFiltred = app.getRecordsBetween(startTime,endTime);
            renderRecordList(recordsFiltred);
        } catch (Exception e) {
                Utils.showErrorMessage("Error",e.getMessage());
        }
    }
    private void validateDates() throws Exception {
        if(recordsFromDate.getValue().compareTo(recordsToDate.getValue())>0){
            throw new Exception("La fecha 'Hasta' debe ser mayor o igual a la fecha 'Desde'.");
        }
    }

    private void updateCarFee() {
        try {
            double newFee = Utils.getPositiveDoubleIncludingZero("Ingrese el nuevo valor de la tarifa por hora para carro");
            app.updateCarFee(newFee);
            this.carFeeLbl.setText(""+newFee);
        } catch (Exception e) {
            Utils.showErrorMessage("Error",e.getMessage());
        }
    }
    private void updateClassicMotorcycleFee() {
        try {
            double newFee = Utils.getPositiveDoubleIncludingZero("Ingrese el nuevo valor de la tarifa por hora para la moto clásica");
            app.updateClassicMotorcycleFee(newFee);
            classicMotorcycleFeeLbl.setText(""+newFee);
        } catch (Exception e) {
            Utils.showErrorMessage("Error",e.getMessage());
        }
    }
    private void updateHybridMotorcycle() {
        try {
            double newFee = Utils.getPositiveDoubleIncludingZero("Ingrese el nuevo valor de la tarifa por hora para la moto híbrida");
            app.updateHybridMotorcycle(newFee);
            hybridMotorcycleFeeLbl.setText(""+newFee);
        } catch (Exception e) {
            Utils.showErrorMessage("Error",e.getMessage());
        }
    }
    private void refreshRecrods() {
        List<SpaceRecord> recordList = app.getAllRecords();
        renderRecordList(recordList);
    }

    private void renderRecordList(List<SpaceRecord> recordList) {
        recordsVBox.getChildren().clear();
        for (SpaceRecord spaceRecord : recordList) {
           HBox recordHbox = getRecordHBox(spaceRecord); 
           recordsVBox.getChildren().add(recordHbox);
        }
    }

    private HBox getRecordHBox(SpaceRecord spaceRecord) {
        HBox hBox = new HBox();
        // Agregando margen a la derecha e izquierda
        Insets margin = new Insets(5, 0, 5,0); // Margen de 3 a la derecha e izquierda
        VBox.setMargin(hBox, margin);
        // Define el formato deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        //se crea la hora de inicio
        VBox startTimeVBox = getRecordVBoxComponent("Fecha Inicio",""+spaceRecord.getStarTime().format(formatter));
        //se crea la hora de final
        VBox endTimeVBox = getRecordVBoxComponent("Fecha Fin", ""+spaceRecord.getEndTime().format(formatter));
        // se crea el modelo
        VBox modelVBox = getRecordVBoxComponent("Modelo",spaceRecord.getModel());
        // se crea la placa 
        VBox licenseVBox = getRecordVBoxComponent("Placa",spaceRecord.getLicensePlate());
        // se crea la identificacion del usuario
        VBox userIdVbox = getRecordVBoxComponent("Identificación",spaceRecord.getUserIdentification());
        // se crea la posicion
        VBox positionVBox = getRecordVBoxComponent("Posicion","I:"+spaceRecord.getPositionI() + " - J:" + spaceRecord.getPositionJ());
        // se crea el monto pagado
        VBox ammountVBox = getRecordVBoxComponent("Monto Pagado",""+spaceRecord.getAmountPaid());
        //se agregan los componentes vBox al hbox principal
        hBox.getChildren().addAll(startTimeVBox,endTimeVBox,modelVBox,licenseVBox,userIdVbox,positionVBox,ammountVBox);
        return hBox;
    }

    private VBox getRecordVBoxComponent(String title, String content) {
       VBox vBox = new VBox();
       vBox.setAlignment(Pos.CENTER);
       Label titleLabel = new Label(title);
       Label contentLabel = new Label(content); 
       vBox.getChildren().addAll(titleLabel,contentLabel);
       vBox.setStyle("-fx-border-color: #808080");
       vBox.setMinWidth(100);
       vBox.setMaxWidth(102);
       vBox.setMinHeight(40);
       vBox.setMaxHeight(42);
       return  vBox;
    }
    private void generateMoneyEarnedReportImplementation() {
        try {
            Double earnedMoney = app.getMoneyEarned();
            int   totalReservations = app.countReservations();
            Utils.showSuccessMessage("Dinero Generado", "Se ha generado :"+earnedMoney+" en un total de "+totalReservations+" reservaciones");
            
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showErrorMessage("Error al obtener el dinero total", e.getMessage());
        }
    }


}
