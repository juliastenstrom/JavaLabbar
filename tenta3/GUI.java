package tenta3;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class GUI extends JFrame implements ActionListener{
	
	private JRadioButton Return, Button;
	private JButton plus, minus, mult, div, equ;
	private TextField write, output;	
	
	public GUI() {
		
		Font myFont = new Font("SansSerif", Font.PLAIN, 25);
		
		plus = new JButton("+");
		plus.setFont(myFont);
		plus.addActionListener(this);
		
		minus = new JButton("-");
		minus.setFont(myFont);
		minus.addActionListener(this);
		
		mult = new JButton("*");
		mult.setFont(myFont);
		mult.addActionListener(this);
		
		div = new JButton("/");
		div.setFont(myFont);
		div.addActionListener(this);
		
		equ = new JButton("=");
		equ.setFont(myFont);
		equ.addActionListener(this);
		
		Return = new JRadioButton("Return");
		Return.setFont(myFont);
		Return.addActionListener(this);
		
		Button = new JRadioButton("Button");
		Button.setFont(myFont);
		Button.addActionListener(this);
		
		write = new TextField("");
		write.setFont(myFont);
		write.addActionListener(this);
		
		output = new TextField("");
		output.setFont(myFont);
		output.addActionListener(this);
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,3));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2,1));
		
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2,1));
		
		
		p1.add(plus);
		p1.add(minus);
		p2.add(Button);
		p2.add(Return);
		p1.add(p2);
		p1.add(div);
		p1.add(mult);
		p1.add(equ);
		p3.add(write);
		p3.add(output);
		
		Container C = getContentPane();
		C.setLayout(new GridLayout(2,1));
		C.add(p3);
		C.add(p1);
		
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		output.setEnabled(false);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
	}

	public static void main(String[] args) {

		GUI myGUI = new GUI();
		
	}

}
