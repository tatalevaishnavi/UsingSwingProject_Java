package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.*;


public  class Room extends JFrame implements ActionListener{
	
	JTable table;
	JButton back;
	
	Room(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel (i3);
		image.setBounds(500,0,600,600);
		add(image);
		
		JLabel I1 = new JLabel("Room Number");
		I1.setBounds(10,10,100,20);
		add(I1);
		
		JLabel I2 = new JLabel("Availiability");
		I2.setBounds(110,10,100,20);
		add(I2);
		
		JLabel I3 = new JLabel(" Status");
		I3.setBounds(200,10,100,20);
		add(I3);
		
		JLabel I4 = new JLabel("Price");
		I4.setBounds(310,10,100,20);
		add(I4);
		
		JLabel I5 = new JLabel(" Bed Type");
		I5.setBounds(400,10,100,20);
		add(I5);
		
		table = new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select *from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(200,500,120,30);
		back.addActionListener(this);
		add(back);
		
		setBounds(300,200,1050,600);
		setVisible(true);
		
	}
	public static void main(String args[]) {
		new Room();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Reception();
	}
}
