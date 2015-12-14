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

import com.dgi.login.controller.Carrinho;
import com.dgi.login.controller.Vitrine;
import com.dgi.login.model.Produto;
import com.dgi.login.view.VitrineApp.ItensProperty;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Andrei
 */
public class VitrineApp extends Application {
    private AnchorPane anchorPane;
    private TextField txtPesquisa;
    private TableView<ItensProperty> tbVitrine;
    
    private TableColumn<ItensProperty, String> columnProduto;
    private TableColumn<ItensProperty, Double> columnPreco;
    
    private static Stage stage;
    private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();
    
    private static Carrinho carrinho;
    
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
    
    private void initComponents() {
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(800, 600);
        
        txtPesquisa = new TextField();
        txtPesquisa.setPromptText("Digite o item para pesquisa");
        
        tbVitrine = new TableView<>();
        tbVitrine.setPrefSize(780, 550);
        
        columnProduto = new TableColumn<>();
        columnProduto.setText("Produto");
        columnPreco = new TableColumn<>();
        columnPreco.setText("Preço");
        
        columnProduto.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>("produto"));
        columnPreco.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>("preco"));
        
        tbVitrine.getColumns().addAll(columnProduto, columnPreco);
        anchorPane.getChildren().addAll(txtPesquisa, tbVitrine);
        
        carrinho = new Carrinho();
        
        initItens();
        initLayout();
    }
    
    private void initItens() 
    {
        Vitrine v = new Vitrine();
        v.addProdutos(new Produto("Bola Topper", 15.00), new Produto("Luvas Umbro", 9.00), 
                new Produto("Camisa Esportiva", 40.00), new Produto("Chuteira Nike Mercurial", 199.00),
                new Produto("Caneleira Topper", 10.00));
        for (Produto p : v.getProdutos())
        {
            listItens.add(new ItensProperty(p.getProduto(), p.getPreco()));
        }
        
        tbVitrine.setItems(listItens);
    }
    
    private ObservableList<ItensProperty> findItems()
    {
        ObservableList<ItensProperty> itensEncontrados = FXCollections.observableArrayList();
        for (ItensProperty itens : listItens)
        {
            if (itens.getProduto().equals(txtPesquisa.getText()))
            {
                itensEncontrados.add(itens);
            }
        }
        return itensEncontrados;
    }
    
    private void initListeners() 
    {
        txtPesquisa.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent t) 
            {
                /*Quando o usuário digitar algo para pesquisa, a lista exibirá 
                apenas os itens que tenham na descrição do produto o valor digitado. 
                Se o usuário não digitar nada, então volta a exibição normal de 
                todos os itens. Este método será chamado apertando o botão ENTER
                do teclado, quando o foco estiver no campo de texto.*/
                if (!txtPesquisa.getText().equals(""))
                {
                    tbVitrine.setItems(findItems());
                } else {
                    tbVitrine.setItems(listItens);
                }
            }
        });
    }
    
    private void initLayout() 
    {
        txtPesquisa.setLayoutY(0);
        tbVitrine.setLayoutY(30);
    }

    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public class ItensProperty {
        /**
         * O conceito de Properties é uma recomendação do JavaFX. O conceito é 
         * semelhante ao Model, apenas mudando o fato de que usaremos tipos 
         * Property, ao invés de primitivos (um exemplo: SimpleDoubleProperty, 
         * ao invés de um simples double). Este padrão será bastante utilizado
         * em registros da TableView, ou seja, para outros conceitos (MVC e DAO,
         * por exemplo, caso esteja usando Hibernate/JPA) os conceitos de Model
         * serão normais, e não desta forma com Property.
         */
        private final SimpleStringProperty produto;
        private final SimpleDoubleProperty preco;

        public ItensProperty(String produto, double preco) {
            this.produto = new SimpleStringProperty(produto);
            this.preco = new SimpleDoubleProperty(preco);
        }
        
        public String getProduto() {return produto.get();}
        public void setProduto(String produto) {this.produto.set(produto);}
        
        public double getPreco() {return preco.get();}
        public void setPreco(double preco) {this.preco.set(preco);}
    }
}