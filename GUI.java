package itemSrc;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;


public class GUI implements ActionListener
{	
	/** This is the GUI class for my project
	 * @param args in the main function
	 */
	/*
	 * these are the components for the GUI
	 * the top level component is the JFrame  
	 */
	
	private JFrame frame;
	private JPanel northPanel, southPanel;
	private JLabel lblname, lblcourse;
	private JTextField txtName, txtCourse;
	private JButton btnSave;
	
	/*
	 * the constructor for the objects created for 
	 * each component of the JFrame used
	 */
	
	public GUI()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500); //specifies x and y coordinates, length and breadth of the frame 
		frame.setTitle("5CS019 GUI");
		
		northPanel = new JPanel(); // a panel that will go north of the frame
		northPanel.setLayout(new GridLayout(0,2)); // two adjacent next to each other
		lblname = new JLabel("Name : Randara Gill"); // the caption label
		txtName = new JTextField(20); // a text field that has up to a 20 character limit
		txtCourse = new JTextField(20);
		
		lblcourse = new JLabel("Course :");
		
		/*
		 * this part of the code will add widgets to the north panel		 * 
		 */
		
		northPanel.add(lblname);
		northPanel.add(lblcourse);
		northPanel.add(txtCourse);
		northPanel.add(txtName);
		
		southPanel = new JPanel(); // creates a south panel
		btnSave = new JButton("Click to Save"); // A button that when clicked will content obtained from textfields into a file
		btnSave.addActionListener(this); // get the button to listen to a click event
		southPanel.add(btnSave); // adds the button to the south panel
		frame.getContentPane().add(northPanel, BorderLayout.NORTH); // adds the north panel to the north of the border
		frame.getContentPane().add(southPanel, BorderLayout.SOUTH); // ass the south panel to the south of the border
		
		frame.setVisible(true); // Makes the frame visible
			 									
	}
	
	/*
	 * This method uses file stream classes to create a file
	 * and write the content from the text fields 
	 */
	
	public void saveData()
	{
		try 
		{
			FileWriter fr = new FileWriter("Outfile.txt");
			
			BufferedWriter b = new BufferedWriter(fr);
			b.write(txtName.getText());
			b.write(txtCourse.getText());
			b.close();
			fr.close();
		}
		catch(IOException ex) {}
		
	}
	
	/*
	 * this actionPerformed method is part of 
	 * the ActionListener interface
	 */	
	

	public void actionPerformed(ActionEvent e) 
	{
		// if the btnSave event is being used then call the saveData() method
		if(e.getSource() == btnSave)
		{
			saveData();
		}
		
	}
	
	public static void main(String[] args) 
	{
		
		new GUI(); // launches the program
	}

}
