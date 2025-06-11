package hotel.management.system;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class DashBoard extends JFrame implements ActionListener{
	DashBoard(){
		setBounds(0,0,15550,1000);
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 =  new ImageIcon(i2);
		JLabel Image = new JLabel(i3);
		Image.setBounds(0, 0, 1550, 1000);
		add(Image);
		
		JLabel text = new JLabel("THE TAJ GROUP WELCOME YOU");
		text.setBounds(400,80,1000,50);
		text.setFont(new Font("Tahoma",Font.PLAIN,45));
		text.setForeground(Color.white);
		Image.add(text);	
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0,0,1550,30);
		Image.add(mb);
		
		JMenu hotel = new JMenu("Hotel Management");
		hotel.setForeground(Color.red);
		mb.add(hotel);
		
		JMenuItem reception = new JMenuItem("Reception");
		reception.addActionListener(this);
		hotel.add(reception);
		
		JMenu admin = new JMenu(" Admin");
		admin.setForeground(Color.BLUE);
		mb.add(admin);
		
		JMenuItem addemployee = new JMenuItem("ADD Employee");
		addemployee.addActionListener(this);
        admin.add(addemployee);
		
        JMenuItem addrooms = new JMenuItem("ADD Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers = new JMenuItem("ADD Drivers");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
		setVisible(true);

	}


	public static void main(String[] args) {
     new DashBoard();
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("ADD Employee")) {
			new AddEmployee();
		}else if(ae.getActionCommand().equals("ADD Rooms")) {
			new AddRooms();
			
		}else if(ae.getActionCommand().equals("ADD Drivers")) {
			new AddDrivers();
		}else if(ae.getActionCommand().equals("Reception")) {
			new Reception();
		}
		
	}

}
