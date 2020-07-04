package until;

/**
 * 该类为检查文本框中是否有文本
 * @author YLove
 * @version V1.0
 */
public class ScannerUtil {
    /**
     * 该类为检查文本框中是否有文本
     * @param s 检查文本
     * @return 如果为空返回false，否则true
     */
	public static boolean inputCheck(String s) {
		if(s == null)
			return false;
		return s.matches("\\w{6,15}");
	}
}
