package until;

/**
 * ����Ϊ����ı������Ƿ����ı�
 * @author YLove
 * @version V1.0
 */
public class ScannerUtil {
    /**
     * ����Ϊ����ı������Ƿ����ı�
     * @param s ����ı�
     * @return ���Ϊ�շ���false������true
     */
	public static boolean inputCheck(String s) {
		if(s == null)
			return false;
		return s.matches("\\w{6,15}");
	}
}
