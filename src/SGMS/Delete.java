package SGMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Delete extends ConnDB{

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
					Delete window = new Delete();
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
	public Delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 292, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("删除");
		label.setBounds(111, 25, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("学号：");
		label_1.setBounds(18, 69, 61, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("课程号：");
		label_2.setBounds(18, 128, 61, 16);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(87, 64, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 123, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = textField.getText();
				String cno = textField_1.getText();
				String sql ="select * from grade where sno='"+sno+"' and cno = '"+cno+"'";

				try {
					connection();
					Statement stmt = con.createStatement();
					ResultSet rs1 = stmt.executeQuery(sql);
					if (rs1.next()) {
						int rs2 = stmt.executeUpdate("delete from grade where sno='"+sno+"' and cno = '"+cno+"'");
						if(rs2==1)
						JOptionPane.showMessageDialog(null,"删除成功");
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
		button.setBounds(6, 198, 117, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					new Manager("select student.sno,student.sname,student.sclass,course.cno,course.cname,grade.grade "
							+ "from student,course,grade where student.sno=grade.sno and course.cno=grade.cno ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(135, 198, 117, 29);
		frame.getContentPane().add(button_1);
		frame.setVisible(true);

	}

}
