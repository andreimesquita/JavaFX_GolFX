/*
 * The MIT License
 *
 * Copyright 2015 Andrei.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.dgi.login.util;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Andrei
 */
public class AlertBox {
    public static void displayMessage(String title, String message)
    {
        Stage window = new Stage();
        /*Obriga que este janela seja finalizada para que as demais possam
        ser reutilizadas.*/
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(300);
        window.setTitle(title);
        
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> window.close());
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        window.sizeToScene();
    }
    
    private static boolean response;
    
    public static boolean displayConfirmBox(String title, String message)
    {
        Stage window = new Stage();
        /*Obriga que este janela seja finalizada para que as demais possam
        ser reutilizadas.*/
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(300);
        window.setTitle(title);
        
        Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            response = false;
            window.close();
        });
        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            response = true;
            window.close();
        });
        
        FlowPane flowPane = new FlowPane(10, 10);
        flowPane.getChildren().addAll(noButton, yesButton);
        flowPane.setAlignment(Pos.CENTER);
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(new Label(message), flowPane);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        window.sizeToScene();
        
        return response;
    }
}