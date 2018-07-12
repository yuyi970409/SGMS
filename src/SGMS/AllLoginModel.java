package SGMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllLoginModel {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllLoginModel window = new AllLoginModel();
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
	public AllLoginModel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 417, 270);
		frame.setTitle("学生成绩管理系统");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("学生成绩管理系统");
		label.setFont(new Font("Al Bayan", Font.BOLD, 39));
		label.setBounds(52, 42, 318, 77);
		frame.getContentPane().add(label);
		
		JButton Button = new JButton("管理员登陆");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerLoginModel();
				frame.dispose();
			}
		});
		Button.setBounds(39, 164, 147, 51);
		frame.getContentPane().add(Button);
		
		JButton button_1 = new JButton("学生登陆");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentLoginModel();
				frame.dispose();
			}
		});
		button_1.setBounds(235, 164, 147, 51);
		frame.getContentPane().add(button_1);
	}
}
