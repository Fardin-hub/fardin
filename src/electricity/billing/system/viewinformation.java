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
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class viewinformation extends JFrame implements ActionListener{
	String view;
	JButton cancel;
	viewinformation(String view)
	{
		this.view=view;
		setBounds(350,150,850,650);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading=new JLabel("View Customer Information");
		heading.setBounds(250,0,500,40);
		heading.setFont(new Font("serif",Font.BOLD,20));
		add(heading);
		
		JLabel namelabel=new JLabel("Name");
		namelabel.setBounds(70,80,100,20);
		add(namelabel);
		
		JTextField namelabeltext=new JTextField();
		namelabeltext.setBounds(200,80,150,20);
		add(namelabeltext);
		
		JLabel meterno=new JLabel("Meter Number");
		meterno.setBounds(70,140,100,20);
		add(meterno);
		
		JTextField meternotext=new JTextField();
		meternotext.setBounds(200,140,150,20);
		add(meternotext);
		
		JLabel address=new JLabel("Address");
		address.setBounds(70,200,100,20);
		add(address);
		
		JTextField addresstext=new JTextField();
		addresstext.setBounds(200,200,150,20);
		add(addresstext);
		
		JLabel city=new JLabel("City");
		city.setBounds(70,260,100,20);
		add(city);
		
		JTextField citytext=new JTextField();
		citytext.setBounds(200,260,150,20);
		add(citytext);
		
		JLabel state=new JLabel("Name");
		state.setBounds(500,80,100,20);
		add(state);
		
		JTextField statetext=new JTextField();
		statetext.setBounds(600,80,150,20);
		add(statetext);
		
		JLabel email=new JLabel("Email");
		email.setBounds(500,140,100,20);
		add(email);
		
		JTextField emailtext=new JTextField();
		emailtext.setBounds(600,140,150,20);
		add(emailtext);
		
		JLabel phone=new JLabel("Phone Number");
		phone.setBounds(500,200,100,20);
		add(phone);
		
		JTextField phonetext=new JTextField();
		phonetext.setBounds(600,200,150,20);
		add(phonetext);
		
		try {
			database c=new database();
			ResultSet resultset= c.statement.executeQuery("select*from new_customer where meter_no='"+view+"'");
			if(resultset.next())
			{
				namelabeltext.setText(resultset.getString("name"));
				meternotext.setText(resultset.getString("meter_no"));
				emailtext.setText(resultset.getString("email"));
				citytext.setText(resultset.getString("city"));
				statetext.setText(resultset.getString("state"));
				phonetext.setText(resultset.getString("phone"));
				addresstext.setText(resultset.getString("address"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		cancel=new JButton("Cancel");
		cancel.setBounds(220,350,120,25);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(getClass().getResource("/images/viewInfo.png"));
		Image i2=i1.getImage().getScaledInstance(600, 300, DO_NOTHING_ON_CLOSE);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(100,320,600,300);
		add(image);
		
		setVisible(true);
	}
public static void main(String a[])
{
	new viewinformation("");
}
@Override
public void actionPerformed(ActionEvent e) {

	if(e.getSource()==cancel)
	{
		setVisible(false);
	}
}
}
