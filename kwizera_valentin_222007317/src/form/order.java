package form;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

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
import javax.swing.SwingConstants;

public class order extends JFrame {

    private static final long serialVersionUID = 1L;
	protected static final Window frame = null;
    private JPanel contentPane;
    private JTextField ordtxtf;
    private JTextField custxtf;
    private JTextField lotxtf;
    private JTextField esttxtf;
    private JTextField patxtf;
    private JTextField amtxtf;
    private JTextField totxtf;
    private JTextField ortxtf;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    order frame = new order();
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
    public order() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 1274, 613);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setForeground(new Color(128, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        JMenuItem driver = new JMenuItem("driver");
        driver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose current frame
                dispose();

                // Create and display the driver form
                driver driverFrame = new driver();
                driverFrame.setVisible(true);
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
//                dispose();
//                LoginForm obj = new LoginForm();
//
//               // obj.setTitle("Student-Login");
//                obj.setVisible(true);

            }
        });
        mnFile.add(mntmExit);
        mnFile.add(driver);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(563, 60, 684, 338);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("BOOKING");
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setBounds(256, 11, 197, 46);
        lblNewLabel.setForeground(new Color(0, 128, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("booking_id");
        lblNewLabel_1.setBounds(23, 91, 147, 20);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_1);
        
        ordtxtf = new JTextField();
        ordtxtf.setBounds(208, 94, 307, 20);
        contentPane.add(ordtxtf);
        ordtxtf.setColumns(10);
        
        
        JLabel lblNewLabel_2 = new JLabel("location");
        lblNewLabel_2.setBounds(23, 191, 117, 14);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_2);
        
        custxtf = new JTextField();
        custxtf.setBounds(208, 141, 307, 20);
        contentPane.add(custxtf);
        custxtf.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("estimated_hour");
        lblNewLabel_3.setBounds(23, 242, 147, 14);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_3);
        
        lotxtf = new JTextField();
        lotxtf.setBounds(208, 191, 307, 20);
        contentPane.add(lotxtf);
        lotxtf.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("booking_date");
        lblNewLabel_4.setBounds(23, 442, 147, 23);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_4);
        
        esttxtf = new JTextField();
        esttxtf.setBounds(208, 242, 307, 20);
        contentPane.add(esttxtf);
        esttxtf.setColumns(10);
        
        JButton btnInsert = new JButton("INSERT");
        btnInsert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kwizera_valentin_a_d_m_s", "222007317", "222007317");

                    con.setAutoCommit(true); // Set auto-commit to true

                    String sql = "INSERT INTO booking VALUES(?,?,?,?,?,?,?,?)";
                    try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setInt(1, Integer.parseInt(ordtxtf.getText()));
		                stm.setString(2, custxtf.getText());
		                stm.setString(3, lotxtf.getText());
		                stm.setString(4, esttxtf.getText());
		                stm.setString(5, patxtf.getText());
                        stm.setString(6, amtxtf.getText());
                        stm.setString(7, totxtf.getText());
                        stm.setString(8, ortxtf.getText());

                        stm.executeUpdate(); // Execute the update

                        JOptionPane.showMessageDialog(btnInsert, "Data inserted successfully!");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(btnInsert, "An error occurred. Please check the console for details.");
                }
            }

        });
        btnInsert.setBounds(33, 501, 107, 40);
        btnInsert.setBackground(new Color(0, 255, 0));
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(btnInsert);
        
        JButton btnDelete = new JButton("DELETE");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kwizera_valentin_a_d_m_s", "222007317", "222007317");

                     con.setAutoCommit(true); // Set auto-commit to true

                     String sql = "DELETE FROM booking WHERE booking_id = ?";
                     try (PreparedStatement stm = con.prepareStatement(sql)) {
                         stm.setInt(1, Integer.parseInt(ordtxtf.getText()));

                         int rowsAffected = stm.executeUpdate(); // Execute the update

                         if (rowsAffected > 0) {
                             JOptionPane.showMessageDialog(btnDelete, "Record deleted successfully!");
                         } else {
                             JOptionPane.showMessageDialog(btnDelete, "No record found with the given booking_id.");
                         }
                     }
                 } catch (Exception e2) {
                     e2.printStackTrace();
                     JOptionPane.showMessageDialog(btnDelete, "An error occurred. Please check the console for details.");
                 }
             
                // Add your delete logic here
            }
        });
        
        btnDelete.setBounds(176, 501, 117, 40);
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(btnDelete);
        
        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kwizera_valentin_a_d_m_s", "222007317", "222007317");

                    String sql = "UPDATE booking SET customer_id=?, location=?, estimated_hour=?, payment_code=?, amount_perhour=?, total_amount=?, booking_date=? WHERE booking_id=?";
                    try (PreparedStatement stm = con.prepareStatement(sql)) {
                        stm.setString(1, custxtf.getText());
                        stm.setString(2, lotxtf.getText());
                        stm.setString(3, esttxtf.getText());
                        stm.setString(4, patxtf.getText());
                        stm.setString(5, amtxtf.getText());
                        stm.setString(6, totxtf.getText());
                        stm.setString(7, ortxtf.getText());
                        stm.setInt(8, Integer.parseInt(ordtxtf.getText()));


                        int rowsAffected = stm.executeUpdate(); // Execute the update

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(btnUpdate, "Record updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(btnUpdate, "No record found with the given booking ID.");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(btnUpdate, "An error occurred. Please check the console for details.");
                }
            }
        });

        btnUpdate.setBounds(317, 501, 107, 40);
        btnUpdate.setBackground(new Color(192, 192, 192));
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(btnUpdate);
        
        JButton btnRetrieve = new JButton("RETRIEVE");
        btnRetrieve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kwizera_valentin_a_d_m_s", "222007317", "222007317");
                    PreparedStatement stm = con.prepareStatement("SELECT * FROM booking");
                    ResultSet rs = stm.executeQuery();
                    java.sql.ResultSetMetaData metaData = rs.getMetaData();

                    // Create table model with column names
                    DefaultTableModel model = new DefaultTableModel();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        model.addColumn(metaData.getColumnName(i));
                    }

                    // Populate the table model with data
                    while (rs.next()) {
                        Object[] rowData = new Object[columnCount];
                        for (int i = 1; i <= columnCount; i++) {
                            rowData[i - 1] = rs.getObject(i);
                        }
                        model.addRow(rowData);
                    }

                    // Set the table model to the JTable
                    table.setModel(model);

                    rs.close();
                    stm.close();
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(btnRetrieve, "An error occurred. Please check the console for details.");
                }
            }
        });
        btnRetrieve.setBounds(445, 501, 141, 40);
        btnRetrieve.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(btnRetrieve);
        
        JLabel lblNewLabel_5 = new JLabel("payment_code");
        lblNewLabel_5.setBounds(23, 281, 147, 29);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_5);
        
        patxtf = new JTextField();
        patxtf.setBounds(208, 287, 307, 23);
        contentPane.add(patxtf);
        patxtf.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("amount_perhour");
        lblNewLabel_6.setBounds(23, 339, 166, 23);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("total_amount");
        lblNewLabel_7.setBounds(23, 388, 166, 23);
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_7);
        
        amtxtf = new JTextField();
        amtxtf.setBounds(208, 338, 307, 24);
        contentPane.add(amtxtf);
        amtxtf.setColumns(10);
        
        totxtf = new JTextField();
        totxtf.setBounds(208, 392, 307, 20);
        contentPane.add(totxtf);
        totxtf.setColumns(10);
        
        JLabel lblNewLabel_8 = new JLabel("customer_id");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_8.setBounds(23, 137, 141, 23);
        contentPane.add(lblNewLabel_8);
        
        ortxtf = new JTextField();
        ortxtf.setBounds(208, 442, 307, 23);
        contentPane.add(ortxtf);
        ortxtf.setColumns(10);
    }
}
