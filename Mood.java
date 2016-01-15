import java.util.*;
import java.awt.image.*;

public class Mood extends ImageDN {

public Mood(BufferedImage img){
	//for baseline gonna do happy mood 
	int r;
	int g;
	int b;
	String newcolor;
	for (int row; row <getPixels().length; row++){
		for (int col; col <getPixels()[row].length; col++){
			r = Integer.parseInt(getPixels()[row][col].substring(0,3)) + 20;
			g = Integer.parseInt(getPixels()[row][col].substring(3,6)) - 20;
	        b = Integer.parseInt(getPixels()[row][col].substring(6,9)) - 20;    
    		
	        pixels[row][col] = r + g + b + getPixels()[row][col].substring(9,12);
		}
	}


}
}