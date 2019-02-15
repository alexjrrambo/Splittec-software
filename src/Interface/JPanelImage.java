package Interface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class JPanelImage extends JPanel {  

	private static final long serialVersionUID = 1714375113550386727L;

	private Image image;  

	public JPanelImage(Image image) {  
		this.image = image;  
	}  

	@Override  
	public void paintComponent(Graphics g) {  
		super.paintComponent(g);
		if (image != null){
			g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(), this);  
		}
	}  
}