package voting_pac;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;



public class Candidate_change_p implements ActionListener,MenuListener{
//	private static final Object Successful = null;

//////////////////////////FRAMS AND COMPONENTS/////////////////////////////////////////////////////////////////////
	JFrame frame;
	
	
	
	
	private JLabel current_lb=new JLabel("CURRENT PASSWORD");
	JTextField current_f=new JTextField();
	
	private JLabel new_lb=new JLabel("NEW PASSWORD");
	JTextField new_f=new JTextField();
	
	private JLabel c_lb=new JLabel("CONFIRM PASSWORD");
	JTextField c_f=new JTextField();
	
	
	
	private
//	JButton submit=new JButton("REGISTER");
	JButton resetbtn=new JButton("CLEAN");
	
	JButton change=new JButton("SAVE CHANGE");
	

	JLabel my_code=new JLabel();
	
	
	
	
	
	
	
JMenuBar myMenuBar = new JMenuBar();
	
    JMenu myMenuS =new JMenu("MANAGE");
   
    
    JMenu myMenuP =new JMenu("RESULT");
    JMenu myMenuC =new JMenu("CHANGE PASSWORD");
    JMenu myMenuL =new JMenu("LOGOUT");
    
    
    //title
    
   
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Candidate_change_p() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
		my_update(toString());
	}
	void my_update(String x) {
		
		my_code.setText(x);
//		code_f.setText(x);
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	private void addActionEvent() {
		resetbtn.addActionListener(this);
//		submit.addActionListener(this);
		
		
		
		change.addActionListener(this);
//		change.addActionListener(this);
		
		
		
		//menu
				myMenuS.addMenuListener(this);
				myMenuP.addMenuListener(this);
				myMenuC.addMenuListener(this);
				myMenuL.addMenuListener(this);
				
	}
////////////////////ADD ELEMENTS TO FRAME///////////////////////////////////////////////////////////////////////////
	private void AddComponenttoFrame() {
		
	
		
		frame.add(current_lb);
		frame.add(current_f);
		
		frame.add(new_lb);
		frame.add(new_f);
		
		frame.add(c_lb);
		frame.add(c_f);
		
		
		frame.add(resetbtn);
//		frame.add(submit);
		
		frame.add(change);
		frame.add(my_code);
		
	
		
		
		
//menu
		
        frame.add(myMenuBar);	
		myMenuBar.add(myMenuS);
		myMenuBar.add(myMenuP);
		myMenuBar.add(myMenuC);
		myMenuBar.add(myMenuL);
		
		
	}
	
/////////////////////////////POSITIONING//////////////////////////////////////////////////////////////////
	private void setLocationAndSize() {
	
		current_lb.setBounds(200, 200, 300, 30);
		current_f.setBounds(200, 230, 300, 30);
		
		new_lb.setBounds(200, 270, 300, 30);
		new_f.setBounds(200, 300, 300, 30);
		
		c_lb.setBounds(200, 340, 300, 30);
		c_f.setBounds(200, 370, 300, 30);
		
		
		
		
		
//		submit.setBounds(20, 300, 80, 30);
		resetbtn.setBounds(200, 415, 140, 30);
//		change.setBounds(200, 300, 120, 30);

		// second part
		change.setBounds(360, 415, 145, 30);

		// second part
		
		
		
		
		
		myMenuBar.setBounds(10, 20, 700, 30);
		
		
		
		
		


	}
	
//////////////////////_____WINDOW________/////////////////////////////////////////////////////////////////////////
	
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("CANDIDATE  CHANGE PASSWORD");
		frame.setBounds(10,10,770,670);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
//		update.getRootPane().setBackground(Color.gray);
	}
	@Override
/////////////////////////____ACTION PERFORMED_____//////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent e) {
 if(e.getSource()==resetbtn) {
//		current_f.setText("");
		current_f.setText("");
		new_f.setText("");
		c_f.setText("");
		
		
	}

	
	else if(e.getSource()==change) {
		
		 try {  
			 
			 if(!current_f.getText().equals("") && !new_f.getText().equals("") && !c_f.getText().equals("")){
			  Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        Statement st = con.createStatement();  
		        
		        
		        
		        
		        PreparedStatement ps = con.prepareStatement("select * from student where student_reg="+my_code.getText()+""); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		        	  String p = rs.getString("password");
//		              String p = rs.getString("pid");
		              
		              
//		              current_f.setText(cand);
//		      		v_code.setText(p);
		        	  
		        	  
		              System.out.println(p);
		              if(current_f.getText().equals(p)) {
		            	  //JOptionPane.showMessageDialog(null, "good");
		            	  if(new_f.getText().equals(c_f.getText())) {
		            		  //JOptionPane.showMessageDialog(null, "good");
		            		  
		            		  st.executeUpdate("update student set password='" +new_f.getText()+ "' where student_reg="+my_code.getText()+"");
		      		        JOptionPane.showMessageDialog(null, "password updated Successful");
		            		  
		            	  }else {
		            		  JOptionPane.showMessageDialog(null, "new password mismatch with confirm one !!");
		            	  }
		              }else {
		            	  JOptionPane.showMessageDialog(null, "your current password miss match");
		              }
		          
		          }
		          

			  }else {
		        	JOptionPane.showMessageDialog(null, "fill all  fields please");	
		        }
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}//end of if change

	
	


	}
	
	
	 public void menuSelected(MenuEvent e) {
	      JMenu myMenuS = (JMenu) e.getSource();
	      JMenu myMenuP = (JMenu) e.getSource();
	      JMenu myMenuC = (JMenu) e.getSource();
	      JMenu myMenuL = (JMenu) e.getSource();
	      
	      
//	      System.out.println("Menu Selected: "+myMenuS.getText());
	      
	      if(myMenuS.getText()=="MANAGE")
	      {
	    	
	    	  Candidate_register obj=new Candidate_register();
	    	  obj.my_update(my_code.getText());
	   			
	   			frame.dispose();
	      }
	      if(myMenuC.getText()=="CHANGE PASSWORD")
	      {
	    	
	    	  Candidate_change_p obj=new Candidate_change_p();		
	    	  obj.my_update(my_code.getText());
	    	  frame.dispose();
	      }
	      
	      if(myMenuP.getText()=="RESULT")
	      {
	    	
	    	  Candidate_votes obj=new Candidate_votes();
	    	  obj.my_update(my_code.getText());
	    	  frame.dispose();
	    	  
	    	  
	    		EventQueue.invokeLater(new Runnable() {
	    			public void run() {
	    				try {
	    					List_of_position frame = new List_of_position();
	    					frame.setVisible(true);
	    					
	    					
	    				} catch (Exception e) {
	    					e.printStackTrace();
	    				}
	    				
	    			}
	    			
	    		});
	      }
	      if(myMenuL.getText()=="LOGOUT")
	      {
	    	
	    	  LoginForm obj = new LoginForm();
//	    	  obj.my_update(v_code.getText());
	    	  frame.dispose();
	    	  
	    	  
	    	  
	      }
	      
	     
	   }

//	
	
///////////////////////////////////////////////////////////////////////////////////////////////
public static void main(String []args) {
	Candidate_change_p anyname=new Candidate_change_p();
}



@Override
public void menuDeselected(MenuEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void menuCanceled(MenuEvent e) {
	// TODO Auto-generated method stub
	
}
}
