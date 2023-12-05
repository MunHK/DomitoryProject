package ManagerOutside;

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
import Database.StudentOutsideDTO;

public class outside_manage extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTable table;
    private DefaultTableModel tableModel;
    DAO db = new DAO();
    
	public outside_manage() {
		setTitle("외박 관리");
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
		btnNewButton_2.setBounds(302, 18, 137, 69);
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
		
		table = new JTable();
		table.setModel( new DefaultTableModel(
                new Object[][] {},
                new String[] { "학번", "사유", "내용", "시간", "외박 시작일", "외박 귀가일", "외박승인여부" }
                )
		);
        // 열 너비 및 셀 렌더러를 설정합니다.
        table.getColumn("학번").setPreferredWidth(30);
        table.getColumn("사유").setPreferredWidth(30);
        table.getColumn("내용").setPreferredWidth(30);
        table.getColumn("시간").setPreferredWidth(30);
        table.getColumn("외박 시작일").setPreferredWidth(30);
        table.getColumn("외박 귀가일").setPreferredWidth(30);
        table.getColumn("외박승인여부").setPreferredWidth(60);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tcm = table.getColumnModel();
        for (int i = 0; i < tcm.getColumnCount(); i++) {
            tcm.getColumn(i).setCellRenderer(dtcr);
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(12, 100, 445, 183);
        panel.add(scrollPane);
        
		JButton btnNewButton = new JButton("찾기");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 데이터베이스에서 데이터를 검색하고 테이블을 업데이트하는 메서드를 호출합니다.
            	List<StudentOutsideDTO> studentList =db.Search_Outside_Info();

                // Clear existing rows from the table
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                // Add rows from the studentList to the table
                for (StudentOutsideDTO student : studentList) {
                    Object[] rowData = {
                            student.getUniversityNumber(),
                            student.getReason(),
                            student.getContent(),
                            student.getTime(),
                            student.getOutingDate(),
                            student.getReturningDate(),
                            student.getSuccess()
                    };
                    model.addRow(rowData);
                }
                table.addMouseListener(new java.awt.event.MouseAdapter() {
	                @Override
	                public void mouseClicked(java.awt.event.MouseEvent evt) {
	                    int row = table.rowAtPoint(evt.getPoint());
	                    int col = table.columnAtPoint(evt.getPoint());

	                    if (row >= 0 && col >= 0) {
	                        // 선택한 행의 데이터 가져오기
	                        String universityNumber = (String) table.getValueAt(row, 0);
	                        String reason = (String) table.getValueAt(row, 1);
	                        String content = (String) table.getValueAt(row, 2);
	                        String atime = (String) table.getValueAt(row, 3);
	                        String outing_date = (String) table.getValueAt(row, 4);
	                        String returning_date = (String) table.getValueAt(row, 5);
	                        String success = (String) table.getValueAt(row, 6);

	                        // 새로운 UI 생성 및 데이터 전달
	                        outside_manage_info repair = new outside_manage_info(universityNumber, reason, content, atime, outing_date,returning_date, success);
	                        repair.setVisible(true);
	                    }
	                }
	            });
            }
        });
        btnNewButton.setBounds(161, 18, 131, 70);
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