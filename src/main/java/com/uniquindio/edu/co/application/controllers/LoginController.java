package com.uniquindio.edu.co.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.uniquindio.edu.co.application.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private TextField emailTXT;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField passwordTXT;

    @FXML
    void loginUser(ActionEvent event) {
        System.out.println("hola");

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    public void setMain(App app) {
        // TODO Auto-generated method stub
    }

}
