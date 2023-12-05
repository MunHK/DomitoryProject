package Public;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Database.DAO;
import Database.StudentInformationDTO;
import manager.manager_main;
import user.user_main;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	DAO db = new DAO();
	StudentInformationDTO info = new StudentInformationDTO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 438, 265);
		panel.setLayout(null);
		contentPane.add(panel);
		//JTabbedPane를 투명하게 설정
	    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	    tabbedPane.setBounds(10, 10, 421, 234);
	    panel.add(tabbedPane);
	    
		//JTabbedPane의 사용자 패널도 투명하게 설정
	    JPanel UserPanel = new JPanel(); // 사용자 패널
	    tabbedPane.addTab("사용자", null, UserPanel, null);
	    UserPanel.setLayout(null);
	    
	    JLabel lblNewLabel_1 = new JLabel("아이디");
	    lblNewLabel_1.setBounds(89, 58, 50, 15);
	    UserPanel.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("비밀번호");
	    lblNewLabel_2.setBounds(89, 119, 50, 15);
	    UserPanel.add(lblNewLabel_2);
	    
	    //user id
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(144, 55, 158, 21);
	    UserPanel.add(textField_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(144, 115, 158, 21);
	    UserPanel.add(textField_2);
	    
	    JButton btnNewButton_1 = new JButton("초기화");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		textField_1.setText("");
                textField_2.setText("");
	    	}
	    });
	    btnNewButton_1.setBounds(225, 155, 79, 23);
	    UserPanel.add(btnNewButton_1);
	    
	    JButton btnNewButton_1_1 = new JButton("로그인");
	    btnNewButton_1_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		info.setUniversityNumber(textField_1.getText());
	    		info.setBirth(textField_2.getText());
	    		info=db.Search_Student_Info2(info);
	    		if(db.login(info)) {
	    			user_main login = new user_main(info);
	    			login.setVisible(true);
	    			dispose();
	    		}
	    		else {
	    			System.out.println("로그인 실패");
	    		}
	    		
	    	}
	    	
	    });
	    btnNewButton_1_1.setBounds(141, 155, 84, 23);
	    UserPanel.add(btnNewButton_1_1);
	   
	    
	  //JTabbedPane의 관리자 패널도 투명하게 설정
	    JPanel Managerpanel = new JPanel(); //관리자 패널을 생성
	    tabbedPane.addTab("관리자", null, Managerpanel, null);

	    Managerpanel.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("비밀번호");
	    lblNewLabel.setBounds(113, 76, 50, 15);
	    Managerpanel.add(lblNewLabel);
	    
	    textField = new JTextField();
	    textField.setBounds(173, 73, 96, 21);
	    Managerpanel.add(textField);
	    textField.setColumns(10);
	    
	    JButton btnNewButton = new JButton("로그인");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String managerpw = textField.getText();
	    		if(managerpw.equals("1234")) {
	    			System.out.println("관리자 로그인 성공!");
	    			manager_main login1 = new manager_main();
	    		}
	    	}
	    });
	    btnNewButton.setBounds(173, 119, 93, 23);
	    Managerpanel.add(btnNewButton);
	    
	    setLocationRelativeTo(null);
	}
}
