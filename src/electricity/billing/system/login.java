package electricity.billing.system;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class login extends JFrame implements ActionListener{
	JTextField usertext,passwordtext;
	Choice loginchoice;
	JButton loginbutton,cancelbutton,signupbutton;
	login()
	{
		super("login");
		JLabel username=new JLabel("USERNAME");
		username.setBounds(300,60,100,20);
		add(username);
		
		usertext =new JTextField();
		usertext.setBounds(400,60,150,20);
		add(usertext);
		
		JLabel password=new JLabel("PASSWORD");
		password.setBounds(300,100,100,20);
		add(password);
		
		passwordtext=new JTextField();
		passwordtext.setBounds(400,100,150,20);
		add(passwordtext);
		
		JLabel login=new JLabel("LOGIN");
		login.setBounds(300,140,100,20);
		add(login);
		
		loginchoice=new Choice();
		loginchoice.add("Customer");
		loginchoice.add("Admin");
		loginchoice.setBounds(400,140,150,20);
		add(loginchoice);
		
		loginbutton=new JButton("Login");
		loginbutton.setBounds(330,180,100,20);
		loginbutton.addActionListener(this);
		add(loginbutton);
		
		cancelbutton=new JButton("Cancel");
		cancelbutton.setBounds(460,180,100,20);
		cancelbutton.addActionListener(this);
		add(cancelbutton);
		
		signupbutton=new JButton("Signup");
		signupbutton.setBounds(400,215,100,20);
		signupbutton.addActionListener(this);
		add(signupbutton);
		
		ImageIcon image=new ImageIcon(getClass().getResource("/images/login.png"));
		Image image1=image.getImage().getScaledInstance(250, 250, DO_NOTHING_ON_CLOSE);
		ImageIcon image2=new ImageIcon(image1);
		JLabel i=new JLabel(image2);
		i.setBounds(0,0,250,250);
		add(i);
		
		setLocation(400,200);
		setSize(640,300);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==loginbutton)
		{
			String susername=usertext.getText();
			String spassword=passwordtext.getText();
			String suser =loginchoice.getSelectedItem();
			try
			{
				database c=new database();
				String query=null;
				query="select*from signup where username='"+susername+"' and password='"+spassword+"' and usertype='"+suser+"' ";
				ResultSet resultset=c.statement.executeQuery(query);
				if(resultset.next())
				{
					String meter=resultset.getString("meter_no");
					setVisible(false);
					new main_class(suser,meter);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "invalid login");
				}
			}catch(Exception E)
			{
				
			}
		}else if(e.getSource()==cancelbutton)
		{
			setVisible(false);
		}else if(e.getSource()==signupbutton)
		{
			setVisible(false);
			new signup();
		}
	}
	public static void main(String a[])
	{
		new login();
	}
}
