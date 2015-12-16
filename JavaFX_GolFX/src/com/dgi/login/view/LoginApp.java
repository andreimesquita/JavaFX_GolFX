package com.dgi.login.view;
import com.dgi.login.util.AlertBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * @author Andrei
 */
public class LoginApp extends Application {
    private AnchorPane anchorPane;
    private TextField txfLogin;
    private PasswordField psfSenha;
    private Button btnEntrar, btnSair;
    
    private static Stage stage;
    /**
     * Os componentes e o desenvolvimento da lógica da View devem ser criados
     * neste método. Este método também é últil para se chamar outros
     * formulários da aplicação.
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initListeners();
        
        //É necessário criar uma cena para fazer acontecer o formulário
        Scene scene = new Scene(anchorPane);
        
        /*Por fim, é necessário indicar qual cena será usada no Stage, que 
          seria a tela propriamente dita. Esta Stage é passada no próprio
        método "start", e a indicação da cena é passada pelo método 
        "setScene(Scene scene)"*/
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Login - GolFX");
        stage.show();
        
        initLayout();
        LoginApp.stage = stage;
    }
    
    private void initComponents()
    {
        //Painel que dá total liberdade na localização dos componentes da UI
        anchorPane = new AnchorPane();
        /*É possível utilizar CSS (próprio da plataforma) para dar toques de
        requinte para os componentes da aplicação.*/
        anchorPane.setStyle("-fx-background-color: linear-gradient( from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        
        anchorPane.setPrefSize(400, 300);
        
        txfLogin = new TextField();
        /*O método "setPromptText" define um textholder para o campo de texto.
          O textholder é apenas apresentado quando o campo de texto está vazio,
          de forma que, quando o campo recebe o foco, este texto é apagado. */
        txfLogin.setPromptText("Digite aqui seu login");
        
        psfSenha = new PasswordField();
        psfSenha.setPromptText("Digite aqui sua senha");
        
        btnEntrar = new Button("Entrar");
        btnSair = new Button("Sair");
        
        anchorPane.getChildren().addAll(txfLogin, psfSenha, btnEntrar, btnSair);
    }
    
    private void initLayout()
    {
        /*Abaixo são adicionados os códigos que manipulam o tamanho dos elementos
          da tela. É necessário que eles estejam aqui em baixo pois só é 
          possível saber o tamanho da janela após a execução do método 
          "Show()". */
        
        txfLogin.setLayoutX((anchorPane.getWidth() - txfLogin.getWidth()) * 0.5);
        txfLogin.setLayoutY(50); //Controla a posição vertical (eixo Y)
        
        psfSenha.setLayoutX((anchorPane.getWidth() - psfSenha.getWidth()) * 0.5);
        psfSenha.setLayoutY(100);
        
        btnEntrar.setLayoutX((anchorPane.getWidth() - btnEntrar.getWidth()) * 0.5);
        btnEntrar.setLayoutY(150);
        
        btnSair.setLayoutX((anchorPane.getWidth() - btnSair.getWidth()) * 0.5);
        btnSair.setLayoutY(200);
    }
    
    private void initListeners()
    {
        btnSair.setOnAction((ActionEvent t) -> {
            fecharAplicacao();
        });
        
        btnEntrar.setOnAction((ActionEvent t) -> {
            if (txfLogin.getText().equals("admin") &&
                    psfSenha.getText().equals("casadocodigo")) {
                //TODO Abrir a tela VitrineApp
                try {
                    new VitrineApp().start(new Stage());
                    LoginApp.getStage().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //JOptionPane.showMessageDialog(null,
                //        "Login e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println(AlertBox.displayConfirmBox("Erro", "Login e/ou senha inválidos!"));
            }
        });
    }
    
    private void fecharAplicacao()
    {
        System.exit(0);
    }

    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
        /* A View do JavaFX deve ser inicializada através do método 
        "launch(String[] args)", que provém da classe Application */
        launch(args);
    }
}