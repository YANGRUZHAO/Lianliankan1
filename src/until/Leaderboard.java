package until;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * ����Ϊ���ļ��ж�ȡд���û��Ĺ�����Ϣ
 * @author YLove
 * @version V1.0
 */
public class Leaderboard {
	/**
	 * �÷���Ϊ���ļ��ж�ȡ��ҹ�����Ϣ
	 * @return ����������ҹ�����Ϣ
	 */
	public static  List  Read_List() {
		String[] Str = new String[11];
		Map<String, Integer> map1 = new TreeMap<String,Integer>();;
		String name = "";
        long score = 0;
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
           String record;
           int index;
           File file = new File("D:\\All_Code\\Java\\Lianliankan1\\Leaderboard.txt");
           RandomAccessFile raf = new RandomAccessFile(file,"rw");
           while(raf.getFilePointer() < raf.length()) {
           	record = raf.readLine();
           	index = record.indexOf(" ");
           	name = record.substring(0,index);
           	String str = record.substring(index+1, record.length());
           	System.out.println("str :" + str);
           	score = Long.parseLong(str);
           	int s = (int)score;
           	Integer wrapperi = new Integer(s);  
           	map1.put(name, wrapperi);
           	//System.out.println("name����ʾ��" + name + "  score  " + score);
           }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//���ｫmap.entrySet()ת����list
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map1.entrySet());
        //Ȼ��ͨ���Ƚ�����ʵ������
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //��������
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });
	    return list;

	}
    /**
     * �÷���Ϊ���ļ���д����ҹ�����Ϣ
     * @param name  ����˺�
     * @param score ���ط���
     */
	public static void Add_List(String name,int score) {
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
	          File file = new File("D:\\All_Code\\Java\\Lianliankan\\Leaderboard.txt");
	          RandomAccessFile raf = new RandomAccessFile(file,"rw");
	          String record = name + " " + String.valueOf(score);
	          raf.seek(raf.length());
	          raf.writeBytes(record);
	          raf.writeBytes(System.lineSeparator());
	          raf.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void Delete_List(String name,int score) {
		
	}
}
