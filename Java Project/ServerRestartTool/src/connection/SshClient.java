package connection;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;


public class SshClient {
	
	private JSch shell;
	private Session session;
	private ChannelExec channel;

	
	/**
	 * 
	 * @param user
	 * @param passwd
	 * @param host
	 * @param port
	 * @throws JSchException 
	 */
	public void connect(String user, String passwd, String host, int port) throws JSchException{
		shell = new JSch();
		session = shell.getSession(user, host, port);
		session.setPassword(passwd);
	    session.setConfig("StrictHostKeyChecking", "no");
	    session.connect();
	    
	    channel = (ChannelExec) session.openChannel("exec");
	
	}
	
	/**
	 * 
	 * @param cmd
	 * @return
	 * @throws JSchException 
	 * @throws IOException 
	 */
	public String sendCommand(String cmd) throws JSchException, IOException{
	 
		channel.setCommand(cmd);
		   channel.connect();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
		StringBuilder responseBuilder = new StringBuilder();
		
		int i=0;
		String line="";
		while ((line=reader.readLine())!=null) {
			responseBuilder.append(line).append("\n");
		i++;
		}
		reader.close();
		return responseBuilder.toString();
	}
	
	public void executeCommand(String cmd, String login, String password, String host) throws JSchException, IOException{
	
		JTextArea textAreaResponse = new JTextArea();
		JScrollPane scrollPaneResponse = new JScrollPane(textAreaResponse);
		String response="";
		String ScriptName="";
		int len=0;
		len=cmd.lastIndexOf(" ");
		ScriptName=cmd.substring(len, cmd.length());
		
		connect(login, password, host, 22);
		response = sendCommand(cmd);
		if (response.contains("No available router to destination"))
		{
			JOptionPane.showMessageDialog(null,"Server already stopped.\nPlease start the server again.",ScriptName +" Output",1);	
		}
		else
		{
			textAreaResponse.setText(response);
			textAreaResponse.setLineWrap(true);
			textAreaResponse.setWrapStyleWord(true);
			textAreaResponse.setEditable(false);
			scrollPaneResponse.setPreferredSize(new Dimension(650,450));
			JOptionPane.showMessageDialog(null,scrollPaneResponse,ScriptName +" Output",1);	
		}
		
		disconnect();
		
	}
	
	public boolean isConnected() {
		return (channel != null && channel.isConnected());
	}

	public void disconnect() {
		if (isConnected()) {
		channel.disconnect();
		session.disconnect();
		}
	}
}