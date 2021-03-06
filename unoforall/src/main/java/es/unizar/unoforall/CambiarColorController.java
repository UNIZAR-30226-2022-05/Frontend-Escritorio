package es.unizar.unoforall;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CambiarColorController implements Initializable{
	//VARIABLE BOOLEANA PARA MOSTRAR MENSAJES POR LA CONSOLA
	public static final boolean DEBUG = App.DEBUG;
    
	private static final int CANCELAR = -1;
	private static final int ROJO = 1;
	private static final int VERDE = 2;
	private static final int AMARILLO = 3;
	private static final int AZUL = 4;
	
	private static final String TEXTO_COLOR_AZUL_CLARO = "Azul claro";
	private static final String TEXTO_COLOR_ROSA = "Rosa";
	private static final String TEXTO_COLOR_AZUL_OSCURO = "Azul Oscuro";
	private static final String TEXTO_COLOR_NARANJA = "Naranja";
	
    @FXML private Button btnRojo;
    @FXML private Button btnVerde;
    @FXML private Button btnAmarillo;
    @FXML private Button btnAzul;
    @FXML private Button btnCancelar;
    
    @FXML private Circle colorRojo;
    @FXML private Circle colorVerde;
    @FXML private Circle colorAmarillo;
    @FXML private Circle colorAzul;
    
    private static int resultado;
	private EventHandler<ActionEvent> elegirColor;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		resultado = CANCELAR;
		if (App.getPersonalizacion().get("cartaSelec") == 1) {
			colorRojo.setFill(Paint.valueOf("#20f3f3"));
			colorVerde.setFill(Paint.valueOf("#d851b0"));
			colorAmarillo.setFill(Paint.valueOf("#3948e9"));
			colorAzul.setFill(Paint.valueOf("#faaa1b"));
			
			btnRojo.setText(TEXTO_COLOR_AZUL_CLARO);
			btnVerde.setText(TEXTO_COLOR_ROSA);
			btnAmarillo.setText(TEXTO_COLOR_AZUL_OSCURO);
			btnAzul.setText(TEXTO_COLOR_NARANJA);	
		}	
		//Handler que realiza una acción dependiendo de qué botón ha sido pulsado.
		//Tras pulsarse, está configurado para cerrar el popup.
		elegirColor = new EventHandler<ActionEvent>() {
	      	@Override 
	      	public void handle(ActionEvent actionEvent) {
	      		if(actionEvent.getSource().equals(btnRojo)) {
	      			if (DEBUG) System.out.println("Has clickado el botón rojo");
	      			resultado = ROJO;
	      		} else if(actionEvent.getSource().equals(btnVerde)) {
	      			if (DEBUG) System.out.println("Has clickado el botón verde");
	      			resultado = VERDE;
	      		} else if(actionEvent.getSource().equals(btnAmarillo)) {
	      			if (DEBUG) System.out.println("Has clickado el botón amarillo");
	      			resultado = AMARILLO;
	      		} else if(actionEvent.getSource().equals(btnAzul)) {
	      			if (DEBUG) System.out.println("Has clickado el botón azul");
	      			resultado = AZUL; 
	      	  	} else if(actionEvent.getSource().equals(btnCancelar)) {
	      			if (DEBUG) System.out.println("Has clickado el botón de cancelar jugada"); 
	      		}
	      		
		      	Node  source = (Node)  actionEvent.getSource(); 
		      	Stage stage  = (Stage) source.getScene().getWindow();
		      	stage.close();
	      	}
		};
		
      	btnRojo.setOnAction(elegirColor);
      	btnVerde.setOnAction(elegirColor);
      	btnAmarillo.setOnAction(elegirColor);
      	btnAzul.setOnAction(elegirColor);
      	btnCancelar.setOnAction(elegirColor);		
	}
    
    public int getReturn() {
    	return resultado;
    }
}
