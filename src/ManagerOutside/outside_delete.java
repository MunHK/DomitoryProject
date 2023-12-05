
package ManagerOutside;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Color;

public class outside_delete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					outside_delete frame = new outside_delete();
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
	public outside_delete() {
		setTitle("외박정보 삭제");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 243, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("삭제하시겠습니까?");
		lblNewLabel.setBounds(68, 40, 124, 15);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showConfirmationDialog("삭제되었습니다.");
	    		dispose();
			}
		});
		btnNewButton.setBounds(35, 86, 69, 23);
		panel.add(btnNewButton);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		dispose();
			}
		});
		btnNo.setBounds(138, 86, 69, 23);
		panel.add(btnNo);
		
		setLocationRelativeTo(null);
	}
	private void showConfirmationDialog(String message) {
	    JOptionPane.showMessageDialog(null, message, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
}
