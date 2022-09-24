import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Button;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField sFirstName;
	private JTextField sLastName;
	private JTextField sEmail;
	private JTextField sAddress1;
	private JTextField sAddress2;
	private JTextField sCounty;
	private JTextField sCountry;
	private JTextField sPassword;
	private JTextField sPhone;
	private JTextField gender;
	private JTextField sAge;
	private JTable table;
	private Button button_1;
	private JTextField sCustomerID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() {
		setTitle("Customer Details");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name :");
		lblNewLabel.setBounds(10, 10, 140, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name :");
		lblNewLabel_1.setBounds(10, 33, 140, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setBounds(10, 56, 140, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address Line 1 :");
		lblNewLabel_3.setBounds(10, 79, 140, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address Line 2 :");
		lblNewLabel_4.setBounds(10, 102, 140, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("County :");
		lblNewLabel_5.setBounds(10, 125, 140, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Country :");
		lblNewLabel_6.setBounds(10, 148, 140, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password :");
		lblNewLabel_7.setBounds(10, 171, 140, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Phone Number :");
		lblNewLabel_8.setBounds(10, 194, 140, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Gender :");
		lblNewLabel_9.setBounds(10, 217, 140, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Age :");
		lblNewLabel_10.setBounds(10, 240, 140, 13);
		contentPane.add(lblNewLabel_10);
		
		sFirstName = new JTextField();
		sFirstName.setBounds(160, 7, 96, 19);
		contentPane.add(sFirstName);
		sFirstName.setColumns(10);
		
		sLastName = new JTextField();
		sLastName.setBounds(160, 30, 96, 19);
		contentPane.add(sLastName);
		sLastName.setColumns(10);
		
		sEmail = new JTextField();
		sEmail.setBounds(160, 53, 96, 19);
		contentPane.add(sEmail);
		sEmail.setColumns(10);
		
		sAddress1 = new JTextField();
		sAddress1.setBounds(160, 76, 96, 19);
		contentPane.add(sAddress1);
		sAddress1.setColumns(10);
		
		sAddress2 = new JTextField();
		sAddress2.setBounds(160, 99, 96, 19);
		contentPane.add(sAddress2);
		sAddress2.setColumns(10);
		
		sCounty = new JTextField();
		sCounty.setBounds(160, 122, 96, 19);
		contentPane.add(sCounty);
		sCounty.setColumns(10);
		
		sCountry = new JTextField();
		sCountry.setBounds(160, 145, 96, 19);
		contentPane.add(sCountry);
		sCountry.setColumns(10);
		
		sPassword = new JTextField();
		sPassword.setBounds(160, 168, 96, 19);
		contentPane.add(sPassword);
		sPassword.setColumns(10);
		
		sPhone = new JTextField();
		sPhone.setBounds(160, 191, 96, 19);
		contentPane.add(sPhone);
		sPhone.setColumns(10);
		
		gender = new JTextField();
		gender.setBounds(160, 214, 96, 19);
		contentPane.add(gender);
		gender.setColumns(10);
		
		sAge = new JTextField();
		sAge.setBounds(160, 237, 96, 19);
		contentPane.add(sAge);
		sAge.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 298, 907, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = table.getValueAt(table.getSelectedRow(), 0).toString();
				SetTextField(id);
			}
		});
		scrollPane.setViewportView(table);
		
		Button button = new Button("Create Customer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setForeground(new Color(230, 230, 250));
		button.setBackground(new Color(0, 0, 0));
		button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button.setBounds(428, 249, 159, 31);
		contentPane.add(button);
		
		button_1 = new Button("Update Customer");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					Update(sCustomerID.getText());
				}
			}
		});
		button_1.setForeground(new Color(230, 230, 250));
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(593, 249, 159, 31);
		contentPane.add(button_1);
		
		Button button_1_1 = new Button("Delete Customer");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0)
					Delete(sCustomerID.getText());
			}
		});
		button_1_1.setForeground(new Color(230, 230, 250));
		button_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_1_1.setBackground(Color.BLACK);
		button_1_1.setBounds(758, 249, 159, 31);
		contentPane.add(button_1_1);
		
		Button button_2 = new Button("Customer");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer frame = new Customer();
				frame.setVisible(true);
				CloseJframe();
			}
		});
		button_2.setForeground(new Color(0, 0, 0));
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_2.setBackground(new Color(230, 230, 250));
		button_2.setBounds(541, 10, 126, 28);
		contentPane.add(button_2);
		
		Button button_2_1 = new Button("Product");
		button_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product frame = new Product();
				frame.setVisible(true);
				CloseJframe();
			}
		});
		button_2_1.setForeground(new Color(0, 0, 0));
		button_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_2_1.setBackground(new Color(230, 230, 250));
		button_2_1.setBounds(665, 10, 126, 28);
		contentPane.add(button_2_1);
		
		Button button_2_2 = new Button("Invoice");
		button_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invoice frame = new Invoice();
				frame.setVisible(true);
				CloseJframe();
			}
		});
		button_2_2.setForeground(new Color(0, 0, 0));
		button_2_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_2_2.setBackground(new Color(230, 230, 250));
		button_2_2.setBounds(791, 10, 126, 28);
		contentPane.add(button_2_2);
		
		JLabel lblNewLabel_11 = new JLabel("Customer ID :");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_11.setBounds(331, 124, 111, 13);
		contentPane.add(lblNewLabel_11);
		
		sCustomerID = new JTextField();
		sCustomerID.setBounds(425, 118, 96, 28);
		contentPane.add(sCustomerID);
		sCustomerID.setColumns(10);
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
			String query = "insert into customer values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, null);
			ps.setString(2, sFirstName.getText());
			ps.setString(3, sLastName.getText());
			ps.setString(4, sEmail.getText());
			ps.setString(5, sAddress1.getText());
			ps.setString(6, sAddress2.getText());
			ps.setString(7, sCounty.getText());
			ps.setString(8, sCountry.getText());
			ps.setString(9, sPassword.getText());
			ps.setString(10, sPhone.getText());
			ps.setString(11, gender.getText());
			ps.setString(12, sAge.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!");
			ShowData();
			
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
	
	
	private void ShowData()
	{
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.black);
	    tableHeader.setForeground(Color.white);
	    Font headerFont = new Font("Times New Roman", Font.BOLD, 12);
	    tableHeader.setFont(headerFont);
	    model.addColumn("Customer ID");
		model.addColumn("First Name");
		model.addColumn("Last Name");
		model.addColumn("Email");
		model.addColumn("Address Line 1");
		model.addColumn("Address Line 2");
		model.addColumn("County");
		model.addColumn("Country");
		model.addColumn("Password");
		model.addColumn("Phone Number");
		model.addColumn("Gender");
		model.addColumn("Age");
		
		try {
			String query = "select * from customer";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("CustomerID"),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getString("email"),
						rs.getString("addressLine1"),
						rs.getString("addressLine2"),
						rs.getString("county"),
						rs.getString("country"),
						rs.getString("password"),
						rs.getString("phoneNumber"),
						rs.getString("gender"),
						rs.getString("age"),
				});
				
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(90);
			table.getColumnModel().getColumn(1).setPreferredWidth(65);
			table.getColumnModel().getColumn(2).setPreferredWidth(65);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(50);
			table.getColumnModel().getColumn(7).setPreferredWidth(65);
			table.getColumnModel().getColumn(8).setPreferredWidth(85);
			table.getColumnModel().getColumn(9).setPreferredWidth(90);
			table.getColumnModel().getColumn(10).setPreferredWidth(50);
			table.getColumnModel().getColumn(11).setPreferredWidth(50);
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
	}
	
	private void SetTextField(String id) {
		Connection con = con();
		try {
			String query = "select * from customer where CustomerID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sCustomerID.setText(rs.getString("CustomerID"));
				sFirstName.setText(rs.getString("firstName"));
				sLastName.setText(rs.getString("lastName"));
				sEmail.setText(rs.getString("email"));
				sAddress1.setText(rs.getString("addressLine1"));
				sAddress2.setText(rs.getString("addressLine2"));
				sCounty.setText(rs.getString("county"));
				sCountry.setText(rs.getString("country"));
				sPassword.setText(rs.getString("password"));
				sPhone.setText(rs.getString("phoneNumber"));
				gender.setText(rs.getString("gender"));
				sAge.setText(rs.getString("age"));
			}
			rs.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	private void Update (String id) {
		Connection con = con();
		try {
			String query = "update customer set firstName = ?, lastName = ?, email = ?, addressLine1 = ?, addressLine2 = ?, county = ?, country = ?, password = ?, phoneNumber = ?, gender = ?, age = ? where CustomerID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, sFirstName.getText());
			ps.setString(2, sLastName.getText());
			ps.setString(3, sEmail.getText());
			ps.setString(4, sAddress1.getText());
			ps.setString(5, sAddress2.getText());
			ps.setString(6, sCounty.getText());
			ps.setString(7, sCountry.getText());
			ps.setString(8, sPassword.getText());
			ps.setString(9, sPhone.getText());
			ps.setString(10, gender.getText());
			ps.setString(11, sAge.getText());
			ps.setString(12, id);
			ps.execute();
			
			ps.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Update successfull");
			ShowData();
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	private void Delete (String id) {
		Connection con = con();
		
		try {
			String query = "delete from customer where CustomerID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ps.execute();
			
			ps.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Deleted");
			ShowData();
		}catch (Exception e) {
			System.out.println("Error " + e);
		}
	}
	
	public void CloseJframe(){
	    super.dispose();
	}
}
