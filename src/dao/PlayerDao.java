package dao;

import test.Player;
/**
 * ����Ϊ��ҵ�һ���򵥲����ӿ�
 * @author YLove
 * @version V1.0
 */
public interface PlayerDao {
	/**
	 * �û���¼����
	 * 
	 * @param account
	 *            �û���
	 * @param password
	 *            ����
	 * @return ��¼�Ƿ�ɹ����ɹ�����true�����򷵻�false
	 */

	public abstract boolean login(String account, String password);

	/**
	 * �û�ע�Ṧ��
	 * 
	 * @param p ��ע����û���Ϣ
	 * @return ע��ɹ�����ture�����򷵻�false
	 */
	public abstract boolean register(Player p);
}

