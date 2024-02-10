package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.*;

public class FirstView extends JFrame
{
	private JTextField areaOne;
	private JTextField areaTwo;
	private JButton kickOff;
	private JLabel pic;
	
	
	public static JTextArea getareaone(JTextField x)
	{
		String s= x.getText();
		return new JTextArea(s);
	}

	public JTextField getAreaOne() {
		return areaOne;
	}

	public JTextField getAreaTwo() {
		return areaTwo;
	}

	public JButton getKickOff() {
		return kickOff;
	}

	public FirstView()
	{
		//super();
		//setSize(700,500);
		//WindowDestroyer myListener = new WindowDestroyer();
        //addWindowListener(myListener);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setBounds(50, 50, 1600, 1400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		areaOne = new JTextField("");
		areaOne.setBounds(1000, 200, 200 , 60);
		areaOne.setBackground(Color.red);
		areaOne.setFont(new Font("Serif",Font.BOLD,15));
		this.add(areaOne);
		
		areaTwo = new JTextField("");
		areaTwo.setBounds(1000, 250, 200 , 60);
		areaTwo.setBackground(Color.LIGHT_GRAY);
		areaTwo.setFont(new Font("Serif",Font.BOLD,15));
		this.add(areaTwo);
		
		
		//ImageIcon f=new ImageIcon("/Users/funnyflea7/Downloads/The_Marvel_Universe.webp");
		//JLabel g=new JLabel(f);
	//g.setIcon(f);
		//g.setBounds(100, 100, 300, 300);
		//this.add(g);
		
		kickOff = new JButton("Start");
		kickOff.setBounds(1000, 400, 200 , 200);
		kickOff.setBackground(Color.yellow);
		kickOff.setFont(new Font("Serif",Font.BOLD,27));
		this.add(kickOff);

		pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/marvel-heroes-transparent-png-stickpng-16.png"));
		 //pic=new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/The_Marvel_Universe.webp"));
		pic.setBounds(0, 0, 1200, 1004);
		//pic.add()
		this.add(pic);
		
        this.setVisible(true);
        this.revalidate();
        this.repaint();
        
        
        //setBackground();
        
        
	}

}
