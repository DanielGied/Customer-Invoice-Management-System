import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField uFirstName;
	private JTextField uLastName;
	private JTextField uEmail;
	private JTextField uConfirmEmail;
	private JTextField uAddress1;
	private JTextField uAddress2;
	private JTextField uCounty;
	private JTextField uCountry;
	private JTextField uAge;
	private JTextField uPhone;
	private String gender;
	private JPasswordField uPassword;
	private JPasswordField uConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Form Registration");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(183, 10, 161, 28);
		contentPane.add(lblNewLabel);
		
		JLabel fName = new JLabel("First Name *");
		fName.setBounds(10, 68, 69, 13);
		contentPane.add(fName);
		
		uFirstName = new JTextField();
		uFirstName.setBounds(109, 65, 96, 19);
		contentPane.add(uFirstName);
		uFirstName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name *");
		lblNewLabel_2.setBounds(10, 101, 78, 13);
		contentPane.add(lblNewLabel_2);
		
		uLastName = new JTextField();
		uLastName.setBounds(109, 98, 96, 19);
		contentPane.add(uLastName);
		uLastName.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail *");
		lblEmail.setBounds(251, 68, 45, 13);
		contentPane.add(lblEmail);
		
		uEmail = new JTextField();
		uEmail.setBounds(379, 65, 96, 19);
		contentPane.add(uEmail);
		uEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm E-mail *");
		lblNewLabel_3.setBounds(251, 101, 93, 13);
		contentPane.add(lblNewLabel_3);
		
		uConfirmEmail = new JTextField();
		uConfirmEmail.setBounds(379, 98, 96, 19);
		contentPane.add(uConfirmEmail);
		uConfirmEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address Line 1 *");
		lblNewLabel_4.setBounds(10, 136, 97, 13);
		contentPane.add(lblNewLabel_4);
		
		uAddress1 = new JTextField();
		uAddress1.setBounds(109, 133, 96, 19);
		contentPane.add(uAddress1);
		uAddress1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Address Line 2 *");
		lblNewLabel_5.setBounds(251, 136, 97, 13);
		contentPane.add(lblNewLabel_5);
		
		uAddress2 = new JTextField();
		uAddress2.setBounds(379, 133, 96, 19);
		contentPane.add(uAddress2);
		uAddress2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("County *");
		lblNewLabel_6.setBounds(10, 169, 69, 13);
		contentPane.add(lblNewLabel_6);
		
		uCounty = new JTextField();
		uCounty.setBounds(109, 166, 96, 19);
		contentPane.add(uCounty);
		uCounty.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Country *");
		lblNewLabel_7.setBounds(251, 169, 62, 13);
		contentPane.add(lblNewLabel_7);
		
		uCountry = new JTextField();
		uCountry.setBounds(379, 166, 96, 19);
		contentPane.add(uCountry);
		uCountry.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Age *");
		lblNewLabel_8.setBounds(10, 203, 69, 13);
		contentPane.add(lblNewLabel_8);
		
		uAge = new JTextField();
		uAge.setBounds(109, 200, 96, 19);
		contentPane.add(uAge);
		uAge.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Phone Number *");
		lblNewLabel_9.setBounds(10, 235, 97, 13);
		contentPane.add(lblNewLabel_9);
		
		uPhone = new JTextField();
		uPhone.setBounds(109, 232, 96, 19);
		contentPane.add(uPhone);
		uPhone.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Gender");
		lblNewLabel_10.setBounds(251, 203, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		JRadioButton MaleButton = new JRadioButton("Male");
		MaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Male";
			}
		});
		MaleButton.setBackground(new Color(0, 139, 139));
		MaleButton.setBounds(372, 199, 103, 21);
		contentPane.add(MaleButton);
		
		JRadioButton FemaleButton = new JRadioButton("Female");
		FemaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Female";
			}
		});
		FemaleButton.setBackground(new Color(0, 139, 139));
		FemaleButton.setBounds(372, 219, 103, 21);
		contentPane.add(FemaleButton);
		
		JRadioButton OtherButton = new JRadioButton("Other");
		OtherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Other";
			}
		});
		OtherButton.setBackground(new Color(0, 139, 139));
		OtherButton.setBounds(372, 242, 103, 21);
		contentPane.add(OtherButton);
		
		ButtonGroup group = new ButtonGroup(); 
		group.add(MaleButton);
		group.add(FemaleButton);
		group.add(OtherButton);
		
		JLabel lblNewLabel_1 = new JLabel("Password *");
		lblNewLabel_1.setBounds(10, 290, 78, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_11 = new JLabel("Confirm Password *");
		lblNewLabel_11.setBounds(251, 290, 122, 13);
		contentPane.add(lblNewLabel_11);
		
		Button button = new Button("Sign Up");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String FirstName = uFirstName.getText().toString();
				String LastName = uLastName.getText().toString();
				String Email = uEmail.getText().toString();
				String ConfirmEmail = uConfirmEmail.getText().toString();
				String Address1 = uAddress1.getText().toString();
				String Address2 = uAddress2.getText().toString();
				String County = uCounty.getText().toString();
				String Country = uCountry.getText().toString();
				String Age = uAge.getText().toString();
				String Phone = uPhone.getText().toString();
				String Password = uPassword.getText().toString();
				String ConfirmPassword = uConfirmPassword.getText().toString();
				
				if(FirstName.equals("")) {
					JOptionPane.showMessageDialog(null,"First Name is Required");
				}
				else if(LastName.equals("")) {
					JOptionPane.showMessageDialog(null,"Last Name is Required");
				}
				else if(Email.equals("")) {
					JOptionPane.showMessageDialog(null,"Email is Required");
				}
				else if(ConfirmEmail.equals("")) {
					JOptionPane.showMessageDialog(null,"Confirm Email is Required");
				}
				else if(Address1.equals("")) {
					JOptionPane.showMessageDialog(null,"Address Line 1 is Required");
				}
				else if(Address2.equals("")) {
					JOptionPane.showMessageDialog(null,"Address Line 2 is Required");
				}
				else if(County.equals("")) {
					JOptionPane.showMessageDialog(null,"County is Required");
				}
				else if(Country.equals("")) {
					JOptionPane.showMessageDialog(null,"Country is Required");
				}
				else if(Age.equals("")) {
					JOptionPane.showMessageDialog(null,"Age is Required");
				}
				else if(Phone.equals("")) {
					JOptionPane.showMessageDialog(null,"Phone is Required");
				}
				else if(Password.equals("")) {
					JOptionPane.showMessageDialog(null,"Password is Required");
				}
				else if(ConfirmPassword.equals("")) {
					JOptionPane.showMessageDialog(null,"Confirm Password is Required");
				}
				else {
				SaveToDatabase();
				}
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button.setForeground(UIManager.getColor("Button.background"));
		button.setBackground(new Color(0, 0, 0));
		button.setBounds(1, 342, 165, 21);
		contentPane.add(button);
		
		Button button_1 = new Button("Clear");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				uFirstName.setText(null);
				uLastName.setText(null);
				uEmail.setText(null);
				uConfirmEmail.setText(null);
				uAddress1.setText(null);
				uAddress2.setText(null);
				uCounty.setText(null);
				uCountry.setText(null);
				uAge.setText(null);
				uPhone.setText(null);
				uPassword.setText(null);
				uConfirmPassword.setText(null);
				group.clearSelection();
			}
		});
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button_1.setForeground(UIManager.getColor("Button.background"));
		button_1.setBackground(new Color(0, 0, 0));
		button_1.setBounds(164, 342, 171, 21);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Sign In Page");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				CloseJframe();
			}
		});
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button_2.setForeground(UIManager.getColor("Button.background"));
		button_2.setBackground(new Color(0, 0, 0));
		button_2.setBounds(333, 342, 152, 21);
		contentPane.add(button_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(1, 0, 484, 48);
		contentPane.add(panel);
		
		uPassword = new JPasswordField();
		uPassword.setBounds(109, 287, 96, 19);
		contentPane.add(uPassword);
		
		uConfirmPassword = new JPasswordField();
		uConfirmPassword.setBounds(379, 287, 96, 19);
		contentPane.add(uConfirmPassword);
	}
	
	static Connection con() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydatabase";
			Class.forName(driver);
			
			return DriverManager.getConnection(url,"root", "danielg");
			
		}catch (Exception e) {
			System.out.println("Connection failed! " + e);
		}
		return null;
	}
	
	private void SaveToDatabase() {
		Connection con = con();
		
		try {
			String query = "insert into administrator values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, null);
			ps.setString(2, uFirstName.getText());
			ps.setString(3, uLastName.getText());
			ps.setString(4, uEmail.getText());
			ps.setString(5, uAddress1.getText());
			ps.setString(6, uAddress2.getText());
			ps.setString(7, uCounty.getText());
			ps.setString(8, uCountry.getText());
			ps.setString(9, uPassword.getText());
			ps.setString(10, uPhone.getText());
			ps.setString(11, gender);
			ps.setString(12, uAge.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!");
			
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
	
	public void CloseJframe(){
	    super.dispose();
	}
}
