package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import controller.GameController;
import engine.Game;
import model.world.Champion;

public class Secondtry extends JFrame
{
	
		private JButton button0;
		private JPanel panel;
		private JPanel first;
		private JPanel second;
		private JButton[] buttons;
		private JTextArea fleader;
		private JTextArea sleader;
		private JButton secc;
		
		
		
		
		public JButton[] getButtons() {
			return buttons;
		}
		public void setButtons(JButton[] buttons) {
			this.buttons = buttons;
		}
		public JButton getSeccc() 
		{
			return secc;
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
		public Secondtry()
		{
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			this.setBounds(50, 50, 1600, 1400);
			this.setLocationRelativeTo(null);
			//this.setLayout(null);
			this.setFont(new Font("Serif",Font.BOLD,50));
			//JTextArea x= FirstView.getareaone();
			this.setTitle("second player");
			
			 panel=new JPanel(new GridLayout(5,5));
			//panel.setSize(50, 50);
			//panel.setLayout(new GridLayout(3,5));
			 panel.setBounds(0, 0, 500, 500);

			//this.add(new JButton("grgvrrg"));
			//this.add(panel);
			//ArrayList<JButton> button=new ArrayList<JButton>();
			 buttons=new JButton[13];
			for(int i=0;i<GameController.avachamp().size();i++)
			{
				Champion c=GameController.avachamp().get(i);
				JTextArea x=new JTextArea(c.toString());
				panel.add(x);
				buttons[i]=new JButton(c.getName());
				buttons[i].setFont(new Font("Serif",Font.BOLD,27));
				buttons[i].setBackground(Color.BLUE);
				//buttons[i].setSize(3, 3);
				panel.add(buttons[i]);
			}
			buttons[12]=new JButton("next");
			buttons[12].setFont(new Font("Serif",Font.BOLD,27));
			panel.add(buttons[12]);
			
			first=new JPanel();
			first.setToolTipText("first team");
			first.setBounds(200, 500, 100, 100);
			first.add(new JButton("hfg"));
			
			second=new JPanel();
			second.setToolTipText("second team");
			second.setBounds(800, 500, 100, 100);
			second.add(new JButton("hfrfg"));
			
			
			sleader=new JTextArea("first leader");
			this.add(sleader);
			sleader.setVisible(false);
			fleader=new JTextArea("secpbd wvfchj");
			this.add(fleader);
			fleader.setVisible(false);
			//this.add(first);
			
			//this.add(second);
			
			secc=new JButton("next");
			secc.setFont(new Font("Serif",Font.BOLD,27));
			secc.setBackground(Color.BLUE);
			secc.setBounds(0, 0, 500, 500);
			secc.setVisible(false);
			
			this.add(secc);
			
			this.add(panel);
			
			
			this.setVisible(false);
	        this.revalidate();
	        this.repaint();
			
			
			
			
	}

}
