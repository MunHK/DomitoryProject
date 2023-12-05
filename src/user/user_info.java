package user;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class user_info {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;

    // 추가: 사용자 정보를 저장할 변수
    private String universityNumber;
    private String name;
    private String sex;
    private String department;
    private String address;
    private String room;
    private String phone_number;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    user_info window = new user_info();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public user_info() {
        // TODO Auto-generated constructor stub
        initialize();
    }

    // 추가: 데이터베이스에서 사용자 정보 및 방 정보 불러오기
    public user_info(String universityNumber) {
        this.universityNumber = universityNumber;

        // 데이터베이스 연결 정보
        String jdbcUrl = "jdbc:mysql://localhost:3306/domitory";
        String username = "root";
        String password = "1234";

        try (Connection con = DriverManager.getConnection(jdbcUrl, username, password)) {
            // 사용자 정보 불러오기
            String userSql = "SELECT * FROM student_information WHERE university_number = ?";
            try (PreparedStatement userStatement = con.prepareStatement(userSql)) {
                userStatement.setString(1, universityNumber);
                ResultSet userResultSet = userStatement.executeQuery();

                if (userResultSet.next()) {
                    this.name = userResultSet.getString("name");
                    this.sex = userResultSet.getString("sex");
                    this.department = userResultSet.getString("department");
                    this.phone_number = userResultSet.getString("phone_number");
                }
            }

            // 방 정보 불러오기
            String roomSql = "SELECT * FROM student_room WHERE university_number = ?";
            try (PreparedStatement roomStatement = con.prepareStatement(roomSql)) {
                roomStatement.setString(1, universityNumber);
                ResultSet roomResultSet = roomStatement.executeQuery();

                if (roomResultSet.next()) {
                    this.room = roomResultSet.getString("room");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "데이터베이스 연결 또는 쿼리 실행 중 오류가 발생했습니다.");
        }

       // initialize();
    }

    public user_info(String universityNumber, String name, String department, String address, String sex, String phone_number, String room) {
        this.universityNumber = universityNumber;
        this.name = name;
        this.department = department;
        this.address = address;  // 주소 필드 추가
        this.sex = sex;
        this.phone_number = phone_number;
        this.room = room;

        initialize();
    }
	/**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("학생 정보");
        setVisible(true);
        frame.setSize(new Dimension(400, 520));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(12, 10, 360, 385);
        frame.getContentPane().add(panel);

        JButton btnNewButton_1 = new JButton("취소");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 추가: 취소 버튼 클릭 시 사용자 정보 수정 없이 단순히 창 닫기
                frame.dispose();
            }
        });
        btnNewButton_1.setBounds(212, 405, 160, 70);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("학번: ");
        lblNewLabel.setBounds(85, 57, 57, 15);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("이름: ");
        lblNewLabel_1.setBounds(85, 99, 57, 15);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("학과: ");
        lblNewLabel_2.setBounds(85, 143, 57, 15);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("주소: ");
        lblNewLabel_3.setBounds(85, 189, 57, 15);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("성별: ");
        lblNewLabel_4.setBounds(85, 228, 57, 15);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("전화번호: ");
        lblNewLabel_5.setBounds(85, 271, 57, 15);
        panel.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("호실: ");
        lblNewLabel_6.setBounds(85, 315, 57, 15);
        panel.add(lblNewLabel_6);

        textField = new JTextField();
        textField.setBounds(158, 54, 116, 21);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(158, 96, 116, 21);
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(158, 140, 116, 21);
        panel.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(158, 186, 116, 21);
        panel.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(158, 225, 116, 21);
        panel.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(158, 268, 116, 21);
        panel.add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(158, 310, 116, 21);
        panel.add(textField_6);
        textField_6.setColumns(10);

        // 추가: 불러온 사용자 정보를 각 텍스트 필드에 설정
        textField.setText(universityNumber);
        textField_1.setText(name);
        textField_2.setText(department);
        textField_3.setText(room);  // 방 정보 추가
        textField_4.setText(sex);
        textField_5.setText(phone_number);
        textField_6.setText(room);  // 방 정보 추가

        JButton btnNewButton = new JButton("확인");
        btnNewButton.setBounds(12, 405, 160, 70);
        frame.getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 추가: 수정 버튼 클릭 시 텍스트 필드에서 정보 가져와서 데이터베이스에 업데이트
                updateUserInfo();
            }
        });
        frame.getContentPane().add(btnNewButton_1);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(0, 0, 360, 385);
        panel.add(progressBar);

        frame.setVisible(true);
        setLocationRelativeTo(null);
    }

    private void setLocationRelativeTo(Object object) {
		
	}

	// 추가: 사용자 정보를 데이터베이스에 업데이트하는 메서드
    private void updateUserInfo() {
        String updatedName = textField_1.getText();
        String updatedDepartment = textField_2.getText();
        String updatedRoom = textField_6.getText();  // 수정된 호실 정보

        // 데이터베이스 연결 정보
        String jdbcUrl = "jdbc:mysql://localhost:3306/domitory";
        String username = "root";
        String password = "1234";

        try (Connection con = DriverManager.getConnection(jdbcUrl, username, password)) {
            // 사용자 정보 업데이트
            String updateSql = "UPDATE student_information SET name = ?, department = ? WHERE university_number = ?";
            try (PreparedStatement updateStatement = con.prepareStatement(updateSql)) {
                updateStatement.setString(1, updatedName);
                updateStatement.setString(2, updatedDepartment);
                updateStatement.setString(3, universityNumber);
                updateStatement.executeUpdate();
            }

            // 방 정보 업데이트
            String updateRoomSql = "UPDATE student_room SET room = ? WHERE university_number = ?";
            try (PreparedStatement updateRoomStatement = con.prepareStatement(updateRoomSql)) {
                updateRoomStatement.setString(1, updatedRoom);
                updateRoomStatement.setString(2, universityNumber);
                updateRoomStatement.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "사용자 정보가 성공적으로 수정되었습니다.");
            frame.dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "데이터베이스 연결 또는 쿼리 실행 중 오류가 발생했습니다.");
        }
    }
    

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
