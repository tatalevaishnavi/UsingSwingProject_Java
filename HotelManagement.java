package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
public class HotelManagement extends JFrame implements ActionListener{

	HotelManagement(){
		// TODO Auto-generated constructor stub
	//	setSize(1366,565);
		//setLocation(100,100);
		setBounds(100,100,1366,565);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("first.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0,0,1366,565);//locationx,locationy,length,breadth
		add(image);
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20,430, 1000, 90);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("serif",Font.PLAIN,50));
		image.add(text);
		
		JButton next = new JButton("Next");
		next.setBounds(1150,450,150,50);
		image.add(next);
		next.setBackground(Color.white);
		next.setForeground(Color.magenta);
		next.addActionListener(this);
		next.setFont(new Font("serif",Font.PLAIN,24));
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				e.printStackTrace();}
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new HotelManagement();
       
	}



	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Login();
		
	}
		
	}


