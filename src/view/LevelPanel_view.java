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
import javax.swing.JTextField;
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
	
	private JTextField textField;
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
		setBounds(100, 100, 700,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
 
		JLabel label = new JLabel("��ʷ���������а�");
		label.setForeground(Color.RED);
		label.setFont(new Font("����", Font.PLAIN, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);
		JPanel panel = new JPanel(); //����
		contentPane.add(panel, BorderLayout.SOUTH);
		JButton button = new JButton("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gotoChoice();
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(button, BorderLayout.SOUTH);

		// ׼�����ı��������
		title = new Object[] { "���", "����ٶ�" };
		
		
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
		
		JButton btnNewButton = new JButton("\u5220\u9664\u6211\u7684\u8D26\u53F7\u6392\u884C\u699C\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				until.Leaderboard.deleteAccountRank(account);

				new LevelPanel_view(account).setVisible(true);
				(LevelPanel_view.this).dispose();

			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(500, 500, 138, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton1 = new JButton("�޸ĸ��˺ŵ÷֣�");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ɾ����ҵ�����ͨ�ص÷ּ�¼
				String score = textField.getText();
				until.Leaderboard.updateAccountScore(account,Integer.valueOf(score));

				new LevelPanel_view(account).setVisible(true);
				(LevelPanel_view.this).dispose();
			}
		});
		btnNewButton1.setFont(new Font("����", Font.PLAIN, 20));
		panel.add(btnNewButton1);
		
		
	}

	/**
	 * ���عؿ�ѡ��
	 */
	private void gotoChoice() {
		this.dispose(); // �ͷ���Դ
		new FirstFrame(0,this.currentAccount).setVisible(true);
		
	}
}