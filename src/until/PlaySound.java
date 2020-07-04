package until;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * ����������������
 * @author ������
 * @version V1.0
 *
 */

public class PlaySound {

	private File file;//��Ƶ�ļ�
	private AudioInputStream stream;//��Ƶ������
	private AudioFormat format;//��Ƶ��ʽ
	private DataLine.Info info;//��Ƶ����Ϣ
	private Clip clip;//��Ƶ��
	public static boolean[] b = new boolean[]{true, true, true, true};//������������
	
	/**
	 * �������ļ�����
	 * @param s �ļ�·��
	 */
	public void open(String s) {
		file = new File(s);//��Ƶ�ļ�����
		try {
			stream = AudioSystem.getAudioInputStream(file);//��Ƶ����������
			format = stream.getFormat();//��Ƶ��ʽ����
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����������Ƶ����Ƶ����
	 */
	public void play() {
		info = new DataLine.Info(Clip.class, format);//��Ƶ����Ϣ����
		try {
			clip = (Clip) AudioSystem.getLine(info);//��Ƶ�ж���
			clip.open(stream);//����Ƶ���ݶ�����Ƶ��
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ֹͣ����
	 */
	public void stop() {
		clip.stop();//��ͣ��Ƶ����
	}
	
	/**
	 * ��ʼ����
	 */
	public void start() {
		clip.start();//������Ƶ��
	}
	
	/**
	 * �طű�����������
	 */
	public void loop() {
		clip.loop(20);//�ط�
	}
}
