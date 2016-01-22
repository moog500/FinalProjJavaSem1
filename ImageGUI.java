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
    this.setSize(600,600);
    this.setMinimumSize(new Dimension(400,400));
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));

    ImageIcon img1 = new ImageIcon("test.jpg");
    String[] mods = {"border", "mood"};
    JComboBox<String> cb = new JComboBox<String>(mods);
    JButton but = new JButton("Select");
    cb.setSize(50,100);

    pane.add(cb);
    pane.add(but);
    pane.add(new JLabel(img1));}

    public static void main(String[] args){
        ImageGUI Test = new ImageGUI();
        Test.setVisible(true);
    }
    
}
