package SGMS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentLoginDB extends ConnDB implements ActionListener{
	JTextField sno1;
	JPasswordField pw;
	JButton button,button_1;
	StudentRegisterModel srm;
	
	public void setsid(JTextField a) {
		sno1 = a;
	}

	public void setpw(JPasswordField n) {
		pw = n;
	}
	
	public void setButton(JButton b1,JButton b2) {
		button = b1;
		button_1 = b2;
	}
	
	public void actionPerformed(ActionEvent e) {
		String sno = sno1.getText();
		char[] pw1 = pw.getPassword();
		String pw2 = new String(pw1);
		if(e.getSource() == button) {
			if (sno.equals("")) 
				JOptionPane.showMessageDialog(null, "请输入学号！");
			else if (pw2.equals(""))
				JOptionPane.showMessageDialog(null, "请输入密码！");
			else {
				String sql = "select * from student where sno='" + sno + "'";
				try {
					connection();
					Statement stmt = con.createStatement();
					ResultSet rs1 = stmt.executeQuery(sql);
					if (rs1.next()) {
						if (rs1.getString("password").equals(pw2)) {
							new Student(sno);
				            System.out.println("成功");
						}
						else {
							JOptionPane.showMessageDialog(null, "密码输入错误");
							sno1.setText("");
							pw.setText("");
						}
					} else {
						JOptionPane.showMessageDialog(null, "学号不存在");
						sno1.setText("");
						pw.setText("");
					}
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}else if (e.getSource() == button_1)

		{
			new JFrame().dispose();
			srm = new StudentRegisterModel();
		}
	}
}
