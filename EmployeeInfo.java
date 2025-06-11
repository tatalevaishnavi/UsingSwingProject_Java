package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.*;


public  class EmployeeInfo extends JFrame implements ActionListener{
	
	JTable table;
	JButton back;
	
	EmployeeInfo(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
			
		JLabel I1 = new JLabel("Name");
		I1.setBounds(10,10,100,20);
		add(I1);
		
		JLabel I2 = new JLabel("age");
		I2.setBounds(150,10,100,20);
		add(I2);
		
		JLabel I3 = new JLabel("gender");
		I3.setBounds(260,10,100,20);
		add(I3);
		
		JLabel I4 = new JLabel("job");
		I4.setBounds(380,10,100,20);
		add(I4);
		
		JLabel I5 = new JLabel("salary");
		I5.setBounds(510,10,100,20);
		add(I5);
		
		JLabel I6 = new JLabel("phone");
		I6.setBounds(630,10,100,20);
		add(I6);
		
		
		JLabel I7 = new JLabel("email");
		I7.setBounds(760,10,100,20);
		add(I7);
		
		JLabel I8 = new JLabel("aadhar");
		I8.setBounds(880,10,100,20);
		add(I8);
		
		table = new JTable();
		table.setBounds(0,40,1000,400);
		add(table);
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select *from employee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(420,500,120,30);
		back.addActionListener(this);
		add(back);
		
		setBounds(300,200,1000,600);
		setVisible(true);
		
	}
	public static void main(String args[]) {
		new EmployeeInfo();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Reception();
	}
}

