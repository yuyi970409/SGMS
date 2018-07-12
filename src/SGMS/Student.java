package SGMS;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;


import java.awt.Font;
import javax.swing.JButton;

import java.sql.PreparedStatement;
import java.awt.event.*;
import java.sql.SQLException;

public class Student extends ConnDB{

	private JFrame frame;
	private JTable table;
	private String sno1;
	private DefaultTableModel tableModel = new DefaultTableModel();
	static String head[] = {"课程号","课程名","成绩"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String sno) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student(sno);
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
	public Student(String sno) throws SQLException {
		sno1=sno;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize () throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 249, 342);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("学号：");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(39, 20, 51, 28);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_1.setBounds(39, 45, 51, 28);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("班级：");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_2.setBounds(39, 70, 51, 28);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(90, 20, 110, 28);
		frame.getContentPane().add(label_3);
		label_3.setText(sno1);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(90, 45, 110, 28);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(90, 70, 110, 28);
		frame.getContentPane().add(label_5);
		
		String sname1 = null,sclass1 = null;
		String sql = "select sname,sclass from student where sno='" + sno1 + "'";
		try {
			connection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				sname1 = rs.getString("sname");
				sclass1 = rs.getString("sclass");
				}
			con.close();
			} catch (Exception e1) {
				e1.printStackTrace();
				}
		label_4.setText(sname1);
		label_5.setText(sclass1);
	
		table = new JTable();
		table.setBounds(39, 126, 151, 132);
		frame.getContentPane().add(table);
		table.setModel(tableModel);
        table.setEnabled(false);
        tableModel.setColumnIdentifiers(head);
        
        try {
        		connection();
        		PreparedStatement ps=con.prepareStatement("select grade.cno,grade.grade,course.cname from grade,course where sno='"+sno1+"' and grade.cno=course.cno");
        		ResultSet rs=ps.executeQuery();
        		while(rs.next()){
        			String data[]=new String[3];
        			data[0]=rs.getString(1);
        			data[1]=rs.getString(3);
        			data[2]=rs.getString(2);
        			tableModel.addRow(data);	
        		}
        		con.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		JButton button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		button.setBounds(49, 270, 123, 37);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("课程号");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel.setBounds(39, 108, 51, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_6 = new JLabel("课程名");
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		label_6.setBounds(90, 108, 51, 16);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("成绩");		
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		label_7.setBounds(141, 108, 39, 15);
		frame.getContentPane().add(label_7);
	}
}
