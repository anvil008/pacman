package Extras;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JPasswordField;

public class Send extends JFrame {

/* initialises all Fields
 * requires: nothing
 * ensures:  that the fields you need for later on in the class are initialised for use
 */
	private JPanel contentPane;
	private JTextField Email;
	private JTextField Subject;
	private JTextField Message;
	private JTextField Attatchment;
	private JTextField Where;
	private JTextField CC;
	private JPasswordField Password;


	/* Main method for the class Send
	 * requires: nothing
	 * ensures:  that when the application has started to run the window opens up and that the program runs
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Send frame = new Send();
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

	/*Constructor for Send
	 * requires: there be a valid class called Send which has the method Send in it.
	 * ensures:  creates all the Buttons(Send, Browse), Labels(Title, Email, Password, To, CC, Subject, Message, Attachment), and TextFields(Title, Email, Password, To, CC, Subject, Message, Attachment) for the application.
	 */
	public Send() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Title = new JLabel("Send us an E-Mail for any queries");
		Title.setBounds(200, 0, 200, 14);
		contentPane.add(Title);
		Title.setForeground(Color.WHITE);

		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setBounds(10, 24, 60, 14);
		contentPane.add(EmailLabel);
		EmailLabel.setForeground(Color.WHITE);

		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(10, 49, 60, 14);
		contentPane.add(PasswordLabel);
		PasswordLabel.setForeground(Color.WHITE);

		JLabel MessageLabel = new JLabel("Message");
		MessageLabel.setBounds(10, 150, 60, 14);
		contentPane.add(MessageLabel);
		MessageLabel.setForeground(Color.WHITE);

		JLabel AttatchmentLabel = new JLabel("Attatchment");
		AttatchmentLabel.setBounds(10, 241, 89, 14);
		contentPane.add(AttatchmentLabel);
		AttatchmentLabel.setForeground(Color.WHITE);

		Email = new JTextField();
		Email.setBounds(99, 21, 314, 20);
		contentPane.add(Email);
		Email.setColumns(10);

		Subject = new JTextField();
		Subject.setBounds(99, 122, 314, 20);
		Subject.setColumns(10);
		contentPane.add(Subject);
		Subject.setText("B2 Game - PacMan");
		Subject.setEditable(false);

		Message = new JTextField();
		Message.setBounds(99, 150, 314, 66);
		Message.setColumns(10);
		contentPane.add(Message);

		Attatchment = new JTextField();
		Attatchment.setBounds(99, 238, 215, 20);
		Attatchment.setColumns(10);
		contentPane.add(Attatchment);

		/*creates a new button called Browse which will let user to go through files for required attachment
		 * requires: t2 to be valid
		 * ensures:  that user is able to look through their files to get the filepath for their desired attachment without having to type it themselves
		 */
		JButton Browse = new JButton("Browse");
		Browse.setBounds(324, 237, 89, 23);
		Browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        t2.start();
			}
		});
		contentPane.add(Browse);

		/*creates a button called SendEmail which will allow user to send the email when pressed
		 * requires: t1 to be valid
		 * ensures:  that when the button is clicked and the Textfield's are valid an email is sent to the desired destination
		 */
		JButton btnSendEmail = new JButton("Send Email");
		btnSendEmail.setBounds(177, 264, 110, 23);
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.start();
			}
		});
		contentPane.add(btnSendEmail);

		Where = new JTextField();
		Where.setBounds(99, 71, 314, 20);
		contentPane.add(Where);
		Where.setColumns(10);
		Where.setText("tkhan3627@gmail.com");
		Where.setEditable(false);

		JLabel ToLabel = new JLabel("To");
		ToLabel.setBounds(10, 74, 46, 14);
		contentPane.add(ToLabel);
		ToLabel.setForeground(Color.WHITE);

		JLabel SubjectLabel = new JLabel("Subject");
		SubjectLabel.setBounds(10, 125, 60, 14);
		contentPane.add(SubjectLabel);
		SubjectLabel.setForeground(Color.WHITE);

		JLabel CCLabel = new JLabel("CC");
		CCLabel.setBounds(10, 100, 46, 14);
		contentPane.add(CCLabel);
		CCLabel.setForeground(Color.WHITE);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(430, 10, 89, 23);
		contentPane.add(btnClose);

		CC = new JTextField();
		CC.setBounds(99, 97, 314, 20);
		contentPane.add(CC);
		CC.setColumns(10);

		Password = new JPasswordField();
		Password.setBounds(99, 46, 314, 20);
		contentPane.add(Password);

		JButton BackToMenu = new JButton("");
		BackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		BackToMenu.setBackground(Color.WHITE);
		BackToMenu.setBounds(430, 212, 179, 39);
		contentPane.add(BackToMenu);
		BackToMenu.setIcon(new ImageIcon("Resources\\BackToMenu.png"));
	}

	/*creates a new thread called t1
	 * requires: class Sending to be valid
	 * ensures: that you can use a thread t1 to send the email
	 */
	Thread t1 = new Thread(){
		@SuppressWarnings("static-access")
		public void run() {
			Sending s = new Sending();
			String a = Attatchment.getText();
			if(a.isEmpty()){
				a=" ";
			}
			s.Send(Email.getText(), Password.getText(),  CC.getText(), Where.getText(), Subject.getText() , Message.getText(), Attatchment.getText());
			JOptionPane.showMessageDialog(null, "Your Message has been sent");
		};
	};




	/*creates a new thread called t2
	 * requires: there be an attachment Textfield
	 * ensures: allows you to use this thread to look thorugh files and choose one
	 */
	Thread t2 = new Thread(){
		public void run() {
			JFileChooser jc = new JFileChooser();
	        jc.setDialogType(JFileChooser.OPEN_DIALOG);
	        jc.showDialog(null, "Mail Send");
	        File f =  jc.getSelectedFile() ;
	        Attatchment.setText(f.getAbsolutePath());
		}


		};





}
