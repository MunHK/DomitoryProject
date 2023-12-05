package ManagerRoom;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import Database.DAO;
import Database.SrudentInfoRoomDTO;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class room_number extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String selectedRoom;
	DAO db = new DAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					room_number frame = new room_number();
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
	public room_number() {
		setTitle("생활관 메인화면");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(0, 0, 529, 363);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		
		JLabel lblf_3 = new JLabel("1F");
		lblf_3.setBounds(20, 231, 23, 15);
		panel_7.add(lblf_3);
		
		JLabel lblf_2 = new JLabel("2F");
		lblf_2.setBounds(20, 166, 23, 15);
		panel_7.add(lblf_2);
		
		JLabel lblf_1 = new JLabel("3F");
		lblf_1.setBounds(20, 97, 23, 15);
		panel_7.add(lblf_1);
		
		JLabel lblf = new JLabel("4F");
		lblf.setBounds(20, 33, 23, 15);
		panel_7.add(lblf);
		
		int j = 0;
		int z = 0;
		int o = 0;
		int s = 0;
		int count = 0;
		int number = 101;
		
		JButton[] roomBtn = new JButton[38];
		for ( int i = 0; i< 38; i++) {
			if((i > 6) && (i < 14)) {
				number = 101;
				roomBtn[i] = new JButton();
				roomBtn[i].setText(Integer.toString(number + j));
				roomBtn[i].setBackground(new Color(222, 225, 247));
				roomBtn[i].setBorderPainted(false);
				roomBtn[i].setFocusPainted(false);
				roomBtn[i].setBounds(43 + 60*j, 224, 56, 28);
				panel_7.add(roomBtn[i]);
				int finalI = i; // ActionListener 내부에서 사용하기 위해 final 변수로 선언
	            roomBtn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // 버튼을 클릭했을 때 실행되는 부분
	                    selectedRoom = roomBtn[finalI].getText();
	                    System.out.println("Selected Room: " + selectedRoom);
	                    
	                    List<SrudentInfoRoomDTO> studentList = db.Search_Student_Info(selectedRoom,"호수");
	                    
	                    if(!studentList.isEmpty()) { // 방에 사람이 있을때
	                    	//이름, 학과, 전화번호, 주소
	                    	room_info roominfo = new room_info(studentList);
	                    	roominfo.setVisible(true);
	                    	dispose();
	                    }
	                    else { // 빈방일 때
	                    	showConfirmationDialog("빈 방입니다.");
	                    }
	                }
	            });
				count++;
				j++;
			}
			else if((i > 14) && (i < 22)) {
				number = 201;
				roomBtn[i] = new JButton();
				roomBtn[i].setText(Integer.toString(number + z));
				roomBtn[i].setBackground(new Color(222, 225, 247));
				roomBtn[i].setBorderPainted(false);
				roomBtn[i].setFocusPainted(false);
				roomBtn[i].setBounds(43 + 60*z, 155, 56, 28);
				panel_7.add(roomBtn[i]);
				int finalI = i; // ActionListener 내부에서 사용하기 위해 final 변수로 선언
	            roomBtn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // 버튼을 클릭했을 때 실행되는 부분
	                    selectedRoom = roomBtn[finalI].getText();
	                    System.out.println("Selected Room: " + selectedRoom);
	                    
	                    List<SrudentInfoRoomDTO> studentList = db.Search_Student_Info(selectedRoom,"호수");
	                    
	                    if(!studentList.isEmpty()) { // 방에 사람이 있을때
	                    	//이름, 학과, 전화번호, 주소
	                    	room_info roominfo = new room_info(studentList);
	                    	roominfo.setVisible(true);
	                    	dispose();
	                    }
	                    else { // 빈방일 때
	                    	showConfirmationDialog("빈 방입니다.");
	                    }
	                }
	            });
				count++;
				z++;
			}
			else if((i > 22) && (i < 30)) {
				number = 301;
				roomBtn[i] = new JButton();
				roomBtn[i].setText(Integer.toString(number + o));
				roomBtn[i].setBackground(new Color(222, 225, 247));
				roomBtn[i].setBorderPainted(false);
				roomBtn[i].setFocusPainted(false);
				roomBtn[i].setBounds(43 + 60*o, 90, 56, 28);
				panel_7.add(roomBtn[i]);
				int finalI = i; // ActionListener 내부에서 사용하기 위해 final 변수로 선언
	            roomBtn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // 버튼을 클릭했을 때 실행되는 부분
	                    selectedRoom = roomBtn[finalI].getText();
	                    System.out.println("Selected Room: " + selectedRoom);
	                    
	                    List<SrudentInfoRoomDTO> studentList = db.Search_Student_Info(selectedRoom,"호수");
	                    
	                    if(!studentList.isEmpty()) { // 방에 사람이 있을때
	                    	//이름, 학과, 전화번호, 주소
	                    	room_info roominfo = new room_info(studentList);
	                    	roominfo.setVisible(true);
	                    	dispose();
	                    }
	                    else { // 빈방일 때
	                    	showConfirmationDialog("빈 방입니다.");
	                    }
	                }
	            });
				count++;
				o++;
			}
			else if((i > 30) && (i < 38)) {
				number = 401;
				roomBtn[i] = new JButton();
				roomBtn[i].setText(Integer.toString(number + s));
				roomBtn[i].setBackground(new Color(222, 225, 247));
				roomBtn[i].setBorderPainted(false);
				roomBtn[i].setFocusPainted(false);
				roomBtn[i].setBounds(43 + 60*s, 27, 56, 28);
				panel_7.add(roomBtn[i]);
				int finalI = i; // ActionListener 내부에서 사용하기 위해 final 변수로 선언
	            roomBtn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // 버튼을 클릭했을 때 실행되는 부분
	                    selectedRoom = roomBtn[finalI].getText();
	                    System.out.println("Selected Room: " + selectedRoom);
	                    
	                    List<SrudentInfoRoomDTO> studentList = db.Search_Student_Info(selectedRoom,"호수");
	                    
	                    if(!studentList.isEmpty()) { // 방에 사람이 있을때
	                    	//이름, 학과, 전화번호, 주소
	                    	room_info roominfo = new room_info(studentList);
	                    	roominfo.setVisible(true);
	                    	dispose();
	                    }
	                    else { // 빈방일 때
	                    	showConfirmationDialog("빈 방입니다.");
	                    }
	                }
	            });
				count++;
				s++;
			}
	    }
		JButton btnNewButton = new JButton("취 소");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager_main manage = new manager_main();
				manage.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setBounds(385, 309, 82, 25);
		panel_7.add(btnNewButton);
		
		JLabel lblf_3_1 = new JLabel("B1");
		lblf_3_1.setBounds(20, 292, 23, 15);
		panel_7.add(lblf_3_1);
		
		JLabel lblNewLabel = new JLabel("이미지");
		lblNewLabel.setBounds(63, 281, 290, 53);
		panel_7.add(lblNewLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 10, 492, 343);
		panel_7.add(progressBar);
		setLocationRelativeTo(null);
	}
	// 알림 창을 표시하는 메소드
	private void showConfirmationDialog(String message) {
	    JOptionPane.showMessageDialog(null, message, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
}
