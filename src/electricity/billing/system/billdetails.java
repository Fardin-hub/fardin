package electricity.billing.system;

import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class billdetails extends JFrame{
	String meter;
	billdetails(String meter)
	{
		this.meter=meter;
		setSize(700,650);
		setLocation(400,150);
		setLayout(null);
		
		JTable table=new JTable();
		try {
			database c=new database();
			ResultSet resultset=c.statement.executeQuery("select*from bill where meter_no='"+meter+"'");
			table.setModel(DbUtils.resultSetToTableModel(resultset));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(0,0,700,650);
		add(sp);
		
		setVisible(true);
	}
	public static void main(String a[])
	{
		new billdetails("");
	}
}
