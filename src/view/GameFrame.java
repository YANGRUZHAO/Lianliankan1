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
 * ��Ϸ��ʼ����
 * @author YLove
 * @version V1.0
 */
public class GameFrame extends JFrame {
	
	private JLabel back;
	private GameFrame g;
	private JButton cancel, restart;//���ذ�ť
	private int LEVEL;//����
	private int GameSize;//���ִ�С��������
	private JProgressBar jpb;//ʱ�������
	private Timer timer; //��ʱ��
    private String account;
    long startTime;
    /**
     * ����Ĺ��췽�������й���GameFrame
     * @param GameSize ���ִ�С
     * @param t �ڼ���
     * @param account  �˺�ֵ
     */
	public GameFrame(int GameSize,int t,String account) {
	   
		super(t==-1?"��ʱģʽ":"��"+t+"��");
	    startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��  
		System.out.println("t�ڼ���"+t);
		this.account = account;
		//����javaͼ��
		setIconImage(Toolkit.getDefaultToolkit ().getImage(getClass().getResource("/images/icon.png")));
		LEVEL = t;
		this.GameSize = GameSize+2;
		setSize(700, 600);//���ô����С
		ImageIcon background = new ImageIcon(getClass().getResource("/images/background.png"));
	  	 //���ñ�����ǩ
		back = new JLabel(background);
        //���ñ���ͼƬλ�ô�С
		back.setBounds(0, 0, getWidth(), getHeight());
        //���͸��
		JPanel j = (JPanel)getContentPane();
		j.setOpaque(false);
        //���ñ���
		getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		setVisible(true);
		
		showMenu();
		if(t == -1)
			showTime();
		//�����Ϸ���
		GamePanel jpanel = new GamePanel();
		add(jpanel);
		
		g = this;
		
	}
	
	/**
	 * ��Ӷ�ʱ����
	 */
	private void showTime() {
		jpb = new JProgressBar();
		jpb.setOrientation(JProgressBar.HORIZONTAL);
		jpb.setMinimum(0);//���ý�������Сֵ
		jpb.setMaximum(100);//���ý��������ֵ
		jpb.setValue(0);//���ý�������ǰֵ
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
					new ShowTimerOver(g,"����ʧ��",account,-1);
					timer.cancel();
				}
			}
		}, 0, 900);
		
	}
	
	/**
	 *  ��ʾ�˵�ҳ��
	 */
	private void showMenu() {
		//LEVEL==-1?"�������˵�":"����ѡ��"
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
				////�Ķ�2
				
				StartMain.e1 = new FirstFrame(0,account);
				//�����رմ��尴ť
			    StartMain.e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//���ÿ���
			    StartMain.e1.setVisible(true); 
				//���ò�������
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
				//�����رմ��尴ť
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLayout(null);//������ֹ�����
				
				//���ò�������
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
				if(timer != null)
					timer.cancel();
			}
		});
	}
	/**
	 * ����Ϊ��Ϸ���н��棬�����������ز���
	 * @author YLove
	 * @version V1.0
	 */
	class GamePanel extends JPanel implements MouseListener {
		
		private int W = 50;                  //���﷽��ͼ���Ŀ��
	    
	    private Icon icon[];         //ˮ��ͼƬ����
	    private Icon icon_line[];     //����ͼƬ����
	    @SuppressWarnings("rawtypes")
		private ArrayList images_t;        //ˮ��ͼƬ���ɵ�ͼ
	    @SuppressWarnings("rawtypes")
		private ArrayList label_arr;     //label����
	    private int[] path_line;		//����·����ӦͼƬ����
	    
	    private int index=-1;			//��¼�б߿��label
	    @SuppressWarnings("unused")
		private Point p_index;			//��¼�б߿��label
	    private int k;                  //��¼�ڶ������з���
	    
	    private int sum;               //��¼ʣ�µķ���
	    @SuppressWarnings("rawtypes")
		private ArrayList path;      //��¼����·��
	    
	    private int can;            //�Ƿ�������־λ
	    /**
	     * ����Ĺ��췽�������г�ʼ�����͵�ͼ
	     */
		public GamePanel() {
			// TODO Auto-generated constructor stub
			setLayout(new GridLayout(GameSize, GameSize));//���񲼾�
			setBounds((700-GameSize*W)/2,(600-GameSize*W)/2,GameSize*W,GameSize*W);
			setOpaque(false);
			System.out.println("��ʼ��ʼ����ͼ����ʾ��Ϸ���");
			initMap();//��ʼ����ͼ
			showGame();//��ʾ��Ϸ���
		}
		
		/**
		 * ��ʾ��Ϸ����ͼƬ����
		 */
		private void showGame() {
			// TODO Auto-generated method stub
			label_arr = new ArrayList();
			
			//��ʾ����ͼƬ
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
		 * ��ʼ����ͼ���
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
		 * �������������
		 */
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * ��갴�¼�������
		 */
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			JLabel j = (JLabel)e.getComponent();//��ȡ�����label
			Point p = j.getLocation(); //��ȡλ��
			if(j.getIcon()!=null)
				if(index != -1) {
					((JLabel)label_arr.get(index)).setBorder(null);//ȡ����һ���߿�
				//	public boolean is_OK(Point p,int GameSize,int index,int[] path_line,ArrayList label_arr,ArrayList path) {
					if(!isOK.is_OK(p,GameSize,index,path_line,label_arr,path)) {
						j.setBorder(BorderFactory.createLineBorder(Color.RED));  //������ֱ߿�
						//��¼λ��
						p_index = p;
						index = p.x/W+p.y/W*GameSize;
					} else {
						//·��
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
					j.setBorder(BorderFactory.createLineBorder(Color.RED));  //������ֱ߿�
					//��¼λ��
					p_index = p;
					index = p.x/W+p.y/W*GameSize;
				}
		}

		/**
		 * ����ɿ���������
		 */
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(can == 1) {
				JLabel j = (JLabel)e.getComponent();//��ȡ�����label
				//��ǰ��ͣ1��
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//���·��
				for(int i = 0;i < path.size();i++) {
					((JLabel)label_arr.get((int)path.get(i))).setIcon(null);
				}
				path.clear();//·�����鸴λ
				//����
				//((JLabel)label_arr.get(index)).setIcon(null);
				//j.setIcon(null);
				
				//��������
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
						long endTime=System.currentTimeMillis(); //��ȡ����ʱ��  
						System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");   
						timer.cancel();
						long time = endTime - startTime;
						String str = String.valueOf(time);
					    String A = "��ϲ���أ�����ʱ��Ϊ";
						String Str = A+str+"ms!";
						new ShowTimerOver(g,Str,account,(endTime-startTime));
					}
				}
			}
		}

		/**
		 * ��갴�¼�������
		 */
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * ����˳���������
		 */
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
