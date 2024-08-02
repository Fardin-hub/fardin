package electricity.billing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class updateinformation extends JFrame implements ActionListener{
	String meter;
	JLabel nametext;
	JTextField addresstext,citytext,statetext,emailtext,phonetext;
	JButton update,cancel;
	updateinformation(String meter)
	{
		this.meter=meter;
		setBounds(400,150,777,450);
		getContentPane().setBackground(new Color(229,255,227));
		
		JLabel heading =new JLabel("Update Customer Information");
		heading.setBounds(50,10,400,40);
		heading.setFont(new Font("Sherif",Font.BOLD,20));
		add(heading);
		
		JLabel name=new JLabel("Name");
		name.setBounds(30,70,100,20);
		add(name);
		
		nametext=new JLabel("");
		nametext.setBounds(150,70,200,20);
		add(nametext);
		
		JLabel meterno=new JLabel("Meter No");
		meterno.setBounds(30,110,100,20);
		add(meterno);
		
		JLabel metertext=new JLabel("");
		metertext.setBounds(150,110,200,20);
		add(metertext);
		
		JLabel address=new JLabel("Address");
		address.setBounds(30,150,100,20);
		add(address);
		
		addresstext=new JTextField();
		addresstext.setBounds(150,150,200,20);
		add(addresstext);
		
		JLabel city=new JLabel("City");
		city.setBounds(30,190,100,20);
		add(city);
		
		citytext=new JTextField();
		citytext.setBounds(150,190,200,20);
		add(citytext);
		
		
		JLabel state=new JLabel("State");
		state.setBounds(30,230,100,20);
		add(state);
		
		statetext=new JTextField();
		statetext.setBounds(150,230,200,20);
		add(statetext);
		
		JLabel email=new JLabel("Email Id");
		email.setBounds(30,270,100,20);
		add(email);
		
		emailtext=new JTextField();
		emailtext.setBounds(150,270,200,20);
		add(emailtext);
		
		JLabel phone=new JLabel("Phone");
		phone.setBounds(30,310,100,20);
		add(phone);
		
		phonetext=new JTextField();
		phonetext.setBounds(150,310,200,20);
		add(phonetext);
		
		try {
			database c=new database();
			ResultSet resultset =c.statement.executeQuery("select*from new_customer where meter_no='"+meter+"'");
			if(resultset.next())
			{
				nametext.setText(resultset.getString("name"));
				metertext.setText(resultset.getString("meter_no"));
				addresstext.setText(resultset.getString("address"));
				citytext.setText(resultset.getString("city"));
				statetext.setText(resultset.getString("state"));
				emailtext.setText(resultset.getString("email"));
				phonetext.setText(resultset.getString("phone"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		update=new JButton("Update");
		update.setBounds(200,360,120,25);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(200,360,120,25);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(getClass().getResource("/images/update.png"));
		Image i2=i1.getImage().getScaledInstance(400, 410, DO_NOTHING_ON_CLOSE);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(360,0,400,410);
		add(image);
		
		setLayout(null);
		setVisible(true);
	}
	public static void main(String a[])
	{
		new updateinformation("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==update)
		{
			String saddress=addresstext.getText();
			String semail=emailtext.getText();
			String scity=citytext.getText();
			String sstate=statetext.getText();
			String sphone=phonetext.getText();
			
			try {
				database c=new database();
				c.statement.executeUpdate("update new_customer set address='"+saddress+"',city='"+scity+"',state='"+sstate+"',email='"+semail+"',phone='"+sphone+"'");
				JOptionPane.showMessageDialog(null,"User Information Updated");
				setVisible(false);
			}catch(Exception k)
			{
				k.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
		}
	}
}
