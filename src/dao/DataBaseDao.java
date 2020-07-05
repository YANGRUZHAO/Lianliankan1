package dao;

import test.Player;
/**
 * 该类为简单的数据库操作接口
 * @author YLove
 * @version V1.0
 */
public interface DataBaseDao {

	/**
	 * 数据库驱动
	 */
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";

	/**
	 * 连接地址
	 */
	public static final String URL = "jdbc:mysql://localhost:3306/lian?serverTimezone=UTC&characterEncoding=utf8";

	/**
	 * 数据库用户
	 */
	public static final String DBUSER = "root";

	/**
	 * 数据库用户密码
	 */
	public static final String DBPASSWORd = "123456";
	
    /**
     * 查询账号密码是否正确；正确返回true，否则false
     * 
     * @param account  查询的账号
     * @param password 账号的密码
     * @return 账号密码正确返回true，否则false
     */
	public abstract boolean query(String account, String password);

    /**
     * 向数据库添加一个玩家信息
     * @param p  添加的玩家信息
     * @return  添加成功返回true，否则false
     */
	public abstract boolean insert(Player p);
	
	/**
	 * 向数据库删除一个玩家信息
	 * @param p 删除的玩家信息
	 * @return 删除成功返回true，否则false
	 */
	public abstract boolean delete(Player p);
	
	public boolean update(String account, String password);
}
