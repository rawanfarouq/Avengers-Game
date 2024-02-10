package view;


import java.awt.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import engine.Game;
import engine.Player;
import model.world.Champion;
import view.FirstView;




public class SecondView extends JFrame
{
	private JButton button0;
	private JPanel panel;
	private JPanel first;
	private JPanel second;
	private JButton[] buttons;
	private JTextArea fleader;
	private JTextArea sleader;
	private JButton sec;
	
	
	
	
	public JButton getSec() 
	{
		return sec;
	}
	public void setSec(JButton sec) 
	{
		panel.setVisible(false);
		sec.setVisible(true);
		
		//this.sec = sec;
	}
	
	
	
	public JTextArea getFleader() {
		return fleader;
	}
	public JTextArea getSleader() {
		return sleader;
	}
	public boolean flag()
	{
		return true;
	}
	public SecondView()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setBounds(50, 50, 1600, 1400);
		this.setLocationRelativeTo(null);
		//this.setLayout(null);
		this.setFont(new Font("Serif",Font.BOLD,50));
		//JTextArea x= FirstView.getareaone();
		this.setTitle("first player");
		
		 panel=new JPanel(new GridLayout(8,8));
		//panel.setSize(50, 50);
		//panel.setLayout(new GridLayout(3,5));
		 //panel.setBounds(0, 0, 500, 500);

		//this.add(new JButton("grgvrrg"));
		//this.add(panel);
		//ArrayList<JButton> button=new ArrayList<JButton>();
		 buttons=new JButton[15];
		for(int i=0;i<Game.getAvailableChampions().size();i++)
		{
			Champion c=Game.getAvailableChampions().get(i);
			JTextArea x=new JTextArea(c.toString());
			x.setFont(new Font("Serif",Font.BOLD,12));
			panel.add(x);
			buttons[i]=new JButton(c.getName());
			buttons[i].setFont(new Font("Serif",Font.BOLD,27));
			buttons[i].setBackground(Color.BLUE);
			//buttons[i].setSize(3, 3);
			panel.add(buttons[i]);
		}

		
		first=new JPanel();
		first.setToolTipText("first team");
		first.setBounds(200, 500, 100, 100);
		first.add(new JButton("hfg"));
		
		second=new JPanel();
		second.setToolTipText("second team");
		second.setBounds(800, 500, 100, 100);
		second.add(new JButton("hfrfg"));
		
		
		sleader=new JTextArea("first leader");
		//this.add(sleader);
		sleader.setVisible(false);
		fleader=new JTextArea("secpbd wvfchj");
		//this.add(fleader);
		fleader.setVisible(false);
		//this.add(first);
		
		//this.add(second);
		
		sec=new JButton("next");
		sec.setFont(new Font("Serif",Font.BOLD,27));
		sec.setBackground(Color.BLUE);
		sec.setBounds(700, 630, 500, 100);
		sec.setVisible(true);
		
		this.add(sec);
		
		panel.setBounds(50, 50, 500, 500);
		this.add(panel);
		
		
		this.setVisible(true);
        this.revalidate();
        this.repaint();
		
		
		
		
	}
	
	
	
	public JPanel getFirst() {
		return first;
	}



	public void setFirst(JPanel first) {
		this.first = first;
	}



	


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setButton0(JButton o) 
	{
		o.setFont(new Font("Serif",Font.BOLD,15));
	}

	public void setButtons(JButton[] buttons) 
	{
		this.buttons = buttons;
	}
	public JButton[] getButtons()
	{
		return buttons;
	}
	public JButton getButton0()
	{
		return button0;
	}
	
	public JButton getbutton(int i)
	{
		return buttons[i];
	}
	public void setSecc(JButton sec2) 
	{
		panel.setVisible(true);
		sec.setVisible(false);
		
	}
	
	
	
}








/*public class SecondView extends JFrame
{
	private JPanel first;
	private JPanel middle;
	private JPanel second;
	private JButton b1;private JButton b2;private JButton b3;
	//private JButton button101;
	private JButton button0;private JButton button1;private JButton button2;
	private JButton button3;private JButton button4;private JButton button5;
	private JButton button6;private JButton button7;private JButton button8;
	private JButton button9;private JButton button10;private JButton button11;
	private JButton button12;private JButton button13;private JButton button14;
    private JTextArea area0; private JTextArea area1; private JTextArea area2; 
    private JTextArea area3; private JTextArea area4; private JTextArea area5;
    private JTextArea area6; private JTextArea area7; private JTextArea area8; 
    private JTextArea area9; private JTextArea area10; private JTextArea area11;
    private JTextArea area12; private JTextArea area13; private JTextArea area14;
	private Game game;
    
    public JPanel getFirst()
	{
		return first;
	}

	public JPanel getMiddle() {
		return middle;
	}

	public JPanel getSecond() {
		return second;
	}



	public SecondView()
	{
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setBounds(50, 50, 1200, 801);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		first=new JPanel();
		second=new JPanel();
		middle=new JPanel();
		first.setBounds(0, 0, 1200, 200);
		first.setBackground(Color.black);
		second.setBackground(Color.red);
		middle.setBackground(Color.cyan);
		second.setBounds(0,500 , 1200, 267);
		middle.setBounds(0, 200, 1200, 267);
		//middle.setLayout(new BorderLayout().CENTER);
		this.add(first);
		//this.add(second);
		this.add(middle);
		Player p1=new Player("gr");
		Player p2=new Player("grr");
		try {
			game=new Game(p1,p2);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		ArrayList<Champion> f=p1.getTeam();
		ArrayList<Champion> s=p2.getTeam();
		
		
		for(int i=0; i<Game.getAvailableChampions().size();i++)
		{
			Champion c ;//= Game.getAvailableChampions().get(i);
			//JTextArea x;//=new JTextArea();
			//x.setText(c.toString());
			switch(i)
			{
			case 0 :
				 c = Game.getAvailableChampions().get(i);
				 area0=new JTextArea();
				area0.setText(c.toString());
			button0=new JButton(c.getName());
			button0.setBackground(Color.yellow);
			button0.setBounds(100, 250, 200 , 80);
			button0.setFont(new Font("Serif",Font.BOLD,15));
			middle.add(button0);
			middle.add(area0);
			
			break;
			case 1:
				c = Game.getAvailableChampions().get(i);
			 area1=new JTextArea();
			 area1.setText(c.toString());
			button1=new JButton(c.getName());
			button1.setBackground(Color.yellow);
			button1.setBounds(150, 300, 200 , 80);
			button1.setFont(new Font("Serif",Font.BOLD,15));
			middle.add(button1);
			middle.add(area1);
			break;
			case 2:
				 c = Game.getAvailableChampions().get(i);
				 area2=new JTextArea();
				area2.setText(c.toString());
				button2=new JButton(c.getName());
				button2.setBackground(Color.yellow);
				button2.setBounds(200, 350, 200 , 80);
				button2.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button2);
				middle.add(area2);
				break;
			case 3:
				c = Game.getAvailableChampions().get(i);
				area3=new JTextArea();
				area3.setText(c.toString());
				button3=new JButton(c.getName());
				button3.setBackground(Color.yellow);
				button3.setBounds(250, 400, 200 , 80);
				button3.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button3);
				middle.add(area3);
				break;
			case 4:
				c = Game.getAvailableChampions().get(i);
				 area4=new JTextArea();
				 area4.setText(c.toString());
				button4=new JButton(c.getName());
				button4.setBackground(Color.yellow);
				button4.setBounds(100, 250, 200 , 80);
				button4.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button4);
				middle.add(area4);
				break;
			case 5:
				c = Game.getAvailableChampions().get(i);
				 area5=new JTextArea();
				 area5.setText(c.toString());
				button5=new JButton(c.getName());
				button5.setBackground(Color.yellow);
				button5.setBounds(100, 250, 200 , 80);
				button5.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button5);
				middle.add(area5);
				break;
			case 6:
				c = Game.getAvailableChampions().get(i);
				 area6=new JTextArea();
				 area6.setText(c.toString());
				button6=new JButton(c.getName());
				button6.setBackground(Color.yellow);
				button6.setBounds(100, 250, 200 , 80);
				button6.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button6);
				middle.add(area6);
				break;
			case 7:
				c = Game.getAvailableChampions().get(i);
				 area7=new JTextArea();
				 area7.setText(c.toString());
				button7=new JButton(c.getName());
				button7.setBackground(Color.yellow);
				button7.setBounds(100, 250, 200 , 80);
				button7.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button7);
				middle.add(area7);
				break;	
			case 8:
				c = Game.getAvailableChampions().get(i);
				 area8=new JTextArea();
				 area8.setText(c.toString());
				button8=new JButton(c.getName());
				button8.setBackground(Color.yellow);
				button8.setBounds(100, 250, 200 , 80);
				button8.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button8);
				middle.add(area8);
				break;
			case 9:
				c = Game.getAvailableChampions().get(i);
				 area9=new JTextArea();
				 area9.setText(c.toString());
				button9=new JButton(c.getName());
				button9.setBackground(Color.yellow);
				button9.setBounds(100, 250, 200 , 80);
				button9.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button9);
				middle.add(area9);
				break;
			case 10:
				c = Game.getAvailableChampions().get(i);
				 area10=new JTextArea();
				 area10.setText(c.toString());
				button10=new JButton(c.getName());
				button10.setBackground(Color.yellow);
				button10.setBounds(100, 250, 200 , 80);
				button10.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button10);
				middle.add(area10);
				break;
			case 11:
				c = Game.getAvailableChampions().get(i);
				 area11=new JTextArea();
				 area11.setText(c.toString());
				button11=new JButton(c.getName());
				button11.setBackground(Color.yellow);
				button11.setBounds(100, 250, 200 , 80);
				button11.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button11);
				middle.add(area11);
				break;	
			case 12:
				c = Game.getAvailableChampions().get(i);
				 area12=new JTextArea();
				 area12.setText(c.toString());
				button12=new JButton(c.getName());
				button12.setBackground(Color.yellow);
				button12.setBounds(100, 250, 200 , 80);
				button12.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button12);
				middle.add(area12);
				break;	
			case 13:
				c = Game.getAvailableChampions().get(i);
				 area13=new JTextArea();
				 area13.setText(c.toString());
				button13=new JButton(c.getName());
				button13.setBackground(Color.yellow);
				button13.setBounds(100, 250, 200 , 80);
				button13.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button13);
				middle.add(area13);
				break;	
			case 14:
				c = Game.getAvailableChampions().get(i);
				 area14=new JTextArea();
				 area14.setText(c.toString());
				button14=new JButton(c.getName());
				button14.setBackground(Color.yellow);
				button14.setBounds(100, 250, 200 , 80);
				button14.setFont(new Font("Serif",Font.BOLD,15));
				middle.add(button14);
				middle.add(area14);
				break;	
		 }
			
		}
		b1=new JButton();
		b1.setBounds(50, 250, 200 , 80);
		b1.setFont(new Font("Serif",Font.BOLD,15));
		b1.setVisible(false);
		first.add(b1);
		
		b2=new JButton();
		b2.setBounds(200, 150, 200 , 80);
		b2.setFont(new Font("Serif",Font.BOLD,15));
		b2.setVisible(false);
		first.add(b2);
		
		b3=new JButton();
		b3.setBounds(300, 250, 200 , 80);
		b3.setFont(new Font("Serif",Font.BOLD,15));
		b3.setVisible(false);
		first.add(b3);

		
		
		
		this.setVisible(true);
        this.revalidate();
        this.repaint();
	}

	
	public void setButton1() 
	{
		button1.setVisible(false);
		//this.remove(button1);
	}
	public JButton getButton0()
	{
	game.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(0));
	Game.getAvailableChampions().remove(0);
	
		return button0;
	}

	public JButton getButton1() {
		return button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public JButton getButton4() {
		return button4;
	}

	public JButton getButton5() {
		return button5;
	}

	public JButton getButton6() {
		return button6;
	}

	public JButton getButton7() {
		return button7;
	}

	public JButton getButton8() {
		return button8;
	}

	public JButton getButton9() {
		return button9;
	}

	public JButton getButton10() {
		return button10;
	}

	public JButton getButton11() {
		return button11;
	}

	public JButton getButton12() {
		return button12;
	}

	public JButton getButton13() {
		return button13;
	}

	public JButton getButton14() {
		return button14;
	}

	public JTextArea getArea0() {
		return area0;
	}

	public JTextArea getArea1() {
		return area1;
	}

	public JTextArea getArea2() {
		return area2;
	}

	public JTextArea getArea3() {
		return area3;
	}

	public JTextArea getArea4() {
		return area4;
	}

	public JTextArea getArea5() {
		return area5;
	}

	public JTextArea getArea6() {
		return area6;
	}

	public JTextArea getArea7() {
		return area7;
	}

	public JTextArea getArea8() {
		return area8;
	}

	public JTextArea getArea9() {
		return area9;
	}

	public JTextArea getArea10() {
		return area10;
	}

	public JTextArea getArea11() {
		return area11;
	}

	public JTextArea getArea12() {
		return area12;
	}

	public JTextArea getArea13() {
		return area13;
	}

	public JTextArea getArea14() {
		return area14;
	}

	public JButton getB1() 
	{
		return b1;
	}
	public void setB1(String s) 
	{
		b1.setText(s);
	}
	public void setB2(String s) 
	{
		b1.setText(s);
	}
	public void setB3(String s) 
	{
		b1.setText(s);
	}

	public JButton getB2() 
	{
		return b2;
	}

	public JButton getB3() 
	{
		return b3;
	}
	

	

}*/
