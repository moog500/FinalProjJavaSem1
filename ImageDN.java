import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class ImageDN {
	private int[][] pixels;
	private String[][] hexpistols;
	private int maxX;
	private int maxY;

	public ImageDN(BufferedImage img) {
		maxX = img.getWidth();
		maxY = img.getHeight();
		pixels = new int[maxY][maxX];
		hexpistols = new String[maxY][maxX];
		hexifier();
		for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				pixels[i][j] = img.getRGB(j,i);
			}
		}
		System.out.println(pixels[50][50]);
		System.out.println(hexpistols[50][50]);
		System.out.println(maxX);
		System.out.println(maxY);
	}
	
	'public void hexifier(){
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[row].length; col++ ){
				Color pixel = new Color(pixels[row][col]);
				String s = String.format("#%02x%02x%02x", pixel.getRed(), pixel.getGreen(), pixel.getBlue());
				pixel = Color.decode(s);
				hexpistols[row][col] = s;
			}
		}
	}'
	//commenting this garbage out, because it is garbage LOL
	//for real tho, it is initialized to the first thing i think 
	// and shit don't change 
	//it is 2 am i will just fix this tommorow in class 
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