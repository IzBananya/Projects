import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.*;
import java.sql.*;

public class UI {
	
	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	static String firstName;
	static String lastName;
	static String ageString;
	static int age;
	
    static final String DB_URL = ""; //insert database url  
    static final String USER = ""; // insert database username
    static final String PASS = ""; // insert database password
    static final String QUERY = "SELECT * FROM People";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name: ");
		lblNewLabel.setBounds(107, 65, 74, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setBounds(107, 103, 74, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblAge = new JLabel("Age: ");
		lblAge.setBounds(107, 135, 42, 14);
		frame.getContentPane().add(lblAge);
		
		tf1 = new JTextField();
		tf1.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				ContainerEvent firstName = e;
			}
		});
		tf1.setBounds(191, 62, 86, 20);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(191, 100, 86, 20);
		frame.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(191, 132, 86, 20);
		frame.getContentPane().add(tf3);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstName = tf1.getText();
				lastName = tf2.getText();
				ageString = tf3.getText();
				age = Integer.parseInt(ageString);
				
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(QUERY);
						PreparedStatement pstmt = conn.prepareStatement("INSERT INTO people(First_Name, Last_Name, Age) VALUES(?, ?, ?)")
								){
					pstmt.setString(1, firstName);
					pstmt.setString(2, lastName);
					pstmt.setInt(3, age);
					pstmt.executeUpdate();
				}
				catch (SQLException e1) {
					throw new RuntimeException(e1);
				}
				System.exit(0);	
				
			}
		});
		confirm.setBounds(145, 196, 115, 33);
		frame.getContentPane().add(confirm);
	}	
}
