package com.esprit.socket.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.swing.*;

@Startup
public class StartServer {
	@PostConstruct
	public static void main(String [] args) throws UnknownHostException{
			String[] arguments = new String[] {};
			new MultiThreadChatServerSync().main(arguments);
		
	}

}