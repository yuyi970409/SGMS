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

public class ModifyStudent extends ConnDB{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyStudent window = new ModifyStudent();
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
	public ModifyStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 230, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改学生信息");
		lblNewLabel.setBounds(57, 38, 86, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("学号：");
		label.setBounds(6, 87, 86, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setBounds(6, 130, 86, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("班级：");
		label_2.setBounds(6, 168, 86, 16);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(78, 82, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 125, 130, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 163, 130, 26);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = textField.getText();
				String sname = textField_1.getText();
				String sclass = textField_2.getText();
				String sql ="select * from student where sno='"+sno+"'";
				
				try {
					connection();
					Statement stmt = con.createStatement();
					ResultSet rs1 = stmt.executeQuery(sql);
					if (rs1.next()) {
						int rs2 = stmt.executeUpdate("update student set sname = '"+sname+"' , sclass = '"+sclass+"'  where sno='"+sno+"' ");
						if(rs2==1)
						JOptionPane.showMessageDialog(null,"修改成功");
					}

						else {
							JOptionPane.showMessageDialog(null, "记录不存在，请重新输入");
							textField.setText("");
							textField_1.setText("");		
							textField_2.setText("");							

						}
					

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(6, 218, 86, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Modify();
			}
		});
		button.setBounds(122, 218, 86, 29);
		frame.getContentPane().add(button);
	}

}
