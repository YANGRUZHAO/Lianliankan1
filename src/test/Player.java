package test;

/**
 * ����Ϊ�����Ϣ��
 * @author YLove
 * @version V1.0
 */
public class Player {
	/**
	 * �˺�
	 */
	private String account;

	/**
	 *  ����
	 */
	private String password;

	/**
	 * �÷�
	 */
	private int score;
    /**
     * �����Ϣ�๹�췽��
     * @param name �˺�
     * @param password ����
     */
	public Player(String name, String password) {
		this.account = name;
		this.password = password;
	}
    /**
     * ��ȡ����ҵ�account
     * @return ���ظ���ҵ��˺�
     */
	public String getAccount() {
		return account;
	}
    /**
     * ��������˺Ÿ�ֵ
     * @param name �˺�ֵ
     */
	public void setAccount(String name) {
		this.account = name;
	}
    /**
     * �õ�����ҵ�����
     * @return ���ظ���ҵ�����
     */
	public String getPassword() {
		return password;
	}
    /**
     * ������ҵ����븳ֵ
     * @param password ���ظ���ҵ�����
     */
	public void setPassword(String password) {
		this.password = password;
	}
}
