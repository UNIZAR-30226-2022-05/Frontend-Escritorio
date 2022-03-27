package es.unizar.unoforall;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;

public class CrearSalaController implements Initializable {
	
	@FXML private ChoiceBox<String> GameModeChoiceBox;
	private String[] gamemodes = {"Uno Clásico", "Uno Attack", "Uno por Parejas"};
	private String selectedGamemode = gamemodes[0];
	
	private int numParticipantes = 4;
	@FXML private RadioButton part2;
	@FXML private RadioButton part3;
	@FXML private RadioButton part4;
	
	private boolean tipoPublica = true;
	@FXML private RadioButton publica;
	@FXML private RadioButton privada;
	
	private boolean rayosX = false;
	@FXML private RadioButton rayosXSi;
	@FXML private RadioButton rayosXNo;
	
	private boolean intercambio = false;
	@FXML private RadioButton intercambioSi;
	@FXML private RadioButton intercambioNo;
	
	private boolean modifX2 = false;
	@FXML private RadioButton modifX2Si;
	@FXML private RadioButton modifX2No;
	
	private boolean encadenar = false;
	@FXML private RadioButton encadenarSi;
	@FXML private RadioButton encadenarNo;
	
	private boolean redirigir = false;
	@FXML private RadioButton redirigirSi;
	@FXML private RadioButton redirigirNo;
	
	private boolean jugarVarias = false;
	@FXML private RadioButton jugarVariasSi;
	@FXML private RadioButton jugarVariasNo;
	
	private boolean evitarEspeciales = false;
	@FXML private RadioButton evitarEspecialesSi;
	@FXML private RadioButton evitarEspecialesNo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GameModeChoiceBox.getItems().addAll(gamemodes);
		GameModeChoiceBox.setOnAction(this::getGameMode);
	}
	
	@FXML
	public void getGameMode (ActionEvent event) {
		String choice = GameModeChoiceBox.getValue();
		
		if (choice.equals(gamemodes[0])) {
			selectedGamemode = gamemodes[0];
//			goToConfCuenta(event);
		} else if (choice.equals(gamemodes[1])) {
			selectedGamemode = gamemodes[1];
//			goToConfAspecto(event);
		} else {
			selectedGamemode = gamemodes[2];
//			goToLogin(event);
		}
	}
	
	
	@FXML
    private void goBack(ActionEvent event) {
		try {
	    	App.setRoot("principal");
		} catch (IOException e) {
			System.out.print(e);
		}
	}

	@FXML
    private void goToMain(Event event) {
		try {
	    	App.setRoot("principal");
		} catch (IOException e) {
			System.out.print(e);
		}
	}
	
	@FXML
    private void selectTipoSala(ActionEvent event) {
		if (publica.isSelected()) {
			tipoPublica = true;
		}
		else if (privada.isSelected()) {
			tipoPublica = false;
		}
	}
	
	@FXML
    private void selectNumParticip(ActionEvent event) {
		if (part2.isSelected()) {
			numParticipantes = 2;
		}
		else if (part3.isSelected()) {
			numParticipantes = 3;
		}
		else if (part4.isSelected()) {
			numParticipantes = 4;
		}
	}
	
	@FXML
    private void selectRayosX(ActionEvent event) {
		if (rayosXSi.isSelected()) {
			rayosX = true;
		}
		else if (rayosXNo.isSelected()) {
			rayosX = false;
		}
	}
	
	@FXML
    private void selectIntercambio(ActionEvent event) {
		if (intercambioSi.isSelected()) {
			intercambio = true;
		}
		else if (intercambioNo.isSelected()) {
			intercambio = false;
		}
	}
	
	@FXML
    private void selectX2(ActionEvent event) {
		if (modifX2Si.isSelected()) {
			modifX2 = true;
		}
		else if (modifX2No.isSelected()) {
			modifX2 = false;
		}
	}
	
	@FXML
    private void selectEncadenar(ActionEvent event) {
		if (encadenarSi.isSelected()) {
			encadenar = true;
		}
		else if (encadenarNo.isSelected()) {
			encadenar = false;
		}
	}
	
	@FXML
    private void selectRedirigir(ActionEvent event) {
		if (redirigirSi.isSelected()) {
			redirigir = true;
		}
		else if (redirigirNo.isSelected()) {
			redirigir = false;
		}
	}
	
	@FXML
    private void selectJugarVarias(ActionEvent event) {
		if (jugarVariasSi.isSelected()) {
			jugarVarias = true;
		}
		else if (jugarVariasNo.isSelected()) {
			jugarVarias = false;
		}
	}
	
	@FXML
    private void selectEvitarEspeciales(ActionEvent event) {
		if (evitarEspecialesSi.isSelected()) {
			evitarEspeciales = true;
		}
		else if (evitarEspecialesNo.isSelected()) {
			evitarEspeciales = false;
		}
	}
	
	@FXML
    private void createRoom (ActionEvent event) {
		try {
			System.out.println("Creada Sala de tipo:");
			
			System.out.println("Número de participantes: " + numParticipantes);
			
			System.out.print("Tipo de sala: ");
			if (tipoPublica) System.out.println("Publica"); else System.out.println("Privada");
			
			System.out.print("Rayos X: ");
			if (rayosX) System.out.println("Si"); else System.out.println("No");
			
			System.out.print("Intercambio: ");
			if (intercambio) System.out.println("Si"); else System.out.println("No");
			
			System.out.print("X2: ");
			if (modifX2) System.out.println("Si"); else System.out.println("No");
			
			System.out.println("Modo de juego: " + selectedGamemode);
			
			System.out.print("Encadenar +2 y +4: ");
			if (encadenar) System.out.println("Si"); else System.out.println("No");
			
			System.out.print("Redirigir +2 y +4: ");
			if (redirigir) System.out.println("Si"); else System.out.println("No");
			
			System.out.print("Jugar Varias Cartas: ");
			if (jugarVarias) System.out.println("Si"); else System.out.println("No");

			System.out.print("Evitar Cartas Especiales: ");
			if (evitarEspeciales) System.out.println("Si"); else System.out.println("No");
			
	    	App.setRoot("principal");
		} catch (IOException e) {
			System.out.print(e);
		}
	}

}
