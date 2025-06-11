package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
	
	JButton add , cancel;
	JTextField tfroomno,tfprice;
	JComboBox availablecombo,cleancombo,typecombo;
	
	AddRooms(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,20,200,20);
		add(heading);
		
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblroomno.setBounds(60,80,120,30);
		add(lblroomno);
		
		 tfroomno = new JTextField();
		tfroomno.setBounds(200,80,150,30);
		add(tfroomno);
		
		JLabel lblavailable = new JLabel("Available ");
		lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblavailable.setBounds(60,130,120,30);
		add(lblavailable);
		
		String availableoption[]= {"Available","Occupied"};
		 availablecombo = new JComboBox(availableoption);
		availablecombo.setBounds(200,130,150,30);
		availablecombo.setBackground(Color.WHITE);
		add(availablecombo);
		
		JLabel lblcleans = new JLabel("Cleaning Status ");
		lblcleans.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblcleans.setBounds(60,180,120,30);
		add(lblcleans);
		
		String cleanoption[]= {"Cleaned","Dirty"};
		 cleancombo = new JComboBox(cleanoption);
		cleancombo.setBounds(200,180,150,30);
		cleancombo.setBackground(Color.WHITE);
		add(cleancombo);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblprice.setBounds(60,230,120,30);
		add(lblprice);
		
		 tfprice =  new JTextField();
		tfprice.setBounds(200,230,150,30);
		add(tfprice);
		
		JLabel lbltype = new JLabel("Bed Type");
		lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbltype.setBounds(60,280,120,30);
		add(lbltype);
		
		String typeoption[]= {"Single Bed","Double Bed"};
		 typecombo = new JComboBox(typeoption);
		typecombo.setBounds(200,280,150,30);
		typecombo.setBackground(Color.WHITE);
		add(typecombo);
		
		 add = new JButton("Add Room");
		add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,120,30);
        add.addActionListener(this);
        add(add);
        
         cancel = new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,120,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(400,60,500,300);
		add(image);
        
		setBounds(330,200,940,470);
		setVisible(true);
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddRooms();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==add) {
			String roomnumber = tfroomno.getText();
			String availability = (String) availablecombo.getSelectedItem();
			String status =  (String) cleancombo.getSelectedItem();
			String price = tfprice.getText();
			String type = (String)typecombo.getSelectedItem();
			if(roomnumber.equals("")) {
				JOptionPane.showMessageDialog(null,"Room Number Should Not Empty");
				return;
			}
			try {
				Conn conn = new Conn();
				String str= "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
				conn.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "New Room Added Successfully!");
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}

}
