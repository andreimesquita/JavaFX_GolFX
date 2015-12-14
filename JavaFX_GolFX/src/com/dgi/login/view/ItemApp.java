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

import static javafx.application.Application.launch;
import com.dgi.login.model.Produto;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Andrei
 */
public class ItemApp extends Application {
    private AnchorPane anchorPane;
    private ImageView imgItem;
    private Label lblPreco, lblDescricao;
    private Button btAddCarrinho;
    
    private static Stage stage;
    private static Produto produto;
    
    private static int index;
    private static String[] images = 
    {
        "http://www.wpclipart.com/office/sale_promo/new_item/new_item_light_red.png",
        "http://static.cineclick.com.br/sites/adm/uploads/banco_imagens/31/602x0_1439644246.jpg"
    };
    
    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initListeners();
        
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Item - GolFX");
        stage.show();
        
        anchorPane.getChildren().addAll(
                this.btAddCarrinho, this.imgItem, this.lblDescricao, this.lblPreco);
        
        initLayout();
        
        ItemApp.stage = stage;
    }
    
    private void initComponents() {
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(600, 400);
        
        btAddCarrinho = new Button("Adicionar ao Carrinho");
        lblPreco = new Label("Preço");
        lblDescricao = new Label("Descrição");
        imgItem = new ImageView(
            new Image("http://www.wpclipart.com/office/sale_promo/new_item/new_item_light_red.png"));
        imgItem.setViewport(new Rectangle2D(0, 0, 300, 300));
        
        initLayout();
    }
    
    private void initListeners() 
    {}
    
    private void initLayout() 
    {
        this.btAddCarrinho.setLayoutX(0);
        this.btAddCarrinho.setLayoutY(0);
        
        this.imgItem.setLayoutX(0);
        this.imgItem.setLayoutY(50);
        
        this.lblDescricao.setLayoutX(0);
        this.lblDescricao.setLayoutY(360);
        
        this.lblPreco.setLayoutX(0);
        this.lblPreco.setLayoutY(330);
    }

    public static void setProduto(Produto produto) {
        ItemApp.produto = produto;
    }

    public static Produto getProduto() {
        return produto;
    }

    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}