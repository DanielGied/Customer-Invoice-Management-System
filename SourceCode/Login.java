import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 170);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel email = new JLabel("E-mail :");
		email.setFont(new Font("Times New Roman", Font.BOLD, 12));
		email.setBounds(10, 10, 96, 24);
		contentPane.add(email);
		
		JLabel password = new JLabel("Password :");
		password.setFont(new Font("Times New Roman", Font.BOLD, 12));
		password.setBounds(10, 44, 65, 24);
		contentPane.add(password);
		
		emailField = new JTextField();
		emailField.setBounds(99, 13, 117, 19);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(99, 47, 117, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp frame = new SignUp();
				frame.setVisible(true);
				CloseJframe();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(10, 93, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","danielg");
					Statement stmt=con.createStatement();
					String sql="Select * from administrator where email ='"+ emailField.getText() +"' and password = '" + passwordField.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						Customer frame = new Customer();
						frame.setVisible(true);
						JOptionPane.showMessageDialog(null, "Login Successfully...");
						CloseJframe();
					}
					else
						JOptionPane.showMessageDialog(null, "Inccorect email or password...");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(131, 93, 85, 21);
		contentPane.add(btnNewButton_1);
	}
	
	public void CloseJframe(){
	    super.dispose();
	}
}
