package com.uniquindio.edu.co.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.uniquindio.edu.co.application.App;
import com.uniquindio.edu.co.application.models.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
    private App app;

    @FXML
    private TextField emailTXT;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField passwordTXT;

    @FXML
    void loginUser(ActionEvent event) {

        try {

            if (Utils.isValidEmail(emailTXT.getText()) == false){
                throw new Exception("El email debe ser valido del tipo user@gmail.com");
            }
            if (Utils.isValidString(passwordTXT.getText()) == false){
                throw new Exception("Ingrese una contraseña");
            }

            app.loginUser(emailTXT.getText(),passwordTXT.getText());

            
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showErrorMessage("Error al hacer login", e.getMessage());
        }

        }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    public void setMain(App app) {
        this.app = app;
    }

}
