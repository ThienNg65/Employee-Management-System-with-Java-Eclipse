import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;

public class Employee {

	private JFrame frame;
	private JTextField jtxtEmployeeID;
	private JTable table;
	private JLabel lblEmployeeID;
	private JScrollPane scrollPane;
	private JLabel lblName;
	private JTextField jtxtName;
	private JLabel lblGender;
	private JTextField jtxtGender;
	private JLabel lblPhoneNum;
	private JTextField jtxtPhoneNum;
	private JLabel lblEmail;
	private JTextField jtxtEmail;
	private JLabel lblDesignation;
	private JTextField jtxtDesignation;
	private JLabel lblSalary;
	private JTextField jtxtSalary;
	private JButton btnPrint;
	private JButton btnReset;
	private JButton btnExit;
	private JButton btnAddNew;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	
	public void updateTabel() {
		conn = MyDBMS.ConnectDB();
		
		if(conn != null) {
			String sql = "id, name, gender, phoneNum, email, designation, salary";
		
		
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				Object[] columnData = new Object[8];
				
				while (rs.next()) {
					columnData[0] = rs.getString("id");
					columnData[1] = rs.getString("name");
					columnData[2] = rs.getString("gender");
					columnData[3] = rs.getString("phoneNum");
					columnData[4] = rs.getString("email");
					columnData[5] = rs.getString("designation");
					columnData[6] = rs.getString("salary");
					
					model.addRow(columnData);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
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
	public Employee() {
		initialize();
		
		conn = MyDBMS.ConnectDB();
		Object col[] = {"id", "name", "gender", "phoneNum", "email", "designation", "salary"};
		model.setColumnIdentifiers(col);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		jtxtEmployeeID = new JTextField();
		jtxtEmployeeID.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtxtEmployeeID.setBounds(273, 71, 160, 39);
		frame.getContentPane().add(jtxtEmployeeID);
		jtxtEmployeeID.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(511, 71, 690, 415);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		
		lblEmployeeID = new JLabel("Employee ID");
		lblEmployeeID.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmployeeID.setBounds(57, 80, 160, 20);
		frame.getContentPane().add(lblEmployeeID);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(57, 143, 160, 20);
		frame.getContentPane().add(lblName);
		
		jtxtName = new JTextField();
		jtxtName.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtxtName.setColumns(10);
		jtxtName.setBounds(273, 134, 160, 39);
		frame.getContentPane().add(jtxtName);
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(57, 207, 160, 20);
		frame.getContentPane().add(lblGender);
		
		jtxtGender = new JTextField();
		jtxtGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtxtGender.setColumns(10);
		jtxtGender.setBounds(273, 198, 160, 39);
		frame.getContentPane().add(jtxtGender);
		
		lblPhoneNum = new JLabel("Phone Number");
		lblPhoneNum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhoneNum.setBounds(57, 271, 160, 20);
		frame.getContentPane().add(lblPhoneNum);
		
		jtxtPhoneNum = new JTextField();
		jtxtPhoneNum.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtxtPhoneNum.setColumns(10);
		jtxtPhoneNum.setBounds(273, 262, 160, 39);
		frame.getContentPane().add(jtxtPhoneNum);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(57, 333, 160, 20);
		frame.getContentPane().add(lblEmail);
		
		jtxtEmail = new JTextField();
		jtxtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtxtEmail.setColumns(10);
		jtxtEmail.setBounds(273, 324, 160, 39);
		frame.getContentPane().add(jtxtEmail);
		
		lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDesignation.setBounds(57, 395, 160, 20);
		frame.getContentPane().add(lblDesignation);
		
		jtxtDesignation = new JTextField();
		jtxtDesignation.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtxtDesignation.setColumns(10);
		jtxtDesignation.setBounds(273, 386, 160, 39);
		frame.getContentPane().add(jtxtDesignation);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(57, 456, 160, 20);
		frame.getContentPane().add(lblSalary);
		
		jtxtSalary = new JTextField();
		jtxtSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtxtSalary.setColumns(10);
		jtxtSalary.setBounds(273, 447, 160, 39);
		frame.getContentPane().add(jtxtSalary);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header = new MessageFormat("Printing in Progress");
				
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				
				try {
					table.print();
				} catch (java.awt.print.PrinterException ev) {
					System.err.format("No Printer found", ev.getMessage());
				}
				
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPrint.setBounds(388, 533, 200, 65);
		frame.getContentPane().add(btnPrint);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtEmployeeID.setText(null);
				jtxtName.setText(null);
				jtxtGender.setText(null);
				jtxtPhoneNum.setText(null);
				jtxtEmail.setText(null);
				jtxtDesignation.setText(null);
				jtxtSalary.setText(null);
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(677, 533, 200, 65);
		frame.getContentPane().add(btnReset);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Employee Database System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(960, 533, 200, 65);
		frame.getContentPane().add(btnExit);
		
		btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "INSERT INTO employee(id, name, gender, phoneNum, email, designation, salary)values(?,?,?,?,?,?,?)";
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, jtxtEmployeeID.getText());
					pst.setString(2, jtxtName.getText());
					pst.setString(3, jtxtGender.getText());
					pst.setString(4, jtxtPhoneNum.getText());
					pst.setString(5, jtxtEmail.getText());
					pst.setString(6, jtxtDesignation.getText());
					pst.setString(7, jtxtSalary.getText());
					
					pst.execute();
					
					rs.close();
					
					pst.close();
				} catch (Exception ev) {
					JOptionPane.showMessageDialog(null, "System Update Completed!");
				}
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						jtxtEmployeeID.getText(),
						jtxtName.getText(),
						jtxtGender.getText(),
						jtxtPhoneNum.getText(),
						jtxtEmail.getText(),
						jtxtDesignation.getText(),
						jtxtSalary.getText(),
				});
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Membership update confirmed","Employee Database System", JOptionPane.OK_OPTION);
					}
				}
			}
		});
		btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddNew.setBounds(104, 533, 200, 65);
		frame.getContentPane().add(btnAddNew);
		
		lblNewLabel = new JLabel("Employee Database Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(57, 20, 463, 28);
		frame.getContentPane().add(lblNewLabel);
	}
}
