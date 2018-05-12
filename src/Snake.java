import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación
 * @author enriqueVilCamp
 * @version final
 * @since 13/12/2017 
 */
public class Snake extends Application{

	/** Ancho y alto del panel de trabajo (respectivamente) */
	public final int WIDTH = 600, HEIGHT = 400;
	
	/** Atributo que se corresponde con el contexto gráfico del Canvas lo posee */
	GraphicsContext gc ;

	/**
	 * Método que actualiza las coordenadas de las pelotas en el contexto gráfico del Canvas correspondiente
	 * @param ballInputs almacena las pelotas creadas en el método llenaArrayPelotas
	 * @return no retorna nada
	 */
	public void update(ArrayList<Ball> ballInputs) {
		gc.clearRect(0, 0, 600, 400);
		for(int i=0;i<ballInputs.size();i++) {
			Ball ball = ballInputs.get(i);
			if(ball.getX() > WIDTH-ball.getRadius() || ball.getX() < 0) {
				ball.setDx(-ball.getDx());
			}
			if(ball.getY() > HEIGHT-ball.getRadius() || ball.getY() < 0) {
				ball.setDy(-ball.getDy());
			}
			ball.moveX();
			ball.moveY();
			ball.render(gc);
		}
	}      

	/**
	 * Método que crea el nodo principal (panel de trabajo) de la aplicación y sobre el que se añaden los demás nodos 
	 * @param ballInputs almacena las pelotas creadas en el método llenaArrayPelotas
	 * @return retorna el nodo padre usado para crear la escena 
	 */
	public Parent create(ArrayList<Ball> ballInputs) {
		Pane root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		Canvas canv = new Canvas(WIDTH, HEIGHT);
		gc =  canv.getGraphicsContext2D();

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				update(ballInputs);
			}
		};

		timer.start();

		root.getChildren().add(canv);
		return root;
	}
	
	/**
	 * Método que llena un vector de tipo ArrayList de instancias de pelotas de la clase ball, inicializadas en coordenadas x e y "contiguas"
	 * @param ballInputs como array que guarda instancias de la clase Ball inicializado en el método start
	 * @return no retorna nada
	 */
	public void llenaArrayPelotas(ArrayList<Ball> ballInputs) {
		for(int i=0; i<10;i++) {
			ballInputs.add(new Ball(i*10, i*10, 2, 2, 20));
		}
	}

	/**
	 * Método start de la clase Application sobreescrito (crea un escenario con una escena).
	 * @return no retorna nada
	 * @see javafx.application.Application.Parameters 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Snake");
		ArrayList<Ball> ballInputs = new ArrayList<>();
		llenaArrayPelotas(ballInputs);
		Scene scene = new Scene(create(ballInputs));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Método principal que ejecuta la aplicación
	 * @param args 
	 * @return no retorna nada
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
