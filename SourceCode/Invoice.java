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

public class Invoice extends JFrame {

	private JPanel contentPane;
	private JTextField InvoiceID;
	private JTextField CustomerID;
	private JTextField ProductID;
	private JTextField Quantity;
	private JTextField Price;
	private JTable table;
	private Button button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
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
	public Invoice() {
		setTitle("Invoice Details");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Invoice ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(330, 90, 140, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID :");
		lblNewLabel_1.setBounds(10, 21, 140, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product ID :");
		lblNewLabel_2.setBounds(10, 44, 140, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity :");
		lblNewLabel_3.setBounds(10, 67, 140, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price :");
		lblNewLabel_4.setBounds(10, 90, 140, 13);
		contentPane.add(lblNewLabel_4);
		
		InvoiceID = new JTextField();
		InvoiceID.setBounds(399, 87, 96, 19);
		contentPane.add(InvoiceID);
		InvoiceID.setColumns(10);
		
		CustomerID = new JTextField();
		CustomerID.setBounds(160, 18, 96, 19);
		contentPane.add(CustomerID);
		CustomerID.setColumns(10);
		
		ProductID = new JTextField();
		ProductID.setBounds(160, 41, 96, 19);
		contentPane.add(ProductID);
		ProductID.setColumns(10);
		
		Quantity = new JTextField();
		Quantity.setBounds(160, 64, 96, 19);
		contentPane.add(Quantity);
		Quantity.setColumns(10);
		
		Price = new JTextField();
		Price.setBounds(160, 87, 96, 19);
		contentPane.add(Price);
		Price.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 635, 243);
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
		
		Button button = new Button("Create Invoice");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setForeground(new Color(230, 230, 250));
		button.setBackground(new Color(0, 0, 0));
		button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button.setBounds(273, 161, 120, 31);
		contentPane.add(button);
		
		button_1 = new Button("Update Invoice");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					Update(InvoiceID.getText());
				}
			}
		});
		button_1.setForeground(new Color(230, 230, 250));
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(399, 161, 120, 31);
		contentPane.add(button_1);
		
		Button button_1_1 = new Button("Delete Invoice");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0)
					Delete(InvoiceID.getText());
			}
		});
		button_1_1.setForeground(new Color(230, 230, 250));
		button_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_1_1.setBackground(Color.BLACK);
		button_1_1.setBounds(525, 161, 120, 31);
		contentPane.add(button_1_1);
		
		Button button_2_2 = new Button("Invoice");
		button_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invoice frame = new Invoice();
				frame.setVisible(true);
				CloseJframe();
			}
		});
		button_2_2.setForeground(Color.BLACK);
		button_2_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_2_2.setBackground(new Color(230, 230, 250));
		button_2_2.setBounds(545, 10, 100, 28);
		contentPane.add(button_2_2);
		
		Button button_2_1 = new Button("Product");
		button_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product frame = new Product();
				frame.setVisible(true);
				CloseJframe();
			}
		});
		button_2_1.setForeground(Color.BLACK);
		button_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_2_1.setBackground(new Color(230, 230, 250));
		button_2_1.setBounds(445, 10, 100, 28);
		contentPane.add(button_2_1);
		
		Button button_2 = new Button("Customer");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer frame = new Customer();
				frame.setVisible(true);
				CloseJframe();
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_2.setBackground(new Color(230, 230, 250));
		button_2.setBounds(345, 10, 100, 28);
		contentPane.add(button_2);
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
			String query = "insert into invoice values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, null);
			ps.setString(2, CustomerID.getText());
			ps.setString(3, ProductID.getText());
			ps.setString(4, Quantity.getText());
			ps.setString(5, Price.getText());
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
		model.addColumn("Invoice ID");
		model.addColumn("Customer ID");
		model.addColumn("Product ID");
		model.addColumn("Quantity");
		model.addColumn("Price");
		
		try {
			String query = "select * from invoice";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("invoiceID"),
						rs.getString("customerID"),
						rs.getString("productID"),
						rs.getString("quantity"),
						rs.getString("price"),
				});
				
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(130);
			table.getColumnModel().getColumn(1).setPreferredWidth(130);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(130);
			table.getColumnModel().getColumn(4).setPreferredWidth(115);
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
	}
	
	private void SetTextField(String id) {
		Connection con = con();
		try {
			String query = "select * from invoice where invoiceID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				InvoiceID.setText(rs.getString("invoiceID"));
				CustomerID.setText(rs.getString("customerID"));
				ProductID.setText(rs.getString("productID"));
				Quantity.setText(rs.getString("quantity"));
				Price.setText(rs.getString("price"));
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
			String query = "update invoice set customerID = ?, productID = ?, quantity = ?, price = ? where invoiceID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, CustomerID.getText());
			ps.setString(2, ProductID.getText());
			ps.setString(3, Quantity.getText());
			ps.setString(4, Price.getText());
			ps.setString(5, id);
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
			String query = "delete from invoice where invoiceID = ?";
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

