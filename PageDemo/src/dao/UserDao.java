package dao;

public interface UserDao {
    // 登陆验证
    boolean login(String username, String password);
    // 添加用户信息
    boolean addUser(String username, String password, String uname);

    // 查询用户名
    boolean getUserName(String username);

    // 验证重复密码是否一致
    boolean isSame(String password, String repass);

    // 修改密码
    boolean changePassword(String password, String newPassword, String username);
}
