package SGMS;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentLoginModel {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	StudentLoginDB sld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLoginModel window = new StudentLoginModel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentLoginModel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 318, 356);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("学生登陆");
		sld = new StudentLoginDB();
		
		JLabel lblNewLabel = new JLabel("学生登陆");
		lblNewLabel.setFont(new Font("Arial Hebrew", Font.BOLD, 33));
		lblNewLabel.setBounds(85, 35, 145, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("学  号：");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(16, 129, 88, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密  码：");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(16, 197, 88, 43);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(100, 120, 200, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(20);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 197, 200, 40);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(20);
		
		JButton button = new JButton("登陆");
		button.setBounds(16, 259, 117, 43);
		frame.getContentPane().add(button);
		button.addActionListener(sld);
		
		JButton button_1 = new JButton("注册");
		button_1.addActionListener(sld);
		button_1.setBounds(183, 259, 117, 43);
		frame.getContentPane().add(button_1);
		
		sld.setsid(textField);
		sld.setpw(passwordField);
		sld.setButton(button, button_1);
	}

}
