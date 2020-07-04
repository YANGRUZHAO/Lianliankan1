package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import test.StartMain;
import until.PlaySound;
import until.isOK;

/**
 * 游戏开始界面
 * @author YLove
 * @version V1.0
 */
public class GameFrame extends JFrame {
	
	private JLabel back;
	private GameFrame g;
	private JButton cancel, restart;//返回按钮
	private int LEVEL;//关数
	private int GameSize;//布局大小即行列数
	private JProgressBar jpb;//时间进度条
	private Timer timer; //计时器
    private String account;
    long startTime;
    /**
     * 该类的构造方法，进行构造GameFrame
     * @param GameSize 布局大小
     * @param t 第几关
     * @param account  账号值
     */
	public GameFrame(int GameSize,int t,String account) {
	   
		super(t==-1?"计时模式":"第"+t+"关");
	    startTime=System.currentTimeMillis();   //获取开始时间  
		System.out.println("t第几关"+t);
		this.account = account;
		//设置java图标
		setIconImage(Toolkit.getDefaultToolkit ().getImage(getClass().getResource("/images/icon.png")));
		LEVEL = t;
		this.GameSize = GameSize+2;
		setSize(700, 600);//设置窗体大小
		ImageIcon background = new ImageIcon(getClass().getResource("/images/background.png"));
	  	 //设置背景标签
		back = new JLabel(background);
        //设置背景图片位置大小
		back.setBounds(0, 0, getWidth(), getHeight());
        //面板透明
		JPanel j = (JPanel)getContentPane();
		j.setOpaque(false);
        //设置背景
		getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		setVisible(true);
		
		showMenu();
		if(t == -1)
			showTime();
		//添加游戏面板
		GamePanel jpanel = new GamePanel();
		add(jpanel);
		
		g = this;
		
	}
	
	/**
	 * 添加定时设置
	 */
	private void showTime() {
		jpb = new JProgressBar();
		jpb.setOrientation(JProgressBar.HORIZONTAL);
		jpb.setMinimum(0);//设置进度条最小值
		jpb.setMaximum(100);//设置进度条最大值
		jpb.setValue(0);//设置进度条当前值
		jpb.setBackground(new Color(238,226,29));
		jpb.setBounds(175, 25, 350, 12);
		add(jpb);
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				jpb.setValue(jpb.getValue()+1);
				if(jpb.getValue() > 80)
					jpb.setForeground(Color.RED);
				if(jpb.getValue() == 100) {
					new ShowTimerOver(g,"闯关失败",account,-1);
					timer.cancel();
				}
			}
		}, 0, 900);
		
	}
	
	/**
	 *  显示菜单页面
	 */
	private void showMenu() {
		//LEVEL==-1?"返回主菜单":"返回选关"
		cancel = new JButton();
		cancel.setBounds(10, 10, 60, 40);
		cancel.setIcon(new ImageIcon(getClass().getResource("/images/home.png")));
		add(cancel);
		
		restart = new JButton();
		restart.setBounds(10, 60, 60, 40);
		restart.setIcon(new ImageIcon(getClass().getResource("/images/restart.png")));
		add(restart);
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = g.getLocation();
				g.dispose();
				/*StartMain.main(null);
				StartMain.e1.setLocation(p);*/
				////改动2
				
				StartMain.e1 = new FirstFrame(0,account);
				//监听关闭窗体按钮
			    StartMain.e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//设置可视
			    StartMain.e1.setVisible(true); 
				//设置不可拉伸
			    StartMain.e1.setResizable(false);
			    
			    System.out.println("LEVEL = " + LEVEL);
				if(LEVEL != -1)
					StartMain.e1.toLevel(0,account);
				else
					timer.cancel();
			}
		});
		
		restart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = g.getLocation();
				g.dispose();
				GameFrame gameFrame;
				gameFrame = new GameFrame(GameSize-2,LEVEL,account);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
				if(timer != null)
					timer.cancel();
			}
		});
	}
	/**
	 * 该类为游戏运行界面，并对其进行相关操作
	 * @author YLove
	 * @version V1.0
	 */
	class GamePanel extends JPanel implements MouseListener {
		
		private int W = 50;                  //动物方块图案的宽度
	    
	    private Icon icon[];         //水果图片数组
	    private Icon icon_line[];     //连线图片数组
	    @SuppressWarnings("rawtypes")
		private ArrayList images_t;        //水果图片过渡地图
	    @SuppressWarnings("rawtypes")
		private ArrayList label_arr;     //label数组
	    private int[] path_line;		//消除路径对应图片数组
	    
	    private int index=-1;			//记录有边框的label
	    @SuppressWarnings("unused")
		private Point p_index;			//记录有边框的label
	    private int k;                  //记录第二个点中方块
	    
	    private int sum;               //记录剩下的方块
	    @SuppressWarnings("rawtypes")
		private ArrayList path;      //记录消除路径
	    
	    private int can;            //是否消除标志位
	    /**
	     * 该类的构造方法，进行初始化面板和地图
	     */
		public GamePanel() {
			// TODO Auto-generated constructor stub
			setLayout(new GridLayout(GameSize, GameSize));//网格布局
			setBounds((700-GameSize*W)/2,(600-GameSize*W)/2,GameSize*W,GameSize*W);
			setOpaque(false);
			System.out.println("开始初始化地图和显示游戏面板");
			initMap();//初始化地图
			showGame();//显示游戏面板
		}
		
		/**
		 * 显示游戏动物图片界面
		 */
		private void showGame() {
			// TODO Auto-generated method stub
			label_arr = new ArrayList();
			
			//显示动物图片
			for(int i=0;i<GameSize*GameSize;i++) {
				if(i%GameSize==0 || i%GameSize==GameSize-1 || i/GameSize==0 || i/GameSize==GameSize-1) {
					JLabel j = new JLabel();
					j.setIcon(null);
					label_arr.add(j);
					add(j);
					continue;
				}
				int nIndex = new Random().nextInt(images_t.size());
				
				JLabel j = new JLabel(icon[(int) images_t.get(nIndex)]);
				label_arr.add(j);
				j.addMouseListener(this);
				add(j);
				
				images_t.remove(nIndex);
			}
		}

		/**
		 * 初始化地图面板
		 */
		private void initMap() {
			// TODO Auto-generated method stub
			images_t = new ArrayList();
			path = new ArrayList();
			icon = new Icon[10];
			icon_line = new Icon[6];
			path_line = new int[GameSize*GameSize];
			
			for(int i=0;i<icon.length;i++) {
				icon[i] = new ImageIcon(getClass().getResource("/images/"+"fruit_"+(i+1)+".jpg"));
			}
			for(int i=0;i<icon_line.length;i++) {
				icon_line[i] = new ImageIcon(getClass().getResource("/images/"+"line_"+(i+1)+".png"));
			}
			for(int i=0;images_t.size()<(GameSize-2)*(GameSize-2);i++) {
				images_t.add(i%10);
				if(images_t.size()==(GameSize-2)*(GameSize-2)) {
					continue;
				}
				images_t.add(i%10);
			}
			sum = images_t.size();
			
		}
		

		/**
		 * 鼠标点击监听方法
		 */
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * 鼠标按下监听方法
		 */
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			JLabel j = (JLabel)e.getComponent();//获取点击的label
			Point p = j.getLocation(); //获取位置
			if(j.getIcon()!=null)
				if(index != -1) {
					((JLabel)label_arr.get(index)).setBorder(null);//取消上一个边框
				//	public boolean is_OK(Point p,int GameSize,int index,int[] path_line,ArrayList label_arr,ArrayList path) {
					if(!isOK.is_OK(p,GameSize,index,path_line,label_arr,path)) {
						j.setBorder(BorderFactory.createLineBorder(Color.RED));  //点击出现边框
						//记录位置
						p_index = p;
						index = p.x/W+p.y/W*GameSize;
					} else {
						//路径
						k = p.x/W+p.y/W*GameSize;
						for(int i = 0;i < path.size();i++) {
							System.out.print(path.get(i)+" a ");
							if((int)path.get(i) == index || (int)path.get(i) == k)
								continue;
							((JLabel)label_arr.get((int)path.get(i))).setIcon(icon_line[path_line[(int) path.get(i)]]);
						}
						can = 1;
					}
				} else {
					j.setBorder(BorderFactory.createLineBorder(Color.RED));  //点击出现边框
					//记录位置
					p_index = p;
					index = p.x/W+p.y/W*GameSize;
				}
		}

		/**
		 * 鼠标松开监听方法
		 */
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(can == 1) {
				JLabel j = (JLabel)e.getComponent();//获取点击的label
				//当前暂停1秒
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//清除路径
				for(int i = 0;i < path.size();i++) {
					((JLabel)label_arr.get((int)path.get(i))).setIcon(null);
				}
				path.clear();//路径数组复位
				//消除
				//((JLabel)label_arr.get(index)).setIcon(null);
				//j.setIcon(null);
				
				//消除音乐
				if(PlaySound.b[1]) {
					PlaySound ps = new PlaySound();
					ps.open("sounds/ClearSound.wav");
					ps.play();
					ps.start();
				}
				can = 0;
				
				sum -= 2;
				
				if(sum == 0) {
					if(LEVEL != -1) {
						new ShowOver(g,account,LEVEL);
						
					} else {
						long endTime=System.currentTimeMillis(); //获取结束时间  
						System.out.println("程序运行时间： "+(endTime-startTime)+"ms");   
						timer.cancel();
						long time = endTime - startTime;
						String str = String.valueOf(time);
					    String A = "恭喜过关，所花时间为";
						String Str = A+str+"ms!";
						new ShowTimerOver(g,Str,account,(endTime-startTime));
					}
				}
			}
		}

		/**
		 * 鼠标按下监听方法
		 */
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * 鼠标退出监听方法
		 */
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
