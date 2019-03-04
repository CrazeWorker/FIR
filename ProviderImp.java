package imp;

import bean.Bill;
import bean.Provider;
import dao.BillDao;
import dao.ProviderDao;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProviderImp implements ProviderDao {

    @Override
    public ArrayList<Provider> getAll() {
        ArrayList<Provider> arr = new ArrayList<>();
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from providers";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setProId(rs.getString("proId"));
                provider.setProName(rs.getString("proName"));
                provider.setContacts(rs.getString("contacts"));
                provider.setPhone(rs.getString("phone"));
                provider.setFax(rs.getString("fax"));
                provider.setCreateDate(rs.getString("createDate"));
                arr.add(provider);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Provider> getLikes(String proName) {
        ArrayList<Provider> arr = new ArrayList<>();
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from providers where proName like '%"+proName+"%';";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setProId(rs.getString("proId"));
                provider.setProName(rs.getString("proName"));
                provider.setContacts(rs.getString("contacts"));
                provider.setPhone(rs.getString("phone"));
                provider.setFax(rs.getString("fax"));
                provider.setCreateDate(rs.getString("createDate"));
                arr.add(provider);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addProvider(Provider provider) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "insert into providers values(?,?,?,?,?,?);";
        PreparedStatement ps = db.getPs(sql);
        try {
            ps.setString(1,provider.getProId());
            ps.setString(2,provider.getProName());
            ps.setString(3, provider.getContacts());
            ps.setString(4,provider.getPhone());
            ps.setString(5,provider.getFax());
            ps.setString(6,provider.getCreateDate());
            if (ps.executeUpdate()>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProvider(Provider provider) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "Update providers set proName='"+provider.getProName()+"',contacts='"+provider.getContacts()+"',phone='"+provider.getPhone()+"',fax='"+provider.getFax()+"' where proId='"+provider.getProId()+"'";
        if (db.executeUpdate(sql) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProvider(String proId) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "delete from providers where proId = '" + proId+"'";
        if (db.executeUpdate(sql)>0) {
            return true;
        }
        return false;
    }
}
