package com.ly.ssh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class SSHCommandTest {
	private static final String host = "192.168.199.120";
	private static final String usrName = "root";
	private static final String password = "liyang";
	private Connection conn;

	private static Logger logger = Logger.getAnonymousLogger();

	@Before
	public void doConnect() throws IOException {
		conn = new Connection(host);
		conn.connect();
		boolean isAuthenticated = conn.authenticateWithPassword(usrName, password);
		if (isAuthenticated == false)
			throw new IOException(host + "Authentication failed.");
		logger.info(host + " : connect success");
	}

	@Test
	public void commandTest() {
		try{
			Session session = conn.openSession();
			String exportJAVAHOME="export JAVA_HOME=/usr/lib/jvm/jdk1.7;echo $PATH;sh /home/liyang/tomcat7/bin/startup.sh";
			session.execCommand(exportJAVAHOME);
			stoutInfo(session, exportJAVAHOME);
//			Session session = conn.openSession();
//			String testPath="echo $PATH";
//			session.execCommand(testPath);
//			stoutInfo(session, testPath);
		//	session = conn.openSession();
//			String command = "sh /home/liyang/tomcat7/bin/startup.sh";
//			session.execCommand(command);
//			stoutInfo(session, command);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void stoutInfo(Session session, String cmd) throws Exception {
		InputStream stdout = new StreamGobbler(session.getStdout());
		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			String log = host + " : " + " command : " + cmd + "; feedback : " + line;
			System.out.println(log);
		}
		String log = host + " : " + " command : " + cmd + "; ExitCode : " + session.getExitStatus();
		System.out.println(log);
		br.close();
		session.close();

	}

	@After
	public void doClose() {
		if (conn != null) {
			logger.info("关闭connection...");
			conn.close();
		}
	}

}
