package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//import util.HighestScoreUtil;
//import util.JFrameToolUtil;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import until.Leaderboard;
/**
 * �鿴���а�
 * 
 * @author ������
 * @version V1.0
 */
public class LevelPanel_view extends JFrame {

	private JPanel contentPane;

	// ��ǰ����˺�
	private String currentAccount;
	// ������
	private Object title[];
	// �������
	private Object data[][]=new Object[6][2];
	/**
	 * ��ʾ���а��������Ϣ
	 * @param account ��¼�е�����˺�
	 */
	public LevelPanel_view(String account) {
		// ���õ�ǰ����˺�
		this.currentAccount = account;
        
		setResizable(false);
	//	setIconImage(Toolkit.getDefaultToolkit().getImage(HighestScoreJFrame.class.getResource("/images/apple.png")));
		setTitle("��ʷ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
 
		JLabel label = new JLabel("��ʷ���������а�");
		label.setForeground(Color.RED);
		label.setFont(new Font("����", Font.PLAIN, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);

		JButton button = new JButton("\u8FD4  \u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gotoChoice();
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 20));
		contentPane.add(button, BorderLayout.SOUTH);

		// ׼�����ı��������
		title = new Object[] { "���", "����ٶ�" };
		
		
		//String[] str = new String[11];
		List<Map.Entry<String,Integer>> list = Leaderboard.Read_List();
        int i = 0;
        for(Map.Entry<String,Integer> mapping:list){ 
            System.out.println(mapping.getKey()+":"+mapping.getValue()); 
           data[i][0]=mapping.getKey();
           data[i++][1] = mapping.getValue();
            
       }
		
		
        
		// ��ȡ����data����
	//	HighestScoreUtil.getHighestScore(data);
				
		JTable jtable = new JTable(data, title);
		jtable.setFont(new Font("����", Font.BOLD, 20));
		jtable.setRowHeight(30);

		// �������ӵ�������
		contentPane.add(new JScrollPane(jtable), BorderLayout.CENTER);

		// ���ɸ��Ĵ����С
		this.setResizable(false);

		// ���ô������
	//	this.setLocation(JFrameToolUtil.centerLocation(new Point(this.getWidth(), this.getHeight())));
	}

	/**
	 * ���عؿ�ѡ��
	 */
	private void gotoChoice() {
		this.dispose(); // �ͷ���Դ
		new FirstFrame(0,this.currentAccount).setVisible(true);
		
	}
}