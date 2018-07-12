package SGMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Modify {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify window = new Modify();
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
	public Modify() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 219, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("修改学生信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ModifyStudent();
			}
		});
		button.setBounds(47, 51, 117, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("修改课程信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

				new ModifyCourse();

			}
		});
		button_1.setBounds(47, 111, 117, 29);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("修改成绩");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

				new ModifyGrade();
			}
		});
		button_2.setBounds(47, 172, 117, 29);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Manager("select student.sno,student.sname,student.sclass,course.cno,course.cname,grade.grade "
							+ "from student,course,grade where student.sno=grade.sno and course.cno=grade.cno ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(47, 225, 117, 29);
		frame.getContentPane().add(button_3);
	}
}
