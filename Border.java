import java.util.*;
import java.awt.image.*;

public class Border extends ImageDN {
    private ArrayList<Integer> borderPos;

    public Border(BufferedImage brdr) {
	super(brdr);
	borderPos = new ArrayList<Integer>();
	for (int row = 0; row < getHexPistols().length; row++) {
	    for (int col = 0; col < getHexPistols().length; col++) {
		if (getHexPistols()[row][col].equals("#000000")) {
		    borderPos.add(row);
		    borderPos.add(col);
		}
	    }
	}
    }

    
}