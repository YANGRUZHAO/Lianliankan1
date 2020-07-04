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
 * 该类为游戏的设置界面
 * @author YLove
 * @version V1.0
 */
public class ShowSetting  extends JDialog	 {
	private JLabel sounds, about, pass_level;
	private JButton to_main, to_next, to_new;
	private JCheckBox jcb_1, jcb_2;
	private JTextArea jta;
	private int LEVEL;//关数
	/**
	 * 显示游戏设置页面的功能，并对其进行设置
	 * @param f 窗体值
	 */
	public  ShowSetting(JFrame f) {
		super(f,true);
		setLayout(null);//设置布局管理器为空
		//Container c = this.getContentPane();
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);//设置对话框不可拉
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("设置");
		setBounds(getBounds().x+75, getBounds().y+75, 500, 350);//设置对话框位置大小
		
		//音效标签
		sounds = new JLabel("音效:");
		sounds.setFont(new Font("acefont-family", Font.BOLD, 15));
		sounds.setBounds(10, 10, 50, 20);
		add(sounds);
		
		//关于作者标签
		about = new JLabel("关于作者:");
		about.setFont(new Font("acefont-family", Font.BOLD, 15));
		about.setBounds(10, 75, 100, 20);
		add(about);
		
		//音效选项多选按钮
		jcb_1 = new JCheckBox("背景声音");
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
		
		jcb_2 = new JCheckBox("消除音");
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
		
		//关于作者内容
		jta = new JTextArea();
		jta.setBounds(20, 110, 300, 150);
		jta.setEditable(false);
		jta.setText("  阳汝昭\n  18级软件工程5班");
		add(jta);
	}
}

