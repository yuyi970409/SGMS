package SGMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Add extends ConnDB{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
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
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 296, 391);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("添加学生成绩");
		lblNewLabel.setBounds(90, 33, 111, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("学号：");
		label.setBounds(26, 103, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setBounds(26, 131, 61, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("班级：");
		label_2.setBounds(26, 159, 61, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("课程号：");
		label_3.setBounds(26, 187, 61, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("成绩：");
		label_4.setBounds(26, 215, 61, 16);
		frame.getContentPane().add(label_4);
		
		textField = new JTextField();
		textField.setBounds(104, 98, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 126, 130, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(104, 154, 130, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(104, 182, 130, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(104, 210, 130, 26);
		frame.getContentPane().add(textField_4);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = textField.getText();
				String sname = textField_1.getText();
				String sclass = textField_2.getText();
				String cno = textField_3.getText();
				String grade = textField_4.getText();
				String sql1 ="insert into student(sno,sname,sclass,password) values('"+sno+"','"+sname+"','"+sclass+"','')";
				String sql2 ="insert into grade(sno,cno,grade) values('"+sno+"','"+cno+"','"+grade+"')";

				if(validate1(sno)) {
					if(validate2(cno)) {
					try {
						connection();
						Statement stmt = con.createStatement();
						int row = stmt.executeUpdate(sql2);
						if (row==1) {
							JOptionPane.showMessageDialog(null,"添加成功");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");	
						}
//							else {
//								JOptionPane.showMessageDialog(null, "失败，请重新输入");
//								textField.setText("");
//								textField_1.setText("");
//								textField_2.setText("");
//								textField_3.setText("");
//								textField_4.setText("");								
//							}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "记录存在，请重新输入");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");	
					}
				}else {
					try {
						connection();
						Statement stmt1 = con.createStatement();
						int row = stmt1.executeUpdate(sql1);
						if(row == 1) {
							Statement stmt2 = con.createStatement();
							int row1 = stmt2.executeUpdate(sql2);
							if(row1 == 1) {
								JOptionPane.showMessageDialog(null,"添加成功");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");	
							}else {
								JOptionPane.showMessageDialog(null, "失败，请重新输入");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");		
								}
							}
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		button.setBounds(26, 293, 117, 53);
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
		button_1.setBounds(155, 293, 117, 53);
		frame.getContentPane().add(button_1);
	}
	
	private boolean validate1(String sno)       
    {  
        String sql="select *from student where sno='"+sno+"'";  
        try {
        	connection();
		Statement stmt = con.createStatement();
		ResultSet rs1 = stmt.executeQuery(sql);
		
		if (rs1.next()){  
			return true; 
			}  
		con.close();
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return false;  
    }
	
	private boolean validate2(String cno)       
    {  
        String sql="select *from course where cno='"+cno+"'";  
        try {
        	connection();
		Statement stmt = con.createStatement();
		ResultSet rs1 = stmt.executeQuery(sql);
		
		if (rs1.next()){  
			return true; 
			}  
		con.close();
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return false;  
    }
	
}
