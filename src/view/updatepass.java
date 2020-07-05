
package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.impl.DataBaseDaolmpl;
import dao.impl.PlayerDaolmpl;
import test.Player;
import until.ScannerUtil;
/**
 * �û�ע�ᴰ��ģ��
 * 
 * @author ������
 * @version V1.0
 */
public class updatepass extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * ����Ĺ��췽����ʵ��ע�Ṧ��
	 */
	public updatepass() {
		setTitle("�޸�����");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlayerRegister.class.getResource("/images/apple.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("�˺�");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(55, 31, 72, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(55, 79, 72, 18);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("������");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(55, 128, 72, 18);
		contentPane.add(label_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(141, 76, 168, 24);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(141, 125, 168, 24);
		contentPane.add(passwordField_1);

		textField = new JTextField();
		textField.setBounds(141, 28, 168, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("ȷ���޸�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  // �ж������Ƿ�һ��
					Player p = new Player(textField.getText(), String.valueOf(passwordField_1.getPassword()));

					// ע������˺�
					if (new PlayerDaolmpl().update(p)) {
						// ����˺�ע��ɹ�����ʼ���û��Ļ���
						JOptionPane.showMessageDialog(contentPane, "�޸ĳɹ���");
					} else {
						JOptionPane.showMessageDialog(contentPane, "��������Ԥ�ϵ�ԭ�򣬵����޸�ʧ�ܣ�");
					}	
				} 
			
		});
		btnNewButton.setBounds(250, 174, 113, 27);
		contentPane.add(btnNewButton);
		

		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���������ı��������
				textField.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
			}
		});
		btnNewButton_1.setBounds(154, 174, 82, 27);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���ص�¼���壬 ע�ᴰ���ͷ�
				new PlayerLogin().setVisible(true);
				(updatepass.this).dispose();
			}
		});
		btnNewButton_2.setBounds(32, 174, 113, 27);
		contentPane.add(btnNewButton_2);
	}
}
