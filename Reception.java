package hotel.management.system;

import java.awt.Color;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Reception extends JFrame implements ActionListener{
	
	JButton newCustomer,rooms,department,allemployees,customerinfo,managerinfo,Checkout,updatestatus,updateroomstatus,pickupservice,searchroom,logout;
	
       Reception(){
    	   getContentPane().setBackground(Color.WHITE);
    	   setLayout(null);
    	   
    	    newCustomer = new JButton("New Customer Form");
    	   newCustomer.setBounds(10,30,200,30);
    	   newCustomer.setBackground(Color.BLACK);
    	   newCustomer.setForeground(Color.WHITE);
    	   newCustomer.addActionListener(this);
    	   add(newCustomer);
    	   
    	    rooms = new JButton("Rooms");
    	   rooms.setBounds(10,70,200,30);
    	   rooms.setBackground(Color.BLACK);
    	   rooms.setForeground(Color.WHITE);
    	   rooms.addActionListener(this);
           add(rooms);
    	   
    	    department = new JButton("  Department");
    	   department.setBounds(10,110,200,30);
    	   department.setBackground(Color.BLACK);
    	   department.setForeground(Color.WHITE);
    	   department.addActionListener(this);
           add(department);
    	   
    	    allemployees = new JButton("All Employees ");
    	   allemployees.setBounds(10,150,200,30);
    	   allemployees.setBackground(Color.BLACK);
    	   allemployees.setForeground(Color.WHITE);
    	   allemployees.addActionListener(this);
    	   add(allemployees);
    	   
    	    customerinfo = new JButton("Customer Info");
    	   customerinfo.setBounds(10,190,200,30);
    	   customerinfo.setBackground(Color.BLACK);
    	   customerinfo.setForeground(Color.WHITE);
    	   customerinfo.addActionListener(this);
    	   add(customerinfo);
    	   
    	    managerinfo = new JButton("Manager Info");
    	   managerinfo.setBounds(10,230,200,30);
    	   managerinfo.setBackground(Color.BLACK);
    	   managerinfo.setForeground(Color.WHITE);    	
    	   managerinfo.addActionListener(this);
    	   add(managerinfo);
    	   
    	    Checkout = new JButton("Checkout");
    	    Checkout.setBounds(10,270,200,30);
    	    Checkout.setBackground(Color.BLACK);
    	    Checkout.setForeground(Color.WHITE);
    	   add(Checkout);
    	   
    	    updatestatus = new JButton("Update Status");
    	   updatestatus.setBounds(10,310,200,30);
    	   updatestatus.setBackground(Color.BLACK);
    	   updatestatus.setForeground(Color.WHITE);
    	   updatestatus.addActionListener(this);
    	   add(updatestatus);
    	   
    	    updateroomstatus = new JButton("Update Room Status");
    	   updateroomstatus.setBounds(10,350,200,30);
    	   updateroomstatus.setBackground(Color.BLACK);
    	   updateroomstatus.setForeground(Color.WHITE);
    	   add(updateroomstatus);
    	   
    	    pickupservice = new JButton("Pickup Service");
    	   pickupservice.setBounds(10,390,200,30);
    	   pickupservice.setBackground(Color.BLACK);
    	   pickupservice.setForeground(Color.WHITE);
    	   add(pickupservice);
    	   
    	    searchroom = new JButton("Search Room");
    	   searchroom.setBounds(10,430,200,30);
    	   searchroom.setBackground(Color.BLACK);
    	   searchroom.setForeground(Color.WHITE);
    	   searchroom.addActionListener(this);
    	   add(searchroom);
    	   
    	    logout = new JButton("Logout");
    	   logout.setBounds(10,470,200,30);
    	   logout.setBackground(Color.BLACK);
    	   logout.setForeground(Color.WHITE);
    	   logout.addActionListener(this);
    	   add(logout);
    	   
    	   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fourth.jpg"));
    	   JLabel image = new JLabel(i1);
    	   image.setBounds(250,30,500,470);
    	   add(image);
    	   
    	   setBounds(350,200,800,570);
    	   setVisible(true);
       }
       public static void main(String[] args) {
    	   new Reception();
       }
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == newCustomer) {
			setVisible(false);
			new AddCustomer();
		}else if(ae.getSource()==rooms) {
			setVisible(false);
			new Room();
		}else if(ae.getSource()==department) {
			setVisible(false);
			new Department();
			}else if(ae.getSource()==allemployees) {
				setVisible(false);
				new EmployeeInfo();
			}else if(ae.getSource()==managerinfo) {
				setVisible(false);
				new ManagerInfo();
			}else if(ae.getSource()==customerinfo) {
				setVisible(false);
				new CustomerInfo();
			}else if(ae.getSource()==searchroom) {
				setVisible(false);
				new SearchRoom();
			}else if(ae.getSource()==updatestatus) {
				setVisible(false);
				new UpdateCheck();
			}else if(ae.getSource()==updatestatus) {
				setVisible(false);
				new UpdateCheck();
			}else if(ae.getSource()==logout) {
				setVisible(false);
				System.exit(0);
			}
		
	}
}
