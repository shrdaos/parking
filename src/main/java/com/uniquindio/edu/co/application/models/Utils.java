package com.uniquindio.edu.co.application.models;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.awt.Component;
import java.io.File;
import java.util.logging.Level;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Utils {

	public static void showSuccessMessage(String header,String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle      ("Éxito");
		alert.setHeaderText (header);
		alert.setContentText(content);
		alert.showAndWait   ();
	}
	public static void showErrorMessage(String header,String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle      ("Error");
		alert.setHeaderText (header);
		alert.setContentText(content);
		alert.showAndWait   ();
	}
	public static void showSimpleMessage(String title, String header, String content, AlertType alertType) {

		Alert alert = new Alert(alertType);
		alert.setTitle      (title);
		alert.setHeaderText (header);
		alert.setContentText(content);
		alert.showAndWait   ();
	}
	public static String getDirectoryPath() {
		int selection=JFileChooser.APPROVE_OPTION;
		boolean pathObtained=false;
		while(!pathObtained ){
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(2);
			//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
			selection=fileChooser.showOpenDialog(new Component() {
			});
			if(selection==JFileChooser.CANCEL_OPTION)
				break;
			//Si el usuario, pincha en aceptar
			if(selection==JFileChooser.APPROVE_OPTION){

				//Seleccionamos el fichero
				File file=fileChooser.getSelectedFile();
				if(file!=null)
				{
					if(file.isDirectory())
					{
						pathObtained=true;
						return file.getAbsolutePath();
					}
				}
			}
		}
		return "";
	}
	public static String getFileFullPath(String description,String extention) {
		int selection=JFileChooser.APPROVE_OPTION;
		boolean pathObtained=false;
		while(!pathObtained ){
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Solo permite la selección de archivos
	        FileNameExtensionFilter filter = new FileNameExtensionFilter(description, extention); // Filtro para archivos .txt
	        fileChooser.setFileFilter(filter); // Aplica el filtro al JFileChooser	
			
			//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
			selection=fileChooser.showOpenDialog(null);
			if(selection==JFileChooser.CANCEL_OPTION)
				break;
			//Si el usuario, pincha en aceptar
			if(selection==JFileChooser.APPROVE_OPTION){
				//Seleccionamos el fichero
				File file=fileChooser.getSelectedFile();
				if(file != null)
				{
					if(file.isFile() )
					{
						pathObtained=true;
						return file.getAbsolutePath();
					}
				}
			}
		}
		return "";
	}
	public static boolean isInteger(String stringRepresentation) {
		try {
			Integer.parseInt(stringRepresentation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean isValidString(String str){
		if(str != null && !str.isEmpty()){
			return true;
		}
		return false;
	}
	public static boolean isValidEmail(String email) {
		if(email != null && !email.isEmpty() && email.contains("@")){
			return true;
		}
		return false;
	}
	public static int getNaturalIntegerJOption(String message){
		while(true){
			try {
				int integer = Integer.parseInt(JOptionPane.showInputDialog(message));
				if(integer>0)
					return integer;	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}