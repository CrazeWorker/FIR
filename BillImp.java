package imp;

import bean.Bill;
import dao.BillDao;
import util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillImp implements BillDao {
    @Override
    public ArrayList<Bill> getAll() {
        ArrayList<Bill> arr = new ArrayList<>();
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from bills";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillNum(rs.getInt("billNum"));
                bill.setGoodsName(rs.getString("goodsName"));
                bill.setProvider(rs.getString("provider"));
                bill.setMoney(rs.getDouble("money"));
                bill.setIsPaid(rs.getString("isPaid"));
                bill.setCreateDate(rs.getString("createDate"));
                arr.add(bill);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Bill> getLikes(String goodsName , String provider , String isPaid) {
        DBUtil db = DBUtil.getDBUtil();
        if (goodsName == null) {
            goodsName = "";
        }
        if (provider.equals("--请选择--")) {
            provider = "";
        }
        if (isPaid.equals("--请选择--")) {
            isPaid = "";
        }
        String sql = "select * from bills where goodsName like '%" + goodsName + "%' and provider like '%"+provider+"%' and provider like '%"+isPaid+"%'";
        ResultSet rs = db.executeQuery(sql);
        ArrayList<Bill> arr = new ArrayList<>();
        try {
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillNum(rs.getInt("billNum"));
                bill.setGoodsName(rs.getString("goodsName"));
                bill.setProvider(rs.getString("provider"));
                bill.setMoney(rs.getDouble("money"));
                bill.setIsPaid(rs.getString("isPaid"));
                bill.setCreateDate(rs.getString("createDate"));
                arr.add(bill);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBill(Bill bill) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "insert into bills values(?,?,?,?,?,?);";
        PreparedStatement ps = db.getPs(sql);
        try {
            ps.setInt(1,bill.getBillNum());
            ps.setString(2,bill.getGoodsName());
            ps.setString(3, bill.getProvider());
            ps.setDouble(4,bill.getMoney());
            ps.setString(5,bill.getIsPaid());
            ps.setString(6,bill.getCreateDate());
            if (ps.executeUpdate()>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public boolean updateBill(Bill bill) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "Update bills set goodsName='"+bill.getGoodsName()+"',provider='"+bill.getProvider()+"',money="+bill.getMoney()+",isPaid='"+bill.getIsPaid()+"'"+" where billNum="+bill.getBillNum();
        if (db.executeUpdate(sql) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBill(int id) {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "delete from bills where billNum = " + id;
        if (db.executeUpdate(sql)>0) {
            return true;
        }
        return false;
    }
}
