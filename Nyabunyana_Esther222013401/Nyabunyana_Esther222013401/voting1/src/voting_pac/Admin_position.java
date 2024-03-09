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



public class Admin_position implements ActionListener,MenuListener{
	private static final Object Successful = null;

//////////////////////////FRAMS AND COMPONENTS/////////////////////////////////////////////////////////////////////
	JFrame frame;
	
	private JLabel formtitle=new JLabel("ADDING POSSITION FOR CONDIDATE");
	private JLabel code_lb=new JLabel("POSITION CODE");
	JTextField pcode_f=new JTextField();
	
	private JLabel position_lb=new JLabel("POSITION TITLE");
	JTextField position_title=new JTextField();
	
	
	
	private
	JButton submit=new JButton("SUBMIT");
	JButton resetbtn=new JButton("CLEAN");
	JButton change=new JButton("SAVE CHANGE");
	
	
	
	
	private JLabel code_l=new JLabel("POSITION CODE");
	JTextField code_f=new JTextField();
	
	JButton delete=new JButton("DELETE");
	JButton view=new JButton("VIEW");
	JButton update=new JButton("UPDATE");
	
JMenuBar myMenuBar = new JMenuBar();
	
    JMenu myMenuS =new JMenu("STUDENTS");
    JMenu myMenuC =new JMenu("POSITION");
    
    JMenu myMenuP =new JMenu("CANDIDATE");
    JMenu myMenuV =new JMenu("VOTES");
    JMenu myMenuL =new JMenu("LOGOUT");
    
    
    //title
    
   	JButton list=new JButton("VIEW LIST OF POSITIONS");
       private JLabel title=new JLabel("CLICK HERE TO DISPLAY LIST");
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Admin_position() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////
	private void addActionEvent() {
		resetbtn.addActionListener(this);
		submit.addActionListener(this);
		delete.addActionListener(this);
		view.addActionListener(this);
		update.addActionListener(this);
		change.addActionListener(this);
		
		list.addActionListener(this);
		
		//menu
				myMenuS.addMenuListener(this);
				myMenuP.addMenuListener(this);
				myMenuC.addMenuListener(this);
				myMenuV.addMenuListener(this);
				myMenuL.addMenuListener(this);
	}
////////////////////ADD ELEMENTS TO FRAME///////////////////////////////////////////////////////////////////////////
	private void AddComponenttoFrame() {
		
		frame.add(formtitle);
		frame.add(code_lb);
		frame.add(pcode_f);
		
		frame.add(position_lb);
		frame.add(position_title);
		
		
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
		myMenuBar.add(myMenuV);
		myMenuBar.add(myMenuL);
		
		frame.add(title);
		frame.add(list);
	}
	
/////////////////////////////POSITIONING//////////////////////////////////////////////////////////////////
	private void setLocationAndSize() {
		formtitle.setBounds(20, 50, 300, 30);
		
		code_lb.setBounds(20, 100, 200, 30);
		pcode_f.setBounds(120, 100, 200, 30);
		
		position_lb.setBounds(20, 150, 200, 30);
		position_title.setBounds(120, 150, 200, 30);
		
		
		
		submit.setBounds(20, 210, 80, 30);
		resetbtn.setBounds(110, 210, 80, 30);
		change.setBounds(200, 210, 120, 30);

		// second part
		
		code_l.setBounds(20, 350, 200, 30);
		code_f.setBounds(220, 350, 100, 30);
		
		//buttonsmyMenuBar.setBounds(10, 20, 700, 30);
		delete.setBounds(20, 390, 90, 30);
		view.setBounds(120, 390, 90, 30);
		update.setBounds(220, 390, 100, 30);
		
		myMenuBar.setBounds(10, 20, 700, 30);
		
		title.setBounds(360, 150, 350, 60);
		list.setBounds(360, 200, 350, 60);
		
		


	}
	
//////////////////////_____WINDOW________/////////////////////////////////////////////////////////////////////////
	
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("ADMIN  MANAGE POSITION");
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
	
	 try {  
		 
		 if(!pcode_f.getText().equals("") && !position_title.getText().equals("")){
			 
	        Class.forName("com.mysql.jdbc.Driver");  
	        // establish connection  
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
	        Statement st = con.createStatement();  
	        String code=pcode_f.getText();
	        String title=position_title.getText();
	        
	        st.executeUpdate("INSERT INTO position VALUES('" +code+ "','" +title+ "')");
	        JOptionPane.showMessageDialog(code_f, "submit Successful");
	        
		  }else {
	        	JOptionPane.showMessageDialog(null, "fill all fields please");	
	        }
	   
	   
	    } catch (SQLException | ClassNotFoundException e1) {  
	         
	    }  
	
			
	}else if(e.getSource()==resetbtn) {
		pcode_f.setText("");
		position_title.setText("");
		
		
	}

	else if(e.getSource()==delete) {
		//System.out.println(code_f.getText());
		
		 try {
			 
			 if(!code_f.getText().equals("")){
			 
			 
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
		        Statement st = con.createStatement();  
		        st.executeUpdate("delete from position where pcode='"+code_f.getText()+"'");
		        JOptionPane.showMessageDialog(code_f, "delete Successful");
			  }else {
		        	JOptionPane.showMessageDialog(null, "fill position code fields to delete please");	
		        }
		   
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}
	else if(e.getSource()==view) {
		
		 try {  
			 if(!code_f.getText().equals("")){
				 
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
		        PreparedStatement ps = con.prepareStatement("select * from position where pcode='"+code_f.getText()+"'"); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		              String code = rs.getString("pcode");
		              String title = rs.getString("title");
		              
		              
		              pcode_f.setText(code);
		      		position_title.setText(title);
		      		

		          }
		          
			 }else {
		        	JOptionPane.showMessageDialog(null, "fill position code fields to view please");	
		        }
		   
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}	else if(e.getSource()==update) {
		
		 try {  
			 
			 if(!code_f.getText().equals("")){
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
//		        
		        
		        PreparedStatement ps = con.prepareStatement("select * from position where pcode='"+code_f.getText()+"'"); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		        	  String code = rs.getString("pcode");
		              String title = rs.getString("title");
		              
		              pcode_f.setText(code);
		      		position_title.setText(title);
		      		
		              
		          
		          }
		          
			 }else {
		        	JOptionPane.showMessageDialog(null, "fill position code fields to update please");	
		        }
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}
	else if(e.getSource()==change) {
		
		 try {  
			 
			 if(!pcode_f.getText().equals("") && !position_title.getText().equals("")){
				 
			 
			  Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        Statement st = con.createStatement();  
		        String code=pcode_f.getText();
		        String title=position_title.getText();
		       
		        
//		        System.out.println(fname);
//		        
		        
		        st.executeUpdate("update position set pcode='" +code+ "', title='" +title+"' where pcode='"+code_f.getText()+"'");
		        JOptionPane.showMessageDialog(code_f, "updated Successful");
		        
			 }else {
		        	JOptionPane.showMessageDialog(null, "fill all fields please");	
		        }
		          
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}//end of if change


else if(e.getSource()==list) {
		
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
	      JMenu myMenuV = (JMenu) e.getSource();
	      JMenu myMenuL = (JMenu) e.getSource();
	      
	      
//	      System.out.println("Menu Selected: "+myMenuS.getText());
	      
	      if(myMenuS.getText()=="STUDENTS")
	      {
	    	
	    	  Admin_student anyname=new Admin_student();
	   			//student_voting anyname=new student_voting();
	   			frame.dispose();
	      }
	      if(myMenuP.getText()=="POSITION")
	      {
	    	
	    	  Admin_position anyname=new Admin_position();	
	    	  frame.dispose();
	      }
	      
	      if(myMenuC.getText()=="CANDIDATE")
	      {
	    	
	    	  Admin_candidates anyname=new Admin_candidates();	
	    	  frame.dispose();
	      }
	      
	      if(myMenuV.getText()=="VOTES")
	      {
	    	
	    	  Admin_votes anyname=new Admin_votes();	
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
	Admin_position anyname=new Admin_position();
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
