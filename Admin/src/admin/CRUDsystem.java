package admin;


import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;





// imports for Database 

import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.w3c.dom.events.Event;
import org.w3c.dom.ls.LSOutput;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;import javax.swing.RowFilter;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Label;
import java.awt.event.WindowStateListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;

public class CRUDsystem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
      
	
	//================================================================
	//  Connection Class\
	PreparedStatement preparedStatement;
	DbConnection dbConnection = new DbConnection();
	Connection connection = dbConnection.connection();
	ResultSet resultSet;
	
	
	
	
	
	private JTextField txtMiddleName ;
	private JTextField txtAddress;
	private JTextField txtID;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtSearch;
	private JRadioButtonMenuItem radioFemale;
	private JRadioButtonMenuItem radioMale;
	private JMenu menuCivilStatus;
	private JButton btnConfirm;
	JLabel lblError;
	
	String targetConfirm ="";
	
	
	
	//================ GLOBAL VARIABLE FOR DATA ===========
	 
	
	String iD ="";
	String lastname = "";
	String firstname = "";
	String middlename = "";
	String address = "";
	String sex ="N/A";
	String civiStatus = "";
	
	
	
	
	
	private JButton btnUpdateCustomer;
	private JButton btnRemoveCustomer;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblNewLabel_2;
	private JSeparator separator_2;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JTabbedPane tabbedPane;
	private JPanel panelEnrollNew;
	private JButton btnEnrollNew;
	private JPanel panelRequests;
	private JButton btnRequests;
	private JButton btnAdvance;
	private JPanel panel_4;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtEnrollIDNumber;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtEnrollFirstName;
	private JTextField txtEnrollLastName;
	private JTextField txtEnrollMiddleName;
	private JPanel panel;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JMenuBar menuBar_1;
	private JMenu menuEnrollYear;
	private JMenuItem mntmNewMenuItem_3;
	private JPanel panel_1;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JPanel panel_3;
	private JMenuBar menuBar_2;
	private JMenu menuEnrollSection;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JLabel lblNewLabel_11;
	private JTextField txtEnrollCourse;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JTextField txtEnrollUsername;
	private JTextField txtEnrollPassword;
	private JTable tableRequeast;
	private JScrollPane scrollPane_1;
	private JPanel panelRequestEnroll;
	private JLabel lblRequestProfile;
	private JLabel lblRequestID;
	private JLabel lblRequestName;
	private JLabel lblStudentID;
	private JLabel lblStudentName;
	private JLabel lblSex1;
	private JLabel lblStudentSex;
	private JTextArea textAreaRequeastAboutME;
	private JLabel lblNewLabel_16;
	private JButton btnRequeastAccept;
	private JLabel lblRequestCountTable;
	private JButton btnRequestEnrollAll;
	private JLabel lblAddress_1;
	private JLabel lblStudentAddress;
	private JComboBox comboBoxSortRequest;
	private JLabel lblNewLabel_14;
	private JButton btnNewButton_2;
	private JPanel panelActive;
	private JButton btnViewPresent;
	private JTable tablePresent;
	private JScrollPane scrollPane_2;
	private JTable tableAbsent;
	private JScrollPane scrollPane_3;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_17;
	private JLabel lblNotif;
	private JLabel lblCountPresent;
	private JComboBox comboBoxSortRequest_1;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel label;
	private JLabel lblNewLabel_24;
	
	//============================Db Query=============
	
	
	//=========== For Refresh Data====
	public void refreshData()  {
		
		String Select = "SELECT * FROM Customer_data";
		try {
			preparedStatement = connection.prepareStatement(Select);
			resultSet = preparedStatement.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			// == Close 
		}
			
	}
	
	//========================== SHOW PRESENTS STUDENTS ===================
	
	
	public void showPresentStudents() {
		
		String queryString ="SELECT FirstName,LastName,StudentYear,CurrentDate FROM Student WHERE Active ='Active'";
		
		try {
			preparedStatement = connection.prepareStatement(queryString);
			resultSet = preparedStatement.executeQuery();
   tablePresent.setModel(DbUtils.resultSetToTableModel(resultSet));
   
   sortPresentTable(comboBoxSortRequest_1.getSelectedItem().toString());
   
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		

	}
	
	
	//================================== SHOW ALL NOT PRESENT STUDENT ============
	
	public void showNotPresent() {
		
	String queryString ="SELECT FirstName,LastName,StudentYear FROM Student WHERE Active ='notActive' AND Enrolled = 'Enrolled'";
		
		try {
			preparedStatement = connection.prepareStatement(queryString);
			resultSet = preparedStatement.executeQuery();
   tableAbsent.setModel(DbUtils.resultSetToTableModel(resultSet));
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		
	}
	
	
	
	
	
	
	
	//===================== INSERTING DATA to Customer database ===============
	
	public void InsertData(String ID,String LastName ,String FirstName,String MiddleName,String Address,String Sex,String CivilStatus) {
		
		int isExist = 0;
		
		try {
		
			String insertData = "Insert into Customer_data VALUE(?,?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(insertData);
			preparedStatement.setString(1, ID);
			preparedStatement.setString(2, LastName);
			preparedStatement.setString(3, FirstName);
			preparedStatement.setString(4, MiddleName);
			preparedStatement.setString(5, Address);
			preparedStatement.setString(6, Sex);
			preparedStatement.setString(7, CivilStatus);
			
			System.out.println(FirstName);
		 
		
			
					
			isExist =	preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(panelEnrollNew, "Inserting data.....", "", JOptionPane.INFORMATION_MESSAGE, null);
			txtID.setText("");
			txtLastName.setText("");
			txtFirstName.setText("");
			txtMiddleName.setText("");
			txtAddress.setText("");
			
			
			refreshData();
		
			
		
		
		
		
			
		} catch (SQLException e) {
			//==== SHOW WARNING ID ALREADY EXIST ==============
			if(isExist != 1) {
				System.out.println("INset xusrtomer");
				JOptionPane.showMessageDialog(null, "ID already Exist!!", "", JOptionPane.ERROR_MESSAGE, null);
			}
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	// ======================== UPDATING DATA ===============
	
	public void updateData(String ID,String LastName ,String FirstName,String MiddleName,String Address,String Sex,String CivilStatus) {
		int isexist=0;
		String updateData = "UPDATE Customer_data SET LastName =?,FirstName=?,MiddleName=?,Address=?,Sex=?,CivilStatus=? WHERE ID=? ";
		
		try {
			preparedStatement=connection.prepareStatement(updateData);
			preparedStatement.setString(1, LastName);
			preparedStatement.setString(2, FirstName);
			preparedStatement.setString(3, MiddleName);
			preparedStatement.setString(4, Address);
			preparedStatement.setString(5, Sex);
			preparedStatement.setString(6, CivilStatus);
			preparedStatement.setString(7, ID);
		
			
		//============ SHOW CONFIRMATION MESSAGE =======
		
		int yes =	JOptionPane.showConfirmDialog(null, 
					"Are your sure? \n Do you want to UPDATE THIS Student Data?",
					"", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		//=== IF YES =====
		if(yes == JOptionPane.YES_OPTION) {
			isexist = preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Data Updated!", "", JOptionPane.INFORMATION_MESSAGE, null);
			txtID.setText("");
			txtLastName.setText("");
			txtFirstName.setText("");
			txtMiddleName.setText("");
			txtAddress.setText("");
			refreshData();
			
		}else {
			return;
		}
		
		
			
			
		} catch (SQLException e) {
			//==== SHOW WARNING ID NOT EXIST ==============
			if(isexist != 1) {
				JOptionPane.showMessageDialog(null, "ID not Exist!!", "", JOptionPane.ERROR_MESSAGE, null);
				
			}
			e.printStackTrace();
		}
	}
	
	
	//====================== DELETING DATA ===============
	public void deleteData(String ID,String LastName ,String FirstName) {
		int isExist = 0;
		String deleteData = "DELETE FROM Customer_data WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(deleteData);
			preparedStatement.setString(1, ID);
			
			//============ SHOW CONFIRMATION MESSAGE =======
			
		int yes =	JOptionPane.showConfirmDialog(null, 
					"Are your sure? \n Do you want to REMOVE ".concat(FirstName+" "+ LastName+" in Student Data?"),
					"Are you Sure?",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		//=== IF YES =====
		if(yes == JOptionPane.YES_OPTION) {
			isExist = preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Deleted!!", "", JOptionPane.INFORMATION_MESSAGE, null);
			txtID.setText("");
			txtLastName.setText("");
			txtFirstName.setText("");
			txtMiddleName.setText("");
			txtAddress.setText("");
			refreshData();
			
		}else {
			return;
		}
		
		
			
			
			// ====== IF ERROR =====
		
		} catch (SQLException e) {
		
			if(isExist != 1) {
				//==== SHOW WARNING ID NOT EXIST ==============
				JOptionPane.showMessageDialog(null, "ID not Exist!!", "", JOptionPane.ERROR_MESSAGE, null);
				
			}
			
			e.printStackTrace();
		}
		
	}
	
	//================== DELETE STUDENT DATA ================
	public void deleteStudent(String ID) {
		
		String queryString = "DELETE FROM Student WHERE ID =? ";
		try {
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, ID);
			
		int i =	preparedStatement.executeUpdate();
			
		if(i== 1) {
			System.out.println("Student deleted");
			
		}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	// ================================ FOR SEARCHING DATA in ADVANCE  Table ===============
	
	public void searchData(String search) {
		
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		
		TableRowSorter<DefaultTableModel> trRowSorter = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(trRowSorter);
		trRowSorter.setRowFilter(RowFilter.regexFilter(search));
	
	}
	
	//========================================== SORT REQUEST TABLE ======================================
	
	public void sortRequestTable(String sort) {
		
DefaultTableModel tableModel = (DefaultTableModel)tableRequeast.getModel();
		
		TableRowSorter<DefaultTableModel> trRowSorter = new TableRowSorter<DefaultTableModel>(tableModel);
		tableRequeast.setRowSorter(trRowSorter);	
		
		if(sort.equals("All")) {
			
			trRowSorter.setRowFilter(RowFilter.regexFilter(""));
		}else {
			trRowSorter.setRowFilter(RowFilter.regexFilter(sort));
		}
		
		
		
		
		
	}
	
	
	//========================================== SORT PRESENT TABLE ======================================
	
	public void sortPresentTable(String sort) {
		
		DefaultTableModel tableModel = (DefaultTableModel)tablePresent.getModel();
				
				TableRowSorter<DefaultTableModel> trRowSorter = new TableRowSorter<DefaultTableModel>(tableModel);
				tablePresent.setRowSorter(trRowSorter);	
				
				if(sort.equals("All")) {
					
					trRowSorter.setRowFilter(RowFilter.regexFilter(""));
					lblCountPresent.setText(tablePresent.getRowCount()+" - STUDENTs ARE  PRESENTs " );
					
					
					
				}else {
					trRowSorter.setRowFilter(RowFilter.regexFilter(sort));
					lblCountPresent.setText(tablePresent.getRowCount()+" - STUDENTs ARE PRESENTs IN - " + comboBoxSortRequest_1.getSelectedItem().toString());
				}
				
				
				
				
				
			}
			
			
	
	

	//=========================================== GET DATA TO STUDENT DATABASE =====================
public void selectUnenrollStudent() {
		
		String sqString =  "SELECT ID,LastName,FirstName,StudentYear,Course from Student where Request = 'request' ";
		int isExist = 0;
	//	System.out.println("tryyyy");
		
		try {
			preparedStatement = connection.prepareStatement(sqString);
			
		              resultSet = preparedStatement.executeQuery();
		           
		            	  tableRequeast.setModel(DbUtils.resultSetToTableModel(resultSet));
		            	  
		            	  sortRequestTable(comboBoxSortRequest.getSelectedItem().toString());
		            	  
		            	 String count = String.valueOf(tableRequeast.getRowCount());
		            	 
		            	  lblRequestCountTable.setText(count + " Requests");
		            	  lblNotif.setText(count);
		            	 
		            	  
		            	
		              
		
		
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			if(isExist != 1) {
			
				
			} 
			
			
			
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDsystem frame = new CRUDsystem();
					
					frame.setLocationRelativeTo(null);
					
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
	public CRUDsystem() {
		initComponents();
	
		
		
	}
	
	//============= Load all Customer data IN WINDOW LOAD =============
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CRUDsystem.class.getResource("/assets/bg.png")));
		setTitle("ADMIN");
	
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tabbedPane.setSelectedIndex(1);
				
				
				refreshData();
			
				showPresentStudents();
				showNotPresent();
				selectUnenrollStudent();
				
			}
			
			//================================== WINDOW ACTIVATE ===================
			@Override
			public void windowActivated(WindowEvent e) {
				
				refreshData();
				showPresentStudents();
				showNotPresent();
				selectUnenrollStudent();
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1132, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0,150));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 31));
		lblNewLabel.setBounds(336, 11, 188, 41);
		contentPane.add(lblNewLabel);
		 sex ="N/A";
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 51, 204));
		panel_2.setBounds(0, 0, 136, 600);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNotif = new JLabel("");
		lblNotif.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNotif.setForeground(Color.GREEN);
		lblNotif.setBounds(95, 152, 41, 20);
		panel_2.add(lblNotif);
		
		lblNewLabel_3 = new JLabel("Icon");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(20, 0, 86, 69);
		panel_2.add(lblNewLabel_3);
		
		btnEnrollNew = new JButton("Enroll New");
		btnEnrollNew.setBorder(null);
		btnEnrollNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnrollNew.setForeground(new Color(255, 255, 255));
		btnEnrollNew.setBackground(Color.RED);
		
		// ============================================ EMROLL NEW BUTTON =============================
		
		btnEnrollNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRequests.setBackground(Color.BLACK);
				btnAdvance.setBackground(Color.BLACK);
				btnEnrollNew.setBackground(Color.RED);
				btnViewPresent.setBackground(Color.BLACK);
				
				
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnEnrollNew.setBounds(20, 116, 104, 32);
		panel_2.add(btnEnrollNew);
		
		btnRequests = new JButton("Requests ");
		
		//========================================= REQUESTS BUTTON ===========================
		
		btnRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnRequests.setBackground(Color.RED);
				btnAdvance.setBackground(Color.BLACK);
				btnEnrollNew.setBackground(Color.BLACK);
				btnViewPresent.setBackground(Color.BLACK);
				
				tabbedPane.setSelectedIndex(2);
				
				
				// ============= hide panel request===========
			//panelRequestEnroll.hide();
			    
				selectUnenrollStudent();
				
				
				
			}
		});
		btnRequests.setForeground(Color.WHITE);
		btnRequests.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRequests.setBorder(null);
		btnRequests.setBackground(Color.BLACK);
		btnRequests.setBounds(20, 172, 104, 32);
		panel_2.add(btnRequests);
		
		btnAdvance = new JButton("Advance");
		btnAdvance.setBorder(null);
		btnAdvance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdvance.addActionListener(new ActionListener() {
			
			// =========================================== ADVANCE BUTTON =========================
			
			public void actionPerformed(ActionEvent e) {
				
				btnRequests.setBackground(Color.BLACK);
				btnAdvance.setBackground(Color.RED);
				btnEnrollNew.setBackground(Color.BLACK);
				btnViewPresent.setBackground(Color.BLACK);
				refreshData();
				
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnAdvance.setForeground(Color.WHITE);
		btnAdvance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdvance.setBackground(Color.BLACK);
		btnAdvance.setBounds(20, 233, 104, 32);
		panel_2.add(btnAdvance);
		
		btnViewPresent = new JButton("View Present");
		
		//======================== VIEW PRESENT BUTTON CLICK ======================
		
		btnViewPresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showNotPresent();
				showPresentStudents();
				
				
				btnRequests.setBackground(Color.BLACK);
				btnAdvance.setBackground(Color.BLACK);
				btnEnrollNew.setBackground(Color.BLACK);
				btnViewPresent.setBackground(Color.RED);
				
			//	refreshData();
				
				tabbedPane.setSelectedIndex(3);
				
			}
		});
		btnViewPresent.setForeground(Color.WHITE);
		btnViewPresent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewPresent.setBorder(null);
		btnViewPresent.setBackground(Color.BLACK);
		btnViewPresent.setBounds(20, 298, 104, 32);
		panel_2.add(btnViewPresent);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(new Color(0, 0, 255));
		tabbedPane.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setName("");
		tabbedPane.setBounds(51, 114, 1010, 475);
		contentPane.add(tabbedPane);
		
		JPanel panelAdvance = new JPanel();
		tabbedPane.addTab("Advace", null, panelAdvance, null);
		tabbedPane.setEnabledAt(0, true);
	
		panelAdvance.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelAdvance.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelAdvance.setBackground(new Color(0, 0, 51));
		panelAdvance.setLayout(null);
		
		JLabel lblID = new JLabel("ID Number");
		lblID.setBounds(148, 96, 81, 22);
		panelAdvance.add(lblID);
		lblID.setBackground(new Color(255, 255, 255,60));
		lblID.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblID.setForeground(new Color(255, 255, 255));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtID = new JTextField();
		txtID.setForeground(new Color(255, 255, 255));
		txtID.setCaretColor(Color.WHITE);
		txtID.setBounds(239, 100, 115, 22);
		panelAdvance.add(txtID);
		
		//================= Digit only =================
		
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if(Character.isDigit(c) || c == '-') {
					lblError.setText("");
					
				}else {
					lblError.setText("Invalid Input!");
					e.consume();
				}
			}
				
			
		});
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtID.setText("");
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBackground(new Color(0, 0, 51));
		
		
		
		
		
		//============================= ASIGN DATA TO STRING ===========================================
		
		

		 iD = txtID.getText().trim();
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(448, 96, 77, 22);
		panelAdvance.add(lblAddress);
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtAddress = new JTextField();
		txtAddress.setForeground(Color.WHITE);
		txtAddress.setCaretColor(Color.WHITE);
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddress.setBounds(535, 100, 175, 22);
		panelAdvance.add(txtAddress);
		txtAddress.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtAddress.setEnabled(false);
		txtAddress.setColumns(10);
		txtAddress.setBackground(new Color(0, 0, 51));
		address = txtAddress.getText().trim();
		
		lblError = new JLabel("");
		lblError.setBounds(239, 125, 115, 9);
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		panelAdvance.add(lblError);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(158, 141, 71, 22);
		panelAdvance.add(lblLastName);
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtLastName = new JTextField();
		txtLastName.setCaretColor(new Color(255, 255, 255));
		txtLastName.setBounds(239, 145, 167, 22);
		panelAdvance.add(txtLastName);
		txtLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtLastName.setForeground(new Color(255, 255, 255));
		txtLastName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtLastName.setBackground(new Color(0, 0, 51));
		txtLastName.setEnabled(false);
		txtLastName.setColumns(10);
		
		lastname = txtLastName.getText().trim();
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(476, 142, 42, 21);
		panelAdvance.add(lblSex);
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setForeground(Color.WHITE);
		lblSex.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		radioMale = new JRadioButtonMenuItem("Male");
		radioMale.setBounds(533, 133, 101, 22);
		panelAdvance.add(radioMale);
		radioMale.setForeground(Color.WHITE);
		radioMale.setBackground(new Color(0, 0, 51));
		radioMale.setEnabled(false);
		radioMale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonGroup.add(radioMale);
		radioMale.addActionListener(new ActionListener() {
			
			//=============Male Sex=================================================================
			
			public void actionPerformed(ActionEvent e) {
			sex =radioMale.getText().trim();	
                    			
				
				
			}
			
			
		});
		radioMale.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(156, 174, 73, 22);
		panelAdvance.add(lblFirstName);
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtFirstName = new JTextField();
		txtFirstName.setForeground(Color.WHITE);
		txtFirstName.setCaretColor(new Color(255, 255, 255));
		txtFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstName.setBounds(239, 178, 167, 22);
		panelAdvance.add(txtFirstName);
		txtFirstName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtFirstName.setEnabled(false);
		txtFirstName.setColumns(10);
		txtFirstName.setBackground(new Color(0, 0, 51));
		firstname = txtFirstName.getText().trim();
		
		JLabel lblCivilStatus = new JLabel("Civil Status");
		lblCivilStatus.setBounds(509, 207, 77, 22);
		panelAdvance.add(lblCivilStatus);
		lblCivilStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblCivilStatus.setForeground(Color.WHITE);
		lblCivilStatus.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		 
		 txtMiddleName = new JTextField();
		 txtMiddleName.setForeground(Color.WHITE);
		 txtMiddleName.setCaretColor(Color.WHITE);
		 txtMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
		 txtMiddleName.setBounds(239, 211, 167, 22);
		 panelAdvance.add(txtMiddleName);
		 txtMiddleName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		 txtMiddleName.setEnabled(false);
		 txtMiddleName.setColumns(10);
		 txtMiddleName.setBackground(new Color(0, 0, 51));
		 middlename = txtMiddleName.getText().trim();
		 
		 JLabel lblMiddleName = new JLabel("Middle name");
		 lblMiddleName.setBounds(129, 211, 100, 22);
		 panelAdvance.add(lblMiddleName);
		 lblMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
		 lblMiddleName.setForeground(Color.WHITE);
		 lblMiddleName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		
	
		//================ CONFIRM BUTTON ===================
		
		 btnConfirm = new JButton("Confirm");
		 btnConfirm.setForeground(new Color(255, 255, 255));
		 btnConfirm.setBackground(new Color(0, 51, 255));
		 btnConfirm.setBounds(702, 9, 81, 25);
		 panelAdvance.add(btnConfirm);
		 btnConfirm.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 		// ====== FUNCTION FOR ADD BUTTON ========
		 		if(targetConfirm =="addButton") {
		 			if(txtID.getText().isEmpty()||txtLastName.getText().isEmpty()||
		 			txtFirstName.getText().isEmpty()||txtMiddleName.getText().isEmpty()||
		 			txtAddress.getText().isEmpty()||sex.isEmpty()||civiStatus.isEmpty()) {
		 				
		 			
		 				JOptionPane.showMessageDialog(null, "Fill all information in the feilds","",JOptionPane.WARNING_MESSAGE,null);
		 				
		 				
		 			}else {
		 				InsertData(txtID.getText(), txtLastName.getText(), txtFirstName.getText(), txtMiddleName.getText(), txtAddress.getText(), sex, menuCivilStatus.getText());
		 				
		 				
		 				
		 			}
		 			
		 			
		 			
		 		}
		 		// =================  FUNCTION FOR REMOVE BUTTON ==========
		 		else if(targetConfirm == "removeButton") {
		 			
		 			if(txtID.getText().isEmpty()) {
		 				
		 				JOptionPane.showMessageDialog(null, "ID not be empty!","",JOptionPane.WARNING_MESSAGE,null);
		 				
		 				
		 			}else {
		 				deleteStudent(txtID.getText());
		 				deleteData(txtID.getText(), txtLastName.getText(), txtFirstName.getText());
		 				
		 				
		 			}
		 			
		 			
		 		}
		 		// ============== FUNCTION FOR UPDATE BUTTON ============
		 		else if(targetConfirm == "updateButton") {
		 				if(txtID.getText().isEmpty()||txtLastName.getText().isEmpty()||
		 						txtFirstName.getText().isEmpty()||txtMiddleName.getText().isEmpty()||
		 						txtAddress.getText().isEmpty()||sex.isEmpty()||civiStatus.isEmpty()) {
		 				
		 					JOptionPane.showMessageDialog(null, "Fill all information in the feilds","",JOptionPane.WARNING_MESSAGE,null);
		 				
		 				
		 			}else {
		 				
		 				
		 				try {
							preparedStatement = connection.prepareStatement("Update Student SET FirstName=?,LastName=?,MiddleName =? Where BINARY ID = ?");
							preparedStatement.setString(1, txtFirstName.getText());
							preparedStatement.setString(2, txtLastName.getText());
							preparedStatement.setString(3, txtMiddleName.getText());
							preparedStatement.setString(4, txtID.getText());
							preparedStatement.executeUpdate();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		 				
		 				updateData(txtID.getText(), txtLastName.getText(), txtFirstName.getText(), txtMiddleName.getText(), txtAddress.getText(), sex, menuCivilStatus.getText());

		 				
		 				
		 				
		 				
		 				
		 			}
		 			
		 			
		 		}
		 		
		 		
		 		
		 		
		 		
		 		
		 	}
		 });
		 btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		 btnConfirm.setBorderPainted(false);
		 btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnConfirm.setEnabled(false);
		 btnConfirm.setBorder(UIManager.getBorder("RadioButton.border"));
		
		txtSearch = new JTextField();
		txtSearch.addFocusListener(new FocusAdapter() {
			
			// ================================= TXT SEARCH ON FOCUS ===============
			
			@Override
			public void focusGained(FocusEvent e) {
				
				searchData(txtSearch.getText().trim());
				
				
			}
		});
		txtSearch.addKeyListener(new KeyAdapter() {
			
			//========================================= TXT SEARCH BAR key Type=======================
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
				
				String searchString = txtSearch.getText().trim();
				searchData(searchString);
				
				
				
				
			}
		});
		txtSearch.setBounds(496, 286, 154, 22);
		panelAdvance.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton = new JButton("Show All");
		btnNewButton.setBounds(121, 286, 108, 23);
		panelAdvance.add(btnNewButton);
		
		//======================================== BUTTON SHOW ALL DATA ======================
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchData("");
				
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.BLUE, 1, true));
		scrollPane.setBounds(29, 319, 891, 140);
		panelAdvance.add(scrollPane);
		scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBackground(Color.BLACK);
		
		
		
		// ========= SELCTING DATA IN TABLE  TO  TEXTFIELDS===================================
		
		table = new JTable();
		table.setGridColor(new Color(0, 0, 204));
	
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setForeground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				
				if(table.getSelectedRowCount() ==1) {
					
					
					if(tableModel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 5).toString().trim() == "Male")	{
						radioMale.setSelected(true);
						
					}else if(tableModel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 5).toString().trim() == "Female") {
						
						
						radioFemale.setSelected(true);
					}else {
						
					}
					
					
					
					
				txtID.setText(tableModel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 0).toString());
				txtLastName.setText(tableModel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1).toString());
				txtFirstName.setText(tableModel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 2).toString());
				txtMiddleName.setText(tableModel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 3).toString());
				txtAddress.setText(tableModel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 4).toString());
				 
				
			
				
			menuCivilStatus.setText(tableModel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 6).toString());
				
				
			if(tableModel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 5).toString().equals("Female")) {
				radioFemale.setSelected(true);
			}else {
				
                radioMale.setSelected(true);
			}
				
					
					
			
				}
				
				
				
			}
		});
		table.setBackground(new Color(0, 0, 0));
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Number", "Last Name", "First Name", "Middle Name", "Address", "Sex", "CivilStatus", "Year", "Section"
			}
		));
		
		
		
		radioFemale = new JRadioButtonMenuItem("Female");
		radioFemale.setBounds(535, 155, 91, 22);
		panelAdvance.add(radioFemale);
		buttonGroup.add(radioFemale);
		radioFemale.setForeground(Color.WHITE);
		radioFemale.setEnabled(false);
		radioFemale.setBackground(new Color(0, 0, 51));
		radioFemale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		 
		//======================== REMOVE BUTTON =============================
		btnRemoveCustomer = new JButton("Remove Student");
		btnRemoveCustomer.setBounds(408, 12, 117, 19);
		panelAdvance.add(btnRemoveCustomer);
		btnRemoveCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveCustomer.setBorderPainted(false);
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.grabFocus();
				//btnAddCustomer.setBackground( Color.BLACK);
				btnRemoveCustomer.setBackground( Color.WHITE);
				btnUpdateCustomer.setBackground( Color.BLACK);
				
				btnConfirm.setEnabled(true);
				
				txtID.setEnabled(true);
				txtLastName.setEnabled(false);
				txtFirstName.setEnabled(false);
				txtMiddleName.setEnabled(false);
				txtAddress.setEnabled(false);
				
				lblSex.setEnabled(false);
				lblID.setEnabled(true);
				lblFirstName.setEnabled(false);
				lblLastName.setEnabled(false);
				lblMiddleName.setEnabled(false);
				lblAddress.setEnabled(false);
				lblCivilStatus.setEnabled(false);
				
				radioFemale.setEnabled(false);
				radioMale.setEnabled(false);
				
				menuCivilStatus.setEnabled(false);
				
				targetConfirm ="removeButton";
				
				
			}
		});
		buttonGroup.add(btnRemoveCustomer);
		btnRemoveCustomer.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnRemoveCustomer.setForeground(new Color(51, 0, 255));
		btnRemoveCustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemoveCustomer.setBackground(new Color(0, 0, 51));
		
		
		
		
		
		
		
		
		//========================== UPDATE BUTTON ======================
		
		btnUpdateCustomer = new JButton("Update Student Info");
		btnUpdateCustomer.setBounds(217, 13, 137, 17);
		panelAdvance.add(btnUpdateCustomer);
		btnUpdateCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateCustomer.setBorderPainted(false);
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnAddCustomer.setBackground( Color.BLACK);
				btnRemoveCustomer.setBackground( Color.BLACK);
				btnUpdateCustomer.setBackground( Color.WHITE);
				
				txtID.grabFocus();
				
				btnConfirm.setEnabled(true);
				
				txtID.setEnabled(false);
				txtLastName.setEnabled(true);
				txtFirstName.setEnabled(true);
				txtMiddleName.setEnabled(true);
				txtAddress.setEnabled(true);
				
				lblSex.setEnabled(true);
				lblID.setEnabled(false);
				lblFirstName.setEnabled(true);
				lblLastName.setEnabled(true);
				lblMiddleName.setEnabled(true);
				lblAddress.setEnabled(true);
				lblCivilStatus.setEnabled(true);
				
				radioFemale.setEnabled(true);
				radioMale.setEnabled(true);
				
				menuCivilStatus.setEnabled(true);
			targetConfirm = "updateButton";
				
				
				
			}
		});
		buttonGroup.add(btnUpdateCustomer);
		btnUpdateCustomer.setBorder(new LineBorder(Color.WHITE));
		btnUpdateCustomer.setForeground(new Color(51, 0, 255));
		btnUpdateCustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateCustomer.setBackground(new Color(0, 0, 51));
		
		lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(415, 283, 71, 25);
		panelAdvance.add(lblNewLabel_2);
		
		panel_4 = new JPanel();
		panel_4.setBounds(605, 208, 63, 22);
		panelAdvance.add(panel_4);
		panel_4.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 63, 22);
		panel_4.add(menuBar);
		menuBar.setBackground(Color.BLACK);
		menuBar.setEnabled(false);
		
		menuCivilStatus = new JMenu("Single");
		menuCivilStatus.setBackground(Color.WHITE);
		menuCivilStatus.setForeground(Color.WHITE);
		menuCivilStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuCivilStatus.setEnabled(false);
		
		menuBar.add(menuCivilStatus);
		
		
		// ================== CIVIL STATUS ===============
		
		mntmNewMenuItem = new JMenuItem("Single");
		mntmNewMenuItem.setForeground(Color.BLACK);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// =============== set CivilStatus to Single ============
				menuCivilStatus.setText("Single");
				
				
				
			}
		});
		menuCivilStatus.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		menuCivilStatus.add(separator);
		
		mntmNewMenuItem_1 = new JMenuItem("Married");
		mntmNewMenuItem_1.setForeground(Color.BLACK);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ====================  Set CivilStatus to Married ==================
				
				menuCivilStatus.setText("Married");
				
			}
		});
		menuCivilStatus.add(mntmNewMenuItem_1);
		
		JSeparator separator_1 = new JSeparator();
		menuCivilStatus.add(separator_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Widow");
		mntmNewMenuItem_2.setForeground(Color.BLACK);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//=========== Set CivilStatus to Widow ======================
				
				menuCivilStatus.setText("Widow");

				
			}
		});
		
		
		
		menuCivilStatus.add(mntmNewMenuItem_2);
		
		lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(CRUDsystem.class.getResource("/assets/wallpapersden.com_macos-11-big-sur_1440x900.jpg")));
		lblNewLabel_21.setBounds(0, 0, 930, 470);
		panelAdvance.add(lblNewLabel_21);
		
		//============ ASIGN THIS DATA TO STRING
			 civiStatus = menuCivilStatus.getText().trim();
		
		panelEnrollNew = new JPanel();
		panelEnrollNew.setBackground(new Color(0, 0, 51));
		tabbedPane.addTab("New tab", null, panelEnrollNew, null);
		panelEnrollNew.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Enroll Student");
		lblNewLabel_4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 21));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(345, 0, 232, 49);
		panelEnrollNew.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("ID Number");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(79, 72, 126, 29);
		panelEnrollNew.add(lblNewLabel_5);
		
		txtEnrollIDNumber = new JTextField();
		txtEnrollIDNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrollIDNumber.setBounds(208, 72, 145, 29);
		panelEnrollNew.add(txtEnrollIDNumber);
		txtEnrollIDNumber.setColumns(10);
		
		lblNewLabel_6 = new JLabel("First Name");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(79, 138, 126, 29);
		panelEnrollNew.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Last Name");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(79, 192, 126, 29);
		panelEnrollNew.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Middle Name");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(79, 244, 126, 29);
		panelEnrollNew.add(lblNewLabel_8);
		
		txtEnrollFirstName = new JTextField();
		txtEnrollFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrollFirstName.setColumns(10);
		txtEnrollFirstName.setBounds(208, 138, 145, 29);
		panelEnrollNew.add(txtEnrollFirstName);
		
		txtEnrollLastName = new JTextField();
		txtEnrollLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrollLastName.setColumns(10);
		txtEnrollLastName.setBounds(208, 192, 145, 29);
		panelEnrollNew.add(txtEnrollLastName);
		
		txtEnrollMiddleName = new JTextField();
		txtEnrollMiddleName.setColumns(10);
		txtEnrollMiddleName.setBounds(208, 244, 145, 29);
		panelEnrollNew.add(txtEnrollMiddleName);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(448, 62, 454, 270);
		panelEnrollNew.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_9 = new JLabel("Year");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 11, 58, 29);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Section");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 77, 58, 29);
		panel.add(lblNewLabel_10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(63, 11, 75, 29);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 75, 30);
		panel_1.add(menuBar_1);
		
		menuEnrollYear = new JMenu("1st Year");
		menuEnrollYear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuEnrollYear.setForeground(new Color(0, 0, 0));
		menuBar_1.add(menuEnrollYear);
		
		mntmNewMenuItem_3 = new JMenuItem("1st Year");
		
		//============================================== 1ST YEAR BUTTON CLICK ====================
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuEnrollYear.setText("1st Year");
				
			}
		});
		menuEnrollYear.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("2nd Year");
		
		//============================== 2ND YEAR BUTTON CLICK ===========================
		
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuEnrollYear.setText("2nd Year");
				
			}
		});
		menuEnrollYear.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("3rd Year");
		
		//======================================== 3RD YEAR BUTTON CLICK ============
		
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				menuEnrollYear.setText("3rd Year");
				
			}
		});
		menuEnrollYear.add(mntmNewMenuItem_5);
		
		mntmNewMenuItem_6 = new JMenuItem("4th Year");
		
		//============================================ 4TH YEAR BUTTON CLICK ================================
		
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuEnrollYear.setText("4th Year");
				
			}
		});
		menuEnrollYear.add(mntmNewMenuItem_6);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 0, 51));
		panel_3.setBounds(90, 77, 48, 29);
		panel.add(panel_3);
		
		menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(0, 0, 27, 30);
		panel_3.add(menuBar_2);
		
		menuEnrollSection = new JMenu("A");
		menuEnrollSection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuEnrollSection.setForeground(new Color(0, 0, 0));
		menuBar_2.add(menuEnrollSection);
		
		mntmNewMenuItem_7 = new JMenuItem("A");
		
		//============================== SECTION A BUTTON CLICK ====================
		
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuEnrollSection.setText("A");
				
			}
		});
		menuEnrollSection.add(mntmNewMenuItem_7);
		
		mntmNewMenuItem_8 = new JMenuItem("B");
		
		//============================= SECTION B BUTTON CLIICK ============================
		
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuEnrollSection.setText("B");
				
			}
		});
		menuEnrollSection.add(mntmNewMenuItem_8);
		
		mntmNewMenuItem_9 = new JMenuItem("C");
		
		//=============================================== SECTION C BUTTON CLICK ====================
		
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuEnrollSection.setText("C");
				
			}
		});
		menuEnrollSection.add(mntmNewMenuItem_9);
		
		mntmNewMenuItem_10 = new JMenuItem("D");
		
		//====================================== SECTION D BUTTON  CLICK ==============================
		
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuEnrollSection.setText("D");
				
			}
		});
		menuEnrollSection.add(mntmNewMenuItem_10);
		
		mntmNewMenuItem_11 = new JMenuItem("E");
		
		//================================= SECTION E BUTTON CLICK ===============================================
		
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuEnrollSection.setText("E");
				
			}
		});
		menuEnrollSection.add(mntmNewMenuItem_11);
		
		lblNewLabel_11 = new JLabel("Course");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 152, 58, 29);
		panel.add(lblNewLabel_11);
		
		txtEnrollCourse = new JTextField();
		txtEnrollCourse.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrollCourse.setBounds(77, 154, 131, 29);
		panel.add(txtEnrollCourse);
		txtEnrollCourse.setColumns(10);
		
		lblNewLabel_12 = new JLabel("User Name");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(179, 11, 75, 29);
		panel.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Password");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(179, 46, 75, 29);
		panel.add(lblNewLabel_13);
		
		txtEnrollUsername = new JTextField();
		txtEnrollUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrollUsername.setColumns(10);
		txtEnrollUsername.setBounds(263, 11, 181, 29);
		panel.add(txtEnrollUsername);
		
		txtEnrollPassword = new JTextField();
		txtEnrollPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrollPassword.setColumns(10);
		txtEnrollPassword.setBounds(263, 46, 181, 29);
		panel.add(txtEnrollPassword);
		
		lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(CRUDsystem.class.getResource("/assets/wallpapersden.com_macos-11-big-sur_1440x900.jpg")));
		lblNewLabel_23.setBounds(0, 0, 454, 270);
		panel.add(lblNewLabel_23);
		
		btnNewButton_1 = new JButton("Enroll Now");
		
		
		//====================================== ENROLL NOW BUTTON ============================
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//============= CHECK ID AND USERNAME IF EXIST ===================
				
				try {
					//============FOR ID ========
					preparedStatement = connection.prepareStatement("SELECT ID FROM Student WHERE BINARY ID=? ");
					preparedStatement.setString(1, txtEnrollIDNumber.getText().trim());
				
					resultSet = preparedStatement.executeQuery();
					//============= IF ID EXIST ============
					if(resultSet.next()) {
						JOptionPane.showMessageDialog(panelEnrollNew, "ID already Exist!!", "", JOptionPane.ERROR_MESSAGE, null);
						return;
					}
					
					//=============FOR USERNAME ========
					preparedStatement = connection.prepareStatement("SELECT Username FROM Student WHERE BINARY Username=? ");
					preparedStatement.setString(1, txtEnrollUsername.getText().trim());
				
					resultSet = preparedStatement.executeQuery();
					
					if(resultSet.next()) {
						JOptionPane.showMessageDialog(panelEnrollNew, "UserName already Exist!!", "", JOptionPane.ERROR_MESSAGE, null);
						return;
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				int isExist = 0;
				
				try {
				
					String insertData = " INSERT INTO Student (ID,LastName,FirstName,MiddleName,StudentYear,Section,Course,Username,StudentPass,Request,Enrolled,Active) value(?,?,?,?,?,?,?,?,?,?,?,?)";
					
					preparedStatement = connection.prepareStatement(insertData);
					preparedStatement.setString(1, txtEnrollIDNumber.getText().trim());
					preparedStatement.setString(2, txtEnrollLastName.getText().trim());
					preparedStatement.setString(3, txtEnrollFirstName.getText().trim());
					preparedStatement.setString(4, txtEnrollMiddleName.getText().trim());
					preparedStatement.setString(5, menuEnrollYear.getText().trim());
					preparedStatement.setString(6,menuEnrollSection.getText().trim());
					preparedStatement.setString(7, txtEnrollCourse.getText().trim());
					preparedStatement.setString(8, txtEnrollUsername.getText().trim());
					preparedStatement.setString(9, txtEnrollPassword .getText().trim());
					preparedStatement.setString(10, "noRequest");
					preparedStatement.setString(11, "Enrolled");
					preparedStatement.setString(12, "notActive");
					
					//System.out.println(FirstName);
				 
				int yes	 = JOptionPane.showConfirmDialog(panelEnrollNew, "Are your sure? ", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
				if(yes == JOptionPane.OK_OPTION) {
					
					isExist =	preparedStatement.executeUpdate();
					InsertData(txtEnrollIDNumber.getText().trim(), txtEnrollLastName.getText().trim(), txtEnrollFirstName.getText().trim(), txtEnrollMiddleName.getText().trim(), "N/A", "N/A", "N/A");
					
					JOptionPane.showMessageDialog(panelEnrollNew, "New Student Enrolled!", "", JOptionPane.INFORMATION_MESSAGE, null);
					txtEnrollIDNumber.setText("");
					txtEnrollLastName.setText("");
					txtEnrollFirstName.setText("");
					txtEnrollMiddleName.setText("");
					menuEnrollYear.setText("1st Year");
					menuEnrollSection.setText("A");
					txtEnrollUsername.setText("");
					txtEnrollPassword.setText("");
					txtEnrollCourse.setText("");
					
				
					
					refreshData();
				}else {
					return;
					
				}
				
				
				
					
				} catch (SQLException e2) {
					//==== SHOW WARNING ID ALREADY EXIST ==============
					if(isExist != 1) {
						
						System.out.println("Enrooollll");
						
						JOptionPane.showMessageDialog(null, "ID already Exist!!", "", JOptionPane.ERROR_MESSAGE, null);
					}
					e2.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(0, 204, 0));
		btnNewButton_1.setBounds(345, 364, 200, 50);
		panelEnrollNew.add(btnNewButton_1);
		
		lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon(CRUDsystem.class.getResource("/assets/wallpapersden.com_macos-11-big-sur_1440x900.jpg")));
		lblNewLabel_22.setBounds(0, 0, 930, 470);
		panelEnrollNew.add(lblNewLabel_22);
		tabbedPane.setForegroundAt(1, new Color(0, 0, 0));
		tabbedPane.setEnabledAt(1, true);
		
		panelRequests = new JPanel();
		panelRequests.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelRequests.setBackground(new Color(0, 0, 51));
	//	panelRequestEnroll.hide();
		tabbedPane.addTab("New tab", null, panelRequests, null);
		panelRequests.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(Color.BLUE, 2));
		scrollPane_1.setBounds(23, 125, 408, 297);
		panelRequests.add(scrollPane_1);
		
		tableRequeast = new JTable();
		tableRequeast.setBorder(new LineBorder(Color.BLUE));
		tableRequeast.setBackground(SystemColor.activeCaption);
		tableRequeast.addMouseListener(new MouseAdapter() {
			
		//====================================== SHOW STUDENT INFO IN REQUEST TABLE ======================== 
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			
				
		DefaultTableModel tableModel = (DefaultTableModel)tableRequeast.getModel();
				
				if(tableRequeast.getSelectedRowCount() ==1) {
					panelRequestEnroll.show();
				
					
		String ID = 	tableModel.getValueAt(tableRequeast.getSelectedRow(), 0).toString();
				
				
				 
		byte[] imgdata;
		try {
			
			
			preparedStatement=connection.prepareStatement("SELECT ID,LastName,FirstName,MiddleName,Image,About FROM Student WHERE ID =?");
			preparedStatement.setString(1, ID);
		resultSet =	preparedStatement.executeQuery();
		
		
			if(resultSet.next()) {
			imgdata = resultSet.getBytes("Image");
			
			
			if(imgdata!=null) {
			
			// ================ SHOW IMAGE ==================
			ImageIcon im = new ImageIcon(imgdata);
			Image img = im.getImage().getScaledInstance(lblRequestProfile.getWidth(),lblRequestProfile.getHeight(),Image.SCALE_SMOOTH);
			lblRequestProfile.setIcon(new ImageIcon(img));
			
			}else {
				lblRequestProfile.setIcon(null);
			}
			
			lblStudentID.setText(resultSet.getString("ID"));
			lblStudentName.setText(resultSet.getNString("FirstName")+" "+ resultSet.getString("MiddleName")+" "+ resultSet.getString("LastName"));
			textAreaRequeastAboutME.setText(resultSet.getString("About"));
			
			//============================================= from customer ======================
			
			preparedStatement=connection.prepareStatement("SELECT Address,Sex FROM Customer_data WHERE ID =?");
			preparedStatement.setString(1, ID);
		resultSet =	preparedStatement.executeQuery();
		
		
                if(resultSet.next()) {
               
                	lblStudentAddress.setText(resultSet.getString("Address"));
                	lblStudentSex.setText(resultSet.getString("Sex"));
                	
                }
			
			
			
			
					
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
	
				
			
				
		
				
			
				
					
					
			
				}
				
				
				
				
			}
		});
		tableRequeast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tableRequeast.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Number", "Last Name", "First Name", "Course", "Year"
			}
		));
		scrollPane_1.setViewportView(tableRequeast);
		
		label = new JLabel("New label");
		scrollPane_1.setColumnHeaderView(label);
		
		panelRequestEnroll = new JPanel();
		panelRequestEnroll.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelRequestEnroll.hide();
		panelRequestEnroll.setBackground(new Color(204, 204, 204));
		panelRequestEnroll.setBounds(467, 44, 440, 391);
		panelRequests.add(panelRequestEnroll);
	
		panelRequestEnroll.setLayout(null);
		
		lblRequestProfile = new JLabel("Profile Pic");
		lblRequestProfile.setForeground(Color.WHITE);
		lblRequestProfile.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblRequestProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequestProfile.setBounds(10, 11, 114, 102);
		panelRequestEnroll.add(lblRequestProfile);
		
		lblRequestID = new JLabel("ID Number");
		lblRequestID.setForeground(Color.WHITE);
		lblRequestID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRequestID.setBounds(10, 124, 81, 30);
		panelRequestEnroll.add(lblRequestID);
		
		lblRequestName = new JLabel("Name");
		lblRequestName.setForeground(Color.WHITE);
		lblRequestName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRequestName.setBounds(30, 157, 61, 30);
		panelRequestEnroll.add(lblRequestName);
		
		lblStudentID = new JLabel("");
		lblStudentID.setForeground(Color.WHITE);
		lblStudentID.setBounds(101, 123, 200, 33);
		panelRequestEnroll.add(lblStudentID);
		
		lblStudentName = new JLabel("");
		lblStudentName.setForeground(Color.WHITE);
		lblStudentName.setBounds(101, 157, 200, 33);
		panelRequestEnroll.add(lblStudentName);
		
		lblSex1 = new JLabel("Sex");
		lblSex1.setForeground(Color.WHITE);
		lblSex1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex1.setBounds(30, 220, 43, 30);
		panelRequestEnroll.add(lblSex1);
		
		lblStudentSex = new JLabel("");
		lblStudentSex.setForeground(Color.WHITE);
		lblStudentSex.setBounds(83, 217, 61, 33);
		panelRequestEnroll.add(lblStudentSex);
		
		textAreaRequeastAboutME = new JTextArea();
		textAreaRequeastAboutME.setBounds(33, 303, 380, 77);
		panelRequestEnroll.add(textAreaRequeastAboutME);
		
		lblNewLabel_16 = new JLabel("About Me");
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_16.setBounds(30, 264, 74, 33);
		panelRequestEnroll.add(lblNewLabel_16);
		
		
		
		
		//=================================== REQUEST ACCEPT BUTTON =====================================
		
		btnRequeastAccept = new JButton("Accept");
		btnRequeastAccept.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					preparedStatement= connection.prepareStatement("UPDATE Student SET Request = 'norequest' , Enrolled ='Enrolled' WHERE ID =?");
					preparedStatement.setString(1, lblStudentID.getText().trim());
					preparedStatement.execute();
					//refresh rwquest tablle ===
					selectUnenrollStudent();
					
					lblRequestProfile.setIcon(null);
					lblStudentAddress.setText(null);
					lblStudentID.setText(null);
					lblStudentName.setText(null);
					lblStudentSex.setText(null);
					textAreaRequeastAboutME.setText(null);
				JOptionPane.showMessageDialog(panelRequests, "Enrolled");
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnRequeastAccept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRequeastAccept.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRequeastAccept.setBackground(new Color(0, 204, 0));
		btnRequeastAccept.setBorder(null);
		btnRequeastAccept.setBounds(276, 10, 154, 41);
		panelRequestEnroll.add(btnRequeastAccept);
		
		lblAddress_1 = new JLabel("Address ");
		lblAddress_1.setForeground(Color.WHITE);
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress_1.setBounds(30, 183, 61, 30);
		panelRequestEnroll.add(lblAddress_1);
		
		lblStudentAddress = new JLabel("");
		lblStudentAddress.setForeground(Color.WHITE);
		lblStudentAddress.setBounds(89, 180, 226, 33);
		panelRequestEnroll.add(lblStudentAddress);
		
		lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(CRUDsystem.class.getResource("/assets/firewatch-minimalism-0u-1440x900.jpg")));
		lblNewLabel_19.setBounds(0, 1, 440, 390);
		panelRequestEnroll.add(lblNewLabel_19);
		
		lblRequestCountTable = new JLabel("");
		lblRequestCountTable.setHorizontalAlignment(SwingConstants.LEFT);
		lblRequestCountTable.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblRequestCountTable.setForeground(Color.GREEN);
		lblRequestCountTable.setBounds(23, 71, 126, 30);
		panelRequests.add(lblRequestCountTable);
		
		btnRequestEnrollAll = new JButton("Enroll All");
		
		//================================= ENROLL ALL BUTTON  CLICK ===========================================
		
		btnRequestEnrollAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxSortRequest.setSelectedIndex(0);
				sortRequestTable(comboBoxSortRequest.getSelectedItem().toString());
				
				int allRow = tableRequeast.getRowCount();
				
				
				 int i = 0;
				while(allRow >i) {
					
					String ID = tableRequeast.getValueAt(i, 0).toString();
					
					
					
					try {
						preparedStatement= connection.prepareStatement("UPDATE Student SET Request = 'noRequest' WHERE ID =?");
						preparedStatement.setString(1, ID);
						preparedStatement.execute();
						//refresh rwquest tablle ===
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					i++;
					
				}
				
				
				
				lblRequestProfile.setIcon(null);
				lblStudentAddress.setText(null);
				lblStudentID.setText(null);
				lblStudentName.setText(null);
				lblStudentSex.setText(null);
				textAreaRequeastAboutME.setText(null);
			JOptionPane.showMessageDialog(panelRequests, "All Students are Enrolled");
				
			selectUnenrollStudent();
				
				
				
				
				
				
				
			}
		});
		btnRequestEnrollAll.setBackground(Color.GREEN);
		btnRequestEnrollAll.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnRequestEnrollAll.setBounds(271, 84, 101, 30);
		panelRequests.add(btnRequestEnrollAll);
		
		comboBoxSortRequest = new JComboBox();
		comboBoxSortRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sortRequestTable(comboBoxSortRequest.getSelectedItem().toString());
				
				
			}
		});
		//==================================== SORT COMBO BOX =============================================
		
		
		comboBoxSortRequest.setBounds(280, 28, 92, 30);
		comboBoxSortRequest.addItem("All");
		comboBoxSortRequest.addItem("1st Year");
		comboBoxSortRequest.addItem("2nd Year");
		comboBoxSortRequest.addItem("3rd Year");
		comboBoxSortRequest.addItem("4th Year");

	
		panelRequests.add(comboBoxSortRequest);
		
		lblNewLabel_14 = new JLabel("Sort");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setBounds(208, 28, 62, 30);
		panelRequests.add(lblNewLabel_14);
		
		
		//============================== REFRESH REQUEST TABLE  BUTTON =============
		
		btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxSortRequest.setSelectedIndex(0);
				selectUnenrollStudent();
				
			}
		});
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setBounds(48, 429, 143, 30);
		panelRequests.add(btnNewButton_2);
		
		lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon(CRUDsystem.class.getResource("/assets/wallpapersden.com_macos-11-big-sur_1440x900.jpg")));
		lblNewLabel_20.setBounds(0, 0, 930, 470);
		panelRequests.add(lblNewLabel_20);
		tabbedPane.setEnabledAt(2, true);
		
		panelActive = new JPanel();
		panelActive.setBackground(Color.BLACK);
		tabbedPane.addTab("New tab", null, panelActive, null);
		panelActive.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(Color.CYAN);
		scrollPane_2.setBorder(new LineBorder(Color.BLUE, 2));
		scrollPane_2.setBounds(20, 110, 474, 349);
		panelActive.add(scrollPane_2);
		
		tablePresent = new JTable();
		tablePresent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Year", "Time Present"
			}
		));
		scrollPane_2.setViewportView(tablePresent);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(Color.CYAN);
		scrollPane_3.setBorder(new LineBorder(Color.BLUE, 2));
		scrollPane_3.setBounds(530, 111, 367, 348);
		panelActive.add(scrollPane_3);
		
		tableAbsent = new JTable();
		tableAbsent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Year"
			}
		));
		scrollPane_3.setViewportView(tableAbsent);
		
		lblNewLabel_15 = new JLabel("PRESENTS");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_15.setForeground(Color.GREEN);
		lblNewLabel_15.setBounds(191, 35, 130, 32);
		panelActive.add(lblNewLabel_15);
		
		lblNewLabel_17 = new JLabel("NOT PRESENTS");
		lblNewLabel_17.setForeground(Color.GREEN);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_17.setBounds(647, 35, 130, 32);
		panelActive.add(lblNewLabel_17);
		
		lblCountPresent = new JLabel("");
		lblCountPresent.setForeground(Color.GREEN);
		lblCountPresent.setBounds(20, 72, 252, 27);
		panelActive.add(lblCountPresent);
		
		comboBoxSortRequest_1 = new JComboBox();
		
		
		comboBoxSortRequest_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				sortPresentTable(comboBoxSortRequest_1.getSelectedItem().toString());
				
				
			}
		});
		comboBoxSortRequest_1.setBounds(357, 53, 92, 30);
		comboBoxSortRequest_1.addItem("All");
		comboBoxSortRequest_1.addItem("1st Year");
		comboBoxSortRequest_1.addItem("2nd Year");
		comboBoxSortRequest_1.addItem("3rd Year");
		comboBoxSortRequest_1.addItem("4th Year");
		comboBoxSortRequest_1.setSelectedIndex(0);
		
		panelActive.add(comboBoxSortRequest_1);
		
		lblNewLabel_18 = new JLabel("SORT");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setBounds(282, 52, 68, 32);
		panelActive.add(lblNewLabel_18);
		
		lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setIcon(new ImageIcon(CRUDsystem.class.getResource("/assets/wallpapersden.com_macos-11-big-sur_1440x900.jpg")));
		lblNewLabel_24.setBounds(0, 0, 930, 470);
		panelActive.add(lblNewLabel_24);
		radioFemale.addActionListener(new ActionListener() {
			
			//====================== Female Sex ======================================================
			
			public void actionPerformed(ActionEvent e) {
				sex = radioFemale.getText().trim();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(CRUDsystem.class.getResource("/assets/bg.png")));
		lblNewLabel_1.setBounds(0, 0, 1116, 611);
		
		contentPane.add(lblNewLabel_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(148, 45, 63, 555);
		contentPane.add(separator_2);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
