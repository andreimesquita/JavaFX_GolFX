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
package com.dgi.login.view;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Andrei
 */
public class VitrineApp extends Application {
    private static Stage stage;
    private AnchorPane anchorPane;
    
    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initListeners();
        
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Vitrine - GolFX");
        stage.show();
        
        initLayout();
        
        VitrineApp.stage = stage;
    }
    
    private void initComponents() {}
    
    private void initListeners() {}
    
    private void initLayout() {}

    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public class ItensProperty {
        private SimpleStringProperty produto;
        private SimpleDoubleProperty preco;

        public ItensProperty(String produto, double preco) {
            this.produto = new SimpleStringProperty(produto);
            this.preco = new SimpleDoubleProperty(preco);
        }
    }
}