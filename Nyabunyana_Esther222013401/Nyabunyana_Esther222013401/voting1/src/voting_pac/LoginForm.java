package voting_pac;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;






public class LoginForm implements ActionListener{
	
	JFrame frame;

	private JLabel reg_number = new JLabel("REG NUMBER");
	private JLabel passwordLabel = new JLabel("PASSWORD");
	private JTextField userTextField = new JTextField("220000");
	private JPasswordField passwordField = new JPasswordField("000");
	private JButton loginButton = new JButton("LOGIN");
	private JButton resetButton = new JButton("RESET");
	private JCheckBox showPassword = new JCheckBox("Show Password");
	
	private JLabel choicel = new JLabel("ENTER USER !..ADMIN / CANDIDATE / STUDENT ?");
	private JTextField choicef = new JTextField("student");
	
	private JLabel wn = new JLabel("N.B !! IF YOU CLICK ON LOGIN WITH NO CHANGE ");
	private JLabel wn2 = new JLabel("REVIEW YOUR CREIDANCIALS AGAIN PLEASE!!");
	
	JComboBox<String> combo = new JComboBox<>(new String[] { "student","candidate", "admin" });

    ///////////////////////////////////////////////////////////////////////////////////////////////
	
	public LoginForm() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
		
		setLayoutManager();
		setLocationAndSize();
		
	}
	


public void setLayoutManager() {
	frame.setLayout(null);
}
	
	private void addActionEvent()
	{
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}
////////////////////ADD ELEMENTS TO FRAME///////////////////////////////////////////////////////////////////////////
	private void AddComponenttoFrame() {
		frame.add(reg_number);
		frame.add(passwordLabel);
		frame.add(userTextField);
		frame.add(passwordField);
		frame.add(showPassword);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(choicel);
		frame.add(choicef);
		frame.add(wn);
		frame.add(wn2);
		
		frame.add(combo);
			
	}
	
/////////////////////////////POSITIONING//////////////////////////////////////////////////////////////////
	private void setLocationAndSize() {
	
		combo.setBounds(50, 40, 270, 25);
		choicel.setBounds(50, 5, 270, 30);
//		choicef.setBounds(50, 40, 260, 30);
		reg_number.setBounds(50, 80, 100, 30);
		passwordLabel.setBounds(50, 120, 100, 30);
		userTextField.setBounds(150, 80, 160, 30);
		passwordField.setBounds(150, 120, 160, 30);
		showPassword.setBounds(150, 160, 150, 30);
		loginButton.setBounds(50, 200, 105, 30);
		resetButton.setBounds(205, 200, 105, 30);
		
		wn.setBounds(50, 270, 300, 30);
		wn2.setBounds(50, 290, 300, 30);
		
		wn.setForeground(Color.red);
		wn2.setForeground(Color.red);
		choicel.setForeground(Color.blue);
		
		 wn2.setFont(new Font("Serif", Font.BOLD, 13));
		// wn2.setBackground(Color.gray);
		 wn2.setOpaque(true);
		 
		 wn.setFont(new Font("Serif", Font.BOLD, 13));
		 //wn.setBackground(Color.gray);
		 wn.setOpaque(true);
		

	}
	
//////////////////////_____WINDOW________/////////////////////////////////////////////////////////////////////////
	
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("Login Form");
		frame.setVisible(true);
		frame.setBounds(10, 10, 370, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		setLayout(null);
	}
	private void setLayout(Object object) {
	// TODO Auto-generated method stub
	
}



	@Override
/////////////////////////____ACTION PERFORMED_____//////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginButton) {
		
			String reg=userTextField.getText();
			String pwdText=passwordField.getText();
			Object choice = combo.getSelectedItem();
			
			 if(!reg.equals("") && !pwdText.equals("")){
			
			if(choice.equals("student")) {
				
				
				try { 
				Class.forName("com.mysql.jdbc.Driver");   
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  	        
				PreparedStatement ps = con.prepareStatement("select * from student where student_reg="+reg+" and password='"+pwdText+"'"); 
				  ResultSet rs = ps.executeQuery(); 

				  while (rs.next()) {
				      String regi = rs.getString("student_reg");
				      String password = rs.getString("password");
		
				      	
				      if(reg.equals(regi) && pwdText.equals(password)) {
				    	  
				    	  Student_voting obj=new Student_voting();
				    		obj.my_update(regi);
				    		//obj.setVisible(true);
				    		frame.dispose();
				    	  
				    	  
				    	  
				    	  //
		        	// JOptionPane.showMessageDialog(this, "you are allowed to pass");
		           		} else{
		           			
		           			JOptionPane.showMessageDialog(null, "ENTER CORRECT CRIDENTIOS");	
		           		}
				  
				  }
				} catch (SQLException | ClassNotFoundException e1) {  
			         
			    }  
				
				String x = "123";
				
				 
			
				
			}
			else if(choice.equals("candidate")) {
				//JOptionPane.showMessageDialog(this, "you are candidate");
				
				
				try { 
					Class.forName("com.mysql.jdbc.Driver");   
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  	        
					PreparedStatement ps = con.prepareStatement("select * from student,candidate where student.student_reg=candidate.candidate_reg and student_reg="+reg+" and password='"+pwdText+"'"); 
					  ResultSet rs = ps.executeQuery(); 

					  while (rs.next()) {
					      String regi = rs.getString("student_reg");
					      String password = rs.getString("password");
					      
					      	
					      if((reg.equals(regi)) && (pwdText.equals(password))) {
					    	  
					    	  Candidate_register obj=new Candidate_register();
					    		obj.my_update(regi);
					    		//obj.setVisible(true);
					    		frame.dispose();
					    	  
					    	  
					    	  
					    	  //
			        	// JOptionPane.showMessageDialog(this, "you are allowed to pass");
			           		} else{
			           			
			           			
			           			JOptionPane.showMessageDialog(null, "you are not allowed to pass");	
			           		}
					  
					  }
					} catch (SQLException | ClassNotFoundException e1) {  
				         
				    }  
					
					String x = "123";
					
					 
				
				
				
				
			}
			
			else if(choice.equals("admin")) {
				
//				JOptionPane.showMessageDialog(this, "you are admin");
				
				

				try { 
					Class.forName("com.mysql.jdbc.Driver");   
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  	        
					PreparedStatement ps = con.prepareStatement("select * from admin where  regnumber="+reg+" and password='"+pwdText+"'"); 
					  ResultSet rs = ps.executeQuery(); 

					  while (rs.next()) {
					      String regi = rs.getString("regnumber");
					      String password = rs.getString("password");
					      

					      	
					      if(reg.equals(regi) && pwdText.equals(password)) {
					    	  
					    	  Admin_student obj=new  Admin_student();
					    	frame.dispose();

			        	// JOptionPane.showMessageDialog(this, "you are allowed to pass");
			           		} else{
			           			
			           			
			           			JOptionPane.showMessageDialog(null, "you are not allowed to pass");	
			           		}
					  
					  }
					} catch (SQLException | ClassNotFoundException e1) {  
				         
				    }  
					
					
					
			}
			else {
				JOptionPane.showMessageDialog(null, "correct your spelling on user you are!!");
			}
			
			
			 }
				else {
					JOptionPane.showMessageDialog(null, "fill all fields please");
				}

		
		}
		
			//Coding Part of RESET button
			if (e.getSource() == resetButton) {
				userTextField.setText("");
				passwordField.setText("");
			}
			//Coding Part of showPassword JCheckBox
			if (e.getSource() == showPassword) {
				if (showPassword.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}


			}
		


	}
	
	
	 
//	
	
///////////////////////////////////////////////////////////////////////////////////////////////
public static void main(String []args) {
	LoginForm anyname=new LoginForm();

	
	
	
}
public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
public void dispose() {
	// TODO Auto-generated method stub
	
}



}














