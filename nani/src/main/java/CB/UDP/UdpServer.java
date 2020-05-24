package CB.UDP; 

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * <pre>
 * kr.co.swh.lecture.network.udp
 * UdpServer.java
 *
 * ���� :UDP ����
 * </pre>
 * 
 * @since : 2018. 6. 23.
 * @author : tobby48
 * @version : v1.0
 */
public class UdpServer {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		try{
			ds = new DatagramSocket(7777);	// ������ �����Ҽ� �ֵ��� UDP ���� ����
			byte [] date = new byte[66536];		// ���۹��� �����͸� ������ ����Ʈ �迭����

			// UDP ������� ������ ���� packet ��ü����
			DatagramPacket dp = new DatagramPacket(date, date.length);
			System.out.println("������ ���� �غ� �Ϸ�....");
			while(true){
				// ������ ���� �ޱ�
				ds.receive(dp);
				// ������ ������ Ȯ��
				System.out.println(" �۽� IP : " + dp.getAddress());
				// ���� �����͸� UTF-8�� ���ڿ��� ��ȯ
				String msg = new String(dp.getData(),"UTF-8");
				System.out.println("���� �� ����  : " + msg);
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		} finally {
			ds.close();
		}
	}
}