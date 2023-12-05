package ManagerRoom;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.SrudentInfoRoomDTO;

import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class room_info extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name1Field;
	private JTextField department1Field;
	private JTextField phone1Field;
	private JTextField address1Field;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_1;
	private JTextField name2Field;
	private JTextField department2Field;
	private JTextField phone2Field;
	private JTextField address2Field;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public room_info(List<SrudentInfoRoomDTO> studentList) {
		setTitle("생활관 학생 정보");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 591, 355);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(room_info.class.getResource("/image/빈방이미지.png")));
		lblNewLabel.setBounds(118, 29, 70, 70);
		panel.add(lblNewLabel);
		
		name1Field = new JTextField();
		name1Field.setBounds(118, 120, 133, 21);
		panel.add(name1Field);
		name1Field.setColumns(10);
		
		department1Field = new JTextField();
		department1Field.setColumns(10);
		department1Field.setBounds(118, 180, 133, 21);
		panel.add(department1Field);
		
		phone1Field = new JTextField();
		phone1Field.setColumns(10);
		phone1Field.setBounds(118, 240, 133, 21);
		panel.add(phone1Field);
		
		address1Field = new JTextField();
		address1Field.setColumns(10);
		address1Field.setBounds(118, 300, 133, 21);
		panel.add(address1Field);
		
		lblNewLabel_2 = new JLabel("이름:");
		lblNewLabel_2.setBounds(58, 123, 50, 15);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("학과:");
		lblNewLabel_3.setBounds(58, 183, 50, 15);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("전화번호:");
		lblNewLabel_4.setBounds(47, 243, 61, 15);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("주소:");
		lblNewLabel_5.setBounds(58, 303, 50, 15);
		panel.add(lblNewLabel_5);
		
		btnNewButton_1 = new JButton("X");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room_number roomnumber = new room_number();
				roomnumber.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(549, 0, 42, 42);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(room_info.class.getResource("/image/빈방이미지.png")));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(421, 29, 70, 70);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("이름:");
		lblNewLabel_2_1.setBounds(346, 123, 50, 15);
		panel.add(lblNewLabel_2_1);
		
		name2Field = new JTextField();
		name2Field.setColumns(10);
		name2Field.setBounds(406, 120, 133, 21);
		panel.add(name2Field);
		
		JLabel lblNewLabel_3_1 = new JLabel("학과:");
		lblNewLabel_3_1.setBounds(346, 183, 50, 15);
		panel.add(lblNewLabel_3_1);
		
		department2Field = new JTextField();
		department2Field.setColumns(10);
		department2Field.setBounds(406, 180, 133, 21);
		panel.add(department2Field);
		
		JLabel lblNewLabel_4_1 = new JLabel("전화번호:");
		lblNewLabel_4_1.setBounds(335, 243, 61, 15);
		panel.add(lblNewLabel_4_1);
		
		phone2Field = new JTextField();
		phone2Field.setColumns(10);
		phone2Field.setBounds(406, 240, 133, 21);
		panel.add(phone2Field);
		
		JLabel lblNewLabel_5_1 = new JLabel("주소:");
		lblNewLabel_5_1.setBounds(346, 303, 50, 15);
		panel.add(lblNewLabel_5_1);
		
		address2Field = new JTextField();
		address2Field.setColumns(10);
		address2Field.setBounds(406, 300, 133, 21);
		panel.add(address2Field);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(302, 44, 2, 290);
		panel.add(panel_1);
		setLocationRelativeTo(null);
		int index = 0; // studentList에서 현재 처리 중인 학생의 인덱스
		 
        for (SrudentInfoRoomDTO studentInfo : studentList) {
        	System.out.println(studentInfo.getName());
        	System.out.println(studentInfo.getDepartment());
        	System.out.println(studentInfo.getPhoneNumber());
	        System.out.println(studentInfo.getAddress());
	        
	        // 각 레코드에 대한 정보를 UI 텍스트 필드에 설정
	        if (index == 0) {
	            name1Field.setText(studentInfo.getName());
	            department1Field.setText(studentInfo.getDepartment());
	            phone1Field.setText(studentInfo.getPhoneNumber());
	            address1Field.setText(studentInfo.getAddress());
	        }
	        else if (index == 1) {
	            name2Field.setText(studentInfo.getName());
	            department2Field.setText(studentInfo.getDepartment());
	            phone2Field.setText(studentInfo.getPhoneNumber());
	            address2Field.setText(studentInfo.getAddress());
	        }
	        index++;
        }
        
	}
}
