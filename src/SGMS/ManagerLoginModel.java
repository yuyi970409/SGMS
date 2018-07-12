package SGMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerLoginModel {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	ManagerLoginDB mld;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLoginModel window = new ManagerLoginModel();
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
	public ManagerLoginModel() {
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
		frame.setTitle("管理员登陆");
		mld = new ManagerLoginDB();
		
		JLabel lblNewLabel = new JLabel("管理员登陆");
		lblNewLabel.setFont(new Font("Arial Hebrew", Font.BOLD, 33));
		lblNewLabel.setBounds(70, 35, 182, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("管理员号：");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(16, 129, 117, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" 密    码 ：");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(16, 197, 117, 43);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(118, 125, 182, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(20);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 197, 182, 40);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(20);
		
		JButton button = new JButton("登陆");
		button.setBounds(16, 259, 117, 43);
		frame.getContentPane().add(button);
		button.addActionListener(mld);
		
		mld.setmno(textField);
		mld.setpw(passwordField);
		mld.setButton(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(183, 259, 117, 43);
		frame.getContentPane().add(button_1);
	}
}
