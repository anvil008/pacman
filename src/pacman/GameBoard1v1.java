package pacman;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


import ch.aplu.xboxcontroller.XboxController;
import ch.aplu.xboxcontroller.XboxControllerAdapter;



public class GameBoard1v1 extends JPanel implements ActionListener {

	//players
	private int pac1 = 1;


	//ghost
	private int ghostbot1 = 1;


	//walls
	private int pacwall = 1;

	//coins
	private int paccoins = 1;

	//font for the score
	private static final Font fontOfHud = new Font("Century Gothic",
			Font.PLAIN, 25);

	// set the score initially to 0
	private int pacman1score = 0;

	private int pacman1lives = 2;



	// boolean variables required for moving the pacman in different directions
	public boolean p1moveup = false;
	public boolean p1movedown = false;
	public boolean p1moveleft = false;
	public boolean p1moveright = false;

	// boolean variables required for moving second ghost player in different
	// directions

	public boolean ghostmoveup = false;
	public boolean ghostmovedown = false;
	public boolean ghostmoveleft = false;
	public boolean ghostmoveright = false;

	// gets pacman Images
	private BufferedImage pacman;

	// gets wall Images
	private BufferedImage walls;

	//gets ghost images
	private BufferedImage ghost1;

	//gets coin images
	private BufferedImage coin1;
	private BufferedImage coin2;
	private BufferedImage coin3;
	private BufferedImage coin4;
	private BufferedImage coin5;
	private BufferedImage coin6;
	private BufferedImage coin7;
	private BufferedImage coin8;
	private BufferedImage coin9;
	private BufferedImage coin10;
	private BufferedImage coin11;
	private BufferedImage coin12;
	private BufferedImage coin13;
	private BufferedImage coin14;
	private BufferedImage coin15;
	private BufferedImage coin16;
	private BufferedImage coin17;
	private BufferedImage coin18;
	private BufferedImage coin19;
	private BufferedImage coin20;

	private GameMap gamemap;


	// need the dimensions for the height n width of the pacman object
	public int pacwidth = 20;
	public int pacheight = 20;

	// need the dimensions for the height n width of the ghost1 image
	public int ghost1width = 20;
	public int ghost1height = 20;

	// need the dimensions for the height n width of the coin image
	public int coinheight = 20;
	public int coinwidth = 20;

	// need the dimensions for the height n width of the ghost1 image
	public int wallheight = 20;
	public int wallwidth = 20;


	// timer variable used for imporiving smoothnless of player movement
	private Timer timer;

	// timer for wall collision
	private Timer timer3;

	// boolean used to initialise when the game starts
	public boolean playing = true;
	public boolean notplaying = false;

	// maximum pixels that are displayed on our gamemap grid altogether
	public int Maximum_pixels_on_screen = 768;

	// got the basic idea of using these arrays to store the x and y co-ordinates online
			// however just used that basic initial idea and then changed & built on it,
			// with the majority of code being ours - this applies to all GameBoard classes
			// referenced link will be in the reports if you wish to view it
			// --------------------------------------------------------------------------------------------------

			// These two arrays store the x, y coordinates of all possible positions on
			// the board for pacman player 1
			public int playerx1[] = new int[Maximum_pixels_on_screen];
			public int playery1[] = new int[Maximum_pixels_on_screen];
		    //---------------------------------------------------------------------------------------------------


	// These two arrays store the x, y coordinates of all possible positions on
	// the board for ghost bot 1
	public int ghostx1[] = new int[Maximum_pixels_on_screen];
	public int ghosty1[] = new int[Maximum_pixels_on_screen];



	// These two arrays store the x, y coordinates of all possible positions on
		// the board for wall
		public int wallx1[] = new int[Maximum_pixels_on_screen];
		public int wally1[] = new int[Maximum_pixels_on_screen];

	// These two arrays store the x, y coordinates of all possible positions on
	// the board for all 20 coins
	public int coinx1[] = new int[Maximum_pixels_on_screen];
	public int coiny1[] = new int[Maximum_pixels_on_screen];
	public int coinx2[] = new int[Maximum_pixels_on_screen];
	public int coiny2[] = new int[Maximum_pixels_on_screen];
	public int coinx3[] = new int[Maximum_pixels_on_screen];
	public int coiny3[] = new int[Maximum_pixels_on_screen];
	public int coinx4[] = new int[Maximum_pixels_on_screen];
	public int coiny4[] = new int[Maximum_pixels_on_screen];
	public int coinx5[] = new int[Maximum_pixels_on_screen];
	public int coiny5[] = new int[Maximum_pixels_on_screen];
	public int coinx6[] = new int[Maximum_pixels_on_screen];
	public int coiny6[] = new int[Maximum_pixels_on_screen];
	public int coinx7[] = new int[Maximum_pixels_on_screen];
	public int coiny7[] = new int[Maximum_pixels_on_screen];
	public int coinx8[] = new int[Maximum_pixels_on_screen];
	public int coiny8[] = new int[Maximum_pixels_on_screen];
	public int coinx9[] = new int[Maximum_pixels_on_screen];
	public int coiny9[] = new int[Maximum_pixels_on_screen];
	public int coinx10[] = new int[Maximum_pixels_on_screen];
	public int coiny10[] = new int[Maximum_pixels_on_screen];
	public int coinx11[] = new int[Maximum_pixels_on_screen];
	public int coiny11[] = new int[Maximum_pixels_on_screen];
	public int coinx12[] = new int[Maximum_pixels_on_screen];
	public int coiny12[] = new int[Maximum_pixels_on_screen];
	public int coinx13[] = new int[Maximum_pixels_on_screen];
	public int coiny13[] = new int[Maximum_pixels_on_screen];
	public int coinx14[] = new int[Maximum_pixels_on_screen];
	public int coiny14[] = new int[Maximum_pixels_on_screen];
	public int coinx15[] = new int[Maximum_pixels_on_screen];
	public int coiny15[] = new int[Maximum_pixels_on_screen];
	public int coinx16[] = new int[Maximum_pixels_on_screen];
	public int coiny16[] = new int[Maximum_pixels_on_screen];
	public int coinx17[] = new int[Maximum_pixels_on_screen];
	public int coiny17[] = new int[Maximum_pixels_on_screen];
	public int coinx18[] = new int[Maximum_pixels_on_screen];
	public int coiny18[] = new int[Maximum_pixels_on_screen];
	public int coinx19[] = new int[Maximum_pixels_on_screen];
	public int coiny19[] = new int[Maximum_pixels_on_screen];
	public int coinx20[] = new int[Maximum_pixels_on_screen];
	public int coiny20[] = new int[Maximum_pixels_on_screen];


	// Creates Xbox Controller
	XboxController Controller = new XboxController();

	public void isConnected(boolean connected)
    {
      if (connected)
       System.out.println("Connected");
      else
        System.out.println("Not Connected");
    }

	// Constructor - passing in the game window and our background we will use
	// for the game
	public GameBoard1v1(GameFrame frame, // game window created in the GameStart
										// class
			String Pacman1Image, // passes in the String for pacman1 player
			String Ghost1Image,   // passes in the String for the first ghost bot
			String coinImage,
			String wallImage
	) {

		// method call loads the pacman and ghost images
		loadPacman(Pacman1Image);
		loadGhost1(Ghost1Image);


		loadCoins(coinImage);

		loadWall(wallImage);
		// creates the new map class when constructor is run, so gamemap can be
		// displayed
		gamemap = new GameMap();

		// this initialises and starts the game
		startGame();

		// timer used to set delay and timing of movement for player
		timer = new Timer(50, this);
		timer.start();

		timer3 = new Timer(0, this);
		timer3.start();

		// add in a keylistener so the object can move about
		// listens for keys, works out what they are doing
		frame.addKeyListener(new KeyAdapter() {
			// keypressed method - when a key is pressed, it gets the key
			// sets the current boolean to true when the corresponding key is
			// pressed
			public void keyPressed(KeyEvent event) {

				// when boolean is set to true, key is being pressed and object
				// is moving

				// when pressing upwards key, move up and set the boolean to
				// true

				// controls for player 1
				if (event.getKeyCode() == KeyEvent.VK_W) {

								p1moveup = true;
								p1movedown = false;
								p1moveleft = false;
								p1moveright = false;

			}


				// when pressing downwards key, move down and set boolean to
				// true
				if (event.getKeyCode() == KeyEvent.VK_S) {

					p1movedown = true;
					p1moveup = false;
					p1moveleft = false;
					p1moveright = false;

				}

				// when pressing right key, move right and set boolean to true
				if (event.getKeyCode() == KeyEvent.VK_A) {

					p1moveleft = true;
					p1moveright = false;
					p1moveup = false;
					p1movedown = false;

				}

				// when pressing left key, move left and set boolean to true
				if (event.getKeyCode() == KeyEvent.VK_D) {

					p1moveright = true;
					p1moveleft = false;
					p1moveup = false;
					p1movedown = false;
					}

                // ---------------------------------------------------------------------

				// Adds Xbox controll listener to the adapter to take commands
				if (!Controller.isConnected())
				      System.out.println("Xbox controller not connected");
				Controller.addXboxControllerListener(new XboxControllerAdapter() {

					public void dpad(int direction, boolean pressed) {
						if (direction == 0 && pressed) {
							p1moveup = true;
							p1movedown = false;
							p1moveleft = false;
							p1moveright = false;
						}

						if (direction == 2 && pressed) {
							p1moveright = true;
							p1moveleft = false;
							p1moveup = false;
							p1movedown = false;
						}

						if (direction == 4 && pressed) {
							p1movedown = true;
							p1moveup = false;
							p1moveleft = false;
							p1moveright = false;
						}

						if (direction == 6 && pressed) {
							p1moveleft = true;
							p1moveright = false;
							p1moveup = false;
							p1movedown = false;
						}

					}

				});

				// ---------------------------------------------------------------------

				// controls for pacman player 2:
				if (event.getKeyCode() == KeyEvent.VK_UP) {
					ghostmoveup = true;
					ghostmovedown = false;
					ghostmoveleft = false;
					ghostmoveright = false;

				}

				// when pressing downwards key, move down and set boolean to
				// true
				if (event.getKeyCode() == KeyEvent.VK_DOWN) {
					ghostmoveup = false;
					ghostmovedown = true;
					ghostmoveleft = false;
					ghostmoveright = false;
				}

				// when pressing right key, move right and set boolean to true
				if (event.getKeyCode() == KeyEvent.VK_LEFT) {
					ghostmoveup = false;
					ghostmovedown = false;
					ghostmoveleft = true;
					ghostmoveright = false;

				}

				// when pressing left key, move left and set boolean to true
				if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
					ghostmoveup = false;
					ghostmovedown = false;
					ghostmoveleft = false;
					ghostmoveright = true;
				}


			}

			// keyreleased method - when a key is released, boolean value goes
			// back to false and object does nothing
			public void keyReleased(KeyEvent event) {

				// when boolean is set to true, key is being pressed and object
				// is moving

				// when pressing upwards key, move up and set the boolean to
				// true
				if (event.getKeyCode() == KeyEvent.VK_W) {

					p1moveup = false;
					p1movedown = false;
					p1moveleft = false;
					p1moveright = false;

				}
				// when pressing downwards key, move down and set boolean to
				// true
				if (event.getKeyCode() == KeyEvent.VK_S) {

					p1movedown = false;
					p1moveup = false;
					p1moveleft = false;
					p1moveright = false;

				}

				// when pressing right key, move right and set boolean to true
				if (event.getKeyCode() == KeyEvent.VK_A) {

					p1moveleft = false;
					p1moveright = false;
					p1moveup = false;
					p1movedown = false;

				}

				// when pressing left key, move left and set boolean to true
				if (event.getKeyCode() == KeyEvent.VK_D) {

					p1moveright = false;
					p1moveleft = false;
					p1moveup = false;
					p1movedown = false;

				}

//				// -----------------------------------------------------------------------------

				// controls for pacman player 2:
				if (event.getKeyCode() == KeyEvent.VK_UP) {
					ghostmoveup = false;
					ghostmovedown = false;
					ghostmoveleft = false;
					ghostmoveright = false;
				}

				// when pressing downwards key, move down and set boolean to
				// true
				if (event.getKeyCode() == KeyEvent.VK_DOWN) {
					ghostmoveup = false;
					ghostmovedown = false;
					ghostmoveleft = false;
					ghostmoveright = false;
				}

				// when pressing right key, move right and set boolean to true
				if (event.getKeyCode() == KeyEvent.VK_LEFT) {
					ghostmoveup = false;
					ghostmovedown = false;
					ghostmoveleft = false;
					ghostmoveright = false;
				}

				// when pressing left key, move left and set boolean to true
				if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
					ghostmoveup = false;
					ghostmovedown = false;
					ghostmoveleft = false;
					ghostmoveright = false;
				}

			}

		});
	}

	// In the loadPacman() method we get the images for the game.
	// The ImageIcon class is used for displaying the PNG images.
	private void loadPacman(String Pacman1Image) {

		try {
			pacman = ImageIO
					.read(getClass().getResourceAsStream(Pacman1Image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void loadGhost1(String Ghost1Image) {

		// added second pacman player
		try {
			ghost1 = ImageIO.read(getClass().getResourceAsStream(
					Ghost1Image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void loadWall(String wallImage) {

		// added second pacman player
		try {
			walls = ImageIO.read(getClass().getResourceAsStream(
					wallImage));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadCoins(String coinImage) {

		// added second pacman player
		try {
			coin1 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin2 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin3 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin4 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin5 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin6 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin7 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin8 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin9 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin10 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin11 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin12 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin13 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin14 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin15 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin16 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin17 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin18 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin19 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
			coin20 = ImageIO.read(getClass().getResourceAsStream(
					coinImage));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	// In the startGame() method, we use a forloop to place the pacman player
	// onto the map
	public void startGame() {

		for (int i = 0; i < pac1; i++) {
			// place the pacman onto the screen at x and y co-ordinates in terms
			// of pixels
			playerx1[i] = 80;
			playery1[i] = 80;
		}


		for (int i = 0; i < ghostbot1; i++) {
			// place the ghost onto the screen at x and y co-ordinates in
			// terms
			// of pixels
			ghostx1[i] = 400;
			ghosty1[i] = 400;
		}



		for (int i = 0; i < pacwall; i++) {
			// place the ghost onto the screen at x and y co-ordinates in
			// terms
			// of pixels
			wallx1[i] = 80;
			wally1[i] = 60;
		}

		for (int i = 0; i < paccoins; i++) {
			// place the ghost onto the screen at x and y co-ordinates in
			// terms
			// of pixels
			coinx1[i] = 380;
			coiny1[i] = 40;

			coinx2[i] = 180;
			coiny2[i] = 80;

			coinx3[i] = 360;
			coiny3[i] = 100;

			coinx4[i] = 500;
			coiny4[i] = 240;

			coinx5[i] = 20;
			coiny5[i] = 160;

			coinx6[i] = 400;
			coiny6[i] = 220;

			coinx7[i] = 20;
			coiny7[i] = 300;

			coinx8[i] = 120;
			coiny8[i] = 440;

			coinx9[i] = 440;
			coiny9[i] = 400;

			coinx10[i] = 320;
			coiny10[i] = 500;

			coinx11[i] = 460;
			coiny11[i] = 520;

			coinx12[i] = 380;
			coiny12[i] = 460;

			coinx13[i] = 220;
			coiny13[i] = 440;

			coinx14[i] = 140;
			coiny14[i] = 20;

			coinx15[i] = 220;
			coiny15[i] = 240;

			coinx16[i] = 520;
			coiny16[i] = 120;

			coinx17[i] = 260;
			coiny17[i] = 240;

			coinx18[i] = 260;
			coiny18[i] = 260;

			coinx19[i] = 280;
			coiny19[i] = 240;

			coinx20[i] = 280;
			coiny20[i] = 260;


		}
	}

	// method to draw the score for the game
	public void pacScore(Graphics graphics) {
		// create a string
		String pac1score;

		//set color to white
		graphics.setColor(Color.WHITE);
		// set the font from variables
		graphics.setFont(fontOfHud);
		// display the String and the integer score
		pac1score = "P1Score: " + pacman1score;

		// draw and position the string at the bottom of the game window
		graphics.drawString(pac1score, 10, 585);


	}

	public void pacLives(Graphics graphics) {

		// create a string
				String pac1lives;

				//set color to white
				graphics.setColor(Color.WHITE);
				// set the font from variables
				graphics.setFont(fontOfHud);
				// display the String and the integer score
				pac1lives = "P1Lives: " + pacman1lives;

				// draw and position the string at the bottom of the game window
				graphics.drawString(pac1lives, 170, 585);


	}
	// GameOver string is displayed when pacman lives reach zero
	public void gameOver(Graphics graphics) {

		if (pacman1lives == 0) {
			String gameover;
			String winner;
			graphics.setColor(Color.RED);
			graphics.setFont(fontOfHud);
			gameover = "GameOver";
			winner = "Ghost Wins!";

			graphics.drawString(gameover, 360, 585);
			graphics.drawString(winner, 361, 620);
			// stops the game
			playing = false;
		}
		else if (pacman1score == 20) {
				String gameover;
				String winner;
				graphics.setColor(Color.RED);
				graphics.setFont(fontOfHud);
				gameover = "GameOver";
				winner = "Pacman Wins!";

				graphics.drawString(gameover, 360, 585);
				graphics.drawString(winner, 348, 620);
			// stops the game
			playing = false;
		}

	}



	// this method will move the pacman players in desired direction, using its
		// size and position in array
		// again, this idea we got from online and research, of moving the bots, using the same x and y arrays
		// but we just used the basic idea and majority of the code is ours - this applies to all GameBoard Classes
	public void pacmove() {

		// This line moves pacman up.
		if (p1moveup) {
			playery1[0] = playery1[0] - 20; // is the size of each pacman - so will move every
								// half tile


		for (int y = 0; y < 28; y++) {
			for (int x = 0; x < 28; x++) {

				if (gamemap.gameMap(x, y).equals("1")) {

					p1moveup = true;
					p1movedown = false;
					p1moveleft = false;
					p1moveright = false;


				} else if (gamemap.gameMap(x, y).equals("0")) {

					p1moveup = false;
					p1movedown = false;
					p1moveleft = false;
					p1moveright = false;


				}
			}
		}
		}

		// This line moves pacman down.
		if (p1movedown) {
			playery1[0] = playery1[0] + 20;
		}

		// This line moves pacman to the right.
		if (p1moveright) {
			playerx1[0] = playerx1[0] + 20;
		}

		// This line moves pacman to the left.
		if (p1moveleft) {
			playerx1[0] = playerx1[0] - 20;
		}

	}

	// the moveGhost method that will enable the ghost to move on its own
	// it will implement Graphics as it will not be controlled by the player, but my itself
	public void ghostMove() {

		if (ghostmoveup) {
			ghosty1[0] = ghosty1[0] - 20; // is the size of each ghost - so will move a
								// whole tile
		}

		// This line moves pacman down.
		if (ghostmovedown) {
			ghosty1[0] = ghosty1[0] + 20;
		}

		// This line moves pacman to the right.
		if (ghostmoveright) {
			ghostx1[0] = ghostx1[0] + 20;
		}

		// This line moves pacman to the left.
		if (ghostmoveleft) {
			ghostx1[0] = ghostx1[0] - 20;
		}
	 }



	// added a checkGhost method, so that when the pacman comes into contact with the ghost bot, it will
	//lose a life and reset back into its original position
	public void checkGhostCollision() {

		// collision for second ghost player
		if ((playerx1[0] == ghostx1[0]) &&  (playery1[0] == ghosty1[0])) {

			// p1moveright = true;

			for (int i = 0; i < pac1; i++) {
				// place the pacman onto the screen at x and y co-ordinates in
				// terms
				// of pixels
				playerx1[i] = 80;
				playery1[i] = 80;
				// pacman lives go down for player 1 everytime it comes into contact with a ghost bot
                pacman1lives = pacman1lives - 1;
    			ghostx1[i] = 400;
    			ghosty1[i] = 400;

			}
		}
	}

	// this goes through each tile and checks that when a tile is a wall, the players or ghosts cannot pass
		// through
	public void checkWallCollision() {


				if (((playerx1[0] == 20  && (p1moveleft) ||

						((playerx1[0] == 80 || playerx1[0] == 500) &&
playery1[0] != 20 && playery1[0] != 40 && playery1[0] != 260 && playery1[0] != 280 && playery1[0] != 500 && playery1[0] != 520)
                     && (p1moveleft)) ||

						(((playerx1[0] == 140 || playerx1[0] == 440)&&
playery1[0] != 20 && playery1[0] != 40 && playery1[0] != 80 && playery1[0] != 100 && playery1[0] != 180 && playery1[0] != 200
&& playery1[0] != 340 && playery1[0] != 360 && playery1[0] != 440 && playery1[0] != 460 && playery1[0] != 500 && playery1[0] != 520)
                  && (p1moveleft)) ||

                  (((playerx1[0] == 200 || playerx1[0] == 380) &&
playery1[0] != 20 && playery1[0] != 40 && playery1[0] != 80 && playery1[0] != 100 && playery1[0] != 140 && playery1[0] != 160
&& playery1[0] != 260 && playery1[0] != 280 && playery1[0] != 380 && playery1[0] != 400
&& playery1[0] != 440 && playery1[0] != 460 && playery1[0] != 500 && playery1[0] != 520)
                  && (p1moveleft)) ||

                  (((playerx1[0] == 260 || playerx1[0] == 320) &&
playery1[0] != 20 && playery1[0] != 40 && playery1[0] != 80 && playery1[0] != 100 && playery1[0] != 140 && playery1[0] != 160
&& playery1[0] != 200 && playery1[0] != 340 && playery1[0] != 380 && playery1[0] != 400 &&  playery1[0] != 440
&& playery1[0] != 460 && playery1[0] != 500 && playery1[0] != 520)
                  && (p1moveleft)) ||

                  ((playerx1[0] == 160 || playerx1[0] == 360) && playery1[0] == 120 || playery1[0] == 420)
                		                       && (p1moveleft))


                  || ( (ghostx1[0]==20 && (ghostmoveleft))
					|| (ghostx1[0]==80 &&
         ghosty1[0]!=20 && ghosty1[0]!=40 && ghosty1[0] != 260 && ghosty1[0] != 280 && ghosty1[0] != 500 && ghosty1[0] != 520)
         && (ghostmoveleft))  ||

			(((ghostx1[0] == 140 || ghostx1[0] == 440)&&
		ghosty1[0] != 20 && ghosty1[0] != 40 && ghosty1[0] != 80 && ghosty1[0] != 100 && ghosty1[0] != 180 && ghosty1[0] != 200
&& ghosty1[0] != 340 && ghosty1[0] != 360 && ghosty1[0] != 440 && ghosty1[0] != 460 && ghosty1[0] != 500 && ghosty1[0] != 520)
      && (ghostmoveleft)) ||

      (((ghostx1[0] == 200 || ghostx1[0] == 380) &&
    ghosty1[0] != 20 && ghosty1[0] != 40 && ghosty1[0] != 80 && ghosty1[0] != 100 && ghosty1[0] != 140 && ghosty1[0] != 160
&& ghosty1[0] != 260 && ghosty1[0] != 280 && ghosty1[0] != 380 && ghosty1[0] != 400
&& ghosty1[0] != 440 && ghosty1[0] != 460 && ghosty1[0] != 500 && ghosty1[0] != 520)
      && (ghostmoveleft)) ||

      (((ghostx1[0] == 260 || ghostx1[0] == 320) &&
    ghosty1[0] != 20 && ghosty1[0] != 40 && ghosty1[0] != 80 && ghosty1[0] != 100 && ghosty1[0] != 140 && ghosty1[0] != 160
&& ghosty1[0] != 200 && ghosty1[0] != 340 && ghosty1[0] != 380 && ghosty1[0] != 400 &&  ghosty1[0] != 440
&& ghosty1[0] != 460 && ghosty1[0] != 500 && ghosty1[0] != 520)
      && (ghostmoveleft))
      || ((ghostx1[0] == 160 || ghostx1[0] == 360) && ghosty1[0] == 120 || ghosty1[0] == 420)
      && (ghostmoveleft)){

					p1moveup = false;
					p1movedown = false;
					p1moveleft = false;
					p1moveright = false;

					 ghostmoveup = false;
					 ghostmovedown = false;
					 ghostmoveleft = false;
					 ghostmoveright = false;
				}

				if ( ((playery1[0] == 20) && (p1moveup)) ||
						(((playery1[0] == 80 || playery1[0] == 500) &&
playerx1[0] != 20 && playerx1[0] != 40 && playerx1[0] != 260 && playerx1[0] != 280 && playerx1[0] != 500 && playerx1[0] != 520)
                     && (p1moveup)) ||

						(((playery1[0] == 140 || playery1[0] == 440) &&
playerx1[0] != 20 && playerx1[0] != 40 && playerx1[0] != 80 && playerx1[0] != 100 && playerx1[0] != 160 && playerx1[0] != 180
&& playerx1[0] != 360 && playerx1[0] != 380 && playerx1[0] != 440 && playerx1[0] != 460 && playerx1[0] != 500 && playerx1[0] != 520)
                  && (p1moveup)) ||

                  (((playery1[0] == 200 || playery1[0] == 380) &&
playerx1[0] != 20 && playerx1[0] != 40 && playerx1[0] != 80 && playerx1[0] != 100 && playerx1[0] != 120 && playerx1[0] != 140
&& playerx1[0] != 160 && playerx1[0] != 260 && playerx1[0] != 280 && playerx1[0] != 380 && playerx1[0] != 400
&& playerx1[0] != 420 && playerx1[0] != 440 && playerx1[0] != 460 && playerx1[0] != 500 && playerx1[0] != 520)
                  && (p1moveup)) ||

                  (((playery1[0] == 340) && (playerx1[0] == 120 || playerx1[0] == 240 || playerx1[0] == 300 || playerx1[0] == 420))
                		  && (p1moveup))
                  ||
                  (((playery1[0] == 260) && (playerx1[0] == 60 || playerx1[0] == 180  || playerx1[0] == 360 || playerx1[0] == 480))
                		  && (p1moveup))
                  || (((playery1[0] == 180) && (playerx1[0] == 120 || playerx1[0] == 420) ) && (p1moveup))


                  ||
                  ((ghosty1[0] == 20) && (ghostmoveup)) ||
					(((ghosty1[0] == 80 || ghosty1[0] == 500) &&
	ghostx1[0] != 20 && ghostx1[0] != 40 && ghostx1[0] != 260 && ghostx1[0] != 280 && ghostx1[0] != 500 && ghostx1[0] != 520)
               && (ghostmoveup)) ||

					(((ghosty1[0] == 140 || ghosty1[0] == 440) &&
   ghostx1[0] != 20 && ghostx1[0] != 40 && ghostx1[0] != 80 && ghostx1[0] != 100 && ghostx1[0] != 160 && ghostx1[0] != 180
&& ghostx1[0] != 360 && ghostx1[0] != 380 && ghostx1[0] != 440 && ghostx1[0] != 460 && ghostx1[0] != 500 && ghostx1[0] != 520)
            && (ghostmoveup)) ||

            (((ghosty1[0] == 200 || ghosty1[0] == 380) &&
   ghostx1[0] != 20 && ghostx1[0] != 40 && ghostx1[0] != 80 && ghostx1[0] != 100 && ghostx1[0] != 120 && ghostx1[0] != 140
&& ghostx1[0] != 160 && ghostx1[0] != 260 && ghostx1[0] != 280 && ghostx1[0] != 380 && ghostx1[0] != 400
&& ghostx1[0] != 420 && ghostx1[0] != 440 && ghostx1[0] != 460 && ghostx1[0] != 500 && ghostx1[0] != 520)
            && (ghostmoveup)) ||

            (((ghosty1[0] == 340) && (ghostx1[0] == 120 || ghostx1[0] == 240 || ghostx1[0] == 300 || ghostx1[0] == 420))
          		  && (ghostmoveup))
            ||

            (((ghosty1[0] == 260) && (ghostx1[0] == 60 || ghostx1[0] == 180  || ghostx1[0] == 360 || ghostx1[0] == 480))
            		 && (ghostmoveup))
            ||

            (((ghosty1[0] == 180) && (ghostx1[0] == 120 || ghostx1[0] == 420 )) && (ghostmoveup))) {

					p1moveup = false;
					p1movedown = false;
					p1moveleft = false;
					p1moveright = false;

					 ghostmoveup = false;
					 ghostmovedown = false;
					 ghostmoveleft = false;
					 ghostmoveright = false;
				}
				if (((playerx1[0] == 520  && (p1moveright) ||

						((playerx1[0] == 40 || playerx1[0] == 460) &&
playery1[0] != 20 && playery1[0] != 40 && playery1[0] != 260 && playery1[0] != 280 && playery1[0] != 500 && playery1[0] != 520)
                     && (p1moveright)) ||

						(((playerx1[0] == 100 || playerx1[0] == 400)&&
playery1[0] != 20 && playery1[0] != 40 && playery1[0] != 80 && playery1[0] != 100 && playery1[0] != 180 && playery1[0] != 200
&& playery1[0] != 340 && playery1[0] != 360 && playery1[0] != 440 && playery1[0] != 460 && playery1[0] != 500 && playery1[0] != 520)
                  && (p1moveright)) ||

                  (((playerx1[0] == 160 || playerx1[0] == 340) &&
playery1[0] != 20 && playery1[0] != 40 && playery1[0] != 80 && playery1[0] != 100 && playery1[0] != 140 && playery1[0] != 160
&& playery1[0] != 260 && playery1[0] != 280 && playery1[0] != 380 && playery1[0] != 400
&& playery1[0] != 440 && playery1[0] != 460 && playery1[0] != 500 && playery1[0] != 520)
                  && (p1moveright)) ||

                  (((playerx1[0] == 220 || playerx1[0] == 280) &&
playery1[0] != 20 && playery1[0] != 40 && playery1[0] != 80 && playery1[0] != 100 && playery1[0] != 140 && playery1[0] != 160
&& playery1[0] != 200 && playery1[0] != 340 && playery1[0] != 380 && playery1[0] != 400 &&  playery1[0] != 440
&& playery1[0] != 460 && playery1[0] != 500 && playery1[0] != 520)
                  && (p1moveright)) )


                  || ( (ghostx1[0]==520 && (ghostmoveright))
					|| ((ghostx1[0]==40  || ghostx1[0] == 460) &&
         ghosty1[0]!=20 && ghosty1[0]!=40 && ghosty1[0] != 260 && ghosty1[0] != 280 && ghosty1[0] != 500 && ghosty1[0] != 520)
         && (ghostmoveright))  ||

			(((ghostx1[0] == 100 || ghostx1[0] == 400)&&
		ghosty1[0] != 20 && ghosty1[0] != 40 && ghosty1[0] != 80 && ghosty1[0] != 100 && ghosty1[0] != 180 && ghosty1[0] != 200
&& ghosty1[0] != 340 && ghosty1[0] != 360 && ghosty1[0] != 440 && ghosty1[0] != 460 && ghosty1[0] != 500 && ghosty1[0] != 520)
      && (ghostmoveright)) ||

      (((ghostx1[0] == 160 || ghostx1[0] == 340) &&
    ghosty1[0] != 20 && ghosty1[0] != 40 && ghosty1[0] != 80 && ghosty1[0] != 100 && ghosty1[0] != 140 && ghosty1[0] != 160
&& ghosty1[0] != 260 && ghosty1[0] != 280 && ghosty1[0] != 380 && ghosty1[0] != 400
&& ghosty1[0] != 440 && ghosty1[0] != 460 && ghosty1[0] != 500 && ghosty1[0] != 520)
      && (ghostmoveright)) ||

      (((ghostx1[0] == 220 || ghostx1[0] == 280) &&
    ghosty1[0] != 20 && ghosty1[0] != 40 && ghosty1[0] != 80 && ghosty1[0] != 100 && ghosty1[0] != 140 && ghosty1[0] != 160
&& ghosty1[0] != 200 && ghosty1[0] != 340 && ghosty1[0] != 380 && ghosty1[0] != 400 &&  ghosty1[0] != 440
&& ghosty1[0] != 460 && ghosty1[0] != 500 && ghosty1[0] != 520)
      && (ghostmoveright))) {

					p1moveup = false;
					p1movedown = false;
					p1moveleft = false;
					p1moveright = false;

					 ghostmoveup = false;
					 ghostmovedown = false;
					 ghostmoveleft = false;
					 ghostmoveright = false;
				}
				if (  ((playery1[0] == 520) && (p1movedown)) ||
						(((playery1[0] == 40 || playery1[0] == 460) &&
playerx1[0] != 20 && playerx1[0] != 40 && playerx1[0] != 260 && playerx1[0] != 280 && playerx1[0] != 500 && playerx1[0] != 520)
                     && (p1movedown)) ||

						(((playery1[0] == 100 || playery1[0] == 400) &&
playerx1[0] != 20 && playerx1[0] != 40 && playerx1[0] != 80 && playerx1[0] != 100 && playerx1[0] != 160 && playerx1[0] != 180
&& playerx1[0] != 360 && playerx1[0] != 380 && playerx1[0] != 440 && playerx1[0] != 460 && playerx1[0] != 500 && playerx1[0] != 520)
                  && (p1movedown)) ||

                  (((playery1[0] == 160 || playery1[0] == 340) &&
playerx1[0] != 20 && playerx1[0] != 40 && playerx1[0] != 80 && playerx1[0] != 100 && playerx1[0] != 120 && playerx1[0] != 140
&& playerx1[0] != 160 && playerx1[0] != 260 && playerx1[0] != 280 && playerx1[0] != 380 && playerx1[0] != 400
&& playerx1[0] != 420 && playerx1[0] != 440 && playerx1[0] != 460 && playerx1[0] != 500 && playerx1[0] != 520)
                  && (p1movedown)) ||

                  (((playery1[0] == 200) && (playerx1[0] == 120 || playerx1[0] == 240 || playerx1[0] == 300 || playerx1[0] == 420))
                		  && (p1movedown))
                  ||
                  (((playery1[0] == 280) && (playerx1[0] == 60 || playerx1[0] == 180  || playerx1[0] == 360 || playerx1[0] == 480))
                		  && (p1movedown))
                  || (((playery1[0] == 360) && (playerx1[0] == 120 || playerx1[0] == 420) ) && (p1movedown))


                  ||
                  ((ghosty1[0] == 520) && (ghostmovedown)) ||
					(((ghosty1[0] == 40 || ghosty1[0] == 460) &&
	ghostx1[0] != 20 && ghostx1[0] != 40 && ghostx1[0] != 260 && ghostx1[0] != 280 && ghostx1[0] != 500 && ghostx1[0] != 520)
               && (ghostmovedown)) ||

					(((ghosty1[0] == 100 || ghosty1[0] == 400) &&
   ghostx1[0] != 20 && ghostx1[0] != 40 && ghostx1[0] != 80 && ghostx1[0] != 100 && ghostx1[0] != 160 && ghostx1[0] != 180
&& ghostx1[0] != 360 && ghostx1[0] != 380 && ghostx1[0] != 440 && ghostx1[0] != 460 && ghostx1[0] != 500 && ghostx1[0] != 520)
            && (ghostmovedown)) ||

            (((ghosty1[0] == 160 || ghosty1[0] == 340) &&
   ghostx1[0] != 20 && ghostx1[0] != 40 && ghostx1[0] != 80 && ghostx1[0] != 100 && ghostx1[0] != 120 && ghostx1[0] != 140
&& ghostx1[0] != 160 && ghostx1[0] != 260 && ghostx1[0] != 280 && ghostx1[0] != 380 && ghostx1[0] != 400
&& ghostx1[0] != 420 && ghostx1[0] != 440 && ghostx1[0] != 460 && ghostx1[0] != 500 && ghostx1[0] != 520)
            && (ghostmovedown)) ||

            (((ghosty1[0] == 200) && (ghostx1[0] == 120 || ghostx1[0] == 240 || ghostx1[0] == 300 || ghostx1[0] == 420))
          		  && (ghostmovedown))
            ||

            (((ghosty1[0] == 280) && (ghostx1[0] == 60 || ghostx1[0] == 180  || ghostx1[0] == 360 || ghostx1[0] == 480))
            		 && (ghostmovedown))
            ||

            (((ghosty1[0] == 360) && (ghostx1[0] == 120 || ghostx1[0] == 420 )) && (ghostmovedown))) {

					p1moveup = false;
					p1movedown = false;
					p1moveleft = false;
					p1moveright = false;

					 ghostmoveup = false;
					 ghostmovedown = false;
					 ghostmoveleft = false;
					 ghostmoveright = false;
				}




	}

	public void checkCoinCollision() {

		// checks for collision for coin 1, will increment score by one and
		// remove the coin

		// THIS IS DONE FOR ALL 20 COINS
		if ((playerx1[0] == coinx1[0]) && (playery1[0] == coiny1[0]))

		{

			pacman1score = pacman1score + 1;
			coinx1[0]= - 20;
			coiny1[0]= - 20;

		}

		// ----------------------------------------------------------------------------------------------------
		// checks for collision for coin 2, will increment score by one and
		// remove the coin
		if ((playerx1[0] == coinx2[0]) && (playery1[0] == coiny2[0])) {

			pacman1score = pacman1score + 1;
			coinx2[0]= - 20;
			coiny2[0]= - 20;
		}


		// ----------------------------------------------------------------------------------------------------
		// checks for collision for coin 3, will increment score by one and
		// remove the coin
		if ((playerx1[0] == coinx3[0]) && (playery1[0] == coiny3[0])) {

			pacman1score = pacman1score + 1;
			coinx3[0]= - 20;
			coiny3[0]= - 20;
		}


		// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 4, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx4[0]) && (playery1[0] == coiny4[0])) {

					pacman1score = pacman1score + 1;
					coinx4[0]= - 20;
					coiny4[0]= - 20;
				}



				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 5, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx5[0]) && (playery1[0] == coiny5[0])) {

					pacman1score = pacman1score + 1;
					coinx5[0]= - 20;
					coiny5[0]= - 20;
				}



				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 6, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx6[0]) && (playery1[0] == coiny6[0])) {

					pacman1score = pacman1score + 1;
					coinx6[0]= - 20;
					coiny6[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 7, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx7[0]) && (playery1[0] == coiny7[0])) {

					pacman1score = pacman1score + 1;
					coinx7[0]= - 20;
					coiny7[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 8, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx8[0]) && (playery1[0] == coiny8[0])) {

					pacman1score = pacman1score + 1;
					coinx8[0]= - 20;
					coiny8[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 9, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx9[0]) && (playery1[0] == coiny9[0])) {

					pacman1score = pacman1score + 1;
					coinx9[0]= - 20;
					coiny9[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 10, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx10[0]) && (playery1[0] == coiny10[0])) {

					pacman1score = pacman1score + 1;
					coinx10[0]= - 20;
					coiny10[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 11, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx11[0]) && (playery1[0] == coiny11[0])) {

					pacman1score = pacman1score + 1;
					coinx11[0]= - 20;
					coiny11[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 12, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx12[0]) && (playery1[0] == coiny12[0])) {

					pacman1score = pacman1score + 1;
					coinx12[0]= - 20;
					coiny12[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 13, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx13[0]) && (playery1[0] == coiny13[0])) {

					pacman1score = pacman1score + 1;
					coinx13[0]= - 20;
					coiny13[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 14, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx14[0]) && (playery1[0] == coiny14[0])) {

					pacman1score = pacman1score + 1;
					coinx14[0]= - 20;
					coiny14[0]= - 20;
				}



				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 15, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx15[0]) && (playery1[0] == coiny15[0])) {

					pacman1score = pacman1score + 1;
					coinx15[0]= - 20;
					coiny15[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 16, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx16[0]) && (playery1[0] == coiny16[0])) {

					pacman1score = pacman1score + 1;
					coinx16[0]= - 20;
					coiny16[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 17, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx17[0]) && (playery1[0] == coiny17[0])) {

					pacman1score = pacman1score + 1;
					coinx17[0]= - 20;
					coiny17[0]= - 20;
				}



				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 10, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx18[0]) && (playery1[0] == coiny18[0])) {

					pacman1score = pacman1score + 1;
					coinx18[0]= - 20;
					coiny18[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 19, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx19[0]) && (playery1[0] == coiny19[0])) {

					pacman1score = pacman1score + 1;
					coinx19[0]= - 20;
					coiny19[0]= - 20;
				}


				// ----------------------------------------------------------------------------------------------------
				// checks for collision for coin 20, will increment score by one and
				// remove the coin
				if ((playerx1[0] == coinx20[0]) && (playery1[0] == coiny20[0])) {

					pacman1score = pacman1score + 1;
					coinx20[0]= - 20;
					coiny20[0]= - 20;
				}

	}



	// when playing is initialised, pacman players will then be able to move
	public void actionPerformed(ActionEvent e) {

		if (playing) {
			// as soon as game is initialised, the pacman is able to move


			// makes the pacmans move and the collision depend on variable timer
			if (e.getSource() == timer)
		    {
				pacmove();
				ghostMove();
				checkGhostCollision();

				checkCoinCollision();

		    }




			if (e.getSource() == timer3)
		    {
				checkWallCollision();
		    }



		} else {
			// when the game ends, it stops playing and player has to restart the game
			playing = false;
		}


			}


	// painting method to draw the game objects
	public void paintComponent(Graphics graphics) {

		super.paintComponent(graphics);

		// assign graphics to a Graphics2D object
		Graphics2D graphics2D = (Graphics2D) graphics;

		this.setBackground(Color.BLACK);
		// added pacscore so that this method run and can paint out the score onscreen
		pacScore (graphics);
		// added paclives so that this method run and can paint out the lives onscreen
		pacLives (graphics);
		// added gameOver so that when either player reaches 0 lives, the game ends
		gameOver (graphics);

		// need a repaint() in order to redraw the object everytime it moves!
		repaint();

		// First draw the map
		// got idea from for forloop from youtube online, and then changed and built on it ourselves

		// -------------------------------------------------------------------------------------------
		for (int y = 0; y < 28; y++) {
			for (int x = 0; x < 28; x++) {

				if (gamemap.gameMap(x, y).equals("0")) {
					graphics2D.drawImage(gamemap.getMapfloor(), x * 20, y * 20,
							this);
				} else if (gamemap.gameMap(x, y).equals("1")) {
					graphics2D.drawImage(gamemap.getMapwall(), x * 20, y * 20,
							this);
				}
			     else if (gamemap.gameMap(x, y).equals("c")) {
				graphics2D.drawImage(gamemap.getCoins(), x * 20, y * 20,
						this);
			}

			}// End of inner for loop
		// -------------------------------------------------------------------------------------------
		}// End of outer for loop

		// Secondly draw the players and ghosts which will spawn over the tile map
		if (playing) {

			for (int i = 0; i < pac1; i++) {
				if (i < 1) {
					graphics.drawImage(pacman, playerx1[0], playery1[0], null);
					graphics.drawImage(ghost1, ghostx1[0], ghosty1[0], null);

					//print wall
					graphics.drawImage(walls, wallx1[0], wally1[0], null);
					// print all 20 coins
					graphics.drawImage(coin1, coinx1[0], coiny1[0], null);
					graphics.drawImage(coin2, coinx2[0], coiny2[0], null);
					graphics.drawImage(coin3, coinx3[0], coiny3[0], null);
					graphics.drawImage(coin4, coinx4[0], coiny4[0], null);
					graphics.drawImage(coin5, coinx5[0], coiny5[0], null);
					graphics.drawImage(coin6, coinx6[0], coiny6[0], null);
					graphics.drawImage(coin7, coinx7[0], coiny7[0], null);
					graphics.drawImage(coin8, coinx8[0], coiny8[0], null);
					graphics.drawImage(coin9, coinx9[0], coiny9[0], null);
					graphics.drawImage(coin10, coinx10[0], coiny10[0], null);
					graphics.drawImage(coin11, coinx11[0], coiny11[0], null);
					graphics.drawImage(coin12, coinx12[0], coiny12[0], null);
					graphics.drawImage(coin13, coinx13[0], coiny13[0], null);
					graphics.drawImage(coin14, coinx14[0], coiny14[0], null);
					graphics.drawImage(coin15, coinx15[0], coiny15[0], null);
					graphics.drawImage(coin16, coinx16[0], coiny16[0], null);
					graphics.drawImage(coin17, coinx17[0], coiny17[0], null);
					graphics.drawImage(coin18, coinx18[0], coiny18[0], null);
					graphics.drawImage(coin19, coinx19[0], coiny19[0], null);
					graphics.drawImage(coin20, coinx20[0], coiny20[0], null);

				}
			}
		}

	}

}
