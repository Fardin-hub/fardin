package electricity.billing.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class paymentbill extends JFrame implements ActionListener{
	JButton back;
	String meter;
	paymentbill(String meter)
	{
		this.meter=meter;
		JEditorPane j=new JEditorPane();
		j.setEditable(false);
		
		try {
			j.setPage("https://payments.google.com/gp/w/home/paymentmethods?sctid=4262395039173015");
			j.setBounds(400,150,800,600);
		}catch(Exception e)
		{
			e.printStackTrace();
			j.setContentType("text/html");
			j.setText("<html>Error!</html>");
		}
		
		JScrollPane pane =new JScrollPane(j);
		add(pane);
		
		    back=new JButton("Back");
			back.setBackground(Color.black);
			back.setForeground(Color.white);
			back.setBounds(640,20,80,30);
			back.addActionListener(this);
			j.add(back);
		
		
		setSize(800,600);
		setLocation(400,150);
		setVisible(true);
	}
	public static void main(String a[])
	{
		new paymentbill("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back)
		{
			setVisible(false);
			new paybill("");
		}
	}
}
