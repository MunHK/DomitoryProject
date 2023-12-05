package UsertInandOut;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class inandout_info{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inandout_info window = new inandout_info();
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
	public inandout_info() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("학생 등록");
		frame.setTitle("입실퇴실 정보");
		setVisible(true);
		frame.setSize(new Dimension(400, 520));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 360, 385);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(212, 405, 160, 70);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//inandout_main user = new inandout_main();
				//user.setVisible(true);
				frame.dispose();
			}
		});
		panel.setLayout(null);
		
		JCheckBox chckbxX = new JCheckBox("X");
		chckbxX.setBounds(230, 285, 44, 23);
		panel.add(chckbxX);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("O");
		chckbxNewCheckBox.setBounds(160, 285, 44, 23);
		panel.add(chckbxNewCheckBox);

        ButtonGroup group = new ButtonGroup();
        group.add(chckbxNewCheckBox);
        group.add(chckbxX);

        panel.add(chckbxNewCheckBox);
        panel.add(chckbxX);
		
		JLabel lblNewLabel = new JLabel("학번: ");
		lblNewLabel.setBounds(85, 69, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름: ");
		lblNewLabel_1.setBounds(85, 111, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("성별: ");
		lblNewLabel_2.setBounds(85, 157, 57, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("학과: ");
		lblNewLabel_3.setBounds(85, 202, 57, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("호실: ");
		lblNewLabel_4.setBounds(85, 245, 57, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("입실퇴실여부: ");
		lblNewLabel_5.setBounds(62, 289, 86, 15);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(158, 66, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 108, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 154, 116, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(158, 199, 116, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(158, 242, 116, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(12, 405, 160, 70);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//inandout_main user = new inandout_main();
				//user.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 0, 360, 385);
		panel.add(progressBar);
		setLocationRelativeTo(null);
		
	}

	private void setLocationRelativeTo(Object object) {
		// TODO Auto-generated method stub
		
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
