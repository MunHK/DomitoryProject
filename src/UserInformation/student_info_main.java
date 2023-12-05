package UserInformation;

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
import manager.manager_main;

public class student_info_main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	DAO db = new DAO();
	SrudentInfoRoomDTO inforoom = new SrudentInfoRoomDTO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_info_main frame = new student_info_main();
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
	public student_info_main() {
		setTitle("학생 관리");
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
		
		JButton btnNewButton_2 = new JButton("뒤로가기");
		btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		manager_main manage = new manager_main();
	    		manage.setVisible(true);
	    		dispose();
	    	}
		});
		btnNewButton_2.setBounds(350, 19, 96, 69);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(20, 22, 50, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("학번");
		lblNewLabel_1.setBounds(20, 47, 50, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("호실");
		lblNewLabel_2.setBounds(20, 72, 50, 15);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(55, 19, 96, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 44, 96, 21);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(55, 69, 96, 21);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
	                 
	               },
	               new String[] {
	                  "학번", "이름", "성별", "학과", "전화번호", "호실", "생년월일", "주소"
	               }   
	            ));
	      scrollPane.setViewportView(table);
	      table.getColumn("학번").setPreferredWidth(30);
	      table.getColumn("이름").setPreferredWidth(30);
	      table.getColumn("성별").setPreferredWidth(30);
	      table.getColumn("학과").setPreferredWidth(30);
	      table.getColumn("주소").setPreferredWidth(30);
	      table.getColumn("전화번호").setPreferredWidth(45);
	      table.getColumn("생년월일").setPreferredWidth(45);
	      table.getColumn("호실").setPreferredWidth(30);

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
	      
		JButton btnNewButton = new JButton("찾기");
		btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		inforoom.setName(textField.getText());
				inforoom.setUniversityNumber(textField_1.getText());
				inforoom.setRoom(textField_2.getText());
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
                            student.getPhoneNumber(),
                            student.getRoom(),
                            student.getBirth(),
                            student.getAddress()
                    };
                    model.addRow(rowData);
                }
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
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
	                        String address = (String) table.getValueAt(row, 7);
	                        String phone_number = (String) table.getValueAt(row, 4);
	                        String birth = (String) table.getValueAt(row, 6);
	                        String room = (String) table.getValueAt(row, 5);

	                        // 새로운 UI 생성 및 데이터 전달
	                        student_repair repair = new student_repair(universityNumber, name, sex, 
	                        		department, address,phone_number, birth,room);
	                        repair.setVisible(true);
	                    }
	                }
	            });
            }
        });
		btnNewButton.setBounds(152, 18, 76, 70);
		panel.add(btnNewButton);

		
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(10, 98, 448, 187);
		panel.add(progressBar_1);
		
		JButton btnNewButton_1_2 = new JButton("등록");
		btnNewButton_1_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Student_insert manage = new Student_insert();
	    		manage.setVisible(true);
	    		dispose();
	    	}
		});
		btnNewButton_1_2.setBounds(230, 19, 117, 69);
		panel.add(btnNewButton_1_2);
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 10, 448, 86);
		panel.add(progressBar);
		setLocationRelativeTo(null);
	}
}