package view;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import test.StartMain;

import java.awt.Font;
import until.PlaySound;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * ����Ϊ��Ϸ�����ý���
 * @author YLove
 * @version V1.0
 */
public class ShowSetting  extends JDialog	 {
	private JLabel sounds, about, pass_level;
	private JButton to_main, to_next, to_new;
	private JCheckBox jcb_1, jcb_2;
	private JTextArea jta;
	private int LEVEL;//����
	/**
	 * ��ʾ��Ϸ����ҳ��Ĺ��ܣ��������������
	 * @param f ����ֵ
	 */
	public  ShowSetting(JFrame f) {
		super(f,true);
		setLayout(null);//���ò��ֹ�����Ϊ��
		//Container c = this.getContentPane();
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);//���öԻ��򲻿���
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("����");
		setBounds(getBounds().x+75, getBounds().y+75, 500, 350);//���öԻ���λ�ô�С
		
		//��Ч��ǩ
		sounds = new JLabel("��Ч:");
		sounds.setFont(new Font("acefont-family", Font.BOLD, 15));
		sounds.setBounds(10, 10, 50, 20);
		add(sounds);
		
		//�������߱�ǩ
		about = new JLabel("��������:");
		about.setFont(new Font("acefont-family", Font.BOLD, 15));
		about.setBounds(10, 75, 100, 20);
		add(about);
		
		//��Чѡ���ѡ��ť
		jcb_1 = new JCheckBox("��������");
		jcb_1.setBounds(20, 40, 80, 20);
		if(PlaySound.b[0])
			jcb_1.setSelected(true);
		add(jcb_1);
		jcb_1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				PlaySound.b[0] = !PlaySound.b[0];
				if(!(PlaySound.b[0]))
				{
					StartMain.p.stop();
				}
				else
					StartMain.p.start();			
				}
		});
		
		jcb_2 = new JCheckBox("������");
		jcb_2.setBounds(120, 40, 80, 20);
		if(PlaySound.b[1])
			jcb_2.setSelected(true);
		add(jcb_2);
		jcb_2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				PlaySound.b[1] = !PlaySound.b[1];
			}
		});
		
		//������������
		jta = new JTextArea();
		jta.setBounds(20, 110, 300, 150);
		jta.setEditable(false);
		jta.setText("  ������\n  18���������5��");
		add(jta);
	}
}

