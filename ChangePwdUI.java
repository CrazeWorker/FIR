package ToolBarUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import JDBC.DBUtil;
import UserUI.UserUI1;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChangePwdUI {

	private JFrame frame;
	private JPasswordField oldPwdTxt;
	private JPasswordField newPwdTxt;

	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePwdUI window = new ChangePwdUI();
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
	public ChangePwdUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocation(500, 300);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 61, 91, 36);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(10, 123, 91, 36);
		panel.add(label);
		
		oldPwdTxt = new JPasswordField();
		oldPwdTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		oldPwdTxt.setBounds(87, 61, 279, 36);
		panel.add(oldPwdTxt);
		
		newPwdTxt = new JPasswordField();
		newPwdTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		newPwdTxt.setBounds(87, 123, 279, 36);
		panel.add(newPwdTxt);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "select password from users where userName = '"+UserUI1.us.getUserName()+"'";
				DBUtil db = DBUtil.getDBUtil();
				ResultSet rs = db.executeQuery(sql);
				try {
					rs.next();
					if(rs.getString(1).equals(oldPwdTxt.getText())) {
						if(!newPwdTxt.getText().trim().equals("")) {
							String up = "update users set password = '"+newPwdTxt.getText().trim()
									+"' where userName = '"+UserUI1.us.getUserName()+"'";
							if(db.executeUpdate(up) > 0) {
								JOptionPane.showMessageDialog(null, "密码修改成功");
								frame.dispose();
							}else {
								JOptionPane.showMessageDialog(null, "密码修改失败，请重试");
							}
						}else {
							JOptionPane.showMessageDialog(null, "密码不得为空，请重新输入!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "旧密码输入错误!");
						oldPwdTxt.setText("");
						newPwdTxt.setText("");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(228, 204, 143, 36);
		panel.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(74, 204, 132, 36);
		panel.add(button_1);
	}
}
