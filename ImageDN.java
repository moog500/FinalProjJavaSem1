import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class ImageDN {
    private int[][] pixels;
    private int maxX;
    private int maxY;

    public ImageDN(BufferedImage img) {
	maxX = img.getWidth();
	maxY = img.getHeight();
	pixels = new int[maxX][maxY];
	for (int i = 0; i < maxX; i++) {
	    for (int j = 0; j < maxY; j++) {
		pixels[i][j] = img.getRGB(i,j);
	    }
	}
	System.out.println(pixels[maxX-1][maxY-1]);
    }
    
    public static void main(String[] args) {
	BufferedImage b = null;
	try {
	    b = ImageIO.read(new File("test.jpg"));
	}
	catch (IOException e) {
	    System.out.println("test");
	}

	ImageDN a = new ImageDN(b);
    }
}