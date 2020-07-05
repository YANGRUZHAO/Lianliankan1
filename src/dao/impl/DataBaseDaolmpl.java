package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import dao.DataBaseDao;
import test.Player;
/**
 * ����Ϊ�򵥵����ݿ����ʵ��
 * @author YLove
 * @version V1.0
 */
public class DataBaseDaolmpl implements DataBaseDao {
	/**
	 * ���ݿ����Ӷ���
	 */
	private Connection conn = null;
	/**
	 * ���ݿ��������
	 */
	private PreparedStatement pstate = null;
    /**
     * ���췽��
     */
	public DataBaseDaolmpl() {
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ���������ʧ�ܣ�");
		}

		try {
			conn = DriverManager.getConnection(URL, DBUSER, DBPASSWORd);
		} catch (SQLException e) {
			System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
		}
	}

	/**
	 *  ��ѯ�˺������Ƿ���ȷ
	 *  @param account �˺�
	 *  @param password ����
	 *  @return ��¼�Ƿ�ɹ����ɹ�����true�����򷵻�false
	 */
	public boolean query(String account, String password) {
		if (conn == null)
			return false;
		if (account == null)
			return false;
		if (password == null)
			return false;
		// ����SQL���
		String sql = "select password from player where account=?;";

		ResultSet rs = null;

		boolean flag = false;

		try {
			// Ԥ����SQL���
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, account);
			// ִ��SQL���
			rs = pstate.executeQuery();
			while (rs.next()) {
				// �ȶ��˺������Ƿ���ȷ
				if (rs.getString(1).equals(password)) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("���ݿ��ѯ�쳣��");
		} finally {
			// �ͷ����ݿ���Դ
			if (pstate != null)
				try {
					pstate.close();
					conn.close();
				} catch (SQLException e) {
					System.out.println("�ͷ����ݿ���Դ�쳣");
				}
			return flag;
		}
	}


	/**
	 * �û�ע�Ṧ��
	 * 
	 * @param p ��ע����û���Ϣ
	 * @return ע��ɹ�����ture�����򷵻�false
	 */
	public boolean insert(Player p) {
		if (conn == null)
			return false;
		// ����SQL���
		String sql = "insert into player(account,password) values(?,?);";
		

		try {
			// ��player������˺�����
			// Ԥ����SQL���
			pstate = conn.prepareStatement(sql);
			// ���ò���ֵ
			pstate.setString(1, p.getAccount());
			pstate.setString(2, p.getPassword());
			// ִ��SQL���²���
			pstate.executeUpdate();
		} catch (SQLException e) {
			System.out.println("���ݿ����ʧ�ܣ�");
			return false;
		} finally {
			if (pstate != null)
				try {
					// �ͷ����ݿ���Դ
					pstate.close();
					conn.close();
				} catch (SQLException e) {
					System.out.println("���ݲ����ر�ʧ�ܣ�");
				}
		}
		return true;
	}
	
	public boolean delete(Player p) {
		String account = p.getAccount();
		String password = p.getPassword();
		if (conn == null)
			return false;
		if (account == null)
			return false;
		if (password == null)
			return false;
		// ����SQL���
		String sql="delete from player where account = ?";//����һ��sql���
		ResultSet rs = null;

		boolean flag = false;

		try {
			// Ԥ����SQL���
			pstate = conn.prepareStatement(sql);
			// ���ò���ֵ
			pstate.setString(1, p.getAccount());
			// ִ��SQL���²���
			pstate.executeUpdate();
			flag = true;
			
		} catch (SQLException e) {
			System.out.println("���ݿ��ѯ�쳣��");
		} finally {
			// �ͷ����ݿ���Դ
			if (pstate != null)
				try {
					pstate.close();
					conn.close();
				} catch (SQLException e) {
					System.out.println("�ͷ����ݿ���Դ�쳣");
				}
			return flag;
		}
	}
	// �������ݿ����û��˺�������
		@Override
		public boolean update(String account, String password) {
			if (conn == null)
				return false;

			// ����SQL���
			String sql = "update player set password=? where account=?;";

			try {
				// Ԥ����SQL���
				pstate = conn.prepareStatement(sql);
				// ������ֵ
				pstate.setString(1, password);
				pstate.setString(2, account);
				// ִ��SQL���
				pstate.executeUpdate();
			} catch (SQLException e) {
				System.out.println("���ݿ���²�������һ��С���⣡");
				return false;
			}
			return true;
		}
}
