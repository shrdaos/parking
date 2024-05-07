package com.uniquindio.edu.co.application.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.uniquindio.edu.co.application.App;
import com.uniquindio.edu.co.application.models.Space;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardController implements Initializable {
    private App app;
    private List<Space> spaceList;

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
    void generateMoneyEarnedReport(ActionEvent event) {

    }

    @FXML
    void generateRecordsReport(ActionEvent event) {

    }

    @FXML
    void logoutAction(ActionEvent event) {

    }

    @FXML
    void updateCarFeeAction(ActionEvent event) {

    }

    @FXML
    void updateClassicMotorcycleFeeAction(ActionEvent event) {

    }

    @FXML
    void updateHybridMotorcycleAction(ActionEvent event) {

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
        System.out.println("Hola mundo i"+i+"  j"+j);
        //lblColor.setStyle("-fx-background-color: #ff0000");
        //card.setStyle("-fx-border-color:  #ff0000");
    }

    public void setMain(App app,int totalSpaces) {
        this.app = app;
        this.spaceList = new ArrayList<>();
        app.setSpaces(getSpaces(totalSpaces));
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

            if(drawed+9<totalSpaces){
                totalPerFile = 9;
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
        System.out.println(spaces.toString());
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


}
