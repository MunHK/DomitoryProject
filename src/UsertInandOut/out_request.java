package UsertInandOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Database.DAO;
import Database.StudentCheckinandoutDTO;
import Database.StudentInformationDTO;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class out_request extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	DAO db = new DAO();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public out_request(StudentInformationDTO info) {
		setTitle("퇴실 신청");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 438, 280);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("학번");
		lblNewLabel.setBounds(10, 116, 69, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setBounds(208, 116, 69, 15);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField(info.getUniversityNumber());
		textField.setColumns(10);
		textField.setBounds(82, 113, 96, 21);
		panel_1.add(textField);
		
		textField_1 = new JTextField(info.getPhoneNumber());
		textField_1.setColumns(10);
		textField_1.setBounds(287, 113, 96, 21);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("성별");
		lblNewLabel_2.setBounds(10, 151, 50, 15);
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField(info.getSex());
		textField_2.setColumns(10);
		textField_2.setBounds(82, 148, 96, 21);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_5 = new JLabel("이름");
		lblNewLabel_5.setBounds(10, 80, 50, 15);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("학과");
		lblNewLabel_7.setBounds(208, 80, 50, 15);
		panel_1.add(lblNewLabel_7);
		
		textField_3 = new JTextField(info.getName());
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(82, 77, 96, 21);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField(info.getDepartment());
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(287, 77, 96, 21);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("주소");
		lblNewLabel_2_1.setBounds(208, 151, 50, 15);
		panel_1.add(lblNewLabel_2_1);
		
		textField_5 = new JTextField(info.getAddress());
		textField_5.setColumns(10);
		textField_5.setBounds(287, 148, 96, 21);
		panel_1.add(textField_5);
		
		JButton btnNewButton = new JButton("신청");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(db.student_inandout_request(info, "퇴실")) {
					showConfirmationDialog("퇴실 신청이 완료되었습니다!");
					inandout_main main = new inandout_main(info);
					main.setVisible(true);
					dispose();
				}
				else {
					showConfirmationDialog("퇴실 신청 실패");
				}
			}
		});
		btnNewButton.setBounds(82, 229, 93, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inandout_main main = new inandout_main(info);
				main.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(269, 229, 93, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("퇴실 신청서");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 10, 418, 23);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("*승인시 현재 거주중인 생활관에서 퇴실됩니다!");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(10, 196, 418, 23);
		panel_1.add(lblNewLabel_3_1);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		setLocationRelativeTo(null);
	}
	private void showConfirmationDialog(String message) {
	    JOptionPane.showMessageDialog(null, message, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
}
