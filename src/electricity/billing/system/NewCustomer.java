package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class NewCustomer extends JFrame implements ActionListener{
	JLabel heading,meternumber,customername,meternum,metertext,address,city,phone,state,email;
	JTextField nametext,addresstext,citytext,statetext,emailtext,phonetext;
	JButton next,cancel;
	NewCustomer()
	{
		super("New Customer");
		setSize(700,500);
		setLocation(400,200);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(252,186,3));;
		add(panel);
		
		heading=new JLabel("New Customer");
		heading.setFont(new Font("tahoma",Font.BOLD,15));
		heading.setBounds(180,10,200,20);
		panel.add(heading);
		

		customername=new JLabel("New Customer");
		customername.setBounds(50,80,100,20);
		panel.add(customername);
		
		nametext=new JTextField();
		nametext.setBounds(180,80,150,20);
		panel.add(nametext);
		
		meternum=new JLabel("Meter Name");
		meternum.setBounds(50,120,100,20);
		panel.add(meternum);
		
	    metertext=new JLabel();
		metertext.setBounds(180,120,150,20);
		panel.add(metertext);
		
		Random ran=new Random();
		long number=ran.nextLong() % 1000000;
		metertext.setText(""+ Math.abs(number));
		
		address=new JLabel("Address");
		address.setBounds(50,160,100,20);
		panel.add(address);
		
		addresstext=new JTextField();
		addresstext.setBounds(180,160,150,20);
		panel.add(addresstext);
		
		city=new JLabel("City");
		city.setBounds(50,200,100,20);
		panel.add(city);
		
		citytext=new JTextField();
		citytext.setBounds(180,200,150,20);
		panel.add(citytext);
		
		state=new JLabel("State");
		state.setBounds(50,240,100,20);
		panel.add(state);
		
		statetext=new JTextField();
		statetext.setBounds(180,240,150,20);
		panel.add(statetext);
		
		email=new JLabel("email");
		email.setBounds(50,280,100,20);
		panel.add(email);
		
		emailtext=new JTextField();
		emailtext.setBounds(180,280,150,20);
		panel.add(emailtext);
		
		phone=new JLabel("Phone");
		phone.setBounds(50,320,100,20);
		panel.add(phone);
		
		phonetext=new JTextField();
		phonetext.setBounds(180,320,150,20);
		panel.add(phonetext);
		
		next=new JButton("NEXT");
		next.setBounds(120,390,100,25);
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.addActionListener(this);
		panel.add(next);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(230,390,100,25);
		cancel.addActionListener(this);
		panel.add(cancel);
		
		setLayout(new BorderLayout());
		add(panel,"Center");
		ImageIcon i1=new ImageIcon(getClass().getResource("/images/boy.png"));
		Image i2=i1.getImage().getScaledInstance(230, 200, DO_NOTHING_ON_CLOSE);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image,"West");
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent E)
	{
		if(E.getSource()==next)
		{
			String sname=nametext.getText();
			String smeter=metertext.getText();
			String saddress=addresstext.getText();
			String scity=citytext.getText();
			String sstate=statetext.getText();
			String eemail=emailtext.getText();
			String sphone=phonetext.getText();
			
			String query_customer="insert into new_customer values('"+sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+sstate+"','"+eemail+"','"+sphone+"')";
			String query_signup="insert into signup values('"+smeter+"','','"+sname+"','','')";
			
			try {
				database c=new database();
				c.statement.executeUpdate(query_customer);
				c.statement.executeUpdate(query_signup);
				
				JOptionPane.showMessageDialog(null,"customer details addded successfully");
				setVisible(false);
				new meterinfo(smeter);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String a[])
	{
		new NewCustomer();
	}
}
	
