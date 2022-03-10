package studentPortal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;

import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.synth.ColorType;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.AlgorithmMethod;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Content extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JButton btnVisit;
	JTabbedPane tabbedPane;
	JPanel panel_2;
	JLabel lblRequestForEnroll;
	JButton btnMyprofile;
	JLabel lblMyCourse;
	JLabel lblMyYear;
	JLabel lblMyAdress;
	JLabel lblMySex;
	JTextArea textAreaMyAbout;
	JLabel lblMyProfile;
	JLabel lblMyName;
	JButton btnNewButton_1;
	JLabel lblProfile;
	JLabel lblName;
	JTextArea textAreaAbout;
	JLabel lblAddress;
	JLabel lblYear;
	JLabel lblCourse ;
	JLabel lblSex ;
	JButton btnPresent;
	JLabel lblStatus;
	File loggedIn;
	
	
	
	
	File file2 = null;
	File file = null;
	 String path = null;
	 private ImageIcon formatIcon = null;
	 String fileName = null;
	 int s = 0;
	 byte[] pimage = null;
	 boolean notEmpty = false;
	 boolean no1 =false;
	 boolean no2 = false;
	 String Username = "";
	 
	
	
	//================================ CONNECTION DATABASE ===================
	
	DbConnection dbConnection = new DbConnection();
	Connection connection = dbConnection.connection();
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	private JLabel lblStatus_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	
	
	
	//===============  CHECK IF ACTIVE ===========
	
	
	public void checkActive() {
		

		String queryString = "SELECT Active FROM Student  WHERE BINARY Username=?";
		try {
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, Username);
		
		resultSet  =	preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			
			if(resultSet.getString("Active").equalsIgnoreCase("Active")) {
				btnPresent.setText("Leave");
				btnPresent.setBackground(Color.BLACK);
				btnPresent.setForeground(Color.WHITE);
			}else if(resultSet.getString("Active").equalsIgnoreCase("notActive")) {
				
				btnPresent.setText("Present");
				btnPresent.setBackground(Color.GREEN);
				btnPresent.setForeground(Color.BLACK);
			}
			
			
		
			
		}
		
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	//================ CHECK IF ACCOUT IS EXIST ================
	
	
	public void checkAccoutExist() {
		
		try {
			preparedStatement =connection.prepareStatement("SELECT ID FROM Student WHERE Username =?");
			preparedStatement.setString(1, Username);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return;
				
			}else{
				
			int	yes =JOptionPane.showConfirmDialog(contentPane, "Your Account is Deleted","SORRY",JOptionPane.OK_OPTION);
				if(yes == JOptionPane.OK_OPTION) {
					
					loggedIn.delete();
					
					
					Log_in_System log_in_System = new Log_in_System();
					log_in_System.setLocationRelativeTo(null);
					log_in_System.setVisible(true);
					dispose();
					return;
				}
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	public void sendUsername(String Username) {
		
		this.Username = Username;
		
	}
	
	
	
	
	//=============================== SHOW ALL STUDENT IN TABLE ===================
	
	public void showStudents() {
		
		
		
		String queryString = "Select ID,FirstName,LastName ,StudentYear  from Student WHERE BINARY Username != ? AND Enrolled = 'Enrolled'";
		
		try { 
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1,Username );
		resultSet = 	preparedStatement.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(resultSet));
	
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
	//========================= SHOW MY PROFILE =================
	
	public void myProfile() {
		
		
		if(Username.equals("")) {
			String[] saveUserName = loggedIn.list();
			Username = saveUserName[0];
			
			
		}
		
		
		
		System.out.println("my profile");
		System.out.println(Username);
		
		String idString ="";
		byte[] imgdata;
		System.out.println(Username);
		
	
		String queryString = "SELECT * FROM Student WHERE BINARY Username =? ";
	
		
		try {
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, Username);
		resultSet =	preparedStatement.executeQuery();
			if(resultSet.next()) {
				idString = resultSet.getString("ID");
				lblMyName.setText(resultSet.getString("FirstName")+" "+ resultSet.getString("MiddleName")+ " "+ resultSet.getString("LastName"));
				lblMyYear.setText(resultSet.getString("StudentYear"));
				lblMyCourse.setText(resultSet.getString("Course"));
				textAreaMyAbout.setText(resultSet.getString("About"));
				
				String status=resultSet.getString("Active");
				
			
				
				
				
				// ======== for Image========
		
					imgdata = resultSet.getBytes("Image");
					
					
					if(imgdata!=null) {
					
					// ================ SHOW IMAGE ==================
						lblMyProfile.setText(null);
					ImageIcon im = new ImageIcon(imgdata);
					Image img = im.getImage().getScaledInstance(lblMyProfile.getWidth(),lblMyProfile.getHeight(),Image.SCALE_SMOOTH);
					lblMyProfile.setIcon(new ImageIcon(img));
					
					}else {
						lblMyProfile.setIcon(null);
						lblMyProfile.setText("Profile Pic");
					}
					
					if(status.equalsIgnoreCase("Active")) {
						lblStatus.setForeground(Color.GREEN);
						lblStatus.setText(resultSet.getString("Active"));
					}else {
						lblStatus.setForeground(Color.RED);
						lblStatus.setText("Not Present");
						}
					
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
		//================== for Address and Sex ====================
		
		try {
		String query = "SELECT Sex,Address FROM Customer_data WHERE BINARY ID =? ";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, idString);
		
	resultSet =	preparedStatement.executeQuery();
	if(resultSet.next()) {
		lblMySex.setText(resultSet.getString("Sex"));
		lblMyAdress.setText(resultSet.getString("Address"));
		
	}
	
	
		
		}catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		
		
		
	}
	
	
	
	
	
	
	//=================================== CHECKING FOR ENROLLED ============================
	
	@SuppressWarnings("deprecation")
	public void checkEnrolled() {
		System.out.println("checEnroled");
	
		
		
		
		
	String queryString = "SELECT Enrolled FROM Student WHERE BINARY UserName =?";
	
	try {
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setString(1, Username);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			
			
			
			if(resultSet.getString("Enrolled").equalsIgnoreCase("Enrolled")) {
				
		//============== WHEN ENROLLED ===========
				
				
				System.out.println("enrolled");
				
				lblRequestForEnroll.setEnabled(false);
				lblRequestForEnroll.hide();
				
				btnPresent.setEnabled(true);
				btnPresent.show();
				btnVisit.setEnabled(true);
				btnVisit.show();
				
			

				
				
				
				
			}else {
				
                      			//===== WHEN NOT ENROLLED =====
				
				
				btnVisit.setEnabled(false);
				btnVisit.hide();
				btnPresent.setEnabled(false);
				btnPresent.hide();
				
				
				
				lblRequestForEnroll.setEnabled(true);
				lblRequestForEnroll.show();
				
			}
			
			
		}
		 
		 
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
		
		
	}
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Content frame = new Content();
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
	public Content() {
		initComponents();
	}
	@SuppressWarnings("deprecation")
	
	
	
	//========================================== WINDOW ON LOAD ==============
	
	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Content.class.getResource("/assets/273889635_279547864263950_8156061988337639158_n.jpg")));
		setResizable(false);
		setTitle("Student Portal");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				

				 loggedIn = new File("/loggedIn/"+Username);
				 if(loggedIn.mkdir()) {
					 System.out.println("Valdez Created");
				 }
				 
				if (loggedIn.exists()) {
					System.out.println("Fle exist");
				}
				
				
				
				
				
		if(path != null) {
			
			
		}else {
			checkAccoutExist();
			checkActive();
			
			checkEnrolled();
			
			myProfile();
			
			
		}
			
				
				
				
		
				
				
			}
			
			//========================== WHEN CLOSE WINDOW ============================
			
		
			@Override
			public void windowOpened(WindowEvent e) {
				
				
				
				
				
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		panel.setBackground(Color.BLACK);
		panel.setBounds(5, 5, 132, 478);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblRequestForEnroll = new JLabel("Request for Enroll");
		lblRequestForEnroll.setBorder(new LineBorder(Color.GREEN));
		lblRequestForEnroll.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequestForEnroll.addMouseListener(new MouseAdapter() {
			
			
			//========================== REQUEST ENROLL CLICK =======================
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String queryString = "UPDATE Student SET Request ='request' WHERE BINARY USERNAME =?";
				
			try {
				preparedStatement = connection.prepareStatement(queryString);
				preparedStatement.setString(1, Username);
				int updated =	preparedStatement.executeUpdate();
				
				if(updated == 1) {
					JOptionPane.showMessageDialog(contentPane, "Your Request is Delivered \n Wait for Response");
					
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

				
				
				
				
				
			}
		});
		lblRequestForEnroll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRequestForEnroll.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRequestForEnroll.setForeground(Color.GREEN);
		lblRequestForEnroll.hide();
		lblRequestForEnroll.setBounds(0, 25, 122, 38);
		panel.add(lblRequestForEnroll);
		
		
		//=========================== refresh button ===================
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkEnrolled();
				myProfile();
				showStudents();
				
				
				
				
			}
		});
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		btnRefresh.setBackground(Color.BLUE);
		btnRefresh.setBounds(10, 404, 112, 38);
		panel.add(btnRefresh);
		
		
		//======================== MY PROFILE BUTTON CLICK ===============
		
		btnMyprofile = new JButton("My Profile");
		btnMyprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnMyprofile.setBackground(Color.GREEN);
				
				btnMyprofile.setForeground(ColorUIResource.BLACK);
				btnVisit.setBackground(Color.BLACK);
				
				btnVisit.setForeground(ColorUIResource.WHITE);
				tabbedPane.setSelectedIndex(0);
				panel_2.hide();
				
				
				
				
				
				
			}
		});
		btnMyprofile.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMyprofile.setBackground(Color.GREEN);
		btnMyprofile.setBounds(43, 107, 89, 38);
		panel.add(btnMyprofile);
		
		
		//============================================ BUTTON VISIT CLICK ================
		
		btnVisit = new JButton("Visit");
		btnVisit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnMyprofile.setBackground(Color.BLACK);
				
				btnMyprofile.setForeground(ColorUIResource.WHITE);
				btnVisit.setBackground(Color.GREEN);
				
				btnVisit.setForeground(ColorUIResource.BLACK);
				tabbedPane.setSelectedIndex(1);
				showStudents();
				
				panel_2.hide();
				
				
				
				
				
				
				
			}
		});
		btnVisit.setForeground(Color.WHITE);
		btnVisit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVisit.setBackground(Color.BLACK);
		btnVisit.setBounds(43, 170, 89, 38);
		panel.add(btnVisit);
		
		
		// =============== PRESENT BUTTON CLICK =================
		
		btnPresent = new JButton("Present");
		btnPresent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date date = new Date();
				SimpleDateFormat clockDateFormat = new SimpleDateFormat("h:mm a");
				SimpleDateFormat day = new SimpleDateFormat("EEEE");

				if(btnPresent.getText().equalsIgnoreCase("Present")) {
				
					
					
					
					String queryString = "Update Student SET Active =? ,CurrentDate=? WHERE BINARY Username=?";
					try {
						preparedStatement = connection.prepareStatement(queryString);
						preparedStatement.setString(1, "Active");
						preparedStatement.setString(3, Username);
						preparedStatement.setString(2, day.format(date)+" "+ clockDateFormat.format(date));
					int i =	preparedStatement.executeUpdate();
						
					    if(i==1) {
					    	
					    	btnPresent.setText("Leave");
							btnPresent.setBackground(Color.BLACK);
							btnPresent.setForeground(Color.WHITE);
							
					    }
					
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}else if(btnPresent.getText().equalsIgnoreCase("Leave")) {
					
				int yes =	JOptionPane.showConfirmDialog(panel_2,"You will Be MARK ABSENT If You Continue\n\tContinue ?","Leave",JOptionPane.OK_CANCEL_OPTION);
					
					if(yes == JOptionPane.OK_OPTION) {
						String queryString = "Update Student SET Active =? ,CurrentDate=? WHERE BINARY Username=?";
						try {
							preparedStatement = connection.prepareStatement(queryString);
							preparedStatement.setString(1, "notActive");
							preparedStatement.setString(3, Username);
							preparedStatement.setString(2, "N/A");
						int i =	preparedStatement.executeUpdate();
						
						if(i==1) {
							btnPresent.setText("Present");
							btnPresent.setBackground(Color.GREEN);
							btnPresent.setForeground(Color.BLACK);
							
						}
						
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					
					
						
						
					}
					
				myProfile();
				
			
				
				
				
				
				
				
				
				
			}
		});
		btnPresent.setBackground(Color.GREEN);
		btnPresent.setBounds(10, 313, 112, 23);
		panel.add(btnPresent);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Content.class.getResource("/assets/246808829_905880143369025_9083127541608472071_n.jpg")));
		lblNewLabel_5.setBounds(0, 0, 132, 478);
		panel.add(lblNewLabel_5);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(72, 5, 923, 478);
		contentPane.add(tabbedPane);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		JPanel panelMyProfile = new JPanel();
		panelMyProfile.setBackground(Color.BLACK);
		tabbedPane.addTab("New tab", null, panelMyProfile, null);
		panelMyProfile.setLayout(null);
		
		lblMyProfile = new JLabel("Profile");
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setBorder(new LineBorder(Color.BLUE, 2));
		lblMyProfile.setBounds(354, 11, 145, 122);
		panelMyProfile.add(lblMyProfile);
		
		 lblMyName = new JLabel("");
		 lblMyName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyName.setForeground(Color.WHITE);
		lblMyName.setBounds(276, 137, 294, 28);
		panelMyProfile.add(lblMyName);
		
		 textAreaMyAbout = new JTextArea();
		 textAreaMyAbout.addKeyListener(new KeyAdapter() {
			 
			 
			 //======================= about type change ============
		 	@Override
		 	public void keyTyped(KeyEvent e) {
		 		btnNewButton_1.show();
		 		
		 		
		 		
		 		
		 		
		 	}
		 });
		 textAreaMyAbout.addInputMethodListener(new InputMethodListener() {
		 	public void caretPositionChanged(InputMethodEvent event) {
		 		btnNewButton_1.show();
		 	}
		 	public void inputMethodTextChanged(InputMethodEvent event) {
		 		
		 		btnNewButton_1.show();
		 		
		 		
		 	}
		 });
		textAreaMyAbout.setCaretColor(Color.WHITE);
		textAreaMyAbout.setForeground(Color.WHITE);
		textAreaMyAbout.setBackground(Color.BLACK);
		textAreaMyAbout.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		textAreaMyAbout.setBounds(286, 191, 284, 52);
		panelMyProfile.add(textAreaMyAbout);
		
	 lblMySex = new JLabel("");
	 lblMySex.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMySex.setForeground(Color.WHITE);
		lblMySex.setBounds(257, 326, 102, 28);
		panelMyProfile.add(lblMySex);
		
		 lblMyAdress = new JLabel("");
		 lblMyAdress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMyAdress.setForeground(Color.WHITE);
		lblMyAdress.setBounds(257, 287, 189, 28);
		panelMyProfile.add(lblMyAdress);
		
		lblMyYear = new JLabel("");
		lblMyYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMyYear.setForeground(Color.WHITE);
		lblMyYear.setBounds(509, 326, 79, 28);
		panelMyProfile.add(lblMyYear);
		
		lblMyCourse = new JLabel("");
		lblMyCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMyCourse.setForeground(Color.WHITE);
		lblMyCourse.setBounds(509, 287, 79, 28);
		panelMyProfile.add(lblMyCourse);
		
		
		
		//================================== SAVE CHANGES==================
		
		btnNewButton_1 = new JButton("Save changes");
		btnNewButton_1.hide();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			int	yes = JOptionPane.showConfirmDialog(panelMyProfile, "Are you Sure?","",JOptionPane.OK_CANCEL_OPTION);
				
	if(yes == JOptionPane.OK_OPTION) {
		
		if(path != null) {
			//fileName = file.getName();
			

System.out.println(path);
      
    	  File file = new File(path);
    	  
    		try {
				InputStream inputStream = new FileInputStream(file);
				
				String queryString = "Update Student SET About =?,Image =? where UserName = ? ";
				preparedStatement= connection.prepareStatement(queryString);
				preparedStatement.setString(1, textAreaMyAbout.getText());
				preparedStatement.setBlob(2, inputStream);
				preparedStatement.setString(3, Username);
				
				int	inserted = preparedStatement.executeUpdate();
				JOptionPane.showMessageDialog(panelMyProfile, "Saved changes");
				
				System.out.println(inserted);
				
				btnNewButton_1.hide();
		
				
				
			} catch (FileNotFoundException e1) {
				        btnNewButton_1.show();
				e1.printStackTrace();
			}catch (SQLException e2) {
				 btnNewButton_1.show();
				e2.printStackTrace();
			}
			
			
			}else {
				

				//========================= Update About ==============
				
				try {
				String queryString = "Update Student SET About =? where Username = ? ";
				preparedStatement= connection.prepareStatement(queryString);
				preparedStatement.setString(1, textAreaMyAbout.getText());
				preparedStatement.setString(2, Username);
			
				
				int	inserted = preparedStatement.executeUpdate();
				JOptionPane.showMessageDialog(panelMyProfile, "Saved changes");
				btnNewButton_1.hide();
				}catch (SQLException e1) {
					btnNewButton_1.show();
					e1.printStackTrace();
					
					
					
				}
				
			}
			
		
		
	}else if(yes == JOptionPane.CANCEL_OPTION) {
		btnNewButton_1.hide();
		myProfile();
	}
                                   
								
										
										
										
								
							
						
				
				
		}
				
				
				
				
			
		});
		
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(716, 427, 136, 35);
		panelMyProfile.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Change Picture");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			
			//================================= CHANGE PICTURE =====================
			
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				
			           File file;
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("PNG,JPG,JPEG","png","jpeg","jpg");
				fileChooser.addChoosableFileFilter(fileNameExtensionFilter);
				int load = fileChooser.showOpenDialog(null);
				
				if(load == fileChooser.APPROVE_OPTION) {
				System.out.println("meron image");
				       btnNewButton_1.show();
					file = fileChooser.getSelectedFile();
					path = file.getAbsolutePath();
					
					ImageIcon im = new ImageIcon(path);
					Image img = im.getImage().getScaledInstance(lblMyProfile.getWidth(),lblMyProfile.getHeight(),Image.SCALE_SMOOTH);
					lblMyProfile.setIcon(new ImageIcon(img));
					
					
					
				}
				
				
				
				
				
				
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(375, 241, 112, 28);
		panelMyProfile.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBounds(209, 293, 46, 14);
		panelMyProfile.add(lblNewLabel);
		
		 lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setForeground(Color.GREEN);
		lblStatus.setBounds(502, 110, 86, 14);
		panelMyProfile.add(lblStatus);
		
		
		//==================== LOGOUT BUTTON =======================
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			int	 yes = JOptionPane.showConfirmDialog(panelMyProfile,"Are you Sure?" ,"",JOptionPane.OK_CANCEL_OPTION);
				
			    if(yes == JOptionPane.OK_OPTION) {
			    	
			    	
			    	loggedIn.delete();
					Log_in_System log_in_System = new Log_in_System();
					log_in_System.setLocationRelativeTo(null);
					log_in_System.setVisible(true);
					dispose();
					
			    }else {
			    	
			    	myProfile();
			    	
			    }
			
			
				
				
				
			}
		});
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(Color.BLUE);
		btnLogOut.setBounds(763, 11, 89, 23);
		panelMyProfile.add(btnLogOut);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Content.class.getResource("/assets/firewatch-minimalism-0u-1440x900.jpg")));
		lblNewLabel_3.setBounds(10, 0, 842, 462);
		panelMyProfile.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(-52, 47, 200, 50);
		panelMyProfile.add(lblNewLabel_4);
		
		JPanel panelVisit = new JPanel();
		panelVisit.setBackground(Color.BLACK);
		tabbedPane.addTab("New tab", null, panelVisit, null);
		panelVisit.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
		scrollPane.setBounds(29, 106, 379, 321);
		panelVisit.add(scrollPane);
		
		table = new JTable();
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				panel_2.hide();
				
				System.out.println("FOcus Lost");
				
			}
			
			
			
		});
		table.setBackground(new Color(176, 224, 230));
		table.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		
		//================================ When table selected =================
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
						
						if(table.getSelectedRowCount() ==1) {
							
						panel_2.show();
							
				String ID = 	tableModel.getValueAt(table.getSelectedRow(), 0).toString();
						
						
						 
				byte[] imgdata;
				try {
					
					
					preparedStatement=connection.prepareStatement("SELECT ID,LastName,FirstName,MiddleName,Image,About,Active,Course,StudentYear FROM Student WHERE ID =? AND Enrolled = 'Enrolled'");
					preparedStatement.setString(1, ID);
				resultSet =	preparedStatement.executeQuery();
				
				
				
					if(resultSet.next()) {
					imgdata = resultSet.getBytes("Image");
					
					
					
					
					
					
					
					if(imgdata!=null) {
					
					// ================ SHOW IMAGE ==================
						lblProfile.setText(null);
					ImageIcon im = new ImageIcon(imgdata);
					Image img = im.getImage().getScaledInstance(lblProfile.getWidth(),lblProfile.getHeight(),Image.SCALE_SMOOTH);
					lblProfile.setIcon(new ImageIcon(img));
					
					}else {
						lblProfile.setText(null);
						lblProfile.setIcon(null);
					}
					
					//lblStudentID.setText(resultSet.getString("ID"));
					lblName.setText(resultSet.getNString("FirstName")+" "+ resultSet.getString("MiddleName")+" "+ resultSet.getString("LastName"));
					textAreaAbout.setText(resultSet.getString("About"));
					lblCourse.setText(resultSet.getString("Course"));
					lblYear.setText(resultSet.getString("StudentYear"));
					String status= resultSet.getString("Active");
					System.out.println(status);
					if(status.equalsIgnoreCase("Active")) {
						lblStatus_1.setForeground(Color.GREEN);
						lblStatus_1.setText("Active");
					}else {
						lblStatus_1.setForeground(Color.RED);
					lblStatus_1.setText("Not Present");
				}
				
					
					//============================================= from customer ======================
					
					preparedStatement=connection.prepareStatement("SELECT Address,Sex FROM Customer_data WHERE ID =?");
					preparedStatement.setString(1, ID);
				resultSet =	preparedStatement.executeQuery();
				
				
		                if(resultSet.next()) {
		               
		                	lblAddress.setText(resultSet.getString("Address"));
		                	lblSex.setText(resultSet.getString("Sex"));
		                	
		                }
					
					
					
					
							
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			
			
						
					
						
				
						
					
						
							
							
					
						}else {
							panel_2.hide();
						}
				
			
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Number", "First Name", "Last Name", "Year"
			}
		));
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		panel_2.setBounds(429, 0, 379, 461);
		panelVisit.add(panel_2);
		panel_2.setBackground(Color.BLACK);
		panel_2.hide();
		panel_2.setLayout(null);
		
		lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setBorder(new LineBorder(Color.BLUE, 2));
		lblProfile.setBounds(147, 11, 116, 105);
		panel_2.add(lblProfile);
		
		 lblName = new JLabel("");
		 lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(61, 122, 294, 28);
		panel_2.add(lblName);
		
		 textAreaAbout = new JTextArea();
		textAreaAbout.setForeground(Color.WHITE);
		textAreaAbout.setCaretColor(Color.WHITE);
		textAreaAbout.setBorder(new LineBorder(Color.WHITE));
		textAreaAbout.setBackground(Color.BLACK);
		textAreaAbout.setBounds(60, 161, 284, 52);
		panel_2.add(textAreaAbout);
		
		 lblSex = new JLabel("");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSex.setForeground(Color.WHITE);
		lblSex.setBounds(78, 283, 79, 28);
		panel_2.add(lblSex);
		
		lblAddress = new JLabel("");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setBounds(68, 247, 287, 28);
		panel_2.add(lblAddress);
		
		 lblYear = new JLabel("");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYear.setForeground(Color.WHITE);
		lblYear.setBounds(78, 322, 79, 28);
		panel_2.add(lblYear);
		
		 lblCourse = new JLabel("");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCourse.setForeground(Color.WHITE);
		lblCourse.setBounds(88, 369, 79, 28);
		panel_2.add(lblCourse);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 253, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		lblStatus_1 = new JLabel("");
		lblStatus_1.setForeground(Color.GREEN);
		lblStatus_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus_1.setBounds(269, 82, 86, 14);
		panel_2.add(lblStatus_1);
		
		lblNewLabel_8 = new JLabel("Sex");
		lblNewLabel_8.setForeground(Color.CYAN);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(24, 289, 46, 14);
		panel_2.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Year");
		lblNewLabel_9.setForeground(Color.CYAN);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(24, 334, 46, 14);
		panel_2.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Section");
		lblNewLabel_10.setForeground(Color.CYAN);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(24, 375, 71, 14);
		panel_2.add(lblNewLabel_10);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(Content.class.getResource("/assets/firewatch-minimalism-0u-1440x900.jpg")));
		lblNewLabel_7.setBounds(0, 0, 379, 450);
		panel_2.add(lblNewLabel_7);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Content.class.getResource("/assets/wallpapersden.com_macos-11-big-sur_1440x900.jpg")));
		lblNewLabel_6.setBounds(10, 0, 842, 473);
		panelVisit.add(lblNewLabel_6);
	}
}
