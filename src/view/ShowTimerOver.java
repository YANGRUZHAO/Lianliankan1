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
 * ����Ϊ��Ϸʱ���������߼�ʱ��Ϸ���صĽ���
 * @author YLove
 * @version V1.0
 */
public class ShowTimerOver {
	private JLabel sounds, about, pass_level;
	private JButton to_main, to_next, to_new;
	private JCheckBox jcb_1, jcb_2;
	private JTextArea jta;
	private int LEVEL;//����
	private String account;
	/**
	 * ����Ĺ��췽������ʾΪ��Ϸʱ���������߼�ʱ��Ϸ���صĽ���
	 * @param f ����ֵ
	 * @param s ��ʾ���
	 * @param account1  ��¼�˺�ֵ
	 * @param time  ʱ��
	 */
	public ShowTimerOver(final JFrame f, String s,String account1,long time) {
		System.out.println("�����Ǽ�ʱģʽ");
		f.setTitle("��ʱģʽ");
		f.setBounds(f.getBounds().x+125, f.getBounds().y+150, 700, 500);//���öԻ���λ�ô�С
		//��ϲ���ر�ǩ
		this.account = account1;
		pass_level = new JLabel(s);
		pass_level.setFont(new Font("acefont-family", Font.BOLD, 20));
		pass_level.setBounds(190, 50, 500, 40);
		f.add(pass_level);
		
		//�������˵���ť
		to_main = new JButton("�������˵�");
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
				////�Ķ�1
				StartMain.e1 = new FirstFrame(0,account);
				//�����رմ��尴ť
			    StartMain.e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//���ÿ���
			    StartMain.e1.setVisible(true); 
				//���ò�������
			    StartMain.e1.setResizable(false);
			    
			    
			}
		});
		
		//��һ�ذ�ť
		to_new = new JButton("���¿�ʼ");
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
				//�����رմ��尴ť
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLayout(null);//������ֹ�����
				
				//���ò�������
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
	}
}
