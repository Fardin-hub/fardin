package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class paybill extends JFrame implements ActionListener{
	String meter;
	JButton pay,back;
	Choice monthcho;
	paybill(String meter)
	{
		this.meter=meter;
		setSize(900,600);
		setLocation(300,150);
		setLayout(null);
		
		JLabel heading=new JLabel("Pay BIlls");
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		heading.setBounds(120,5,400,30);
		add(heading);
		
		JLabel meternumber=new JLabel("Meter Number");
		meternumber.setBounds(35,80,200,20);
		add(meternumber);
		
		JTextField meternumbertext=new JTextField("");
		meternumbertext.setBounds(300,80,200,20);
		add(meternumbertext);
		
		JLabel name=new JLabel("Name");
		name.setBounds(35,140,200,20);
		add(name);
		
		JTextField nametext=new JTextField("");
		nametext.setBounds(300,140,200,20);
		add(nametext);
		
		JLabel month=new JLabel("Month");
		month.setBounds(35,200,200,20);
		add(month);
		
		monthcho=new Choice();
		monthcho.add("January");
		monthcho.add("February");
		monthcho.add("March");
		monthcho.add("April");
		monthcho.add("May");
		monthcho.add("June");
		monthcho.add("July");
		monthcho.add("August");
		monthcho.add("September");
		monthcho.add("October");
		monthcho.add("November");
		monthcho.add("December");
		monthcho.setBounds(300,200,200,20);
		add(monthcho);
		
		JLabel unit=new JLabel("Unit");
		unit.setBounds(35,260,200,20);
		add(unit);
		
		JTextField unittext=new JTextField("");
		unittext.setBounds(300,260,200,20);
		add(unittext);
		
		JLabel totalbill=new JLabel("Total Bill");
		totalbill.setBounds(35,320,200,20);
		add(totalbill);
		
		JTextField totalbilltext=new JTextField("");
		totalbilltext.setBounds(300,320,200,20);
		add(totalbilltext);
		
		JLabel status=new JLabel("Status");
		status.setBounds(35,380,200,20);
		add(status);
		
		JTextField statustext=new JTextField("");
		statustext.setBounds(300,380,200,20);
		status.setForeground(Color.red);
		add(statustext);
		
		try {
			database c=new database();
			ResultSet resultset =c.statement.executeQuery("select*from new_customer where meter_no='"+meter+"'");
			while(resultset.next())
			{
				meternumbertext.setText(meter);
				nametext.setText(resultset.getString("name"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		monthcho.addItemListener(new ItemListener()	{

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					database c=new database();
					ResultSet resultset=c.statement.executeQuery("select*from bill where meter_no='"+meter+"' and month='"+monthcho.getSelectedItem()+"'");
					while(resultset.next())
					{
						unittext.setText(resultset.getString("unit"));
						statustext.setText(resultset.getString("status"));
						totalbilltext.setText(resultset.getString("total_bill"));
					}
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		});
		
	    pay=new JButton("Pay");
		pay.setBackground(Color.black);
		pay.setForeground(Color.white);
		pay.setBounds(100,460,100,25);
		pay.addActionListener(this);
		add(pay);
		
	    back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(230,460,100,25);
		back.addActionListener(this);
		add(back);
		
		setVisible(true);
	}
	public static void main(String a[])
	{
		new paybill("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pay)
		{
			try {
				database c=new database();
				c.statement.executeUpdate("update bill set status='Paid' where meter_no='"+meter+"' and month='"+monthcho.getSelectedItem()+"'");
				
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			setVisible(false);
			new paymentbill(meter);
		}
		else
		{
			setVisible(false);
		}
	}
}
