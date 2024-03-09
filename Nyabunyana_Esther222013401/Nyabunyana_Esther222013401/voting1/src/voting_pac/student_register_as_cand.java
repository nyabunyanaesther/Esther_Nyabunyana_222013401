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



public class student_register_as_cand implements ActionListener,MenuListener{
//	private static final Object Successful = null;

//////////////////////////FRAMS AND COMPONENTS/////////////////////////////////////////////////////////////////////
	JFrame frame;
	
	private JLabel formtitle=new JLabel("BEFORE YOU REGISTER AS CANDIDATE CLICK VIEW BUTTON TO SEE ALL POSITIONS AND IT INFORMATIONS AND THEN ");
	private JLabel formtitle2=new JLabel(" FILL FORM WITH HIS/HER POSITION CODE  ");
	private JLabel formtitle3=new JLabel("  IF YOU SAVE CHANGES OR REGISTER AND YOU DONT NOT SEE COMFIRMATION MESSAGE IT MEANS POSITION CODE DOES NOT EXIST ");
	
	
	private JLabel code_lb=new JLabel("CANDIDATE REG NO");
	JLabel c_code=new JLabel();
	
	private JLabel position_lb=new JLabel("POSITION CODE");
	JTextField v_code=new JTextField();
	
	
	
	private
	JButton submit=new JButton("REGISTER");
	JButton resetbtn=new JButton("CLEAN");
	
	JButton change=new JButton("SAVE CHANGE");
	

	private JLabel code_l=new JLabel("REGISTRATION NUMBER");
	JLabel code_f=new JLabel();
	
	JButton delete=new JButton("DELETE");
	JButton view=new JButton("VIEW");
	JButton update=new JButton("UPDATE");
	
	
	
	
	
	
JMenuBar myMenuBar = new JMenuBar();
	
    JMenu myMenuS =new JMenu("VOTE");
    JMenu myMenuC =new JMenu("REGISTER");
    
    JMenu myMenuP =new JMenu("RESULT");
    JMenu myMenuL =new JMenu("LOGOUT");
    JMenu myMenuX =new JMenu("CHANGE PASSWORD");
    
    
    //title
    
   	JButton list=new JButton("VIEW LIST OF CANDIDATE WITH INFORMATION");
       private JLabel title=new JLabel("CLICK HERE TO DISPLAY LIST");
       
   	JButton list2=new JButton("VIEW LIST OF POSITION WITH INFORMATION");
    private JLabel title2=new JLabel("CLICK HERE TO DISPLAY LIST OF POSITION");
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
	
	public student_register_as_cand() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
		my_update(toString());
	}
	void my_update(String x) {
		
		c_code.setText(x);
		code_f.setText(x);
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	private void addActionEvent() {
		resetbtn.addActionListener(this);
		submit.addActionListener(this);
		
		
		delete.addActionListener(this);
		view.addActionListener(this);
		update.addActionListener(this);
		change.addActionListener(this);
//		change.addActionListener(this);
		
		list.addActionListener(this);
		list2.addActionListener(this);
		
		//menu
				myMenuS.addMenuListener(this);
				myMenuP.addMenuListener(this);
				myMenuC.addMenuListener(this);
				myMenuL.addMenuListener(this);
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
		
		
		frame.add(resetbtn);
		frame.add(submit);
		
		frame.add(change);
		
		frame.add(code_l);
		frame.add(code_f);
		
		frame.add(delete);
		frame.add(view);
		frame.add(update);
		
		
		
//menu
		
        frame.add(myMenuBar);
		
		myMenuBar.add(myMenuS);
		myMenuBar.add(myMenuC);
		myMenuBar.add(myMenuP);
		myMenuBar.add(myMenuX);
		myMenuBar.add(myMenuL);
		
		frame.add(title);
		frame.add(list);
		frame.add(title2);
		frame.add(list2);
	}
	
/////////////////////////////POSITIONING//////////////////////////////////////////////////////////////////
	private void setLocationAndSize() {
		formtitle.setBounds(20, 90, 900, 30);
		formtitle2.setBounds(20, 115, 900, 30);
		formtitle3.setBounds(20, 137, 900, 30);
		
		code_lb.setBounds(20, 200, 200, 30);
		c_code.setBounds(180, 200, 140, 30);
		
		position_lb.setBounds(20, 250, 200, 30);
		v_code.setBounds(180, 250, 140, 30);
		
		
		
		submit.setBounds(20, 300, 80, 30);
		resetbtn.setBounds(110, 300, 80, 30);
//		change.setBounds(200, 300, 120, 30);

		// second part
		change.setBounds(200, 300, 120, 30);

		// second part
		
		code_l.setBounds(20, 450, 200, 30);
		code_f.setBounds(220, 450, 100, 30);
		
		//buttons
		delete.setBounds(20, 490, 90, 30);
		view.setBounds(120, 490, 90, 30);
		update.setBounds(220, 490, 100, 30);
		
		
		
		myMenuBar.setBounds(10, 20, 700, 30);
		
		title.setBounds(360, 170, 350, 40);
		list.setBounds(360, 200, 350, 40);
		
		title2.setBounds(360, 260, 350, 40);
		list2.setBounds(360, 290, 350, 40);
		
		 formtitle3.setForeground(Color.red);
		
		


	}
	
//////////////////////_____WINDOW________/////////////////////////////////////////////////////////////////////////
	
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("STUDENT REGISTER AS CANDIDATE");
		frame.setBounds(10,10,800,670);
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
	
	 try {  
		 
		 if(!v_code.getText().equals("")){
			 
	        Class.forName("com.mysql.jdbc.Driver");  
	        // establish connection  
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
	        Statement st = con.createStatement();  
	        String code=c_code.getText();
	        String v=v_code.getText();
//	       
	        
	        
	        
	        PreparedStatement ps = con.prepareStatement("select * from position where  pcode='"+v+"'"); 
			  ResultSet rs = ps.executeQuery(); 

			  while (rs.next()) {
			      String cd = rs.getString("pcode");
	
			      	
			      if(v.equals(cd)) {

				        st.executeUpdate("INSERT INTO candidate VALUES('" +code+ "','" +v+ "')");
				        JOptionPane.showMessageDialog(null, "you registered Successful");
			      }
			  }
	        
		 }else {
	        	JOptionPane.showMessageDialog(null, "fill candidate reg number field to vote please");	
	        }
	    } catch (SQLException | ClassNotFoundException e1) {  
	         
	    }  
	
			
	}else if(e.getSource()==resetbtn) {
//		c_code.setText("");
		v_code.setText("");
		
		
	}

	else if(e.getSource()==delete) {
		
		 try {  
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
		        Statement st = con.createStatement();  
		        st.executeUpdate("delete from candidate where candidate_reg="+code_f.getText()+"");
		        JOptionPane.showMessageDialog(code_f, "delete Successful");
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}
	else if(e.getSource()==view) {
		
		 try {  
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
		        PreparedStatement ps = con.prepareStatement("select * from candidate where candidate_reg="+code_f.getText()+""); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		              String cand = rs.getString("candidate_reg");
		              String p = rs.getString("pid");
		              
		              
		              c_code.setText(cand);
		      		v_code.setText(p);
		      		
		              
//		              System.out.println("reg is "+cand+" "+p+" ");

		              // do something with the extracted data...
		          }
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}	else if(e.getSource()==update) {
		
		 try {  
			 
			
				 
			 
			 
			 
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
//		        
		        
		        PreparedStatement ps = con.prepareStatement("select * from candidate where candidate_reg="+code_f.getText()+""); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		        	  String cand = rs.getString("candidate_reg");
		              String p = rs.getString("pid");
		              
		              
		              c_code.setText(cand);
		      		v_code.setText(p);
		              
		          
		          }
		          
			
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}
	else if(e.getSource()==change) {
		
		 try {  
			 
			 if(!v_code.getText().equals("")){
			  Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        Statement st = con.createStatement();  
		        String reg=c_code.getText();
		        String p=v_code.getText();
		        
		        
		        
		        PreparedStatement ps = con.prepareStatement("select * from position where  pcode='"+p+"'"); 
				  ResultSet rs = ps.executeQuery(); 

				  while (rs.next()) {
				      String cd = rs.getString("pcode");
		
				      	
				      if(p.equals(cd)) {

				    	   st.executeUpdate("update candidate set pid='" +p+ "' where candidate_reg="+code_f.getText()+"");
					        JOptionPane.showMessageDialog(code_f, "updated Successful");
				      }
				  }
	              
	              
		         }else {
		        	JOptionPane.showMessageDialog(null, "fill candidate reg number field please");	
		        }
		   
		        
		     
		          
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}//end of if change

	
	


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

else if(e.getSource()==list2) {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				List_of_position frame = new List_of_position();
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
	      JMenu myMenuL = (JMenu) e.getSource();
	      JMenu myMenuX = (JMenu) e.getSource();
	      
	      
//	      System.out.println("Menu Selected: "+myMenuS.getText());
	      
	      if(myMenuS.getText()=="VOTE")
	      {
	    	
	    	  Student_voting obj=new Student_voting();
	    	  obj.my_update(c_code.getText());
	   			
	   			frame.dispose();
	      }
	      if(myMenuP.getText()=="REGISTER")
	      {
	    	
	    	  student_register_as_cand obj=new student_register_as_cand();	
	    	  obj.my_update(c_code.getText());
	    	  frame.dispose();
	      }
	      
	      if(myMenuC.getText()=="RESULT")
	      {
	    	
	    	  Student_votes obj=new Student_votes();
	    	  obj.my_update(c_code.getText());
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
	    	  obj.my_update(c_code.getText());
	    	  frame.dispose();
	    	  
	    	  
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
	student_register_as_cand anyname=new student_register_as_cand();
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
