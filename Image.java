public class Image {
    int[][] pixels;
    int maxX;
    int maxY;

    public Image(BufferedImage img) {
	maxX = img.getWidth();
	maxY = img.getHeight();
	pixels = new int[maxX][maxY];
    }
}