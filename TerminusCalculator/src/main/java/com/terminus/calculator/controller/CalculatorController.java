package com.terminus.calculator.controller;

import com.terminus.calculator.TerminusCalculatorApplication;
import com.terminus.calculator.service.SymbolService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.Label;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class CalculatorController {

    @Autowired
    private SymbolService symbolService;

    @FXML
    private Label xValue, yValue, zValue;

    private int currentXValue = 0;
    private int currentYValue = 0;
    private int currentZValue = 0;

    @FXML
    public void handleSymbolClick(ActionEvent event) {
        Button pressedButton = (Button) event.getSource();
        String buttonId = pressedButton.getId();

        switch (buttonId) {
            case "x":
                String xId = (String) pressedButton.getUserData();
                currentXValue = symbolService.processXSymbolClick(xId);
                break;
            case "y":
                String yId = (String) pressedButton.getUserData();
                currentYValue = symbolService.processYSymbolClick(yId);
                break;
            case "z":
                String zId = (String) pressedButton.getUserData();
                currentZValue = symbolService.processZSymbolClick(zId);
                break;
        }

        // Update values based on the new state
        String previousXValue = String.valueOf(2 * currentXValue + 11);
        String previousYValue = String.valueOf(((2 * currentZValue) + currentYValue) - 5);
        String previousZValue = String.valueOf(Math.abs((currentYValue + currentZValue)) - currentXValue);

        // Update the labels with the new values
        xValue.setText(previousXValue);
        yValue.setText(previousYValue);
        zValue.setText(previousZValue);
    }

    public static void loadView(Stage stage) {

        try {
            FXMLLoader loader = new FXMLLoader(CalculatorController.class.getResource("/com.terminus.calculator.controller/TerminusCalculator.fxml"));
            loader.setControllerFactory(TerminusCalculatorApplication.getApplicationContext()::getBean);

            Scene scene = new Scene(loader.load());

            stage.setTitle("Terminus Calculator");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
