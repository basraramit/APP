package View;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.util.Observable;
import javax.imageio.ImageIO;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class Images.
 */
public class Images{
	
	/** The image. */
	private BufferedImage image;

	/**
	 * Instantiates a new images.
	 *
	 * @param fileName the file name
	 */
	/*
	 * @param : the file name to be loaded
	 */
	public Images(String fileName){
		try{
			image = ImageIO.read(new File(fileName));
			System.out.println("Image loaded!: ");
		}
		catch (IOException e){
			System.out.println("Image not loaded!: " + e);
		}
	}

	/**
	 * Gets the image.
	 *
	 * @param width the width
	 * @param height the height
	 * @return the image
	 */
	public Image getImage(int width, int height){
		return image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
	}
}

