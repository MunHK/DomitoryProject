package ManagerInandOut;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Database.DAO;
import Database.SrudentInfoRoomDTO;

public class inandout_request extends JFrame{

	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	DAO db = new DAO();
	SrudentInfoRoomDTO inforoom = new SrudentInfoRoomDTO();
	/**
	 * Launch the application.
	 */
	 
	/**
	 * Create the application.
	 */
	public inandout_request(String universityNumber, String reason, String content, String atime, String Ing) {
		inforoom.setUniversityNumber(universityNumber);
		inforoom.setName("");
		inforoom.setRoom("");
		List<SrudentInfoRoomDTO> studentList = db.Search_Student_room(inforoom);
		for(SrudentInfoRoomDTO student : studentList) {
			inforoom.setStartDate(student.getStartDate());
			inforoom.setEndDate(student.getEndDate());
		}
		setTitle("입퇴실 승인");
		setVisible(true);
		setSize(new Dimension(400, 520));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 360, 385);
		getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(257, 405, 115, 70);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inandout_manage manage = new inandout_manage();
				manage.setVisible(true);
				dispose();
			}
		});
		panel.setLayout(null);
		
		JCheckBox chckbxX = new JCheckBox("X");
		chckbxX.setBounds(230, 300, 44, 23);
		panel.add(chckbxX);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("O");
		chckbxNewCheckBox.setBounds(160, 300, 44, 23);
		panel.add(chckbxNewCheckBox);

		if(Ing.equals("미승인")) {
			chckbxX.setSelected(true);
		}
		else {
			chckbxNewCheckBox.setSelected(true);
		}
		
		ButtonGroup group = new ButtonGroup();
		group.add(chckbxNewCheckBox);
		group.add(chckbxX);

		panel.add(chckbxNewCheckBox);
		panel.add(chckbxX);
		
		JLabel lblNewLabel = new JLabel("학번: ");
		lblNewLabel.setBounds(85, 53, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("사유: ");
		lblNewLabel_1.setBounds(85, 94, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("내용: ");
		lblNewLabel_2.setBounds(85, 135, 57, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("시간: ");
		lblNewLabel_3.setBounds(85, 177, 57, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("퇴실일:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(68, 256, 74, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("입실일:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(68, 217, 74, 15);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("승인여부: ");
		lblNewLabel_6.setBounds(68, 304, 86, 15);
		panel.add(lblNewLabel_6);
		
		textField = new JTextField(universityNumber);
		textField.setEditable(false);
		textField.setBounds(158, 50, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(158, 91, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(reason);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(158, 132, 116, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(content);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(158, 174, 116, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(atime);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(158, 214, 116, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(inforoom.getStartDate());
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(160, 253, 116, 21);
		panel.add(textField_5);
		textField_5.setText(inforoom.getEndDate());
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(12, 405, 115, 70);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = null;

				// 체크박스가 선택되었는지 여부를 확인하고 문자열 변수에 값을 할당
				if (chckbxNewCheckBox.isSelected()) {
				    s = "승인";
				} else if (chckbxX.isSelected()) {
				    s = "미승인";
				}
				String ou = db.inandout_manage_repair(universityNumber, s);
				
				System.out.println(s);
				
				inandout_manage manage = new inandout_manage();
				manage.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 0, 360, 385);
		panel.add(progressBar);
		
		JButton btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String os = db.inandout_manage_delete(universityNumber);
				
				inandout_manage manage = new inandout_manage();
				manage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(137, 405, 115, 70);
		getContentPane().add(btnNewButton_2);
		
		setLocationRelativeTo(null);
	}
	
}
