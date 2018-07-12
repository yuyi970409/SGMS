package SGMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class StudentRegisterModel {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	StudentRegisterDB srd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegisterModel window = new StudentRegisterModel();
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
	public StudentRegisterModel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 316, 390);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		srd = new StudentRegisterDB();
		
		JLabel label = new JLabel("学生注册");
		label.setFont(new Font("Arial Hebrew", Font.BOLD, 33));
		label.setBounds(91, 34, 132, 46);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("学    号:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(16, 105, 100, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密    码:");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(16, 167, 100, 43);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("确认密码:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(6, 232, 100, 43);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(100, 110, 200, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(20);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 172, 200, 40);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(20);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(100, 235, 200, 40);
		frame.getContentPane().add(passwordField_1);
		passwordField_1.setColumns(20);
		
		JButton button = new JButton("注册");
		button.setBounds(16, 297, 117, 51);
		frame.getContentPane().add(button);
		button.addActionListener(srd);
		srd.setsno(textField);
		srd.setbutton(button);
		srd.setpw1(passwordField, passwordField_1);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new StudentLoginModel();
			}
		});
		button_1.setBounds(183, 297, 117, 51);
		frame.getContentPane().add(button_1);
	}
}
