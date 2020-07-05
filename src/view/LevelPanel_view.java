package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//import util.HighestScoreUtil;
//import util.JFrameToolUtil;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import until.Leaderboard;
/**
 * 查看排行榜
 * 
 * @author 阳汝昭
 * @version V1.0
 */
public class LevelPanel_view extends JFrame {

	private JPanel contentPane;

	// 当前玩家账号
	private String currentAccount;
	// 表格标题
	private Object title[];
	// 表格数据
	private Object data[][]=new Object[6][2];
	/**
	 * 显示排行榜及其各种信息
	 * @param account 登录中的玩家账号
	 */
	public LevelPanel_view(String account) {
		// 设置当前玩家账号
		this.currentAccount = account;
        
		setResizable(false);
	//	setIconImage(Toolkit.getDefaultToolkit().getImage(HighestScoreJFrame.class.getResource("/images/apple.png")));
		setTitle("历史最快");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
 
		JLabel label = new JLabel("历史最快过关排行榜");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);

		JButton button = new JButton("\u8FD4  \u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gotoChoice();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(button, BorderLayout.SOUTH);

		// 准备表格的标题和数据
		title = new Object[] { "玩家", "最快速度" };
		
		
		//String[] str = new String[11];
		List<Map.Entry<String,Integer>> list = Leaderboard.Read_List();
        int i = 0;
        for(Map.Entry<String,Integer> mapping:list){ 
            System.out.println(mapping.getKey()+":"+mapping.getValue()); 
           data[i][0]=mapping.getKey();
           data[i++][1] = mapping.getValue();
            
       }
		
		
        
		// 获取表格的data数据
	//	HighestScoreUtil.getHighestScore(data);
				
		JTable jtable = new JTable(data, title);
		jtable.setFont(new Font("宋体", Font.BOLD, 20));
		jtable.setRowHeight(30);

		// 将表格添加到容器中
		contentPane.add(new JScrollPane(jtable), BorderLayout.CENTER);

		// 不可更改窗体大小
		this.setResizable(false);

		// 设置窗体居中
	//	this.setLocation(JFrameToolUtil.centerLocation(new Point(this.getWidth(), this.getHeight())));
	}

	/**
	 * 返回关卡选择
	 */
	private void gotoChoice() {
		this.dispose(); // 释放资源
		new FirstFrame(0,this.currentAccount).setVisible(true);
		
	}
}