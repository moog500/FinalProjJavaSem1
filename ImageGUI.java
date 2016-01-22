import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ImageGUI extends JFrame implements ActionListener{
    private BufferedImage imtopen = null;
    private Container pane;
    private String[] mods = {"filter", "mood", "border"};
    private String[] filters = {"b/w", "glass"};
    private String[] moods = {"happy", "sad", "mad"};
    private JComboBox<String> cb;
    private JComboBox<String> filterlist;
    private JComboBox<String> moodlist;
    private String cur;
    private ImageIcon img1;
    private JLabel aimg1;
    

    public void actionPerformed(ActionEvent e){
        String event = e.getActionCommand();
        try {
            imtopen = ImageIO.read(new File("test.jpg"));
        }
        catch (IOException ex) {
            System.out.println("IOException");
        }
        if(event.equals("Select")){
            if (cur.equals("filter")){
                ImageDN img = new ImageDN(imtopen);
                img.applyBlackWhite();
                img.outputImage("currentOutput","jpg");
                ImageIcon img2 = new ImageIcon("currentOutput.jpg");
                aimg1.setIcon(null);
                pane.add(new JLabel(img2));
            }
    }}

    public ImageGUI() {
    this.setTitle("Image Editing GUI");
    this.setSize(600,600);
    this.setMinimumSize(new Dimension(400,400));
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
    
    img1 = new ImageIcon("test.jpg");
    cb = new JComboBox<String>(mods);
    cur = (String)cb.getSelectedItem();
    JButton but = new JButton("Select");
    cb.setSize(50,100);
    aimg1 = new JLabel(img1);

    but.addActionListener(this);
    but.setActionCommand("Select");
    pane.add(cb);
    pane.add(but);
    pane.add(aimg1);


    }

    public static void main(String[] args){
        ImageGUI Test = new ImageGUI();
        Test.setVisible(true);
    }
    
}
