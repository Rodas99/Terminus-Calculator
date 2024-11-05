package com.terminus.calculator;

import com.terminus.calculator.controller.CalculatorController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class TerminusCalculatorApplication extends Application {

    private static ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        this.applicationContext = SpringApplication.run(TerminusCalculatorApplication.class);
    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        CalculatorController.loadView(stage);
    }

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
