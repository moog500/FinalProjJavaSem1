import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ImageGUI extends JFrame{
    private BufferedImage imtopen;
    private Container pane; 

    public ImageGUI() {
    this.setTitle("Image Editing GUI");
    this.setSize(600,400);
    this.setMinimumSize(new Dimension(400,400));
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

    ImageIcon img1 = new ImageIcon("test.jpg");
    String[] mods = {"border", "mood"};
    final JComboBox<String> cb = new JComboBox<String>(mods);

    pane.add(cb);}

    public static void main(String[] args){
        ImageGUI Test = new ImageGUI();
        Test.setVisible(true);
    }
    
}
