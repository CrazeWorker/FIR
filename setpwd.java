package JDBC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class setpwd extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setpwd frame = new setpwd();
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
	public setpwd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		label.setBounds(48, 59, 86, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801\uFF1A");
		label_1.setBounds(48, 95, 105, 15);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 56, 135, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(129, 92, 135, 21);
		contentPane.add(passwordField_1);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getPassword().length==0){
					JOptionPane.showMessageDialog(null, "密码不能为空，请重新输入");
				}else if(passwordField.getText().equals(passwordField_1.getText()))
				{
					boolean up1 = logInterface.tdao.updatePassWord(logInterface.t1.getId(), passwordField.getText());
					JOptionPane.showMessageDialog(null, "密码修改成功！");
				}else{
					JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入！");
				}
			}
		});
		button.setBounds(148, 159, 93, 23);
		contentPane.add(button);
	}
}
