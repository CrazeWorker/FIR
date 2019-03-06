package imp;

import dao.UserDao;
import util.DBUtil;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImp implements UserDao {

    @Override
    public boolean login(String username,String password) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select password from users where username = '" + username + "'";
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs.next()) {
                return password.equals(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addUser(String username, String password, String name) {
        username = username.trim();
        password = password.trim();
        name = name.trim();
        if (username == null || username.equals("")||password == null || password.equals(name)) {
            return false;
        }
        DBUtil db = DBUtil.getDBUtil();
        String sql = "insert into users values('"+username+"','"+password+"','"+name+"');";
        int i = db.executeUpdate(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getUserName(String username) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from users where username = '" + username + "'";
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean isSame(String password,String repass) {
        return password.equals(repass);
    }

    @Override
    public boolean changePassword(String password,String newPassword,String username) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select password from users where username = '" + username + "'";
        String sql2 = "update users set password='"+newPassword+"' where username='"+username+"'";
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs.next()) {
                String password1 = rs.getString("password");
                if (password1.equals(password)) {
                    if (db.executeUpdate(sql2)>0) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
