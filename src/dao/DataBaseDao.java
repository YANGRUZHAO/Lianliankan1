package dao;

import test.Player;
/**
 * ����Ϊ�򵥵����ݿ�����ӿ�
 * @author YLove
 * @version V1.0
 */
public interface DataBaseDao {

	/**
	 * ���ݿ�����
	 */
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";

	/**
	 * ���ӵ�ַ
	 */
	public static final String URL = "jdbc:mysql://localhost:3306/lian?serverTimezone=UTC&characterEncoding=utf8";

	/**
	 * ���ݿ��û�
	 */
	public static final String DBUSER = "root";

	/**
	 * ���ݿ��û�����
	 */
	public static final String DBPASSWORd = "123456";
	
    /**
     * ��ѯ�˺������Ƿ���ȷ����ȷ����true������false
     * 
     * @param account  ��ѯ���˺�
     * @param password �˺ŵ�����
     * @return �˺�������ȷ����true������false
     */
	public abstract boolean query(String account, String password);

    /**
     * �����ݿ����һ�������Ϣ
     * @param p  ��ӵ������Ϣ
     * @return  ��ӳɹ�����true������false
     */
	public abstract boolean insert(Player p);
	
	/**
	 * �����ݿ�ɾ��һ�������Ϣ
	 * @param p ɾ���������Ϣ
	 * @return ɾ���ɹ�����true������false
	 */
	public abstract boolean delete(Player p);
	
	public boolean update(String account, String password);
}
