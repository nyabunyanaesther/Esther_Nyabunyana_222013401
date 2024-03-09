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



public class Admin_candidates implements ActionListener,MenuListener{
	private static final Object Successful = null;

	JFrame frame;
	
	private JLabel formtitle=new JLabel("CONDIDATE INFORMATION");
	private JLabel reg_lb=new JLabel("");
	JLabel reg_text=new JLabel("");
	
	private JLabel fname_label=new JLabel("");
	JLabel fname_f=new JLabel("");
	
	private JLabel lname_label=new JLabel("");
	JLabel lname_f=new JLabel("");
	
	private JLabel position_l=new JLabel("");
	JLabel position_f=new JLabel("");
	
	
	
	
	
JMenuBar myMenuBar = new JMenuBar();
	
    JMenu myMenuS =new JMenu("STUDENTS");
    JMenu myMenuC =new JMenu("POSITION");
    
    JMenu myMenuP =new JMenu("CANDIDATE");
    JMenu myMenuV =new JMenu("VOTES");
    JMenu myMenuL =new JMenu("LOGOUT");
    
    JButton list=new JButton("VIEW LIST OF CONDIDATES");
    private JLabel title=new JLabel("CLICK HERE TO DISPLAY LIST OF CONDIDATES");
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	private JLabel code_l=new JLabel("REGISTRATION NUMBER");
	JTextField code_f=new JTextField();
	
	JButton delete=new JButton("DELETE");
	JButton view=new JButton("VIEW");
//	JButton update=new JButton("UPDATE");
	
	
	public Admin_candidates() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
	}
	private void addActionEvent() {
//		resetbtn.addActionListener(this);
//		submit.addActionListener(this);
		delete.addActionListener(this);
		view.addActionListener(this);
		
		list.addActionListener(this);
//	//menu
		myMenuS.addMenuListener(this);
		myMenuP.addMenuListener(this);
		myMenuC.addMenuListener(this);
		myMenuV.addMenuListener(this);
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
		frame.add(code_f);
		
		frame.add(delete);
		frame.add(view);
        
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
		formtitle.setBounds(20, 220, 200, 30);
		
		code_l.setBounds(20, 100, 200, 30);
		code_f.setBounds(210, 100, 150, 30);
		
		delete.setBounds(20, 150, 150, 30);
		view.setBounds(210, 150, 150, 30);
		
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
		list.setBounds(370, 119, 350, 60);
	}
	
//////////////////////_____WINDOW________/////////////////////////////////////////////////////////////////////////
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("ADMIN  MANAGE CANDIDATES");
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
			 if(!code_f.getText().equals("")){
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
		        Statement st = con.createStatement();  
		        st.executeUpdate("delete from student where student_reg="+code_f.getText()+"");
		        JOptionPane.showMessageDialog(code_f, "delete Successful");
		        
			 }else {
		        	JOptionPane.showMessageDialog(null, "fill candidate reg number fields to delete please");	
		        }
		   
		    } catch (SQLException | ClassNotFoundException e1) {  
		         
		    }  	
	}
	else if(e.getSource()==view) {
//		System.out.println("test my event view");
		 try {  
			 
			 if(!code_f.getText().equals("")){
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "root", "");  
		        
		        PreparedStatement ps = con.prepareStatement("select student.student_reg,fname,lname,title from student,position,candidate"
		        		+ " where student.student_reg=candidate.candidate_reg and position.pcode=candidate.pid and candidate.candidate_reg='"+code_f.getText()+"'"); 
		          ResultSet rs = ps.executeQuery(); 

		          while (rs.next()) {
		              String reg = rs.getString("student_reg");
		              String fname = rs.getString("fname");
		              String lname = rs.getString("lname");
		              String title = rs.getString("title");

		              
		              reg_lb.setText("REG NUMBER");
		              fname_label.setText("FIRST NAME");
		              lname_label.setText("LAST NAME");
		              position_l.setText("POSITION TITLE");
		              
		              
		              reg_text.setText(reg);
		      		fname_f.setText(fname);
		      		lname_f.setText(lname);
		      		position_f.setText(title);

		          }
		          
			 }else {
		        	JOptionPane.showMessageDialog(null, "fill candidate reg number fields to view please");	
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
		
	}	

 public void menuSelected(MenuEvent e) {
     JMenu myMenuS = (JMenu) e.getSource();
     JMenu myMenuP = (JMenu) e.getSource();
     JMenu myMenuC = (JMenu) e.getSource();
     JMenu myMenuV = (JMenu) e.getSource();
     JMenu myMenuL = (JMenu) e.getSource();
     
     
//     System.out.println("Menu Selected: "+myMenuS.getText());
     
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
//   	  obj.my_update(v_code.getText());
   	  frame.dispose();
   	  
     }
  }
//

///////////////////////////////////////////////////////////////////////////////////////////////
public static void main(String []args) {
	Admin_candidates anyname=new Admin_candidates();
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
