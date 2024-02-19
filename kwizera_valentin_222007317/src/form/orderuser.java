package form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class orderuser extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField ordtxtf;
    private JTextField custxtf;
    private JTextField lotxtf;
    private JTextField esttxtf;
    private JTextField patxtf;
    private JTextField amtxtf;
    private JTextField totxtf;
    private JTextField ortxtf;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    orderuser frame = new orderuser();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public orderuser(String email) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 774, 613);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

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

    public orderuser() {
        // TODO Auto-generated constructor stub
    }
}
