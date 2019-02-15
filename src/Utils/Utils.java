package Utils;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *  @author Bruno Konzen Stahl
 *  @since 11/08/2010
 */
public class Utils{

	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static ImageIcon imageIcon;
	private static String title;
	public static float leiaNumericoComVirgula;

	/**
	 *  Métodos para ler texto
	 */
	public static String leiaLiteral(){
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	public static String leiaLiteral(String mensagem){
		return (String) JOptionPane.showInputDialog(null, mensagem, title, JOptionPane.QUESTION_MESSAGE, imageIcon, null, null);
		//return JOptionPane.showInputDialog(null,mensagem,"",JOptionPane.QUESTION_MESSAGE);
	}

	/**
	 *  Método para ler números inteiros
	 */
	public static int leiaNumerico(){
		return new Integer(leiaLiteral());
	}
	public static Integer leiaNumerico(String mensagem){
		return Integer.parseInt(leiaLiteral(mensagem));
	}

	/**
	 *  Método para ler números com virgula do teclado
	 */
	public static float leiaNumericoComVirgula(){
		String number = leiaLiteral();
		number = number.replaceAll(",", ".");
		return new Float(number);
	}
	public static float leiaNumericoComVirgula(String mensagem){
		String number = leiaLiteral(mensagem);
		number = number.replaceAll(",", ".");
		return Float.parseFloat(number);
	}

	/**
	 *  Método para escrever no console
	 */
	public static void escreva(Object obj){
		System.out.println(obj+"");
	}
	public static void escrevaMensagem(Object obj){
		JOptionPane.showMessageDialog(null,obj+"",title,1,imageIcon);
	}

	/**
	 *  Método para limpar textos do console
	 */
	public static void limpaTela(){
		for (int i=0; i<50; i++){
			System.out.println();
		}
	}

	/**
	 *  Método para setar o padrão visual dos componentes
	 */
	public static void setLookAndFeel(){
		Font fonte = new Font("Tahoma", Font.PLAIN, 11);
		UIManager.put("Label.font", fonte);
		UIManager.put("Button.font", fonte);
		UIManager.put("ComboBox.font", fonte);
		UIManager.put("TextField.font", fonte);
		UIManager.put("TextArea.font", fonte);
		UIManager.put("CheckBox.font", fonte);
		UIManager.put("MenuBar.font", fonte);
		UIManager.put("MenuItem.font", fonte);
		UIManager.put("Menu.font", fonte);
		UIManager.put("RadioButton.font", fonte);
		UIManager.put("TabbedPane.font", fonte);
		UIManager.put("TitledBorder.font", fonte);
	}

	public static void setIconMenu(String dir){
		imageIcon = new ImageIcon(Utils.class.getClassLoader().getResource(dir));
	}
	public static void setTile(String titleNome){
		title = titleNome;
	}
	public static ImageIcon resizeImageIcon(String diretorio, int width, int heigt){
		ImageIcon iconMaterial = new ImageIcon(Utils.class.getClassLoader().getResource(diretorio));
		return new ImageIcon(iconMaterial.getImage().getScaledInstance(width,heigt,100));
	}
}