
package lab6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI extends JFrame implements ActionListener{
	
	private JButton loadB, searchB, addB, saveB, nextB, deleteB;
	private JTextField searchF, nameF, numberF;
	private PhoneBook phoneBook = new PhoneBook();
	private ArrayList<Person> array;
	private int counter;

	
	

	public GUI() {
		
		setTitle("Interactive phonebook");
		Font myFont = new Font("SanSerif", Font.PLAIN, 20);
		
		loadB = new JButton("Load phonebook");
		loadB.setFont(myFont);
		loadB.addActionListener(this);
		
		searchB = new JButton("Search");
		searchB.setFont(myFont);
		searchB.addActionListener(this);
		
		addB = new JButton("Add person");
		addB.setFont(myFont);
		addB.addActionListener(this);
		
		saveB = new JButton("Save phonebook");
		saveB.setFont(myFont);
		saveB.addActionListener(this);
		
		nextB = new JButton("Next name");
		nextB.setFont(myFont);
		nextB.addActionListener(this);
		
		deleteB = new JButton("Delete person");
		deleteB.setFont(myFont);
		deleteB.addActionListener(this);
		
		searchF = new JTextField();
		searchF.setFont(myFont);
		searchF.addActionListener(this);
		
		numberF = new JTextField();
		numberF.setFont(myFont);
		numberF.addActionListener(this);
		
		nameF = new JTextField();
		nameF.setFont(myFont);
		nameF.addActionListener(this);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,2));

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3,1));
		
		p1.add(loadB);
		p1.add(saveB);
		p1.add(searchB);
		p1.add(nextB);
		p1.add(addB);
		p1.add(deleteB);
		p2.add(searchF);
		p2.add(nameF);
		p2.add(numberF);
		Container C = getContentPane();
		C.setLayout(new GridLayout(1,2));
		C.add(p1);
		C.add(p2);
		
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		searchB.setEnabled(false);
		addB.setEnabled(false);
		saveB.setEnabled(false);
		nextB.setEnabled(false);
		deleteB.setEnabled(false);
		nameF.setEnabled(false);
		numberF.setEnabled(false);
	
	}
	
	//???????????????????????????????????????????????????????
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==loadB || ae.getSource() == searchF) { //press return????  
			searchB.setEnabled(true);
			addB.setEnabled(true);
			saveB.setEnabled(true);
			nextB.setEnabled(false);
			deleteB.setEnabled(true);
			nameF.setEnabled(false);
			numberF.setEnabled(false);

			String input = searchF.getText();
			try {
				phoneBook.load(input);
				nameF.setText("Phonebook loaded");
			} catch (IOException e) {
				nameF.setText("Try again");
			}
		}
		
		if(ae.getSource()==saveB) {
			nextB.setEnabled(false);
			nameF.setEnabled(false);
			numberF.setEnabled(false);
			
			if(searchF.getText().isBlank() || searchF.getText().equals("PhoneList.txt")) {
				searchF.setText("");
				nameF.setText("Provide a file name");
				
			}
			else {
				try {
					String a = (phoneBook.save(searchF.getText()));
					nameF.setText(a);
					searchF.setText("");
				} catch (IOException e) {
					;
				}
			}
		}
		
		if(ae.getSource() == searchB) {
			nextB.setEnabled(false);
			nameF.setEnabled(false);
			numberF.setEnabled(false);

			String arg = searchF.getText();
			array = phoneBook.search(arg);
			if(array.size()<1) {
				nameF.setText("Provide a name");
			}
			else if(array.size()==1) {
				nameF.setText(array.get(0).getFullName());
				numberF.setText(Integer.toString(array.get(0).getPhoneNumber()));
			}
			
			else {
				nextB.setEnabled(true);
				counter = 0;
				nameF.setText(array.get(counter).getFullName());
				numberF.setText(Integer.toString(array.get(counter).getPhoneNumber()));
			}
		}
		
		if(ae.getSource() == nextB) {
			nextB.setEnabled(false);
			nameF.setEnabled(false);
			numberF.setEnabled(false);
			
			counter++;
			nameF.setText(array.get(counter).getFullName());
			numberF.setText(Integer.toString(array.get(counter).getPhoneNumber()));
			if(counter >= array.size()) {
				counter = 0;
				
			}
		}
		
		if(ae.getSource()==deleteB) {
			
			searchF.setText(phoneBook.deletePerson(nameF.getText(), Integer.valueOf(numberF.getText())));
			
		}
		
		if(ae.getSource() == addB) {
			searchF.setEnabled(false);
	
			if("Type in name and phone number".equals(searchF.getText())) {
				boolean wow = phoneBook.addPerson(nameF.getText(), Integer.valueOf(numberF.getText()));
				nameF.setText("");
				numberF.setText("");
				searchF.setText("");
				
				if(wow) {
					searchF.setText("Person added");
				}
				else {
					searchF.setText("Could not be added");
				}
				nameF.setEnabled(false);
				numberF.setEnabled(false);
			}
			else {
				searchF.setText("Type in name and phone number");
				nameF.setEnabled(true);
				numberF.setEnabled(true);
				nameF.setText("");
				numberF.setText("");
			}
		}
	}




	public static void main(String[] args) {
	GUI myGUI = new GUI();

	}

}
