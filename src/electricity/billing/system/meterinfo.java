package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class meterinfo extends JFrame implements ActionListener{
	JLabel heading,meternumbertext,meternumber,meterloc,metertyp,phasecode,note1,billtyp,day,note;
	String meterNumber;
	JButton submit;
	Choice meterloccho,metertypcho,phasecodecho,billtypcho;
	meterinfo(String meterNumber)
	{
		this.meterNumber=meterNumber;
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(252,186,3));
		add(panel);
		
		heading=new JLabel("Meter Information");
		heading.setBounds(180,10,200,20);
		heading.setFont(new Font("Tahome",Font.BOLD,20));
		panel.add(heading);
		
		meternumber=new JLabel("Meter Number");
		meternumber.setBounds(50,80,100,20);
		panel.add(meternumber);
		
		meternumbertext=new JLabel(meterNumber);
		meternumbertext.setBounds(180,80,150,20);
		panel.add(meternumbertext);
		
		meterloc=new JLabel("Meter location");
		meterloc.setBounds(50,120,100,20);
		panel.add(meterloc);
		
		meterloccho=new Choice();
		meterloccho.add("Outside");
		meterloccho.add("Inside");
		meterloccho.setBounds(180,120,150,20);
		panel.add(meterloccho);
		
		metertyp=new JLabel("Meter Type");
		metertyp.setBounds(50,160,100,20);
		panel.add(metertyp);
		
		metertypcho=new Choice();
		metertypcho.add("Electric Motor");
		metertypcho.add("Solar Motor");
		metertypcho.add("smart Meter");
		metertypcho.setBounds(180,160,150,20);
		panel.add(metertypcho);
		

		phasecode=new JLabel("Phase Code");
		phasecode.setBounds(50,200,100,20);
		panel.add(phasecode);
		
		phasecodecho=new Choice();
		phasecodecho.add("11");
		phasecodecho.add("22");
		phasecodecho.add("33");
		phasecodecho.add("44");
		phasecodecho.add("55");
		phasecodecho.add("66");
		phasecodecho.add("77");
		phasecodecho.add("88");
		phasecodecho.add("99");
		phasecodecho.setBounds(180,200,150,20);
		panel.add(phasecodecho);

		billtyp=new JLabel("Bill Type");
		billtyp.setBounds(50,240,100,20);
		panel.add(billtyp);
		
		billtypcho=new Choice();
		billtypcho.add("Normal");
		billtypcho.add("Industrial");
		billtypcho.setBounds(180,240,150,20);
		panel.add(billtypcho);
		
		
		day=new JLabel("30 days billing Time......");
		day.setBounds(50,280,150,20);
		panel.add(day);
		
		note=new JLabel("Note:-");
		note.setBounds(50,320,100,20);
		panel.add(note);
		
		note1=new JLabel("By default bill is calculated for 30 days only");
		note1.setBounds(50,340,300,20);
		panel.add(note1);
		
		submit=new JButton("Submit");
		submit.setBounds(220,390,100,25);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		panel.add(submit);
		

		setLayout(new BorderLayout());
		add(panel,"Center");

		ImageIcon i1=new ImageIcon(getClass().getResource("/images/details.png"));
		Image i2=i1.getImage().getScaledInstance(230, 200, DO_NOTHING_ON_CLOSE);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image,"East"); 
		
		setSize(700,500);
		setLocation(400,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==submit)
		{
			String smeternum=meterNumber;
			String Smeterloccho=meterloccho.getSelectedItem();
			String smetertyp=metertypcho.getSelectedItem();
			String sphasecodecho=phasecodecho.getSelectedItem();
			String sbilltypecho=billtypcho.getSelectedItem();
			String sday="30";
			
			String query_meterinfo="insert into meter_info values('"+smeternum+"','"+Smeterloccho+"','"+smetertyp+"','"+sphasecodecho+"','"+sbilltypecho+"','"+sday+"')";
			try {
				database c=new database();
				c.statement.executeUpdate(query_meterinfo);
				
				JOptionPane.showMessageDialog(null, "Meter Info Submitted Succcessfully");
				setVisible(false);
			}catch(Exception E)
			{
				E.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
		}
	}
	public static void main(String a[])
	{
		new meterinfo("");
	}
}
