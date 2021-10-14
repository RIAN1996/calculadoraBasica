package com.example.calculadorabasica;

import com.example.calculadorabasica.Modelo.operaciones;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCalculadora implements Initializable {

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonDec;

    @FXML
    private Button buttonDel;

    @FXML
    private Button buttonDiv;

    @FXML
    private Button buttonEigth;

    @FXML
    private Button buttonEqu;

    @FXML
    private Button buttonFive;

    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonMult;

    @FXML
    private Button buttonNine;

    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonSeven;

    @FXML
    private Button buttonSix;

    @FXML
    private Button buttonSub;

    @FXML
    private Button buttonTrhee;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonZero;

    //Metodo
    @FXML
    private TextField idTextNum;

    //variables
    public Button[] numbersButtons = new Button[10];
    public double num1 = 0, num2 = 0, result = 0;
    public String operation = "";

    operaciones op = new operaciones(num1,num2);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        numbersButtons[0] = buttonZero;
        numbersButtons[1] = buttonOne;
        numbersButtons[2] = buttonTwo;
        numbersButtons[3] = buttonTrhee;
        numbersButtons[4] = buttonFour;
        numbersButtons[5] = buttonFive;
        numbersButtons[6] = buttonSix;
        numbersButtons[7] = buttonSeven;
        numbersButtons[8] = buttonEigth;
        numbersButtons[9] = buttonNine;
    }


    //Metodo 
    @FXML
    void buttonOn(ActionEvent actionEvent) {
        for (int i = 0; i < 10; i++) {
            if (actionEvent.getSource() == numbersButtons[i]) {
                idTextNum.setText(idTextNum.getText().concat(String.valueOf(i)));
            }
        }
        if (actionEvent.getSource() == buttonDec) {
            idTextNum.setText(idTextNum.getText().concat("."));

        } else if (actionEvent.getSource() == buttonAdd) {
            num1 = Double.parseDouble(idTextNum.getText());
            operation = "+";
            idTextNum.setText("");

        }else if(actionEvent.getSource() == buttonSub){
            num1 = Double.parseDouble(idTextNum.getText());
            operation = "-";
            idTextNum.setText("");

        }else if(actionEvent.getSource() == buttonMult){
            num1 = Double.parseDouble(idTextNum.getText());
            operation = "*";
            idTextNum.setText("");

        }else if(actionEvent.getSource() == buttonDiv){
            num1 = Double.parseDouble(idTextNum.getText());
            operation = "/";
            idTextNum.setText("");

        }else if(actionEvent.getSource() == buttonEqu){
            num2 = Double.parseDouble(idTextNum.getText());

            switch (operation) {
                case "+" -> result = op.add(num1, num2);
                case "-" -> result = op.sub(num1, num2);
                case "*" -> result = op.moult(num1, num2);
                case "/" -> {
                    if (num2 != 0){
                        result = op.div(num1, num2);
                    }else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Info");
                        alert.setContentText("No puedes divider entre cero");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                        num1= result;
                    }
                }
            }
            idTextNum.setText(String.valueOf(result));
            num1= result;
        }

        if(actionEvent.getSource() == buttonClear){
            idTextNum.setText("");
            num1 = 0;
            num2 = 0;
        }


    }
    
}