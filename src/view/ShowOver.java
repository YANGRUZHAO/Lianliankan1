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

/**
 * 该类为游戏结束后的恭喜过关界面
 * @author YLove
 * @version V1.0
 */
public class ShowOver {
	private JLabel sounds, about, pass_level;
	private JButton to_main, to_next, to_new;
	private JCheckBox jcb_1, jcb_2;
	private JTextArea jta;
	private int LEVEL;//关数
	private String account;
    /**
     * 该类为游戏结束后的恭喜过关界面
     * @param f 窗体值
     * @param account1  显示语句
     * @param t 第几关
     */
	public ShowOver(final JFrame f,String account1,int t) {
		f.setTitle("过关");
		this.LEVEL = t;
		f.setBounds(f.getBounds().x+125, f.getBounds().y+150, 400, 200);//设置对话框位置大小
		this.account = account1;
		//恭喜过关标签
		pass_level = new JLabel("恭喜过关");
		pass_level.setFont(new Font("acefont-family", Font.BOLD, 40));
		pass_level.setBounds(110, 30, 200, 40);
		f.add(pass_level);
		
		//返回主菜单按钮
		to_main = new JButton("返回主菜单");
		to_main.setBounds(50, 120, 100, 30);
		f.add(to_main);
		
		to_main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = f.getLocation();
				f.dispose();
				/*
				StartMain.main(null);
				StartMain.e1.setLocation(p);*/
				
				///改动3
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
		to_next = new JButton("下一关");
		to_next.setBounds(250, 120, 100, 30);
		if(LEVEL == 15)
			to_next.setEnabled(false);
		f.add(to_next);
		
		to_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = f.getLocation();
				f.dispose();
				GameFrame gameFrame;
				System.out.println("ShowOver LEVEl" + LEVEL);
				gameFrame = new GameFrame(LEVEL>2?8:(int) Math.pow(2, LEVEL+1),LEVEL+1,account);
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
