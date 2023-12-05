package UserOutside;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Database.DAO;
import Database.StudentOutsideDTO;

public class outside_repair extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	DAO db = new DAO();
	List<StudentOutsideDTO> studentList = new ArrayList<>();
	String reasoncheck;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					outside_repair frame = new outside_repair();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	

	/**
	 * Create the frame.
	 * @param success 
	 * @param room 
	 * @param department 
	 * @param sex 
	 * @param name 
	 * @param universityNumber 
	 */
	public outside_repair(String user_id, String universityNumber, String name, String sex, String department,
			String room, String success, String outing_date, String returning_date) {
		setTitle("외박 수정");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		System.out.println(user_id);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 438, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 438, 280);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("외박 시작일");
		lblNewLabel.setBounds(10, 56, 69, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("외박 귀가일");
		lblNewLabel_1.setBounds(208, 56, 69, 15);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(82, 53, 96, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(287, 53, 96, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("생활관");
		lblNewLabel_2.setBounds(10, 91, 50, 15);
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(82, 88, 96, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("사유");
		lblNewLabel_3.setBounds(10, 129, 50, 15);
		panel_1.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("학교행사");
		rdbtnNewRadioButton.setBounds(53, 125, 96, 23);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("귀가");
		rdbtnNewRadioButton_1.setBounds(145, 125, 73, 23);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("입원");
		rdbtnNewRadioButton_2.setBounds(222, 125, 73, 23);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("기타");
		rdbtnNewRadioButton_3.setBounds(310, 125, 73, 23);
		
		ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnNewRadioButton);
        buttonGroup.add(rdbtnNewRadioButton_1);
        buttonGroup.add(rdbtnNewRadioButton_2);
        buttonGroup.add(rdbtnNewRadioButton_3);

        panel_1.add(rdbtnNewRadioButton);
        panel_1.add(rdbtnNewRadioButton_1);
        panel_1.add(rdbtnNewRadioButton_2);
        panel_1.add(rdbtnNewRadioButton_3);
        
		JTextPane textPane = new JTextPane();
		textPane.setBounds(52, 171, 354, 99);
		panel_1.add(textPane);
		
		JLabel lblNewLabel_4 = new JLabel("내용");
		lblNewLabel_4.setBounds(10, 171, 50, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이름");
		lblNewLabel_5.setBounds(10, 20, 50, 15);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("학과");
		lblNewLabel_7.setBounds(208, 20, 50, 15);
		panel_1.add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(82, 17, 96, 21);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(287, 17, 96, 21);
		panel_1.add(textField_4);
		
		//사유 클릭 이벤트
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // rdbtnNewRadioButton이 클릭되었을 때 실행할 코드
		        System.out.println("rdbtnNewRadioButton이 선택되었습니다.");
		        reasoncheck = rdbtnNewRadioButton.getText();
		    }
		});

		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // rdbtnNewRadioButton_1이 클릭되었을 때 실행할 코드
		        System.out.println("rdbtnNewRadioButton_1이 선택되었습니다.");
		        reasoncheck = rdbtnNewRadioButton_1.getText();
		    }
		});
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // rdbtnNewRadioButton_1이 클릭되었을 때 실행할 코드
		        System.out.println("rdbtnNewRadioButton_2이 선택되었습니다.");
		        reasoncheck = rdbtnNewRadioButton_2.getText();
		    }
		});
		
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // rdbtnNewRadioButton_1이 클릭되었을 때 실행할 코드
		        System.out.println("rdbtnNewRadioButton_3이 선택되었습니다.");
		        reasoncheck = rdbtnNewRadioButton_3.getText();
		    }
		});
		String reason_1 = null;
		//user_id를 사용하여 사용자의 모든 정보를 추출
		// Search_Student_Info 메서드 호출
        List<StudentOutsideDTO> studentList = db.Student_update_search(user_id);
        //이름 학과 생활관
        // 반환된 학생 정보 리스트 사용 예시
        for (StudentOutsideDTO studentInfo : studentList) {
            textField_3.setText(name);
            textField_4.setText(department);
            textField_2.setText(room);
            textField.setText(studentInfo.getOutingDate());
            textField_1.setText(studentInfo.getReturningDate());
            textPane.setText(studentInfo.getContent());
            reason_1 = (studentInfo.getReason());
        }
        if(reason_1.equals("학교행사")) {
        	rdbtnNewRadioButton.setSelected(true);
        }
        else if(reason_1.equals("귀가")) {
        	rdbtnNewRadioButton_1.setSelected(true);
        }
        else if(reason_1.equals("입원")) {
        	rdbtnNewRadioButton_2.setSelected(true);
        }
        else {
        	rdbtnNewRadioButton_3.setSelected(true);
        }
        if(!reason_1.equals(null)) {
			reasoncheck=reason_1;
		}
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String RS = textField_3.getText();
				String CT = textPane.getText();
				String OD = textField.getText();
				String RD = textField_1.getText();
				
				String os = db.outside_repair(universityNumber, reasoncheck, CT, OD, RD);
				
				if(os.equals("성공")) {
					showConfirmationDialog("등록되었습니다.");
				}
				else {
					showConfirmationDialog("실패되었습니다.");
				}
				outside_main user = new outside_main(user_id);
	    		user.setVisible(true);
	    		dispose();
			}
		});
		btnNewButton.setBounds(65, 291, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		outside_main user = new outside_main(user_id);
	    		user.setVisible(true);
	    		dispose();
	    		
	    	}
		});
		btnNewButton_1.setBounds(279, 291, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String RS = textField_3.getText();
				String CT = textPane.getText();
				String OD = textField.getText();
				String RD = textField_1.getText();
				
				String os = db.outside_request_delete(universityNumber, reasoncheck, CT, OD, RD);
				
				if(os.equals("성공")) {
					showConfirmationDialog("삭제되었습니다.");
				}
				else {
					showConfirmationDialog("실패되었습니다.");
				}
				outside_main user = new outside_main(user_id);
	    		user.setVisible(true);
	    		dispose();
			}
		});
		btnNewButton_2.setBounds(176, 291, 93, 23);
		contentPane.add(btnNewButton_2);
		setLocationRelativeTo(null);
	}
	// 알림 창을 표시하는 메소드
	private void showConfirmationDialog(String message) {
	    JOptionPane.showMessageDialog(null, message, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
}
