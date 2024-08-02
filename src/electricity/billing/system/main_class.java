package electricity.billing.system;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class main_class extends JFrame implements ActionListener{
	String acctype;
	String meter;
	main_class(String acctype,String meter)
	{
		this.meter=meter;
		this.acctype=acctype;

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon image= new ImageIcon(getClass().getResource("/images/ebs.png"));
		Image image1=image.getImage().getScaledInstance(1530, 830, DO_NOTHING_ON_CLOSE);
		ImageIcon image2=new ImageIcon(image1);
		JLabel i=new JLabel(image2);
		add(i);
		
		JMenuBar menubar=new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu menu=new JMenu("Menu");
		menu.setFont(new Font("serif",Font.PLAIN,15));
		
		JMenuItem newcustomer=new JMenuItem("NewCustomer");
		newcustomer.setFont(new Font("monospaced",Font.PLAIN,14));
		ImageIcon customerimg=new ImageIcon(getClass().getResource("/images/newcustomer.png"));
		Image customerimage=customerimg.getImage().getScaledInstance(20,20,DO_NOTHING_ON_CLOSE );
		newcustomer.setIcon(new ImageIcon(customerimage));
		newcustomer.addActionListener(this);
		menu.add(newcustomer);
		
		JMenuItem customerdetails=new JMenuItem("Customer Details");
		customerdetails.setFont(new Font("monospaced",Font.PLAIN,14));
		ImageIcon customerdetailsimg=new ImageIcon(getClass().getResource("/images/customerDetails.png"));
		Image customerdetailsimage=customerdetailsimg.getImage().getScaledInstance(20,20, DO_NOTHING_ON_CLOSE);
		customerdetails.setIcon(new ImageIcon(customerdetailsimage));
		customerdetails.addActionListener(this);
		menu.add(customerdetails);
		
		JMenuItem depositdetails=new JMenuItem("Deposit Details");
		depositdetails.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon depositdetailsimg=new ImageIcon(getClass().getResource("/images/depositdetails.png"));
		Image depositdetailsimage=depositdetailsimg.getImage().getScaledInstance(20,20, DO_NOTHING_ON_CLOSE);
		depositdetails.setIcon(new ImageIcon(depositdetailsimage));
		depositdetails.addActionListener(this);
		menu.add(depositdetails);
		
		JMenuItem calculatebill=new JMenuItem("Calculate Bill");
		calculatebill.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon calculatebillimg=new ImageIcon(getClass().getResource("/images/calculatorbills.png"));
		Image calculatebillimage=calculatebillimg.getImage().getScaledInstance(20,20, DO_NOTHING_ON_CLOSE);
		calculatebill.setIcon(new ImageIcon(calculatebillimage));
		calculatebill.addActionListener(this);
		menu.add(calculatebill);
		
		JMenu info=new JMenu("Information");
		info.setFont(new Font("serif",Font.PLAIN,15));
		
		JMenuItem updateinformation=new JMenuItem("Update Information");
		updateinformation.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon updateinformationimg=new ImageIcon(getClass().getResource("/images/refresh.png"));
		Image updateinformationimage=updateinformationimg.getImage().getScaledInstance(20,20, DO_NOTHING_ON_CLOSE);
		updateinformation.setIcon(new ImageIcon(updateinformationimage));
		updateinformation.addActionListener(this);
		info.add(updateinformation);
		
		JMenuItem viewinfo=new JMenuItem("View Information");
		viewinfo.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon viewinfoimg=new ImageIcon(getClass().getResource("/images/information.png"));
		Image viewinfoimage=viewinfoimg.getImage().getScaledInstance(20,20, DO_NOTHING_ON_CLOSE);
		viewinfo.setIcon(new ImageIcon(viewinfoimage));
		viewinfo.addActionListener(this);
		info.add(viewinfo);
		
		JMenu user=new JMenu("User");
		user.setFont(new Font("serif",Font.PLAIN,15));
		
		
		JMenuItem paybill=new JMenuItem("Pay Bills");
		paybill.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon paybillimg=new ImageIcon(getClass().getResource("/images/pay.png"));
		Image paybillimage=paybillimg.getImage().getScaledInstance(20,20, DO_NOTHING_ON_CLOSE);
		paybill.setIcon(new ImageIcon(paybillimage));
		paybill.addActionListener(this);
		user.add(paybill);
		
		JMenuItem billdetail=new JMenuItem("Bill Details");
		billdetail.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon billdetailimg=new ImageIcon(getClass().getResource("/images/detail.png"));
		Image billdetailimage=billdetailimg.getImage().getScaledInstance(20,20,DO_NOTHING_ON_CLOSE);
		billdetail.setIcon(new ImageIcon(billdetailimage));
		billdetail.addActionListener(this);
		user.add(billdetail);
		
		JMenu bill=new JMenu("Bill");
		bill.setFont(new Font("serif",Font.PLAIN,15));
		
		
		JMenuItem genbill=new JMenuItem("Generate Bill");
		genbill.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon genbillimg=new ImageIcon(getClass().getResource("/images/bill.png"));
		Image genbillimage=genbillimg.getImage().getScaledInstance(20,20, DO_NOTHING_ON_CLOSE);
		genbill.setIcon(new ImageIcon(genbillimage));
		genbill.addActionListener(this);
		bill.add(genbill);
		
		JMenu utility=new JMenu("Utility");
		utility.setFont(new Font("serif",Font.PLAIN,15));
	
		
		JMenuItem notepad=new JMenuItem("Notepad");
		notepad.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon notepadimg=new ImageIcon(getClass().getResource("/images/notepad.png"));
		Image notepadimage=notepadimg.getImage().getScaledInstance(20,20, DO_NOTHING_ON_CLOSE);
		notepad.setIcon(new ImageIcon(notepadimage));
		notepad.addActionListener(this);
		utility.add(notepad);
		
		JMenuItem calculator=new JMenuItem("Calculator");
		calculator.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon calculatorimg=new ImageIcon(getClass().getResource("/images/calculator.png"));
		Image calculatorimage=calculatorimg.getImage().getScaledInstance(20,20,DO_NOTHING_ON_CLOSE);
		calculator.setIcon(new ImageIcon(calculatorimage));
		calculator.addActionListener(this);
		utility.add(calculator);
		
		JMenu exit=new JMenu("Exit");
		exit.setFont(new Font("serif",Font.PLAIN,15));
		menubar.add(exit);
		
		JMenuItem eexit= new JMenuItem("Exit");
		eexit.setFont(new Font("monospace",Font.PLAIN,14));
		ImageIcon eexitimg= new ImageIcon(getClass().getResource("/images/exit.png"));
		Image eexitimage=eexitimg.getImage().getScaledInstance(20,20,DO_NOTHING_ON_CLOSE);
		eexit.setIcon(new ImageIcon(eexitimage));
		eexit.addActionListener(this);
		exit.add(eexit);
		
		if(acctype.equals("Admin")) {
		menubar.add(menu);
		}
		else {
		menubar.add(info);
		menubar.add(user);
		menubar.add(bill);
		}
		menubar.add(utility);
		menubar.add(exit);
		
		setLayout(new FlowLayout());
		setVisible(true);
	}
	public static void main(String a[])
	{
		new main_class("","");
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=e.getActionCommand();
		if(msg.equals("NewCustomer"))
		{
			new NewCustomer();
		}
		else if(msg.equals("Deposit Details"))
		{
			new depositdetails();
		}
		else if(msg.equals("Customer Details"))
		{
			new customerdetails();
		}
		else if(msg.equals("Calculate Bill"))
		{
			new calculate_bill();
		}
		else if(msg.equals("View Information"))
		{
			new viewinformation(meter);
		}
		else if(msg.equals("Update Information"))
		{
			new updateinformation(meter);
		}
		else if(msg.equals("Calculator"))
		{
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception h)
			{
				h.printStackTrace();
			}
		}
		else if(msg.equals("Notepad"))
		{

			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception h)
			{
				h.printStackTrace();
			}
		}
		else if(msg.equals("Bill Details"))
		{
			new billdetails(meter);
		}

		else if(msg.equals("Pay Bills"))
		{
			new paybill(meter);
		}
		if(msg.equals("Generate Bill"))
		{
			new generatebill(meter);
		}
		else if(msg.equals("Exit"))
		{
			setVisible(false);
		}
	}
}
