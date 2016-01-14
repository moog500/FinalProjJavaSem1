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
	for (int i = 0; i < maxY; i++) {
	    for (int j = 0; j < maxX; j++) {
	        c = new Color(img.getRGB(j,i));
		String[] colors = new String[3];

		if ((""+c.getRed()).length() == 1) {
		    colors[0] = "00"+c.getRed();
		}
		if ((""+c.getRed()).length() == 2) {
		    colors[0] = "0"+c.getRed();
		}
		if ((""+c.getRed()).length() == 3) {
		    colors[0] = ""+c.getRed();
		}

		if ((""+c.getGreen()).length() == 1) {
		    colors[1] = "00"+c.getGreen();
		}
		if ((""+c.getGreen()).length() == 2) {
		    colors[1] = "0"+c.getGreen();
		}
		if ((""+c.getGreen()).length() == 3) {
		    colors[1] = ""+c.getGreen();
		}

		if ((""+c.getBlue()).length() == 1) {
		    colors[2] = "00"+c.getBlue();
		}
		if ((""+c.getBlue()).length() == 2) {
		    colors[2] = "0"+c.getBlue();
		}
		if ((""+c.getBlue()).length() == 3) {
		    colors[2] = ""+c.getBlue();
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
	for (int i = 0; i < pos.size(); i+=2) {
	    img.setRGB(pos.get(i),pos.get(i+1),applied.getImage().getRGB((int)pos.get(i),(int)pos.get(i+1)));
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
	//a.testColors();
	
    
	BufferedImage brdr = null;
	Border test = null;
	try {
	    brdr = ImageIO.read(new File("test_border.png"));
	}
	catch (IOException e) {
	    System.out.println("test2");
	}
	test = new Border(brdr, "000000000");
	a.applyBorder(test);

	try {
	    String s = String.format("%s.png","test");
	    File output = new File(s);
	    ImageIO.write(a.getImage(),"png",output);
	}
	catch (IOException e) {
	    System.out.println("test3");
	}
    }
}