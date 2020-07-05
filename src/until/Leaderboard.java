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
 * 此类为从文件中读取写入用户的过关信息
 * @author YLove
 * @version V1.0
 */
public class Leaderboard {
	/**
	 * 该方法为从文件中读取玩家过关信息
	 * @return 返回所有玩家过关信息
	 */
	public static  List  Read_List() {
		String[] Str = new String[11];
		Map<String, Integer> map1 = new TreeMap<String,Integer>();;
		String name = "";
        long score = 0;
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
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
           	//System.out.println("name的显示是" + name + "  score  " + score);
           }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//这里将map.entrySet()转换成list
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map1.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //升序排序
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });
	    return list;

	}
    /**
     * 该方法为向文件中写入玩家过关信息
     * @param name  玩家账号
     * @param score 过关分数
     */
	public static void Add_List(String name,int score) {
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
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
