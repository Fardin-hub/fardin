package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class calculate_bill extends JFrame implements ActionListener{
	JLabel name,address,unitconsumed,month;
	JTextField nametext,addresstext,monthtext,unittext;
	Choice meternumcho,monthcho;
	JButton submit,cancel;
	calculate_bill()
	{
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(214,195,247));
		add(panel);
		
		JLabel heading=new JLabel("Calculate Electricity Bill");
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		heading.setBounds(70,10,300,20);
		panel.add(heading);
		
		JLabel meternum=new JLabel("Meter Num");
		meternum.setBounds(50,80,100,20);
		panel.add(meternum);
		
		meternumcho=new Choice();
		try {
			database c=new database();
			ResultSet resultset=c.statement.executeQuery("select*from new_customer");
			while(resultset.next())
			{
				meternumcho.add(resultset.getString("meter_no"));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		meternumcho.setBounds(180,80,150,20);
		panel.add(meternumcho);
		
		name=new JLabel("Name");
		name.setBounds(50,120,100,20);
		panel.add(name);
		
		nametext=new JTextField();
		nametext.setBounds(180,120,150,20);
		panel.add(nametext);
		
		address=new JLabel("Address");
		address.setBounds(50,160,100,20);
		panel.add(address);
		
		addresstext=new JTextField();
		addresstext.setBounds(180,160,150,20);
		panel.add(addresstext);
		
		try {
			database c=new database();
			ResultSet resultset=c.statement.executeQuery("select*from new_customer where meter_no='"+meternumcho.getSelectedItem()+"'");
			while(resultset.next())
			{
				nametext.setText(resultset.getString("name"));
				addresstext.setText(resultset.getString("address"));
			}
		}catch(Exception E)
		{
			E.printStackTrace();
		}
		meternumcho.addItemListener(new ItemListener()
				{
			public void itemStateChanged(ItemEvent e) {
				
				try {
					database c=new database();
					ResultSet resultset=c.statement.executeQuery("select*from new_customer where meter_no='"+meternumcho.getSelectedItem()+"'");
					while(resultset.next())
					{
						nametext.setText(resultset.getString("name"));
						addresstext.setText(resultset.getString("address"));
					}
				}catch(Exception E)
				{
					E.printStackTrace();
				}
			}
				});
		
		unitconsumed=new JLabel("Unit Consumed");
		unitconsumed.setBounds(50,200,100,20);
		panel.add(unitconsumed);
		
		unittext=new JTextField();
		unittext.setBounds(180,200,150,20);
		panel.add(unittext);
		
		month=new JLabel("Month");
		month.setBounds(50,240,100,20);
		panel.add(month);
		
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
		monthcho.setBounds(180,240,150,20);
		panel.add(monthcho);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(80,300,100,25);
		submit.addActionListener(this);
		panel.add(submit);
		
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(220,300,100,25);
		cancel.addActionListener(this);
		panel.add(cancel);
		
		setLayout(new BorderLayout());
		add(panel,"Center");
		ImageIcon i1=new ImageIcon(getClass().getResource("/images/budget.png"));
		Image i2=i1.getImage().getScaledInstance(250, 200, DO_NOTHING_ON_CLOSE);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image,"East");
		
		setSize(650,400);
		setLocation(400,200);
		setVisible(true);
	}
	public static void main(String a[])
	{
		new calculate_bill();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit)
		{
			String smeterno=meternumcho.getSelectedItem();
			String sunit=unittext.getText();
			String smonth=monthcho.getSelectedItem();
			int totalbill=0;
			int unit=Integer.parseInt(sunit);
			String query_tax="select*from tax";
			try {
				database c=new database();
				ResultSet resultset=c.statement.executeQuery(query_tax);
				while(resultset.next())
				{
					totalbill+=unit*Integer.parseInt(resultset.getString("cost_per_unit"));
					totalbill+= unit*Integer.parseInt(resultset.getString("meter_rent"));
					totalbill+= unit*Integer.parseInt(resultset.getString("service_charge"));
					totalbill+= unit*Integer.parseInt(resultset.getString("swacch_bharat_tax"));
					totalbill+= unit*Integer.parseInt(resultset.getString("fixed_tax"));
					
				}
			}catch(Exception l)
			{
				l.printStackTrace();
			}
			String query_total_bill="insert into bill values('"+smeterno+"','"+smonth+"','"+sunit+"','"+totalbill+"','not paid')";
			try {
				database c=new database();
				c.statement.executeUpdate(query_total_bill);
				JOptionPane.showMessageDialog(null, "customer Bill Updated Successfully");
			}catch(Exception m)
			{
				m.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
		}
	}
}
