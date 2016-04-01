package pacman;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class GameStart {

	// sets the GameFrame window
	private static GameFrame frame;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {

					// accessing frame GameFrame class
					frame = new GameFrame();
					frame.setVisible(true);
					frame.pack();
					frame.setTitle("Pacman");
					frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					// places the frame in middle of the screen
					frame.setLocationRelativeTo(null);
					// stays on screen unless minimised
					frame.setAlwaysOnTop(true);

				} catch (Exception e) {
					// print trace to find solution to error if one shall occur
					e.printStackTrace();
				}
			}
		});

	}

}
