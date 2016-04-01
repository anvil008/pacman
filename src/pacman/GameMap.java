package pacman;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GameMap {

	// gets the tilemap images for the mapfloor and mapwalls
	private BufferedImage mapFloor;
	private BufferedImage mapWall;
	// gets the tilemap image for the coins in the game
	private BufferedImage coins;

	// scanner is required to input our text file for the gamelayout
	public Scanner input;

	// creates an array to store the String of X x Y grid layout (grid is
	// currently 28 x 28)
    // got this idea of using an array to store the x and y grid layout from online
	// reference links in the report

	// ----------------------------------------------------------------------------
	public String GameMap[] = new String[28];
	//-----------------------------------------------------------------------------

	// when GameMap constructor is called, gets the tile images for the gamemap
	// it also gets calls the methods to open and read the files so that they
	// can be used
	public GameMap() {

		// when constructor is called, will open up the map using the mapOpen()
		// method
		mapOpen();
		// gets the images for walls, floor and coin tiles from GameResources
		try {
			mapFloor = ImageIO.read(getClass().getResourceAsStream(
					"/map/mapfloor.png"));

			mapWall = ImageIO.read(getClass().getResourceAsStream(
					"/map/mapwall.png"));

			coins = ImageIO.read(getClass().getResourceAsStream(
					"/map/Coin.png"));


		} catch (Exception e) {
			e.printStackTrace();
		}

		// when constructor is called, will read the map using the mapRead()
		// method which will read in the map, so that it can then be displayed
		mapRead();

	}

	// getter for the floor tile of the tilemap
	public Image getMapfloor() {
		return mapFloor;
	}

	// getter for the wall tile of the tilemap
	public Image getMapwall() {
		return mapWall;
	}
	// getter for the coins that are placed in the tilemap
	public Image getCoins() {
		return coins;
	}


	// reads the file
	public void mapRead() {
		// make a while loop, until it reaches the end of the file
		// got this idea template from online as i wasn't sure how to implement it - between the lines
		// reference links in the report
// ------------------------------------------------------------------------------------------------------
		while (input.hasNext()) {
			// for loop - loops through file
			for (int i = 0; i < 28; i++) {

				// goes through each row of the file
				GameMap[i] = input.next();
				// prints the gamemap to console when playing
				System.out.println(GameMap[i]);
			}

		}
	}


	// get specific tile from specific spot in the gamemap file
	public String gameMap(int a, int b) { // starting position a, b - horizontal
											// and vertical axis
		// returns a substring of the string,
		// got this idea from online as i wasn't sure how to get a specific file from a specific spot
		String tileI = GameMap[b].substring(a, a + 1);
		return tileI;
	}

// ------------------------------------------------------------------------------------------------------

	// opens the file via directory
	public void mapOpen() {
		// uses a try and catch for browsing for the gamemap.txt file directory
		try {
			input = new Scanner(getClass().getResourceAsStream(
					"/map/gamemap.txt"));
		} catch (Exception e) {
			// if exception is caught, print line, and use stack trace to see
			// where the problem lies
			System.out.print("cannot find gamemap path, please search again ");
			e.printStackTrace();
		}

	}



}
