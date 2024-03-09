package voting_pac;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class List_of_students extends JFrame {

	private JPanel contentPane;
	private javax.swing.JTable jt1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List_of_students frame = new List_of_students();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
	
	}

	/**
	 * Create the frame.
	 */
public List_of_students() {
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 400, 305);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
		
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 64, 366, 107);
	contentPane.add(scrollPane);
	//My_test obj=new My_test();// with test data
	my_mysql obj=new my_mysql();
	
	
	 JLabel titles=new JLabel("LIST OF  STUDENTS ABLE TO VOTE");
	 contentPane.add(titles);
	 titles.setBounds(10, 20, 300, 30);
		
	String[] column= {"REG NUMBER","FIRST NAME","LAST NAME","EMAIL","PHONE"};
	
//jt1=new javax.swing.JTable(obj.my_test_select(),column);//test data
	jt1 = new javax.swing.JTable(obj.my_db_select(),column);
	scrollPane.setViewportView(jt1);
	}


public List_of_students(DefaultTableModel defaultTableModel) {
		// TODO Auto-generated constructor stub
	}


public class my_mysql {

public  String[][] my_db_select() {
////////////
String[][] data = new String[8][5]; // [rows][columns]
	
try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/voting","root","");  
	Statement st=con.createStatement();  
	
  ResultSet rs=st.executeQuery("SELECT * FROM STUDENT "); 
// Looping to store result in returning array data // 
	int i=0;
	while(rs.next())  {
	 for(int j=0;j<5;j++)
	 {	 
	  data[i][j]=rs.getString(j+1);
	 } 
	 i=i+1;
	}

con.close();  
}catch(Exception e){ System.out.println(e);} 
//////////////////////////////

return data;


	}
}


public void setPreferredScrollableViewportSize(Dimension dimension) {
	// TODO Auto-generated method stub
	
}



}