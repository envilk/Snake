import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {

	/** coordenada x en el eje cartesiano del panel de trabajo */
	private int x;
	
	/** coordenada y en el eje cartesiano del panel de trabajo */
	private int y;
	
	/** variable que indica cuánto se mueve en el eje x en cada frame del Animation Timer */
	private int dx;
	
	/** variable que indica cuánto se mueve en el eje y en cada frame del Animation Timer */
	private int dy;
	
	/** radio de una instancia de pelota */
	private int radius;
	
	/* Aqui simplemente hay un constructor por defecto, otro parametrizado y 
	 * los setters y getters necesarios de los atributos de la clase 
	 */
	
	public Ball() {
		this.x = 0;
		this.y = 0;
		this.dx = 0;
		this.dy = 0;
		this.radius = 0;
	}
	
	public Ball(int x, int y, int dx, int dy, int radius) {
		this.x = x;
		this.y = y;
		this.dx  = dx;
		this.dy =  dy;
		this.radius = radius;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * Método que dibuja una pelota en el plano Canvas, según las coordenadas x e y de una instancia de la clase Ball
	 * @param gc es el contexto gráfico del plano Canvas sobre el que llamemos al método
	 * @return no retorna nada
	 */
	public void render(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRoundRect(this.x, this.y, this.radius, this.radius, this.radius, this.radius);
	}
	
	/**
	 * Método que desplaza una pelota por el panel de trabajo según el atributo dx de esa instancia de pelota  
	 * @param no recibe parámetros
	 * @return no retorna nada
	 */
	public void moveX() {
		this.x += this.dx;
	}
	
	/**
	 * Método que desplaza una pelota por el panel de trabajo según el atributo dy de esa instancia de pelota 
	 * @param no recibe parámetros
	 * @return no retorna nada
	 */
	public void moveY() {
		this.y += this.dy;
	}
	
}
