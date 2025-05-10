package com.anudip.BugTrackingSystem1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Operations.BugOperations;
import Operations.DeveloperOperations;
import Operations.ProjectOperations;
import Operations.ReportOperations;
import Operations.TesterOperations;

public class App 
{
	//Scanner object creation for taking input from the user
	static Scanner sc=new Scanner(System.in);
	
	static boolean loginSuccessful;

	//implementations of main operations
	public static void mainOps()
	{

		while(true) {
			System.out.println("Press 1. Project Details \nPress 2. Developer Details \nPress 3. Tester Details"
					+ "\nPress 4. Bug Details \nPress 5. Report Details\nPress 6.Exit");
			System.out.println("Enter choice: ");
			int input=sc.nextInt();
			switch(input) {
			case 1:
				ProjectOperations.projectOperations();
				System.out.println("====================================================");
				break;
			case 2:
				DeveloperOperations.developerOperations();
				System.out.println("====================================================");
				break;

			case 3:
				TesterOperations.testerOperations();
				System.out.println("====================================================");
				break;

			case 4:
				BugOperations.bugOperations();
				System.out.println("====================================================");
				break;

			case 5:
				ReportOperations.reportOperations();
				System.out.println("====================================================");
				break;

			case 6:
				System.exit(0);

			default:
				System.out.println("Invalid Input");
			}
		}
	}
	
	//Admin Login window
	static void showLoginScreen() {
		JFrame frame = new JFrame("Admin Login"); // creating JFrame object
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Use DISPOSE so we can detect close
		frame.setLayout(new GridBagLayout());  //setting layout to the frame
		frame.setResizable(false);

		GridBagConstraints gbc = new GridBagConstraints(); //creating constraints object
		gbc.insets = new Insets(10, 10, 10, 10); //giving insets to the the grid bag

		JLabel userLabel = new JLabel("Username:");  //creating JLabel object
		JTextField userField = new JTextField(15);  //creating textfield object

		JLabel passLabel = new JLabel("Password:");
		JPasswordField passField = new JPasswordField(15);

		JButton loginBtn = new JButton("Login");  //creating button object for login
		JLabel resultLabel = new JLabel("");

		// Add components
		gbc.gridx = 0; gbc.gridy = 0;
		frame.add(userLabel, gbc);
		gbc.gridx = 1;
		frame.add(userField, gbc);

		gbc.gridx = 0; gbc.gridy = 1;
		frame.add(passLabel, gbc);
		gbc.gridx = 1;
		frame.add(passField, gbc);

		gbc.gridx = 1; gbc.gridy = 2;
		frame.add(loginBtn, gbc);

		gbc.gridy = 3;
		frame.add(resultLabel, gbc);


		// Login button action
		loginBtn.addActionListener(e -> {
			String username = userField.getText();
			String password = new String(passField.getPassword());

			if (username.equals("Admin") && password.equals("Admin@123")) {
				resultLabel.setForeground(Color.GREEN);
				resultLabel.setText("Login successful!");
				loginSuccessful = true;
			} else {
				resultLabel.setForeground(Color.RED);
				resultLabel.setText("Invalid credentials!");
				loginSuccessful = false;
			}
		});

		// On window close, check login status
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if (loginSuccessful) {
					mainOps();
				}
			}
		});

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	//Main method
	public static void main( String[] args )
	{

		System.out.println("---------------Bug Tracking System----------------");
		SwingUtilities.invokeLater(App::showLoginScreen);

	}
}
