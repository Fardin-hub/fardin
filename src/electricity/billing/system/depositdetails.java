package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class depositdetails extends JFrame implements ActionListener{
	JLabel meternum,month;
	Choice meternumcho,monthcho;
	JButton search,print,close;
	JTable table;
	depositdetails()
	{
		super("Deposit Details");
		getContentPane().setBackground(new Color(192,186,252));
		setSize(700,500);
		setLocation(400,200);
		setLayout(null);
		
		meternum=new JLabel("Search by Meter Number");
		meternum.setBounds(20,20,150,20);
		add(meternum);
		
		meternumcho=new Choice();
		try {
			database c=new database();
			ResultSet resultset=c.statement.executeQuery("select*from bill");
			while(resultset.next())
			{
				meternumcho.add(resultset.getString("meter_no"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		meternumcho.setBounds(180,20,100,20);
		add(meternumcho);
		
		month=new JLabel("Search BY Month");
		month.setBounds(400,20,100,20);
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
		monthcho.setBounds(520,20,150,20);
		add(monthcho);
		
		
		table=new JTable();
		try {
			database c=new database();
			ResultSet resultset=c.statement.executeQuery("select*from bill");
			table.setModel(DbUtils.resultSetToTableModel(resultset));
					
		}catch(Exception h)
		{
			h.printStackTrace();
		}
		
		JScrollPane scrollpane=new JScrollPane(table);
		scrollpane.setBounds(0,100,700,500);
		scrollpane.setBackground(Color.white);
		add(scrollpane);
		
		search=new JButton("Search");
		search.setBounds(20,70,80,20);
		search.setForeground(Color.black);
		search.addActionListener(this);
		add(search);
		
		print=new JButton("Print");
		print.setBounds(120,70,80,20);
		print.setForeground(Color.black);
		print.addActionListener(this);
		add(print);
		
		close=new JButton("Close");
		close.setBounds(600,70,80,20);
		close.setForeground(Color.black);
		close.addActionListener(this);
		add(close);
		
		setVisible(true);
	}
	public static void main(String a[])
	{
		new depositdetails();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search)
		{
			String query_search="select*from bill where meter_no='"+meternumcho.getSelectedItem()+"' and month='"+monthcho.getSelectedItem()+"'";
			try {
		     	database c=new database();
			    ResultSet resultset=c.statement.executeQuery(query_search);
			    table.setModel(DbUtils.resultSetToTableModel(resultset));
			    }catch(Exception h)
			    {
			      h.printStackTrace();
			    }
		}
		else if(e.getSource()==print)
		{
			try {
				table.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
		}
	}
}
