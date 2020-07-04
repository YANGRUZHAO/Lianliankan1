package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import test.StartMain;

/**
 * 这是主界面
 * @author 阳汝昭
 * @version V1.0
 */
@SuppressWarnings("serial")
public class FirstFrame extends JFrame {
	
	private JLabel back;//背景
//	private JLabel label01, label02, label03, label04, label05, label06;
	private JButton button01, button02, button03,button05;
	private FirstFrame f;
	private String account;
	
	JPanel contentPane = new JPanel();
	/**
	 * 该类的构造方法
	 * @param i  标记值
	 * @param account  账号值
	 */
	public FirstFrame(int i,String account) {
		super("动物连连看");
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//设置java图标
		System.out.println("进入FirstFrame了");
		this.account = account;
		setIconImage(Toolkit.getDefaultToolkit ().getImage(getClass().getResource("/images/icon.png")));
		setSize(650, 500);//设置窗体大小
		setLayout(null);//清除布局管理器
		showBackground();//设置背景//设置背景
		
		showButton();//显示界面
		adapter();//监听
		f = this;
	}
	
	/**
	 * 监听页面按钮
	 */
	private void adapter() {
		// TODO Auto-generated method stub
		
		button01.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				toLevel(0,account);
				
			}
		});
		
		button02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();// 释放当前窗体的资源 
				System.out.println("进入计时模式");
				//Point p = StartMain.e1.getLocation();
				
				//StartMain.e1.dispose();
				System.out.println("开始计时模式的gameFrame");
				GameFrame gameFrame;
				gameFrame = new GameFrame(8,-1,account);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				//gameFrame.setLocation(p);
			}
		});
		
		button03.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new Dialog(f,0,0,null);
				//dispose();// 释放当前窗体的资源 
				System.out.println("进入设置");
				new ShowSetting(f).setVisible(true);;
			}
		});
		
        button05.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new Dialog(f,0,0,null);
				dispose();// 释放当前窗体的资源 
				System.out.println("进入设置");
				new LevelPanel_view(account).setVisible(true);;
			}
		});
		
	}
	/**
	 * 跳转到闯关页面
	 * @param id  标记值
	 * @param account 账号名称
	 */
	public void toLevel(int id,String account) {
		Point p = this.getLocation();
		//this.dispose();
	//	StartMain.e1.dispose();
		dispose();// 释放当前窗体的资源 
		System.out.println("开始LevePanle");
		new newLevel(account).setVisible(true);;
		
	}
	/**
	 * 显示界面	
	 */
	private void showButton() {
		// TODO Auto-generated method stub
		
		//设置按钮
		button01 = new JButton("经典模式");
		button01.setFont(new Font("acefont-family", Font.BOLD, 25));
		button01.setBackground(Color.RED);
		button01.setBounds(260, 200, 150, 40);

		button02 = new JButton("计时模式");
		button02.setFont(new Font("acefont-family", Font.BOLD, 25));
		button02.setBackground(Color.GREEN);
		button02.setBounds(260, 250, 150, 40);
		 
		button03 = new JButton("设置");
     	button03.setFont(new Font("acefont-family", Font.BOLD, 25));
     	button03.setBackground(Color.BLUE);
	    button03.setBounds(260, 350, 150, 40);
		
	    button05 = new JButton("排行榜");
	    button05.setFont(new Font("acefont-family", Font.BOLD, 25));
	    button05.setBackground(Color.BLUE);
	    button05.setBounds(260, 300, 150, 40);
	    
	     add(button05);
		 add(button01);
		 add(button02);
		 add(button03);
	}
	
	/**
	 * 设置背景
	 */
	private void showBackground() {
		// TODO Auto-generated method stub
		//背景图片
	 	ImageIcon background = new ImageIcon(getClass().getResource("/images/background.jpg"));
	  	//设置背景标签
        back = new JLabel(background);
        //设置背景图片位置大小
        back.setBounds(0, 0, getWidth(), getHeight());
        //面板透明
        JPanel j = (JPanel)getContentPane();
        j.setOpaque(false);
        //设置背景
        getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
	}

}
