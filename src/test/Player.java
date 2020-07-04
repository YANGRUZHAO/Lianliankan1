package test;

/**
 * 该类为玩家信息类
 * @author YLove
 * @version V1.0
 */
public class Player {
	/**
	 * 账号
	 */
	private String account;

	/**
	 *  密码
	 */
	private String password;

	/**
	 * 得分
	 */
	private int score;
    /**
     * 玩家信息类构造方法
     * @param name 账号
     * @param password 密码
     */
	public Player(String name, String password) {
		this.account = name;
		this.password = password;
	}
    /**
     * 获取该玩家的account
     * @return 返回该玩家的账号
     */
	public String getAccount() {
		return account;
	}
    /**
     * 给该玩家账号赋值
     * @param name 账号值
     */
	public void setAccount(String name) {
		this.account = name;
	}
    /**
     * 得到该玩家的密码
     * @return 返回该玩家的密码
     */
	public String getPassword() {
		return password;
	}
    /**
     * 给该玩家的密码赋值
     * @param password 返回该玩家的密码
     */
	public void setPassword(String password) {
		this.password = password;
	}
}
