package com.example.demo.web.user;

import java.net.*;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class JPortScanner1 {

	public JPortScanner1(String IP, int port) {

	}

	public static void main(String[] args) throws IOException,
			InterruptedException {

		String ipHead;
		int lastPoint;
		String IP = InetAddress.getLocalHost().getHostAddress();

		lastPoint = IP.lastIndexOf('.');

		ipHead = IP.substring(0, ++lastPoint);

		for (int tail = 0; tail < 255; tail++) {
			ExecutorService executor = Executors.newSingleThreadExecutor();
			executor.invokeAll(Arrays.asList(new Task(ipHead, tail, 22)),
					200, TimeUnit.MILLISECONDS);
			executor.shutdown();
		}

	}
}

class Task implements Callable<String> {
	String ipHead;
	int ipTail;
	int port;

	public Task(String ipHead, int ipTail, int port) {
		this.ipHead = ipHead;
		this.ipTail = ipTail;
		this.port = port;
	}

	public String call() throws Exception {
		Socket connect = new Socket();
		connect.setSoTimeout(100);
			try {
			
				connect = new Socket(this.ipHead + ipTail, this.port);
				connect.close();

				System.out.println("Open port:" + this.ipHead + ipTail + " "
						+ this.port);

			} catch (UnknownHostException e) {
				//System.out.println("Unknown Port：" + this.ipHead + ipTail + this.port);
			} catch (IOException e) {
				//System.out.println("Unknown Port：" + this.ipHead + ipTail + this.port);
			} 
		
		//System.out.println("Finished!");
		return null;

	}
}

