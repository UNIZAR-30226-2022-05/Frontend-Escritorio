package es.unizar.unoforall;

import java.util.UUID;

import es.unizar.unoforall.listeners.SalaListener;
import es.unizar.unoforall.model.salas.ConfigSala;
import es.unizar.unoforall.model.salas.ReglasEspeciales;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SalaItemController {
	//VARIABLE BOOLEANA PARA MOSTRAR MENSAJES POR LA CONSOLA
	private static final boolean DEBUG = true;
	
    private static Image original = new Image(App.class.getResourceAsStream("images/logoUno.png"));
    private static Image attack = new Image(App.class.getResourceAsStream("images/arista.png"));
    private static Image parejas = new Image(App.class.getResourceAsStream("images/social.png"));
    
    private SalaListener myListener;
    private UUID idSala;

    @FXML
    private ImageView modoJuego;

    @FXML
    private Label tamanno;

    @FXML
    private Label rayosX;

    @FXML
    private Label intercambio;

    @FXML
    private Label x2;
	
	@FXML
    private Label encadenar;

    @FXML
    private Label redirigir;

    @FXML
    private Label jugarVarias;

    @FXML
    private Label evitarEspecial;
    
    @FXML
    private void click (MouseEvent mouseEvent) {
    	myListener.onClickListener(idSala);
    }
    
    public void setData(ConfigSala config, UUID salaID, SalaListener listener) {
    	//INTERFAZ PARA COMUNICAR
    	myListener = listener;
    	
    	//ID DE LA SALA
    	idSala = salaID;
    	
    	//CONFIGURAR MODO DE JUEGO
    	if (config.getModoJuego() == ConfigSala.ModoJuego.Original) modoJuego.setImage(original);
    	else if (config.getModoJuego() == ConfigSala.ModoJuego.Attack) modoJuego.setImage(attack);
    	else if (config.getModoJuego() == ConfigSala.ModoJuego.Parejas) modoJuego.setImage(parejas);
    	else if (DEBUG) System.out.println("Modo de juego inválido: " + config.getModoJuego().name());
    	
    	//CONFIGURAR TAMAÑO DE SALA
    	tamanno.setText(config.getMaxParticipantes() + " Jugadores");
    	
    	//CONFIGURAR REGLAS ESPECIALES
    	ReglasEspeciales reglas = config.getReglas();
    	if (reglas.isCartaRayosX()) rayosX.setText("SI"); else rayosX.setText("NO");
    	if (reglas.isCartaIntercambio()) intercambio.setText("SI"); else intercambio.setText("NO");
    	if (reglas.isCartaX2()) x2.setText("SI"); else x2.setText("NO");
    	if (reglas.isEncadenarRoboCartas()) encadenar.setText("SI"); else encadenar.setText("NO");
    	if (reglas.isRedirigirRoboCartas()) redirigir.setText("SI"); else redirigir.setText("NO");
    	if (reglas.isJugarVariasCartas()) jugarVarias.setText("SI"); else jugarVarias.setText("NO");
    	if (reglas.isEvitarEspecialFinal()) evitarEspecial.setText("SI"); else evitarEspecial.setText("NO");
    }
 }