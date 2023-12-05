package UsertInandOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.DAO;
import Database.SrudentInfoRoomDTO;
import Database.StudentCheckinandoutDTO;
import Database.StudentInformationDTO;
import ManagerRoom.room_info;

public class inandout_main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel contentPane;
	private JTextField textField;
	DAO db = new DAO();
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the frame.
	 */
	public inandout_main(StudentInformationDTO info) {
		
		StudentCheckinandoutDTO inout = db.inandout_search(info);
		System.out.println("ewqdsa"+info.getUniversityNumber());
		
		setTitle("입실퇴실 메인화면");
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

		textField = new JTextField(info.getName());
		textField.setEditable(false);
		textField.setBounds(88, 29, 140, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(info.getUniversityNumber());
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(88, 61, 140, 21);
		panel.add(textField_1);
		
		table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "학번", "신청일", "승인여부","입/퇴실"}));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(12, 100, 445, 184);
        panel.add(scrollPane);
	    
        DefaultTableModel model = (DefaultTableModel)table.getModel();
	    System.out.println(inout.getStartDate());
        Object[] rowData = {
                inout.getUniversityNumber(),
                inout.getStartDate(),
                inout.getIng(),
                inout.getInOut()
        };
        model.addRow(rowData);
        
		JButton btnNewButton_1_2_1 = new JButton("퇴실신청");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String roomnum=""; 
	    		List<SrudentInfoRoomDTO> studentList = db.Search_Student_Info(info.getUniversityNumber(),"학번");
	    		for (SrudentInfoRoomDTO studentInfo : studentList) {
    	            roomnum = studentInfo.getRoom();
	    	        
	            }
                if(!roomnum.equals("")) { // 거주중이지않은 학생
                	out_request manage = new out_request(info);
	    			manage.setVisible(true);
	    			dispose();
                }
                else { // 거주중
                	showConfirmationDialog("거주중인 학생이 아닙니다.");
                }
//	    		if(!inout.getIng().equals("")) {
//	    			out_request manage = new out_request(info);
//	    			manage.setVisible(true);
//	    			dispose();
//	    		}
//	    		else {
//	    			showConfirmationDialog("거주중인 학생이 아닙니다.");
//	    		}
	    	}
		});
		btnNewButton_1_2_1.setBounds(238, 55, 109, 33);
		panel.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_2 = new JButton("뒤로가기");
		btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		user_main user = new user_main(info);
	    		user.setVisible(true);
	    		dispose();
	    	}
		});
		btnNewButton_2.setBounds(350, 55, 96, 33);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 32, 50, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("학번");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 63, 50, 15);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_2 = new JButton("입실신청");
		btnNewButton_1_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String roomnum=""; 
	    		List<SrudentInfoRoomDTO> studentList = db.Search_Student_Info(info.getUniversityNumber(),"학번");
	    		for (SrudentInfoRoomDTO studentInfo : studentList) {
    	            roomnum = studentInfo.getRoom();
	    	        
	            }
                if(roomnum.equals("")) { // 거주중이지않은 학생
                	in_request manage = new in_request(info);
                	manage.setVisible(true);
                	dispose();
                }
                else { // 거주중
                	showConfirmationDialog("이미 거주중이거나 입실완료된 학생입니다.");
                }
	    		
	    	}
		});
		btnNewButton_1_2.setBounds(238, 19, 109, 33);
		panel.add(btnNewButton_1_2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 10, 448, 86);
		panel.add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(10, 98, 448, 187);
		panel.add(progressBar_1);
		setLocationRelativeTo(null);
	}
	private void showConfirmationDialog(String message) {
	    JOptionPane.showMessageDialog(null, message, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
}