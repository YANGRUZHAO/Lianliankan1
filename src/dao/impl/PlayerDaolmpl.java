package dao.impl;

import dao.PlayerDao;
import test.Player;
/**
 * ����Ϊ��ҵĲ����ӿ�ʵ��
 * @author YLove
 * @version V1.0
 */
public class PlayerDaolmpl implements PlayerDao{

	/**
	 * �û���¼����
	 * 
	 * @param account
	 *            �û���
	 * @param password
	 *            ����
	 * @return ��¼�Ƿ�ɹ����ɹ�����true�����򷵻�false
	 */
	public boolean login(String account, String password) {
		return new DataBaseDaolmpl().query(account, password);
	}

	/**
	 * �û�ע�Ṧ��
	 * 
	 * @param p ��ע����û���Ϣ
	 * @return ע��ɹ�����ture�����򷵻�false
	 */
	public boolean register(Player p) {
		return new DataBaseDaolmpl().insert(p);
	}
	
}
