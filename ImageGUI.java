import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ImageGUI extends JFrame {
	private BufferedImage imtopen = null;
	private Container pane;
	private String[] filters = {"b/w", "glass"};
	private String[] moods = {"happy", "sad", "mad"};
	private String[] borders = {"border1", "border2", "border3"};
	private JRadioButton border;
	private JRadioButton mood;
	private JRadioButton filter;
	private ButtonGroup choices;
	private JComboBox<String> filterlist;
	private JComboBox<String> moodlist;
	private JComboBox<String> borderlist;
	private String cur;
	private ImageIcon img1;
	private JLabel aimg1;
	private JComboBox<String> menuSelected;
	private JTextField userInput;

	public ImageGUI() {
		this.setTitle("Image Editing GUI");
		this.setSize(600,600);
		this.setMinimumSize(new Dimension(400,400));
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			imtopen = ImageIO.read(new File("test.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pane = this.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		img1 = new ImageIcon("test.jpg");
		aimg1 = new JLabel(img1);

		RadioListener myListener = new RadioListener();
		filter = new JRadioButton("filter");
		filter.setActionCommand("Filter");
		filter.addActionListener(myListener);
		filter.addChangeListener(myListener);
		filter.addItemListener(myListener);

		mood = new JRadioButton("mood");
		mood.setActionCommand("Mood");
		mood.addActionListener(myListener);
		mood.addChangeListener(myListener);
		mood.addItemListener(myListener);
		
		filterlist = new JComboBox<String>(new DefaultComboBoxModel<String>(filters));
		filterlist.addActionListener(new FilterSelectionListener());

		moodlist = new JComboBox<String>(new DefaultComboBoxModel<String>(moods));
		moodlist.addActionListener(new MoodSelectionListener());

		borderlist = new JComboBox<String>(new DefaultComboBoxModel<String>(borders));
		borderlist.addActionListener(new BorderSelectionListener());
		
		border = new JRadioButton("border");
		border.setActionCommand("Border");
		border.addActionListener(myListener);
		border.addChangeListener(myListener);
		border.addItemListener(myListener);
		choices = new ButtonGroup();
		choices.add(mood);
		choices.add(border);
		choices.add(filter);

		pane.add(aimg1);
		pane.add(border);
		pane.add(mood);
		pane.add(filter);
	}

	public static void main(String[] args){
		ImageGUI Test = new ImageGUI();
		Test.setVisible(true);
	}

	class FilterSelectionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			System.out.println("Combo action: " + action);

			JComboBox cb = (JComboBox)e.getSource();
			String filterSelected = (String)cb.getSelectedItem();
			System.out.println("Filter option selected: " + filterSelected);
			if("glass".equals(filterSelected)) {
				ImageDN img = new ImageDN(imtopen);
                img.applyGlass();
                img.outputImage("currentOutput","jpg");
			} else if("b/w".equals(filterSelected)) {
				ImageDN img = new ImageDN(imtopen);
                img.applyBlackWhite();
                img.outputImage("currentOutput","jpg");
			}
		}		
	}

	class MoodSelectionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			System.out.println("Combo action: " + action);

			JComboBox cb = (JComboBox)e.getSource();
			String moodSelected = (String)cb.getSelectedItem();
			System.out.println("Mood option selected: " + moodSelected);
			
			if("happy".equals(moodSelected)) {
				ImageDN img = new ImageDN(imtopen);
                img.applyMood("happy");
                img.outputImage("currentOutput","jpg");
			} else if("sad".equals(moodSelected)) {
				ImageDN img = new ImageDN(imtopen);
                img.applyMood("sad");
                img.outputImage("currentOutput","jpg");
			} else {
				ImageDN img = new ImageDN(imtopen);
                img.applyMood("mad");
                img.outputImage("currentOutput","jpg");				
			}
		}		
	}

class BorderSelectionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			System.out.println("Combo action: " + action);

			JComboBox cb = (JComboBox)e.getSource();
			String borderSelected = (String)cb.getSelectedItem();
			System.out.println("Border option selected: " + borderSelected);
			if("border1".equals(borderSelected)) {
				ImageDN img = new ImageDN(imtopen);
                try {
					img.applyBorder(new Border(ImageIO.read(new File("border0.jpg")), "red"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                img.outputImage("currentOutput","jpg");
			} else if("border2".equals(borderSelected)) {
				ImageDN img = new ImageDN(imtopen);
                try {
					img.applyBorder(new Border(ImageIO.read(new File("border1.jpg")), "red"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                img.outputImage("currentOutput","jpg");
			} else if("border2".equals(borderSelected)) {
				ImageDN img = new ImageDN(imtopen);
                try {
					img.applyBorder(new Border(ImageIO.read(new File("border2.jpg")), "red"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                img.outputImage("currentOutput","jpg");
			}
		}		
	} 

	class RadioListener implements ActionListener, //only one event type needed
	ChangeListener, //for curiosity only
	ItemListener {  //for curiosity only
		public void actionPerformed(ActionEvent e) {
			String factoryName = null;

			System.out.print("ActionEvent received: ");
			if(menuSelected != null) {
				menuSelected.setVisible(false);
				pane.remove(menuSelected);
			}

			if (e.getActionCommand() == "Filter") {
				System.out.println("Filter pressed.");
				filterlist = new JComboBox<String>(new DefaultComboBoxModel<String>(filters));
				filterlist.addActionListener(new FilterSelectionListener());
				menuSelected = filterlist;				
			}

			if (e.getActionCommand() == "Mood") {
				System.out.println("Mood pressed.");
				moodlist = new JComboBox<String>(new DefaultComboBoxModel<String>(moods));
				moodlist.addActionListener(new MoodSelectionListener());
				moodlist.setVisible(true);
				menuSelected = moodlist;
			}

			if (e.getActionCommand() == "Border") {
				System.out.println("Border pressed.");
				borderlist = new JComboBox<String>(new DefaultComboBoxModel<String>(borders));
				borderlist.addActionListener(new BorderSelectionListener());
				menuSelected = borderlist;
			} 
			pane.add(menuSelected);
			menuSelected.setEnabled(true);
			//aimg1.setIcon(null);
		}

		public void itemStateChanged(ItemEvent e) {
			System.out.println("ItemEvent received: " 
					+ e.getItem()
					+ " is now "
					+ ((e.getStateChange() == ItemEvent.SELECTED)?
							"selected.":"unselected"));
		}

		public void stateChanged(ChangeEvent e) {
			//System.out.println("ChangeEvent received from: "
			//		+ e.getSource());
		}
	}
}
