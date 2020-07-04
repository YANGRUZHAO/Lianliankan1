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
 * ����Ϊ��Ϸ������Ĺ�ϲ���ؽ���
 * @author YLove
 * @version V1.0
 */
public class ShowOver {
	private JLabel sounds, about, pass_level;
	private JButton to_main, to_next, to_new;
	private JCheckBox jcb_1, jcb_2;
	private JTextArea jta;
	private int LEVEL;//����
	private String account;
    /**
     * ����Ϊ��Ϸ������Ĺ�ϲ���ؽ���
     * @param f ����ֵ
     * @param account1  ��ʾ���
     * @param t �ڼ���
     */
	public ShowOver(final JFrame f,String account1,int t) {
		f.setTitle("����");
		this.LEVEL = t;
		f.setBounds(f.getBounds().x+125, f.getBounds().y+150, 400, 200);//���öԻ���λ�ô�С
		this.account = account1;
		//��ϲ���ر�ǩ
		pass_level = new JLabel("��ϲ����");
		pass_level.setFont(new Font("acefont-family", Font.BOLD, 40));
		pass_level.setBounds(110, 30, 200, 40);
		f.add(pass_level);
		
		//�������˵���ť
		to_main = new JButton("�������˵�");
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
				
				///�Ķ�3
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
		to_next = new JButton("��һ��");
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
