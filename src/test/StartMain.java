package test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import dao.impl.PlayerDaolmpl;
import until.PlaySound;
import view.FirstFrame;
import view.PlayerLogin;

/**
 * main����
 * @author ������
 * @version V1.0
 */
public class StartMain {
	
	public static FirstFrame e1;
	public static PlaySound p;//�������� 
	/**
	 * main����
	 * @param agrs ��˵��
	 */
	public static void main(String agrs[]) {	 
		//LoginUser login=new LoginUser();
		
        new PlayerLogin().setVisible(true);
        System.out.println("dasd   dfsd");
        //p.stop();
		//login.setVisible(true); 
	
   }
}
