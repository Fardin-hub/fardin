package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class generatebill extends JFrame implements ActionListener{
	Choice monthcho;
	JTextArea area;
	String meter;
	JButton bill;
	generatebill(String meter)
	{
		this.meter=meter;
		setSize(500,700);
		setLocation(500,30);

		setLayout(new BorderLayout());
		JPanel panel=new JPanel();
		JLabel heading= new JLabel("Generate Bill");
		panel.add(heading);
		
		JLabel meterno=new JLabel(meter);
		panel.add(meterno);

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
		panel.add(monthcho);
		
		area=new JTextArea(50,15);
		area.setText("\n\n\t.........Click on the.........\n\t..........Generate Bill");
		area.setFont(new Font("Senserif",Font.ITALIC,20));
		JScrollPane pane=new JScrollPane(area);
		
		
		bill=new JButton("Generate BILL");
		bill.addActionListener(this);
		add(pane);
	
		add(panel,"North");
		add(bill,"South");
		setVisible(true);
	}
	public static void main(String a[])
	{
		new generatebill("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		try{
				database c=new database();
				String smonthcho=monthcho.getSelectedItem();
				area.setText("\n Power Limited \n Electricity bill for month of "+smonthcho+",2023\n\n\n ");
				ResultSet resultSet=c.statement.executeQuery("select*from new_customer where meter_no='"+meter+"'");
				 if (resultSet.next()){
		                area.append("\n    Customer Name        : "+resultSet.getString("name"));
		                area.append("\n    Customer Meter Number: "+resultSet.getString("meter_no"));
		                area.append("\n    Customer Address     : "+resultSet.getString("address"));
		                area.append("\n    Customer City        : "+resultSet.getString("city"));
		                area.append("\n    Customer State       : "+resultSet.getString("state"));
		                area.append("\n    Customer Email       : "+resultSet.getString("email"));
		                area.append("\n    Customer Phone Number       : "+resultSet.getString("phone"));

				                      }
			        	 resultSet = c.statement.executeQuery("select * from meter_info where meter_number ='"+meter+"'");
			        if (resultSet.next()){
			            area.append("\n    Customer Meter Location        : "+resultSet.getString("meter_location"));
			            area.append("\n    Customer Meter Type: "+resultSet.getString("meter_type"));
			            area.append("\n    Customer Phase Code   : "+resultSet.getString("phase_code"));
			            area.append("\n    Customer Bill Type        : "+resultSet.getString("bill_type"));
			            area.append("\n    Customer Days      : "+resultSet.getString("days"));


			        }
			            resultSet = c.statement.executeQuery("select * from tax");
			            if (resultSet.next()){
			                area.append("\n    Cost Per Unit        : "+resultSet.getString("cost_per_unit"));
			                area.append("\n   Meter Rent: "+resultSet.getString("meter_rent"));
			                area.append("\n   Service Charge   : "+resultSet.getString("service_charge"));
			                area.append("\n   Service Tax        : "+resultSet.getString("service_tax"));
			                area.append("\n   Swacch Bharat Acss     : "+resultSet.getString("swacch_bharat_tax"));
			                area.append("\n   Fixed Tax     : "+resultSet.getString("fixed_tax"));

			            }
			            resultSet = c.statement.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+smonthcho+"'");
			            if (resultSet.next()) {
			                area.append("\n    Current Month       : " + resultSet.getString("month"));
			                area.append("\n   Units Consumed: " + resultSet.getString("unit"));
			                area.append("\n   Total Charges   : " + resultSet.getString("total_bill"));
			                area.append("\n Total Payable: "+resultSet.getString("total_bill"));
			            }
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
}
