package dao.impl;

import dao.PlayerDao;
import test.Player;
/**
 * 该类为玩家的操作接口实现
 * @author YLove
 * @version V1.0
 */
public class PlayerDaolmpl implements PlayerDao{

	/**
	 * 用户登录功能
	 * 
	 * @param account
	 *            用户名
	 * @param password
	 *            密码
	 * @return 登录是否成功，成功返回true，否则返回false
	 */
	public boolean login(String account, String password) {
		return new DataBaseDaolmpl().query(account, password);
	}

	/**
	 * 用户注册功能
	 * 
	 * @param p 被注册的用户信息
	 * @return 注册成功返回ture，否则返回false
	 */
	public boolean register(Player p) {
		return new DataBaseDaolmpl().insert(p);
	}
	
	public boolean delete(Player p) {
		return new DataBaseDaolmpl().delete(p);
	}
	
	public boolean update(Player p) {
		String account = p.getAccount();
		String password = p.getPassword();
		return new DataBaseDaolmpl().update(account,password);
	}
}
