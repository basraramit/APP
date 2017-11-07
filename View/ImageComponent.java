package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.util.Observable;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JComponent;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageComponent.
 */
public class ImageComponent extends JComponent
{
	
	/** The image. */
	private Image image;
	
	/**
	 * Instantiates a new image component.
	 *
	 * @param image the image
	 */
	public ImageComponent(Image image){
		this.image = image;
		repaint();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, this);
	}
}
