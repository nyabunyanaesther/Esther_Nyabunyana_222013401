package voting_pac;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;





public class Student_voting implements ActionListener,MenuListener{
	//private static final Object Successful = null;
	
	
	

//////////////////////////FRAMS AND COMPONENTS/////////////////////////////////////////////////////////////////////
	JFrame frame;
	
	private JLabel wel=new JLabel("", SwingConstants.CENTER);
	
	private JLabel formtitle=new JLabel("BEFORE YOU VOTE CLICK VIEW BUTTON TO SEE ALL CANDIDATES");
	private JLabel formtitle2=new JLabel(" AND THEIR INFORMATIONS AND THEN FILL FORM !!");
	private JLabel formtitle3=new JLabel("  IF YOU VOTE AND NOT DIALOG BOX MEANS THAT CANDIDATE DOES NOT EXIST ");
	
	
	private JLabel code_lb=new JLabel("CANDIDATE REG NO");
	JTextField c_code=new JTextField();
	
	private JLabel position_lb=new JLabel("VOTER REG NO");
	JLabel v_code=new JLabel();
	
	
	
	private
	JButton submit=new JButton("VOTE");
	JButton resetbtn=new JButton("CLEAN");
//	JButton change=new JButton("SAVE CHANGE");
	
	
	
	
	
	
JMenuBar myMenuBar = new JMenuBar();
	
    JMenu myMenuS =new JMenu("VOTE");
    JMenu myMenuC =new JMenu("REGISTER");
    
    JMenu myMenuP =new JMenu("RESULT");
    JMenu myMenuLo =new JMenu("LOGOUT");
    JMenu myMenuX =new JMenu("CHANGE PASSWORD");
    
    
    //title
    
   	JButton list=new JButton("VIEW CANDIDATES");
       private JLabel title=new JLabel("CLICK HERE TO DISPLAY LIST !!");
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Student_voting() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
		my_update(toString());
		}
		void my_update(String x) {
			
			
			
			v_code.setText(x);
			
			
			 try {  
				 
			        Class.forName("com.mysql.jdbc.Driver");  
			        // establish connection  
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
			        
			        
//			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
//			        Statement st = con.createStatement();  
			        PreparedStatement ps = con.prepareStatement("select * from student where student_reg="+x+""); 
			          ResultSet rs = ps.executeQuery(); 
			          
			           

			          while (rs.next()) {
			        	  String f = rs.getString("fname");
			        	  String l = rs.getString("lname");
//			   
			        	  wel.setText("WELCAME "+f+"  "+l+" now you can vote/or register as candidate as well");
			              }
			          
				
			          
			 } catch (SQLException | ClassNotFoundException e1) {  
		         
			    } 
			          
			 
			 
			        
			        
			
		} 
	
///////////////////////////////////////////////////////////////////////////////////////////////
	private void addActionEvent() {
		resetbtn.addActionListener(this);
		submit.addActionListener(this);
		
//		change.addActionListener(this);
		
		list.addActionListener(this);
		
		//menu
				myMenuS.addMenuListener(this);
				myMenuP.addMenuListener(this);
				myMenuC.addMenuListener(this);
				myMenuLo.addMenuListener(this);
				myMenuX.addMenuListener(this);
				
	}
////////////////////ADD ELEMENTS TO FRAME///////////////////////////////////////////////////////////////////////////
	private void AddComponenttoFrame() {
		
		frame.add(formtitle);
		frame.add(formtitle2);
		frame.add(formtitle3);
		
		frame.add(code_lb);
		frame.add(c_code);
		
		frame.add(position_lb);
		frame.add(v_code);
		frame.add(wel);
		
		frame.add(resetbtn);
		frame.add(submit);
//		frame.add(change);
		
		
		
//menu
		
        frame.add(myMenuBar);
		
		myMenuBar.add(myMenuS);
		myMenuBar.add(myMenuC);
		myMenuBar.add(myMenuP);
		myMenuBar.add(myMenuX);
		myMenuBar.add(myMenuLo);
		
		frame.add(title);
		frame.add(list);
	}
	
/////////////////////////////POSITIONING//////////////////////////////////////////////////////////////////
	private void setLocationAndSize() {
		
		wel.setBounds(20, 80, 700, 70);
		
		formtitle.setBounds(20, 170, 400, 30);
		formtitle2.setBounds(20, 200, 400, 30);
		formtitle3.setBounds(20, 230, 900, 30);
		
		code_lb.setBounds(20, 300, 200, 30);
		c_code.setBounds(180, 300, 140, 30);
		
		position_lb.setBounds(20, 350, 200, 30);
		v_code.setBounds(180, 350, 350, 30);
		
		
		
		submit.setBounds(20, 400, 135, 30);
		resetbtn.setBounds(180, 400, 135, 30);
//		change.setBounds(200, 300, 120, 30);

		// second part
		
		
		
		myMenuBar.setBounds(10, 20, 700, 30);
		
		title.setBounds(510, 150, 200, 60);
		list.setBounds(510, 200, 200, 60);
		
		 formtitle3.setForeground(Color.red);
		 formtitle3.setBackground(Color.cyan);
		 wel.setForeground(Color.blue);
		 
		 wel.setFont(new Font("Serif", Font.BOLD, 22));
		 wel.setBackground(Color.cyan);
		 wel.setOpaque(true);

	
		
		


	}
	
//////////////////////_____WINDOW________/////////////////////////////////////////////////////////////////////////
	
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("STUDENT  MANAGE VOTING");
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
if(e.getSource()==submit) {
	
//	System.out.println(c_code.getText()+""+c_code.getText());
	 try {  
		 
		 if(!c_code.getText().equals("")){
	        Class.forName("com.mysql.jdbc.Driver");  
	        // establish connection  
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
	        
	        
//	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
//	        Statement st = con.createStatement();  
	        PreparedStatement ps = con.prepareStatement("select * from candidate where candidate_reg="+c_code.getText()+""); 
	          ResultSet rs = ps.executeQuery(); 
	          
	           

	          while (rs.next()) {
	        	  String c = rs.getString("candidate_reg");
//	              System.out.println(c);
	              if(c_code.getText().equals(c)) {
	            	  
	            	  
	    	            	  
	    	            	  Statement st = con.createStatement();  
	    		            	String code=c_code.getText();
	    		            	String v=v_code.getText();
	    		            	int id=1;
	    		            	String s="1";
//	    		            	System.out.println(code+" "+v+" "+id+" "+s);
	    		            	
	    		            	st.executeUpdate("INSERT INTO `votes` (`vid`, `student_reg`, `candidate_reg`, `score`) VALUES (NULL, "+v+", "+code+", "+s+")");
	    		            	// st.executeUpdate("INSERT INTO candidate VALUES(" +id+ ",'" +v+ "'");
	    		            	
	    		            	//st.executeUpdate("INSERT INTO votes VALUES(" +id+ ",'" +v+ "','" +code+ "','" +s+ "')");
	    		            	JOptionPane.showMessageDialog(null, "submit Successful");
	    	              
	    	            	 
	            	  
	    	              
	    	              }

	              
	              }
	          
		 }else {
	        	JOptionPane.showMessageDialog(null, "fill candidate reg number field to vote please");	
	        }
	          
	          
	 } catch (SQLException | ClassNotFoundException e1) {  
         
	    } 
	          
	 
	 
	        
	        

	
			
	}else if(e.getSource()==resetbtn) {
		c_code.setText("");
//		v_code.setText("");
		
		
	}

	
	


else if(e.getSource()==list) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List_of_candidates frame = new List_of_candidates();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			//student_voting anyname=new student_voting();
		});
		
		
		
	}//end of if change

	}
	
	
	 public void menuSelected(MenuEvent e) {
	      JMenu myMenuS = (JMenu) e.getSource();
	      JMenu myMenuP = (JMenu) e.getSource();
	      JMenu myMenuC = (JMenu) e.getSource();
	      JMenu myMenuLo = (JMenu) e.getSource();
	      JMenu myMenuX = (JMenu) e.getSource();
	      
	      
//	      System.out.println("Menu Selected: "+myMenuS.getText());
	      
	      if(myMenuS.getText()=="VOTE")
	      {
	    	
	    	  Student_voting obj=new Student_voting();
	    	  obj.my_update(v_code.getText());
	    	  
	    	  
	    		//obj.setVisible(true);
	    		
	   			frame.dispose();
	      }
	      if(myMenuP.getText()=="REGISTER")
	      {
	    	
	    	  student_register_as_cand obj=new student_register_as_cand();	
	    	  obj.my_update(v_code.getText());
	    	  
	    	  frame.dispose();
	      }
	      
	      if(myMenuC.getText()=="RESULT")
	      {
	    	
	    	  Student_votes obj=new Student_votes();	
	    	  obj.my_update(v_code.getText());
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
	      
	      if(myMenuX.getText()=="CHANGE PASSWORD")
	      {
	    	
	    	 Student_change_p obj=new Student_change_p();		
	    	  obj.my_update(v_code.getText());
	    	  frame.dispose();
	    	  
	    	  
	      }
	      
	      if(myMenuLo.getText()=="LOGOUT")
	      {
	    	
	    	    LoginForm obj = new LoginForm();
//	    	  obj.my_update(v_code.getText());
	    	  frame.dispose();
	    	  
	    	  
	      }
////	      
	      
	     
	   }
//	
	
///////////////////////////////////////////////////////////////////////////////////////////////
public static void main(String []args) {
	Student_voting anyname=new Student_voting();
	
	
	
	
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
