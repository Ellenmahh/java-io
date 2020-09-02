/**
 * 
 */
package br.com.alura.java.io.teste;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * @author Ellen Mayara
 *
 */
public class TesteLeitura3 {

	public static void main(String[] args)  {

		String host = "sftp.sf.prefeitura.sp.gov.br";
		String username = "sftp-usr-24913412000180_SP156";
		String password = "rQwxnmWzuF";
		int port = 2022;
		Session session = null;
		
		try {
			JSch jsch = new JSch();
			
			jsch.addIdentity("keyPublic.txt");
			System.out.println("chave adicionada");
			
			session = jsch.getSession(username, host, port);
			System.out.println("session adicionada");
			session.setPassword(password);
			
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			
			System.out.println("Conectamos!");
			Channel channel=session.openChannel("shell");
			channel.setInputStream(System.in);
			channel.setOutputStream(System.out);
			channel.connect(3*1000);
		} catch (JSchException e) {
			System.out.println("Fail :(");
			e.printStackTrace();
		}
		//FTPClient client = new FTPClient();

//		String host = "sftp.sf.prefeitura.sp.gov.br";
//		String username = "sftp-usr-24913412000180_SP156";
//		String password = "rQwxnmWzuF";
//		
//		try {
//			client.connect(host);
//
//			boolean login = client.login(username, password);
//		
//			if(login) {
//				System.out.println("Conectamos!");
//			}else {
//				System.out.println("Fail :(");
//			}
//		
//		}catch(IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				client.disconnect();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		try (BufferedInputStream in = new BufferedInputStream(
//				new URL("https://h-pmsp.metasix.solutions/static/2020/08/UXJKUW1DRHZIYTY0ckpuUi05dmhJdzo6cHJvdG9jb2xvcyBzb2xpY2l0YcOnw6NvIHNlbmhhd2ViLnBkZg.pdf").openStream());
//				  FileOutputStream fileOutputStream = new FileOutputStream("testizinho.pdf")) {
//				    byte dataBuffer[] = new byte[1024];
//				    int bytesRead;
//				    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
//				        fileOutputStream.write(dataBuffer, 0, bytesRead);
//				    }
//				} catch (IOException e) {
//				    // handle exception
//				}
	}

}
