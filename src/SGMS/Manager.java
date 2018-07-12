package SGMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import java.awt.Font;
import javax.swing.JButton;

import java.sql.PreparedStatement;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class Manager extends ConnDB{

	private JFrame frame;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTextField textField;
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane; 
	
	Object head[] = {"学号","姓名","班级","课程号","课程名","成绩"};
	Object info[][] =new Object[100][6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String sql = "select student.sno,student.sname,student.sclass,course.cno,course.cname,grade.grade "
							+ "from student,course,grade where student.sno=grade.sno and course.cno=grade.cno ";
					Manager window = new Manager(sql);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Manager(String sql) throws SQLException {
		initialize(sql);
	}


	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize(String sql) throws SQLException{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 410);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        int i = 0;
        try {
        		connection();
        		PreparedStatement ps=con.prepareStatement(sql);
        		ResultSet rs=ps.executeQuery();
        		while(rs.next()){
				info[i][0]=rs.getString(1);
				info[i][1]=rs.getString(2);
				info[i][2]=rs.getString(3);
				info[i][3]=rs.getString(4);
				info[i][4]=rs.getString(5);
				info[i][5]=rs.getString(6);
				i++;
				}
        		con.close();
        		}catch(Exception e1) {
        			e1.printStackTrace();
        			}
        table =new JTable(info,head);
        
        scrollPane = new JScrollPane(table);        
        contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
        contentPane.add(scrollPane);
        contentPane.setBounds(6, 6, 438, 229);
        frame.getContentPane().add(contentPane);
        
        JButton button_1 = new JButton("添加");
        button_1.setBounds(155, 338, 140, 40);
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Add();
        	}
        });
        frame.getContentPane().add(button_1);
        
        JButton button_2 = new JButton("修改");
        button_2.setBounds(304, 338, 140, 40);
        button_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Modify();
        	}
        });
        frame.getContentPane().add(button_2);
        
        textField = new JTextField();
        textField.setBounds(1, 275, 189, 40);
        frame.getContentPane().add(textField);
        textField.setColumns(20);
        
        JButton button_3 = new JButton("查询");
        button_3.setBounds(202, 275, 117, 40);
        button_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String text = textField.getText();
        		try {
					new Manager("select student.sno,student.sname,student.sclass,course.cno,course.cname,grade.grade "
							+ "from student,course,grade "
							+ "where student.sno=grade.sno and course.cno=grade.cno and (student.sno like '%"+text+"%' or student.sname like '%"+text+"%' "
									+ "or student.sclass like '%"+text+"%' or course.cno like '%"+text+"%' or course.cname like '%"+text+"%' )");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}		
        });
        frame.getContentPane().add(button_3);
        
        JButton button_4 = new JButton("删除");
        button_4.setBounds(6, 338, 140, 40);
        button_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();

        		new Delete();
        		       }
        });
        frame.getContentPane().add(button_4);
        
        JButton button_5 = new JButton("刷新");
        button_5.setBounds(331, 275, 113, 40);
        button_5.addActionListener(new ActionListener() {
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
        frame.getContentPane().add(button_5);
       
        }
}
