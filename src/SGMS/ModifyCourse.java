package SGMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ModifyCourse extends ConnDB{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyCourse window = new ModifyCourse();
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
	public ModifyCourse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 245, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("修改课程");
		label.setBounds(85, 33, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("课程号：");
		label_1.setBounds(20, 95, 61, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("课程名：");
		label_2.setBounds(20, 136, 61, 16);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(85, 90, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 131, 130, 26);
		frame.getContentPane().add(textField_1);
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cno = textField.getText();
				String cname = textField_1.getText();
				String sql ="select * from course where cno='"+cno+"'";
				
				try {
					connection();
					Statement stmt = con.createStatement();
					ResultSet rs1 = stmt.executeQuery(sql);
					if (rs1.next()) {
						int rs2 = stmt.executeUpdate("update course set cname = '"+cname+"' where cno='"+cno+"' ");
						if(rs2==1)
						JOptionPane.showMessageDialog(null,"修改成功");
					}

						else {
							JOptionPane.showMessageDialog(null, "记录不存在，请重新输入");
							textField.setText("");
							textField_1.setText("");		

						}
					

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(6, 207, 117, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Modify();
			}
		});
		button_1.setBounds(122, 207, 117, 29);
		frame.getContentPane().add(button_1);
	}
}
