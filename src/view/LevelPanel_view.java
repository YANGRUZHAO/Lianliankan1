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
import javax.swing.JTextField;
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
	
	private JTextField textField;
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
		setBounds(100, 100, 700,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
 
		JLabel label = new JLabel("历史最快过关排行榜");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);
		JPanel panel = new JPanel(); //返回
		contentPane.add(panel, BorderLayout.SOUTH);
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gotoChoice();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(button, BorderLayout.SOUTH);

		// 准备表格的标题和数据
		title = new Object[] { "玩家", "最快速度" };
		
		
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
		
		JButton btnNewButton = new JButton("\u5220\u9664\u6211\u7684\u8D26\u53F7\u6392\u884C\u699C\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				until.Leaderboard.deleteAccountRank(account);

				new LevelPanel_view(account).setVisible(true);
				(LevelPanel_view.this).dispose();

			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(500, 500, 138, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton1 = new JButton("修改该账号得分：");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 删除玩家的所有通关得分记录
				String score = textField.getText();
				until.Leaderboard.updateAccountScore(account,Integer.valueOf(score));

				new LevelPanel_view(account).setVisible(true);
				(LevelPanel_view.this).dispose();
			}
		});
		btnNewButton1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton1);
		
		
	}

	/**
	 * 返回关卡选择
	 */
	private void gotoChoice() {
		this.dispose(); // 释放资源
		new FirstFrame(0,this.currentAccount).setVisible(true);
		
	}
}