package display;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ImageLabel {
	JLabel myLabel;
	
	public ImageLabel(File file){
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			ImageIcon icon = new ImageIcon( (Image) img);
			myLabel = new JLabel(icon,SwingConstants.CENTER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JLabel get(){
		return myLabel;
	}
}
