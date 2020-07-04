package view;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import test.StartMain;
import until.Leaderboard;
/**
 * 该类为游戏时间结束后或者计时游戏过关的界面
 * @author YLove
 * @version V1.0
 */
public class ShowTimerOver {
	private JLabel sounds, about, pass_level;
	private JButton to_main, to_next, to_new;
	private JCheckBox jcb_1, jcb_2;
	private JTextArea jta;
	private int LEVEL;//关数
	private String account;
	/**
	 * 该类的构造方法，显示为游戏时间结束后或者计时游戏过关的界面
	 * @param f 窗体值
	 * @param s 显示语句
	 * @param account1  登录账号值
	 * @param time  时间
	 */
	public ShowTimerOver(final JFrame f, String s,String account1,long time) {
		System.out.println("这里是计时模式");
		f.setTitle("计时模式");
		f.setBounds(f.getBounds().x+125, f.getBounds().y+150, 700, 500);//设置对话框位置大小
		//恭喜过关标签
		this.account = account1;
		pass_level = new JLabel(s);
		pass_level.setFont(new Font("acefont-family", Font.BOLD, 20));
		pass_level.setBounds(190, 50, 500, 40);
		f.add(pass_level);
		
		//返回主菜单按钮
		to_main = new JButton("返回主菜单");
		to_main.setBounds(180, 600, 150, 40);
		f.add(to_main);
		if(time != -1) {
			int ttt = (int)time;
			Leaderboard.Add_List(account1,ttt);
		}
		
		to_main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = f.getLocation();
				f.dispose();
				/*StartMain.main(null);
				StartMain.e1.setLocation(p);*/
				////改动1
				StartMain.e1 = new FirstFrame(0,account);
				//监听关闭窗体按钮
			    StartMain.e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//设置可视
			    StartMain.e1.setVisible(true); 
				//设置不可拉伸
			    StartMain.e1.setResizable(false);
			    
			    
			}
		});
		
		//下一关按钮
		to_new = new JButton("重新开始");
		to_new.setBounds(337, 400, 150, 40);
		f.add(to_new);
		
		to_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = f.getLocation();
				f.dispose();
				GameFrame gameFrame;
				gameFrame = new GameFrame(8,-1,account);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
	}
}
