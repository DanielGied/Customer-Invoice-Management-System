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

public class Product extends JFrame {

	private JPanel contentPane;
	private JTextField ProductID;
	private JTextField ProductBrand;
	private JTextField ProductName;
	private JTextField Description;
	private JTextField Price;
	private JTable table;
	private Button button_1;
	private JTextField Quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
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
	public Product() {
		setTitle("Product Details");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(309, 102, 140, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Brand :");
		lblNewLabel_1.setBounds(10, 25, 140, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Name :");
		lblNewLabel_2.setBounds(10, 48, 140, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Description :");
		lblNewLabel_3.setBounds(10, 71, 140, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price :");
		lblNewLabel_4.setBounds(10, 94, 140, 13);
		contentPane.add(lblNewLabel_4);
		
		ProductID = new JTextField();
		ProductID.setBounds(387, 99, 96, 19);
		contentPane.add(ProductID);
		ProductID.setColumns(10);
		
		ProductBrand = new JTextField();
		ProductBrand.setBounds(160, 22, 96, 19);
		contentPane.add(ProductBrand);
		ProductBrand.setColumns(10);
		
		ProductName = new JTextField();
		ProductName.setBounds(160, 45, 96, 19);
		contentPane.add(ProductName);
		ProductName.setColumns(10);
		
		Description = new JTextField();
		Description.setBounds(160, 68, 96, 19);
		contentPane.add(Description);
		Description.setColumns(10);
		
		Price = new JTextField();
		Price.setBounds(160, 91, 96, 19);
		contentPane.add(Price);
		Price.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 616, 243);
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
		
		Button button = new Button("Create Product");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setForeground(new Color(230, 230, 250));
		button.setBackground(new Color(0, 0, 0));
		button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button.setBounds(239, 182, 125, 31);
		contentPane.add(button);
		
		button_1 = new Button("Update Product");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					Update(ProductID.getText());
				}
			}
		});
		button_1.setForeground(new Color(230, 230, 250));
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(370, 182, 125, 31);
		contentPane.add(button_1);
		
		Button button_1_1 = new Button("Delete Product");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0)
					Delete(ProductID.getText());
			}
		});
		button_1_1.setForeground(new Color(230, 230, 250));
		button_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_1_1.setBackground(Color.BLACK);
		button_1_1.setBounds(501, 182, 125, 31);
		contentPane.add(button_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity :");
		lblNewLabel_5.setBounds(10, 117, 140, 13);
		contentPane.add(lblNewLabel_5);
		
		Quantity = new JTextField();
		Quantity.setBounds(160, 114, 96, 19);
		contentPane.add(Quantity);
		Quantity.setColumns(10);
		
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
		button_2_2.setBounds(526, 10, 100, 28);
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
		button_2_1.setBounds(427, 10, 100, 28);
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
		button_2.setBounds(327, 10, 100, 28);
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
			String query = "insert into product values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, null);
			ps.setString(2, ProductBrand.getText());
			ps.setString(3, ProductName.getText());
			ps.setString(4, Description.getText());
			ps.setString(5, Price.getText());
			ps.setString(6, Quantity.getText());
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
		model.addColumn("Product ID");
		model.addColumn("Product Brand");
		model.addColumn("Product Name");
		model.addColumn("Description");
		model.addColumn("Price");
		model.addColumn("Quantity");
		
		try {
			String query = "select * from product";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("productID"),
						rs.getString("productBrand"),
						rs.getString("productName"),
						rs.getString("description"),
						rs.getString("price"),
						rs.getString("quantity"),
				});
				
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(85);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(150);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(85);
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
	}
	
	private void SetTextField(String id) {
		Connection con = con();
		try {
			String query = "select * from product where productID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductID.setText(rs.getString("productID"));
				ProductBrand.setText(rs.getString("productBrand"));
				ProductName.setText(rs.getString("productName"));
				Description.setText(rs.getString("description"));
				Price.setText(rs.getString("price"));
				Quantity.setText(rs.getString("quantity"));
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
			String query = "update product set productBrand = ?, productName = ?, description = ?, price = ?, quantity = ? where productID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ProductBrand.getText());
			ps.setString(2, ProductName.getText());
			ps.setString(3, Description.getText());
			ps.setString(4, Price.getText());
			ps.setString(5, Quantity.getText());
			ps.setString(6, id);
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
			String query = "delete from product where productID = ?";
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

