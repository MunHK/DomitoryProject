package ManagerInandOut;

import java.awt.EventQueue;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Database.DAO;
import Database.SrudentInfoRoomDTO;
import Database.StudentCheckinandoutDTO;
import Database.StudentInfoCheckDTO;
import Database.StudentInformationDTO;

public class inandout_manage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	StudentCheckinandoutDTO studentList = new StudentCheckinandoutDTO();
	DAO db = new DAO();
	SrudentInfoRoomDTO inforoom = new SrudentInfoRoomDTO();
	StudentInformationDTO info = new StudentInformationDTO();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public inandout_manage() {
		setTitle("입실/퇴실 관리");
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
	                 
	               },
	               new String[] {
	                  "학번", "이름", "성별", "학과", "입실퇴실여부"
	               }   
	            ));
	      scrollPane.setViewportView(table);
	      table.getColumn("학번").setPreferredWidth(30);
	      table.getColumn("이름").setPreferredWidth(30);
	      table.getColumn("성별").setPreferredWidth(30);
	      table.getColumn("학과").setPreferredWidth(30);
	      table.getColumn("입실퇴실여부").setPreferredWidth(60);

	      scrollPane.setViewportView(table);
	      DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); //테이블 밑에 사용 튜플값들 가운데 정렬
	      dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	      TableColumnModel tcm = table.getColumnModel();
	      for(int i = 0; i < tcm.getColumnCount(); i++) {
	         tcm.getColumn(i).setCellRenderer(dtcr);
	      }
	      scrollPane.setBounds(12, 100, 445, 183);
	      table.setBounds(12, 100, 445, 183);
	      panel.add(scrollPane);

	      DefaultTableModel model = (DefaultTableModel)table.getModel();
	      
		JButton btnNewButton_1 = new JButton("퇴실 신청 조회");
		btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				info.setUniversityNumber(textField_1.getText());
				info.setName(textField.getText());
				
				List<StudentInfoCheckDTO> studentList = db.Search_Student_InfoCheck(info);//
                // Clear existing rows from the table
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

            	for (StudentInfoCheckDTO student : studentList) {
	                Object[] rowData = {
	                        student.getUniversityNumber(),
	                        student.getName(),
	                        student.getSex(),
	                        student.getDepartment(),
	                        student.getIng()
	                };
	                if(student.getIng().equals("미승인")&& student.getInOut().equals("퇴실")){
	                	model.addRow(rowData);
	                }
            	}
                // Add rows from the studentList to the table
                
                
                
				textField.setText("");
				textField_1.setText("");
	    	}
		});
		btnNewButton_1.setBounds(229, 58, 131, 32);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("뒤로가기");
		btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		manager_main manage = new manager_main();
	    		manage.setVisible(true);
	    		dispose();
	    	}
		});
		btnNewButton_2.setBounds(365, 18, 90, 72);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(20, 22, 50, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("학번");
		lblNewLabel_1.setBounds(20, 64, 50, 15);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(55, 19, 164, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 61, 164, 21);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
	      JButton btnNewButton = new JButton("입실 신청 조회");
			btnNewButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		info.setUniversityNumber(textField_1.getText());
					info.setName(textField.getText());
					
					List<StudentInfoCheckDTO> studentList = db.Search_Student_InfoCheck(info);//
	                // Clear existing rows from the table
	                DefaultTableModel model = (DefaultTableModel) table.getModel();
	                model.setRowCount(0);

	            	for (StudentInfoCheckDTO student : studentList) {
		                Object[] rowData = {
		                        student.getUniversityNumber(),
		                        student.getName(),
		                        student.getSex(),
		                        student.getDepartment(),
		                        student.getIng()
		                };
		                if(student.getIng().equals("미승인")&&student.getInOut().equals("입실")){
		                	model.addRow(rowData);
		                }
	            	}
					textField.setText("");
					textField_1.setText("");
					table.addMouseListener(new java.awt.event.MouseAdapter() {
		                @Override
		                public void mouseClicked(java.awt.event.MouseEvent evt) {
		                    int row = table.rowAtPoint(evt.getPoint());
		                    int col = table.columnAtPoint(evt.getPoint());
		                    if (row >= 0 && col >= 0) {
		                        // 선택한 행의 데이터 가져오기
		                        String universityNumber = (String) table.getValueAt(row, 0);
		                        String name = (String) table.getValueAt(row, 1);
		                        String sex = (String) table.getValueAt(row, 2);
		                        String department = (String) table.getValueAt(row, 3);
		                        String Ing = (String) table.getValueAt(row, 4);

		                        // 새로운 UI 생성 및 데이터 전달
		                        inandout_request request = new inandout_request(universityNumber, name, sex, department, Ing);
		                        request.setVisible(true);
		                    }
		                }
		            });
		    	}
			});
			btnNewButton.setBounds(229, 18, 131, 32);
			panel.add(btnNewButton);
			
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(10, 98, 448, 187);
		panel.add(progressBar_1);
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 10, 448, 86);
		panel.add(progressBar);
		setLocationRelativeTo(null);
	}
}