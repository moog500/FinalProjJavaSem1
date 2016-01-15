import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ImageDN {
	private String[][] pixels;
	private String[][] hexpistols;
	private char[][] greypix;
	private int maxX;
	private int maxY;
	private BufferedImage img;

	public ImageDN(BufferedImage img) {
		this.img = img;
		maxX = img.getWidth();
		maxY = img.getHeight();
		pixels = new String[maxY][maxX];
		hexpistols = new String[maxY][maxX];
		Color c;
		String s;
		String get;
		for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				c = new Color(img.getRGB(j,i));
				String[] colors = new String[3];
				for (int a = 0; a < 3; a++) {
					s = "";
					get = "";
					if (a == 0) {
						get = ""+c.getRed();
					}
					if (a == 1) {
						get = ""+c.getGreen();
					}
					if (a == 2) {
						get = ""+c.getBlue();
					}
					for (int b = 0; b < 3-(get).length(); b++) {
						s += "0";
					}
					s += get;
					colors[a] = s;
				}
				pixels[i][j] = colors[0]+colors[1]+colors[2];
			}
		}
	}

	public String[][] getPixels() {
		return pixels;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public BufferedImage getImage() {
		return img;
	}

	public void testColors(){
		int x;
		int y;
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			x = rand.nextInt(maxX);
			y = rand.nextInt(maxY);
			System.out.println("X: " + x + ", Y: " + y);
			System.out.println("aRGB: " + pixels[y][x]);
			System.out.println("Hex: " + hexpistols[y][x]);
			System.out.println();
		}
	}

	public void applyBorder(Border applied) {
		ArrayList<Integer> pos = applied.getBorderPos();
		int posX;
		int posY;
		int valX;
		int valY;
		for (int i = 0; i < pos.size(); i+=2) {
			posX = pos.get(i);
			posY = pos.get(i+1);
			valX = (int)pos.get(i);
			valY = (int)pos.get(i+1);
			img.setRGB(posX,posY,applied.getImage().getRGB(valX,valY));
		}
	}

	public void outputImage(String filename, String extension) {
		try {
			String s = filename+"."+extension;
			File output = new File(s);
			ImageIO.write(img, extension, output);
		}
		catch (IOException e) {
			System.out.println("Input/Output error. Please check that you have entered the correct parameters and try again.");
		}
	}

	public static void main(String[] args) {
		BufferedImage b = null;
		try {
			b = ImageIO.read(new File("whiteimage200x200.png"));
		}
		catch (IOException e) {
			System.out.println("IOException1");
		}
		ImageDN a = new ImageDN(b);
		
		
		BufferedImage brdr = null;
		Border test = null;
		try {
			brdr = ImageIO.read(new File("blackborder200x200.jpg"));
		}
		catch (IOException e) {
			System.out.println("IOException2");
		}
		test = new Border(brdr, "000000000");
		
		a.applyBorder(test);

		
		a.outputImage("whiteimageblackborder200x200","jpg");
	}
}