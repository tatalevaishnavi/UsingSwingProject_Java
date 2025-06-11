package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.*;


public  class SearchRoom extends JFrame implements ActionListener{
	
	JTable table;
	JButton back,submit;
	JComboBox bedtype;
	JCheckBox available;
	
	SearchRoom(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Search For Room");
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		text.setBounds(400,30,200,30);
		add(text);
		
		JLabel lblbed=new JLabel("Bed Type");
		lblbed.setBounds(50,100,100,20);
		add(lblbed);
		
		bedtype = new JComboBox(new String[]{"single bed","double bed"});
		bedtype.setBounds(150,100,150,25);
		bedtype.setBackground(Color.WHITE);
		add(bedtype);
		
		available = new JCheckBox("only display available");
		available.setBounds(650,100,150,25);
		available.setBackground(Color.WHITE);
		add(available);
		
		JLabel I1 = new JLabel("Room Number");
		I1.setBounds(10,160,100,20);
		add(I1);
		
		JLabel I2 = new JLabel("Availiability");
		I2.setBounds(210,160,100,20);
		add(I2);
		
		JLabel I3 = new JLabel("Status");
		I3.setBounds(400,160,100,20);
		add(I3);
		
		JLabel I4 = new JLabel("Price");
		I4.setBounds(610,160,100,20);
		add(I4);
		
		JLabel I5 = new JLabel("Bed Type");
		I5.setBounds(800,160,100,20);
		add(I5);
		
		table = new JTable();
		table.setBounds(0,200,1000,300);
		add(table);
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select *from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(300,500,120,30);
		submit.addActionListener(this);
		add(submit);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(500,500,120,30);
		back.addActionListener(this);
		add(back);
		
		
		
		setBounds(300,200,1000,600);
		setVisible(true);
		
	}
	public static void main(String args[]) {
		new SearchRoom();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==submit) {
		try {
			String query1="select *from room where bed_type='"+bedtype.getSelectedItem()+"'";
			String query2="select *from room where availability='available' AND bed_type='"+bedtype.getSelectedItem()+"'";
             
			
			Conn conn = new Conn();
			ResultSet rs;
			if(available.isSelected()) {
				rs=conn.s.executeQuery(query2);
			}else {
				rs=conn.s.executeQuery(query1);
			}
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}else {
		setVisible(false);
		new Reception();
	}
	}
}
