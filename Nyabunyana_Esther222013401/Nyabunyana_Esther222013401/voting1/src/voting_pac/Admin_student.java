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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
//import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;





import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;



public class Admin_student implements ActionListener,MenuListener{
	private static final Object Successful = null;

	JFrame frame;
	
	private JLabel formtitle=new JLabel("REGISTER STUDENT");
	private JLabel reg_lb=new JLabel("REG NUMBER");
	JTextField reg_text=new JTextField();
	
	private JLabel fname_label=new JLabel("FIRST NAME");
	JTextField fname_f=new JTextField();
	
	private JLabel lname_label=new JLabel("LAST NAME");
	JTextField lname_f=new JTextField();
	
	private JLabel phone_label=new JLabel("TELEPHONE");
	JTextField phone_f=new JTextField();
	
	private JLabel email_label=new JLabel("EMAIL");
	JTextField email_f=new JTextField();
	
	private JLabel pl=new JLabel("PASSWORD");
	JTextField pf=new JTextField();
	
	private

	JButton submit=new JButton("SUBMIT");
	JButton resetbtn=new JButton("CLEAN");
	JButton change=new JButton("SAVE CHANGE");
	
	
	
	
	private JLabel code_l=new JLabel("REGISTRATION NUMBER");
	JTextField code_f=new JTextField();
	
	JButton delete=new JButton("DELETE");
	JButton view=new JButton("VIEW");
	JButton update=new JButton("UPDATE");
	
	
	//menu
	

	JMenuBar myMenuBar = new JMenuBar();
	
    JMenu myMenuS =new JMenu("STUDENTS");
    JMenu myMenuC =new JMenu("POSITION");
    
    JMenu myMenuP =new JMenu("CANDIDATE");
    JMenu myMenuV =new JMenu("VOTES");
    JMenu myMenuL =new JMenu("LOGOUT");
    
    
    //title
    
	JButton list=new JButton("VIEW LIST OF STUDENTS");
    private JLabel title=new JLabel("CLICK HERE TO DISPLAY STUDENTS");
    
	
	public Admin_student() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
	}
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
	private void AddComponenttoFrame() {
		
		frame.add(formtitle);
		frame.add(reg_lb);
		frame.add(reg_text);
		
		frame.add(fname_label);
		frame.add(fname_f);
		
		frame.add(lname_label);
		frame.add(lname_f);
		
		frame.add(phone_label);
		frame.add(phone_f);
		
		frame.add(email_label);
		frame.add(email_f);
		
		frame.add(pl);
		frame.add(pf);
		
		
		frame.add(list);

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
	}
	private void setLocationAndSize() {
		formtitle.setBounds(120, 60, 200, 30);
		
		reg_lb.setBounds(20, 100, 200, 30);
		reg_text.setBounds(120, 100, 200, 30);
		
		fname_label.setBounds(20, 150, 200, 30);
		fname_f.setBounds(120, 150, 200, 30);
		
		lname_label.setBounds(20, 200, 200, 30);
		lname_f.setBounds(120, 200, 200, 30);
		
		phone_label.setBounds(20, 250, 200, 30);
		phone_f.setBounds(120, 250, 200, 30);
		
		email_label.setBounds(20, 300, 200, 30);
		email_f.setBounds(120, 300, 200, 30);
		
		pl.setBounds(20, 350, 200, 30);
		pf.setBounds(120, 350, 200, 30);
		
		submit.setBounds(20, 400, 80, 30);
		resetbtn.setBounds(110, 400, 80, 30);
		change.setBounds(200, 400, 120, 30);

		// second part
		
		code_l.setBounds(20, 500, 200, 30);
		code_f.setBounds(220, 500, 100, 30);
		
		//buttons
		delete.setBounds(20, 540, 90, 30);
		view.setBounds(120, 540, 90, 30);
		update.setBounds(220, 540, 100, 30);
		
				//bar
		myMenuBar.setBounds(10, 20, 700, 30);
		
		title.setBounds(360, 150, 350, 60);
		list.setBounds(360, 200, 350, 60);

		


	}
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("ADMIN  MANAGE STUDENT");
		frame.setBounds(10,10,770,670);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
//		update.getRootPane().setBackground(Color.gray);
	}
	@SuppressWarnings("unlikely-arg-type")
	@Override
	
	public void actionPerformed(ActionEvent e) {
if(e.getSource()==submit) {
	
	 try {  
	        Class.forName("com.mysql.jdbc.Driver");  
	        // establish connection  
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
	        Statement st = con.createStatement();  
	        String reg=reg_text.getText();
	        String fname=fname_f.getText();
	        String lname=lname_f.getText();
	        String phone=phone_f.getText();
	        String email=email_f.getText();
	        String pass=pf.getText();
	               
	        if(!reg.equals("") && !fname.equals("") && !lname.equals("") && !phone.equals("") && !email.equals("") && !pf.equals("")  ){
	        	
	        st.executeUpdate("INSERT INTO student VALUES('" +reg+ "','" +fname+ "','"+lname+"','"+phone+"','"+email+"','"+pass+"')");
	        JOptionPane.showMessageDialog(null, "submit Successful");
	        }else {
	        	JOptionPane.showMessageDialog(null, "fill all fields please");	
	        }
	   
	    } catch (SQLException | ClassNotFoundException e1) {  
	         
	    }  
	
			
	}else if(e.getSource()==resetbtn) {
		reg_text.setText("");
		fname_f.setText("");
		lname_f.setText("");
		phone_f.setText("");
		email_f.setText("");
		pf.setText("");
		
	}

	else if(e.getSource()==delete) {
		
		 try {  
			 
			 
		     if(!code_f.getText().equals("")){
		        	
			        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        Statement st3 = con.createStatement();  
		        st3.executeUpdate("delete from votes where candidate_reg="+code_f.getText()+"");
		        
		        Statement st2 = con.createStatement();  
		        st2.executeUpdate("delete from candidate where candidate_reg="+code_f.getText()+"");
		        
		        Statement st = con.createStatement();  
		        st.executeUpdate("delete from student where student_reg="+code_f.getText()+"");
		        
		        
		        
		        JOptionPane.showMessageDialog(code_f, "delete Successful");
			        }else {
			        	JOptionPane.showMessageDialog(null, "fill reg number fields please");	
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
		        
		        PreparedStatement ps = con.prepareStatement("select * from student where student_reg="+code_f.getText()+""); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		              String reg = rs.getString("student_reg");
		              String fname = rs.getString("fname");
		              String lname = rs.getString("lname");
		              String phone = rs.getString("phone");
		              String email = rs.getString("email");
		              String pass = rs.getString("password");
		              
		              
		              
		              reg_text.setText(reg);
		      		fname_f.setText(fname);
		      		lname_f.setText(lname);
		      		phone_f.setText(phone);
		      		email_f.setText(email);
		      		pf.setText(pass);
		              
		          
		          }
			   }else {
		        	JOptionPane.showMessageDialog(null, "fill reg number fields please");	
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
		        
		        PreparedStatement ps = con.prepareStatement("select * from student where student_reg="+code_f.getText()+""); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		              String reg = rs.getString("student_reg");
		              String fname = rs.getString("fname");
		              String lname = rs.getString("lname");
		              String phone = rs.getString("phone");
		              String email = rs.getString("email");
		              String pass = rs.getString("password");
		              
		              reg_text.setText(reg);
		      		fname_f.setText(fname);
		      		lname_f.setText(lname);
		      		phone_f.setText(phone);
		      		email_f.setText(email);
		      		pf.setText(pass);
		              
		          
		          }
		          
			  }else {
		        	JOptionPane.showMessageDialog(null, "fill reg number fields to view please");	
		        }
		   
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}
	else if(e.getSource()==change) {
		
		 try {  
			  Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        Statement st = con.createStatement();  
		        String reg=reg_text.getText();
		        String fname=fname_f.getText();
		        String lname=lname_f.getText();
		        String phone=phone_f.getText();
		        String email=email_f.getText();
		        String p=pf.getText();
		        
		        //System.out.println(fname);
//		        
		        if(!reg.equals("") && !fname.equals("") && !lname.equals("") && !phone.equals("") && !email.equals("") && !pf.equals("")  ){
		        	
		        st.executeUpdate("update student set student_reg='" +reg+ "', fname='" +fname+ "' ,lname='"+lname+"',phone='"+phone+"', email='"+email+"', password='"+p+"' where student_reg="+code_f.getText()+"");
		        JOptionPane.showMessageDialog(code_f, "updated Successful");
		        }else {
		        	JOptionPane.showMessageDialog(null, "fill all field please!");
		        }
		          
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}//end of if change

	else if(e.getSource()==list) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List_of_students frame = new List_of_students();
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
	   			frame.dispose();
	      }
	      if(myMenuP.getText()=="POSITION")
	      {
	    	  
//	    	  PreparedStatement ps = con.prepareStatement("select student.student_reg,fname,lname,title from student,position,candidate"
//		        		+ " where student.student_reg=candidate.candidate_reg and position.pcode=candidate.pid and candidate.candidate_reg='"+code_f.getText()+"'"); 
//		          ResultSet rs = ps.executeQuery();
	    	
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
	
	
	
public static void main(String []args) {
	Admin_student anyname=new Admin_student();
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
