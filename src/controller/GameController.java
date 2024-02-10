package controller;

import java.awt.*;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import java.util.Scanner;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Game;
import engine.Player;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import view.FirstView;
//import view.GameView;
import view.SecondView;
import view.Secondtry;

import java.util.ArrayList;

import view.ThirdView;
public class GameController extends JFrame implements ActionListener ,MouseListener,KeyListener

{
	private FirstView FirstView;
	public Game engine;
	private SecondView SecondView;//=new SecondView();
	private Secondtry secondtry;
	private ThirdView ThirdView;
	
	
	private JPanel p1;
	private JButton[][] buttons;

	private JButton moveUp;
	private JButton moveDown;
	private JButton moveLeft;
	private JButton moveRight;
	
	
	public static void main (String[] args) throws IOException
	{
	  

		new GameController();
		//if(engine.getSecondPlayer().getTeam().size()==3)

		
	}
	public GameController()
	{
	  FirstView = new FirstView();
	  //SecondView=new SecondView();
	  FirstView.getKickOff().addActionListener(this);
	  //SecondView.getButton1().addActionListener(this);
	  
	  this.secondtry=new Secondtry();
	  ThirdView=new ThirdView();
	  ThirdView.setVisible(false);
	  
	  
//	  p1 = new JPanel();
//		p1.setBounds(10, 10, 500, 500);
//		p1.setBackground(Color.BLACK);
//		p1.setLayout(new GridLayout(5, 5));
//		this.getContentPane().add(p1);
//	  
//	  buttons = new JButton[5][5];
//		for (int i = 0; i < buttons.length; i++) {
//			for (int j = 0; j < buttons.length; j++) {
//				buttons[i][j] = new JButton();
//				if (engine.getBoard()[i][j] == null) {
//					buttons[i][j].setBackground(Color.white);
//				} else if (engine.getBoard()[i][j] instanceof Cover) {
//					buttons[i][j].setBackground(Color.BLACK);
//				} else {
//					if (engine.getBoard()[i][j] == engine.getCurrentChampion()) {
//						buttons[i][j].setBackground(Color.GREEN);
//					}
//				}
//				p1.add(buttons[i][j]);
//			}
//		}
//
//		moveUp = new JButton("Move Attack UP");
//		moveUp.setBounds(550, 20, 200, 30);
//		moveUp.addActionListener(this);
//		this.getContentPane().add(moveUp);
//
//		moveDown = new JButton("Move Attack Down");
//		moveDown.setBounds(550, 100, 200, 30);
//		moveDown.addActionListener(this);
//		this.getContentPane().add(moveDown);
//		
//		moveLeft = new JButton("Move Left");
//		moveLeft.setBounds(550, 200, 200, 30);
//		moveLeft.addActionListener(this);
//		this.getContentPane().add(moveLeft);
//		
//		moveRight = new JButton("Move Right");
//		moveRight.setBounds(550, 300, 200, 30);
//		moveRight.addActionListener(this);
//		this.getContentPane().add(moveRight);
//
//		this.getContentPane().setLayout(null);
//		this.setSize(1000, 600);
//		this.setVisible(true);
	  
	  
	}
	  
	  
	  
	  
	  
	  
	  
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == FirstView.getKickOff()) 
		{
			Player p1 = new Player(FirstView.getAreaOne().getText());
			Player p2 = new Player(FirstView.getAreaTwo().getText());
			

				try 
				{
					engine = new Game(p1,p2);
					FirstView.setVisible(false);
					
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
				  SecondView=new SecondView();
				  //secondtry=new Secondtry();
				  //SecondView.addMouseListener(this);
				  String x="your first choice is your leader";
			        JOptionPane.showMessageDialog(SecondView,x);
			        String y=FirstView.getAreaOne().getText()+" "+"choose your players";
			        JOptionPane.showMessageDialog(SecondView,y);
				  //Component x=SecondView.getPanel().getComponent(0);
				  //System.out.println(x);
				  
				  
				  for(int i=0;i<SecondView.getButtons().length;i++)
				  {
					  SecondView.getButtons()[i].addActionListener(this);
					  //SecondView.getButtons()[i].addMouseListener(this);
				  }
				  SecondView.getSec().addActionListener(this);
				  //SecondView.getSec().addActionListener(this);
//				  ThirdView=new ThirdView();
//				  for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//					{
//						ThirdView.getGamebuttons()[i].addActionListener(this);
//					}
				  //SecondView.addMouseListener(this);
				  //SecondView.addKeyListener(this);
		}

				  
	              if(e.getSource()==SecondView.getButtons()[0] && engine.getFirstPlayer().getTeam().size()<3)
					{ 
					  SecondView.getButtons()[0].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(0));
					  Game.getAvailableChampions().remove(0);
					}
				  else if(e.getSource()==SecondView.getButtons()[1] &&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[1].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(1));
					  Game.getAvailableChampions().remove(1);
				  }
				  else if(e.getSource()==SecondView.getButtons()[2] &&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[2].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(2));
					  Game.getAvailableChampions().remove(2);
				  }
				  else if(e.getSource()==SecondView.getButtons()[3]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[3].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(3));
					  Game.getAvailableChampions().remove(3);
				  }
				  else if(e.getSource()==SecondView.getButtons()[4]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[4].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(4));
					  Game.getAvailableChampions().remove(4);
				  }
				  else if(e.getSource()==SecondView.getButtons()[5]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[5].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(5));
					  Game.getAvailableChampions().remove(5);
				  }
				  else if(e.getSource()==SecondView.getButtons()[6]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[6].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(6));
					  Game.getAvailableChampions().remove(6);
				  }

				  else if(e.getSource()==SecondView.getButtons()[7]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[7].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(7));
					  Game.getAvailableChampions().remove(7);
				  }
				  else if(e.getSource()==SecondView.getButtons()[8]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[8].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(8));
					  Game.getAvailableChampions().remove(8);
				  }
				  else if(e.getSource()==SecondView.getButtons()[9]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[9].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(9));
					  Game.getAvailableChampions().remove(9);
				  }
				  else if(e.getSource()==SecondView.getButtons()[10]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[10].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(10));
					  Game.getAvailableChampions().remove(10);
				  }
				  else if(e.getSource()==SecondView.getButtons()[11]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[11].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(11));
					  Game.getAvailableChampions().remove(11);
				  }
				  else if(e.getSource()==SecondView.getButtons()[12]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[12].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(12));
					  Game.getAvailableChampions().remove(12);
				  }
				  else if(e.getSource()==SecondView.getButtons()[13]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[13].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(13));
					  Game.getAvailableChampions().remove(13);
				  }
				  else if(e.getSource()==SecondView.getButtons()[14]&&engine.getFirstPlayer().getTeam().size()<3)
				  {
					  SecondView.getButtons()[14].setEnabled(false);
					  engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(14));
					  Game.getAvailableChampions().remove(14);
				  }
	              
				  else if(e.getSource()==SecondView.getSec())
	              {
	            	  SecondView.setVisible(false);
	            	  engine.getFirstPlayer().setLeader(engine.getFirstPlayer().getTeam().get(0));
	            	  this.secondtry=new Secondtry();
	            	  secondtry.setVisible(true);
	            	  String p="your first choice is your leader";
				        JOptionPane.showMessageDialog(secondtry,p);
				        String y=FirstView.getAreaTwo().getText()+" "+"choose your players";
				        JOptionPane.showMessageDialog(secondtry,y);
				        for(int i=0;i<secondtry.getButtons().length;i++)
						  {
				        	secondtry.getButtons()[i].addActionListener(this);
						  }
				        secondtry.getButtons()[12].addActionListener(this);
				        secondtry.getSeccc().addActionListener(this);
	              }

				  else if(e.getSource()==secondtry.getButtons()[0] && engine.getSecondPlayer().getTeam().size()<3)
		               {
						  //SecondView.getButtons()[0].setVisible(false);
				    	secondtry.getButtons()[0].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(0));
					    }
					  else if(e.getSource()==secondtry.getButtons()[1] && engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[1].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(1));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[2] &&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[2].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(2));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[3]&&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[3].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(3));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[4]&&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[4].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(4));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[5]&&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[5].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(5));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[6]&&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[6].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(6));
						
					  }
					  
					  else if(e.getSource()==secondtry.getButtons()[7]&&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[7].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(7));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[8]&&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[8].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(8));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[9]&&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[9].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(9));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[10])//&&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[10].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(10));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[11])//&&engine.getSecondPlayer().getTeam().size()<3)
					  {
						  secondtry.getButtons()[11].setEnabled(false);
						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(11));
						
					  }
					  else if(e.getSource()==secondtry.getButtons()[12])
					  {
						 
						  secondtry.setVisible(false);
						  engine.getSecondPlayer().setLeader(engine.getSecondPlayer().getTeam().get(0));
						  engine.placeChampions();
						  
						engine.prepareChampionTurns();
							
						  ThirdView=new ThirdView();
					    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
							ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
							ThirdView.setCurrinfo(engine.getCurrentChampion());

						  //ThirdView.update(engine);
						  

							for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								{
									ThirdView.getGamebuttons()[i].addActionListener(this);
								}
							
							
							for(int i=0;i<ThirdView.getDirections().length;i++)
							{
								ThirdView.getDirections()[i].addActionListener(this);
							}
							for(int i=0;i<ThirdView.getDirectionss().length;i++)
							{
								ThirdView.getDirectionss()[i].addActionListener(this);
							}
							
							
							
							int realx=0;
					    	int realy=0;
						    
					    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								  {	  
									  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
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
											  ThirdView.setcover(i,j);
										  }
										  else if(engine.getBoard()[i][j] instanceof Champion)
										  {
											  Champion c=(Champion) engine.getBoard()[i][j];
											  //if(engine.getFirstPlayer().getTeam().contains(c))
											  {
												  ThirdView.setGridbuttons(i, j, c);
											  }
										  }
											  else if(engine.getBoard()[realx][realy]== null)
											  {
												  ThirdView.setnull(realx, realy);
											  }
									  
								    }
								  }
							
							//ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
							//ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
							//ThirdView.setCurrinfo(engine.getCurrentChampion());
						//ThirdView.setTurnorder(engine.prepareChampionTurns());
					  }
					   
				    System.out.println(engine.getCurrentChampion());
	              //System.out.println(engine.getTurnOrder().peekMin());
				    
				     if(e.getSource()==ThirdView.getGamebuttons()[0])
				    {
				    	ThirdView.enabledirectionn();
				    	
				    }
				    else if(e.getSource()==ThirdView.getGamebuttons()[1])
				    {
				    	ThirdView.enabledirection();
				    	
				    }
				     
				    else if(e.getSource()==ThirdView.getGamebuttons()[3])
				    {
				    	try 
				    	{
							engine.useLeaderAbility();
						} 
				    	catch (LeaderNotCurrentException e1) 
				    	{
							// TODO Auto-generated catch block
				    		JOptionPane.showInputDialog(this,e1);
						} catch (LeaderAbilityAlreadyUsedException e1) 
				    	{
							// TODO Auto-generated catch block
							JOptionPane.showInputDialog(this,e1);
						}
				    	
				    }
				    
				    else if(e.getSource()==ThirdView.getGamebuttons()[4])
				    {
				    	//engine.getTurnOrder().remove();
				    	engine.endTurn();
				    	//engine.prepareChampionTurns();
				    	
				    	
				    	ThirdView=new ThirdView();
                        
						  //ThirdView.update(engine);
				    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
						ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
						ThirdView.setCurrinfo(engine.getCurrentChampion());

							for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								{
									ThirdView.getGamebuttons()[i].addActionListener(this);
								}
							for(int i=0;i<ThirdView.getDirectionss().length;i++)
							{
								ThirdView.getDirectionss()[i].addActionListener(this);
							}
							
							for(int i=0;i<ThirdView.getDirections().length;i++)
							{
								ThirdView.getDirections()[i].addActionListener(this);
							}
							
							
							
							int realx=0;
					    	int realy=0;
						    
					    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								  {	  
									  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
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
											  ThirdView.setcover(i,j);
										  }
										  else if(engine.getBoard()[i][j] instanceof Champion)
										  {
											  Champion c=(Champion) engine.getBoard()[i][j];
											  //if(engine.getFirstPlayer().getTeam().contains(c))
											  {
												  ThirdView.setGridbuttons(i, j, c);
											  }
										  }
											  else if(engine.getBoard()[realx][realy]== null)
											  {
												  ThirdView.setnull(realx, realy);
											  }
									  
								    }
								  }
				    	
				    	
				    	//ThirdView.update(engine.getCurrentChampion());
				    	
				    }
				    else if(e.getSource()==ThirdView.getGamebuttons()[2])
				    {
				    	ThirdView.enabledirection();
				    	
				    }
				    
				    System.out.println("x is "+engine.getCurrentChampion().getLocation().x);
				    //
				     System.out.println("y is "+engine.getCurrentChampion().getLocation().y);
//				    System.out.println();
//				    System.out.println();
//				    System.out.println();
//				    System.out.println(engine.getBoard()[1][1]);
				    
				     
//				     if(e.getSource()==ThirdView.getDirectionss()[0])
//				     {
//				    	 try {
//							engine.attack(Direction.UP);
//						} catch (NotEnoughResourcesException  e1) {
//							// TODO Auto-generated catch block
//							JOptionPane.showMessageDialog(this," not enough resources");
//						}
//				    	 catch (ChampionDisarmedException e1) 
//					    	{
//								JOptionPane.showMessageDialog(this,"your champion is disarmed");
//							}
//				    	 catch(InvalidTargetException e1)
//					    	{JOptionPane.showMessageDialog(this,"invalid target");}
//				    	 
//				    	 
//				    	 
//				    	 ThirdView=new ThirdView();
//	                        
//						  //ThirdView.update(engine);
//				    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
//						ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
//						ThirdView.setCurrinfo(engine.getCurrentChampion());
//
//							for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//								{
//									ThirdView.getGamebuttons()[i].addActionListener(this);
//								}
//							
//							for(int i=0;i<ThirdView.getDirections().length;i++)
//							{
//								ThirdView.getDirections()[i].addActionListener(this);
//							}
//							
//							
//							
//							int realx=0;
//					    	int realy=0;
//						    
//					    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//								  {	  
//									  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
//								    {
//										  if(i==4) realx=0;
//										  else if(i==3) realx=1;
//										  else if(i==2) realx=2;
//										  else if(i==1) realx=3;
//										  else if(i==0) realx=4;
//										  
//										  if(j==4) realy=0;
//										  else if(j==3) realy=1;
//										  else if(j==2) realy=2;
//										  else if(j==1) realy=3;
//										  else if(j==0) realy=4;
//										  
//										  if(engine.getBoard()[i][j] instanceof Cover)
//										  {
//											  ThirdView.setcover(i,j);
//										  }
//										  else if(engine.getBoard()[i][j] instanceof Champion)
//										  {
//											  Champion c=(Champion) engine.getBoard()[i][j];
//											  //if(engine.getFirstPlayer().getTeam().contains(c))
//											  {
//												  ThirdView.setGridbuttons(i, j, c);
//											  }
//										  }
//											  else if(engine.getBoard()[realx][realy]== null)
//											  {
//												  ThirdView.setnull(realx, realy);
//											  }
//									  
//								    }
//								  }
//				    	
//				    	 
//				     }
				     
				     
				     
				     
				     if(e.getSource()==ThirdView.getDirectionss()[0])
					    {
					    	try {
								engine.attack(Direction.UP);
								
							} catch (NotEnoughResourcesException e1) 
					    	{
								JOptionPane.showMessageDialog(this,"cannot move not enough resources");
							}
					    	
					    	//ThirdView.update(engine);
						  //ThirdView.disabledirections();
 catch (ChampionDisarmedException e1) {
								// TODO Auto-generated catch block
	 JOptionPane.showMessageDialog(this,"your champion is disarmed");
							} catch (InvalidTargetException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(this,"invalid target");
							}
					    	
					    	
					    	
					    	
					    	
					    	
					    	ThirdView=new ThirdView();
	                        
					    	
					    	ThirdView.disabledirectionss();
					    	
					    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
							ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
							ThirdView.setCurrinfo(engine.getCurrentChampion());

							  //ThirdView.update(engine);
							  
//
//								for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//									{
//										ThirdView.getGamebuttons()[i].addActionListener(this);
//									}
//								
//								for(int i=0;i<ThirdView.getDirections().length;i++)
//								{
//									ThirdView.getDirections()[i].addActionListener(this);
//								}
//								for(int i=0;i<ThirdView.getDirectionss().length;i++)
//								{
//									ThirdView.getDirectionss()[i].addActionListener(this);
//								}
//								
//								
//								
//								int realx=0;
//						    	int realy=0;
//							    
//						    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//									  {	  
//										  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
//									    {
//											  if(i==4) realx=0;
//											  else if(i==3) realx=1;
//											  else if(i==2) realx=2;
//											  else if(i==1) realx=3;
//											  else if(i==0) realx=4;
//											  
//											  if(j==4) realy=0;
//											  else if(j==3) realy=1;
//											  else if(j==2) realy=2;
//											  else if(j==1) realy=3;
//											  else if(j==0) realy=4;
//											  
//											  if(engine.getBoard()[i][j] instanceof Cover)
//											  {
//												  ThirdView.setcover(i,j);
//											  }
//											  else if(engine.getBoard()[i][j] instanceof Champion)
//											  {
//												  Champion c=(Champion) engine.getBoard()[i][j];
//												  //if(engine.getFirstPlayer().getTeam().contains(c))
//												  {
//													  ThirdView.setGridbuttons(i, j, c);
//												  }
//											  }
//												  else if(engine.getBoard()[realx][realy]== null)
//												  {
//													  ThirdView.setnull(realx, realy);
//												  }
//										  
//									    }
//									  }
						    	}
				     if(e.getSource()==ThirdView.getDirectionss()[2])
					    {
					    	try {
								engine.attack(Direction.RIGHT);
								
							} catch (NotEnoughResourcesException e1) 
					    	{
								JOptionPane.showMessageDialog(this,"cannot move not enough resources");
							}
					    	
					    	//ThirdView.update(engine);
						  //ThirdView.disabledirections();
 catch (ChampionDisarmedException e1) {
								// TODO Auto-generated catch block
	 JOptionPane.showMessageDialog(this,"your champion is disarmed");
							} catch (InvalidTargetException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(this,"invalid target");
							}

					    	
					    	ThirdView=new ThirdView();
	                        
					    	
					    	ThirdView.disabledirectionss();
					    	
					    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
							ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
							ThirdView.setCurrinfo(engine.getCurrentChampion());

							  //ThirdView.update(engine);
							  

								for(int i=0;i<ThirdView.getGamebuttons().length;i++)
									{
										ThirdView.getGamebuttons()[i].addActionListener(this);
									}
								
								for(int i=0;i<ThirdView.getDirectionss().length;i++)
								{
									ThirdView.getDirectionss()[i].addActionListener(this);
								}
								
								for(int i=0;i<ThirdView.getDirections().length;i++)
								{
									ThirdView.getDirections()[i].addActionListener(this);
								}
								
								
								
								int realx=0;
						    	int realy=0;
							    
						    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
									  {	  
										  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
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
												  ThirdView.setcover(i,j);
											  }
											  else if(engine.getBoard()[i][j] instanceof Champion)
											  {
												  Champion c=(Champion) engine.getBoard()[i][j];
												  //if(engine.getFirstPlayer().getTeam().contains(c))
												  {
													  ThirdView.setGridbuttons(i, j, c);
												  }
											  }
												  else if(engine.getBoard()[realx][realy]== null)
												  {
													  ThirdView.setnull(realx, realy);
												  }
										  
									    }
									  }
						    	}
				     if(e.getSource()==ThirdView.getDirectionss()[1])
					    {
					    	try {
								engine.attack(Direction.DOWN);
								
							} catch (NotEnoughResourcesException e1) 
					    	{
								JOptionPane.showMessageDialog(this,"cannot move not enough resources");
							}
					    	
					    	//ThirdView.update(engine);
						  //ThirdView.disabledirections();
 catch (ChampionDisarmedException e1) {
								// TODO Auto-generated catch block
	 JOptionPane.showMessageDialog(this,"your champion is disarmed");
							} catch (InvalidTargetException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(this,"invalid target");
							}

					    	//ThirdView=new ThirdView();
	                        
					    	
					    	ThirdView.disabledirectionss();
					    	
					    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
							ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
							ThirdView.setCurrinfo(engine.getCurrentChampion());

							  //ThirdView.update(engine);
							  

//								for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//									{
//										ThirdView.getGamebuttons()[i].addActionListener(this);
//									}
//								
//								for(int i=0;i<ThirdView.getDirectionss().length;i++)
//								{
//									ThirdView.getDirectionss()[i].addActionListener(this);
//								}
//								for(int i=0;i<ThirdView.getDirections().length;i++)
//								{
//									ThirdView.getDirections()[i].addActionListener(this);
//								}
//								
//								
//								int realx=0;
//						    	int realy=0;
//							    
//						    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//									  {	  
//										  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
//									    {
//											  if(i==4) realx=0;
//											  else if(i==3) realx=1;
//											  else if(i==2) realx=2;
//											  else if(i==1) realx=3;
//											  else if(i==0) realx=4;
//											  
//											  if(j==4) realy=0;
//											  else if(j==3) realy=1;
//											  else if(j==2) realy=2;
//											  else if(j==1) realy=3;
//											  else if(j==0) realy=4;
//											  
//											  if(engine.getBoard()[i][j] instanceof Cover)
//											  {
//												  ThirdView.setcover(i,j);
//											  }
//											  else if(engine.getBoard()[i][j] instanceof Champion)
//											  {
//												  Champion c=(Champion) engine.getBoard()[i][j];
//												  //if(engine.getFirstPlayer().getTeam().contains(c))
//												  {
//													  ThirdView.setGridbuttons(i, j, c);
//												  }
//											  }
//												  else if(engine.getBoard()[realx][realy]== null)
//												  {
//													  ThirdView.setnull(realx, realy);
//												  }
//										  
//									    }
//									  }
						    	}
				     
				     
//				     if(e.getSource()==ThirdView.getDirectionss()[1])
//				     {
//				    	 try {
//							engine.attack(Direction.DOWN);
//						} catch (NotEnoughResourcesException  e1) {
//							// TODO Auto-generated catch block
//							JOptionPane.showMessageDialog(this," not enough resources");
//						}
//				    	 catch (ChampionDisarmedException e1) 
//					    	{
//								JOptionPane.showMessageDialog(this,"your champion is disarmed");
//							}
//				    	 catch(InvalidTargetException e1)
//					    	{JOptionPane.showMessageDialog(this,"invalid target");}
//				    	 
//				    	 
//				    	 
//				    	 ThirdView=new ThirdView();
//				    	 
//				    	 //ThirdView.disabledirectionss();
//	                        
//						  //ThirdView.update(engine);
//				    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
//						ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
//						ThirdView.setCurrinfo(engine.getCurrentChampion());
//
////							for(int i=0;i<ThirdView.getGamebuttons().length;i++)
////								{
////									ThirdView.getGamebuttons()[i].addActionListener(this);
////								}
////							
////							for(int i=0;i<ThirdView.getDirectionss().length;i++)
////							{
////								ThirdView.getDirectionss()[i].addActionListener(this);
////							}
////							
////							
////							
////							int realx=0;
////					    	int realy=0;
////						    
////					    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
////								  {	  
////									  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
////								    {
////										  if(i==4) realx=0;
////										  else if(i==3) realx=1;
////										  else if(i==2) realx=2;
////										  else if(i==1) realx=3;
////										  else if(i==0) realx=4;
////										  
////										  if(j==4) realy=0;
////										  else if(j==3) realy=1;
////										  else if(j==2) realy=2;
////										  else if(j==1) realy=3;
////										  else if(j==0) realy=4;
////										  
////										  if(engine.getBoard()[i][j] instanceof Cover)
////										  {
////											  ThirdView.setcover(i,j);
////										  }
////										  else if(engine.getBoard()[i][j] instanceof Champion)
////										  {
////											  Champion c=(Champion) engine.getBoard()[i][j];
////											  //if(engine.getFirstPlayer().getTeam().contains(c))
////											  {
////												  ThirdView.setGridbuttons(i, j, c);
////											  }
////										  }
////											  else if(engine.getBoard()[realx][realy]== null)
////											  {
////												  ThirdView.setnull(realx, realy);
////											  }
////									  
////								    }
////								  }
//					    	//ThirdView.disabledirectionss();
//				    	
//				    	 
//				     }
				     
				     if(e.getSource()==ThirdView.getDirectionss()[3])
				     {
				    	 try {
							engine.attack(Direction.LEFT);
						} catch (NotEnoughResourcesException  e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(this," not enough resources");
						}
				    	 catch (ChampionDisarmedException e1) 
					    	{
								JOptionPane.showMessageDialog(this,"your champion is disarmed");
							}
				    	 catch(InvalidTargetException e1)
					    	{JOptionPane.showMessageDialog(this,"invalid target");}
				    	 
				    	 
				    	 
				    	 ThirdView=new ThirdView();
				    	 
				    	 ThirdView.disabledirectionss();
	                        
						  //ThirdView.update(engine);
				    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
						ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
						ThirdView.setCurrinfo(engine.getCurrentChampion());

							for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								{
									ThirdView.getGamebuttons()[i].addActionListener(this);
								}
							
							for(int i=0;i<ThirdView.getDirectionss().length;i++)
							{
								ThirdView.getDirectionss()[i].addActionListener(this);
							}
							for(int i=0;i<ThirdView.getDirections().length;i++)
							{
								ThirdView.getDirections()[i].addActionListener(this);
							}
							
							
							
							int realx=0;
					    	int realy=0;
						    
					    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								  {	  
									  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
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
											  ThirdView.setcover(i,j);
										  }
										  else if(engine.getBoard()[i][j] instanceof Champion)
										  {
											  Champion c=(Champion) engine.getBoard()[i][j];
											  //if(engine.getFirstPlayer().getTeam().contains(c))
											  {
												  ThirdView.setGridbuttons(i, j, c);
											  }
										  }
											  else if(engine.getBoard()[realx][realy]== null)
											  {
												  ThirdView.setnull(realx, realy);
											  }
									  
								    }
								  }
					    	//ThirdView.disabledirectionss();
				    	
				    	 
				     }
				     
				     
				     
				     
				     if(e.getSource()==ThirdView.getDirections()[0])
				    {
				    	
				    	try {
							engine.move(Direction.UP);
							
							
						} catch (NotEnoughResourcesException e1) 
				    	{
							JOptionPane.showMessageDialog(this,"cannot move not enough resources");
						}
				    	catch(UnallowedMovementException e1)
				    	{JOptionPane.showMessageDialog(this,"cannot move ,unallowed movement");}
				    	//ThirdView.update(engine);
					  //ThirdView.disabledirections();
				    	
				    	
				    	
				    	ThirdView=new ThirdView();
                        
						  //ThirdView.update(engine);
				    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
						ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
						ThirdView.setCurrinfo(engine.getCurrentChampion());

							for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								{
									ThirdView.getGamebuttons()[i].addActionListener(this);
								}
							
							for(int i=0;i<ThirdView.getDirections().length;i++)
							{
								ThirdView.getDirections()[i].addActionListener(this);
							}
							
							
							
							int realx=0;
					    	int realy=0;
						    
					    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								  {	  
									  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
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
											  ThirdView.setcover(i,j);
										  }
										  else if(engine.getBoard()[i][j] instanceof Champion)
										  {
											  Champion c=(Champion) engine.getBoard()[i][j];
											  //if(engine.getFirstPlayer().getTeam().contains(c))
											  {
												  ThirdView.setGridbuttons(i, j, c);
											  }
										  }
											  else if(engine.getBoard()[realx][realy]== null)
											  {
												  ThirdView.setnull(realx, realy);
											  }
									  
								    }
								  }
				    	
				    	
				    	
				    	
				    	

				    }
				    else if(e.getSource()==ThirdView.getDirections()[1])
				    {
				    	try {
							engine.move(Direction.DOWN);
							
						} catch (NotEnoughResourcesException e1) 
				    	{
							JOptionPane.showMessageDialog(this,"cannot move not enough resources");
						}
				    	catch(UnallowedMovementException e1)
				    	{JOptionPane.showMessageDialog(this,"cannot move ,unallowed movement");}
				    	//ThirdView.update(engine);
					  //ThirdView.disabledirections();
				    	
				    	
				    	
				    	
				    	
				    	
				    	ThirdView=new ThirdView();
                        
				    	
				    	ThirdView.disabledirections();
				    	
				    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
						ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
						ThirdView.setCurrinfo(engine.getCurrentChampion());

						  //ThirdView.update(engine);
						  

							for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								{
									ThirdView.getGamebuttons()[i].addActionListener(this);
								}
							
							for(int i=0;i<ThirdView.getDirections().length;i++)
							{
								ThirdView.getDirections()[i].addActionListener(this);
							}
							
							
							
							int realx=0;
					    	int realy=0;
						    
					    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								  {	  
									  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
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
											  ThirdView.setcover(i,j);
										  }
										  else if(engine.getBoard()[i][j] instanceof Champion)
										  {
											  Champion c=(Champion) engine.getBoard()[i][j];
											  //if(engine.getFirstPlayer().getTeam().contains(c))
											  {
												  ThirdView.setGridbuttons(i, j, c);
											  }
										  }
											  else if(engine.getBoard()[realx][realy]== null)
											  {
												  ThirdView.setnull(realx, realy);
											  }
									  
								    }
								  }
				    	
				    	
				    	
				    	
				    	
				    	
				    }
				    
				    else if(e.getSource()==ThirdView.getDirections()[2])
				    {
				    	try {
							engine.move(Direction.LEFT);
							
						} catch (NotEnoughResourcesException e1) 
				    	{
							JOptionPane.showMessageDialog(this,"cannot move not enough resources");
						}
				    	catch(UnallowedMovementException e1)
				    	{JOptionPane.showMessageDialog(this,"cannot move ,unallowed movement");}
				    	//ThirdView.update(engine);
				    	//ThirdView.disabledirections();
				    	
				    	
				    	
				    	ThirdView=new ThirdView();
                        
				    	
				    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
						ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
						ThirdView.setCurrinfo(engine.getCurrentChampion());

						  //ThirdView.update(engine);
						  

							for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								{
									ThirdView.getGamebuttons()[i].addActionListener(this);
								}
							
							for(int i=0;i<ThirdView.getDirections().length;i++)
							{
								ThirdView.getDirections()[i].addActionListener(this);
							}
							
							
							
							int realx=0;
					    	int realy=0;
						    
					    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								  {	  
									  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
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
											  ThirdView.setcover(i,j);
										  }
										  else if(engine.getBoard()[i][j] instanceof Champion)
										  {
											  Champion c=(Champion) engine.getBoard()[i][j];
											  //if(engine.getFirstPlayer().getTeam().contains(c))
											  {
												  ThirdView.setGridbuttons(i, j, c);
											  }
										  }
											  else if(engine.getBoard()[realx][realy]== null)
											  {
												  ThirdView.setnull(realx, realy);
											  }
									  
								    }
								  }
				    	
				    }
				    
				    else if(e.getSource()==ThirdView.getDirections()[3])
				    {
				    	try {
							engine.move(Direction.RIGHT);
							
						} catch (NotEnoughResourcesException e1) 
				    	{
							JOptionPane.showMessageDialog(this,"cannot move not enough resources");
						}
				    	catch(UnallowedMovementException e1)
				    	{JOptionPane.showMessageDialog(this,"cannot move ,unallowed movement");}
				    	
				    	//ThirdView.update(engine);
				   //ThirdView.disabledirections();
				    	
				    	
				    	
				    	ThirdView=new ThirdView();
                        
				    	
				    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
						ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
						ThirdView.setCurrinfo(engine.getCurrentChampion());

						  //ThirdView.update(engine);
						  

							for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								{
									ThirdView.getGamebuttons()[i].addActionListener(this);
								}
							
							for(int i=0;i<ThirdView.getDirections().length;i++)
							{
								ThirdView.getDirections()[i].addActionListener(this);
							}
							
							
							
							int realx=0;
					    	int realy=0;
						    
					    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
								  {	  
									  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
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
											  ThirdView.setcover(i,j);
										  }
										  else if(engine.getBoard()[i][j] instanceof Champion)
										  {
											  Champion c=(Champion) engine.getBoard()[i][j];
											  //if(engine.getFirstPlayer().getTeam().contains(c))
											  {
												  ThirdView.setGridbuttons(i, j, c);
											  }
										  }
											  else if(engine.getBoard()[realx][realy]== null)
											  {
												  ThirdView.setnull(realx, realy);
											  }
									  
								    }
								  }
				    	
			}

//				    }
//				    int realx=0;
//			    	int realy=0;
//				    
//			    	for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//						  {	  
//							  for(int j=0;j<ThirdView.getGamebuttons().length;j++)
//						    {
//								  if(i==4) realx=0;
//								  else if(i==3) realx=1;
//								  else if(i==2) realx=2;
//								  else if(i==1) realx=3;
//								  else if(i==0) realx=4;
//								  
//								  if(j==4) realy=0;
//								  else if(j==3) realy=1;
//								  else if(j==2) realy=2;
//								  else if(j==1) realy=3;
//								  else if(j==0) realy=4;
//								  
//								  if(engine.getBoard()[i][j] instanceof Cover)
//								  {
//									  ThirdView.setcover();
//								  }
//								  else if(engine.getBoard()[i][j] instanceof Champion)
//								  {
//									  Champion c=(Champion) engine.getBoard()[i][j];
//									  //if(engine.getFirstPlayer().getTeam().contains(c))
//									  {
//										  ThirdView.setGridbuttons(i, j, c);
//									  }
//								  }
//									  else if(engine.getBoard()[i][j]== null)
//									  {
//										  ThirdView.setnull(i, j);
//									  }
//							  
//						    }
//						  }
			    	
//			    	ThirdView.setFteaminfo(FirstView.getAreaOne().getText(), engine.getFirstPlayer().getTeam());
//					ThirdView.setSteaminfo(FirstView.getAreaTwo().getText(), engine.getSecondPlayer().getTeam());
//					ThirdView.setCurrinfo(engine.getCurrentChampion());
			    	
//					for(int i=0;engine.getTurnOrder()!=null&&i<engine.getTurnOrder().size();i++)
//			    	{
//			    		Champion c=(Champion) engine.getTurnOrder().peekMin();
//			    		ThirdView.setTurnorder(c);
//			    		engine.getTurnOrder().remove();
//			    		if(engine.getTurnOrder()==null)
//			    			//JOptionPane.showInputDialog(this, e.getMessage());
//			    		JOptionPane.showMessageDialog(this,"the winner");
//			    	}
			    	
			    	
	              
	              
	              
				    
				    
	}
//					  else if(e.getSource()==SecondView.getButtons()[13]&&engine.getSecondPlayer().getTeam().size()<3)
//					  {
//						  SecondView.getButtons()[13].setEnabled(false);
//						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(13));
//						
//					  }
//					  else if(e.getSource()==SecondView.getButtons()[14]&&engine.getSecondPlayer().getTeam().size()<3)
//					  {
//						  SecondView.getButtons()[14].setEnabled(false);
//						  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(14));
//						
//					  }
		 
				   
						//ThirdView=new ThirdView();

					/*for(int i=0;i<5;i++)
					{
						for(int j=0;j<5;j++)
						{
							ThirdView.getGridbuttons()[i][j].addActionListener(this);
						}
					}*/
				    
//				}
				 
				//if(engine.getSecondPlayer().getTeam().size()==3)
				 
					//SecondView.setVisible(false);
					//engine.getSecondPlayer().setLeader(engine.getSecondPlayer().getTeam().get(0));
					//flag2=SecondView.flag();
					//ThirdView.setVisible(true);
					
//					ThirdView.setGridbuttons(0, 1, engine.getFirstPlayer().getTeam().get(1));
//					ThirdView.setGridbuttons(0, 2, engine.getFirstPlayer().getTeam().get(0));
//					ThirdView.setGridbuttons(0, 3, engine.getFirstPlayer().getTeam().get(2));
//					
//					ThirdView.setGridbuttons(4, 1, engine.getSecondPlayer().getTeam().get(1));
//					ThirdView.setGridbuttons(4, 2, engine.getSecondPlayer().getTeam().get(0));
//					ThirdView.setGridbuttons(4, 3, engine.getSecondPlayer().getTeam().get(2));
//					
//					ThirdView.setcover();ThirdView.setcover();ThirdView.setcover();
//					ThirdView.setcover();ThirdView.setcover();
//					
//					for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//					{
//						ThirdView.getGamebuttons()[i].addActionListener(this);
//					}
					
					
					
//					engine.placeChampions();
//					engine.placeCovers();
					
				

//					if(e.getSource()==ThirdView.getGamebuttons()[0])
//					{
//						ThirdView.enabledirection();
//					}
				
					
					
	

	
	public static ArrayList<Champion> avachamp()
	{
		return Game.getAvailableChampions();
	}
	public void update ()
	{
	    int realx=0;
    	int realy=0;
	    
    	for(int i=0;i<ThirdView.getGridbuttons().length;i++)
			  {	  
				  for(int j=0;j<ThirdView.getGridbuttons().length;j++)
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
						  ThirdView.setcover(i,j);
					  }
					  else if(engine.getBoard()[i][j] instanceof Champion)
					  {
						  Champion c=(Champion) engine.getBoard()[i][j];
						  //if(engine.getFirstPlayer().getTeam().contains(c))
						  {
							  ThirdView.setGridbuttons(i, j, c);
						  }
					  }
						  else if(engine.getBoard()[i][j]== null)
						  {
							  ThirdView.setnull(i, j);
						  }
				  
			    }
				  }
	}
	
	
//	public  static Object[][] getboard()
//	{
//		Object[][] x=engine.getBoard();
//		return engine.getBoard();
//	}
	
//	public static ArrayList<Champion> turn()
//	{
//		engine.getTurnOrder().peekMin();
//		return Game.getAvailableChampions();
//	}
	
	
	
	public Game getEngine() {
		return engine;
	}
	public void setEngine(Game engine) {
		this.engine = engine;
	}
	public FirstView getFirstView() {
		return FirstView;
	}
	public SecondView getSecondView() {
		return SecondView;
	}
	
	public ThirdView getThirdView() {
		return ThirdView;
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if( e.getClickCount()==2)
		{
			SecondView.setSec(SecondView.getSec());
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == 38)
		{
			//SecondView.setSec(SecondView.getSec());
			//SecondView.getSec().setVisible(true);
			SecondView.getButtons()[1].setEnabled(false);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	}

	
	
	
// System.out.println(x);
//int x=0;
//if(engine.getFirstPlayer().getTeam().size()==3 && x==0) //engine.getSecondPlayer().getTeam().size()==0)
//{
//	  engine.getFirstPlayer().setLeader(engine.getFirstPlayer().getTeam().get(0));
//	  //SecondView.getSec().setVisible(true);
//	  //String x=FirstView.getAreaTwo().getText()+ " "+"choose your players";
//     // JOptionPane.showMessageDialog(SecondView,x);
//      //int x = JOptionPane.showConfirmDialog(SecondView, FirstView.getAreaTwo().getText()+ " "+"choose your players");
//      
//      //if(x==0)
//      {
//      	//SecondView.setTitle("second player");
//      	
//      }
//      SecondView.setSec(SecondView.getSec());
//      x++;
//
//}
//if(e.getSource()==SecondView.getSec() && x==1)
//{
//	  SecondView.setTitle("second player");
//	  SecondView.setSecc(SecondView.getSec());
//	 // secondtry=new Secondtry();
//
//}

//boolean flag=false;

//if(engine.getFirstPlayer().getTeam().size()==3)
//{
//	SecondView.setVisible(false);
//	engine.getFirstPlayer().setLeader(engine.getFirstPlayer().getTeam().get(0));
//  //flag=SecondView.flag();
//  SecondView.setTitle("second player");
//  //SecondView.setVisible(true);
//









	
	
    //Second2=new Second2();
				//String x="choose your second leader";
		//JOptionPane.showMessageDialog(SecondView,x); 
				
				////// boolean flag2=false;
//	if(flag)
//	{
//		SecondView.setTitle("second player");
//		//String x="choose your second leader";
//     //JOptionPane.showMessageDialog(SecondView,x);
//		SecondView.setVisible(true);
//	}	
	
	
	
	
	
	
	
//	 boolean flag2=false;
//		if(engine.getSecondPlayer().getTeam().size()==3)
//		{ SecondView.setVisible(false);
//		  flag2=SecondView.flag();
//		}
//	
		
				  
				  
		
//		System.out.println(engine.getFirstPlayer().getTeam()+"      "+"\n"+"\n");
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("dtrfyvghbjnmkl"+engine.getSecondPlayer().getTeam());
//		
		
//		if(flag2)
//		{
//			try 
//			{
//				ThirdView=new ThirdView();
//				/*for(int i=0;i<5;i++)
//				{
//					for(int j=0;j<5;j++)
//					{
//						ThirdView.getGridbuttons()[i][j].addActionListener(this);
//					}
//				}*/
//			}    
//			catch (IOException e1) 
//			{
//				e1.printStackTrace();
//			}
//			
//			engine.placeChampions();
//			engine.placeCovers();
//			
//		
//			ThirdView.setGridbuttons(0, 1, engine.getFirstPlayer().getTeam().get(1));
//			ThirdView.setGridbuttons(0, 2, engine.getFirstPlayer().getTeam().get(0));
//			ThirdView.setGridbuttons(0, 3, engine.getFirstPlayer().getTeam().get(2));
//			
//			ThirdView.setGridbuttons(4, 1, engine.getSecondPlayer().getTeam().get(1));
//			ThirdView.setGridbuttons(4, 2, engine.getSecondPlayer().getTeam().get(0));
//			ThirdView.setGridbuttons(4, 3, engine.getSecondPlayer().getTeam().get(2));
//			
//			ThirdView.setcover();ThirdView.setcover();ThirdView.setcover();
//			ThirdView.setcover();ThirdView.setcover();
//			
//			/*for(int i=0;i<ThirdView.getGamebuttons().length;i++)
//			{
//				ThirdView.getGamebuttons()[i].addActionListener(this);
//			}*/
//			
//		}
//			if(e.getSource()==ThirdView.getGamebuttons()[0])
//			{
//				ThirdView.enabledirection();
//			}
//			
//			
//			
//			
//			
      
	
	
	
	
	
	





///////////////////for(int i=0;i<5;i++)
/*{
for(int j=0;j<5;j++)
{
	ThirdView.getGridbuttons()[i][j].addActionListener(this);
}
}
/*if(e.getSource()==ThirdView.getGridbuttons()[0][1])
{
//engine.getFirstPlayer().getTeam()[0];
ThirdView.getGridbuttons()[0][1]=ThirdView.fteam();
}*/
//SecondView.
//SecondView.setVisible(true);
//SecondView.getSleader().setVisible(true);




//
//
//


//ThirdView.setGridbuttons(4, 1, engine.getFirstPlayer().getTeam().get(0));
//ThirdView.setGridbuttons(4, 2, engine.getFirstPlayer().getTeam().get(1));
//ThirdView.setGridbuttons(4, 3, engine.getFirstPlayer().getTeam().get(2));
//
//ThirdView.setGridbuttons(0, 1, engine.getSecondPlayer().getTeam().get(0));
//ThirdView.setGridbuttons(0, 2, engine.getSecondPlayer().getTeam().get(1));
//ThirdView.setGridbuttons(0, 3, engine.getSecondPlayer().getTeam().get(2));

//ThirdView.setcover();ThirdView.setcover();ThirdView.setcover();
//ThirdView.setcover();ThirdView.setcover();





		//System.out.println();System.out.println();System.out.println();
		//System.out.println(engine.getSecondPlayer().getTeam());
		//System.out.println(engine.getFirstPlayer().getTeam().get(1).getName());
		//System.out.println(engine.getFirstPlayer().getTeam().get(2).getName());
		
				  
				  //SecondView.getButtons().addActionListener(this);
//				  SecondView.getButton0().addActionListener(this);
//					SecondView.getButton1().addActionListener(this);
//					SecondView.getButton2().addActionListener(this);
//					SecondView.getButton3().addActionListener(this);
//					SecondView.getButton4().addActionListener(this);
//					SecondView.getButton5().addActionListener(this);
//					SecondView.getButton6().addActionListener(this);
//					SecondView.getButton7().addActionListener(this);
//					SecondView.getButton8().addActionListener(this);
//					SecondView.getButton9().addActionListener(this);
//					SecondView.getButton10().addActionListener(this);
//					SecondView.getButton11().addActionListener(this);
//					SecondView.getButton12().addActionListener(this);
//					SecondView.getButton13().addActionListener(this);
//					SecondView.getButton14().addActionListener(this);
				
				/*
				//SecondView.getButton6().addActionListener(this);
				//SecondView.getButton7().addActionListener(this);
				//SecondView.getButton8().addActionListener(this);
				//SecondView.getButton9().addActionListener(this);
				//SecondView.getButton10().addActionListener(this);
				//SecondView.getButton11().addActionListener(this);
				
				/*d.getButton1();
				if(e.getSource()==d.getButton1())
				{
					d.getButton1().setVisible(false);
				}
				*/	
				
				//Second1=new Second1();
				//ThirdView=new ThirdView();

		
//		for(int i=0;i<3;i++)
//		 { 
//		if(i==0)
//			
//		{
//			if(e.getSource() ==SecondView.getButton0())
//		{
//			SecondView.getButton0().setVisible(false);
//			SecondView.getArea0().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(0));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//			
//		}
//		else if(e.getSource() ==SecondView.getButton1())
//		{
//			SecondView.getButton1().setVisible(false);
//			SecondView.getArea1().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(1));
//			SecondView.setB1(SecondView.getButton1().getText());
//			SecondView.getB1().setVisible(true);
//			
//		}
//		else if(e.getSource() ==SecondView.getButton2())
//		{
//			SecondView.getButton2().setVisible(false);
//			SecondView.getArea2().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(2));
//			SecondView.setB1(SecondView.getButton2().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton3())
//		{
//			SecondView.getButton3().setVisible(false);
//			SecondView.getArea3().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(3));
//			SecondView.setB1(SecondView.getButton3().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton4())
//		{
//			SecondView.getButton4().setVisible(false);
//			SecondView.getArea4().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(4));
//			SecondView.setB1(SecondView.getButton4().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton5())
//		{
//			SecondView.getButton5().setVisible(false);
//			SecondView.getArea5().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(5));
//			SecondView.setB1(SecondView.getButton5().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton6())
//		{
//			SecondView.getButton6().setVisible(false);
//			SecondView.getArea6().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(6));
//			SecondView.setB1(SecondView.getButton6().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton7())
//		{
//			SecondView.getButton7().setVisible(false);
//			SecondView.getArea7().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(7));
//			SecondView.setB1(SecondView.getButton7().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton8())
//		{
//			SecondView.getButton8().setVisible(false);
//			SecondView.getArea8().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(8));
//			SecondView.setB1(SecondView.getButton8().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton9())
//		{
//			SecondView.getButton9().setVisible(false);
//			SecondView.getArea9().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(9));
//			SecondView.setB1(SecondView.getButton9().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton10())
//		{
//			SecondView.getButton10().setVisible(false);
//			SecondView.getArea10().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(10));
//			SecondView.setB1(SecondView.getButton10().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton11())
//		{
//			SecondView.getButton11().setVisible(false);
//			SecondView.getArea11().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(11));
//			SecondView.setB1(SecondView.getButton11().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton12())
//		{
//			SecondView.getButton12().setVisible(false);
//			SecondView.getArea12().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(12));
//			SecondView.setB1(SecondView.getButton12().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton13())
//		{
//			SecondView.getButton13().setVisible(false);
//			SecondView.getArea13().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(13));
//			SecondView.setB1(SecondView.getButton13().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton14())
//		{
//			SecondView.getButton14().setVisible(false);
//			SecondView.getArea14().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(14));
//			SecondView.setB1(SecondView.getButton14().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		 }
//		
//		
//		if(i==1)
//		
//		{
//			if(e.getSource() ==SecondView.getButton0())
//		{
//			SecondView.getButton0().setVisible(false);
//			SecondView.getArea0().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(0));
//			SecondView.setB2(SecondView.getButton0().getText());
//			SecondView.getB2().setVisible(true);
//			
//		}
//		else if(e.getSource() ==SecondView.getButton1())
//		{
//			SecondView.getButton1().setVisible(false);
//			SecondView.getArea1().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(1));
//			SecondView.setB2(SecondView.getButton1().getText());
//			SecondView.getB2().setVisible(true);
//			
//		}
//		else if(e.getSource() ==SecondView.getButton2())
//		{
//			SecondView.getButton2().setVisible(false);
//			SecondView.getArea2().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(2));
//			SecondView.setB2(SecondView.getButton2().getText());
//			SecondView.getB2().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton3())
//		{
//			SecondView.getButton3().setVisible(false);
//			SecondView.getArea3().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(3));
//			SecondView.setB2(SecondView.getButton3().getText());
//			SecondView.getB2().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton4())
//		{
//			SecondView.getButton4().setVisible(false);
//			SecondView.getArea4().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(4));
//			SecondView.setB2(SecondView.getButton4().getText());
//			SecondView.getB2().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton5())
//		{
//			SecondView.getButton5().setVisible(false);
//			SecondView.getArea5().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(5));
//			SecondView.setB1(SecondView.getButton5().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton6())
//		{
//			SecondView.getButton6().setVisible(false);
//			SecondView.getArea6().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(6));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton7())
//		{
//			SecondView.getButton7().setVisible(false);
//			SecondView.getArea7().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(7));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton8())
//		{
//			SecondView.getButton8().setVisible(false);
//			SecondView.getArea8().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(8));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton9())
//		{
//			SecondView.getButton9().setVisible(false);
//			SecondView.getArea9().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(9));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton10())
//		{
//			SecondView.getButton10().setVisible(false);
//			SecondView.getArea10().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(10));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton11())
//		{
//			SecondView.getButton11().setVisible(false);
//			SecondView.getArea11().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(11));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton12())
//		{
//			SecondView.getButton12().setVisible(false);
//			SecondView.getArea12().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(12));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton13())
//		{
//			SecondView.getButton13().setVisible(false);
//			SecondView.getArea13().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(13));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton14())
//		{
//			SecondView.getButton14().setVisible(false);
//			SecondView.getArea14().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(14));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		}
//		
//		
//		if(i==2)
//		
//		
//		{
//			if(e.getSource() ==SecondView.getButton0())
//		{
//			SecondView.getButton0().setVisible(false);
//			SecondView.getArea0().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(0));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//			
//		}
//		else if(e.getSource() ==SecondView.getButton1())
//		{
//			SecondView.getButton1().setVisible(false);
//			SecondView.getArea1().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(1));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//			
//		}
//		else if(e.getSource() ==SecondView.getButton2())
//		{
//			SecondView.getButton2().setVisible(false);
//			SecondView.getArea2().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(2));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton3())
//		{
//			SecondView.getButton3().setVisible(false);
//			SecondView.getArea3().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(3));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton4())
//		{
//			SecondView.getButton4().setVisible(false);
//			SecondView.getArea4().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(4));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton5())
//		{
//			SecondView.getButton5().setVisible(false);
//			SecondView.getArea5().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(5));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton6())
//		{
//			SecondView.getButton6().setVisible(false);
//			SecondView.getArea6().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(6));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton7())
//		{
//			SecondView.getButton7().setVisible(false);
//			SecondView.getArea7().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(7));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton8())
//		{
//			SecondView.getButton8().setVisible(false);
//			SecondView.getArea8().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(8));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton9())
//		{
//			SecondView.getButton9().setVisible(false);
//			SecondView.getArea9().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(9));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton10())
//		{
//			SecondView.getButton10().setVisible(false);
//			SecondView.getArea10().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(10));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton11())
//		{
//			SecondView.getButton11().setVisible(false);
//			SecondView.getArea11().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(11));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton12())
//		{
//			SecondView.getButton12().setVisible(false);
//			SecondView.getArea12().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(12));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton13())
//		{
//			SecondView.getButton13().setVisible(false);
//			SecondView.getArea13().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(13));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		else if(e.getSource() ==SecondView.getButton14())
//		{
//			SecondView.getButton14().setVisible(false);
//			SecondView.getArea14().setVisible(false);
//			engine.getFirstPlayer().getTeam().add(Game.getAvailableChampions().get(14));
//			SecondView.setB1(SecondView.getButton0().getText());
//			SecondView.getB1().setVisible(true);
//		}
//		}
//			
//			
//			
//		 }
//	}
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}


	
	/*public JButton buttons(int x,int y)
	{
		
	}*/









//if(e.getSource()==SecondView.getButtons()[0] && engine.getSecondPlayer().getTeam().size()<3)
//{
//	  //SecondView.getButtons()[0].setVisible(false);
//	  SecondView.getButtons()[0].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(0));
// }
//else if(e.getSource()==SecondView.getButtons()[1] && engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[1].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(1));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[2] &&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[2].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(2));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[3]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[3].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(3));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[4]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[4].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(4));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[5]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[5].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(5));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[6]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[6].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(6));
//	
//}
//
//else if(e.getSource()==SecondView.getButtons()[7]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[7].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(7));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[8]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[8].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(8));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[9]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[9].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(9));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[10]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[10].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(10));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[11]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[11].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(11));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[12]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[12].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(12));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[13]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[13].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(13));
//	
//}
//else if(e.getSource()==SecondView.getButtons()[14]&&engine.getSecondPlayer().getTeam().size()<3)
//{
//	  SecondView.getButtons()[14].setEnabled(false);
//	  engine.getSecondPlayer().getTeam().add(Game.getAvailableChampions().get(14));
//	
//}


