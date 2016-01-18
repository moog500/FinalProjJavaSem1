public class Driver {
	public static void main(String[] args) {
		BufferedImage bIn = null;
		//Scaling
		if (args[1].equals("s")) {
			try {
				bIn = ImageIO.read(new File(args[0]));
				ImageDN in = new ImageDN(b);
				ImageDN out = in.scale1(args[2],args[3]);
				out.outputImage(args[4],args[5]);
			}
			catch (Exception e) {
				System.out.println("Please read the README for instructions!");
			}
		}
		//Borders
		else if (args[1].equals("b")) {
			try {
				
			}
			catch (Exception e) {
				System.out.println("Please read the README for instructions!");
			}
		}
		//Moods
		else if (args[1].equals("m")) {
			try {
				
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