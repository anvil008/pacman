package Extras;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class About extends JFrame {

	private JPanel contentPane;

	/*
	 * Launch the application.
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

	/*
	 * Creates the frame.
	 */
	public About() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 300);
		contentPane = new JPanel();
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

		/* builds the GUI background and fields
	     * requires: nothing
	     * ensures:  that the text is visible and their is a option to back to menu.
	     */
		BackToMenu.setBackground(Color.WHITE);
		BackToMenu.setBounds(10, 212, 179, 39);
		contentPane.add(BackToMenu);
		BackToMenu.setIcon(new ImageIcon("Resources\\BackToMenu.png"));

		JTextArea ThisGameWas = new JTextArea();
		ThisGameWas.setBackground(Color.BLACK);
		ThisGameWas.setForeground(Color.WHITE);
		ThisGameWas.setLineWrap(true);
		ThisGameWas.setText("This game was created by Team B2 of Birmingham University as a second year project. \r\nThank you for trying our game.\r\n\r\n\tGroup Members\r\nAnvil Palamattam\r\nBorislav Angelov\r\nDiyan Dinev\r\nJosh Maguire\r\nMohammed Khan");
		ThisGameWas.setBounds(56, 11, 396, 190);
		contentPane.add(ThisGameWas);

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
