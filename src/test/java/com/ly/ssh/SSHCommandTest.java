package com.ly.ssh;

import java.io.IOException;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.ethz.ssh2.Connection;

public class SSHCommandTest {
	private static final String host = "192.168.199.120";
	private static final String usrName = "root";
	private static final String password = "liyang";
	private Connection conn;
	
	private static Logger logger = Logger.getAnonymousLogger();
	
	@Before
	public void doConnect() throws IOException{
		 conn = new Connection(host);
	     conn.connect();
	     boolean isAuthenticated = conn.authenticateWithPassword(usrName, password);
	     if (isAuthenticated == false)
	         throw new IOException(host+ "Authentication failed.");
	     logger.info(host+" : connect success");
	}
	
	@Test
	public void commandTest(){
		
	}
	
	
	@After
	public void doClose(){
		if(conn!= null){
			logger.info("关闭connection...");
			conn.close();
		}
	}
	
}
