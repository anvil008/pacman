package pacman;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Server.ServerGame;


// GameFrame class will display the game window
// JFrame is a class built into java, allowing us to use swing components
public class GameFrame extends JFrame {

	// get the Background class for the game background
	private MainMenu mainMenu;

	// need a class for keys - to control pacman player and display contents of the game
	// this class shall be called 'GameBoard'
	private GameBoardEasy gameboard;


	// dimensions of game window
	private static final int GAMEWIDTH = 566;
	private static final int GAMEHEIGHT = 660;

	// now we need to create a JPanel to go over the JFrame - methods imported
	// from swing library - this gets its variable
	private JPanel mypanel;

	// constructor - when the GameFrame is called, set up the JPanel and default gridlayout
	public GameFrame() {

		// code for setting the grid layout of the screen on our panel for the
		// pacman map

		//create new JPanel and set it up
		mypanel = new JPanel();
		// this code is a snippet I got from online as it is just simply how to
		// set the grid layout from a JPanel
		mypanel.setLayout(new GridLayout(1, 1, 0, 0));
        setContentPane(mypanel);
		// set the dimensions of the frame
		setPreferredSize(new Dimension(GAMEWIDTH, GAMEHEIGHT));

		// new MainMenu class for the game Menu
		mainMenu = new MainMenu(this, "/menu/pacmanMenu.jpg");
		// add the background also
		this.add(mainMenu);
		ServerGame.getInstance().Start();
	}

}
