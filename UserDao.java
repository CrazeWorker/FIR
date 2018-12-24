package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Test;

import JDBC.DBUtil;
import Roles.User;
import UserUI.UserUI1;

public class UserDao {
	
	// ����friendsUsername��ѯ����
	public ArrayList<User> searchByFriends(String friendsId) {
		DBUtil db = DBUtil.getDBUtil();
		ArrayList<User> friends = new ArrayList<>();
		if(friendsId == null || "".equals(friendsId)) {
			return null;
		}
		String[] s = friendsId.split(",");
		User user = null;
		ResultSet rs;
		for (String string : s) {
			String sql = "Select * from Users where username ='"+string+"'";
			rs = db.executeQuery(sql);
			try {
				rs.next();
				user = new User(rs.getInt(2),rs.getString(4));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			friends.add(user);
		}
		return friends;
	}

	// �����û��������ѯ����
	public User searchUser(String userName,String password) {
		DBUtil db = DBUtil.getDBUtil();
		User user = null;
		String sql = "select * from Users where username='"+userName+"' and password = '"+password+"'";
		ResultSet rs = db.executeQuery(sql);
		try {
			rs.next();
			user = new User(rs.getInt(2),rs.getString(4),searchByFriends(rs.getString(5)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	// �����û������Ҷ���
	public User searchFriend(String userName) {
		DBUtil db = DBUtil.getDBUtil();
		User user = null;
		String sql = "select * from Users where username='"+userName+"'";
		ResultSet rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				user = new User(rs.getInt(2),rs.getString(4),searchByFriends(rs.getString(5)));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	// ��Ӻ���
	public boolean addFriend(String userName) {
		DBUtil db = DBUtil.getDBUtil();
		String sql = "select friends from users where userName = '"+UserUI1.us.getId()+"'";
		ResultSet rs = db.executeQuery(sql);
		String friends = null;
		if(rs!=null) {
			try {
				rs.next();
				friends = rs.getString(1);
				if(friends == null || friends.equals("")) {
					friends = userName;
				}else {
					String[] f = friends.split(",");
					for (String string : f) {
						if(string.equals(userName)) {
							JOptionPane.showMessageDialog(null, "�Ѿ�����˴˺��ѣ������ظ���ӣ�");
							return false;
						}
					}
					friends += ","+userName; 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String up = "update users set friends = '"+friends+"' where userName = '"+UserUI1.us.getId()+"'";
		db.executeUpdate(up);
		return true;
	}
}
