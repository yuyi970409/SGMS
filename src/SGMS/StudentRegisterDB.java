package SGMS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentRegisterDB extends ConnDB implements ActionListener{
	JTextField sno1;
	JPasswordField pw1,pw2;
	JButton button;
	
	public void setsno(JTextField a) {
		sno1 = a;
	}

	public void setpw1(JPasswordField m,JPasswordField n) {
		pw1 = n;
		pw2 = m;
	}
	
	public void setbutton(JButton b) {
		button = b;
	}
	
	public void actionPerformed(ActionEvent e) {
		String sno = sno1.getText();
		char[] pword1 = pw1.getPassword();
		String pword2 = new String(pword1);
		char[] pword3 = pw2.getPassword();
		String pword4 = new String(pword3);
		if(e.getSource() == button) {
			if (sno.equals("")) 
				JOptionPane.showMessageDialog(null, "请输入学号！");
			else if (pword2.equals("")||pword4.equals(""))
				JOptionPane.showMessageDialog(null, "请输入密码！");
			else if(!(pword2).equals(pword4)) {
				JOptionPane.showMessageDialog(null, "请确认密码！");
				pw1.setText("");
				pw2.setText("");
			}
			else if(pword2.length()<6) {
				JOptionPane.showMessageDialog(null, "密码应大于6位");
				pw1.setText("");
				pw2.setText("");
			}
			else if(validate(sno)) {
				JOptionPane.showMessageDialog(null, "学号已存在");
				sno1.setText("");
				pw1.setText("");
				pw2.setText("");
			}
			else {
				String sno2 = sno1.getText();
				char[] password=pw1.getPassword();
				String jpassword = new String(password);
				try {
				connection(); 
				writesql(sno2,jpassword);
				JOptionPane.showMessageDialog(null, "注册成功");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
	}
	
	private boolean validate(String sno)       
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

	void writesql(String sno2,String jpassword) throws Exception{   
		connection();        
		String sql="insert ignore into student (sno,password) values (?,?)";
        try {
        		PreparedStatement preStmt=con.prepareStatement(sql);  
            preStmt.setString(1,sno2);  
            preStmt.setString(2,jpassword);  
            preStmt.executeUpdate();
            con.close();
        }catch (Exception e1) {  
            e1.printStackTrace();  
        } 
	} 
}
