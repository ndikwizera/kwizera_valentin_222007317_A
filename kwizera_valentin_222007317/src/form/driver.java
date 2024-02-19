package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class driver extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dritxf;
	private JTextField firstxf;
	private JTextField lastxf;
	private JTextField phonetxf;
	private JTextField emaitxf;
	private JTextField adrestxf;
	private JTextField licetxf;
	private JTable table;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					driver frame = new driver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param username 
	 */
	public driver(String username) {
		setTitle("DRIVER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        JMenuItem order = new JMenuItem("order");
        order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose current frame
                dispose();

                // Create and display the order form
                order orderFrame = new order();
                orderFrame.setVisible(true);
            }
        });

        JMenuItem mntmExit = new JMenuItem("log out");
        mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(mntmExit, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    LoginForm obj = new LoginForm();
                   // obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
                dispose();
                LoginForm obj = new LoginForm();

               // obj.setTitle("Student-Login");
                obj.setVisible(true);

            }
        });
        mnFile.add(mntmExit);
        mnFile.add(order);
		
		table = new JTable();
        table.setBounds(30, 540, 980, 200);
        contentPane.add(table);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(442, 110, 576, 200);
        contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("DRIVER");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(192, 30, 167, 37);
		contentPane.add(lblNewLabel);
		
		dritxf = new JTextField();
		dritxf.setBounds(192, 108, 216, 20);
		contentPane.add(dritxf);
		dritxf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("first Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(30, 164, 144, 20);
		contentPane.add(lblNewLabel_2);
		
		firstxf = new JTextField();
		firstxf.setBounds(192, 167, 216, 20);
		contentPane.add(firstxf);
		firstxf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("last Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(31, 212, 127, 31);
		contentPane.add(lblNewLabel_3);
		
		lastxf = new JTextField();
		lastxf.setBounds(192, 220, 216, 20);
		contentPane.add(lastxf);
		lastxf.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("phone number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(30, 268, 144, 37);
		contentPane.add(lblNewLabel_4);
		
		phonetxf = new JTextField();
		phonetxf.setBounds(192, 279, 216, 20);
		contentPane.add(phonetxf);
		phonetxf.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(30, 331, 123, 31);
		contentPane.add(lblNewLabel_5);
		
		emaitxf = new JTextField();
		emaitxf.setBounds(192, 339, 216, 20);
		contentPane.add(emaitxf);
		emaitxf.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("driver ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(30, 108, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("adress");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(30, 381, 98, 31);
		contentPane.add(lblNewLabel_6);
		
		adrestxf = new JTextField();
		adrestxf.setBounds(192, 389, 216, 20);
		contentPane.add(adrestxf);
		adrestxf.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("license category");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(30, 438, 156, 31);
		contentPane.add(lblNewLabel_7);
		
		licetxf = new JTextField();
		licetxf.setBounds(192, 446, 216, 20);
		contentPane.add(licetxf);
		licetxf.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kwizera_valentin_a_d_m_s","222007317","222007317");
			String sql="INSERT INTO driver VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(dritxf.getText()));
			st.setString(2,firstxf.getText());
			st.setString(3, lastxf.getText());
			st.setString(4, phonetxf.getText());
			st.setString(5, emaitxf.getText());
			st.setString(6, adrestxf.getText());
			st.setString(7, licetxf.getText() );
	            
			
			st.executeUpdate();
			JOptionPane.showMessageDialog(btnNewButton, "data saved!!");
			
			st.close();
			con.close();
					
					
					
					
					
					
					
					
					
				} catch (Exception e2) {
					
				}	
			}
		});
		btnNewButton.setBackground(new Color(128, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(30, 493, 128, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   
			        try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kwizera_valentin_a_d_m_s_system", "222007317", "222007317");

			            con.setAutoCommit(true); // Set auto-commit to true

			            String sql = "DELETE FROM driver WHERE driver_ID=?";
			            try (PreparedStatement stm = con.prepareStatement(sql)) {
			                stm.setInt(1, Integer.parseInt(dritxf.getText()));
			                
			                int rowsAffected = stm.executeUpdate(); // Execute the update

			                if (rowsAffected > 0) {
			                    JOptionPane.showMessageDialog(btnNewButton_1, "Record deleted successfully!");
			                } else {
			                    JOptionPane.showMessageDialog(btnNewButton_1, "No record found with the given driver ID.");
			                }
			            }
			        } catch (Exception e2) {
			            e2.printStackTrace();
			            JOptionPane.showMessageDialog(btnNewButton_1, "An error occurred. Please check the console for details.");
			        }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(168, 493, 117, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kwizera_valentin_a_d_m_s", "222007317", "222007317");

		            con.setAutoCommit(true); // Set auto-commit to true

		            String sql = "UPDATE driver SET  first_Name=?, last_Name=?, phone_number=?, email=?, address=?, license_category=? WHERE driver_ID=?";
		            try (PreparedStatement st = con.prepareStatement(sql)) {
		        		st.setString(1,firstxf.getText());
		        		st.setString(2, lastxf.getText());
		        		st.setString(3, phonetxf.getText());
		        		st.setString(4, emaitxf.getText());
		        		st.setString(5, adrestxf.getText());
		        		st.setString(6, licetxf.getText() );
		        		st.setInt(7, Integer.parseInt(dritxf.getText()));
		                
		                int rowsAffected = st.executeUpdate(); // Execute the update

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(btnNewButton_2, "Record updated successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(btnNewButton_2, "No record found with the given driver ID.");
		                }
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(btnNewButton_2, "An error occurred. Please check the console for details.");
		        }
		    }
		});
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setBounds(299, 494, 108, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VIEW");
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		    	try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kwizera_valentin_a_d_m_s", "222007317", "222007317");
		            PreparedStatement pst = con.prepareStatement("SELECT * FROM driver");
		            ResultSet rs = pst.executeQuery();

		            DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("Driver ID");
		            model.addColumn("First Name");
		            model.addColumn("Last Name");
		            model.addColumn("Phone Number");
		            model.addColumn("Email");
		            model.addColumn("Address");
		            model.addColumn("License Category");

		            while (rs.next()) {
		                model.addRow(new Object[]{
		                    rs.getInt(1),
		                    rs.getString(2),
		                    rs.getString(3),
		                    rs.getString(4),
		                    rs.getString(5),
		                    rs.getString(6),
		                    rs.getString(7)
		                });
		            }

		            table.setModel(model);

		            con.close();
		        } catch (Exception e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(null, "An error occurred while fetching data from the database.");
		        }
		    
		    }
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_3.setBounds(429, 493, 108, 36);
		contentPane.add(btnNewButton_3);
	}

	public driver() {
		// TODO Auto-generated constructor stub
	}

}
