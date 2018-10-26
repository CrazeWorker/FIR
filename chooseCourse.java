package JDBC;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import com.euronx.util.*;
import com.euronx.model.Subject;
import com.euronx.model.Teacher;
public class chooseCourse extends JPanel {
	private JTextField textField;
	final JList list_3 = new JList();
	final JList list_1 = new JList();
	/**
	 * Create the panel.
	 */
	public chooseCourse() {
		//设置布局为SpringLayout
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		//添加 提交按钮 并且修改其位置
		JButton button = new JButton("提交");
		springLayout.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, button, -30, SpringLayout.EAST, this);
		//提交按钮的时间响应函数
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBUtil til = DBUtil.getDBUtil();
				String sql = "Select qno from question where qname = "+"'"+list_3.getSelectedValue().toString()+"'";
				ResultSet rs = til.executeQuery(sql);
				String qno = null ;
				try {
					while(rs.next()){
						qno = rs.getString(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String sql3 = "Select sno from s_choose where sno = "+"'"+logInterface.s1.getId()+"'";
				ResultSet rs1 = til.executeQuery(sql3);
				try {
					if(!rs1.next()){
						String sql2 = "Select count from question where qname='"+list_3.getSelectedValue().toString()+"'";
						ResultSet rs2 = til.executeQuery(sql2);
						while(rs2.next()){
						if(rs2.getInt(1) < 4){
							String sql1 = "insert into s_choose(sno,qno,t_cname) values('"+logInterface.s1.getId()+"',"+"'"+qno+"',"+"'"+list_1.getSelectedValue().toString()+"')";
							int s = til.executeUpdate(sql1);
							JOptionPane.showMessageDialog(null,"提交成功");
							String sql4 = "Update question set count=count+1 where qname="+"'"+list_3.getSelectedValue().toString()+"'";
							int x1 = til.executeUpdate(sql4);
					}
					else
						JOptionPane.showMessageDialog(null,"此课程小组人数已满！");
						}
					try {
						chooseInformation.showInformaition1();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					else
						JOptionPane.showMessageDialog(null,"您已经选择了一门课设题目，无法再次选择");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(button);
		//添加 选择课题 的List列表框
		JList list = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list, 92, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, list, 68, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, list, 92, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, list, 142, SpringLayout.WEST, this);
		add(list);
		//选择学院的标签
		JLabel label = new JLabel("选择学院");
		springLayout.putConstraint(SpringLayout.SOUTH, label, -40, SpringLayout.NORTH, list);
		add(label);
		//可供选择的 学院下拉列表框
		final JComboBox comboBox = new JComboBox();
		//设置下拉列表框的布局
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 80, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -268, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, label, 3, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 31, SpringLayout.NORTH, this);
		//下拉列表框显示的 String数组
		String[] academy = new String[2];
		academy[0] = "计算机";
		academy[1] = "管理学院";
		//下拉列表显示
		comboBox.setModel(new DefaultComboBoxModel(academy));
		comboBox.setToolTipText("");
		add(comboBox);
		//两个list列表框的定义及其布局
		
		springLayout.putConstraint(SpringLayout.NORTH, list_1, 20, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.WEST, list_1, 0, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, list_1, -54, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, list_1, 0, SpringLayout.EAST, comboBox);
		
		springLayout.putConstraint(SpringLayout.WEST, list_3, 30, SpringLayout.EAST, list_1);
		springLayout.putConstraint(SpringLayout.EAST, list_3, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, list_3, -17, SpringLayout.NORTH, button);
		//选择教师显示课题的监听器
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				DBUtil til = DBUtil.getDBUtil();
				switch(comboBox.getSelectedIndex()){
				case 0:
					switch(list_1.getSelectedIndex()){
					case 0:					
						try {
							list_3.setModel(new AbstractListModel() {
								String[] values = SubjectDAO.getCourseName(list_1.getSelectedValue().toString());
								public int getSize() {
									return values.length;
								}
								public Object getElementAt(int index) {
									return values[index];
								}
							});
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 1:	
						try {
							list_3.setModel(new AbstractListModel() {
								String[] values = SubjectDAO.getCourseName(list_1.getSelectedValue().toString());
								public int getSize() {
									return values.length;
								}
								public Object getElementAt(int index) {
									return values[index];
								}
							});
						} catch (SQLException e5) {
							// TODO Auto-generated catch block
							e5.printStackTrace();
						}
						break;
					case 2:
						try {
							list_3.setModel(new AbstractListModel() {
								String[] values = SubjectDAO.getCourseName(list_1.getSelectedValue().toString());
								public int getSize() {
									return values.length;
								}
								public Object getElementAt(int index) {
									return values[index];
								}
								});
						} catch (SQLException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
						break;
					}
					break;
				case 1:
					switch(list_1.getSelectedIndex()){
					case 0:
						try {
							list_3.setModel(new AbstractListModel() {
								String[] values = SubjectDAO.getCourseName(list_1.getSelectedValue().toString());
								public int getSize() {
									return values.length;
								}
								public Object getElementAt(int index) {
									return values[index];
								}
							});
						} catch (SQLException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
						break;
					case 1:	
						try {
							list_3.setModel(new AbstractListModel() {
								String[] values = SubjectDAO.getCourseName(list_1.getSelectedValue().toString());
								public int getSize() {
									return values.length;
								}
								public Object getElementAt(int index) {
									return values[index];
								}
							});
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						break;
					case 2:
						try {
							list_3.setModel(new AbstractListModel() {
								String[] values = SubjectDAO.getCourseName(list_1.getSelectedValue().toString());
								public int getSize() {
									return values.length;
								}
								public Object getElementAt(int index) {
									return values[index];
								}
							});
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
				}
					break;
				}
				
			}
		});
		//选择学院显示教师的监听器
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(comboBox.getSelectedIndex()){
				case 0:
					try {
						list_1.setModel(new AbstractListModel() {
							String[] values = TeacherDAO.getTeacherName("计算机");
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
							});
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 1:
					try {
						list_1.setModel(new AbstractListModel() {
							String[] values = TeacherDAO.getTeacherName("管理学院");
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
							});
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		add(list_1);
		//设置 选择教师的标签 的位置
		JLabel label_1 = new JLabel("选择教师");
		springLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, label_1, 0, SpringLayout.SOUTH, list);
		add(label_1);
		add(list_3);
		//设置 选择课题标签 的位置
		JLabel label_2 = new JLabel("选择课题");
		springLayout.putConstraint(SpringLayout.NORTH, list_3, 16, SpringLayout.SOUTH, label_2);
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 30, SpringLayout.EAST, comboBox);
		add(label_2);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 16, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, textField, -104, SpringLayout.WEST, list_3);
		springLayout.putConstraint(SpringLayout.EAST, textField, -30, SpringLayout.WEST, list_3);
		add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u641C\u7D22");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final DBUtil til = DBUtil.getDBUtil();
				final String sql = "Select tname from Teacher where tname LIKE "+"'"+textField.getText()+"%'";
				try {
					final ResultSet rs = til.executeQuery(sql);
					while(rs.next()){
					list_1.setModel(new AbstractListModel() {					
					String[] values = new String[]{rs.getString(1)};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
					});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		springLayout.putConstraint(SpringLayout.NORTH, button_1, -4, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.EAST, button_1, -6, SpringLayout.WEST, textField);
		add(button_1);

	}
}
