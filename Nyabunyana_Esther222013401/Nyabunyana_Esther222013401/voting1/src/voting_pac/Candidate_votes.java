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



public class Candidate_votes implements ActionListener,MenuListener{
	private static final Object Successful = null;

	JFrame frame;
	
	private JLabel formtitle=new JLabel("");
	private JLabel reg_lb=new JLabel("");
	JLabel reg_text=new JLabel("");
	
	private JLabel fname_label=new JLabel("");
	JLabel fname_f=new JLabel("");
	
	private JLabel lname_label=new JLabel("");
	JLabel lname_f=new JLabel("");
	
	private JLabel position_l=new JLabel("");
	JLabel position_f=new JLabel("");
	
	JLabel pass=new JLabel("");
	
	
	
	
	
JMenuBar myMenuBar = new JMenuBar();
JMenu myMenuS =new JMenu("MANAGE");


JMenu myMenuP =new JMenu("RESULT");
JMenu myMenuC =new JMenu("CHANGE PASSWORD");
JMenu myMenuL =new JMenu("LOGOUT");
    
    JButton list=new JButton("VIEW LIST OF CONDIDATES");
    private JLabel title=new JLabel("CLICK HERE TO DISPLAY LIST OF CONDIDATES");
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
	
    JButton list2=new JButton("VIEW LIST OF GENERAL VOTES");
    private JLabel title2=new JLabel("CLICK HERE TO DISPLAY LIST OF GENERAL VOTES");
	
	
//    JButton list3=new JButton("VIEW LIST OF WINNERS");
//    private JLabel title3=new JLabel("CLICK HERE TO DISPLAY LIST OF WINNERS");
	
	private JLabel code_l=new JLabel("OBSERVING THAT DIALOG BOX AND WRITE POSITION CODE");
	private JLabel code_lx=new JLabel("FOR POSITION YOU WANT TO VIEW THE WINNER OF ELECTION");
	JTextField code_f=new JTextField();
	
	JButton delete=new JButton("DELETE");
	JButton view=new JButton("VIEW");
//	JButton update=new JButton("UPDATE");
	
	
	public Candidate_votes() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
		my_update(toString());
		}
		void my_update(String x) {
			
			pass.setText(x);
			
		} 
		
		
	private void addActionEvent() {
//		resetbtn.addActionListener(this);
//		submit.addActionListener(this);
		delete.addActionListener(this);
		view.addActionListener(this);
		
		list.addActionListener(this);
		list2.addActionListener(this);
//		list3.addActionListener(this);
//	//menu
		myMenuS.addMenuListener(this);
		myMenuP.addMenuListener(this);
		myMenuC.addMenuListener(this);
		myMenuL.addMenuListener(this);
}
////////////////////ADD ELEMENTS TO FRAME///////////////////////////////////////////////////////////////////////////
	private void AddComponenttoFrame() {
		
		frame.add(formtitle);
		frame.add(reg_lb);
		frame.add(reg_text);
		
		frame.add(fname_label);
		frame.add(fname_f);
		
		frame.add(lname_label);
		frame.add(lname_f);
		
		frame.add(position_l);
		frame.add(position_f);

		frame.add(code_l);
		frame.add(code_lx);
		frame.add(code_f);
		
		frame.add(delete);
		frame.add(view);
        
		//menu
		frame.add(pass);
		
        frame.add(myMenuBar);
		
        myMenuBar.add(myMenuS);
		myMenuBar.add(myMenuP);
		myMenuBar.add(myMenuC);
		myMenuBar.add(myMenuL);
		
		frame.add(title);
		frame.add(list);
		
		frame.add(title2);
		frame.add(list2);
		
//		frame.add(title3);
//		frame.add(list3);
	}
	
/////////////////////////////POSITIONING//////////////////////////////////////////////////////////////////
	private void setLocationAndSize() {
		formtitle.setBounds(20, 220, 200, 30);
		
		code_l.setBounds(20, 80, 340, 30);
		code_lx.setBounds(20, 100, 340, 30);
		code_f.setBounds(20, 140, 340, 30);
		
//		delete.setBounds(20, 190, 150, 30);
		view.setBounds(20, 180, 340, 30);
		
		reg_lb.setBounds(20, 250, 200, 30);
		reg_text.setBounds(160, 250, 200, 30);
		
		fname_label.setBounds(20, 300, 200, 30);
		fname_f.setBounds(160, 300, 200, 30);
		
		lname_label.setBounds(20, 350, 200, 30);
		lname_f.setBounds(160, 350, 200, 30);
		
		position_l.setBounds(20, 400, 200, 30);
		position_f.setBounds(160, 400, 200, 30);
		

		myMenuBar.setBounds(10, 20, 700, 30);
		
		title.setBounds(370, 80, 350, 30);
		list.setBounds(370, 119, 350, 40);
		
		title2.setBounds(370, 210, 350, 30);
		list2.setBounds(370, 240, 350, 40);
		
//		title3.setBounds(370, 340, 350, 30);
//		list3.setBounds(370, 370, 350, 40);
	}
	
//////////////////////_____WINDOW________/////////////////////////////////////////////////////////////////////////
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("CANDIDATE  MANAGE VOTES");
		frame.setBounds(10,10,770,670);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
//		update.getRootPane().setBackground(Color.gray);
	}
	@Override
	
	public void actionPerformed(ActionEvent e) {
 if(e.getSource()==delete) {
		
		 try {  
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
		        Statement st = con.createStatement();  
		        st.executeUpdate("delete from student where student_reg="+code_f.getText()+"");
		        JOptionPane.showMessageDialog(code_f, "delete Successful");
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  
		
		
	}
	else if(e.getSource()==view) {
		
		 try {  
			 if(!code_f.getText().equals("")){
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
		        PreparedStatement ps = con.prepareStatement("select fname,lname,title,sum(score) as total from student,position,votes,candidate where student.student_reg=candidate.candidate_reg and candidate.pid=position.pcode and candidate.candidate_reg=votes.candidate_reg and pid='"+code_f.getText()+"'   group by lname limit 1;"); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		              String reg = rs.getString("fname");
		              String fname = rs.getString("lname");
		              String lname = rs.getString("title");
		              String title = rs.getString("total");
//		              String email = rs.getString("email");
		              
		              formtitle.setText("WINNER AT THAT POSITION IS :");
		              
		              reg_lb.setText("FIRST NAME");
		              fname_label.setText("LAST NAME");
		              lname_label.setText("POSITION TITLE");
		              position_l.setText("SCORE(VOTES)");
		              
		              
		              reg_text.setText(reg);
		      		fname_f.setText(fname);
		      		lname_f.setText(lname);
		      		position_f.setText(title);
//		      		email_f.setText(email);
		              

		          }
		          
		          
			 }else {
		        	JOptionPane.showMessageDialog(null, "fill position  field please");	
		        }
		          
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }
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
 
else if(e.getSource()==list2) {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				List_of_general_votes frame = new List_of_general_votes();
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
	      
	      
//	      System.out.println("Menu Selected: "+myMenuS.getText());
	      
	      if(myMenuS.getText()=="MANAGE")
	      {
	    	
	    	  Candidate_register obj=new Candidate_register();
	    	  obj.my_update(pass.getText());
	   			
	   			frame.dispose();
	      }
	      if(myMenuC.getText()=="CHANGE PASSWORD")
	      {
	    	
	    	  Candidate_change_p obj=new Candidate_change_p();	
	    	  obj.my_update(pass.getText());
	    	  frame.dispose();
	      }
	      
	      if(myMenuP.getText()=="RESULT")
	      {
	    	
	    	  Candidate_votes obj=new Candidate_votes();	
	    	  obj.my_update(pass.getText());
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
	Candidate_votes anyname=new Candidate_votes();
	
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
	
//	List_of_position frame = new List_of_position();
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
