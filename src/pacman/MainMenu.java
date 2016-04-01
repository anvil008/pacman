package pacman;

import java.awt.Color;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Extras.Menu;
import Functions.IReceiveDataFunction;
import Server.ServerGame;

public class MainMenu extends JPanel {

	private BufferedImage img;

	// variables for and font of the title and menu options
	private static final Font fontOfTitle = new Font("Century Gothic",
			Font.PLAIN, 47);
	private static final Font fontOfOptions = new Font("Century Gothic",
			Font.PLAIN, 27);

	// name of the game
	private static final String[] mainMenuStrings = { "startGame Easy","startGame Medium",
		                                              "startGame Hard", "StartGame 1v1","startGame Network", "quitGame", "Extras","Sound Off" };
	private static final String nameOfGame = "PacMan";

	// this is a variable for the current main menu option chosen
	private int menuStringChosen = 0;

	//variable for the game frame
	private GameFrame frame;

	// Constructor passes through the game frame and the source of the
	// Background image
	public MainMenu(GameFrame frame, String sourceOfImage) {
		t1.start();
		//set the game frame to the menu frame
		this.frame = frame;

		// load the Background image to the frame
		this.loadImage(sourceOfImage);

		// add a keyListener to the frame
		frame.addKeyListener(new KeyAdapter() {

			// when the UP arrow key is pressed go up
			// when the DOWN arrow key is pressed go down
			public void keyPressed(KeyEvent event) {

				if (event.getKeyCode() == KeyEvent.VK_UP) {

					// Idea referenced from youtube video
					menuStringChosen--;
					if (menuStringChosen == -1) {
						menuStringChosen = mainMenuStrings.length - 1;
					}
				}

				if (event.getKeyCode() == KeyEvent.VK_DOWN) {

					// Idea referenced from youtube video
					menuStringChosen++;
					if (menuStringChosen == mainMenuStrings.length) {
						menuStringChosen = 0;
					}
				}

				// when ENTER is pressed, will run the optionSelect function and
				// execute the option
				if (event.getKeyCode() == KeyEvent.VK_ENTER) {
					selectMenuString(menuStringChosen);
				}

			}

		});

	}// end of Constructor

	// function that's called when ENTER key is pressed
	public void selectMenuString(int menuStringChosen) {

		// start game
		// when the first option is selected, it will run the game on easy difficulty
		if (menuStringChosen == 0) {

			// remove the old Jpanel(the MainMenu) and invalidate the frame
			frame.getContentPane().removeAll();
			frame.invalidate();

			// get the frame ContentPane and add the GameKeys to the frame
			// After that revalidate and make it visible
			frame.getContentPane().add(new GameBoardEasy(frame,"/map/pacman.png","/map/pacman2.png",
					"/map/ghost1.png","/map/ghost2.png", "/map/ghost3.png",
					"/map/coin.png", "/map/mapwall.png","/map/item.png"));
			frame.revalidate();
			frame.setVisible(true);
		}


		// when the second option is selected, it will run the game on medium difficulty
		else if (menuStringChosen == 1) {

			// remove the old Jpanel(the MainMenu) and invalidate the frame
						frame.getContentPane().removeAll();
						frame.invalidate();

						// get the frame ContentPane and add the GameKeys to the frame
						// After that revalidate and make it visible
						frame.getContentPane().add(new GameBoardMedium(frame,"/map/pacman.png","/map/pacman2.png",
								"/map/ghost1.png","/map/ghost2.png", "/map/ghost3.png",
								"/map/ghost4.png","/map/coin.png", "/map/mapwall.png", "/map/item.png"));
						frame.revalidate();
						frame.setVisible(true);



		}
		// when the third option is selected, it will run the game on hard difficulty
		else if (menuStringChosen == 2) {

			// remove the old Jpanel(the MainMenu) and invalidate the frame
			frame.getContentPane().removeAll();
			frame.invalidate();

			// get the frame ContentPane and add the GameKeys to the frame
			// After that revalidate and make it visible
			frame.getContentPane().add(new GameBoardHard(frame,"/map/pacman.png","/map/pacman2.png",
					"/map/ghost1.png","/map/ghost2.png", "/map/ghost3.png","/map/ghost4.png","/map/ghost5.png","/map/coin.png", "/map/mapwall.png"));
			frame.revalidate();
			frame.setVisible(true);


		}
		else if (menuStringChosen == 3) {

			// remove the old Jpanel(the MainMenu) and invalidate the frame
						frame.getContentPane().removeAll();
						frame.invalidate();

						// get the frame ContentPane and add the GameKeys to the frame
						// After that revalidate and make it visible
						frame.getContentPane().add(new GameBoard1v1(frame,"/map/pacman.png",
								"/map/ghost1.png","/map/coin.png", "/map/mapwall.png"));
						frame.revalidate();
						frame.setVisible(true);


		}



		else if (menuStringChosen == 4) {

			if (ServerGame.getInstance().getPlayer() != null) {
				// remove the old Jpanel(the MainMenu) and invalidate the frame
				frame.getContentPane().removeAll();
				frame.invalidate();

				// get the frame ContentPane and add the GameKeys to the frame
				// After that revalidate and make it visible
				frame.getContentPane().add(new GameBoardNetwork(frame,"/map/pacman.png","/map/pacman2.png",
						"/map/ghost1.png","/map/ghost2.png", "/map/ghost3.png","/map/coin.png", "/map/mapwall.png"));
				frame.revalidate();
				frame.setVisible(true);
			}
			else
			{
	            //JOptionPane.showMessageDialog(null, "PLAYER 2 DO NOT CONNECT");
			}


		}

		// when the current choice is on quit, when selected, shall quit the
		// window
		else if (menuStringChosen == 5) {

			System.exit(0);
		}
		// option 6 will display new menu for the extras
		else if (menuStringChosen == 6) {

			Extras.Menu m = new Menu();
			m.setVisible(true);
			// when option 7 is selected, this will stop the music being played
		}else if (menuStringChosen == 7) {
			t1.stop();
		}
	}

	// method for loading an image
	public void loadImage(String sourceOfImage) {
		try {
			img = ImageIO.read(getClass().getResourceAsStream(sourceOfImage));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//method draws objects and images on the screen
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		// assign graphics to a Graphics2D object
		Graphics2D graphics2D = (Graphics2D) graphics;

		// draw the background image
		graphics2D
				.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);

		// used to repaint the menu options whenever the user has chosen a
		// different option
		repaint();

		// set the color and font of the Title
		graphics2D.setColor(Color.RED);
		graphics2D.setFont(fontOfTitle);

		// draw the Title of the Game
		graphics2D.drawString(nameOfGame, 280, 45);

		// set the font of the Menu Options
		graphics2D.setFont(fontOfOptions);

		// Idea referenced from youtube video
		for (int i = 0; i < mainMenuStrings.length; i++) {
			if (i == menuStringChosen) {
				graphics2D.setColor(Color.BLUE);
			} else {
				graphics2D.setColor(Color.YELLOW);
			}
			graphics2D.drawString(mainMenuStrings[i], 270, 85 + i * 37);
		}

	}// End of paintComponent

	// creates new thread for trying the mp3 backing music
	Thread t1 = new Thread(){
		public void run() {

			try {
				FileInputStream f = new FileInputStream("Resources/Pac-Man Theme (REMIX).mp3");
				Player p = new Player(f);
				p.play();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		};

}// End of class
