import graphic.Login;


/**
 * @author Vinícius Souza
 * Script que inicia o programa a partir da tela de login.
 */
public class Main {
	
	public static void main(String[] args) {
		try {
			Login inicio = new Login();
			inicio.setVisible(true);
		} catch (Exception e) {
			
		}
	}
}