package UserInformation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import Database.DAO;

public class student_repair{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	DAO db = new DAO();
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					student_repair window = new student_repair(String university_number, String name, String sex, String department, String address, String phone_number, String birth);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public student_repair(String university_number, String name, String sex, String department, String address, String phone_number, String birth, String room) {
		initialize(university_number, name, sex, department, address, phone_number, birth, room);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String university_number, String name, String sex, String department, String address, String phone_number, String birth, String room) {
		frame = new JFrame("학생 등록");
		frame.setTitle("학생 수정");
		setVisible(true);
		frame.setSize(new Dimension(400, 520));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 360, 385);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(267, 405, 105, 70);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student_info_main manage = new student_info_main();
	    		manage.setVisible(true);
				frame.dispose();
			}
		});
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("학번: ");
		lblNewLabel.setBounds(85, 57, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름: ");
		lblNewLabel_1.setBounds(85, 99, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("성별:");
		lblNewLabel_2.setBounds(85, 143, 57, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("학과:");
		lblNewLabel_3.setBounds(85, 189, 57, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("주소:");
		lblNewLabel_4.setBounds(85, 228, 57, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("전화번호: ");
		lblNewLabel_5.setBounds(85, 271, 57, 15);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("생년월일: ");
		lblNewLabel_6.setBounds(85, 315, 57, 15);
		panel.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(158, 54, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText(university_number);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(158, 96, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(name);
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 140, 116, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(sex);
		
		textField_3 = new JTextField();
		textField_3.setBounds(158, 186, 116, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(department);
		
		textField_4 = new JTextField();
		textField_4.setBounds(158, 225, 116, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(address);
		
		textField_5 = new JTextField();
		textField_5.setBounds(158, 268, 116, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setText(phone_number);
		
		textField_6 = new JTextField();
		textField_6.setBounds(158, 312, 116, 21);
		panel.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setText(birth);
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.setBounds(12, 405, 117, 70);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String A = textField.getText();
				String B = textField_1.getText();
				String C = textField_2.getText();
				String D = textField_3.getText();
				String E = textField_4.getText();
				String F = textField_5.getText();
				String G = textField_6.getText();
				String I = textField_7.getText();
				
				String H = db.student_info_repair(A, B, C, D, E, F, G,I);
				
				if(H.equals("성공")) {
					showConfirmationDialog("수정되었습니다.");
				}
				else {
					showConfirmationDialog("실패되었습니다.");
				}
				student_info_main manage = new student_info_main();
	    		manage.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("호실:");
		lblNewLabel_6_1.setBounds(85, 357, 57, 15);
		panel.add(lblNewLabel_6_1);
		
		textField_7 = new JTextField();
		textField_7.setText("<dynamic>");
		textField_7.setColumns(10);
		textField_7.setBounds(158, 354, 116, 21);
		panel.add(textField_7);
		textField_7.setText(room);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 0, 360, 385);
		panel.add(progressBar);
		
		JButton btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String A1 = textField.getText();
				String B1 = textField_1.getText();
				String C1 = textField_2.getText();
				String D1 = textField_3.getText();
				String E1 = textField_4.getText();
				String F1 = textField_5.getText();
				String G1 = textField_6.getText();
				String I1 = textField_7.getText();
				
				String H1 = db.student_info_delete(A1, B1, C1, D1, E1, F1, G1, I1);
				
				if(H1.equals("성공")) {
					showConfirmationDialog("삭제되었습니다.");
				}
				else {
					showConfirmationDialog("실패되었습니다.");
				}
	    		student_info_main manage = new student_info_main();
	    		manage.setVisible(true);
	    		frame.dispose();
	    	}
		});
		btnNewButton_2.setBounds(139, 405, 118, 70);
		frame.getContentPane().add(btnNewButton_2);
		
		setLocationRelativeTo(null);
	}

	private void setLocationRelativeTo(Object object) {
		// TODO Auto-generated method stub
		
	}

	void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	private void showConfirmationDialog(String message) {
	    JOptionPane.showMessageDialog(null, message, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
}
