import javax.sound.sampled.Control;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Control.Type;
import javax.sound.sampled.Line.Info;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.xml.ws.RespectBinding;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class gui extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JMenu menu;
	JButton north;
	JButton south;
	JButton east;
	JButton west;
	JButton reset;
	JPanel Panel;
	JMenuBar menuBar;
	JMenu font;
	JMenuItem font1, font2, font3;
	JMenu size;
	JMenuItem size1, size2, size3;
	JMenu textColor;
	JMenuItem red, blue, random;
	JMenu areaColor;
	JMenuItem areaRed, areaBlue, areaRandom;
	JMenu buttonOutline;
	JMenuItem outlineRed, outlineBlue, outlineRandom, outlineNone;
	JButton[] buttons;
	JMenu[] menus; 
	JMenuItem[] menuItems; 

	JTextArea area;
	
	int fontSize = 12;
	String fontName = "Arial";
	int[] rgb;
	int[] rgbO;
	int[] outline;
	public gui()
	{
		frame=new JFrame();
		frame.add(this);
		
		
		menuBar=new JMenuBar();
		Panel = new JPanel();
		north = new JButton("North");
		north.setPreferredSize(new Dimension(40, 40)); 
		south = new JButton("South");
		south.setPreferredSize(new Dimension(40, 40)); 
		east = new JButton("East");
		east.setPreferredSize(new Dimension(40, 40)); 
		west = new JButton("West");
		west.setPreferredSize(new Dimension(40, 40)); 
		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(40, 40)); 

		
		area = new JTextArea();
		
		Panel.add(reset);
		Panel.add(north);
		Panel.add(east);
		Panel.add(south);
		Panel.add(west);
		
		font = new JMenu("Fonts");
		size = new JMenu("Sizes");
		textColor = new JMenu("Text Colors");
		areaColor = new JMenu("Area Colors");
		buttonOutline = new JMenu("Button Outlines");
		
		
		font1 = new JMenuItem("Arial");
		font2 = new JMenuItem("Times New Roman");
		font3 = new JMenuItem("Cambria");
		size1 = new JMenuItem("10");
		size2 = new JMenuItem("5");
		size3 = new JMenuItem("12");
		red = new JMenuItem("Red");
		blue = new JMenuItem("Blue");
		random = new JMenuItem("Random");
		areaRed = new JMenuItem("Red");
		areaBlue = new JMenuItem("Blue");
		areaRandom = new JMenuItem("Random");
		outlineNone = new JMenuItem("None");
		outlineRed = new JMenuItem("Red");
		outlineBlue = new JMenuItem("Blue");
		outlineRandom = new JMenuItem("Random");
		
		buttons = new JButton[] {reset, north, east, south, west};
		menus = new JMenu[] {font, size, textColor, areaColor, buttonOutline};
		menuItems = new JMenuItem[] {font1, font2, font3, size1, size2, size3, red, blue, random, areaRed, areaBlue, areaRandom, outlineRed, outlineBlue, outlineRandom, outlineNone};
		rgb = new int[] {0, 0, 0};
		rgbO = new int[] {255, 255, 255};
		outline = new int[] {0, 0, 0};
		
		font.add(font1);
		font.add(font2);
		font.add(font3);
		size.add(size1);
		size.add(size2);
		size.add(size3);
		textColor.add(red);
		textColor.add(blue);
		textColor.add(random);
		areaColor.add(areaRed);
		areaColor.add(areaBlue);
		areaColor.add(areaRandom);
		buttonOutline.add(outlineNone);
		buttonOutline.add(outlineRed);
		buttonOutline.add(outlineBlue);
		buttonOutline.add(outlineRandom);
		
		menuBar.add(font);
		menuBar.add(size);
		menuBar.add(textColor);
		menuBar.add(areaColor);
		menuBar.add(buttonOutline);
		
		reset.addActionListener(this);
		north.addActionListener(this);
		east.addActionListener(this);
		west.addActionListener(this);
		south.addActionListener(this);
		font1.addActionListener(this);
		font2.addActionListener(this);
		font3.addActionListener(this);
		size1.addActionListener(this);
		size2.addActionListener(this);
		size3.addActionListener(this);
		red.addActionListener(this);
		blue.addActionListener(this);
		random.addActionListener(this);
		areaRed.addActionListener(this);
		areaBlue.addActionListener(this);
		areaRandom.addActionListener(this);
		outlineNone.addActionListener(this);
		outlineRed.addActionListener(this);
		outlineRandom.addActionListener(this);
		outlineBlue.addActionListener(this);
		
		Panel.setLayout(new GridLayout(1, 6));
		Panel.add(menuBar);
		menuBar.setLayout(new GridLayout(1,6));
		frame.add(Panel, BorderLayout.NORTH);
		frame.add(area, BorderLayout.CENTER); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,600);
		frame.setVisible(true);
		
		setter();
		
		
	}

	public void actionPerformed(ActionEvent e)
	{
		
		if (e.getSource()== north) {
			frame.remove(Panel);
			Panel.setLayout(new GridLayout(1, 6));
			Panel.add(menuBar);
			menuBar.setLayout(new GridLayout(1, 6));
			frame.add(Panel, BorderLayout.NORTH);
		}
		if (e.getSource()== east) {
			frame.remove(Panel);
			Panel.setLayout(new GridLayout(6, 1));
			Panel.add(menuBar);
			menuBar.setLayout(new GridLayout(6, 1));
			frame.add(Panel, BorderLayout.EAST);
		}
		if (e.getSource()== west) {
			frame.remove(Panel);
			Panel.setLayout(new GridLayout(6, 1));
			Panel.add(menuBar);
			menuBar.setLayout(new GridLayout(6, 1));
			frame.add(Panel, BorderLayout.WEST);
		}
		if (e.getSource()== south) {
			frame.remove(Panel);
			Panel.setLayout(new GridLayout(1, 6));
			Panel.add(menuBar);
			menuBar.setLayout(new GridLayout(1, 6));
			frame.add(Panel, BorderLayout.SOUTH);
		}
		
		
		if(e.getSource() == font1) {
			fontName = "Arial";
		}else if(e.getSource() == font2) {
			fontName = "Times New Roman";
		}else if(e.getSource() == font3) {
			fontName = "Cambria";
		}
		if(e.getSource() == size1) {
			fontSize = 10;
		}else if(e.getSource() == size2) {
			fontSize = 5;
		}else if(e.getSource() == size3) {
			fontSize = 12;
		}
		if(e.getSource() == red) {
			rgb[0] = 255;
			rgb[1] = 0;
			rgb[2] = 0;
			
		}else if(e.getSource() == blue) {
			rgb[0] = 0;
			rgb[1] = 0;
			rgb[2] = 255;
		}else if(e.getSource() == random) {
			rgb[0] = (int)(Math.random() * 255)+1;
			rgb[1] = (int)(Math.random() * 255)+1;
			rgb[2] = (int)(Math.random() * 255)+1;
		}
		
		
		
		if(e.getSource() == outlineNone) {
			outline[0] = 0;
			outline[1] = 0;
			outline[2] = 0;
			
		}else if(e.getSource() == outlineRed) {
			outline[0] = 255;
			outline[1] = 0;
			outline[2] = 0;
		}else if(e.getSource() == outlineBlue) {
			outline[0] = 0;
			outline[1] = 0;
			outline[2] = 255;
		}else if(e.getSource() == outlineRandom) {
			outline[0] = (int)(Math.random() * 255)+1;
			outline[1] = (int)(Math.random() * 255)+1;
			outline[2] = (int)(Math.random() * 255)+1;
		}
		
		
		
		
		if(e.getSource() == areaRed) {
			rgbO[0] = 255;
			rgbO[1] = 0;
			rgbO[2] = 0;
			
		}else if(e.getSource() == areaBlue) {
			rgbO[0] = 0;
			rgbO[1] = 0;
			rgbO[2] = 255;
		}else if(e.getSource() == areaRandom) {
			rgbO[0] = (int)(Math.random() * 255)+1;
			rgbO[1] = (int)(Math.random() * 255)+1;
			rgbO[2] = (int)(Math.random() * 255)+1;
		}
		
		if(e.getSource() == reset) {
			reset();
		}
		setter();
		
		frame.revalidate();
	}
	
	public void reset() {
		frame.remove(Panel);
		Panel.setLayout(new GridLayout(1, 6));
		Panel.add(menuBar);
		menuBar.setLayout(new GridLayout(1, 6));
		frame.add(Panel, BorderLayout.NORTH);
		
		fontName = "Arial";
		fontSize = 12;
		
		rgb[0] = 0;
		rgb[1] = 0;
		rgb[2] = 0;
		rgbO[0] = 255;
		rgbO[1] = 255;
		rgbO[2] = 255;
		outline[0] = 0;
		outline[1] = 0;
		outline[2] = 0;
		
		area.setText("");
		
		setter();
	}
	public void setter() {
		for(JMenu menu : menus) {
			menu.setFont(new Font(fontName, Font.PLAIN, fontSize));
			menu.setForeground(new Color(rgb[0], rgb[1], rgb[2]));
			menu.setBackground(new Color(rgbO[0], rgbO[1], rgbO[2]));
			menu.setBorder(new LineBorder(new Color(outline[0], outline[1], outline[2])));
		}
		for(JMenuItem menuItem : menuItems) {
			menuItem.setFont(new Font(fontName, Font.PLAIN, fontSize));
			menuItem.setForeground(new Color(rgb[0], rgb[1], rgb[2]));
			menuItem.setBackground(new Color(rgbO[0], rgbO[1], rgbO[2]));
			menuItem.setBorder(new LineBorder(new Color(outline[0], outline[1], outline[2])));

		}
		for(JButton button : buttons) {
			button.setFont(new Font(fontName, Font.PLAIN, fontSize));
			button.setForeground(new Color(rgb[0], rgb[1], rgb[2]));
			button.setBackground(new Color(rgbO[0], rgbO[1], rgbO[2]));
			button.setBorder(new LineBorder(new Color(outline[0], outline[1], outline[2])));

		}
		area.setFont(new Font(fontName, Font.PLAIN, fontSize));
		area.setForeground(new Color(rgb[0], rgb[1], rgb[2]));
		area.setBackground(new Color(rgbO[0], rgbO[1], rgbO[2]));
		area.setBorder(new LineBorder(new Color(outline[0], outline[1], outline[2])));

		font1.setFont(new Font("Arial", Font.PLAIN, fontSize));
		red.setForeground(new Color(255, 0, 0));
		areaRed.setBackground(new Color(255, 0, 0));
		font2.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
		blue.setForeground(new Color(0, 0, 255));
		areaBlue.setBackground(new Color(0, 0, 255));
		font3.setFont(new Font("Cambria", Font.PLAIN, fontSize));
		random.setForeground(new Color(rgb[0], rgb[1], rgb[2]));
		areaRandom.setBackground(new Color(rgbO[0], rgbO[1], rgbO[2]));
	}
	
	public static void main(String[] args)
	{
		gui app=new gui();
	}

}