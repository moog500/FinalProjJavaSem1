import java.util.*;
import java.awt.image.*;

public class Mood extends ImageDN {
public int[][] newpixs;
public Mood(BufferedImage img){
	//for baseline gonna do happy mood 
	int r;
	int g;
	int b;
	String newcolor;
	for (int row; row <getPixels().length; row++){
		for (int col; col <getPixels()[row].length; col++){
	        pixels[row][col] = r + g + b + getPixels()[row][col].substring(9,12);
		}
		}
	}
public int[][] tointrgb(int r,g,b){

}

}
}