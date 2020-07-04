package dao;

import test.Player;
/**
 * 该类为玩家的一个简单操作接口
 * @author YLove
 * @version V1.0
 */
public interface PlayerDao {
	/**
	 * 用户登录功能
	 * 
	 * @param account
	 *            用户名
	 * @param password
	 *            密码
	 * @return 登录是否成功，成功返回true，否则返回false
	 */

	public abstract boolean login(String account, String password);

	/**
	 * 用户注册功能
	 * 
	 * @param p 被注册的用户信息
	 * @return 注册成功返回ture，否则返回false
	 */
	public abstract boolean register(Player p);
}

