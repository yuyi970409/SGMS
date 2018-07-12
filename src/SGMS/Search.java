//package SGMS;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JTable;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class Search extends ConnDB {
//
//	private JFrame frame;
//	private JTextField textField;
//	private DefaultTableModel tableModel = new DefaultTableModel();
//	private JTable table;
//	private JPanel contentPane;
//	private JScrollPane scrollPane; 
//	
//	Object head[] = {"学号","姓名","班级","课程号","课程名","成绩"};
// 	Object info[][] =new Object[100][6];
//	
//	
//	private JButton button;
//	private JButton button_1;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Search window = new Search();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public Search() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		JLabel label = new JLabel("查询:");
//		label.setBounds(57, 41, 61, 16);
//		frame.getContentPane().add(label);
//		
//		textField = new JTextField();
//		textField.setBounds(134, 36, 130, 26);
//		frame.getContentPane().add(textField);
//		textField.setColumns(20);
//		
//		scrollPane = new JScrollPane(table);        
//        contentPane = new JPanel();
//		contentPane.setLayout(new BorderLayout());
//        contentPane.add(scrollPane);
//        contentPane.setBounds(6, 70, 438, 200);
//        frame.getContentPane().add(contentPane);        
//
//        button = new JButton("确定");
//        button.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//                int i = 0;
//                String text = textField.getText();
//				String sql ="select student.sno,student.sname,student.sclass,course.cno,course.cname,grade.grade "
//						+ "from student,course,grade "
//						+ "where student.sno=grade.sno and course.cno=grade.cno and student.sno = '"+text+"'";
//				System.out.println(text);
//        		try {
//            		connection();
//				
//            		Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);
//
//            		while(rs.next()){
//    				info[i][0]=rs.getString(1);
//
//    				info[i][1]=rs.getString(2);
//    				info[i][2]=rs.getString(3);
//    				info[i][3]=rs.getString(4);
//            		System.out.println(rs.getString(4));
//
//    				info[i][4]=rs.getString(5);
//    				info[i][5]=rs.getString(6);
//    				i++;
//    				}
//            		frame.repaint();
//            		
//            		con.close();
//
//            		}catch(Exception e1) {
//            			e1.printStackTrace();
//            			}
//            table =new JTable(info,head);
//        	}
//        });
//        button.setBounds(276, 36, 85, 29);
//        frame.getContentPane().add(button);
//        
//        button_1 = new JButton("返回");
//        button_1.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        		frame.dispose();
//        		try {
//			//		new Manager();
//	//			} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//		//			e1.printStackTrace();
//		//		}
//        	}
//        });
//        button_1.setBounds(359, 36, 85, 29);
//        frame.getContentPane().add(button_1);
//        
//        
//	}
//
//}
