package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class customerdetails extends JFrame implements ActionListener{
	Choice searchmetercho,namecho;
	JButton search,print,close;
	JTable table;
	customerdetails()
	{
		super("Customer Details");
		getContentPane().setBackground(new Color(192,186,254));
		setSize(700,500);
		setLocation(400,200);
		setLayout(null);
		
		JLabel searchmeter=new JLabel("Search by meter NUmber");
		searchmeter.setBounds(20,20,150,20);
		add(searchmeter);
		
		searchmetercho=new Choice();
		searchmetercho.setBounds(180,20,100,20);
		add(searchmetercho);
		
		try {
			database c=new database();
			ResultSet resultset= c.statement.executeQuery("select*from new_customer");
			while(resultset.next())
			{
				searchmetercho.add(resultset.getString("meter_no"));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel name=new JLabel("Name");
		name.setBounds(400,20,100,20);
		add(name);
		
		namecho=new Choice();
		namecho.setBounds(520,20,150,20);
		add(namecho);
		
		try {
			database c=new database();
			ResultSet resultset=c.statement.executeQuery("select*from new_customer");
			while(resultset.next())
			{
				namecho.add(resultset.getString("name"));
			}
		}catch(Exception E)
		{
			E.printStackTrace();
		}
		
		table=new JTable();
		try {
			database c=new database();
			ResultSet resultset=c.statement.executeQuery("select*from new_customer");
			table.setModel(DbUtils.resultSetToTableModel(resultset));
					
		}catch(Exception h)
		{
			h.printStackTrace();
		}
		
		JScrollPane scrollpane= new JScrollPane(table);
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
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==search)
		{
			String query_search="select*from new_customer where meter_no='"+searchmetercho.getSelectedItem()+"' and name='"+namecho.getSelectedItem()+"' ";
			try {
				database c=new database();
				ResultSet resultset=c.statement.executeQuery(query_search);
				table.setModel(DbUtils.resultSetToTableModel(resultset));
			}catch(Exception l)
			{
				l.printStackTrace();
			}
		}
		else if(e.getSource()==print)
		{
			try
			{
				table.print();
			}catch(Exception j)
			{
				j.printStackTrace();
			}
		}
		else if(e.getSource()==close)
		{
			setVisible(false);
		}
	}
	public static void main(String s[])
	{
		new customerdetails();
	}
}
