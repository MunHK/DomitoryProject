package user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.DAO;
import Database.SrudentInfoRoomDTO;
import Database.StudentInformationDTO;
import UserOutside.outside_main;
import UsertInandOut.inandout_main;

public class user_main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel contentPane;
	StudentInformationDTO info = new StudentInformationDTO();
	SrudentInfoRoomDTO inforoom=new SrudentInfoRoomDTO();
	DAO db = new DAO();
	
	/**
	 * Create the frame.
	 */
	public user_main(StudentInformationDTO info) {
		inforoom.setUniversityNumber(info.getUniversityNumber());
		setTitle("사용자 메인 화면");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 468, 295);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(info.getName()+ "님 안녕하세요");
		lblNewLabel.setBounds(20, 35, 120, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("서원 기숙사 프로그램입니다.");
		lblNewLabel1.setBounds(20, 55, 170, 15);
		panel.add(lblNewLabel1);
		
		JButton btnNewButton = new JButton("조회");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inforoom.setName("");
				inforoom.setRoom("");
				List<SrudentInfoRoomDTO> studentList = db.Search_Student_room(inforoom);

                // Clear existing rows from the table
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                // Add rows from the studentList to the table
                for (SrudentInfoRoomDTO student : studentList) {
                    Object[] rowData = {
                            student.getUniversityNumber(),
                            student.getName(),
                            student.getSex(),
                            student.getDepartment(),
                            student.getRoom(),
                            student.getPhoneNumber()
                    };
                    model.addRow(rowData);
                }
                
			}
		});
		btnNewButton.setBounds(180, 18, 80, 70);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("입실/퇴실 관리");
		btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		inandout_main manage = new inandout_main(info);
	    		manage.setVisible(true);
	    		dispose();
	    	}
		});
		btnNewButton_1.setBounds(271, 18, 174, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("외박 관리");
		btnNewButton_1_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		outside_main user = new outside_main(info.getUniversityNumber());
	    		user.setVisible(true);
	    		dispose();
	    	}
		});
		
		table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "학번", "이름", "성별", "학과", "호실", "전화번호" }));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(12, 100, 445, 184);
        panel.add(scrollPane);
        
        
		btnNewButton_1_1.setBounds(271, 54, 174, 34);
		panel.add(btnNewButton_1_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 10, 448, 86);
		panel.add(progressBar);
	       
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(10, 98, 448, 187);
		
		panel.add(progressBar_1);
		
		setLocationRelativeTo(null);
	}
	public user_main() {
		// TODO Auto-generated constructor stub
	}
}