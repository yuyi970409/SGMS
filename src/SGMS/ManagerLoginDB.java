package SGMS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ManagerLoginDB extends ConnDB implements ActionListener{
	JTextField mno1;
	JPasswordField pw;
	JButton button;
	
	public void setmno(JTextField a) {
		mno1 = a;
	}

	public void setpw(JPasswordField n) {
		pw = n;
	}
	
	public void setButton(JButton b1) {
		button = b1;
	}
	
	public void actionPerformed(ActionEvent e) {
		String mno = mno1.getText();
		char[] pw1 = pw.getPassword();
		String pw2 = new String(pw1);
		if(e.getSource() == button) {
			if (mno.equals("")) 
				JOptionPane.showMessageDialog(null, "请输入管理员号！");
			else if (pw2.equals(""))
				JOptionPane.showMessageDialog(null, "请输入密码！");
			else {
				String sql = "select * from manager where mno='" + mno + "'";
				try {
					connection();
					Statement stmt = con.createStatement();
					ResultSet rs1 = stmt.executeQuery(sql);
					if (rs1.next()) {
						if (rs1.getString("password").equals(pw2)) {
							new Manager("select student.sno,student.sname,student.sclass,course.cno,course.cname,grade.grade "
									+ "from student,course,grade where student.sno=grade.sno and course.cno=grade.cno ");
				            System.out.println("成功");   
						}
						else {
							JOptionPane.showMessageDialog(null, "密码输入错误");
							mno1.setText("");
							pw.setText("");
						}
					} else {
						JOptionPane.showMessageDialog(null, "管理员不存在");
						mno1.setText("");
						pw.setText("");
					}
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}