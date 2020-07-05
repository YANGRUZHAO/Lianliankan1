package view;

import java.awt.EventQueue;
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
import dao.impl.PlayerDaolmpl;
import test.StartMain;
import until.PlaySound;

/**
 * 用户登录窗体模块
 * 
 * @author 阳汝昭
 * @version V1.0
 */
public class PlayerLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * 该类的构造方法，实现登录功能
	 */
	public PlayerLogin() {
		setTitle("\u6E38\u620F\u767B\u5F55");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlayerLogin.class.getResource("/images/apple.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u8D26\u53F7");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(24, 42, 72, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(24, 90, 72, 18);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBounds(125, 39, 138, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(125, 87, 138, 24);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 获取输入的账号密码
				String account = textField.getText();
				String password = String.valueOf(passwordField.getPassword());

				PlayerDaolmpl pdi = new PlayerDaolmpl();

				if (pdi.login(account, password)) {
					JOptionPane.showMessageDialog(contentPane, "账号密码正确，登录成功！");
					// 进入开始游戏窗体
					if(StartMain.p == null) {
						//声音设置
						StartMain.p = new PlaySound();
						StartMain.p.open("sounds/background.wav");	
						StartMain.p.play();
						StartMain.p.loop();
						StartMain.p.start();
						
					}
					new FirstFrame(0,account).setVisible(true);
					(PlayerLogin.this).dispose();

				} else {
					JOptionPane.showMessageDialog(contentPane, "账号或密码错误，请重新输入！");
				}
			}
		});
		btnNewButton.setBounds(20, 130, 80, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 跳转注册界面动作
				new PlayerRegister().setVisible(true);
				(PlayerLogin.this).dispose();
			}
		});
		btnNewButton_1.setBounds(120, 130, 80, 27);
		
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_2.setBounds(220, 130, 80, 27);
		contentPane.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("删除账号");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Delete_user().setVisible(true);
				(PlayerLogin.this).dispose();
			}
		});
		btnNewButton_3.setBounds(220, 160, 80, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("修改密码");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 跳转注册界面动作
				new updatepass().setVisible(true);
				(PlayerLogin.this).dispose();
			}
		});
		btnNewButton_5.setBounds(120, 160, 80, 27);
		
		contentPane.add(btnNewButton_5);
	}
}
