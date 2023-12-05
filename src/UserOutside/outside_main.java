package UserOutside;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Database.DAO;
import Database.StudentInformationDTO;

public class outside_main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	DAO db = new DAO();
	
	private void search(String user_id) {
	    String searchTerm = textField.getText();

	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);

	    // 데이터베이스 연결 매개변수
	    String jdbcUrl = "jdbc:mysql://localhost:3306/domitory";
	    String username = "root";
	    String password = "1234";

	    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password)) {
	        String sql =  "SELECT si.university_number, si.name, si.sex, si.department, sr.room, so.success " +
	                "FROM student_information si " +
	                "JOIN student_room sr ON si.university_number = sr.university_number " +
	                "JOIN student_outside so ON si.university_number = so.university_number " +
	                "WHERE si.name LIKE ?";
	        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setString(1, "%" + searchTerm + "%");
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                student_information studentInfo = new student_information(
	                        resultSet.getString("university_number"),
	                        resultSet.getString("name"),
	                        resultSet.getString("sex"),
	                        resultSet.getString("department"),
	                        resultSet.getString("room"),
	                        resultSet.getString("success")
	                );

	                Vector<String> row = new Vector<>();
	                row.add(studentInfo.getUniversity_number());
	                row.add(studentInfo.getName());
	                row.add(studentInfo.getSex());
	                row.add(studentInfo.getDepartment());
	                row.add(studentInfo.getRoom());
	                row.add(studentInfo.getSuccess()); // success 추가

	                model.addRow(row);
	            }
	            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

	            TableColumnModel columnModel = table.getColumnModel();
	            for (int i = 0; i < columnModel.getColumnCount(); i++) {
	                columnModel.getColumn(i).setCellRenderer(centerRenderer);
	            }
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
	                        String room = (String) table.getValueAt(row, 4);
	                        String success = (String) table.getValueAt(row, 5);

	                        // 새로운 UI 생성 및 데이터 전달
	                        outside_repair repair = new outside_repair(user_id, universityNumber, name, sex, department, room, success, success, success);
	                        repair.setVisible(true);
	                        dispose();  // 현재 UI 닫기
	                    }
	                }
	            });
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "데이터베이스 연결 또는 쿼리 실행 중 오류가 발생했습니다.");
	    }
	}
	/**
	 * Create the frame.
	 */
	public outside_main(String user_id) {
		setTitle("외박 메인화면");
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
	    		user_main user = new user_main();
	    		user.setVisible(true);
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
		
		JButton btnNewButton = new JButton("찾기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search(user_id);
			}
		});
		btnNewButton.setBounds(152, 18, 82, 70);
		panel.add(btnNewButton);
		table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "학번", "이름", "성별", "학과", "호실", "외박승인여부" }));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(12, 100, 445, 184);
        panel.add(scrollPane);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(10, 98, 448, 187);
		panel.add(progressBar_1);
		
		JButton btnNewButton_1_2 = new JButton("외박 신청");
		btnNewButton_1_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		outside_request user = new outside_request(user_id);
	    		user.setVisible(true);
	    		dispose();
	    	}
		});
		btnNewButton_1_2.setBounds(238, 19, 109, 69);
		panel.add(btnNewButton_1_2);
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 10, 448, 86);
		panel.add(progressBar);
		
		setLocationRelativeTo(null);
	}
	public outside_main() {
		// TODO Auto-generated constructor stub
	}
	public class student_information {
		private String university_number;
	    private String name;
	    private String sex;
	    private String department;
	    private String room;
	    private String phoneNumber;
	    private String success;

	    public student_information(String university_number, String name, String sex, String department, String room, String success) {
	        this.university_number = university_number;
	        this.name = name;
	        this.sex = sex;
	        this.department = department;
	        this.room = room;
	        this.success = success;
	    }

		public student_information(String string, String string2, String string3, String string4, String string5,
				String string6, String string7, String string8) {
			// TODO Auto-generated constructor stub
		}

		public String getUniversity_number() {
	        return university_number;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getSex() {
	        return sex;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }
	    public String getRoom() {
	        return room;
	    }
	    public String getSuccess() {
	        return success;
	    }
	}

}