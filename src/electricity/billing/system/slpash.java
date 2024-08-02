package electricity.billing.system;

import java.awt.Image;

import javax.swing.*;

@SuppressWarnings("serial")
public class slpash extends JFrame{
	slpash()
	{
		ImageIcon image=new ImageIcon(getClass().getResource(("/images/Splash.jpg")));
		Image image1=image.getImage().getScaledInstance(600,400, DO_NOTHING_ON_CLOSE);
		ImageIcon image2=new ImageIcon(image1);
		JLabel i=new JLabel(image2);
		add(i);
		setSize(600,400);
		setLocation(500,400);
		setVisible(true);
		try {
			Thread.sleep(3000);
			setVisible(false);
			new login();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String a[])
	{
		new slpash();
	}
}
