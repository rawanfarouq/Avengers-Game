package view;

import java.awt.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import controller.GameController;
import engine.Game;
import engine.Player;
import model.world.*;

public class ThirdView extends JFrame
{
	private JButton[][] gridbuttons;
	private JPanel grid;
	private JPanel fteaminfo;
	private JPanel steaminfo;
	private JPanel currinfo;
	private JButton[] gamebuttons;
	private JPanel gamebuttgrid;
	private JButton[] directions;
	private JButton[] directionss;
	private JPanel turnorder;

	
	
	
	
	
	public JButton[] getDirectionss() {
		return directionss;
	}




	public void setDirectionss(JButton[] directionss) {
		this.directionss = directionss;
	}




	public JPanel getTurnorder()
	{
		return turnorder;
	}




	public void setTurnorder(Champion c)
	{
////		turnorder.add(new JButton(" turn order"));
////		engine.PriorityQueue y=x;
////		//this.turnorder = turnorder;
////		for(int i=0;!y.isEmpty();i++)
//		{
////			Champion c= (Champion) y.peekMin();
////			JTextArea p=new JTextArea(c.getName()+"\n");
////			p.setFont(new Font("Serif",Font.BOLD,20));
////			y.remove();
////			turnorder.add(p);
////		}
////		//this.add(turnorder);
		turnorder.removeAll();
		turnorder.add(new JButton(" turn order"));
		JTextArea p=new JTextArea(c.getName()+"\n");
     	p.setFont(new Font("Serif",Font.BOLD,20));
		turnorder.add(p);
		this.add(turnorder);
	}




	public JPanel getCurrinfo() 
	{
		return currinfo;
	}

   


	public void setCurrinfo(Champion c)
	{
		//currinfo.removeAll();
		currinfo.add(new JButton("current player info"));
		String s="";
		for(int i=0;i<c.getAppliedEffects().size();i++)
		{
			s=s+"/n"+"name: "+c.getAppliedEffects().get(i).getName()+"/n"+"duration: "+
					c.getAppliedEffects().get(i).getDuration();
		}
		
		JTextArea x=new JTextArea(c.getName()+"\n"+c.championj());
		JTextArea y=new JTextArea(c.championabilityname());
		this.currinfo.add(x);
		this.currinfo.add(y);
	}




	public JPanel getFteaminfo() {
		return fteaminfo;
	}



	public JButton[] getDirections() 
	{
		return directions;
	}




	public void setDirections(JButton[] directions) {
		this.directions = directions;
	}




	public ThirdView() 
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		this.setBounds(50, 50, 1600, 1400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		grid=new JPanel(new GridLayout(5,5));
		grid.setBounds(300, 0, 700, 700);
		gridbuttons=new JButton[5][5];
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				this.gridbuttons[i][j]=new JButton();
				
				grid.add(gridbuttons[i][j]);
			}
		}
		gamebuttgrid=new JPanel();
		gamebuttgrid.setBounds(980, 445, 400, 700);
		
		gamebuttons=new JButton[5];
		directions=new JButton[4];
		directionss=new JButton[4];
		
		gamebuttons[0]=new JButton("attack");
		gamebuttons[1]=new JButton("cast ability");
		gamebuttons[2]=new JButton("move");
		gamebuttons[3]=new JButton("leader ability");
		gamebuttons[4]=new JButton("END TURN");
		gamebuttons[4].setSize(30, 30);
		
		
		directions[0]=new JButton("down");
		directions[1]=new JButton("up");
		directions[2]=new JButton("right");
		directions[3]=new JButton("left");
		
		directionss[0]=new JButton("downn");
		directionss[1]=new JButton("upp");
		directionss[2]=new JButton("rightt");
		directionss[3]=new JButton("leftt");
		
		directions[0].setEnabled(false);
		directions[1].setEnabled(false);
		directions[2].setEnabled(false);
		directions[3].setEnabled(false);
		
		directionss[0].setEnabled(false);
		directionss[1].setEnabled(false);
		directionss[2].setEnabled(false);
		directionss[3].setEnabled(false);

		gamebuttgrid.add(gamebuttons[0]);
		gamebuttgrid.add(gamebuttons[1]);
		gamebuttgrid.add(gamebuttons[2]);
		gamebuttgrid.add(gamebuttons[3]);
		
		
		gamebuttgrid.add(directions[0]);
		gamebuttgrid.add(directions[1]);
		gamebuttgrid.add(directions[2]);
		gamebuttgrid.add(directions[3]);
		
		gamebuttgrid.add(directionss[0]);
		gamebuttgrid.add(directionss[1]);
		gamebuttgrid.add(directionss[2]);
		gamebuttgrid.add(directionss[3]);
		
		gamebuttgrid.add(gamebuttons[4]);
		
		
		fteaminfo=new JPanel();
		fteaminfo.setBounds(0, 0, 250, 400);
		
		
		steaminfo=new JPanel();
		steaminfo.setBounds(1000, 0, 250, 800);
		
		
		turnorder=new JPanel();
		turnorder.setBounds(900, 600, 500, 300);
		
		currinfo=new JPanel();
		currinfo.setBounds(0, 500, 250, 800);
		
		//this.add(turnorder);
		
		this.add(gamebuttgrid);
		this.add(grid);
		this.add(fteaminfo);
		this.add(steaminfo);
		
		this.add(currinfo);
		
		
		
		this.setVisible(true);
	    this.revalidate();
	    this.repaint();
	}
	
	
	
	
	public JButton[][] getGridbuttons() 
	{
		return gridbuttons;
	}


	
	/////////////////////////
	////           update texts in info after endturn 
	////           method for each in model
	//////////////////////////
	
	
	

	public void setGridbuttons(int x,int y, Champion c) 
	{
		JTextArea v=new JTextArea(c.getName());
		v.setFont(new Font("Serif",Font.BOLD,20));
		JLabel pic=new JLabel();
//		if(c.getName().equals("Captain America")) 
//			pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Captain America.png"));
//		
//		else if(c.getName().equals("Ironman")) 
//			pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Ironman-2.png"));
//		
//		else if(c.getName().equals("Hulk"))
//			pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Hulk-2.png"));
//		
//		else if(c.getName().equals("Deadpool"))
//			pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Deadpool.png"));
//		
//		else if(c.getName().equals("Dr Strange"))
//			pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Dr Strange.png"));
//		
//		else if(c.getName().equals("Electro"))
//			//pic =new JLabel(new ImageIcon("/Users/funnyflea7/Desktop/Electro.webp"));
//			this.gridbuttons[x][y].add(v);
//		
//		else if(c.getName().equals("Ghost Rider"))	
//			pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Ghost Rider.png"));
//		
//		else if(c.getName().equals("Hela"))	
//			pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Hela.png"));
//		
//		else if(c.getName().equals("Iceman"))
//			pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Iceman.png"));
//		
//        else if(c.getName().equals("Loki"))
//        	pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Loki-2.png"));
//		
//        else if(c.getName().equals("Quicksilver"))	
//        	pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Quicksilver-2.png"));
//		
//        else if(c.getName().equals("Spiderman"))
//        	//pic =new JLabel(new ImageIcon("/Users/funnyflea7/Desktop/Spiderman.webp"));
//        	this.gridbuttons[x][y].add(v);
//		
//        else if(c.getName().equals("Thor"))
//        	//pic =new JLabel(new ImageIcon("/Users/funnyflea7/Desktop/Thor.webp"));
//        	this.gridbuttons[x][y].add(v);
//		
//        else if(c.getName().equals("Venom"))
//        	pic =new JLabel(new ImageIcon("/Users/funnyflea7/Downloads/Venom.png"));
//		
//        else if(c.getName().equals("Yellow Jacket"))
        	//pic =new JLabel(new ImageIcon("/Users/funnyflea7/Desktop/Yellow Jacket.webp"));
		this.gridbuttons[x][y].add(v);
        	
		
		//if(c.getName().equals("Captain America")) //this.gridbuttons[x][y].add(pic);
		 //this.gridbuttons[x][y].add(pic);
	}
	
	
	public void setcover(int x,int y)
	{
		//int xx=(int) ((Math.random() * (999 - 1)) + 1);
		
		JTextArea v=new JTextArea("cover" +"\n"+"HP:" );// +xx);
		v.setBackground(Color.yellow);
		v.setFont(new Font("Serif",Font.BOLD,30));
		//int x=(int) ((Math.random() * (4 - 1)) + 1);
		//int y=(int) ((Math.random() * (5 - 0)) + 0);
		this.gridbuttons[x][y].add(v);
		
	}

	
	public void setFteaminfo(String s,ArrayList<Champion> x) 
	{
		fteaminfo.add(new JButton(s+" team info"));
		for(int i=0;i<x.size();i++)
		{
			if(i==0)
			{
				Champion c=x.get(i);
				JTextArea v=new JTextArea("leader"+"\n"+c.getName()+"\n"+c.championj());
				fteaminfo.add(v);
				
			}
			else
			{
			Champion c=x.get(i);
			JTextArea v=new JTextArea(c.toString());
			v.setSize(30, 30);
			fteaminfo.add(v);
			}
		}
	}
	
	public void turnorder(Game engine)
	{
		for(int i=0;i<engine.getTurnOrder().size();i++)
		{
			Champion c=(Champion) engine.getTurnOrder().peekMin();
			JTextArea x=new JTextArea(c.getName());
			this.turnorder.add(x);
		}
	}
	
	public void setSteaminfo(String s,ArrayList<Champion> x) 
	{
		steaminfo.add(new JButton(s+" team info"));
		for(int i=0;i<x.size();i++)
		{
			if(i==0)
			{
				Champion c=x.get(i);
				JTextArea v=new JTextArea("leader"+"\n"+c.getName()+"\n"+c.championj());
				steaminfo.add(v);
			}
			else
			{
			Champion c=x.get(i);
			JTextArea v=new JTextArea(c.toString());
			steaminfo.add(v);
			}
		}
	}

//	public void moveup(Champion c,int x,int y)
//	{
//		this.gridbuttons[x][y]=new JButton("hb");
//		int u=x+1;
//		this.gridbuttons[u][y]=new JButton(c.getName());
//		//this.gridbuttons[x][y]=new JButton();
//		
//	}
	
	public void update(Game engine)
	{
		
		int realx=0;
    	int realy=0;
	    
    	for(int i=0;i<getGamebuttons().length;i++)
			  {	  
				  for(int j=0;j<getGamebuttons().length;j++)
			    {
					  if(i==4) realx=0;
					  else if(i==3) realx=1;
					  else if(i==2) realx=2;
					  else if(i==1) realx=3;
					  else if(i==0) realx=4;
					  
					  if(j==4) realy=0;
					  else if(j==3) realy=1;
					  else if(j==2) realy=2;
					  else if(j==1) realy=3;
					  else if(j==0) realy=4;
					  
					  if(engine.getBoard()[i][j] instanceof Cover)
					  {
						  setcover(i,j);
					  }
					  else if(engine.getBoard()[i][j] instanceof Champion)
					  {
						  Champion c=(Champion) engine.getBoard()[i][j];
						  //if(engine.getFirstPlayer().getTeam().contains(c))
						  {
							  setGridbuttons(i, j, c);
						  }
					  }
						  else if(engine.getBoard()[i][j]== null)
						  {
							  setnull(i, j);
						  }
				  
			    }
			  }

//		grid=new JPanel(new GridLayout(5,5));
//		grid.setBounds(300, 0, 700, 700);
//       gridbuttons=new JButton[5][5];
//		
//		for(int i=0;i<5;i++)
//		{
//			for(int j=0;j<5;j++)
//			{
//				this.gridbuttons[i][j]=new JButton();
//				
//				grid.add(gridbuttons[i][j]);
//			}
//		}
//		for(int i=0;i<5;i++)
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(engine.getBoard()[i][j] instanceof Cover)
//				{
//					//this.gridbuttons[i][j]
//				}
//				else if(engine.getBoard()[i][j] instanceof Champion)
//				{
//					Champion c =(Champion) engine.getBoard()[i][j];
//					JTextArea v=new JTextArea(c.getName());
//					v.setFont(new Font("Serif",Font.BOLD,20));
//					this.gridbuttons[i][j].add(v);
//					//grid.add(gridbuttons[i][j]);
//				}
//				else if(engine.getBoard()[i][j] ==null)
//				{
//					this.gridbuttons[i][j]=new JButton("null");
//				}
//			}
			//this.add(grid);
			
		

		
		
		
		
//		currinfo.removeAll();
//		currinfo.add(new JButton("current player info"));
//		String s="";
//		for(int i=0;i<c.getAppliedEffects().size();i++)
//		{
//			s=s+"/n"+"name: "+c.getAppliedEffects().get(i).getName()+"/n"+"duration: "+
//					c.getAppliedEffects().get(i).getDuration();
//		}
//		
//		JTextArea x=new JTextArea(c.getName()+"\n"+c.championj());
//		JTextArea y=new JTextArea(c.championabilityname());
//		this.currinfo.add(x);
//		this.currinfo.add(y);
	}
	
	
	public JButton[] getGamebuttons() 
	{
		return gamebuttons;
	}




	public void setGamebuttons(JButton[] gamebuttons) 
	{
		this.gamebuttons = gamebuttons;
	}
	
	public void enabledirection()
	{
		directions[0].setEnabled(true);
		directions[1].setEnabled(true);
		directions[2].setEnabled(true);
		directions[3].setEnabled(true);
	}




	public void setnull(int realx, int realy) 
	{
		this.gridbuttons[realx][realy]=new JButton();
		
	}




	public void disabledirections() 
	{
		
		directions[0].setEnabled(false);
		directions[1].setEnabled(false);
		directions[2].setEnabled(false);
		directions[3].setEnabled(false);
	}
	
	public void disabledirectionss() 
	{
		
		directionss[0].setEnabled(false);
		directionss[1].setEnabled(false);
		directionss[2].setEnabled(false);
		directionss[3].setEnabled(false);
	}




	public void enabledirectionn() 
	{
		// TODO Auto-generated method stub
		
		directionss[0].setEnabled(true);
		directionss[1].setEnabled(true);
		directionss[2].setEnabled(true);
		directionss[3].setEnabled(true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	private JPanel gamegrid;
	private JPanel first;
	private JPanel second;
	private JPanel gamebuttons;
	private JPanel currinfo;
	private JButton[][] gridbuttons;
	
	
	private Game game;
	
	
	
	
	public JPanel getGamegrid() 
	{
		return gamegrid;
	}
	

	public JButton[][] getGridbuttons()
	{
		return gridbuttons;
	}

	public void setGridbuttons(JButton[][] gridbuttons) 
	{
		this.gridbuttons = gridbuttons;
	}





	/*public ThirdView() throws IOException
	{
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		this.setBounds(50, 50, 1600, 1400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		  
		gamegrid=new JPanel(new GridLayout(5,5));
		gamegrid.setBounds(0, 0, 750, 801);
		Player p1=new Player("rg");
		Player p2=new Player("rhtg");
		game=new Game(p1,p2);
		
		Object[][] g=game.getBoard();
		//gamegrid =game.getBoard();
		game.placeCovers();
		
		gridbuttons=new JButton[5][5];
		
		
		/*for(int i=0;i<25;i++)
		{///////nested for loop
			JButton x=new JButton();
			//x.setSize(6, 6);
			
			gamegrid.add(x);
		}
		/////////
		currinfo=new JPanel();
		gamebuttons=new JPanel();

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				this.gridbuttons[i][j]=new JButton();
				gamegrid.add(gridbuttons[i][j]);
			}
		}
		
				
		gamebuttons.setBounds(755, 400, 200, 200);
		
		JButton attack=new JButton("attack");
		JButton cast=new JButton("cast ability");
		JButton move=new JButton("move");
		game.prepareChampionTurns();
		//PriorityQueue p=new PriorityQueue(6);
		//p=game.getTurnOrder();
		//JTextArea d=new JTextArea(game.getCurrentChampion().toString()+game.getCurrentChampion().championabilityname()+game.getCurrentChampion().championeffectname());
		//currinfo.add(d);
		
		
		gamebuttons.add(move);
		gamebuttons.add(cast);
		gamebuttons.add(attack);
		
		this.add(gamebuttons);
		this.add(currinfo);
		
		first=new JPanel();
		second=new JPanel();
		
		//GameController.getEngine();
		//String s=FirstView.getAreaOne().getText();
		first.add(new JButton("first team info"));
		second.add(new JButton("second team info"));
		
		first.setBounds(755, 0, 300, 801);
		second.setBounds(1055, 0, 500, 801);
		
		this.add(first);
		this.add(second);
		
		this.add(gamegrid);
		
		
	  this.setVisible(true);
      this.revalidate();
      this.repaint();
		
	}*/


	
	
	
	
	





}








//{
//	private JButton button1;private JButton button2;private JButton button3;
//	private JButton button4;private JButton button5;private JButton button6;
//	private JButton button7;private JButton button8;private JButton button9;
//	private JButton button10;private JButton button11;private JButton button12;
//	private JButton button13;private JButton button14;private JButton button15;
//	//private Game game;
//	private JPanel gamepanel;
//	
//	public ThirdView()
//	{
//      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//		this.setBounds(50, 50, 1200, 801);
//		this.setLocationRelativeTo(null);
//		this.setLayout(null);
//		
//		
////		gamepanel=new JPanel(new GridLayout(5,5));
////		button1=new JButton();
////		button2.setBackground(Color.yellow);
////		button2.setBounds(150, 300, 200 , 80);
////		button2.setFont(new Font("Serif",Font.BOLD,15));
//		
//		//gamepanel.setBackground(Color.cyan);
//		//gamepanel.setBounds(0,500 , 1200, 267);
//		//gamepanel.add(x);
//		//gamepanel.setVisible(true);
//		//this.add(gamepanel);
//		
//		
//		
//		
//		
//		
//		this.setVisible(true);
//        this.revalidate();
//        this.repaint();
//	}
//
//}
