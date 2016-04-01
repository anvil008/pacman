package Extras;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Settings extends JFrame {

	private JPanel contentPane;
	/*
	 * Launches the application/GUI
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/* builds the GUI and the Text for the viewer to read
     * requires: the class to be error-free etc.
     * ensures:  that the GUI starts up for the user to see and sets up all the background, fields, events etc.
     */
	public Settings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton BackToMenu = new JButton("");
		BackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		BackToMenu.setBackground(Color.WHITE);
		BackToMenu.setBounds(10, 212, 179, 39);
		contentPane.add(BackToMenu);
		BackToMenu.setIcon(new ImageIcon("Resources\\BackToMenu.png"));

		JTextArea txtrBvdsbsab = new JTextArea();
		txtrBvdsbsab.setBackground(Color.BLACK);
		txtrBvdsbsab.setForeground(Color.WHITE);
		txtrBvdsbsab.setLineWrap(true);
		txtrBvdsbsab.setText("The rules are very simple. The objective is to collect 10 coins before you touch the ghosts/or more than the other player.\r\n\r\nyou can control the game via the keyboard using the arrow keys or a usb Xbox 360 controller if you have it connected. Any more queries please contact. Enjoy!!");
		txtrBvdsbsab.setBounds(34, 26, 455, 142);
		contentPane.add(txtrBvdsbsab);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(10, 10, 89, 23);
		contentPane.add(btnClose);

	}
}
