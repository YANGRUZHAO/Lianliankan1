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
 * ����������
 * @author ������
 * @version V1.0
 */
@SuppressWarnings("serial")
public class FirstFrame extends JFrame {
	
	private JLabel back;//����
//	private JLabel label01, label02, label03, label04, label05, label06;
	private JButton button01, button02, button03,button05;
	private FirstFrame f;
	private String account;
	
	JPanel contentPane = new JPanel();
	/**
	 * ����Ĺ��췽��
	 * @param i  ���ֵ
	 * @param account  �˺�ֵ
	 */
	public FirstFrame(int i,String account) {
		super("����������");
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//����javaͼ��
		System.out.println("����FirstFrame��");
		this.account = account;
		setIconImage(Toolkit.getDefaultToolkit ().getImage(getClass().getResource("/images/icon.png")));
		setSize(650, 500);//���ô����С
		setLayout(null);//������ֹ�����
		showBackground();//���ñ���//���ñ���
		
		showButton();//��ʾ����
		adapter();//����
		f = this;
	}
	
	/**
	 * ����ҳ�水ť
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
				dispose();// �ͷŵ�ǰ�������Դ 
				System.out.println("�����ʱģʽ");
				//Point p = StartMain.e1.getLocation();
				
				//StartMain.e1.dispose();
				System.out.println("��ʼ��ʱģʽ��gameFrame");
				GameFrame gameFrame;
				gameFrame = new GameFrame(8,-1,account);
				//�����رմ��尴ť
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLayout(null);//������ֹ�����
				
				//���ò�������
				gameFrame.setResizable(false);
				//gameFrame.setLocation(p);
			}
		});
		
		button03.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new Dialog(f,0,0,null);
				//dispose();// �ͷŵ�ǰ�������Դ 
				System.out.println("��������");
				new ShowSetting(f).setVisible(true);;
			}
		});
		
        button05.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new Dialog(f,0,0,null);
				dispose();// �ͷŵ�ǰ�������Դ 
				System.out.println("��������");
				new LevelPanel_view(account).setVisible(true);;
			}
		});
		
	}
	/**
	 * ��ת������ҳ��
	 * @param id  ���ֵ
	 * @param account �˺�����
	 */
	public void toLevel(int id,String account) {
		Point p = this.getLocation();
		//this.dispose();
	//	StartMain.e1.dispose();
		dispose();// �ͷŵ�ǰ�������Դ 
		System.out.println("��ʼLevePanle");
		new newLevel(account).setVisible(true);;
		
	}
	/**
	 * ��ʾ����	
	 */
	private void showButton() {
		// TODO Auto-generated method stub
		
		//���ð�ť
		button01 = new JButton("����ģʽ");
		button01.setFont(new Font("acefont-family", Font.BOLD, 25));
		button01.setBackground(Color.RED);
		button01.setBounds(260, 200, 150, 40);

		button02 = new JButton("��ʱģʽ");
		button02.setFont(new Font("acefont-family", Font.BOLD, 25));
		button02.setBackground(Color.GREEN);
		button02.setBounds(260, 250, 150, 40);
		 
		button03 = new JButton("����");
     	button03.setFont(new Font("acefont-family", Font.BOLD, 25));
     	button03.setBackground(Color.BLUE);
	    button03.setBounds(260, 350, 150, 40);
		
	    button05 = new JButton("���а�");
	    button05.setFont(new Font("acefont-family", Font.BOLD, 25));
	    button05.setBackground(Color.BLUE);
	    button05.setBounds(260, 300, 150, 40);
	    
	     add(button05);
		 add(button01);
		 add(button02);
		 add(button03);
	}
	
	/**
	 * ���ñ���
	 */
	private void showBackground() {
		// TODO Auto-generated method stub
		//����ͼƬ
	 	ImageIcon background = new ImageIcon(getClass().getResource("/images/background.jpg"));
	  	//���ñ�����ǩ
        back = new JLabel(background);
        //���ñ���ͼƬλ�ô�С
        back.setBounds(0, 0, getWidth(), getHeight());
        //���͸��
        JPanel j = (JPanel)getContentPane();
        j.setOpaque(false);
        //���ñ���
        getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
	}

}
