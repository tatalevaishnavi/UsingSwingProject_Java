package hotel.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{
	
	JComboBox comboid;
	JTextField tfname,tfnumber,tfcompany,tfdeposit,tfcountry;
	JRadioButton rbmale,rbfemale;
	Choice croomnumber;
	JButton add,back;
	JLabel checkintime;
	
	AddCustomer(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel text = new JLabel("New Customer Form");
		text.setBounds(100,20,300,30);
		text.setFont(new Font("Raleway",Font.PLAIN,20));
		add(text);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(35,80,100,20);
		lblid.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblid);
		
		String idoption[]= {"Aadhar Card","Passport","Driving License","Voter-id Card","Ration Card"};
		comboid = new JComboBox(idoption);
		comboid.setBounds(200,80,150,25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(35,120,100,20);
		lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblnumber);
		
		 tfnumber = new JTextField();
		tfnumber.setBounds(200,120,150,25);
		add(tfnumber);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(35,160,100,20);
		lblname.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblname);
		
		 tfname = new JTextField();
		tfname.setBounds(200,160,150,25);
		add(tfname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(35,200,100,20);
		lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblgender);
		
		 rbmale =  new JRadioButton("Male");
		rbmale.setBounds(200,200,100,25);
		rbmale.setFont(new Font("raleway",Font.PLAIN,20));
		rbmale.setBackground(Color.WHITE);
		add(rbmale);
		
		 rbfemale =  new JRadioButton("Female");
		rbfemale.setBounds(300,200,100,25);
		rbfemale.setFont(new Font("raleway",Font.PLAIN,20));
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(35,240,100,20);
		lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblcountry);
		
		 tfcountry = new JTextField();
		tfcountry.setBounds(200,240,150,25);
		add(tfcountry);
		
		JLabel lblrooms = new JLabel("Room Number");
		lblrooms.setBounds(35,280,150,20);
		lblrooms.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblrooms);
		
		 croomnumber = new Choice();
		try {
		Conn conn = new Conn();
		String query = "select *from room";
		ResultSet rs=conn.s.executeQuery(query);
		while(rs.next()) {
			croomnumber.add(rs.getString("roomnumber"));
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		croomnumber.setBounds(200,280,150,20);
		add(croomnumber);
		
		 JLabel lbltime =  new JLabel("check in time");
		lbltime.setBounds(35,320,150,20);
		lbltime.setFont(new Font("raleway",Font.PLAIN,20));
		add(lbltime);
		
		Date date = new Date();
		// 1 + 2 + 3 + 4 + 5 +"code or interview" + 1 + 2 + 3 + 4 + 5 
		
		 checkintime = new JLabel(""+date); 
		checkintime.setBounds(200,320,150,25);
		checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
		add(checkintime);
		
		JLabel lbldeposit = new JLabel("Deposit");
		lbldeposit.setBounds(35,360,100,20);
		lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lbldeposit);
		
		 tfdeposit = new JTextField();
		tfdeposit.setBounds(200,360,150,25);
		add(tfdeposit);
		
		add = new JButton("Add");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setBounds(30,410,150,30);
		add.addActionListener(this);
		add(add);
		
		back = new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(200,410,150,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,50,300,400);
		add(image);
		
		
		
		setBounds(350,200,800,550);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AddCustomer();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
			if (ae.getSource()== add) {
				String id = (String) comboid.getSelectedItem();
				String number = tfnumber.getText();
				String name = tfname.getText();
				String gender = null;
				if(rbmale.isSelected()) {
					gender = "Male";
				}else {
					gender = "Female";
				}
				String Country = tfcountry.getText();
				String roomnumber = croomnumber.getSelectedItem();
				String time = checkintime.getText();
				String deposit = tfdeposit.getText();
				
				try {
					String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+Country+"','"+roomnumber+"','"+time+"','"+deposit+"')";
                    String query2 = "update room set availability = 'Occupied' where roomnumber = '"+roomnumber+"'"	;	
                    
                    Conn c= new Conn();
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "New Customer Added Succesfully ");
                    
   				 setVisible(false);
                 new Reception();
                    
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(ae.getSource()==back) {
				 setVisible(false);
                 new Reception();
			}
		}
		}

