package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 该类为显示选择关卡界面
 * @author YLove
 * @version V1.0
 */
public class newLevel extends JFrame {

	private JPanel contentPane;
	private String thisAccount;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newLevel frame = new newLevel("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
    /**
     * 该类的构造方法，显示关卡页面
     * @param account 登录账号值
     */
	public newLevel(String account) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("第1关");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame; int t = 1-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
				
			}
		});
		btnNewButton.setBounds(10, 108, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("第2关");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 2-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_1.setBounds(140, 108, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("第3关");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 3-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_2.setBounds(272, 108, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("第4关");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 4-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_3.setBounds(409, 108, 97, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("第5关");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 5-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_4.setBounds(532, 108, 97, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("第6关");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 6-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_5.setBounds(10, 216, 97, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_1_1 = new JButton("第7关");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 7-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_1_1.setBounds(140, 216, 97, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("第8关");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 8-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_2_1.setBounds(272, 216, 97, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("第9关");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 9-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_3_1.setBounds(409, 216, 97, 23);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_4_1 = new JButton("第10关");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 10-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_4_1.setBounds(532, 216, 97, 23);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_6 = new JButton("第11关");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 11-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_6.setBounds(10, 313, 97, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_1_2 = new JButton("第12关");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 12-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_1_2.setBounds(140, 313, 97, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_2 = new JButton("第13关");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 13-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_2_2.setBounds(272, 313, 97, 23);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_3_2 = new JButton("第14关");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 14-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_3_2.setBounds(409, 313, 97, 23);
		contentPane.add(btnNewButton_3_2);
		
		JButton btnNewButton_4_2 = new JButton("第15关");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame gameFrame;int t = 15-1;
				dispose();
				gameFrame = new GameFrame(t>2?8:(int) Math.pow(2, t+1),t+1,thisAccount);
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				//设置不可拉伸
				gameFrame.setResizable(false);
			}
		});
		btnNewButton_4_2.setBounds(532, 313, 97, 23);
		contentPane.add(btnNewButton_4_2);
		
		JButton btnNewButton_8 = new JButton("返回主界面");
		btnNewButton_8.setBackground(Color.ORANGE);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FirstFrame(0,account).setVisible(true);
			}
		});
		btnNewButton_8.setBounds(10, 10, 123, 50);
		contentPane.add(btnNewButton_8);

	
	}
}
