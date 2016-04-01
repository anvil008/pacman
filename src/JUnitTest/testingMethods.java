
package JUnitTest;
import pacman.*;
import Server.*;
import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.junit.Test;


public class testingMethods {

	//method to test scores and lives at start
	private static final Graphics Graphics = null;

	GameMap gm = new GameMap();
	GameFrame gf = new GameFrame();
	GameBoardEasy gb = new GameBoardEasy(gf,"/map/pacman.png","/map/pacman2.png",
			"/map/ghost1.png","/map/ghost2.png", "/map/ghost3.png",
			"/map/coin.png", "/map/mapwall.png","/map/item.png");
	int Pac1ScoreExpected = 0;
	int Pac2ScoreExpected = 0;
	int Pac1LivesExpected = 3;
	int Pac2LivesExpected = 3;
	boolean UpAtStart = false;
	boolean DownAtStart = false;
	boolean LeftAtStart = false;
	boolean RightAtStart = false;

	//Test for player1 score at start
	@Test
	public void testPac1Score(){
	//assert checks player 1 score at start
	assertEquals(Pac1ScoreExpected, gb.getPacman1score());
	}

	//Test for player2 score at start
	@Test
	public void testPac2Score(){
	//assert checks player 1 score at start
	assertEquals(Pac2ScoreExpected, gb.getPacman2score());
	}

	//Test for player1 lives at start
	@Test
	public void testPac1lives(){
	//assert checks player 1 score at start
	assertEquals(Pac1LivesExpected, gb.getPacman1lives());
	}

	//Test for player2 lives at start
	@Test
	public void testPac2lives(){
	//assert checks player 1 score at start
	assertEquals(Pac2LivesExpected, gb.getPacman1lives());
	}

	//Test for player1 Up movement at start
	@Test
	public void testMovementUp(){
	//assert checks player 1 score at start
	assertEquals(UpAtStart, gb.p1moveup);
	}

	//Test for player1 Down movement at start
	@Test
	public void testMovementDown(){
	//assert checks player 1 score at start
	assertEquals(DownAtStart, gb.p1movedown);
	}

	//Test for player1 Left movement at start
	@Test
	public void testMovementLeft(){
	//assert checks player 1 score at start
	assertEquals(LeftAtStart, gb.p1moveleft);
	}

	//Test for player1 Right movement at start
	@Test
	public void testMovementRight(){
	//assert checks player movement score at start
	assertEquals(RightAtStart, gb.p1moveright);
	}

	//Test for any coin collisions at start
	@Test
	public void testCoinCollisionAtStart(){
		//assert checks the
		gb.checkCoinCollision();
		//assert checks any Coin collisions score at start by checking scores
		assertEquals(0, gb.getPacman1score());
		}

	//Test for any ghost collisions at start
	@Test
	public void testGhostCollisionAtStart(){
		gb.checkGhostCollision();
		//assert checks Ghost collisions score at start by checking lives
		assertEquals(3, gb.getPacman1lives());
		}

	//Test for loss of lives at ghost collisions
	@Test
	public void lifeAtGhostCollision(){
		//setting the ghost and player 1 to have the same co-ordinates
		gb.playerx1[0] =0;
		gb.playery1[0] =20;
		gb.ghostx1[0]=0;
		gb.ghosty1[0]=20;
		//running ghost collisions check
		gb.checkGhostCollision();
		int lifeExpected = 2;
		//checking if player loses life after collision with ghost
		assertEquals(lifeExpected, gb.getPacman1lives());
	}

	//Test for change of position at ghost collisions
	@Test
	public void playerPositionAtGhostCollision(){
		//setting the ghost and player 1 to have the same co-ordinates
		gb.playerx1[0] =0;
		gb.playery1[0] =20;
		gb.ghostx1[0]=0;
		gb.ghosty1[0]=20;
		//running ghost collisions check
		gb.checkGhostCollision();
		int xExpected = 80;
		int yExpected = 80;
		//checking if player goes back to original place after collision with
		assertEquals(xExpected, gb.playerx1[0]);
		assertEquals(yExpected, gb.playery1[0]);
	}

	//Test for change of score at score collisions
	@Test
	public void playerScoreAtCoinCollision(){
		//setting the coin and player 1 to have the same co-ordinates
		gb.playerx1[0] =0;
		gb.playery1[0] =20;
		gb.coinx1[0]=0;
		gb.coiny1[0]=20;
		//running ghost collisions check
		gb.checkCoinCollision();
		int scoreExpected = 1;
		//checking if player goes back to original place after collision with
		assertEquals(scoreExpected, gb.getPacman1score());
	}

	//Test for ghost down movement method
	@Test
	public void testDownGhostmovement(){
		//sets the ghostDownExpected to the ghosts original position moved down by 20
		int ghostDownExpected = (gb.ghosty1[0] + 20);
		gb.ghostmovedown = true;
		gb.Ghostmove();
		//assert tests if ghost has moved down by 20
		assertEquals(ghostDownExpected, gb.ghosty1[0]);

	}

	//Test for ghost up movement method
	@Test
	public void testUpGhostmovement(){
		//sets the ghostUpExpected to the ghosts original position moved up by 20
		int ghostUpExpected = (gb.ghosty1[0] - 20);
		gb.ghostmoveup = true;
		gb.Ghostmove();
		//assert tests if ghost has moved up by 20
		assertEquals(ghostUpExpected, gb.ghosty1[0]);

	}

	//Test for ghost left movement method
	@Test
	public void testLeftGhostmovement(){
		//sets the ghostUpExpected to the ghosts original position moved left by 20
		int ghostLeftExpected = (gb.ghostx1[0] - 20);
		gb.ghostmoveleft = true;
		gb.Ghostmove();
		//assert tests if ghost has moved left by 20
		assertEquals(ghostLeftExpected, gb.ghostx1[0]);

	}

	//Test for ghost right movement method
		@Test
		public void testGhostRightmovement(){
			//sets the ghostUpExpected to the ghosts original position moved right by 20
			int ghostRightExpected = (gb.ghostx1[0] + 20);
			gb.ghostmoveright = true;
			gb.Ghostmove();
			//assert tests if ghost has moved right by 20
			assertEquals(ghostRightExpected, gb.ghostx1[0]);
		}

		//Test for player down movement method
			@Test
			public void testPlayerDownmovement(){
				//sets the playerDownExpected to the players original position moved down by 20
				int playerDownExpected = (gb.playery1[0] + 20);
				gb.p1movedown = true;
				gb.pacmove();
				//assert tests if ghost has moved down by 20
				assertEquals(playerDownExpected, gb.playery1[0]);

			}

			//Test for player up movement method
			@Test
			public void testPlayerUpmovement(){
				//sets the playerUpExpected to the players original position moved down by 20
				int playerUpExpected = (gb.playery1[0] - 20);
				gb.p1moveup = true;
				gb.pacmove();
				//assert tests if ghost has moved up by 20
				assertEquals(playerUpExpected, gb.playery1[0]);
			}

			//Test for player left movement method
			@Test
			public void testPlayerLeftmovement(){
				//sets the playerLeftExpected to the players original position moved down by 20
				int playerLeftExpected = (gb.playerx1[0] - 20);
				gb.p1moveleft = true;
				gb.pacmove();
				//assert tests if ghost has moved left by 20
				assertEquals(playerLeftExpected, gb.playerx1[0]);
			}

			//Test for player right movement method
			@Test
			public void testPlayerRightmovement(){
				//sets the playerDownExpected to the players original position moved down by 20
				int playerRightExpected = (gb.playerx1[0] + 20);
				gb.p1moveright = true;
				gb.pacmove();
				//assert tests if ghost has moved right by 20
				assertEquals(playerRightExpected, gb.playerx1[0]);

			}

}
