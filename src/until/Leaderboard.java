package until;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import java.io.IOException;

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
	private static ArrayList<String> dataArray;
	private static final String highestfile = "D:\\All_Code\\Java\\Lianliankan1\\Leaderboard.txt";
	
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
	          File file = new File("D:\\All_Code\\Java\\Lianliankan1\\Leaderboard.txt");
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
	
	/**
	 * 删除account账号的文件中的记录
	 * 
	 * @param account
	 *            要删除的account
	 */
	public static void deleteAccountRank(String account) {
		if (account == null)
			return;

		dataArray = new ArrayList<String>();// 初始化缓存list

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			// 读取文件
			br = new BufferedReader(new FileReader(highestfile));
			String line = null;
			while ((line = br.readLine()) != null) {
				// 比对文件中的账号信息
				if (!(line.split(" ")[0].equals(account))) {
					dataArray.add(line);
				}
			}

			// 写入文件
			bw = new BufferedWriter(new FileWriter(highestfile));

			int k = 1; // 刷新标记

			for (String s : dataArray) {// 遍历ArrayList集合写入
				bw.write(s);
				bw.newLine();
				if (k % 200 == 0) // 写入200行刷新一次
					bw.flush();
				k++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				// 释放资源
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 更新文件中account账号的分数
	 * 
	 * @param account
	 *            要修改的账号
	 * 
	 * @param score
	 *            要修改的分数
	 */
	public static void updateAccountScore(String account,int score) {
		if (account == null)
			return;
		
		dataArray = new ArrayList<String>(); // 初始化缓存list

		BufferedReader br = null;
		BufferedWriter bw = null;

		int k = 1; // 刷新标记

		try {
			// 读入数据行
			br = new BufferedReader(new FileReader(highestfile));
			String line = null;
			while ((line = br.readLine()) != null) {

				// 是第pass关 并且 是account账号的数据行就修改
				if  ((line.split(" ")[0].equals(account)))  {

					dataArray.add(line.split(" ")[0] + " " + score);

				} else { // 不是直接添加
					dataArray.add(line);
				}
			}

			// 写入数据
			bw = new BufferedWriter(new FileWriter(highestfile));
			for (String s : dataArray) {
				bw.write(s);
				bw.newLine();
				if (k % 1000 == 0) // 1000行刷新一次
					bw.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
