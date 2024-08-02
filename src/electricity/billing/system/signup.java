package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class signup extends JFrame implements ActionListener{
	JLabel createaccount,employer,user,name,password,meter;
	JTextField metertext,employertext,usertext,nametext,passwordtext;
	Choice loginasch;
	JButton create,back;
	signup()
	{
		super("Signup Page");
		getContentPane().setBackground(new Color(168,203,251));
		createaccount=new JLabel("Create Account As");
		createaccount.setBounds(30,50,125,20);
		add(createaccount);
		
		loginasch=new Choice();
		loginasch.add("Admin");
		loginasch.add("Customer");
		loginasch.setBounds(170,50,120,20);
		add(loginasch);
		
		employer=new JLabel("Employer ID");
		employer.setBounds(30,100,125,20);
		employer.setVisible(true);
		add(employer);
		
		employertext=new JTextField();
		employertext.setBounds(170,100,125,20);;
		employertext.setVisible(true);
		add(employertext);
		
		meter=new JLabel("Meter Number");
		meter.setBounds(30,100,125,20);
		meter.setVisible(false);
		add(meter);
		
		metertext=new JTextField();
		metertext.setBounds(170,100,125,20);
		metertext.setVisible(false);
		add(metertext);
		
		user=new JLabel("UserName");
		user.setBounds(30,150,125,20);
		add(user);
		
		usertext=new JTextField();
		usertext.setBounds(170,140,125,20);
		add(usertext);
		
		name=new JLabel("Name");
		name.setBounds(30,180,125,20);
		add(name);
		
		nametext=new JTextField("");
		nametext.setBounds(170,180,125,20);
		add(nametext);
		
		metertext.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				try {
					database c=new database();
					ResultSet resultset=c.statement.executeQuery("select*from signup where meter_no='"+metertext.getText()+"'");
					if(resultset.next())
					{
						nametext.setText(resultset.getString("name"));
					}
				}catch(Exception E)
				{
					E.printStackTrace();
				}
			}
			
		});
		
		password=new JLabel("Password");
		password.setBounds(30,220,125,20);
		add(password);
		
		passwordtext=new JTextField();
		passwordtext.setBounds(170,220,125,20);
		add(passwordtext);
		
		loginasch.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String user=loginasch.getSelectedItem();
				if (user.equals("Customer")){
					employer.setVisible(false);
					nametext.setEditable(false);
					employertext.setVisible(false);
					meter.setVisible(true);
					metertext.setVisible(true);
				}else
				{
					meter.setVisible(false);
					metertext.setVisible(false);
					employer.setVisible(true);
					employertext.setVisible(true);
				}
			}
		});
		create=new JButton("Create");
		create.setBackground(new Color(66,217,219));
		create.setForeground(Color.black);
		create.setBounds(50,285,100,25);
		create.addActionListener(this);
		add(create);
		

		back=new JButton("Back");
		back.setBackground(new Color(66,127,219));
		back.setForeground(Color.black);
		back.setBounds(180,285,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon image=new ImageIcon(getClass().getResource("/images/sign-up.png"));
		Image image1=image.getImage().getScaledInstance(250,250, DO_NOTHING_ON_CLOSE);
		ImageIcon image2=new ImageIcon(image1);
		JLabel i=new JLabel(image2);
		i.setBounds(320,30,250,250);
		add(i);
		
		setSize(600,380);
		setLocation(500,200);
		setLayout(null);
		setVisible(true);
	}
	@SuppressWarnings("unlikely-arg-type")
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==create) {
			String sloginas=loginasch.getSelectedItem();
			String smeter=metertext.getText();
			String susername=usertext.getText();
			String sname=nametext.getText();
			String spassword=passwordtext.getText();
			try {
				database c=new database();
				String query=null;
				if(loginasch.equals("Admin"))
				{
				query="insert into signup value('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+sloginas+"')";
				}
				else
				{
					query="update signup set username='"+susername+"',usertype='"+sloginas+"',password='"+spassword+"' where meter_no='"+smeter+"'";
				}
				c.statement.executeUpdate(query);
			    JOptionPane.showMessageDialog(null,"Account Created");
			    setVisible(false);
			    new login();
			}catch(Exception E)
			{
				
			}
		}else if(e.getSource()==back)
		{
			setVisible(false);
			new login();
		}
	}
	public static void main(String a[])
	{
		new signup();
	}
}
