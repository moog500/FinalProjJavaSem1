public class Driver {
	public static void main(String[] args) {
		BufferedImage bIn = null;
		//Scaling
		if (args[1].equals("s")) {
			try {
				bIn = ImageIO.read(new File(args[0]));
				ImageDN in = new ImageDN(bIn);
				
				ImageDN out = in.scale1(args[2],args[3]);
				out.outputImage(args[4],args[5]);
			}
			catch (Exception e) {
				System.out.println("Please read the README for instructions!");
			}
		}
		//Borders
		else if (args[1].equals("b")) {
			Border brdr = null;
			BufferedImage bBrdr = null;
			try {
				bIn = ImageIO.read(new File(args[0]));
				bBrdr = ImageIO.read(new File(args[2]));
				brdr = new Border(bBrdr,"000000000000");
				ImageDN in = new ImageDN(bIn);
				
				if ((brdr.getX() != in.getX()) || (brdr.getY() != in.getY())) {
					Border brdr2 = new Border(Brdr.scale1(in.getX(),in.getY()).getImg(),"000000000000");
					in.applyBorder(brdr2);
				}
				else {
					in.applyBorder(brdr);
				}
				
				in.outputImage(args[3],args[4]);
			}
			catch (Exception e) {
				System.out.println("Please read the README for instructions!");
			}
		}
		//Moods
		else if (args[1].equals("m")) {
			try {
				bIn = ImageIO.read(new File(args[0]));
				ImageDN in = new ImageDN(bIn);
				
				in.applyMood(args[2]);
				in.outputImage(args[3],args[4]);
			}
			catch (Exception e) {
				System.out.println("Please read the README for instructions!");
			}
		}
		else {
			System.out.println("Please read the README.txt for instructions!");
		}
	}
}