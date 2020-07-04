package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DataBaseDao;
import test.Player;
/**
 * 该类为简单的数据库操作实现
 * @author YLove
 * @version V1.0
 */
public class DataBaseDaolmpl implements DataBaseDao {
	/**
	 * 数据库连接对象
	 */
	private Connection conn = null;
	/**
	 * 数据库操作对象
	 */
	private PreparedStatement pstate = null;
    /**
     * 构造方法
     */
	public DataBaseDaolmpl() {
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动加载失败！");
		}

		try {
			conn = DriverManager.getConnection(URL, DBUSER, DBPASSWORd);
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败！");
		}
	}

	/**
	 *  查询账号密码是否正确
	 *  @param account 账号
	 *  @param password 密码
	 *  @return 登录是否成功，成功返回true，否则返回false
	 */
	public boolean query(String account, String password) {
		if (conn == null)
			return false;
		if (account == null)
			return false;
		if (password == null)
			return false;
		// 定义SQL语句
		String sql = "select password from player where account=?;";

		ResultSet rs = null;

		boolean flag = false;

		try {
			// 预编译SQL语句
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, account);
			// 执行SQL语句
			rs = pstate.executeQuery();
			while (rs.next()) {
				// 比对账号密码是否正确
				if (rs.getString(1).equals(password)) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("数据库查询异常！");
		} finally {
			// 释放数据库资源
			if (pstate != null)
				try {
					pstate.close();
					conn.close();
				} catch (SQLException e) {
					System.out.println("释放数据库资源异常");
				}
			return flag;
		}
	}


	/**
	 * 用户注册功能
	 * 
	 * @param p 被注册的用户信息
	 * @return 注册成功返回ture，否则返回false
	 */
	public boolean insert(Player p) {
		if (conn == null)
			return false;
		// 定义SQL语句
		String sql = "insert into player(account,password) values(?,?);";
		

		try {
			// 对player表插入账号密码
			// 预编译SQL语句
			pstate = conn.prepareStatement(sql);
			// 设置插入值
			pstate.setString(1, p.getAccount());
			pstate.setString(2, p.getPassword());
			// 执行SQL更新操作
			pstate.executeUpdate();
		} catch (SQLException e) {
			System.out.println("数据库插入失败！");
			return false;
		} finally {
			if (pstate != null)
				try {
					// 释放数据库资源
					pstate.close();
					conn.close();
				} catch (SQLException e) {
					System.out.println("数据操作关闭失败！");
				}
		}
		return true;
	}

}
