import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ImageDN {
    private int[][] pixels;
    private String[][] hexpistols;
    private char[][] greypix;
    private int maxX;
    private int maxY;

    public ImageDN(BufferedImage img) {
	maxX = img.getWidth();
	maxY = img.getHeight();
	pixels = new int[maxY][maxX];
	hexpistols = new String[maxY][maxX];
	for (int i = 0; i < maxY; i++) {
	    for (int j = 0; j < maxX; j++) {
		pixels[i][j] = img.getRGB(j,i);
	    }
	}
	hexifier();
    }
	
    public void hexifier(){
	Color pixel;
	for (int row = 0; row < pixels.length; row++) {
	    for (int col = 0; col < pixels[row].length; col++ ){
		pixel = new Color(pixels[row][col]);
		String s = ("" + pixels[row][col]).substring(0,2) + String.format("#%02x%02x%02x", pixel.getRed(), pixel.getGreen(), pixel.getBlue());
		hexpistols[row][col] = s;
	    }
	}
    }

    public int[][] getPixels() {
	return pixels;
    }

    public String[][] getHexPistols() {
	return hexpistols;
    }

    public int getMaxX() {
	return maxX;
    }

    public int getMaxY() {
	return maxY;
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

    /*public void bwcheck() {
	for (int row = 0; row < hexpistols.length; row++){
	    for (int col = 0; col< hexpistols[col].length; col++){
		//gonna start dropping cites; http://stackoverflow.com/questions/7704377/unable-to-parse-argb-hex-to-integer
		if (hexpistols[row][col].//compareto would go here)
		    Long tempdogo = Long.parseLong(hexpistols[row][col], 16);
		    if tempdogo - Long.parseLong('00000000', 16) > tempdogo -  Long.parseLong('000000', 16){
			    greypix[row][col] = ';';
			}
		    }
	    }
	}
    }*/

    public void toterminal(){
	for (int row = 0; row < hexpistols.length; row++){
	    for (int col = 0; col < hexpistols[row].length; col++){
		System.out.println(hexpistols[row][col]);
	    }
	}
    }

    public void applyBorder(Border applied) {
	ArrayList<Integer> pos = applied.getBorderPos();
	for (int i = 0; i < pos.size(); i+=2) {
	    hexpistols[pos.get(i)][pos.get(i+1)] = applied.getColor();
	}
    }

    public void outputImage() {
	
    }

    public static void main(String[] args) {
	BufferedImage b = null;
	try {
	    b = ImageIO.read(new File("test2.jpg"));
	}
	catch (IOException e) {
	    System.out.println("test");
	}

	ImageDN a = new ImageDN(b);
	a.testColors();
	    
	BufferedImage brdr = null;
	Border test = null;
	try {
	    brdr = ImageIO.read(new File("test_border.png"));
	}
	catch (IOException e) {
	    System.out.println("test2");
	}
	test = new Border(brdr, "#000000");
	a.applyBorder(test);
    }
}