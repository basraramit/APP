package View;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.util.Observable;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Images{
	private BufferedImage image;

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

	public Image getImage(int width, int height){
		return image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
	}
}

