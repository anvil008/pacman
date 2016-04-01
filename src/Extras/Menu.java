package Extras;


import javazoom.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.EventQueue;
import java.awt.Frame;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import pacman.GameStart;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JPanel contentPane;
	private BufferedImage img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 *
	 */

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		t1.start();


		JButton Chat = new JButton("");
		Chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chat c = new Chat();
				c.setVisible(true);
				dispose();
				t1.stop();
			}
		});
		Chat.setBounds(141, 61, 179, 39);
		contentPane.add(Chat);
		Chat.setIcon(new ImageIcon("Resources\\Chat.png"));

		JButton Settings = new JButton("");
		Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings s = new Settings();
				s.setVisible(true);
				dispose();
				t1.stop();
			}
		});
		Settings.setBounds(141, 111, 179, 39);
		contentPane.add(Settings);
		Settings.setIcon(new ImageIcon("Resources\\Settings.png"));

		JButton About = new JButton("");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About a = new About();
				a.setVisible(true);
				dispose();
				t1.stop();
			}
		});
		About.setBounds(141, 161, 179, 39);
		contentPane.add(About);
		About.setIcon(new ImageIcon("Resources\\About.png"));

		JLabel B2 = new JLabel("New label");
		B2.setBackground(Color.WHITE);
		B2.setBounds(346, 10, 140, 40);
		contentPane.add(B2);
		B2.setIcon(new ImageIcon("Resources\\B2.gif"));

		JButton Email = new JButton("");
		Email.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Send s = new Send();
				s.setVisible(true);
				dispose();
				t1.stop();
			}
		});
		Email.setBounds(141, 211, 179, 40);
		contentPane.add(Email);
		Email.setIcon(new ImageIcon("Resources\\Email.png"));

		JButton btnPlay = new JButton("");
		btnPlay.setBackground(Color.BLACK);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameStart gm = new GameStart();
				gm.main(null);
				t1.stop();
				}
		});
		btnPlay.setBounds(141, 10, 179, 40);
		contentPane.add(btnPlay);

		JButton SoundOff = new JButton("Sound Off");
		SoundOff.setBounds(10, 228, 89, 23);
		contentPane.add(SoundOff);
		SoundOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.stop();
			}
		});
		btnPlay.setIcon(new ImageIcon("Resources\\PlayGame.png"));

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				t1.stop();
			}
		});
		btnClose.setBounds(10, 10, 89, 23);
		contentPane.add(btnClose);

	}

	private void setDefaultCloseOperation(Object stop) {
		// TODO Auto-generated method stub

	}

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
}
