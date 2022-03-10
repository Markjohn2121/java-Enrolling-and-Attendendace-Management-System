package studentPortal;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.cj.exceptions.RSAException;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textIdNumber;
	private JTextField textLastName;
	private JTextField textFirstName;
	private JTextField textMiddleName;
	private JTextField textAddress;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtCourse;
	JTextArea textAreaAbout;
	JLabel lblIDError ;
	JLabel lblUsernameError;
	JLabel lblPicture;
	JLabel lblPicName;
	 Content content = new Content();
	
	
	// =========================== SET GLOBALS =====================
	
	DbConnection dbConnection = new DbConnection();
	
	Connection connection = dbConnection.connection();
	PreparedStatement preparedStatement;
	ResultSet resultSet;
 
	 File file = null;
	 String path = null;
	 private ImageIcon formatIcon = null;
	 String fileName = null;
	 int s = 0;
	 byte[] pimage = null;
	 boolean notEmpty = false;
	 boolean no1 =false;
	 boolean no2 = false;
	 
	
	 
	 
	 // ================== get username for content ==============
	 public String getUserName() {
			
			return txtUsername.getText();
			
		}
	
	
	
	
	
	//================================ INSERT DATA TO CUSTOMER DATABASE =========================
	
	public void insertCustomer(String ID,String LastName,String FirstName,String MiddleName,String Sex,String Address,String CivilStatus) {
		
		String sqString = "INSERT INTO Customer_data VALUEs(?,?,?,?,?,?,?)";
		int isExist = 0;
		
		try {
			preparedStatement = connection.prepareStatement(sqString);
			
			preparedStatement.setString(1, ID);
			preparedStatement.setString(2, LastName);
			preparedStatement.setString(3, FirstName);
			preparedStatement.setString(4, MiddleName);
			preparedStatement.setString(6, Sex);
			preparedStatement.setString(5, Address);
			preparedStatement.setString(7, CivilStatus);
			
		isExist =	preparedStatement.executeUpdate();
		
		
			no1 = true;
			
			
			
		} catch (SQLException e) {
			
			if(isExist != 1) {
				lblIDError.setText("ID already exist !");
				
			}
			
			
			e.printStackTrace();
		}
	}
	
	
	
	//=========================================== INSERT DATA TO STUDENT DATABASE =====================
public void insertStudent(String ID,String LastName,String FirstName,String MiddleName,String Year,String Section,String Course,String Imagename,String Username,String Password) {
		
		String sqString =  "INSERT INTO Student (ID,LastName,FirstName,MiddleName,StudentYear,Section,Course,ImageName,Username,StudentPass,Enrolled,About,Active) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int isExist = 0;
		
		try {
			preparedStatement = connection.prepareStatement(sqString);
			
			preparedStatement.setString(1, ID);
			preparedStatement.setString(2, LastName);
			preparedStatement.setString(3, FirstName);
			preparedStatement.setString(4, MiddleName);
			preparedStatement.setString(5, Year);
			preparedStatement.setString(6, Section);
			preparedStatement.setString(7, Course);
			preparedStatement.setString(8, Imagename);
			preparedStatement.setString(9, Username);
			preparedStatement.setString(10, Password);
			preparedStatement.setString(11, "notEnrolled");
			preparedStatement.setString(12, textAreaAbout.getText());
			preparedStatement.setString(13, "notActive");
			
		isExist =	preparedStatement.executeUpdate();
		
		
			no2 = true;
			
			
			
		} catch (SQLException e) {
			
			if(isExist != 1) {
				lblIDError.setText("ID already exist !");
				
			}
			
			
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
					SignUp frame = new SignUp();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SignUp() {
		initComponents();
		
		
		
	}
	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/assets/273889635_279547864263950_8156061988337639158_n.jpg")));
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 480);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//==================================================================
		
		textIdNumber = new JTextField();
		textIdNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblIDError.setText("");
				
			}
		});
		textIdNumber.setHorizontalAlignment(SwingConstants.LEFT);
		textIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textIdNumber.setBounds(10, 20, 95, 26);
		contentPane.add(textIdNumber);
		textIdNumber.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(10, 49, 62, 14);
		contentPane.add(lblNewLabel);
		
		textLastName = new JTextField();
		textLastName.setHorizontalAlignment(SwingConstants.LEFT);
		textLastName.setBounds(10, 68, 115, 26);
		contentPane.add(textLastName);
		textLastName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(10, 98, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		textFirstName = new JTextField();
		textFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		textFirstName.setBounds(135, 68, 115, 26);
		contentPane.add(textFirstName);
		textFirstName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(135, 98, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		textMiddleName = new JTextField();
		textMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		textMiddleName.setBounds(260, 68, 115, 26);
		contentPane.add(textMiddleName);
		textMiddleName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Middle Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3.setBounds(260, 98, 74, 14);
		contentPane.add(lblNewLabel_3);
		
		textAddress = new JTextField();
		textAddress.setHorizontalAlignment(SwingConstants.LEFT);
		textAddress.setBounds(10, 117, 365, 26);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(10, 147, 62, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sex:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_5.setBounds(10, 196, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Civil Status:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_6.setBounds(10, 245, 62, 14);
		contentPane.add(lblNewLabel_6);
		
		 lblPicture = new JLabel("Your Picture");
		 lblPicture.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPicture.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicture.setBounds(499, 29, 160, 128);
		contentPane.add(lblPicture);
		
		
		
		lblPicName = new JLabel("");
		lblPicName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicName.setBounds(465, 196, 239, 14);
		contentPane.add(lblPicName);
		
		JLabel lblNewLabel_5_1 = new JLabel("Year:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_5_1.setBounds(154, 175, 46, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Section:");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_5_2.setBounds(154, 224, 46, 14);
		contentPane.add(lblNewLabel_5_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(186, 172, 62, 22);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 64, 22);
		panel.add(menuBar);
		
		JMenu menuYear = new JMenu("1st Year");
		menuYear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(menuYear);
		
		//========================= SET YEAR  TO 1ST YEAR =====================
		
		JMenuItem mntmNewMenuItem = new JMenuItem("1st Year");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuYear.setText("1st Year");
				
			}
		});
		menuYear.add(mntmNewMenuItem);
		
		//========================= SET YEAR  TO 2ND YEAR =====================
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("2nd Year");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuYear.setText("2nd Year");
				
			}
		});
		menuYear.add(mntmNewMenuItem_1);
		
		//========================= SET YEAR  TO 3rd YEAR =====================
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("3rd Year");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuYear.setText("3rd Year");
				
			}
		});
		menuYear.add(mntmNewMenuItem_2);
		
		//========================= SET YEAR  TO 4th YEAR =====================
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("4th Year");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuYear.setText("4th Year");
			}
		});
		menuYear.add(mntmNewMenuItem_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(197, 221, 35, 22);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 30, 22);
		panel_1.add(menuBar_1);
		
		JMenu menuSection = new JMenu("A");
		menuSection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar_1.add(menuSection);
		
		//========================= SET SECTION  A =====================
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("A");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuSection.setText("");
			}
		});
		menuSection.add(mntmNewMenuItem_4);
		
		//========================= SET SECTION  B =====================
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("B");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuSection.setText("B");
			}
		});
		menuSection.add(mntmNewMenuItem_5);
		
		//========================= SET SECTION  C =====================
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("C");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuSection.setText("C");
			}
		});
		menuSection.add(mntmNewMenuItem_6);
		
		//========================= SET SECTION  D =====================
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("D");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuSection.setText("D");
				
			}
		});
		menuSection.add(mntmNewMenuItem_7);
		
		//========================= SET SECTION  E =====================
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("E");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuSection.setText("E");
				
			}
		});
		menuSection.add(mntmNewMenuItem_8);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Create Username");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_5_2_1.setBounds(102, 281, 95, 14);
		contentPane.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("Create Password");
		lblNewLabel_5_2_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_5_2_2.setBounds(102, 325, 95, 14);
		contentPane.add(lblNewLabel_5_2_2);
		
		txtUsername = new JTextField();
		
	//==========================================================================	
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				lblUsernameError.setText("");
				
			}
		});
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(207, 272, 168, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setColumns(10);
		txtPassword.setBounds(207, 316, 168, 26);
		contentPane.add(txtPassword);
		
		 lblUsernameError = new JLabel("");
		lblUsernameError.setForeground(Color.RED);
		lblUsernameError.setBounds(186, 300, 210, 14);
		contentPane.add(lblUsernameError);
		
		 lblIDError = new JLabel("");
		lblIDError.setForeground(Color.RED);
		lblIDError.setBounds(115, 29, 219, 14);
		contentPane.add(lblIDError);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(43, 188, 53, 22);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(0, 0, 61, 22);
		panel_2.add(menuBar_2);
		
		JMenu menuSex = new JMenu("Male");
		menuSex.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar_2.add(menuSex);
		
		// ================= SET TO MALE ============
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Male");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuSex.setText("Male");
				
			}
		});
		menuSex.add(mntmNewMenuItem_9);
		//================================= SET TO FEMALE =========================
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Female");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuSex.setText("Female");
			}
		});
		menuSex.add(mntmNewMenuItem_10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(71, 245, 62, 22);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(0, 0, 62, 22);
		panel_3.add(menuBar_3);
		
		JMenu menuCivilStatus = new JMenu("Single");
		menuCivilStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar_3.add(menuCivilStatus);
		
		//==================================== SET TO SINGLE ================
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Single");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuCivilStatus.setText("Single");
			}
		});
		menuCivilStatus.add(mntmNewMenuItem_11);
		
		//================================= SET TO MARRIED ==================
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Married");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuCivilStatus.setText("Married");
			}
		});
		menuCivilStatus.add(mntmNewMenuItem_12);
		
		//===================================== SET TO WIDOW ======================
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Widow");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuCivilStatus.setText("Widow");
			}
		});
		menuCivilStatus.add(mntmNewMenuItem_13);
		
		JLabel lblNewLabel_4_1 = new JLabel("Course");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4_1.setBounds(272, 196, 62, 14);
		contentPane.add(lblNewLabel_4_1);
		
		txtCourse = new JTextField();
		txtCourse.setHorizontalAlignment(SwingConstants.LEFT);
		txtCourse.setColumns(10);
		txtCourse.setBounds(328, 187, 115, 26);
		contentPane.add(txtCourse);
		
		//=============================== ATTACH PIC BUTTON ================
		
		JButton btnAttachPic = new JButton("Attach Picture");
		btnAttachPic.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("PNG,JPG,JPEG","png","jpeg","jpg");
				fileChooser.addChoosableFileFilter(fileNameExtensionFilter);
				int load = fileChooser.showOpenDialog(null);
				
				if(load == fileChooser.APPROVE_OPTION) {
					notEmpty = true;
					file = fileChooser.getSelectedFile();
					path = file.getAbsolutePath();
					lblPicName.setText(path);
					ImageIcon im = new ImageIcon(path);
					Image img = im.getImage().getScaledInstance(lblPicture.getWidth(),lblPicture.getHeight(),Image.SCALE_SMOOTH);
					lblPicture.setIcon(new ImageIcon(img));
					
					
					
				}
				
				
				
			}
		});	
		

		btnAttachPic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAttachPic.setBounds(499, 169, 160, 23);
		contentPane.add(btnAttachPic);
		
		
		
		
		
		// =========================================== SIGN UP BUTTON CLICK ======================
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textIdNumber.getText().trim().isEmpty() || txtUsername.getText().trim().isEmpty()) return;
				
				String selectUsername = "Select ID From Student Where BINARY ID =?";
				try {
					preparedStatement = connection.prepareStatement(selectUsername);
					preparedStatement.setString(1, textIdNumber.getText().trim());
				resultSet =	preparedStatement.executeQuery();
					
					if(resultSet.next()) {
						lblIDError.setText("ID number already Exist !");
						
						return;
							
						
					}else {
						
						preparedStatement = connection.prepareStatement("SELECT UserName FROM Student WHERE UserName = ?");
						preparedStatement.setString(1, txtUsername.getText().trim());
					  resultSet =	preparedStatement.executeQuery();
						
					if(resultSet.next()) {
						lblUsernameError.setText("Username already Exist !");
						return;
					}else {
						
insertCustomer(textIdNumber.getText().trim(), textLastName.getText().trim(), textFirstName.getText().trim(), textMiddleName.getText().trim(), menuSex.getText().trim(), textAddress.getText().trim(), menuCivilStatus.getText().trim());
						
insertStudent(textIdNumber.getText().trim(), textLastName.getText().trim(), textFirstName.getText().trim(), textMiddleName.getText().trim(), menuYear.getText().trim(), menuSection.getText().trim(), txtCourse.getText().trim(), lblPicName.getText().trim(), txtUsername.getText().trim(), txtPassword.getText().trim());
                                   
										if(file != null) {
										fileName = file.getName();
										}

              
                                  if (notEmpty) {
                                	  File file = new File(path);
                                	  
                                		try {
            								InputStream inputStream = new FileInputStream(file);
            								
            								String queryString = "UPDATE Student SET ImageName =?,Image=?,About =? WHERE ID = ? ";
            								preparedStatement= connection.prepareStatement(queryString);
            								preparedStatement.setString(1, fileName);
            								preparedStatement.setBlob(2, inputStream);
            								preparedStatement.setString(4, textIdNumber.getText().trim());
            								preparedStatement.setString(3,textAreaAbout.getText() );
            								int	inserted = preparedStatement.executeUpdate();
            								
            							
            								
            								System.out.println(inserted);
            								
            								
            								notEmpty = false;
            								
            								
            							} catch (FileNotFoundException e1) {
            								// TODO Auto-generated catch block
            								e1.printStackTrace();
            							}catch (SQLException e2) {
            								e2.printStackTrace();
            							}
									
								}
							
                                  if(no1||no2) {
                                		//========================== SIGN UP SUCCESS ==============
                                	  
                                	  content.sendUsername(txtUsername.getText());
                                	  
                                	  JOptionPane.showMessageDialog(contentPane, "Data Inserted");

                                	  content.setLocationRelativeTo(null);
                                	  content.setVisible(true);
                                	  dispose();
                                  }
						
					}   
                 
					}
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
		});
		btnSignUp.setBounds(283, 373, 160, 34);
		contentPane.add(btnSignUp);
		
		// =================================== I HAVE AN ACCOUNT ======================
		
		JLabel lblNewLabel_7 = new JLabel("I have an Acount");
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Log_in_System log_in_System = new Log_in_System();
				log_in_System.setLocationRelativeTo(null);
				log_in_System.setVisible(true);
				dispose();
				
				
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setBounds(581, 404, 146, 26);
		contentPane.add(lblNewLabel_7);
		
		textAreaAbout = new JTextArea();
		textAreaAbout.setRows(1);
		textAreaAbout.setLineWrap(true);
		textAreaAbout.setColumns(1);
		textAreaAbout.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textAreaAbout.setBounds(487, 276, 217, 58);
		textAreaAbout.invalidate();
		contentPane.add(textAreaAbout);
		
		JLabel lblNewLabel_8 = new JLabel("Tell About Your Self");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(499, 256, 160, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(SignUp.class.getResource("/assets/wallpapersden.com_macos-11-big-sur_1440x900.jpg")));
		lblNewLabel_9.setBounds(0, 0, 737, 441);
		contentPane.add(lblNewLabel_9);
	}
}