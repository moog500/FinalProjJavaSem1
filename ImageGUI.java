import javax.swing.*;
import java.awt.*;

public class ImageGUI extends JFrame{
    private BufferedImage imtopen;
    private Container pane; 

    public ImageGUI() {
    this.setTitle("Image Editing GUI");
    this.setSize(600,400);
    this.setMinimumSize(Dimension(400,400));
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

    ImageDN img = new ImageDN(imtopen);


    ImageIcon img = new ImageIcon(img);
    pane.add(img);



    }

}